/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Point;
import java.io.File;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for WayPointEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class WayPointEventTests extends TestCase {
    /**
     * <p>
     * Edge instance for helping testing.
     * </p>
     */
    private Edge edge;

    /**
     * <p>
     * The offset point for helping testing.
     * </p>
     */
    private Point offset;

    /**
     * <p>
     * The position of the way point for helping testing.
     * </p>
     */
    private Point wayPoint;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "DiagramViewer.xml");

        offset = new Point(50, 60);
        edge = TestHelper.createEdge();
        wayPoint = new Point(120, 100);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();

        offset = null;
        edge = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(WayPointEventTests.class);
    }

    /**
     * <p>
     * Tests ctor WayPointEvent#WayPointEvent(Edge,Point,Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created WayPointEvent instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new WayPointEvent instance.", new WayPointEvent(edge, wayPoint, offset));
    }

    /**
     * <p>
     * Tests ctor WayPointEvent#WayPointEvent(Edge,Point,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when edge is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullEdge() {
        try {
            new WayPointEvent(null, wayPoint, offset);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor WayPointEvent#WayPointEvent(Edge,Point,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newWayPoint is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullNewWayPoint() {
        try {
            new WayPointEvent(edge, null, offset);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor WayPointEvent#WayPointEvent(Edge,Point,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when offset is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullOffset() {
        try {
            new WayPointEvent(edge, wayPoint, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor WayPointEvent#WayPointEvent(Edge,int,Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created WayPointEvent instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new WayPointEvent instance.", new WayPointEvent(edge, 0, offset));
    }

    /**
     * <p>
     * Tests ctor WayPointEvent#WayPointEvent(Edge,int,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when edge is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullEdge() {
        try {
            new WayPointEvent(null, 0, offset);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor WayPointEvent#WayPointEvent(Edge,int,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when index is negative and expects IndexOutOfBoundsException.
     * </p>
     */
    public void testCtor2_NegativeIndex() {
        try {
            new WayPointEvent(edge, -8, offset);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor WayPointEvent#WayPointEvent(Edge,int,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when index is larger than the size of waypoints and expects IndexOutOfBoundsException.
     * </p>
     */
    public void testCtor2_TooLargeIndex() {
        try {
            new WayPointEvent(edge, 49, offset);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor WayPointEvent#WayPointEvent(Edge,int,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when offset is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullOffset() {
        try {
            new WayPointEvent(edge, 0, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests WayPointEvent#getOldPosition() for accuracy.
     * </p>
     *
     * <p>
     * Verify : WayPointEvent#getOldPosition() is correct.
     * </p>
     */
    public void testGetOldPosition1() {
        WayPointEvent event = new WayPointEvent(edge, wayPoint, offset);

        Point pt = event.getOldPosition();

        assertEquals("Failed to get the correct old position.", wayPoint, pt);

        // verify the point should be set by clone
        pt.x = 876;
        assertEquals("The old position getter should return a cloned point.", wayPoint, event.getOldPosition());

        pt = new Point(wayPoint);
        wayPoint.x = 987;
        assertEquals("The old position should be set by clone in constructor.", pt, event.getOldPosition());
    }

    /**
     * <p>
     * Tests WayPointEvent#getOldPosition() for accuracy.
     * </p>
     *
     * <p>
     * Verify : WayPointEvent#getOldPosition() is correct.
     * </p>
     */
    public void testGetOldPosition2() {
        WayPointEvent event = new WayPointEvent(edge, 0, offset);

        Point expectedOldPosition = edge.getWayPoints().get(0).getCenter();
        Point pt = event.getOldPosition();

        assertEquals("Failed to get the correct old position.", expectedOldPosition, pt);

        // verify the point should be set by clone
        pt.x = 876;
        assertEquals("The old position getter should return a cloned point.", expectedOldPosition,
            event.getOldPosition());
    }

    /**
     * <p>
     * Tests WayPointEvent#getNewPosition() for accuracy.
     * </p>
     *
     * <p>
     * Verify : WayPointEvent#getNewPosition() is correct.
     * </p>
     */
    public void testGetNewPosition1() {
        WayPointEvent event = new WayPointEvent(edge, wayPoint, offset);

        assertEquals("Failed to get the correct new position.", new Point(170, 160), event.getNewPosition());
    }

    /**
     * <p>
     * Tests WayPointEvent#getNewPosition() for accuracy.
     * </p>
     *
     * <p>
     * Verify : WayPointEvent#getNewPosition() is correct.
     * </p>
     */
    public void testGetNewPosition2() {
        WayPointEvent event = new WayPointEvent(edge, 0, offset);

        Point pt = edge.getWayPoints().get(0).getCenter();
        assertEquals("Failed to get the correct new position.", new Point(50 + pt.x, 60 + pt.y),
            event.getNewPosition());
    }

    /**
     * <p>
     * Tests WayPointEvent#getOffset() for accuracy.
     * </p>
     *
     * <p>
     * Verify : WayPointEvent#getOffset() is correct.
     * </p>
     */
    public void testGetOffset1() {
        WayPointEvent event = new WayPointEvent(edge, wayPoint, offset);

        Point pt = event.getOffset();

        assertEquals("Failed to get the correct offset.", offset, pt);

        // verify the point should be set by clone
        pt.x = 876;
        assertEquals("The offset getter should return a cloned point.", offset, event.getOffset());

        pt = new Point(offset);
        offset.x = 234;
        assertEquals("The offset should be set by clone in constructor.", pt, event.getOffset());
    }

    /**
     * <p>
     * Tests WayPointEvent#getOffset() for accuracy.
     * </p>
     *
     * <p>
     * Verify : WayPointEvent#getOffset() is correct.
     * </p>
     */
    public void testGetOffset2() {
        WayPointEvent event = new WayPointEvent(edge, 0, offset);

        Point pt = event.getOffset();

        assertEquals("Failed to get the correct offset.", offset, pt);

        // verify the point should be set by clone
        pt.x = 876;
        assertEquals("The offset getter should return a cloned point.", offset, event.getOffset());

        pt = new Point(offset);
        offset.x = 234;
        assertEquals("The offset should be set by clone in constructor.", pt, event.getOffset());
    }

    /**
     * <p>
     * Tests WayPointEvent#getIndex() for accuracy.
     * </p>
     *
     * <p>
     * Verify : WayPointEvent#getIndex() is correct.
     * </p>
     */
    public void testGetIndex1() {
        WayPointEvent event = new WayPointEvent(edge, wayPoint, offset);

        assertEquals("The index should be -1.", -1, event.getIndex());
    }

    /**
     * <p>
     * Tests WayPointEvent#getIndex() for accuracy.
     * </p>
     *
     * <p>
     * Verify : WayPointEvent#getIndex() is correct.
     * </p>
     */
    public void testGetIndex2() {
        WayPointEvent event = new WayPointEvent(edge, 0, offset);

        assertEquals("The index should be 0.", 0, event.getIndex());
    }
}