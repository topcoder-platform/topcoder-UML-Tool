/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ PolylineAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;


/**
 * <p>
 * The <code>Polyline</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>Polyline</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class PolylineAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>Polyline</code> used for tests.
     * </p>
     */
    private Polyline test = null;

    /**
     * <p>
     * Test suite of <code>PolylineAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>PolylineAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(PolylineAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats a new instance of <code>Polyline</code>.
     * </p>
     */
    protected void setUp() {
        test = new Polyline();
    }

    /**
     * <p>
     * Accuracy Test of the <code>Polyline()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new Polyline());

        // get the original value of closed to check the constructor
        assertFalse("The closed expected to be false", test.isClosed());

        // get the original value of waypoints to check the constructor
        assertEquals("The waypoints expected to be empty", 0,
            test.countWaypoints());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setClosed(boolean)</code> method and
     * <code>isClosed()</code>.
     * </p>
     */
    public void testClosed_Operation() {
        // set to true.
        test.setClosed(true);

        // get the isClosed.
        assertTrue("The isClosed expected to be true", test.isClosed());
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
        List<Point> newWaypoints = test.getWaypoints();

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
}
