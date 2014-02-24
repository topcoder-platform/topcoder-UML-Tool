/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.accuracytests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;

import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;


/**
 * <p>
 * Test Helper for the component.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public final class TestHelper {
    /**
     * <p>
     * Private constructor to prevent instantiation.
     * </p>
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Creates an instance of <code>Edge</code> for accuracy tests.
     * </p>
     *
     * @return an instance of <code>Edge</code>.
     */
    public static Edge getEdge() {
        //GraphEdge graphEdge = new GraphEdge();
        /*
        Diagram diagram = new Diagram();
        diagram.setPosition(getWaypoint(5, 5));
        diagram.addContained(graphEdge);
        graphEdge.setContainer(diagram);
        graphEdge.addWaypoint(getWaypoint(-5, -5));
        graphEdge.addWaypoint(getWaypoint(5, 5));
        graphEdge.addWaypoint(getWaypoint(15, 5));
        graphEdge.addWaypoint(getWaypoint(25, -5));
        */
        LineStyle style = new LineStyle(5, 2);

        return new MockEdge(getGraphEdge(), style, null, null);
    }

    /**
     * <p>
     * Creates an instance of <code>GraphEdge</code> for accuracy tests.
     * </p>
     *
     * @return an instance of <code>GraphEdge</code>.
     */
    public static GraphEdge getGraphEdge() {
        GraphEdge graphEdge = new GraphEdge();
        graphEdge.addWaypoint(getWaypoint(0, 0));
        graphEdge.addWaypoint(getWaypoint(10, 10));
        graphEdge.addWaypoint(getWaypoint(20, 10));
        graphEdge.addWaypoint(getWaypoint(30, 0));
        graphEdge.setPosition(getWaypoint(0, 0));
        graphEdge.setContainer(null);

        return graphEdge;
    }

    /**
     * <p>
     * Creates an instance of <code>Point</code> with the given positions.
     * </p>
     *
     * @return an instance of <code>Point</code>.
     */
    public static Point getWaypoint(int x, int y) {
        Point point = new Point();
        point.setX(x);
        point.setY(y);

        return point;
    }
}
