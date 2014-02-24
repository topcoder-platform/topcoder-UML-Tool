/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.stresstests;

import java.awt.Rectangle;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.EdgeDragListener;
import com.topcoder.gui.diagramviewer.edges.WayPointListener;
import com.topcoder.gui.diagramviewer.edges.connectors.RectangleConnector;

import junit.framework.TestCase;

/**
 * Stress test for <code>Edge</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class EdgeStressTests extends TestCase {

    /**
     * Stress test for <code>Edge</code> class.
     */
    public void testEdgeStress() {
        // record the start time
        TestHelper.startTimer();

        for (int i = 0; i < TestHelper.NUMBER; i++) {

            GraphEdge graphEdge = new GraphEdge();
            GraphNode graphNode = new GraphNode();
            Rectangle rectangle = new Rectangle();

            // add there waypoints
            Point point1 = new Point();
            point1.setX(100);
            point1.setY(100);
            Point point2 = new Point();
            point2.setX(200);
            point2.setY(200);
            Point point3 = new Point();
            point3.setX(300);
            point3.setY(400);
            graphEdge.addWaypoint(point1);
            graphEdge.addWaypoint(point2);
            graphEdge.addWaypoint(point3);

            // create an edge
            Edge edge = new GeneralizationEdge(graphEdge);

            // get all waypoints
            edge.getWayPoints();

            // notify way point change
            edge.notifyAddWayPoint(0);
            edge.notifyChangeWayPoint(1, new java.awt.Point(200, 200));
            edge.notifyRemoveWayPoint(2, new java.awt.Point(300, 400));

            WayPointListener wayPointListener = new MockWayPointListener();
            EdgeDragListener edgeDragListener = new MockEdgeDragListener();

            // register listeners to listen events
            edge.addWayPointDragListener(wayPointListener);
            edge.addEdgeDragListener(edgeDragListener);

            // remove listeners
            edge.removeWayPointDragListener(wayPointListener);
            edge.removeEdgeDragListener(edgeDragListener);

            // add a text field on the line
            edge.addTextField(graphNode, "class1->class2", AnchorType.Line);

            // remove a text field
            edge.removeTextField(graphNode);

            // use a connector
            edge.setLeftConnector(new RectangleConnector(rectangle));
        }

        // print the result
        TestHelper.printResultMulTimes("Edge");
    }
}
