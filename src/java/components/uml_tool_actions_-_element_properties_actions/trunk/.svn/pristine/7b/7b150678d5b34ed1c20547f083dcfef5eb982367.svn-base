/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import java.util.Iterator;
import java.util.List;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the path of a graph
 * edge.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the
 * action, undo to undo the action and execute to execute the action. If any exception prevents
 * redo/undo methods from completing successfully, it should be log with logError.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, rainday
 * @version 1.0
 */
public class ChangeRelationshipPathAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the edge to change the path. This variable is set in the constructor, is immutable
     * (the reference) and never be null. This variable is referenced in the redoAction undoAction
     * and executeAction methods.
     * </p>
     */
    private final GraphEdge edge;

    /**
     * <p>
     * Represents the new waypoints of the edge after this action performed. This variable is set in
     * the constructor, is immutable (the reference) and it will never contain null element. This
     * variable is referenced in the redoAction and executeAction methods.
     * </p>
     */
    private final List<Point> newWaypoints;

    /**
     * <p>
     * Represents the old waypoints of the edge before this action performed. This variable is set
     * in the constructor, is immutable (the reference). This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final List<Point> oldWaypoints;

    /**
     * <p>
     * Constructor of the change relationship path action.
     * </p>
     *
     * @param edge
     *        the non null edge to change the path
     * @param waypoints
     *        the non null new waypoints, it can't contain null.
     * @throws IllegalArgumentException
     *         if edge is null, waypoints is null or it contains null.
     */
    public ChangeRelationshipPathAction(GraphEdge edge, List<Point> waypoints) {
        super("Change relationship path");
        Helper.checkNotNull(edge, "edge");
        Helper.checkNotNullAndNotContainsNull(waypoints, "waypoints");
        this.edge = edge;
        oldWaypoints = edge.getWaypoints();
        newWaypoints = waypoints;
    }

    /**
     * <p>
     * Redo the change relationship path action.
     * </p>
     */
    public void redoAction() {
        edge.clearWaypoints();
        Iterator<Point> iter = newWaypoints.iterator();
        while (iter.hasNext()) {
            edge.addWaypoint(iter.next());
        }
    }

    /**
     * <p>
     * Execute the change relationship path action.
     * </p>
     */
    public void executeAction() {
        redoAction();
    }

    /**
     * <p>
     * Undo the change relationship path action.
     * </p>
     */
    public void undoAction() {
        edge.clearWaypoints();
        Iterator<Point> iter = oldWaypoints.iterator();
        while (iter.hasNext()) {
            edge.addWaypoint(iter.next());
        }
    }
}
