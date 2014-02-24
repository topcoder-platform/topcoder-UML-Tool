/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;


import javax.swing.JComponent;
import javax.swing.RepaintManager;
import javax.swing.event.MouseInputListener;

/**
 * <p>
 * ZoomPane is a concrete Swing JComponent that can perform zoom and other kind of transformations for another
 * JComponent.
 * </p>
 * <p>
 * The transformation (normally zoom) will be applied upon the enclosed JComponent when painting(rendering) the
 * ZoomPane, and the enclosed JComponent will receive mouse events (including motion events) as normal JComponent that
 * can gain user input. The enclosed JComponent will not be noticed that it has been zoomed, that is to say, the zoomed
 * Component will not need modification to perform the zooming, it can paint it as usual and the listeners of it can
 * handle the events as usual, this class will take care of the transform and convert the position of events for it.
 * This ZoomPane has two kinds of "modes", zoom and not zoom, it will have different behavior when working on different
 * mode. If the enclosed component is zoomed, it will handle the transform as mentioned above; if the enclosed component
 * is not zoomed (determined by isNoZoom method of ZoomTransform interface), the ZoomPane will be a dummy container
 * around the enclosed component, the all transformations will be disabled. The differentiation between them is for
 * performance consideration, the enclosed JComponent needn't know the difference. Please note, while changing the
 * transform during runtime, the user must via the API of setTranform or setZoomFactor from this class. Otherwise, i.e.
 * via getTransform() to get the ZoomTranform and invoking setZoomFactor of it, this class will not be aware of the
 * state changing and switch the mode if the changing of zoom factor results switching from zoom to no zoom or vice
 * versa.
 * <p>
 * ZoomTransform variable is mutable. there would not be code to change the state of the ZoomTransform used by ZoomPane
 * out the scope the ZoomPane class.
 * </p>
 * <p>
 * <strong>Thread-safety</strong>: This class is not thread safe, since it has states and is mutable without
 * synchronization.
 * </p>
 *
 * @author smell, 80x86
 * @version 1.0
 */
public class ZoomPane extends JComponent {

    /**
     * The enclosed JComponent instance to perform zooming. It is initialized in constructor and not modified
     * afterwards. It will never be null.
     */
    private final JComponent zoomComponent;

    /**
     * The transform to perform zooming. It is initialized in constructor and accessed by most methods. The setter will
     * assign to it, and all other methods except setPreferredSize will read it. This field will never be null.
     * This field is mutable, but the implementation doesn't clone it in setter, getter and constructor. Because if
     * this component is properly used, there would not be code to change the state of the ZoomTransform used by
     * ZoomPane out the scope the ZoomPane class. Also ZoomTransform is not cloneable in this version.
     */
    private ZoomTransform transform;

    /**
     * A dimension instance representing the preferred size of this ZoomPane. It will be set by the setPrefferredSize
     * method and read by getPrefferredSize method. It is possible that this field is null, meaning the client has set
     * it.
     */
    private Dimension preferredSize = null;

    /**
     * A MouseInputListener instance added to itself to convert mouse events. It is initialized in the constructor and
     * not changed afterwards, it will never be null.
     */
    private final MouseInputListener mouseProxy;

    /**
     * A KeyListener instance added to itself to convert key events. It is initialized in the constructor and not
     * changed afterwards, it will never be null.
     */
    private final KeyListener keyProxy;

    /**
     * A FocusListener instance added to itself to convert focus events. It is initialized in the constructor and
     * not changed afterwards, it will never be null.
     */
    private final FocusListener focusProxy;

    /**
     * Creates a ZoomPane for the given zoomComponent and with the given transform.
     *
     * @param zoomComponent the enclosed component to zoom
     * @param transform the given transform to perform the zoom
     * @throws IllegalArgumentException if either argument is null
     */
    public ZoomPane(JComponent zoomComponent, ZoomTransform transform) {
        Helper.validateObject(zoomComponent, "zoomComponent");
        Helper.validateObject(transform, "transform");

        // initialize the fields
        this.zoomComponent = zoomComponent;
        this.transform = transform;
        mouseProxy = new MouseEventProxy();
        keyProxy = new KeyEventProxy();
        focusProxy = new FocusEventProxy();

        // set size
        zoomComponent.setSize(zoomComponent.getPreferredSize());

        // set current RepaintManager
        RepaintManager rm = new ZoomRepaintManager(RepaintManager.currentManager(zoomComponent));
        RepaintManager.setCurrentManager(rm);

        // entering different 'modes'
        if (transform.isNoZoom()) {
            // no zoom
            add(zoomComponent);
        } else {
            addMouseListener(mouseProxy);
            addMouseMotionListener(mouseProxy);
            addFocusListener(focusProxy);
            addKeyListener(keyProxy);
        }

        // allows this component to receive focus event
        setFocusable(true);
    }

    /**
     * Sets the preferred size of this zoom pane. The user can use this method to set its size in a container, such as
     * in the viewport of ZoomPanel.
     *
     * @param preferredSize the preferred size to size, it could be null to mean the user not to specify the size.
     * @see java.awt.Component#setPreferredSize(java.awt.Dimension)
     */
    public void setPreferredSize(Dimension preferredSize) {
        super.setPreferredSize(preferredSize);
        this.preferredSize = preferredSize;
    }

    /**
     * Gets the preferred size of this zoom pane. The container (such as ZoomPanel) of this zoom pane may use this
     * method to determine the layout.
     *
     * @return the preferred size
     * @see java.awt.Component#getPreferredSize()
     */
    public Dimension getPreferredSize() {
        // if the size has been set to a non-null value just return it
        if (preferredSize != null) {
            return preferredSize;
        }

        // otherwise compute it based on the preferred size of the enclosed component.
        Dimension d = zoomComponent.getPreferredSize();
        return new Dimension((int) (d.width * getZoomFactor()), (int) (d.height * getZoomFactor()));
    }

    /**
     * Sets the zoomFactor of this zoom pane.
     *
     * @param zoomFactor the zoom factor to set
     * @throws IllegalArgumentException if zoomFactor is not positive
     */
    public void setZoomFactor(double zoomFactor) {
        // store the old noZoom status
        boolean oldIsNoZoom = transform.isNoZoom();

        // set the zoomFactor
        transform.setZoomFactor(Helper.validateDouble(zoomFactor, "zoomFactor"));

        // switch mode if necessary
        switchZoomMode(oldIsNoZoom);
    }

    /**
     * Switches the mode if necessary.
     *
     * @param oldIsNoZoom the old isNoZoom status
     */
    private void switchZoomMode(boolean oldIsNoZoom) {
        // switch mode if necessary
        if (oldIsNoZoom && !transform.isNoZoom()) {
            /*
             * BugFix: UML-10107
             * Hide the component instead of removing.
             */
            // old code
//            remove(zoomComponent);
            zoomComponent.setVisible(false);
            addMouseListener(mouseProxy);
            addMouseMotionListener(mouseProxy);
            addFocusListener(focusProxy);
            addKeyListener(keyProxy);
        } else if (!oldIsNoZoom && transform.isNoZoom()) {
            /*
             * BugFix: UML-10107
             * Show the component instead of adding.
             */
            // old code
//            add(zoomComponent);
            zoomComponent.setVisible(true);
            removeMouseListener(mouseProxy);
            removeMouseMotionListener(mouseProxy);
            removeFocusListener(focusProxy);
            removeKeyListener(keyProxy);
        }
    }

    /**
     * Returns the zoom factor of this zoom pane.
     *
     * @return the zoom factor
     */
    public double getZoomFactor() {
        return transform.getZoomFactor();
    }

    /**
     * Returns the ZoomTransform instance to perform zoom.
     *
     * @return the transform instance
     */
    public ZoomTransform getTransform() {
        return transform;
    }

    /**
     * Sets the ZoomTransform instance to perform zooming.
     *
     * @param transform the ZoomTransform instance to perform zooming
     * @throws IllegalArgumentException if transform is null
     */
    public void setTransform(ZoomTransform transform) {
        Helper.validateObject(transform, "transform");

        // store old transform object
        ZoomTransform old = this.transform;
        // set the new transform object
        this.transform = transform;

        // switch mode if necessary
        switchZoomMode(old.isNoZoom());
    }

    /**
     * This overrides the paintComponent to perform the painting of the zoomed the transform.
     *
     * @param graphics the graphics to paint, should be a Graphics2D instance if used in Swing system.
     * @throws IllegalArgumentException if graphics is not Graphics2D instance
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    protected void paintComponent(Graphics graphics) {
        if (!(graphics instanceof Graphics2D)) {
            throw new IllegalArgumentException("argument [ graphics ] is not an instance of Graphics2D");
        }
        super.paintComponent(graphics);
        // if the transform is no zoom, then return
        if (transform.isNoZoom()) {
            return;
        }

        // apply the transform
        Graphics2D g2 = (Graphics2D) graphics.create();
        transform.applyTransform(g2);

        // paint the zoomed component
        zoomComponent.paint(g2);

        // release the resource
        g2.dispose();
    }


    // FIX: BUGR-87
     /**
      * <p>
      * This bind PopupMenu (if exist) from zoomComponent tas PopupMenu on this zoom pane.
      *</p>
     */
    public void bindPopupMenu()
    {
        if(zoomComponent!=null &&zoomComponent.getComponentPopupMenu()!=null)
            this.setComponentPopupMenu(zoomComponent.getComponentPopupMenu());
    }

     /**
      * <p>
      * Returns zoom component from this zoom pane
      *</p>
      * @return the zoom component
     */
    public JComponent getZoomComponent()
    {
        return zoomComponent;
    }

     /**
      * <p>
      * This calculate reall position from point on zoom pane to point on zoom component
      *</p>
      * @param point that should be transformed
      * @return point that was transformed
     */
    public Point getInverseTransformPoint(Point p)
    {
        MouseEvent mouseEvent=transform.applyInverseTransform(new MouseEvent(this, 0, 0, 0, p.x, p.y, 1, false));
        return new Point(mouseEvent.getX(),mouseEvent.getY());
    }

     /**
      * <p>
      * This is trying get component at point at zoom component
      *</p>
      * @param point from where we want component
      * @return component from zoom component at given possition
     */
    public Component getInverseTransformComponent(Point p)
    {
        zoomComponent.setVisible(true);
        Component comp=zoomComponent.findComponentAt(getInverseTransformPoint(p));
        zoomComponent.setVisible(false);
        return comp;
    }

    /**
     * A custom implementation of ZoomRepaintManager. This class is necessary for the enclosing component to receive
     * notification and repaint itself as well when an application repaint is generated to the enclosed component.
     * The setting is done in the constructor of the ZoomPane constructor.
     * <p>
     * <strong>Thread-safety</strong>: This class is not thread safe, since the enclosing class is not thread safe.
     * </p>
     * @author smell, 80x86
     * @version 1.0
     */
    private class ZoomRepaintManager extends RepaintManager {

        /**
         * The wrapped RepaintManager. It is initialized in constructor, and not changed afterwards, it will not be
         * null. This field is generally the old RepaintManager of system. All methods are delegated to this field.
         */
        private final RepaintManager rm;

        /**
         * Constructs a ZoomRepaintManager to wrap around the old RepaintManager.
         *
         * @param rm the old RepaintManager
         * @throws IllegalArgumentException if rm is null
         */
        public ZoomRepaintManager(RepaintManager rm) {
            Helper.validateObject(rm, "rm");
            this.rm = rm;
        }

        /**
         * Add a component in the list of components that should be refreshed.
         *
         * @param component the component of the repaint request
         * @param x the x value of the repaint rectangle
         * @param y the y value of the repaint rectangle
         * @param w the w value of the repaint rectangle
         * @param h the h value of the repaint rectangle
         * @throws IllegalArgumentException if component is null
         * @see javax.swing.RepaintManager#addDirtyRegion(javax.swing.JComponent, int, int, int, int)
         */
        public void addDirtyRegion(JComponent component, int x, int y, int w, int h) {
            Helper.validateObject(component, "component");
            // Bugfix: UML-12684
//            if (w < 0 || h < 0) {
//                throw new IllegalArgumentException("parameter of type int can't be negative.");
//            }

            rm.addDirtyRegion(component, x, y, w, h);
            if (component.equals(zoomComponent)) {
                rm.markCompletelyDirty(ZoomPane.this);
            }
        }

        /**
         * Mark the component as in need of layout and queue a runnable for the event dispatching thread that will
         * validate the components first isValidateRoot() ancestor.
         *
         * @param invalidComponent the invalid component
         * @throws IllegalArgumentException is invalidComponent is null
         * @see javax.swing.RepaintManager#addInvalidComponent(javax.swing.JComponent)
         */
        public void addInvalidComponent(JComponent invalidComponent) {
            Helper.validateObject(invalidComponent, "invalidComponent");

            rm.addInvalidComponent(invalidComponent);
        }

        /**
         * Return the current dirty region for a component.
         *
         * @return the dirty region
         * @param aComponent the component
         * @throws IllegalArgumentException if aComponent is null
         * @see javax.swing.RepaintManager#getDirtyRegion(javax.swing.JComponent)
         */
        public Rectangle getDirtyRegion(JComponent aComponent) {
            Helper.validateObject(aComponent, "aComponent");
            return rm.getDirtyRegion(aComponent);
        }

        /**
         * Returns the maximum double buffer size.
         *
         * @return the buffer size
         * @see javax.swing.RepaintManager#getDoubleBufferMaximumSize()
         */
        public Dimension getDoubleBufferMaximumSize() {
            return rm.getDoubleBufferMaximumSize();
        }

        /**
         * Return the off screen buffer that should be used as a double buffer with the component c.
         *
         * @return the buffer
         * @param component the component
         * @param proposedWidth the proposed width
         * @param proposedHeight the proposed height
         * @throws IllegalArgumentException if component is null, or any int argument is negative
         * @see javax.swing.RepaintManager#getOffscreenBuffer(java.awt.Component, int, int)
         */
        public Image getOffscreenBuffer(Component component, int proposedWidth, int proposedHeight) {
            Helper.validateObject(component, "component");

            return rm.getOffscreenBuffer(component, Helper.validateIntNotNegative(proposedWidth, "proposedWidth"),
                    Helper.validateIntNotNegative(proposedHeight, "proposedHeight"));
        }

        /**
         * Return a volatile off screen buffer that should be used as a double buffer with the specified component c.
         *
         * @return the buffer
         * @param component the component
         * @param proposedWidth the proposed width
         * @param proposedHeight the proposed height
         * @throws IllegalArgumentException if component is null, or any int argument is negative
         * @see javax.swing.RepaintManager#getVolatileOffscreenBuffer(java.awt.Component, int, int)
         */
        public Image getVolatileOffscreenBuffer(Component component, int proposedWidth, int proposedHeight) {
            Helper.validateObject(component, "component");

            return rm.getVolatileOffscreenBuffer(component, Helper.validateIntNotNegative(proposedWidth,
                    "proposedWidth"), Helper.validateIntNotNegative(proposedHeight, "proposedHeight"));
        }

        /**
         * Convenience method that returns true if aComponent will be completely painted during the next
         * paintDirtyRegions().
         *
         * @return whether aComponent is completely dirty
         * @param aComponent the component
         * @throws IllegalArgumentException if aComponent is null
         * @see javax.swing.RepaintManager#isCompletelyDirty(javax.swing.JComponent)
         */
        public boolean isCompletelyDirty(JComponent aComponent) {
            Helper.validateObject(aComponent, "aComponent");
            return rm.isCompletelyDirty(aComponent);
        }

        /**
         * Returns true if this RepaintManager is double buffered.
         *
         * @return true if this RepaintManager is double buffered, false otherwise
         * @see javax.swing.RepaintManager#isDoubleBufferingEnabled()
         */
        public boolean isDoubleBufferingEnabled() {
            return rm.isDoubleBufferingEnabled();
        }

        /**
         * Mark a component completely clean.
         *
         * @param aComponent the component.
         * @throws IllegalArgumentException if aComponent is null
         * @see javax.swing.RepaintManager#markCompletelyClean(javax.swing.JComponent)
         */
        public void markCompletelyClean(JComponent aComponent) {
            Helper.validateObject(aComponent, "aComponent");
            rm.markCompletelyClean(aComponent);
        }

        /**
         * Mark a component completely dirty.
         *
         * @param aComponent the component.
         * @throws IllegalArgumentException if aComponent is null
         * @see javax.swing.RepaintManager#markCompletelyDirty(javax.swing.JComponent)
         */
        public void markCompletelyDirty(JComponent aComponent) {
            Helper.validateObject(aComponent, "aComponent");
            rm.markCompletelyDirty(aComponent);
        }

        /**
         * Paint all of the components that have been marked dirty.
         *
         * @see javax.swing.RepaintManager#paintDirtyRegions()
         */
        public void paintDirtyRegions() {
            rm.paintDirtyRegions();
        }

        /**
         * Remove a component from the list of invalid components.
         *
         * @param component the component
         * @throws IllegalArgumentException if component is null
         * @see javax.swing.RepaintManager#removeInvalidComponent(javax.swing.JComponent)
         */
        public void removeInvalidComponent(JComponent component) {
            Helper.validateObject(component, "component");
            rm.removeInvalidComponent(component);
        }

        /**
         * Enables or disables double buffering in this RepaintManager.
         *
         * @param aFlag true to enable, false to disable
         * @see javax.swing.RepaintManager#setDoubleBufferingEnabled(boolean)
         */
        public void setDoubleBufferingEnabled(boolean aFlag) {
            rm.setDoubleBufferingEnabled(aFlag);
        }

        /**
         * Set the maximum double buffer size.
         *
         * @param dimension the size
         * @throws IllegalArgumentException if dimension is null
         * @see javax.swing.RepaintManager#setDoubleBufferMaximumSize(java.awt.Dimension)
         */
        public void setDoubleBufferMaximumSize(Dimension dimension) {
            Helper.validateObject(dimension, "dimension");
            rm.setDoubleBufferMaximumSize(dimension);
        }

        /**
         * Returns a string that displays and identifies this object's properties.
         *
         * @return the string representation of this object
         * @see java.lang.Object#toString()
         */
        public String toString() {
            return rm.toString();
        }

        /**
         * Validate all of the components that have been marked invalid.
         *
         * @see javax.swing.RepaintManager#validateInvalidComponents()
         */
        public void validateInvalidComponents() {
            rm.validateInvalidComponents();
        }
    }

    /**
     * Implementation of FocusListener interface to delegate the FocusEvent to zoomed component. All the focus listeners
     * of the zoomed component will receive the event directly.
     * <p>
     * <strong>Thread-safety</strong>: This class is not thread safe, since the enclosing class is not thread safe.
     * </p>
     *
     * @author smell, 80x86
     * @version 1.0
     */
    private class FocusEventProxy implements FocusListener {

        /**
         * <p>
         * Creates a FocusEventProxy instance. Empty constructor
         * </p>
         */
        public FocusEventProxy() {
        }

        /**
         * Invoked when a component gains the keyboard focus.
         *
         * @param event the focus event
         * @throws IllegalArgumentException if event is null.
         * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
         */
        public void focusGained(FocusEvent event) {
            Helper.validateObject(event, "event");
            event.setSource(zoomComponent);
            for (FocusListener listener : zoomComponent.getFocusListeners()) {
                listener.focusGained(event);
            }
        }

        /**
         * Invoked when a component loses the keyboard focus.
         *
         * @param event the focus event
         * @throws IllegalArgumentException if event is null.
         * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
         */
        public void focusLost(FocusEvent event) {
            Helper.validateObject(event, "event");
            event.setSource(zoomComponent);
            for (FocusListener listener : zoomComponent.getFocusListeners()) {
                listener.focusLost(event);
            }
        }
    }

    /**
     * Implementation of KeyListener interface to delegate the KeyEvent to zoomed component. All the keyevent listeners
     * of the zoomed component will receive the event directly.
     * <p>
     * <strong>Thread-safety</strong>: This class is not thread safe, since the enclosing class is not thread safe.
     * </p>
     *
     * @author smell, 80x86
     * @version 1.0
     */
    private class KeyEventProxy implements KeyListener {

        /**
         * <p>
         * Creates a KeyEventProxy instance. Empty constructor.
         * </p>
         */
        public KeyEventProxy() {
        }

        /**
         * Invoked when a key has been typed.
         *
         * @param event the key event
         * @throws IllegalArgumentException if event is null
         * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
         */
        public void keyTyped(KeyEvent event) {
            dispatchEvent(event);
        }

        /**
         * Invoked when a key has been pressed.
         *
         * @param event the key event
         * @throws IllegalArgumentException if event is null
         * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
         */
        public void keyPressed(KeyEvent event) {
            dispatchEvent(event);
        }

        /**
         * Invoked when a key has been released.
         *
         * @param event the key event
         * @throws IllegalArgumentException if event is null
         * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
         */
        public void keyReleased(KeyEvent event) {
            dispatchEvent(event);
        }

        /**
         * <p>
         * Checks the event is not null, changes event's source to zoomComponent and dispatches event.
         * </p>
         * @param event the event to dispatch
         */
        private void dispatchEvent(KeyEvent event) {
            Helper.validateObject(event, "event");
            event.setSource(zoomComponent);
            zoomComponent.dispatchEvent(event);
        }
    }

    /**
     * The implementation of MouseInputListener to convert the Mouse Events occurred in this Zoom Pane and delegate to
     * the enclosed zoom component.
     * <p>
     * <strong>Thread-safety</strong>: This class is not thread safe, since the enclosing class is not thread safe.
     * </p>
     *
     * @author smell, 80x86
     * @version 1.0
     */
    private class MouseEventProxy implements MouseInputListener {

        /**
         * <p>
         * Represents the mouse clicked event.
         * </p>
         */
        private static final int MOUSE_CLICKED = 0;

        /**
         * <p>
         * Represents the mouse entered event.
         * </p>
         */
        private static final int MOUSE_ENTERED = 1;

        /**
         * <p>
         * Represents the mouse exited event.
         * </p>
         */
        private static final int MOUSE_EXITED = 2;

        /**
         * <p>
         * Represents the mouse pressed event.
         * </p>
         */
        private static final int MOUSE_PRESSED = 3;

        /**
         * <p>
         * Represents the mouse released event.
         * </p>
         */
        private static final int MOUSE_RELEASED = 4;

        /**
         * <p>
         * Represents the mouse dragged event.
         * </p>
         */
        private static final int MOUSE_DRAGGED = 5;

        /**
         * <p>
         * Represents the mouse moved event.
         * </p>
         */
        private static final int MOUSE_MOVED = 6;

        /**
         * <p>
         * Represents the source of drag event, recorded when mouse pressed.
         * </p>
         */
        private Component dragSource;

        /**
         * <p>
         * Represents the source of drag event, recorded when mouse pressed.
         * </p>
         */
        private Component exitSource;

        /**
         * Default constructor, does nothing.
         */
        public MouseEventProxy() {
        }

        /**
         * Invoked when the mouse button has been clicked (pressed and released) on a component.
         *
         * @param event the mouse event
         * @throws IllegalArgumentException if event is null
         * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
         */
        public void mouseClicked(MouseEvent event) {
            notifyMouseListeners(event, MOUSE_CLICKED);
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param event the mouse event
         * @throws IllegalArgumentException if event is null
         * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
         */
        public void mousePressed(MouseEvent event) {
            notifyMouseListeners(event, MOUSE_PRESSED);
        }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param event the mouse event
         * @throws IllegalArgumentException if event is null
         * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
         */
        public void mouseReleased(MouseEvent event) {
            notifyMouseListeners(event, MOUSE_RELEASED);
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param event the mouse event
         * @throws IllegalArgumentException if event is null
         * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
         */
        public void mouseEntered(MouseEvent event) {
            notifyMouseListeners(event, MOUSE_ENTERED);
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param event the mouse event
         * @throws IllegalArgumentException if event is null
         * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
         */
        public void mouseExited(MouseEvent event) {
            notifyMouseListeners(event, MOUSE_EXITED);
        }

        /**
         * <p>
         * Converts the mouse event, changes source and notifies mouse motion listeners.
         * </p>
         * @param event the mouse event.
         * @param eventType the event type.
         * @throws IllegalArgumentException if event is null.
         */
        private void notifyMouseListeners(MouseEvent event, int eventType) {
            Helper.validateObject(event, "event");

            if(event.isPopupTrigger()){// && !transform.isNoZoom()){
                System.out.println("popable and zoomed");
                /*removeMouseListener(mouseProxy);
                fix();
                processMouseEvent(event);
                unfix();
                addMouseListener(mouseProxy);*/
            }
            /*
             * BugFix: UML-10108
             * Dispatch the event to top most component.
             */
            // old code
//            event.setSource(zoomComponent);
//            MouseEvent converted = transform.applyInverseTransform(event);
//            MouseListener[] listeners = zoomComponent.getMouseListeners();
//            for (MouseListener listener : listeners) {
//                switch (eventType) {
//                case MOUSE_CLICKED:
//                    listener.mouseClicked(converted);
//                    break;
//                case MOUSE_ENTERED:
//                    listener.mouseEntered(converted);
//                    break;
//                case MOUSE_EXITED:
//                    listener.mouseExited(converted);
//                    break;
//                case MOUSE_PRESSED:
//                    listener.mousePressed(converted);
//                    break;
//                default:
//                    listener.mouseReleased(converted);
//                    break;
//                }
//            }
            ZoomPane zoomPane = (ZoomPane) event.getSource();
            event.setSource(zoomComponent);
            MouseEvent converted = transform.applyInverseTransform(event);

            if (eventType == MOUSE_RELEASED) {
                // if is mouse release event, convert to event of dragSource
                converted = convertEvent(dragSource, converted);
                dragSource.dispatchEvent(converted);
            } else {
                converted = convertEventToTopMost(converted);
                Component source = (Component) converted.getSource();

                source.dispatchEvent(converted);
                if (eventType == MOUSE_PRESSED) {
                    // if is mouse pressed event, save dragSource here.
                    dragSource = source;
                }
            }
            zoomPane.repaint();
        }

        /**
         * Invoked when a mouse button is pressed on a component and then dragged. MOUSE_DRAGGED events will continue to
         * be delivered to the component where the drag originated until the mouse button is released (regardless of
         * whether the mouse position is within the bounds of the component). Due to platform-dependent Drag&Drop
         * implementations, MOUSE_DRAGGED events may not be delivered during a native Drag&Drop operation.
         *
         * @param event the mouse event
         * @throws IllegalArgumentException if event is null
         * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
         */
        public void mouseDragged(MouseEvent event) {
            notifyMouseMotionListeners(event, MOUSE_DRAGGED);
        }

        /**
         * Invoked when the mouse cursor has been moved onto a component but no buttons have been pushed.
         *
         * @param event the mouse event
         * @throws IllegalArgumentException if event is null
         * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
         */
        public void mouseMoved(MouseEvent event) {
            notifyMouseMotionListeners(event, MOUSE_MOVED);
        }

        /**
         * <p>
         * Converts the mouse motion event, changes source and notifies mouse motion listeners.
         * </p>
         * @param event the mouse event.
         * @param eventType the event type.
         * @throws IllegalArgumentException if event is null.
         */
        private void notifyMouseMotionListeners(MouseEvent event, int eventType) {
            Helper.validateObject(event, "event");

            /*
             * BugFix: UML-10110
             * Dispatch the event to top most component.
             */
            // old code
//            event.setSource(zoomComponent);
//            MouseEvent converted = transform.applyInverseTransform(event);
//            MouseMotionListener[] listeners = zoomComponent.getMouseMotionListeners();
//            for (MouseMotionListener listener : listeners) {
//                switch (eventType) {
//                case MOUSE_DRAGGED:
//                    listener.mouseDragged(converted);
//                    break;
//                default:
//                    listener.mouseMoved(converted);
//                    break;
//                }
//            }
            ZoomPane zoomPane = (ZoomPane) event.getSource();
            event.setSource(zoomComponent);
            MouseEvent converted = transform.applyInverseTransform(event);

            if (eventType == MOUSE_DRAGGED) {
                // if is mouse drag event, convert the event for dragSource.
                converted = convertEvent(dragSource, converted);
                dragSource.dispatchEvent(converted);
            } else if (eventType == MOUSE_MOVED) {
                /*
                 * BugFix: UML-9878
                 * When moving in/out a top most child component, trigger the
                 * MOUSE_ENTERED/MOUSE_EXITED event.
                 */
                converted = convertEventToTopMost(converted);
                Component source = (Component) converted.getSource();
                if (exitSource != source) {
                    if (exitSource != null) {
                        MouseEvent exitedEvent = new MouseEvent(exitSource, MouseEvent.MOUSE_EXITED,
                                converted.getWhen(), converted.getModifiers(), converted.getX(),
                                converted.getY(), converted.getClickCount(),
                                converted.isPopupTrigger(), converted.getButton());

                        exitSource.dispatchEvent(exitedEvent);
                    }
                    MouseEvent enteredEvent = new MouseEvent(source, MouseEvent.MOUSE_ENTERED,
                            converted.getWhen(), converted.getModifiers(), converted.getX(),
                            converted.getY(), converted.getClickCount(), converted.isPopupTrigger(),
                            converted.getButton());
                    source.dispatchEvent(enteredEvent);

                    exitSource = source;
                }
            } else {
                zoomComponent.dispatchEvent(converted);
            }

            zoomPane.repaint();
        }

        /**
         * <p>
         * Converts the given event to the top most child component.
         * </p>
         * @param event
         *            event to convert
         * @return the converted event
         */
        private MouseEvent convertEventToTopMost(MouseEvent event) {
            MouseEvent converted = event;
            Component parent = (Component) event.getSource(), child;
            for (;;) {
                child = (Component) parent.getComponentAt(converted.getX(), converted.getY());
                if (child == null || child == parent) {
                    break;
                } else {
                    int x = converted.getX() - child.getX();
                    int y = converted.getY() - child.getY();
                    converted = new MouseEvent(child, converted.getID(), converted.getWhen(), converted.getModifiers(),
                            x, y, converted.getClickCount(), converted.isPopupTrigger(), converted.getButton());
                    parent = child;
                }
            }
            return converted;
        }

        /**
         * <p>
         * Converts the given event to specified component.
         * </p>
         * @param child
         *            the child component to convert for
         * @param event
         *            the event to convert
         * @return the convert event
         */
        private MouseEvent convertEvent(Component child, MouseEvent event) {
            int offsetx = 0, offsety = 0;
            Component component = child;
            for (component = child; component != event.getSource(); component = component.getParent()) {
                offsetx += component.getX();
                offsety += component.getY();
            }

            int x = event.getX() - offsetx;
            int y = event.getY() - offsety;
            MouseEvent converted = new MouseEvent(child, event.getID(), event.getWhen(), event.getModifiers(), x, y,
                    event.getClickCount(), event.isPopupTrigger(), event.getButton());
            return converted;
        }
    }
}
