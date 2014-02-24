/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock.dndimpl;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceAdapter;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.gui.sectionlayout.Helper;
import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.DockContainer;
import com.topcoder.gui.sectionlayout.dock.DockEvent;
import com.topcoder.gui.sectionlayout.dock.DockListener;
import com.topcoder.gui.sectionlayout.dock.Dockable;
import com.topcoder.gui.sectionlayout.dock.DragInitListener;
import com.topcoder.gui.sectionlayout.dock.FloatContainer;

/**
 * <p>
 * The default implementation of the <code>Dock</code> interface by using DnD(java.awt.dnd) framework in java.
 * When the dragEnable property is set to true,
 * it will new a <code>DockHandler</code> which creating the <code>DragSource</code> of this dock,
 * listening to the dragging on this dock and registering an <code>DragInitListener</code>
 * to know whether the dock is started to drag.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * The implementation is not required to be thread-safe.
 * But Note the management of listeners
 * and the <code>setDockEnable</code>/<code>getDockEnable</code> are thread-safe,
 * as the relative methods are synchronized.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public class DefaultDock implements Dock {

    /**
     * <p>
     * The DataFlavor instance used in this component to transfer Dock instance in the same JVM.
     * Initialized when it is first used and never changed later. Can't be null.
     * </p>
     */
    public static DataFlavor DOCK_FLAVOR;

    /**
     * <p>
     * The DockListener instances that listen the docked/undocked event on this dock.
     * It can't be null, initialized to empty list. never changed. can be empty, the element can't be null.
     * It can be accessed in listeners management methods.
     * </p>
     */
    private final List<DockListener> listeners = new ArrayList<DockListener>();

    /**
     * <p>
     * The inner Dockable instance in this dock, initialized in the constructor, never changed later. can't be null.
     * Can be accessed by the getter.
     * </p>
     */
    private final Dockable dockable;

    /**
     * <p>
     * The float container of this dock, initialized to null, it is set when this dock is floating. can be null.
     * </p>
     */
    private FloatContainer floatContainer = null;

    /**
     * <p>
     * The relative location of the dockable component when the drag started, can be null,
     * accessed/set in the getter/setter.
     * </p>
     */
    private Point dragStartLocation;

    /**
     * <p>
     * The gesture cursor when dragging. Initialized to null.
     * Nullable, accessed/set in the getter/setter.
     * </p>
     */
    private Cursor gestureCursor = null;

    /**
     * <p>
     * Whether the dock is floatable. Initialized to true.
     * Accessed/set in the getter/setter.
     * </p>
     */
    private boolean floatable = true;

    /**
     * <p>
     * Whether the dock is drag enabled. Initialized to false.
     * Will be set to true in the constructor.
     * Accessed/set in the getter/setter.
     * </p>
     */
    private boolean dragEnabled = false;

    /**
     * <p>
     * The current dock container of this dock, initialized to null, Null able.
     * It is set in the fireDocked and fireUndocked methods.
     * </p>
     */
    private DockContainer currentDockContainer = null;

    /**
     * <p>
     * The location in current dock container of this dock, initialized to null, Null able.
     * It is set in the fireDocked and fireUndocked methods.
     * </p>
     */
    private Point currentLocationInContainer = null;

    /**
     * <p>
     * The index in current dock container of this dock, initialized to -1.
     * It is set in the fireDocked and fireUndocked methods.
     * </p>
     */
    private int currentIndexInContainer = -1;

    /**
     * <p>
     * The DockHandler instance reference by this dock, initialized to null, Null able,
     * Set in setDragEnabled method.
     * </p>
     */
    private DockHandler dockHandler = null;

    private boolean resizable;

    /**
     * <p>
     * Constructs a DefaultDock instance with a dockable component.
     * </p>
     *
     * @param dockable
     *        the dockable component to be docked
     * @throws IllegalArgumentException
     *         if dockable is null
     */
    public DefaultDock(Dockable dockable) {
        this(dockable, false);
    }

    /**
     * <p>
     * Constructs a DefaultDock instance with a dockable component.
     * </p>
     *
     * @param dockable
     *        the dockable component to be docked
     * @throws IllegalArgumentException
     *         if dockable is null
     */
    public DefaultDock(Dockable dockable, boolean resizable) {
        Helper.checkNull(dockable, "dockable");
        this.dockable = dockable;
        this.resizable = resizable;
        this.setDragEnabled(true);
    }

    /**
     * <p>
     * Return the inner Dockable instance.
     * </p>
     *
     * @return the inner Dockable instance
     */
    public Dockable getDockable() {
        return dockable;
    }

    /**
     * <p>
     * Float the dock to the specific location.
     * Note that the location is the point of dragging cursor,
     * so it needs to translate the drag start location.
     * </p>
     *
     * @param location
     *        the location of dragging cursor
     * @throws IllegalArgumentException
     *         if location is null or x, y is negative
     * @throws IllegalStateException
     *         if dragStartLocation is null
     */
    public void floatTo(Point location) {
        Helper.checkPoint(location, "location");

        // if this dock is floatable
        if (floatable) {
            // if floatContianer is null, create it first
            if (floatContainer == null) {
                floatContainer = new DialogFloatContainer(this, resizable);
            }
            // translate the location
            if (dragStartLocation != null) {
                location.translate(-dragStartLocation.x, -dragStartLocation.y);
            } else {
                throw new IllegalStateException("The dragStartLocation should be set.");
            }
            // dock this dock
            floatContainer.dock(this, location);
            // open the float container
            floatContainer.open();
        }
    }

    /**
     * <p>
     * Setter of the dragEnabled property of the dock.
     * </p>
     *
     * @param enable
     *        whether the dock is drag enabled
     */
    public synchronized void setDragEnabled(boolean enable) {
        // if dragEnabled equal with enable, simply return
        if (dragEnabled == enable) {
            return;
        }

        if (enable) { // if enable is true, create a DockHandler and set it to dockHandler
            try {
                dockHandler = new DockHandler();
            } catch (ClassNotFoundException e) {
                // never happen
            }
        } else { // if enable is false, release dockHandler and set it to null
            dockHandler.release();
            dockHandler = null;
        }
        dragEnabled = enable;
    }

    /**
     * <p>
     * Getter of the dragEnabled property of the dock.
     * Default to false and will be set to true in the constructor.
     * </p>
     *
     * @return whether the dock is drag enabled
     */
    public synchronized boolean isDragEnabled() {
        return dragEnabled;
    }

    /**
     * <p>
     * Getter of the gesture cursor when dragging.
     * Default to null.
     * </p>
     *
     * @return the gesture cursor when dragging
     */
    public Cursor getGestureCursor() {
        return gestureCursor;
    }

    /**
     * <p>
     * Setter of the gesture cursor when dragging.
     * </p>
     *
     * @param gestureCursor
     *        the gesture cursor when dragging
     */
    public void setGestureCursor(Cursor gestureCursor) {
        this.gestureCursor = gestureCursor;
    }

    /**
     * <p>
     * Setter of the floatable property of the dock.
     * </p>
     *
     * @param floatable
     *        the floatable property of the dock.
     */
    public void setFloatable(boolean floatable) {
        // if the floatable is false, and the dock is already floating,
        // call the floatContainer.close to close the floating container and dock it back to the original container
        if (!floatable && floatContainer != null) {
            floatContainer.close();
        }
        this.floatable = floatable;
    }

    /**
     * <p>
     * Getter of the floatable property of the dock.
     * Default to true.
     * </p>
     *
     * @return whether the dock is floatable
     */
    public boolean isFloatable() {
        return floatable;
    }

    /**
     * <p>
     * Setter of the dragStartLocation property of the dock.
     * </p>
     *
     * @param location
     *        the relative location of the dockable component when the drag started
     */
    public void setDragStartLocation(Point location) {
        dragStartLocation = location;
    }

    /**
     * <p>
     * Getter of the dragStartLocation property of the dock.
     * </p>
     *
     * @return the relative location of the dockable component when the drag started
     */
    public Point getDragStartLocation() {
        return dragStartLocation;
    }

    /**
     * <p>
     * Add a DockListener instance.
     * </p>
     *
     * @param listener
     *        the listener to listen when this dock is docked or undocked
     * @throws IllegalArgumentException
     *         if listener is null
     */
    public synchronized void addDockListener(DockListener listener) {
        Helper.checkNull(listener, "listener");
        listeners.add(listener);
    }

    /**
     * <p>
     * Remove a DockListener instance.
     * </p>
     *
     * @param listener
     *        the listener to listen when this dock is docked or undocked
     * @throws IllegalArgumentException
     *         if listener is null
     */
    public synchronized void removeDockListener(DockListener listener) {
        Helper.checkNull(listener, "listener");
        listeners.remove(listener);
    }

    /**
     * <p>
     * Return the shallow copy of all the DockListener instances in this dock.
     * </p>
     *
     * @return the shallow copy of all the DockListener instances in this dock
     */
    public synchronized List<DockListener> getDockListeners() {
        return new ArrayList<DockListener>(listeners);
    }

    /**
     * <p>
     * Fire the docked event, invoke the docked method of all the listeners in this dock.
     * This method should also save the current dock container, position, and index in this dock.
     * </p>
     *
     * @param event
     *        the docked event
     * @throws IllegalArgumentException
     *         if argument is null
     */
    public synchronized void fireDocked(DockEvent event) {
        Helper.checkNull(event, "event");
        // save the current dock container, location, and index
        currentDockContainer = event.getContainer();
        currentLocationInContainer = event.getLocation();
        currentIndexInContainer = event.getIndex();
        // invoke the docked method of all the listeners
        for (DockListener listener : listeners) {
            listener.docked(event);
        }
    }

    /**
     * <p>
     * Fire the undocked event, invoke the undocked method of all the listeners in this dock.
     * This method should also clear the current dock container, position, and index in this dock.
     * </p>
     *
     * @param event
     *        the undocked event
     * @throws IllegalArgumentException
     *         if argument is null
     */
    public synchronized void fireUndocked(DockEvent event) {
        Helper.checkNull(event, "event");
        // save the current dock container, posiction, and index
        currentDockContainer = null;
        currentLocationInContainer = null;
        currentIndexInContainer = -1;
        // invoke the undocked method of all the listeners
        for (DockListener listener : listeners) {
            listener.undocked(event);
        }
    }

    /**
     * <p>
     * Return the current dock container of this dock.
     * Default to null.
     * </p>
     *
     * @return the current dock container of this dock
     */
    public DockContainer getCurrentDockContainer() {
        return currentDockContainer;
    }

    /**
     * <p>
     * Return the location in current dock container of this dock.
     * Default to null.
     * </p>
     *
     * @return the location in current dock container of this dock
     */
    public Point getCurrentLocationInContainer() {
        return currentLocationInContainer;
    }

    /**
     * <p>
     * Return the index in current dock container of this dock.
     * Default to -1.
     * </p>
     *
     * @return the index in current dock container of this dock
     */
    public int getCurrentIndexInContainer() {
        return currentIndexInContainer;
    }

    /**
     * <p>
     * The private inner class is used to handle dragging event on the dockable component.
     * It also defines the <code>DataFlavor</code> to transfer which is required in DnD framework.
     * It is used by <code>Dock</code> class.
     * </p>
     *
     * <p>
     * <strong>Thread-safe</strong>:
     * It is mutable and not thread-safe.
     * </p>
     *
     * @author dmks, TCSDEVELOPER
     * @version 1.0
     */
    private class DockHandler extends DragSourceAdapter implements DragGestureListener, Transferable {

        /**
         * <p>
         * The corresponding DragSournce instance of the dock.
         * Initialized in constructor and set to null in release method.
         * </p>
         */
        private DragSource dragSource;

        /**
         * <p>
         * The DragGestureRecoginizer registered on the drag source.
         * Initialized in constructor and set to null in release method.
         * </p>
         */
        private DragGestureRecognizer dragGestureRecognizer;

        /**
         * <p>
         * Constructs a DockHandler instance with specified dock.
         * Initialize the corresponding drag source and dragGestureRecognizer.
         * </p>
         *
         * @throws ClassNotFoundException
         *         if the DOCK_FLAVOR can be initialized
         */
        public DockHandler() throws ClassNotFoundException {
            // initialize dragSournce and dragGestureRecognizer
            dragSource = new DragSource();
            dragSource.addDragSourceListener(this);
            dragGestureRecognizer = new DockDragGestureRecognizer(dragSource, DnDConstants.ACTION_LINK, this);

            // initialize DOCK_FLAVOR if it is null
            if (DOCK_FLAVOR == null) {
                synchronized (Dock.class) {
                    if (DOCK_FLAVOR == null) {
                        DOCK_FLAVOR =
                            new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=" + Dock.class.getName());
                    }
                }
            }
        }

        /**
         * <p>
         * Release this handler.
         * </p>
         */
        public void release() {
            dragSource.removeDragSourceListener(this);
            dragGestureRecognizer.removeDragGestureListener(this);
            dragGestureRecognizer.resetRecognizer();
            dragSource = null;
            dragGestureRecognizer = null;
        }

        /**
         * <p>
         * This method will be invoked when the drag started in the drag source.
         * </p>
         *
         * @param dge
         *        the drag event
         */
        public void dragGestureRecognized(DragGestureEvent dge) {
            dge.startDrag(DefaultDock.this.getGestureCursor(), this);
            DefaultDock.this.setDragStartLocation(dge.getDragOrigin());
        }

        /**
         * <p>
         * Returns the dock instance if the DataFlavlor is DOCK_FLAVOR,
         * otherwise, UnsupportedFlavorException will be thrown.
         * </p>
         *
         * @param flavor
         *        the dataflavor which the data for
         * @return the data for the specific dataflavor
         * @throws UnsupportedFlavorException
         *         if the dataflavor is not supported
         */
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
            if (this.isDataFlavorSupported(flavor)) {
                return DefaultDock.this;
            }
            throw new UnsupportedFlavorException(flavor);
        }

        /**
         * <p>
         * Return all the supported data flavors.
         * </p>
         *
         * @return all the supported data flavors
         */
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{DOCK_FLAVOR};
        }

        /**
         * <p>
         * Check whether the dataflavor is supported by this component.
         * </p>
         *
         * @param flavor
         *        the given dataflavor
         * @return whether the dataflavor is supported by this component
         */
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return DOCK_FLAVOR == flavor;
        }

        /**
         * <p>
         * This method will be invoked when the dragging dropped.
         * It checked whether the drop is accepted by dock container, if not, float the dock.
         * </p>
         *
         * @param dsde
         *        the drag drop event
         */
        public void dragDropEnd(DragSourceDropEvent dsde) {
            if (!dsde.getDropSuccess() && DefaultDock.this.isFloatable()) {
                Point p = dsde.getLocation();
                DefaultDock.this.floatTo(p);
            }
        }
    }

    /**
     * <p>
     * This is a <code>DragGestureRecognizer</code> implementation for this component.
     * When it is constructed,
     * it will register <code>DragInitListener</code> to the dockable component to recognize the start of dragging.
     * It is used by <code>DockHandler</code> class.
     * </p>
     *
     * <p>
     * <strong>Thread-safe</strong>:
     * It is immutable and thread-safe.
     * </p>
     *
     * @author dmks, TCSDEVELOPER
     * @version 1.0
     */
    private class DockDragGestureRecognizer extends DragGestureRecognizer {

        /**
         * <p>
         * Constructs a new <code>DragGestureRecognizer</code>
         * given the <code>DragSource</code> to be used in this Drag and Drop operation,
         * the <code>Dockable</code> this <code>DockDragGestureRecognizer</code> should "observe"
         * for drag initiating gestures,
         * the action(s) supported for this Drag and Drop operation,
         * and the <code>DragGestureListener</code> to notify once a drag initiating gesture has been detected.
         * </p>
         *
         * @param ds
         *        the DragSource this DockDragGestureRecognizer will use to process the Drag and Drop operation
         * @param sa
         *        the set (logical OR) of the DnDConstants that this Drag and Drop operation will support
         * @param dgl
         *        the DragGestureRecognizer to notify when a drag gesture is detected
         * @throws IllegalArgumentException
         *         if ds is null
         */
        public DockDragGestureRecognizer(DragSource ds, int sa, DragGestureListener dgl) {
            super(ds, dockable.getDockableComponent(), sa, dgl);
        }

        /**
         * <p>
         * Register the DragInitListners to dockable to recognize the drag start.
         * </p>
         */
        public void registerListeners() {
            dockable.setDragInitListener(new DragInitListener() {
                /**
                 * <p>
                 * This method will be invoked when the listened dockable component triggered an event to start drag.
                 * </p>
                 *
                 * @param event
                 *        the input event to start drag
                 * @param dockable
                 *        the dockable component which is the source of the event
                 */
                public void dragInitialized(InputEvent event, Dockable dockable) {
                    Point p;
                    if (event instanceof MouseEvent) {
                        p = ((MouseEvent) event).getPoint();
                    } else {
                        p = new Point(0, 0);
                    }
                    appendEvent(event);
                    fireDragGestureRecognized(getSourceActions(), p);
                }
            });
        }

        /**
         * <p>
         * Unregister the DragInitListners to dockable that recognize the drag start.
         * </p>
         */
        public void unregisterListeners() {
            dockable.setDragInitListener(null);
        }
    }
}
