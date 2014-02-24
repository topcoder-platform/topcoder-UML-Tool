/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Color;
import java.awt.Point;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for SelectionCorner.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SelectionCornerTests extends TestCase {
    /**
     * <p>
     * SelectionCorner instance for testing.
     * </p>
     */
    private SelectionCorner corner;

    /**
     * <p>
     * The center point for helping testing.
     * </p>
     */
    private Point center;

    /**
     * <p>
     * The stroke color for helping testing.
     * </p>
     */
    private Color strokeColor = new Color(22, 22, 22);

    /**
     * <p>
     * The fill color for helping testing.
     * </p>
     */
    private Color fillColor = new Color(33, 33, 33);

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        center = new Point(100, 100);
        corner = new SelectionCorner(center, 10, strokeColor, fillColor);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        center = null;
        corner = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(SelectionCornerTests.class);
    }

    /**
     * <p>
     * Tests ctor SelectionCorner#SelectionCorner(Point,int,Color,Color) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created SelectionCorner instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new SelectionCorner instance.", corner);
    }

    /**
     * <p>
     * Tests ctor SelectionCorner#SelectionCorner(Point,int,Color,Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when center is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullCenter() {
        try {
            new SelectionCorner(null, 10, strokeColor, fillColor);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SelectionCorner#SelectionCorner(Point,int,Color,Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when radius is zero and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_ZeroRadius() {
        try {
            new SelectionCorner(center, 0, strokeColor, fillColor);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SelectionCorner#SelectionCorner(Point,int,Color,Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when radius is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NegativeRadius() {
        try {
            new SelectionCorner(center, -87, strokeColor, fillColor);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SelectionCorner#SelectionCorner(Point,int,Color,Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when strokeColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullStrokeColor() {
        try {
            new SelectionCorner(center, 10, null, fillColor);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SelectionCorner#SelectionCorner(Point,int,Color,Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fillColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullFillColor() {
        try {
            new SelectionCorner(center, 10, strokeColor, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SelectionCorner#SelectionCorner(Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created SelectionCorner instance should not be null.
     * </p>
     */
    public void testCtor2() {
        corner = new SelectionCorner(center);
        assertNotNull("Failed to create a new SelectionCorner instance.", corner);
        assertEquals("Failed to get the correct center.", center, corner.getCenter());
        assertEquals("Failed to get the correct radius.", SelectionCorner.DEFAULT_RADIUS, corner.getRadius());
        assertEquals("Failed to get the correct stroke color.", SelectionCorner.DEFAULT_STROKE_COLOR,
            corner.getStrokeColor());
        assertEquals("Failed to get the correct fill color.", SelectionCorner.DEFAULT_FILL_COLOR,
            corner.getFillColor());
    }

    /**
     * <p>
     * Tests ctor SelectionCorner#SelectionCorner(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when center is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullCenter() {
        try {
            new SelectionCorner(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SelectionCorner#getCenter() for accuracy.
     * </p>
     *
     * <p>
     * Verify : SelectionCorner#getCenter() is correct.
     * </p>
     */
    public void testGetCenter() {
        Point pt = corner.getCenter();

        assertEquals("Failed to get the center.", center, pt);

        // modify the point returned by the center getter
        pt.x = 987;
        assertEquals("The point should be cloned.", center, corner.getCenter());

        // modify the center point
        pt = new Point(center);
        center.x = 99;
        assertEquals("The center point should be cloned in constructor.", pt, corner.getCenter());
    }

    /**
     * <p>
     * Tests SelectionCorner#setCenter(Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : SelectionCorner#setCenter(Point) is correct.
     * </p>
     */
    public void testSetCenter() {
        Point pt = new Point(23, 32);
        corner.setCenter(pt);

        assertEquals("Failed to set the center point.", pt, corner.getCenter());

        // modify the point
        pt.x = 98;

        // the center point should not be affected
        assertEquals("Failed to clone the center point.", new Point(23, 32), corner.getCenter());
    }

    /**
     * <p>
     * Tests SelectionCorner#setCenter(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when center is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetCenter_NullCenter() {
        try {
            corner.setCenter(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SelectionCorner#getRadius() for accuracy.
     * </p>
     *
     * <p>
     * Verify : SelectionCorner#getRadius() is correct.
     * </p>
     */
    public void testGetRadius() {
        assertEquals("Failed to get the radius.", 10, corner.getRadius());
    }

    /**
     * <p>
     * Tests SelectionCorner#setRadius(int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : SelectionCorner#setRadius(int) is correct.
     * </p>
     */
    public void testSetRadius() {
        corner.setRadius(245);

        assertEquals("Failed to set the radius.", 245, corner.getRadius());
    }

    /**
     * <p>
     * Tests SelectionCorner#setRadius(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the radius is zero and expect IllegalArgumentException.
     * </p>
     */
    public void testSetRadius_ZeroRadius() {
        try {
            corner.setRadius(0);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests SelectionCorner#setRadius(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the radius is negative and expect IllegalArgumentException.
     * </p>
     */
    public void testSetRadius_NegativeRadius() {
        try {
            corner.setRadius(-87);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests SelectionCorner#getStrokeColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : SelectionCorner#getStrokeColor() is correct.
     * </p>
     */
    public void testGetStrokeColor() {
        assertEquals("Failed to get the stroke color.", strokeColor, corner.getStrokeColor());
    }

    /**
     * <p>
     * Tests SelectionCorner#setStrokeColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * Verify : SelectionCorner#setStrokeColor(Color) is correct.
     * </p>
     */
    public void testSetStrokeColor() {
        corner.setStrokeColor(new Color(23, 34, 56));

        assertEquals("Failed to set the stroke color.", new Color(23, 34, 56), corner.getStrokeColor());
    }

    /**
     * <p>
     * Tests SelectionCorner#setStrokeColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when strokeColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetStrokeColor_NullStrokeColor() {
        try {
            corner.setStrokeColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SelectionCorner#getFillColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : SelectionCorner#getFillColor() is correct.
     * </p>
     */
    public void testGetFillColor() {
        assertEquals("Failed to get the fill color.", fillColor, corner.getFillColor());
    }

    /**
     * <p>
     * Tests SelectionCorner#setFillColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * Verify : SelectionCorner#setFillColor(Color) is correct.
     * </p>
     */
    public void testSetFillColor() {
        corner.setFillColor(new Color(33, 44, 14));

        assertEquals("Failed to set the fill color.", new Color(33, 44, 14), corner.getFillColor());
    }

    /**
     * <p>
     * Tests SelectionCorner#setFillColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fillColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFillColor_NullFillColor() {
        try {
            corner.setFillColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SelectionCorner#contains(int,int) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the given point is inside the selection corner and expects true.
     * </p>
     */
    public void testContainsForTrue() {
        assertTrue("Failed to return true when the given point is inside.", corner.contains(98, 96));
    }

    /**
     * <p>
     * Tests SelectionCorner#contains(int,int) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the given point is outside the selection corner and expects false.
     * </p>
     */
    public void testContainsForFalse() {
        assertFalse("Failed to return false when the given point is outside.", corner.contains(80, 75));
    }

    /**
     * <p>
     * Tests SelectionCorner#paintComponent(Graphics) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when g is null and expects no exception.
     * </p>
     */
    public void testPaintComponent_NullG() {
        corner.paintComponent(null);
    }

}