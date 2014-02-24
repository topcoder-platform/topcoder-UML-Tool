/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock.dndimpl;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.gui.sectionlayout.Helper;
import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.DockContainer;
import com.topcoder.gui.sectionlayout.dock.DockEvent;
import com.topcoder.gui.sectionlayout.dock.DockListener;

/**
 * <p>
 * The basic abstract implementation of <code>DockContainer</code> by using DnD framework.
 * Every implementation using DnD can extend from it.
 * This class implements the Dragging handling, the event handling of dock/undock.
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
public abstract class BasicDockContainer implements DockContainer {

    /**
     * <p>
     * The DockListener instances that listen the docked/undocked event on this dock container.
     * It can't be null, initialized to empty list. never changed. can be empty, the element can't be null.
     * It can be accessed in listeners management methods.
     * </p>
     */
    private final List<DockListener> listeners = new ArrayList<DockListener>();

    /**
     * <p>
     * Whether the dock container is dock enabled. Initialized to false.
     * Will be set to true in the constructor.
     * Accessed/set in the getter/setter.
     * </p>
     */
    private boolean dockEnabled = false;

    /**
     * <p>
     * The DockContainerHandler instance reference by this dock container, initialized to null, Nullable,
     * Set in setDockEnabled method.
     * </p>
     */
    private DockContainerHandler dockContainerHandler;

    /**
     * <p>
     * Constructs a BasicDockContainer instance.
     * Set the container dock enabled.
     * </p>
     */
    protected BasicDockContainer() {
        setDockEnabled(true);
    }

    /**
     * <p>
     * Add a DockListener instance.
     * </p>
     *
     * @param listener
     *        the listener to listen when a dock is docked or undocked in this container
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
     *        the listener to listen when a dock is docked or undocked in this container
     * @throws IllegalArgumentException
     *         if listener is null
     */
    public synchronized void removeDockListener(DockListener listener) {
        Helper.checkNull(listener, "listener");
        listeners.remove(listener);
    }

    /**
     * <p>
     * Return the shallow copy of all the DockListener instances in this dock container.
     * </p>
     *
     * @return the shallow copy of all the DockListener instances in this dock container
     */
    public synchronized List<DockListener> getDockListeners() {
        return new ArrayList<DockListener>(listeners);
    }

    /**
     * <p>
     * Fire the docked event, invoke the docked method of all the listeners in this dock container.
     * </p>
     *
     * @param event
     *        the docked event
     * @throws IllegalArgumentException
     *         if argument is null
     */
    public synchronized void fireDocked(DockEvent event) {
        Helper.checkNull(event, "event");
        for (DockListener listener : listeners) {
            listener.docked(event);
        }
    }

    /**
     * <p>
     * Fire the undocked event, invoke the undocked method of all the listeners in this dock container.
     * </p>
     *
     * @param event
     *        the undocked event
     * @throws IllegalArgumentException
     *         if argument is null
     */
    public synchronized void fireUndocked(DockEvent event) {
        Helper.checkNull(event, "event");
        for (DockListener listener : listeners) {
            listener.undocked(event);
        }
    }

    /**
     * <p>
     * The setter of dockEnabled property in this container.
     * It will also manage dockContainerHandler property.
     * </p>
     *
     * @param enable
     *        whether the dock container is enabled,
     *        false means the dock container is disabled and can't accept any dock.
     */
    public synchronized void setDockEnabled(boolean enable) {
        // if dragEnabled equal with enable, simply return
        if (dockEnabled == enable) {
            return;
        }

        if (enable) { // if enable is true, create a DockContainerHandler and set it to dockContainerHandler
            dockContainerHandler = new DockContainerHandler();
        } else { // if enable is false, release dockContainerHandler and set it to null
            dockContainerHandler.release();
            dockContainerHandler = null;
        }
        dockEnabled = enable;
    }

    /**
     * <p>
     * The getter of dockEnabled property in this container.
     * Default to false and will be set to true in the constructor.
     * </p>
     *
     * @return whether the dock container is enabled,
     *         false means the dock container is disabled and can't accept any dock.
     */
    public synchronized boolean isDockEnabled() {
        return dockEnabled;
    }

    /**
     * <p>
     * This private inner class is used to handle dragging event on the dock container.
     * It first creates the drop target corresponding to the dock container,
     * then listens to the drop target as it implements the <code>DropTargetListener</code>.
     * If the drag enter the dock container, it will let the container mark a gesture;
     * if the drag exit the dock container, it will let the container clear the gesture,
     * if it is dropped into the dock container, it will let the container dock the transferred dock instance.
     * It is used by <code>BasicDockContainer</code> class.
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
    private class DockContainerHandler implements DropTargetListener {

        /**
         * <p>
         * Represents the drop target corresponding to dock container.
         * Initialized in constructor, set to null in release method.
         * </p>
         */
        private DropTarget target;

        /**
         * <p>
         * Constructs a DockContainerHandler instance with a given dock container.
         * Initialize the container and target variables and add this as the DropTargetListener to the target.
         * </p>
         */
        public DockContainerHandler() {
            target = new DropTarget(BasicDockContainer.this.getDockTarget(), DnDConstants.ACTION_LINK, this);
            target.setActive(true);
        }

        /**
         * <p>
         * Release this handler.
         * </p>
         */
        public void release() {
            // inactive the target
            target.setActive(false);
            target.setComponent(null);
            // remove the listener form target
            target.removeDropTargetListener(this);
            // set variables to null
            target = null;
        }

        /**
         * <p>
         * Called while a drag operation is ongoing, when the mouse pointer enters dock container.
         * </p>
         *
         * @param dtde
         *        the DropTargetDragEvent instance
         */
        public void dragEnter(DropTargetDragEvent dtde) {
            // get current data flavors
            DataFlavor[] dfs = dtde.getCurrentDataFlavors();

            for (DataFlavor df : dfs) {
                // if dataflavor is matched
                if (df == DefaultDock.DOCK_FLAVOR) {
                    // accept drag
                    dtde.acceptDrag(DnDConstants.ACTION_LINK);
                    Dock dock = null;
                    try {
                        // get dock from dtde
                        dock = (Dock) dtde.getTransferable().getTransferData(df);
                    } catch (UnsupportedFlavorException e) {
                        // never happen
                    } catch (IOException e) {
                        // never happen
                    }
                    // if dock is not null and container can dock, call the container.markDockGesture method
                    if (dock != null && BasicDockContainer.this.canDock(dock)) {
                        BasicDockContainer.this.markDockGesture(dock, dtde.getLocation());
                    }
                    return;
                }
            }

            // if dataflavor is not matched, reject drag
            dtde.rejectDrag();
        }

        /**
         * <p>
         * Called while a drag operation is ongoing, when the mouse pointer exits dock container.
         * </p>
         *
         * @param dte
         *        the DropTargeEvent instance
         */
        public void dragExit(DropTargetEvent dte) {
            BasicDockContainer.this.clearDockGesture();
        }

        /**
         * <p>
         * Called while a drag operation is ongoing, when the mouse pointer over dock container.
         * </p>
         *
         * @param dtde
         *        the DropTargetDragEvent instance
         */
        public void dragOver(DropTargetDragEvent dtde) {
            // do nothing
        }

        /**
         * <p>
         * Called when the drag operation has terminated with a drop on the dock container.
         * We'll do the dock operation is this method.
         * </p>
         *
         * @param dtde
         *        the DropTargetDragEvent instance
         */
        public void drop(DropTargetDropEvent dtde) {
            // clear dock gesture first
            BasicDockContainer.this.clearDockGesture();

            // get current data flavors
            DataFlavor[] dfs = dtde.getCurrentDataFlavors();

            for (DataFlavor df : dfs) {
                // if dataflavor is matched
                if (df == DefaultDock.DOCK_FLAVOR) {
                    Transferable transferable = dtde.getTransferable();
                    // if the transferable support this dataflavor
                    if (transferable.isDataFlavorSupported(DefaultDock.DOCK_FLAVOR)) {
                        // accept drop
                        dtde.acceptDrop(DnDConstants.ACTION_LINK);
                        Dock dock = null;
                        try {
                            // get dock from transferable
                            dock = (Dock) transferable.getTransferData(df);
                        } catch (UnsupportedFlavorException e) {
                            // never happen
                        } catch (IOException e) {
                            // never happen
                        }
                        // if dock is not null and container can dock, call the container.dock method
                        if (dock != null && BasicDockContainer.this.canDock(dock)) {
                            // it will undock the dock from previous dock container if necessary
                            BasicDockContainer.this.dock(dock, dtde.getLocation());
                        }
                        // set drop complete
                        dtde.dropComplete(true);
                        return;
                    }
                }
            }
            // if dataflavor is not matched, reject drop
            dtde.rejectDrop();
        }

        /**
         * <p>
         * Called if the user has modified the current drop gesture.
         * </p>
         *
         * @param dtde
         *        the DropTargeDragEvent instance
         */
        public void dropActionChanged(DropTargetDragEvent dtde) {
            // do nothing
        }
    }
}
