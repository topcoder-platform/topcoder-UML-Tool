/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.EdgeDragListener;
import com.topcoder.gui.diagramviewer.edges.WayPointEvent;
import com.topcoder.uml.actions.general.ChangeRelationshipPathAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This handler will change or add a way point of an edge when it is dragged.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class EdgeDragHandler extends WayPointHandler implements EdgeDragListener {
    /**
     * <p>
     * Creates an instance of <code>EdgeDragHandler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public EdgeDragHandler(MainFrame mainframe) {
        super(mainframe);
    }

    /**
     * <p>
     * Processes the edge dragged event.
     * </p>
     * @param e
     *            a WayPointEvent instance used to indicate the edge drag event
     */
    public void edgeDragged(WayPointEvent e) {
        if (e == null) {
            return;
        }
        Edge edge = (Edge) e.getSource();
        int index = e.getIndex();
        if (index == -1) {
            // When a way point has been added, its index should be used
            index = HandlerHelper.findIndex(edge, e.getOldPosition());
        }
        if (index == 0 || index == edge.getWayPoints().size() - 1) {
            return;
        }
        if (index == -1) {
            dragEdge(edge, e.getOldPosition(), e.getNewPosition());
        } else {
            dragEdge(edge, index, e.getOffset());
        }
    }

    /**
     * <p>
     * Drags an edge. This will insert a new way point at new position.
     * </p>
     * @param edge
     *            edge dragged
     * @param oldPosition
     *            old position dragging from
     * @param newPosition
     *            new position dragging to
     */
    private void dragEdge(Edge edge, Point oldPosition, Point newPosition) {
        GraphEdge graphEdge = edge.getGraphEdge();
        List<com.topcoder.diagraminterchange.Point> newWayPoints = new ArrayList<com.topcoder.diagraminterchange.Point>(
                graphEdge.getWaypoints());
        // to add a new way point, find its suitable index first
        int index = HandlerHelper.findInsertIndex(edge, oldPosition);
        if (index <= 0 || index >= edge.getWayPoints().size()) {
            return;
        }
        // insert new way point
        newWayPoints.add(index, DeployHelper.createPoint(newPosition));

        ChangeRelationshipPathAction action = new ChangeRelationshipPathAction(graphEdge, newWayPoints);
        action.executeAction();
        DeployHelper.updateEdgeWayPoint(edge, mainFrame);
    }

}
