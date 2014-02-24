/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.List;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.SelectionCorner;
import com.topcoder.uml.actions.general.ChangeRelationshipPathAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.UpdateDiagramAction;

/**
 * <p>
 * This handler will move a way point of an edge when it is dragged and released.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class WayPointMouseHanler extends MouseAdapter {
    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Represents the index for moved way point.
     * </p>
     */
    private int index;

    /**
     * <p>
     * Represents the old position for moved way point.
     * </p>
     */
    private Point oldPosition = new Point();

    /**
     * <p>
     * Creates an instance of <code>WayPointMouseHanler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public WayPointMouseHanler(MainFrame mainframe) {
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
        Edge edge = (Edge) corner.getParent();
        index = edge.getWayPoints().indexOf(corner);
        oldPosition.setX(edge.getGraphEdge().getWaypoints().get(index).getX());
        oldPosition.setY(edge.getGraphEdge().getWaypoints().get(index).getY());
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
        Edge edge = (Edge) corner.getParent();
        int size = edge.getWayPoints().size();
        if (index <= 0 || index >= size - 1) {
            return;
        }
        java.awt.Point point = e.getPoint();
        point.x += corner.getX();
        point.y += corner.getY();
        java.awt.Point prev = edge.getWayPoints().get(index - 1).getCenter();
        java.awt.Point next = edge.getWayPoints().get(index + 1).getCenter();
        if (HandlerHelper.isAboveEdge(point, edge, new Line2D.Double(prev, next))) {
            removeWayPoint(edge);
        } else {
            moveWayPoint(edge, point);
        }
    }

    /**
     * <p>
     * Removes a way point to a new position.
     * </p>
     * @param edge
     *            the edge containing removed way point
     */
    private void removeWayPoint(Edge edge) {
        GraphEdge graphEdge = edge.getGraphEdge();
        graphEdge.getWaypoints().get(index).setX(oldPosition.getX());
        graphEdge.getWaypoints().get(index).setY(oldPosition.getY());
        List<Point> newWayPoints = graphEdge.getWaypoints();
        newWayPoints.remove(index);
        ChangeRelationshipPathAction action = new ChangeRelationshipPathAction(graphEdge, newWayPoints);
        mainFrame.handleActionEvent(action, edge, "way point removed");
    }

    /**
     * <p>
     * Moves a way point to a new position.
     * </p>
     * @param edge
     *            the edge containing moved way point
     * @param position
     *            new position for way point
     */
    private void moveWayPoint(Edge edge, java.awt.Point position) {
        GraphEdge graphEdge = edge.getGraphEdge();
        graphEdge.getWaypoints().get(index).setX(oldPosition.getX());
        graphEdge.getWaypoints().get(index).setY(oldPosition.getY());
        List<Point> newWayPoints = graphEdge.getWaypoints();
        Point newPosition = new Point();
        newPosition.setX(position.x);
        newPosition.setY(position.y);
        newWayPoints.set(index, newPosition);
        UpdateDiagramAction compositeAction = new UpdateDiagramAction((DiagramView) edge.getParent(),
                "action to move way point wrapped");
        ChangeRelationshipPathAction action = new ChangeRelationshipPathAction(graphEdge, newWayPoints);
        compositeAction.put(action, edge);
        mainFrame.handleActionEvent(compositeAction, edge, "way point moved");
    }
}
