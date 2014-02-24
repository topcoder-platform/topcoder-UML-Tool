/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.umltool.deploy.handlers;

import java.awt.Component;
import java.awt.Point;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ResizeEvent;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ResizeListener;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.Lifeline;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Implementation the ResizeListener interface. This class is registered to listen to the resize action on object node
 * </p>
 * <p>
 * Resizes objectNode and updated connected edges connected to it.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ObjectNodeResizeHandler implements ResizeListener {
    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of ObjectNodeResizeHandler.
     * </p>
     * @param mainFrame
     *            main frame of the uml tool
     */
    public ObjectNodeResizeHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Does the actions when the node requests resizing.
     * </p>
     * @param event
     *            The instance of the ResizeEvent class.
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public void resizeNeeded(ResizeEvent event) {
        DeployHelper.checkNotNull(event, "event");

        ObjectNode node = event.getNode();
        node.setSize(node.getPreferredSize(node.getName(), node.getIsNameVisible(), node.getIsStereotypesVisible()));
        node.notifyGraphNodeChange("Resize");
        Map<Edge, Integer> edgeIndexMap = DeployHelper.getConnectedEdges(node);
        for (Edge edge : edgeIndexMap.keySet()) {
            GraphEdge graphEdge = edge.getGraphEdge();
            int index = edgeIndexMap.get(edge);
            java.awt.Point oldWayPoint = edge.getWayPoints().get(index).getCenter();
            java.awt.Point newWayPoint = new Point(oldWayPoint);
            newWayPoint.x = node.getLocation().x + node.getSelectionBound().x + node.getSelectionBound().width / 2;
            graphEdge.getWaypoints().get(index).setX(newWayPoint.x);
            graphEdge.getWaypoints().get(index).setY(newWayPoint.y);
            edge.notifyChangeWayPoint(index, oldWayPoint);
            edge.repaint();
        }

        Component[] components = node.getComponents();
        for (Component component : components) {
            if (component instanceof Lifeline) {
                Lifeline lifeline = (Lifeline) component;
                lifeline.getGraphEdge().getWaypoints().get(0).setX(node.getWidth() / 2);
                lifeline.getGraphEdge().getWaypoints().get(1).setX(node.getWidth() / 2);
            } else if (component instanceof LifelineSegment) {
                LifelineSegment lifelineSegment = (LifelineSegment) component;
                lifelineSegment.setLocation(node.getWidth() / 2 - (int) lifelineSegment.getSelectionBound().getWidth()
                        / 2, lifelineSegment.getY());
            }
        }

        HandlerHelper.updatePanels(node, mainFrame);
    }

}
