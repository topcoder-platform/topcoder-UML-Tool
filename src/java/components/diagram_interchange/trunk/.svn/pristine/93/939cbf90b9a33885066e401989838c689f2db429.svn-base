/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.failuretests;

import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for Polyline class.
 *
 * @author iamajia
 * @version 1.0
 */
public class PolylineFailureTest extends TestCase {
    /**
     * Represents a {@link Polyline} instance that is used in the test.
     */
    private Polyline polyline = new Polyline();
    /**
     * Represents a way point that is used in the test.
     */
    private Point waypoint = new Point();
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(PolylineFailureTest.class);
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
            polyline.addWaypoint(null);
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
            polyline.addWaypoint(-1, waypoint);
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
            polyline.addWaypoint(1, waypoint);
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
            polyline.addWaypoint(0, null);
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
            polyline.setWaypoint(-1, waypoint);
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
            polyline.setWaypoint(0, waypoint);
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
        polyline.addWaypoint(waypoint);
        try {
            polyline.setWaypoint(0, null);
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
            polyline.removeWaypoint(-1);
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
            polyline.removeWaypoint(0);
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
            polyline.removeWaypoint(null);
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
            polyline.containsWaypoint(null);
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
            polyline.containsWaypoint(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
