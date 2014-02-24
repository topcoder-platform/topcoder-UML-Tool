/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Point;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for EdgeEnding.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EdgeEndingTests extends TestCase {
    /**
     * <p>
     * The EdgeEnding instance for testing.
     * </p>
     */
    private EdgeEnding ending;

    /**
     * <p>
     * The center point for helping testing.
     * </p>
     */
    private Point endingPoint;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        endingPoint = new Point(100, 200);
        ending = new TriangleEdgeEnding(0, endingPoint);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        ending = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(EdgeEndingTests.class);
    }

    /**
     * <p>
     * Tests ctor EdgeEnding#EdgeEnding(double,Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created EdgeEnding instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new EdgeEnding instance.", ending);
    }

    /**
     * <p>
     * Tests ctor EdgeEnding#EdgeEnding(double,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when endingPoint is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullEndingPoint() {
        try {
            new TriangleEdgeEnding(0, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor EdgeEnding#EdgeEnding() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created EdgeEnding instance should not be null.
     * </p>
     */
    public void testCtor2() {
        ending = new TriangleEdgeEnding();
        assertNotNull("Failed to create a new EdgeEnding instance.", ending);
        assertEquals("Failed to get the angle of the edge ending.", 0, ending.getAngle(), 0.1);
        assertEquals("Failed to get the ending point of the edge ending.", new Point(0, 0), ending.getEndingPoint());
    }

    /**
     * <p>
     * Tests EdgeEnding#setAngle(double) for accuracy.
     * </p>
     *
     * <p>
     * Verify : EdgeEnding#setAngle(double) is correct.
     * </p>
     */
    public void testSetAngle() {
        ending.setAngle(0.5);

        assertEquals("Failed to set the angle", 0.5, ending.getAngle());
    }

    /**
     * <p>
     * Tests EdgeEnding#setEndingPoint(Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : EdgeEnding#setEndingPoint(Point) is correct.
     * </p>
     */
    public void testSetEndingPoint() {
        Point pt = new Point(39, 256);
        ending.setEndingPoint(pt);

        assertEquals("Failed to set the ending point.", pt, ending.getEndingPoint());

        pt.x = 400;
        assertFalse("The ending point should be cloned.", pt.equals(ending.getEndingPoint()));
    }

    /**
     * <p>
     * Tests EdgeEnding#setEndingPoint(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when point is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetEndingPoint_NullPoint() {
        try {
            ending.setEndingPoint(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests EdgeEnding#getAngle() for accuracy.
     * </p>
     *
     * <p>
     * Verify : EdgeEnding#getAngle() is correct.
     * </p>
     */
    public void testGetAngle() {
        assertEquals("Failed to get the correct angle.", 0, ending.getAngle(), 0.1);
    }

    /**
     * <p>
     * Tests EdgeEnding#getEndingPoint() for accuracy.
     * </p>
     *
     * <p>
     * Verify : EdgeEnding#getEndingPoint() is correct.
     * </p>
     */
    public void testGetEndingPoint() {
        Point pt = ending.getEndingPoint();

        assertEquals("Failed to get the correct ending point.", endingPoint, pt);

        pt.x = 100;
        assertEquals("The point returned by the getter should be a cloned one.", endingPoint, ending.getEndingPoint());

        // save the ending point
        pt = new Point(endingPoint);
        endingPoint.x = 9887;
        // modify the ending point
        assertEquals("The ending point set to the constructor should be cloned.", pt, ending.getEndingPoint());
    }

}