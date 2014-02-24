/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdatePolylineAction;

/**
 * <p>
 * This handler will resize a shape node when its selection corner is dragged and released.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly
 * @version 1.0
 */
public class PolylineCornerMouseHandler extends MouseAdapter {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Represents the old position for dragged graph node.
     * </p>
     */
    private java.awt.Point oldPosition = new java.awt.Point();

    /**
     * <p>
     * Represents the old way points of polyline.
     * </p>
     */
    private List<Point> oldWayPoints = new ArrayList<Point>();

    /**
     * <p>
     * Creates an instance of <code>CornerMouseHandler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public PolylineCornerMouseHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Handles the <b>MOUSE_PRESSED</b> event.
     * </p>
     * <p>
     * When mouse is pressed on a way point, record its index and old position.
     * </p>
     * @param e
     *            the mouse pressed event
     */
    public void mousePressed(MouseEvent e) {
        if (e == null) {
            return;
        }
        SelectionCorner corner = (SelectionCorner) e.getSource();
        PolylineNode node = (PolylineNode) corner.getParent();
        oldPosition = SwingUtilities.convertPoint(corner, e.getPoint(), node.getParent());
        Polyline polyline = node.getPolyline();
        oldWayPoints.clear();
        for (Point point : polyline.getWaypoints()) {
            Point newPoint = new Point();
            newPoint.setX(point.getX());
            newPoint.setY(point.getY());
            oldWayPoints.add(newPoint);
        }
    }

    /**
     * <p>
     * Handles the <b>MOUSE_RELEASED</b> event.
     * </p>
     * <p>
     * When mouse is released, create an action for a way point moving, and pass it to event manager.
     * </p>
     * @param e
     *            the mouse pressed event
     */
    public void mouseReleased(MouseEvent e) {
        if (e == null) {
            return;
        }
        SelectionCorner corner = (SelectionCorner) e.getSource();
        PolylineNode node = (PolylineNode) corner.getParent();
        java.awt.Point newPosition = SwingUtilities.convertPoint(corner, e.getPoint(), node.getParent());
        if (oldPosition.equals(newPosition)) {
            return;
        }
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(node, "Corner dragged");
        Polyline polyline = node.getPolyline();
        UpdatePolylineAction action = new UpdatePolylineAction(polyline, oldWayPoints, polyline.getWaypoints());
        compositeAction.put(action, node);
        mainFrame.handleActionEvent(compositeAction, node, "Corner dragged");
    }
}
