/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Rectangle;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.connectors.RectangleConnector;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {
    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DemoTests.class);
    }

    /**
     * <p>
     * This method shows the usage of the edge in the normal scenario.
     * </p>
     */
    public void testAsDemo() {
        GraphEdge graphEdge = new GraphEdge();
        GraphNode graphNode = new GraphNode();
        Rectangle rectangle = new Rectangle();

        // add there waypoints
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));

        TriangleEdgeEnding triangleEdgeEnding = new TriangleEdgeEnding();
        // create an edge
        Edge edge = new GeneralizationEdge(graphEdge, triangleEdgeEnding);

        // register listeners to listen events
        WayPointListener wayPointListener = new SimpleWayPointListener();
        EdgeDragListener edgeDragListener = new SimpleEdgeDragListener();

        edge.addWayPointDragListener(wayPointListener);
        edge.addEdgeDragListener(edgeDragListener);

        // manipulate text fields
        // add a text field on the line
        edge.addTextField(graphNode, "class1->class2", AnchorType.Line);

        // remove a text field
        edge.removeTextField(graphNode);

        // use a connector
        edge.setLeftConnector(new RectangleConnector(rectangle));
    }
}
