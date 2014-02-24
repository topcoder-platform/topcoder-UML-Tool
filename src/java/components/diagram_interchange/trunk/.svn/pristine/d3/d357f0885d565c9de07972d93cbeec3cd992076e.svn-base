/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ GraphEdgeAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;


/**
 * <p>
 * The <code>GraphEdge</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>GraphEdge</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class GraphEdgeAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>GraphEdge</code> used for tests.
     * </p>
     */
    private GraphEdge test = null;

    /**
     * <p>
     * Test suite of <code>GraphEdgeAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>GraphEdgeAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(GraphEdgeAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats a new instance of <code>GraphEdge</code>.
     * </p>
     */
    protected void setUp() {
        test = new GraphEdge();
    }

    /**
     * <p>
     * Accuracy Test of the <code>GraphEdge()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new GraphEdge());

        // get the original value of waypoints to check the constructor
        assertEquals("The waypoints expected to be empty", 0,
            test.countWaypoints());

        // get the original value of anchors to check the constructor
        assertEquals("The anchors expected to be empty", 0, test.countAnchors());
    }

    /**
     * <p>
     * Accuracy Test of the waypoints correlative method, such like :
     * <code>addWaypoint(Point)</code> method, <code>getWaypoints()</code> and also other method.
     * </p>
     */
    public void testWaypoints_Operation() {
        // creat some points.
        Point point1 = new Point();
        Point point2 = new Point();
        Point point3 = new Point();

        // add the points to the list.
        test.addWaypoint(point1);
        test.addWaypoint(1, point2);

        // get the index of the point.
        assertEquals("The point1 expected to at index 0", 0,
            test.indexOfWaypoint(point1));

        // check for contain.
        assertTrue("The point2 expected to be in the list",
            test.containsWaypoint(point2));

        // set the point to the list.
        test.setWaypoint(0, point3);

        // get the index of the point.
        assertEquals("The point3 expected to at index 0", 0,
            test.indexOfWaypoint(point3));

        // get a copy of the points list.
        List <Point> newWaypoints = test.getWaypoints();

        // get the elements of points list to test.
        assertEquals("The points list expected to be 2 element", 2,
            newWaypoints.size());
        assertTrue("The point3 expected to be in the list",
            newWaypoints.contains(point3));

        // clear the new list.
        newWaypoints.clear();

        // still two elements in points list.
        assertEquals("The points list expected to be 2 element", 2,
            test.countWaypoints());

        // check the removed point.
        assertEquals("The two points expected to be equal", point2,
            test.removeWaypoint(1));
        assertTrue("The point3 expected to be removed",
            test.removeWaypoint(point3));

        // non exist element can not be removed.
        assertFalse("The point2 can not be removed again",
            test.removeWaypoint(point2));

        // add the points to the list.
        test.addWaypoint(point1);
        test.clearWaypoints();
        assertEquals("The points list expected to be empty", 0,
            test.countWaypoints());
    }

    /**
     * <p>
     * Accuracy Test of the wayanchors correlative method, such like :
     * <code>addAnchor(GraphConnector)</code> method, <code>getAnchors()</code> and also other method.
     * </p>
     */
    public void testAnchors_Operation() {
        // creat some anchors.
        GraphConnector anchor1 = new GraphConnector();
        GraphConnector anchor2 = new GraphConnector();
        GraphConnector anchor3 = new GraphConnector();

        // add the anchors to the list.
        test.addAnchor(anchor1);
        test.addAnchor(1, anchor2);

        // get the index of the anchor.
        assertEquals("The anchor1 expected to at index 0", 0,
            test.indexOfAnchor(anchor1));

        // check for contain.
        assertTrue("The anchor2 expected to be in the list",
            test.containsAnchor(anchor2));

        // set the anchor to the list.
        test.setAnchor(0, anchor3);

        // get the index of the anchor.
        assertEquals("The anchor3 expected to at index 0", 0,
            test.indexOfAnchor(anchor3));

        // get a copy of the anchors list.
        List<GraphConnector> newAnchors = test.getAnchors();

        // get the elements of anchors list to test.
        assertEquals("The anchors list expected to be 2 element", 2,
            newAnchors.size());
        assertTrue("The anchor3 expected to be in the list",
            newAnchors.contains(anchor3));

        // clear the new list.
        newAnchors.clear();

        // still two elements in anchors list.
        assertEquals("The anchors list expected to be 2 element", 2,
            test.countAnchors());

        // check the removed anchor.
        assertEquals("The two anchors expected to be equal", anchor2,
            test.removeAnchor(1));
        assertTrue("The anchor3 expected to be removed",
            test.removeAnchor(anchor3));

        // non exist element can not be removed.
        assertFalse("The anchor2 can not be removed again",
            test.removeAnchor(anchor2));

        // add the anchors to the list.
        test.addAnchor(anchor1);
        test.clearAnchors();
        assertEquals("The anchors list expected to be empty", 0,
            test.countAnchors());
    }
}
