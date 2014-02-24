/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Action to update a polyline.
 * </p>
 * @author ly
 * @version 1.0
 */
public class UpdatePolylineAction extends UndoableAbstractAction {
    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Update Polyline";

    /**
     * <p>
     * Polyline to be updated.
     * </p>
     */
    private final Polyline polyline;

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
     * Creates an instance of <code>UpdatePolylineAction</code>.
     * </p>
     * @param polyline
     *            the polyline to be updated
     * @param oldWayPoints
     *            old way points
     * @param newWayPoints
     *            new way points
     */
    public UpdatePolylineAction(Polyline polyline, List<Point> oldWayPoints, List<Point> newWayPoints) {
        super(PRESENTATION_NAME);
        this.polyline = polyline;
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
        polyline.clearWaypoints();
        for (Point wayPoint : oldWayPoints) {
            polyline.addWaypoint(wayPoint);
        }
    }

    /**
     * <p>
     * Redo the action.
     * </p>
     */
    public void redoAction() {
        polyline.clearWaypoints();
        for (Point wayPoint : newWayPoints) {
            polyline.addWaypoint(wayPoint);
        }
    }

    /**
     * <p>
     * Execute the action.
     * </p>
     * @throws ActionExecutionException
     *             if fail to execute action
     */
    public void executeAction() throws ActionExecutionException {
        redoAction();
    }

}
