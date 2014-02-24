/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 * <p>
 * This class extends MouseInputAdapter class and acts as a listener to listen to the WayPoint's mouse event.
 * </p>
 *
 * <p>
 * It will wrap the low level mouse dragged event, and trigger a way point pressed and dragged event.
 * </p>
 *
 * <p>
 * This class is package private and final, it will be registered in the Edge's constructor automatically.
 * So the way point pressed and dragged event could be triggered by default.
 * </p>
 *
 * <p>
 * Thread Safety : This class is mutable and is not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
final class WayPointMouseListener extends MouseInputAdapter {
    /**
     * <p>
     * The edge containing the wayPoint.
     * </p>
     *
     * <p>
     * It is initialized in constructor and never changed later.
     * </p>
     *
     * <p>
     * It will never be null.
     * </p>
     */
    private final Edge edge;

    /**
     * <p>
     * Represents the last mouse point.
     * </p>
     *
     * <p>
     * It is null initially and set in mousePressed and mouseDragged event.
     * </p>
     *
     * <p>
     * This variable is used to hold the dragging history.
     * </p>
     */
    private Point lastPoint;

    /**
     * <p>
     * Construct a WayPointMouseListener instance with edge given.
     * </p>
     *
     * <p>
     * Note, this constructor is package private.
     * </p>
     *
     * @param edge the edge containing the way point.
     *
     * @throws IllegalArgumentException if edge is null.
     */
    WayPointMouseListener(Edge edge) {
        Util.checkNull(edge, "edge");

        this.edge = edge;
    }

    /**
     * <p>
     * Handle the <b>MOUSE_PRESSED</b> event.
     * </p>
     *
     * <p>
     * It is invoked when a mouse button has been pressed on a component.
     * </p>
     *
     * <p>
     * The mouse position is saved in this method.
     * </p>
     *
     * <p>
     * Note, this method will take effect only when the given mouse event is not null,
     * otherwise it does nothing.
     * </p>
     *
     * @param e the mouse pressed event.
     */
    public void mousePressed(MouseEvent e) {
        if (e != null) {
            lastPoint = e.getPoint();
            SelectionCorner wayPoint = (SelectionCorner) e.getSource();
            lastPoint.x += wayPoint.getX();
            lastPoint.y += wayPoint.getY();
        }
    }

    /**
     * <p>
     * Handle the <b>MOUSE_DRAGGED</b> event.
     * </p>
     *
     * <p>
     * It is invoked when a mouse button has been pressed on a component.
     * </p>
     *
     * <p>
     * The way point dragged event are sent out to all the registered listener.
     * The mouse position is saved as well.
     * </p>
     *
     * <p>
     * Note, this method will take effect only when the given mouse event is not null
     * and the source of the event is contained in the edge, otherwise it does nothing.
     * </p>
     *
     * @param e the mouse dragged event.
     */
    public void mouseDragged(MouseEvent e) {
        if (e != null) {
            int index = edge.getWayPoints().indexOf(e.getSource());
            // the source cannot find, do nothing
            if (index == -1) {
                return;
            }

            Point point = e.getPoint();
            SelectionCorner wayPoint = (SelectionCorner) e.getSource();
            point.x += wayPoint.getX();
            point.y += wayPoint.getY();

            // sent out the way point dragged event
            Point offset = Util.getOffset(lastPoint, point);
            edge.fireWayPointDrag(new WayPointEvent(edge, index, offset));

            // save the mouse position
            lastPoint = point;
        }
    }
}
