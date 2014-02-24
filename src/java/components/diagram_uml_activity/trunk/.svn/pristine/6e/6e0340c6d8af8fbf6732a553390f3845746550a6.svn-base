/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Point;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.Connector;

/**
 * <p>
 * This class is the connector used to connect to a <code>Node</code> whose shape is ellipse (<code>InitialNode</code>,
 * <code>FinalNode</code>, <code>FlowFinalNode</code> in this package).
 * </p>
 * <p>
 * Thread safety: This class is immutable, and thread-safe.
 * </p>
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class EllipseConnector implements Connector {
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
     * Creates an instance of <code>EllipseConnector</code>.
     * </p>
     */
    public EllipseConnector() {
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
        double a = graphNode.getSize().getWidth() / 2;
        double b = graphNode.getSize().getHeight() / 2;
        double c = Math.sqrt(a * a - b * b);
        Point origin = new Point(position.x + (int) Math.round(a), position.y + (int) Math.round(b));
        Point connectionPoint = getNearestPointAtEllipse(new Point(wayPoint.x - origin.x, wayPoint.y - origin.y), a, b,
                c);
        // Move coordinate axis back
        connectionPoint.x += origin.x;
        connectionPoint.y += origin.y;
        return connectionPoint;
    }

    /**
     * <p>
     * Gets given point's nearest point at given ellipse defined by x*x/(a*a)+y*y/(b*b)=1.
     * </p>
     * @param wayPoint
     *            the nearest way point of edge
     * @param a
     *            ellipse parameter
     * @param b
     *            ellipse parameter
     * @param c
     *            ellipse parameter, c*c = a*a - b*b
     * @return the nearest point
     */
    private Point getNearestPointAtEllipse(Point wayPoint, double a, double b, double c) {
        Point connectionPoint;
        double x0 = wayPoint.x;
        double y0 = wayPoint.y;
        // Reflect given point to the first quadrant
        if (x0 < 0) {
            x0 = -x0;
        }
        if (y0 < 0) {
            y0 = -y0;
        }
        // (x, y) is the nearest point of (x0, y0)
        double x = (a * a * y0 * y0 * c + a * b * b * (x0 - c) * Math.sqrt((x0 - c) * (x0 - c) + y0 * y0))
                / (b * b * (x0 - c) * (x0 - c) + a * a * y0 * y0);
        double y = b * Math.sqrt(1 - x * x / (a * a));
        // Reflect the nearest point back to the original quadrant
        if (wayPoint.x < 0) {
            x = -x;
        }
        if (wayPoint.y < 0) {
            y = -y;
        }
        connectionPoint = new Point(Math.round((float) x), Math.round((float) y));
        return connectionPoint;
    }
}
