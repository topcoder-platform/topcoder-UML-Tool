/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Point;
import java.awt.Rectangle;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for Util.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UtilTests extends TestCase {

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(UtilTests.class);
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) for accuracy.
     * </p>
     */
    public void testCheckNull() {
        Util.checkNull(" ", "test");
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckNull_NullArg() {
        try {
            Util.checkNull(null, "test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#getClosestPoint(Point,Rectangle) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the point is at the west side and verify the
     * closest point should be returned correctly.
     * </p>
     */
    public void testGetClosestPointWestSide() {
        Point point = new Point(50, 150);
        Rectangle rectangle = new Rectangle(100, 100, 100, 100);

        assertEquals("Failed to get the closest point.", new Point(100, 150), Util.getClosestPoint(point, rectangle));
    }

    /**
     * <p>
     * Tests Util#getClosestPoint(Point,Rectangle) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the point is at the west-south side and verify the
     * closest point should be returned correctly.
     * </p>
     */
    public void testGetClosestPointWestSouthSide() {
        Point point = new Point(50, 260);
        Rectangle rectangle = new Rectangle(100, 100, 100, 100);

        assertEquals("Failed to get the closest point.", new Point(100, 200), Util.getClosestPoint(point, rectangle));
    }

    /**
     * <p>
     * Tests Util#getClosestPoint(Point,Rectangle) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the point is at the north and verify the
     * closest point should be returned correctly.
     * </p>
     */
    public void testGetClosestPointNorthSide() {
        Point point = new Point(150, 30);
        Rectangle rectangle = new Rectangle(100, 100, 100, 100);

        assertEquals("Failed to get the closest point.", new Point(150, 100), Util.getClosestPoint(point, rectangle));
    }

    /**
     * <p>
     * Tests Util#getClosestPoint(Point,Rectangle) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when point is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetClosestPoint1_NullPoint() {
        Rectangle rectangle = new Rectangle(100, 100, 100, 100);
        try {
            Util.getClosestPoint(null, rectangle);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getClosestPoint(Point,Rectangle) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when rectangle is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetClosestPoint1_NullRectangle() {
        Point point = new Point(150, 30);
        try {
            Util.getClosestPoint(point, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getClosestPoint(Point,Point,Point,Point) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the closest point from the point to the segment is the left point of
     * the segment and verify the distance and closest point are correct.
     * </p>
     */
    public void testGetClosestPoint_LineLeft() {
        Point destPoint = new Point();

        assertEquals("Failed to get the closest point.", 50.0, Util.getClosestPoint(new Point(50, 150), new Point(100,
            150), new Point(200, 50), destPoint), 0.01);
        assertEquals("Failed to get the closest point.", new Point(100, 150), destPoint);
    }

    /**
     * <p>
     * Tests Util#getClosestPoint(Point,Point,Point,Point) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the closest point from the point to the segment is the right point of
     * the segment and verify the distance and closest point are correct.
     * </p>
     */
    public void testGetClosestPoint_LineRight() {
        Point destPoint = new Point();

        assertEquals("Failed to get the closest point.", 50.0, Util.getClosestPoint(new Point(200, 0), new Point(100,
            150), new Point(200, 50), destPoint), 0.01);
        assertEquals("Failed to get the closest point.", new Point(200, 50), destPoint);
    }

    /**
     * <p>
     * Tests Util#getClosestPoint(Point,Point,Point,Point) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the closest point from the point to the segment is on the interior
     * the segment and verify the distance and closest point are correct.
     * </p>
     */
    public void testGetClosestPoint_LineUp() {
        Point destPoint = new Point();

        assertEquals("Failed to get the closest point.", 106.066, Util.getClosestPoint(new Point(50, 50), new Point(
            100, 150), new Point(200, 50), destPoint), 0.001);

        assertEquals("Failed to get the closest point.", new Point(125, 125), destPoint);
    }

    /**
     * <p>
     * Tests Util#checkNotPositive(int,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#checkNotPositive(int,String) is correct.
     * </p>
     */
    public void testCheckNotPositive() {
        Util.checkNotPositive(8, "test");
    }

    /**
     * <p>
     * Tests Util#checkNotPositive(int,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the arg is zero and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckNotPositive_ZeroValue() {
        try {
            Util.checkNotPositive(0, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkNotPositive(int,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the arg is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckNotPositive_NegativeValue() {
        try {
            Util.checkNotPositive(-5, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#calculateLineAngle(Point,Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#calculateLineAngle(Point,Point) is correct.
     * </p>
     */
    public void testCalculateLineAngle() {
        assertEquals("Failed to calculate the angle of the segment.", 0.785, Util.calculateLineAngle(
            new Point(100, 100), new Point(200, 200)), 0.001);
    }

    /**
     * <p>
     * Tests Util#getOffset(Point,Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Util#getOffset(Point,Point) is correct.
     * </p>
     */
    public void testGetOffset() {
        Point startPoint = new Point(5, 5);
        Point endPoint = new Point(8, 8);

        assertEquals("Failed to return the correct point.", new Point(3, 3), Util.getOffset(startPoint, endPoint));
    }

}