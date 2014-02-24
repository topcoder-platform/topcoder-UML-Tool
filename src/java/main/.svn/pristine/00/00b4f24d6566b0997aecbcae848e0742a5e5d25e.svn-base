/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JViewport;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.WayPointEvent;
import com.topcoder.gui.diagramviewer.edges.WayPointListener;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.uml.actions.general.ChangeRelationshipPathAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This handler will change or remove a way point of an edge when it is dragged.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class WayPointHandler implements WayPointListener {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    protected final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>WayPointHandler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public WayPointHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Handles the way point dragged event.
     * </p>
     * @param e
     *            a WayPointEvent instance used to indicate the way point drag event.
     */
    public void wayPointDragged(WayPointEvent e) {
        if (e == null) {
            return;
        }
        Edge edge = (Edge) e.getSource();
        //if (e.getIndex() <= 0 || e.getIndex() >= edge.getWayPoints().size() - 1) {
        //    return;
        //}
        dragEdge(edge, e.getIndex(), e.getOffset());
    }

    /**
     * <p>
     * Drags an edge. This will change an old way point's position.
     * </p>
     * @param edge
     *            edge dragged
     * @param index
     *            the changed way point index
     * @param offset
     *            changed offset
     */
    protected void dragEdge(Edge edge, int index, Point offset) {
        GraphEdge graphEdge = edge.getGraphEdge();
        double x = graphEdge.getWaypoints().get(index).getX();
        double y = graphEdge.getWaypoints().get(index).getY();
        List<com.topcoder.diagraminterchange.Point> newWayPoints = new ArrayList<com.topcoder.diagraminterchange.Point>(
                graphEdge.getWaypoints());
        // modify the way point
        com.topcoder.diagraminterchange.Point newPosition = new com.topcoder.diagraminterchange.Point();
        newPosition.setX(x + offset.x);
        newPosition.setY(y + offset.y);
        newWayPoints.set(index, newPosition);

        // auto scroll
        DiagramView view = (DiagramView) edge.getParent();

        ZoomPane zoomPane = (ZoomPane) view.getParent();
        JViewport viewport = (JViewport) zoomPane.getParent();
        Point viewPos = viewport.getViewPosition();
        int viewHeight = viewport.getExtentSize().height;
        int viewWidth = viewport.getExtentSize().width;

        int xscroll = 0, yscroll = 0;

        // perform scrolling
        if (((newPosition.getY()- viewPos.y < 0) && (offset.y < 0))
                || ((viewPos.y + viewHeight - newPosition.getY() < 15) && (offset.y > 0))) {
            yscroll = offset.y;
        }
        if (((newPosition.getX() - viewPos.x < 0) && (offset.x < 0))
                || ((viewPos.x + viewWidth - newPosition.getX() < 15) && (offset.x > 0))) {
            xscroll = offset.x;
        }

        if ((xscroll != 0) || (yscroll != 0)) {
            viewport.setViewPosition(new Point(viewPos.x + xscroll, viewPos.y + yscroll));
            if ((viewPos.x + offset.x < 0) || (viewPos.y + offset.y < 0)
                    || (viewPos.x + offset.x > view.getWidth() + 40 - viewWidth)
                    || (viewPos.y + offset.y > view.getHeight() + 40 - viewHeight)) { // resize diagram view
                Dimension size = new Dimension();
                size.setWidth(view.getWidth() + Math.abs(xscroll));
                size.setHeight(view.getHeight() + Math.abs(yscroll));
                view.getDiagram().setSize(size);

                DeployHelper.resizeDiagramView(view);
            }
        }

        ChangeRelationshipPathAction action = new ChangeRelationshipPathAction(graphEdge, newWayPoints);
        action.executeAction();
        DeployHelper.updateEdgeWayPoint(edge, mainFrame);
    }
}
