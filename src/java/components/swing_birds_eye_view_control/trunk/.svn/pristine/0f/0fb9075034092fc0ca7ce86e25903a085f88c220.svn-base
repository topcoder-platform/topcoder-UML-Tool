/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

import java.awt.AlphaComposite;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

import com.topcoder.swing.birdseyeview.event.ViewPortEvent;
import com.topcoder.swing.birdseyeview.event.ViewPortListener;

/**
 * <p>
 * The view port of the birds eye view. This class represents the JComponent
 * (just a simple rectangle), which will be shown over the birds eye view zoom
 * panel and define the current view port. This is a zoomed view port related to
 * the view port of the input object. It supports dragging by mouse and mouse
 * press event is also processed - will center this component view port at the
 * mouse cursor. The view port has an opacity from 0.0 (0%) to 1.0 (100%). This
 * class will be automatically updated on any change in the ZoomPanel or
 * BirdsEyeView JComponent, because it is a child of them. The
 * paintComponent(...) method of this class will be called on any updates. All
 * calculations will be performed in that method. This class support
 * registration of the view port listeners, which will be called in the case
 * when the input object view port position should be changed.
 * </p>
 *
 * <p>
 * Please note, setting the properties of this class do not perform repainting
 * of the control, because the efficiency is very important and several
 * properties will be usually set (not just once).
 * </p>
 *
 * <p>
 * Thread safety: This class is mutable and therefore is not thread-safe. There
 * is no need to make this class thread safe, because it is just a GUI control,
 * which usually are not thread-safe.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class ViewPort extends JComponent implements MouseInputListener {
    /**
     * <p>
     * Default value of opacity.
     * </p>
     */
    private static final double DEFAULT_OPACITY = 0.5;
    /**
     * <p>
     * Represents the opacity value of the view port. The value 1.0 means 100%
     * of the view port color data - no transparency at all. The value 0.0 -
     * means 0% of the view port color data - means fully transparent data (view
     * port is invisible). The value of 0.5 means 50% - like semi-transparent
     * view port. Of course, any other values can be also used. It should be
     * from 0.0 to 1.0 (both ends inclusive). It is directly initialized.
     * </p>
     *
     * <p>
     * Use related getter/setter methods to retrieve this field value or to
     * mutate its data.
     * </p>
     */
    private double opacity = DEFAULT_OPACITY;
    /**
     * <p>
     * Represents the control flag, defining whether the dragging action with
     * the view port is going on (true value), or not - like finished or not
     * started yet (false value).
     * </p>
     *
     * <p>
     * It can be any value. It is directly initialized.
     * Use related getter/setter methods to retrieve this field value or to mutate its data.
     * </p>
     */
    private boolean dragging = false;
    /**
     * <p>
     * Represent the current mouse cursor position inside this view port during
     * dragging it. It will be set in the mousePressed(...) event and next
     * checked and updated in mouseDragged event. This is an instance of the
     * Point class.
     * </p>
     *
     * <p>
     * It can not be null. It is directly initialized. Use related
     * getter/setter methods to retrieve this field value or to mutate its data.
     * </p>
     */
    private Point dragPosition = new Point(0, 0);
    /**
     * <p>
     * Represents the zoom factor for this view port. It will be the same as for
     * zoomPanel. The factor = 1.0 mean no scaling (the same size of the
     * object). factor =0.5 means twice scaling down, and factor =2.0 means
     * twice scaling up. Of course, other values can be also used. It can be any
     * value greater than or equal to 0.0.
     * </p>
     *
     * <p>
     * It is directly initialized. Use related getter/setter methods to retrieve
     * this field value or to mutate
     * its data.
     * </p>
     */
    private double zoomFactor = 1.0;

    /**
     * <p>
     * The default parameter-less constructor.
     * </p>
     */
    public ViewPort() {
        super();
        // Register the mouse listener for the current class
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.repaint();
    }

    /**
     * <p>
     * A simple getter method for the "opacity" internal field. Please refer to
     * the related field for more information.
     * </p>
     *
     * @return the retrieved value of the opacity value of the view port. The
     *         value 1.0 means 100% of the view port color data - no
     *         transparency at all. The value 0.0 - means 0% of the view port
     *         color data - means fully transparent data (view port is
     *         invisible). The value of 0.5 means 50% - like semi-transparent
     *         view port. Of course, any other values can be also used. It
     *         should be from 0.0 to 1.0 (both ends inclusive)
     */
    public double getOpacity() {
        return this.opacity;
    }

    /**
     * <p>
     * A simple setter method for the "opacity" internal field. Please refer to
     * the related field for more information.
     * </p>
     *
     * @param opacity
     *            the new value of the opacity value of the view port. The value
     *            1.0 means 100% of the view port color data - no transparency
     *            at all. The value 0.0 - means 0% of the view port color data -
     *            means fully transparent data (view port is invisible). The
     *            value of 0.5 means 50% - like semi-transparent view port. Of
     *            course, any other values can be also used. It should be from
     *            0.0 to 1.0 (both ends inclusive)
     */
    public void setOpacity(double opacity) {
        if (opacity < 0 || opacity > 1) {
            throw new IllegalArgumentException("the opacity is not in the scope [0, 1].");
        }
        this.opacity = opacity;
    }

    /**
     * <p>
     * A simple getter method for the "zoomFactor" internal field. Please refer
     * to the related field for more information.
     * </p>
     *
     * @return the retrieved value of the zoom factor for this view port. It
     *         will be the same as for zoomPanel. The factor = 1.0 mean no
     *         scaling (the same size of the object). factor =0.5 means twice
     *         scaling down, and factor =2.0 means twice scaling up. Of course,
     *         other values can be also used. It can be any value greater than
     *         or equal to 0.0.
     */
    public double getZoomFactor() {
        return this.zoomFactor;
    }

    /**
     * <p>
     * A simple setter method for the "zoomFactor" internal field. Please refer
     * to the related field for more information.
     * </p>
     *
     * @param zoomFactor
     *            the new value of the zoom factor for this view port. It will
     *            be the same as for zoomPanel. The factor = 1.0 mean no scaling
     *            (the same size of the object). factor =0.5 means twice scaling
     *            down, and factor =2.0 means twice scaling up. Of course, other
     *            values can be also used. It can be any value greater than or
     *            equal to 0.0.
     * @throws IllegalArgumentException
     *            If the parameter zoomFactor is less than 0
     */
    public void setZoomFactor(double zoomFactor) {
        if (zoomFactor < 0) {
            throw new IllegalArgumentException("the zoomFactor should not be less than 0.");
        }
        if (Helper.compareDoubles(zoomFactor, 0)) {
            this.zoomFactor = 1;
        } else {
            this.zoomFactor = zoomFactor;
        }
    }

    /**
     * <p>
     * Invoked when a mouse button has been pressed on a component. It will be
     * used for start dragging of the view port.
     * </p>
     *
     * @param event
     *            an instance of the MouseEvent class with the data about the
     *            current mouse state. It should be not null. If null - simply
     *            ignore it and return.
     */
    public void mousePressed(MouseEvent event) {
        if (event == null) {
            return;
        }
        // Start the dragging
        this.setDragging(true);
        // Set the current dragging position
        this.getDragPosition().setLocation(event.getX(), event.getY());
    }

    /**
     * <p>
     * Invoked when a mouse button is pressed on a component and then dragged.
     * MOUSE_DRAGGED events will continue to be delivered to the component where
     * the drag originated until the mouse button is released (regardless of
     * whether the mouse position is within the bounds of the component). It
     * will be used for dragging of the view port.
     * </p>
     *
     * @param event
     *            an instance of the MouseEvent class with the data about the
     *            current mouse state. It should be not null. If null - simply
     *            ignore it and return.
     */
    public void mouseDragged(MouseEvent event) {
        if (event == null) {
            return;
        }
        if (this.isDragging()) {
            // Get the new dragging position
            Point newDragPosition = new Point(event.getX(), event.getY());
            if (this.getDragPosition().equals(newDragPosition)) {
                return;
            }
            // Calculate the displacements
            int xDelta = (int) (newDragPosition.getX() - this.getDragPosition().getX());
            int yDelta = (int) (newDragPosition.getY() - this.getDragPosition().getY());

            // Retrieve the size of the view port
            int viewPortWidth = this.getWidth();
            int viewPortHeight = this.getHeight();

            // Calculate the possible new location of the view port
            int x = this.getX() + xDelta;
            int y = this.getY() + yDelta;

            // Get the size of the parent control
            Container parent = this.getParent();
            if (parent == null) {
                return;
            }
            int parentWidth = parent.getWidth();
            int parentHeight = parent.getHeight();

            // Check the limits of the view port borders for the new location
            if (x < 0 || x + viewPortWidth > parentWidth || y < 0 || y + viewPortHeight > parentHeight) {
                return;
            }
            // Set the new location of the view port
            this.setLocation(x, y);
            // Set the new value for the drag position
            this.getDragPosition().setLocation(newDragPosition);
            // Repaint the view port
            this.repaint();
        }
    }

    /**
     * <p>
     * Invoked when a mouse button has been released on a component. It will be
     * used for stop dragging of the view port.
     * </p>
     *
     * @param event
     *            an instance of the MouseEvent class with the data about the
     *            current mouse state. It should be not null. If null - simply
     *            ignore it and return.
     */
    public void mouseReleased(MouseEvent event) {
        if (event == null) {
            return;
        }
        // Stop the dragging
        this.setDragging(false);
    }

    /**
     * <p>
     * Invoked when the mouse button has been clicked (pressed and released) on
     * a component. Not used in this component.
     * </p>
     *
     * @param event
     *            an instance of the MouseEvent class with the data about the
     *            current mouse state. It should be not null. If null - simply
     *            ignore it and return.
     */
    public void mouseClicked(MouseEvent event) {
    }

    /**
     * <p>
     * Invoked when the mouse enters a component. Not used in this component.
     * </p>
     *
     * @param event
     *            an instance of the MouseEvent class with the data about the
     *            current mouse state. It should be not null. If null - simply
     *            ignore it and return.
     */
    public void mouseEntered(MouseEvent event) {
    }

    /**
     * <p>
     * Invoked when the mouse exits a component. Not used in this component.
     * </p>
     *
     * @param event
     *            an instance of the MouseEvent class with the data about the
     *            current mouse state. It should be not null. If null - simply
     *            ignore it and return.
     */
    public void mouseExited(MouseEvent event) {
    }

    /**
     * <p>
     * Invoked when the mouse cursor has been moved onto a component but no
     * buttons have been pushed. Not used in this component.
     * </p>
     *
     * @param event
     *            an instance of the MouseEvent class with the data about the
     *            current mouse state. It should be not null. If null - simply
     *            ignore it and return.
     */
    public void mouseMoved(MouseEvent event) {
    }

    /**
     * <p>
     * Add the listener to the listenerList.
     * </p>
     *
     * @param listener
     *            the instance of the ViewPortListener class. This is a listener
     *            to be registered to this JComponent. It can not be null.
     */
    public void addViewPortListener(ViewPortListener listener) {
        Helper.checkNull(listener, "listener");
        super.listenerList.add(ViewPortListener.class, listener);
    }

    /**
     * <p>
     * Remove the listener from the listenerList.
     * </p>
     *
     * @param listener
     *            the instance of the ViewPortListener class. This is a listener
     *            to be de-registered from this JComponent. It can not be null.
     */
    public void removeViewPortListener(ViewPortListener listener) {
        Helper.checkNull(listener, "listener");
        super.listenerList.remove(ViewPortListener.class, listener);
    }

    /**
     * <p>
     * Remove all the registered ViewPortListener instances from the
     * listenerList.
     * </p>
     */
    public void clearViewPortListeners() {
        ViewPortListener[] listeners = super.listenerList.getListeners(ViewPortListener.class);
        for (ViewPortListener listener : listeners) {
            super.listenerList.remove(ViewPortListener.class, listener);
        }
    }

    /**
     * <p>
     * Notifies all the ViewPortListener instances from the listenerList.
     * </p>
     *
     * @param event
     *            an instance of the ViewPortEvent class with the data about the
     *            view port moving. It can not be null.
     */
    protected void fireViewPortListeners(ViewPortEvent event) {
        Helper.checkNull(event, "event");
        ViewPortListener[] listeners = super.listenerList.getListeners(ViewPortListener.class);
        for (ViewPortListener listener : listeners) {
            listener.viewPortMoved(event);
        }
    }

    /**
     * <p>
     * A simple getter method for the "dragging" internal field. Please refer to
     * the related field for more information.
     * </p>
     *
     * @return the retrieved value of the control flag, defining whether the
     *         dragging action with the view port is going on (true value), or
     *         not - like finished or not started yet (false value). It can be
     *         any value
     */
    protected boolean isDragging() {
        return this.dragging;
    }

    /**
     * <p>
     * A simple setter method for the "dragging" internal field. Please refer to
     * the related field for more information.
     * </p>
     *
     * @param dragging
     *            the new value of the control flag, defining whether the
     *            dragging action with the view port is going on (true value),
     *            or not - like finished or not started yet (false value). It
     *            can be any value
     */
    protected void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    /**
     * <p>
     * A simple getter method for the "dragPosition" internal field. Please
     * refer to the related field for more information.
     * </p>
     *
     * @return the retrieved value of the current mouse cursor position inside
     *         this view port during dragging it. It will be set in the
     *         mousePressed(...) event and next checked and updated in
     *         mouseDragged event. This is an instance of the Point class. It
     *         can not be null
     */
    protected Point getDragPosition() {
        return this.dragPosition;
    }

    /**
     * <p>
     * A simple setter method for the "dragPosition" internal field. Please
     * refer to the related field for more information.
     * </p>
     *
     * @param dragPosition
     *            the new value of the current mouse cursor position inside this
     *            view port during dragging it. It will be set in the
     *            mousePressed(...) event and next checked and updated in
     *            mouseDragged event. This is an instance of the Point class. It
     *            can not be null
     */
    protected void setDragPosition(Point dragPosition) {
        Helper.checkNull(dragPosition, "dragPosition");
        this.dragPosition = dragPosition;
    }

    /**
     * <p>
     * Draw the graphics of the view port. It supports the semi-transparent view
     * port image (with opacity value).
     * </p>
     *
     * @param g
     *            the Graphics instance to be used for drawing the component. It
     *            should be not null. If null - simply ignore it and return.
     */
    protected void paintComponent(Graphics g) {
        if (!(g instanceof Graphics2D)) {
            return;
        }
        Graphics2D g2 = (Graphics2D) g;
        // Apply the opacity
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                (float) this.getOpacity()));

        // Draw the background
        g.setColor(this.getBackground());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        // Calculate the location of the input object view port
        int x = (int) (this.getX() / this.getZoomFactor());
        int y = (int) (this.getY() / this.getZoomFactor());
        // Fire the listeners to update the current position of the
        // input object view port
        this.fireViewPortListeners(new ViewPortEvent(x, y));
    }
}
