/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.DiagramView;

/**
 * <p>
 * This is an adapter to handle a series of dragging event. Because we can only get current point of dragging event,
 * last point must be recorded to calculate the offset value. Since the dragging process begins with a mouse press,
 * this class will extend from <code>MouseAdapter</code> and implement <code>MouseMotionListener</code>.
 * </p>
 * <p>
 * The <code>mouseDragged</code> method is left as abstract to compel the user to implement it.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and not thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public abstract class DragEventAdapter extends MouseAdapter implements MouseMotionListener {

    /**
     * <p>
     * Represents the last mouse drag point.
     * </p>
     * <p>
     * It is null initially, and first set in <code>mousePressed</code> method. It can be used and changed in
     * <code>mouseDragged</code> method.
     * </p>
     */
    private Point lastPoint = null;

    /**
     * <p>
     * The default constructor.
     * </p>
     */
    protected DragEventAdapter() {
        // empty
    }

    /**
     * <p>
     * Gets the last mouse drag point.
     * </p>
     * <p>
     * The returned value can be null if the <code>lastPoint</code> field has not been set. Since the <code>Point</code>
     * class is mutable, a cloned object is returned.
     * </p>
     *
     * @return the last mouse drag point
     */
    protected Point getLastPoint() {
        return lastPoint == null ? null : new Point(lastPoint);
    }

    /**
     * <p>
     * Sets the last mouse drag point.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable. Since the <code>Point</code> class is mutable, a cloned
     * object is set.
     * </p>
     *
     * @param lastPoint
     *            the new last mouse drag point
     */
    protected void setLastPoint(Point lastPoint) {
        this.lastPoint = lastPoint == null ? null : new Point(lastPoint);
    }

    /**
     * <p>
     * Handles the <code>MOUSE_PRESSED</code> event.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     *
     * @param e
     *            the mouse pressed event
     */
    public void mousePressed(MouseEvent e) {
        if (e != null) {
            // record the first dragging point
            Point point = new Point(e.getPoint());
            JComponent component = (JComponent)e.getSource();
            while (component != null && !(component instanceof DiagramView)) {
                point.x += component.getX();
                point.y += component.getY();
                component = (JComponent) component.getParent();
            }
            setLastPoint(point);
        }
    }

    /**
     * <p>
     * Handles the <code>MOUSE_MOVED</code> event.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     *
     * @param e
     *            the mouse moved event
     */
    public void mouseMoved(MouseEvent e) {
        // this method does nothing
    }
}
