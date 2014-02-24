/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.connectors;

import java.awt.Point;
import java.awt.Rectangle;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for RectangleConnector.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RectangleConnectorTests extends TestCase {
    /**
     * <p>
     * RectangleConnector instance for testing.
     * </p>
     */
    private RectangleConnector connector;

    /**
     * <p>
     * Rectangle instance for helping testing.
     * </p>
     */
    private Rectangle rect;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        rect = new Rectangle(100, 100, 100, 100);
        connector = new RectangleConnector(rect);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        rect = null;
        connector = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(RectangleConnectorTests.class);
    }

    /**
     * <p>
     * Tests ctor RectangleConnector#RectangleConnector(Rectangle) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created RectangleConnector instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new RectangleConnector instance.", connector);

        // the rectangle should be cloned
        rect.x = 0;
        rect.y = 0;

        assertEquals("Failed to clone the rectangle", new Rectangle(100, 100, 100, 100), connector.getRectangle());
    }

    /**
     * <p>
     * Tests ctor RectangleConnector#RectangleConnector(Rectangle) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when rectangle is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullRectangle() {
        try {
            new RectangleConnector(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests RectangleConnector#getConnectionPoint(Point) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the way point is at the west side and verify the
     * connection point should be returned correctly.
     * </p>
     */
    public void testGetConnectionPoinWestSide() {
        Point pt = connector.getConnectionPoint(new Point(50, 150));

        assertEquals("Failed to calculate the correct connection point.", new Point(100, 150), pt);
    }

    /**
     * <p>
     * Tests RectangleConnector#getConnectionPoint(Point) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the way point is at the west-south side and verify the
     * connection point should be returned correctly.
     * </p>
     */
    public void testGetConnectionPoinWestSouthSide() {
        Point pt = connector.getConnectionPoint(new Point(50, 260));

        assertEquals("Failed to calculate the correct connection point.", new Point(100, 200), pt);
    }

    /**
     * <p>
     * Tests RectangleConnector#getConnectionPoint(Point) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the way point is at the south side and verify the
     * connection point should be returned correctly.
     * </p>
     */
    public void testGetConnectionPoinSouthSide() {
        Point pt = connector.getConnectionPoint(new Point(150, 270));

        assertEquals("Failed to calculate the correct connection point.", new Point(150, 200), pt);
    }

    /**
     * <p>
     * Tests RectangleConnector#getConnectionPoint(Point) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the way point is at the south side and verify the
     * connection point should be returned correctly.
     * </p>
     */
    public void testGetConnectionPoinSouthEastSide() {
        Point pt = connector.getConnectionPoint(new Point(250, 240));

        assertEquals("Failed to calculate the correct connection point.", new Point(200, 200), pt);
    }

    /**
     * <p>
     * Tests RectangleConnector#getConnectionPoint(Point) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the way point is at the east side and verify the
     * connection point should be returned correctly.
     * </p>
     */
    public void testGetConnectionPoinEastSide() {
        Point pt = connector.getConnectionPoint(new Point(230, 160));

        assertEquals("Failed to calculate the correct connection point.", new Point(200, 160), pt);
    }

    /**
     * <p>
     * Tests RectangleConnector#getConnectionPoint(Point) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the way point is at the east-north side and verify the
     * connection point should be returned correctly.
     * </p>
     */
    public void testGetConnectionPoinEastNorthSide() {
        Point pt = connector.getConnectionPoint(new Point(250, 40));

        assertEquals("Failed to calculate the correct connection point.", new Point(200, 100), pt);
    }

    /**
     * <p>
     * Tests RectangleConnector#getConnectionPoint(Point) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the way point is at the north side and verify the
     * connection point should be returned correctly.
     * </p>
     */
    public void testGetConnectionPoinNorthSide() {
        Point pt = connector.getConnectionPoint(new Point(150, 30));

        assertEquals("Failed to calculate the correct connection point.", new Point(150, 100), pt);
    }

    /**
     * <p>
     * Tests RectangleConnector#getConnectionPoint(Point) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the way point is at the north-west side and verify the
     * connection point should be returned correctly.
     * </p>
     */
    public void testGetConnectionPoinNorthWestSide() {
        Point pt = connector.getConnectionPoint(new Point(50, 60));

        assertEquals("Failed to calculate the correct connection point.", new Point(100, 100), pt);
    }

    /**
     * <p>
     * Tests RectangleConnector#getConnectionPoint(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when wayPoint is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetConnectionPoint_NullWayPoint() {
        try {
            connector.getConnectionPoint(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests RectangleConnector#getRectangle() for accuracy.
     * </p>
     *
     * <p>
     * Verify : RectangleConnector#getRectangle() is correct.
     * </p>
     */
    public void testGetRectangle() {
        Rectangle r = connector.getRectangle();

        assertEquals("Failed to get the correct rectangle.", rect, r);

        r.x = 98;
        assertEquals("The rectangle returned should be cloned.", rect, connector.getRectangle());
    }

    /**
     * <p>
     * Tests RectangleConnector#setRectangle(Rectangle) for accuracy.
     * </p>
     *
     * <p>
     * Verify : RectangleConnector#setRectangle(Rectangle) is correct.
     * </p>
     */
    public void testSetRectangle() {
        Rectangle newRect = new Rectangle(34, 24, 34, 54);
        connector.setRectangle(newRect);

        assertEquals("Failed to set the new rectangle.", newRect, connector.getRectangle());

        // verify it should be cloned
        newRect.x = 987;

        assertEquals("Failed to clone the rectangle.", new Rectangle(34, 24, 34, 54), connector.getRectangle());
    }

    /**
     * <p>
     * Tests RectangleConnector#setRectangle(Rectangle) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when rectangle is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetRectangle_NullRectangle() {
        try {
            connector.setRectangle(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}