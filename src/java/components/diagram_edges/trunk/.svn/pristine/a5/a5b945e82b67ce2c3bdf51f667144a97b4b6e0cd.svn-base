/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Point;
import javax.swing.DebugGraphics;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for LineStyle.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class LineStyleTests extends TestCase {
    /**
     * <p>
     * LineStyle instance for testing.
     * </p>
     */
    private LineStyle lineStyle;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        lineStyle = new LineStyle(15, 0);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        lineStyle = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(LineStyleTests.class);
    }

    /**
     * <p>
     * Tests ctor LineStyle#LineStyle(int,int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created LineStyle instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new LineStyle instance.", lineStyle);
    }

    /**
     * <p>
     * Tests ctor LineStyle#LineStyle(int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the dash length is zero and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_ZeroDashLength() {
        try {
            new LineStyle(0, 5);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor LineStyle#LineStyle(int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the dash length is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NegativeDashLength() {
        try {
            new LineStyle(-87, 5);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor LineStyle#LineStyle(int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the blank length is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NegativeBlankLength() {
        try {
            new LineStyle(87, -5);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests LineStyle#getDashLength() for accuracy.
     * </p>
     *
     * <p>
     * Verify : LineStyle#getDashLength() is correct.
     * </p>
     */
    public void testGetDashLength() {
        assertEquals("Failed to get the dash length.", 15, lineStyle.getDashLength());
    }

    /**
     * <p>
     * Tests LineStyle#setDashLength(int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : LineStyle#setDashLength(int) is correct.
     * </p>
     */
    public void testSetDashLength() {
        lineStyle.setDashLength(30);

        assertEquals("Failed to set the dash length.", 30, lineStyle.getDashLength());
    }

    /**
     * <p>
     * Tests LineStyle#setDashLength(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the dash length is zero and expects IllegalArgumentException.
     * </p>
     */
    public void testSetDashLength_ZeroDashLength() {
        try {
            lineStyle.setDashLength(0);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests LineStyle#setDashLength(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the dash length is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testSetDashLength_NegativeDashLength() {
        try {
            lineStyle.setDashLength(-98);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests LineStyle#getBlankLength() for accuracy.
     * </p>
     *
     * <p>
     * Verify : LineStyle#getBlankLength() is correct.
     * </p>
     */
    public void testGetBlankLength() {
        assertEquals("Failed to get the blank length.", 0, lineStyle.getBlankLength());
    }

    /**
     * <p>
     * Tests LineStyle#setBlankLength(int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : LineStyle#setBlankLength(int) is correct.
     * </p>
     */
    public void testSetBlankLength() {
        lineStyle.setBlankLength(50);

        assertEquals("Failed to set the blank length.", 50, lineStyle.getBlankLength());
    }

    /**
     * <p>
     * Tests LineStyle#setBlankLength(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when blank length is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testSetBlankLength_NegativeBlankLength() {
        try {
            lineStyle.setBlankLength(-98);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests LineStyle#paint(Graphics,Point,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when g is null and expects IllegalArgumentException.
     * </p>
     */
    public void testPaint_NullG() {
        try {
            lineStyle.paint(null, new Point(2, 4), new Point(100, 100));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests LineStyle#paint(Graphics,Point,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when p1 is null and expects IllegalArgumentException.
     * </p>
     */
    public void testPaint_NullP1() {
        try {
            lineStyle.paint(new DebugGraphics(), null, new Point(13, 10));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests LineStyle#paint(Graphics,Point,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when p2 is null and expects IllegalArgumentException.
     * </p>
     */
    public void testPaint_NullP2() {
        try {
            lineStyle.paint(new DebugGraphics(), new Point(13, 10), null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}