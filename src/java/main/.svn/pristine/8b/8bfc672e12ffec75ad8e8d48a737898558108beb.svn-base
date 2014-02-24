/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdatePolylineAction;

/**
 * <p>
 * This handler will move a node when it is dragged and released.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class PolylineMouseHandler extends MouseAdapter {
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
    private Point oldPosition;

    /**
     * <p>
     * Represents the old Z order for dragged node.
     * </p>
     */
    private int oldZOrder;

    /**
     * <p>
     * Creates an instance of <code>PolylineMouseHandler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    public PolylineMouseHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Handles the <b>MOUSE_PRESSED</b> event.
     * </p>
     * <p>
     * When mouse pressed on edge, calculate the index for a new way point.
     * </p>
     * @param e
     *            the mouse pressed event
     */
    public void mousePressed(MouseEvent e) {
        if (e == null) {
            return;
        }
        PolylineNode node = (PolylineNode) e.getSource();
        oldPosition = SwingUtilities.convertPoint(node, e.getPoint(), node.getParent());
        oldZOrder = node.getParent().getComponentZOrder(node);
    }

    /**
     * <p>
     * Handles the <b>MOUSE_RELEASED</b> event.
     * </p>
     * <p>
     * When mouse is released, create an action for a way point adding, and pass it to event manager.
     * </p>
     * @param e
     *            the mouse pressed event
     */
    public void mouseReleased(MouseEvent e) {
        if (e == null) {
            return;
        }
        PolylineNode node = (PolylineNode) e.getSource();
        DiagramView view = (DiagramView) node.getParent();

        Point newPositon = SwingUtilities.convertPoint(node, e.getPoint(), view);
        if (!oldPosition.equals(newPositon)) {
            Polyline polyline = node.getPolyline();
            int xOff = newPositon.x - oldPosition.x;
            int yOff = newPositon.y - oldPosition.y;
            List<com.topcoder.diagraminterchange.Point> oldWayPoints = new ArrayList<com.topcoder.diagraminterchange.Point>();
            for (com.topcoder.diagraminterchange.Point point : polyline.getWaypoints()) {
                com.topcoder.diagraminterchange.Point newPoint = new com.topcoder.diagraminterchange.Point();
                newPoint.setX(point.getX() - xOff);
                newPoint.setY(point.getY() - yOff);
                oldWayPoints.add(newPoint);
            }
            UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(node, "Node moved");
            UpdatePolylineAction action = new UpdatePolylineAction(polyline, oldWayPoints, polyline.getWaypoints());
            compositeAction.put(action, node);
            mainFrame.handleActionEvent(compositeAction, node, "node moved");
        }
        view.setComponentZOrder(node, oldZOrder);
    }
}
