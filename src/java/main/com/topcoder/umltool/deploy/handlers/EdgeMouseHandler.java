/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.uml.actions.general.ChangeRelationshipPathAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.UpdateDiagramAction;

/**
 * <p>
 * This handler will add a way point of an edge when it is dragged and released.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class EdgeMouseHandler extends MouseAdapter {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Represents the index for new way point.
     * </p>
     */
    private int index;

    /**
     * <p>
     * Represents the old way point count.
     * </p>
     */
    private int oldWayPointCount;

    /**
     * <p>
     * Creates an instance of <code>EdgeMouseHandler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public EdgeMouseHandler(MainFrame mainframe) {
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
        Edge edge = (Edge) e.getSource();
        index = HandlerHelper.findInsertIndex(edge, e.getPoint());
        oldWayPointCount = edge.getWayPoints().size();
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
        Edge edge = (Edge) e.getSource();

        int newWayPointCount = edge.getWayPoints().size();
        if (oldWayPointCount != newWayPointCount - 1 || index <= 0 || index >= newWayPointCount - 1) {
            return;
        }
        GraphEdge graphEdge = edge.getGraphEdge();
        graphEdge.removeWaypoint(index);
        List<Point> newWayPoints = graphEdge.getWaypoints();
        newWayPoints.add(index, DeployHelper.createPoint(e.getPoint()));
        UpdateDiagramAction compositeAction = new UpdateDiagramAction((DiagramView) edge.getParent(),
                "action to add way point wrapped");
        ChangeRelationshipPathAction action = new ChangeRelationshipPathAction(graphEdge, newWayPoints);
        compositeAction.put(action, edge);
        mainFrame.handleActionEvent(compositeAction, edge, "way point added");
    }
}
