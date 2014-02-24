/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Point;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.Connector;

/**
 * <p>
 * This class is the connector used to connect to a <code>Node</code> whose shape is rectangle.
 * </p>
 * <p>
 * Thread safety: This class is immutable, and thread-safe.
 * </p>
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class RectangleConnector implements Connector {

    /**
     * <p>
     * Represents the node containing this connector.
     * </p>
     * <p>
     * It can be accessed by setter and getter. It can never be null.
     * </p>
     */
    private BaseNode parent;

    /**
     * <p>
     * Creates an instance of <code>RectangleConnector</code>.
     * </p>
     */
    public RectangleConnector() {
    }

    /**
     * <p>
     * Sets this connector's parent node.
     * </p>
     * @param parent
     *            the node containing this connector
     * @throws IllegalArgumentException
     *             if parent is null
     */
    protected void setParent(BaseNode parent) {
        Util.checkNotNull(parent, "parent");
        this.parent = parent;
    }

    /**
     * <p>
     * Implements the <code>getConnectionPoint</code> method in Connector interface.
     * </p>
     * @param wayPoint
     *            the nearest way point of edge
     * @return the target connection point
     * @throws IllegalArgumentException
     *             if given wayPoint is null
     * @throws IllegalStateException
     *             if parent is null
     */
    public Point getConnectionPoint(Point wayPoint) {
        Util.checkNotNull(wayPoint, "wayPoint");
        if (parent == null) {
            throw new IllegalStateException("Parent of this connector should be set first.");
        }
        GraphNode graphNode = parent.getGraphNode();
        Point position = Util.getGraphNodePosition(graphNode);
        double width = graphNode.getSize().getWidth();
        double height = graphNode.getSize().getHeight();
        /*
         * BugFix: BUGID UML-7180
         * Description:
         * This method assigns the argument point reference to the returned point, this causes problems.
         * It should create a new point instance for the returned point.
         * Solution:
         * Code is modified to create a new point instance for the returned point.
         */
        // old code
//        Point connectionPoint = wayPoint;
        Point connectionPoint = new Point(wayPoint);
        if (wayPoint.x < position.x) {
            connectionPoint.x = position.x;
        } else if (wayPoint.x > position.x + width) {
            connectionPoint.x = position.x + (int) Math.round(width);
        }
        if (wayPoint.y < position.y) {
            connectionPoint.y = position.y;
        } else if (wayPoint.y > position.y + height) {
            connectionPoint.y = position.y + (int) Math.round(height);
        }
        return connectionPoint;
    }
}
