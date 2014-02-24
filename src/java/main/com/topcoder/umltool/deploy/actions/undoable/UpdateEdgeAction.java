/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.uml.actions.general.UndoableAbstractAction;

/**
 * <p>
 * Action to update a polyline.
 * </p>
 * @author ly
 * @version 1.0
 */
public class UpdateEdgeAction extends UndoableAbstractAction {
    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Move Edge";

    /**
     * <p>
     * Edge to be moved.
     * </p>
     */
    private final Edge edge;

    /**
     * <p>
     * Old way points.
     * </p>
     */
    private List<Point> oldWayPoints = new ArrayList<Point>();

    /**
     * <p>
     * New way points.
     * </p>
     */
    private List<Point> newWayPoints = new ArrayList<Point>();

    /**
     * <p>
     * Creates an instance of <code>MoveEdgeAction</code>.
     * </p>
     * @param edge
     *            the edge to be moved
     * @param oldWayPoints
     *            old way points
     * @param newWayPoints
     *            new way points
     */
    public UpdateEdgeAction(Edge edge, List<Point> oldWayPoints, List<Point> newWayPoints) {
        super(PRESENTATION_NAME);
        this.edge = edge;
        cloneList(oldWayPoints, this.oldWayPoints);
        cloneList(newWayPoints, this.newWayPoints);
    }

    /**
     * <p>
     * Copy source list to destination list.
     * </p>
     * @param srcList
     *            source list
     * @param destList
     *            destination list
     */
    private static void cloneList(List<Point> srcList, List<Point> destList) {
        for (Point point : srcList) {
            Point newPoint = new Point();
            newPoint.setX(point.getX());
            newPoint.setY(point.getY());
            destList.add(newPoint);
        }
    }

    /**
     * <p>
     * Undo the action.
     * </p>
     */
    public void undoAction() {
        GraphEdge graphEdge = edge.getGraphEdge();
        graphEdge.clearWaypoints();
        for (Point wayPoint : oldWayPoints) {
            Point newPoint = new Point();
            newPoint.setX(wayPoint.getX());
            newPoint.setY(wayPoint.getY());
            graphEdge.addWaypoint(newPoint);
        }
        int count = edge.getWayPoints().size();
        for (int i = 0; i < count; i++) {
            java.awt.Point oldPoint = new java.awt.Point();
            oldPoint.x = (int) newWayPoints.get(i).getX();
            oldPoint.y = (int) newWayPoints.get(i).getY();
            edge.notifyChangeWayPoint(i, oldPoint);
        }
    }

    /**
     * <p>
     * Redo the action.
     * </p>
     */
    public void redoAction() {
        GraphEdge graphEdge = edge.getGraphEdge();
        graphEdge.clearWaypoints();
        for (Point wayPoint : newWayPoints) {
            Point newPoint = new Point();
            newPoint.setX(wayPoint.getX());
            newPoint.setY(wayPoint.getY());
            graphEdge.addWaypoint(newPoint);
        }
        int count = edge.getWayPoints().size();
        for (int i = 0; i < count; i++) {
            java.awt.Point oldPoint = new java.awt.Point();
            oldPoint.x = (int) oldWayPoints.get(i).getX();
            oldPoint.y = (int) oldWayPoints.get(i).getY();
            edge.notifyChangeWayPoint(i, oldPoint);
        }
    }

    /**
     * <p>
     * Execute the action.
     * </p>
     */
    public void executeAction() {
        redoAction();
    }
}
