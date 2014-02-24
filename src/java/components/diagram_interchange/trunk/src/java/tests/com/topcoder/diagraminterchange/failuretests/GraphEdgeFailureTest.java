/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.failuretests;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for GraphEdge class.
 *
 * @author iamajia
 * @version 1.0
 */
public class GraphEdgeFailureTest extends TestCase {
    /**
     * Represents a {@link GraphEdge} instance that is used in the test.
     */
    private GraphEdge graphEdge = new GraphEdge();
    /**
     * Represents a way point that is used in the test.
     */
    private Point waypoint = new Point();
    /**
     * Represents a anchor that is used in the test.
     */
    private GraphConnector anchor = new GraphConnector();
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(GraphEdgeFailureTest.class);
    }

    /**
     * Failure test of <code>addWaypoint(Point waypoint)</code> method.
     *
     * <p>
     * waypoint is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddWaypoint1FailureNullWaypoint() throws Exception {
        try {
            graphEdge.addWaypoint(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }


    /**
     * Failure test of <code>addWaypoint(int index, Point waypoint)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddWaypoint2FailureNegativeIndex() throws Exception {
        try {
            graphEdge.addWaypoint(-1, waypoint);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addWaypoint(int index, Point waypoint)</code> method.
     *
     * <p>
     * index is greater than list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddWaypoint2FailureIndexGreaterThanSize() throws Exception {
        try {
            graphEdge.addWaypoint(1, waypoint);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addWaypoint(int index, Point waypoint)</code> method.
     *
     * <p>
     * waypoint is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddWaypoint2FailureNullWaypoint() throws Exception {
        try {
            graphEdge.addWaypoint(0, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>setWaypoint(int index, Point waypoint)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetWaypointFailureNegativeIndex() throws Exception {
        try {
            graphEdge.setWaypoint(-1, waypoint);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>setWaypoint(int index, Point waypoint)</code> method.
     *
     * <p>
     * index is equal to list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetWaypointFailureIndexEqualToSize() throws Exception {
        try {
            graphEdge.setWaypoint(0, waypoint);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>setWaypoint(int index, Point waypoint)</code> method.
     *
     * <p>
     * waypoint is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetWaypointFailureNullWaypoint() throws Exception {
        graphEdge.addWaypoint(waypoint);
        try {
            graphEdge.setWaypoint(0, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeWaypoint(int index)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveWaypointFailureNegativeIndex() throws Exception {
        try {
            graphEdge.removeWaypoint(-1);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeWaypoint(int index)</code> method.
     *
     * <p>
     * index is equal to list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveWaypointFailureIndexEqualToSize() throws Exception {
        try {
            graphEdge.removeWaypoint(0);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeWaypoint(Point waypoint)</code> method.
     *
     * <p>
     * waypoint is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveWaypointFailureNullWaypoint() throws Exception {
        try {
            graphEdge.removeWaypoint(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>containsWaypoint(Point waypoint)</code> method.
     *
     * <p>
     * waypoint is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsWaypointFailureNullWaypoint() throws Exception {
        try {
            graphEdge.containsWaypoint(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>indexOfWaypoint(Point waypoint)</code> method.
     *
     * <p>
     * waypoint is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIndexOfWaypointFailureNullWaypoint() throws Exception {
        try {
            graphEdge.containsWaypoint(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addAnchor(GraphConnector anchor)</code> method.
     *
     * <p>
     * anchor is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddAnchor1FailureNullAnchor() throws Exception {
        try {
            graphEdge.addAnchor(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }


    /**
     * Failure test of <code>addAnchor(int index, GraphConnector anchor)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddAnchor2FailureNegativeIndex() throws Exception {
        try {
            graphEdge.addAnchor(-1, anchor);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addAnchor(int index, GraphConnector anchor)</code> method.
     *
     * <p>
     * index is greater than list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddAnchor2FailureIndexGreaterThanSize() throws Exception {
        try {
            graphEdge.addAnchor(1, anchor);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addAnchor(int index, GraphConnector anchor)</code> method.
     *
     * <p>
     * anchor is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddAnchor2FailureNullAnchor() throws Exception {
        try {
            graphEdge.addAnchor(0, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>setAnchor(int index, GraphConnector anchor)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetAnchorFailureNegativeIndex() throws Exception {
        try {
            graphEdge.setAnchor(-1, anchor);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>setAnchor(int index, GraphConnector anchor)</code> method.
     *
     * <p>
     * index is equal to list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetAnchorFailureIndexEqualToSize() throws Exception {
        try {
            graphEdge.setAnchor(0, anchor);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>setAnchor(int index, GraphConnector anchor)</code> method.
     *
     * <p>
     * anchor is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetAnchorFailureNullAnchor() throws Exception {
        graphEdge.addAnchor(anchor);
        try {
            graphEdge.setAnchor(0, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeAnchor(int index)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveAnchorFailureNegativeIndex() throws Exception {
        try {
            graphEdge.removeAnchor(-1);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeAnchor(int index)</code> method.
     *
     * <p>
     * index is equal to list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveAnchorFailureIndexEqualToSize() throws Exception {
        try {
            graphEdge.removeAnchor(0);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeAnchor(GraphConnector anchor)</code> method.
     *
     * <p>
     * anchor is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveAnchorFailureNullAnchor() throws Exception {
        try {
            graphEdge.removeAnchor(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>containsAnchor(GraphConnector anchor)</code> method.
     *
     * <p>
     * anchor is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsAnchorFailureNullAnchor() throws Exception {
        try {
            graphEdge.containsAnchor(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>indexOfAnchor(GraphConnector anchor)</code> method.
     *
     * <p>
     * anchor is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIndexOfAnchorFailureNullAnchor() throws Exception {
        try {
            graphEdge.containsAnchor(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
