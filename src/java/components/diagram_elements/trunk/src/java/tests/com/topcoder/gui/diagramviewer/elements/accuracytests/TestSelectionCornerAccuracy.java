/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.accuracytests;

import java.awt.Color;
import java.awt.Point;

import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>SelectionCorner </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestSelectionCornerAccuracy extends TestCase {

    /**
     * Represents the SelectionCorner instance for testing.
     */
    private SelectionCorner sc = null;

    /**
     * Set up.
     */
    public void setUp() {
        sc = new SelectionCorner(SelectionCornerType.NORTH, new Point(1, 10));
    }

    /**
     * Test the constructor <code> SelectionCorner(SelectionCornerType type, Point center) </code>.
     *
     */
    public void testSelectionCornerSelectionCornerTypePoint() {
        assertNotNull("should not be null.", sc);
        assertEquals("Equal is expected.", new Point(1, 10), sc.getCenter());
        assertEquals("Equal is epxected.", SelectionCorner.DEFAULT_RADIUS, sc.getRadius());
    }

    /**
     * Test constructor
     * <code> SelectionCorner(SelectionCornerType type, Point center,
     * int radius, Color strokeColor, Color fillColor) </code>.
     *
     */
    public void testSelectionCornerSelectionCornerTypePointIntColorColor() {
        Color s = new Color(1);
        Color f = new Color(2);
        Point c = new Point(1, 1);
        int r = 100;
        sc = new SelectionCorner(SelectionCornerType.EAST, c, r, s, f);
        assertNotNull("The SelectionCorner instance should be created.", sc);
        assertEquals("Equal is expected.", c, sc.getCenter());
        assertEquals("Equal is expected.", s, sc.getStrokeColor());
        assertEquals("Equal is expected.", r, sc.getRadius());
        assertEquals("Equal is expected.", f, sc.getFillColor());
    }

    /**
     * Test method <code>boolean contains(int x, int y) </code>.
     *
     */
    public void testContainsIntInt() {
        Color s = new Color(1);
        Color f = new Color(2);
        Point c = new Point(1, 1);
        int r = 100;
        sc = new SelectionCorner(SelectionCornerType.EAST, c, r, s, f);
        assertTrue("True is expected.", sc.contains(101,1));
        assertTrue("True is expected.", sc.contains(1,101));
        /*
         * BugFix: UML-9867
         * The circle center should be (radius, radius).
         */
        // old code
//        assertTrue("True is expected.", sc.contains(-99,1));
//        assertFalse("False is expected.", sc.contains(102, 3));

        assertFalse("False is expected.", sc.contains(-99,1));
        assertTrue("True is expected.", sc.contains(102, 3));

    }

    /**
     * Test method <code>SelectionCornerType getType() </code>.
     *
     */
    public void testGetType() {
        assertEquals("Equal is expected.", SelectionCornerType.NORTH, sc.getType());
    }

    /**
     * Test method <code> void setType(SelectionCornerType type) </code>.
     *
     */
    public void testSetType() {
        sc.setType(SelectionCornerType.NORTHEAST);
        assertEquals("Equal is expected.", SelectionCornerType.NORTHEAST, sc.getType());
    }

    /**
     * Test method <code>int getRadius() </code>.
     *
     */
    public void testGetRadius() {
        assertEquals("Equal is expected.", 5, sc.getRadius());
    }

    /**
     * Test method <code>void setRadius(int radius) </code>.
     *
     */
    public void testSetRadius() {
        sc.setRadius(10);
        assertEquals("Equal is expected.", 10, sc.getRadius());
    }

    /**
     * Test method <code>Point getCenter() </code>.
     *
     */
    public void testGetCenter() {
        assertEquals("Equal is expected.", new Point(1, 10), sc.getCenter());
    }

    /**
     * Test method <code> void setCenter(Point center) </code>.
     *
     */
    public void testSetCenter() {
        Point center = new Point(1, 1);
        sc.setCenter(center);
        assertEquals("Equal is expected.", new Point(1, 1), sc.getCenter());
    }

    /**
     * Test method <code>Color getStrokeColor() </code>.
     *
     */
    public void testGetStrokeColor() {
        assertEquals("Equal is expected.", SelectionCorner.DEFAULT_STROKECOLOR, sc.getStrokeColor());
    }

    /**
     * Test method <code>void setStrokeColor(Color strokeColor) </code>.
     *
     */
    public void testSetStrokeColor() {
        Color c = new Color(1);
        sc.setStrokeColor(c);
        assertEquals("Equal is expected.", c, sc.getStrokeColor());
    }

    /**
     * Test method <code> Color getFillColor() </code>.
     *
     */
    public void testGetFillColor() {
        assertEquals("Equal is expected.", SelectionCorner.DEFAULT_FILLCOLOR, sc.getFillColor());
    }

    /**
     * Test method <code>void setFillColor(Color fillColor) </code>.
     *
     */
    public void testSetFillColor() {
        Color f = new Color(10);
        sc.setFillColor(f);
        assertEquals("Equal is expected.", f, sc.getFillColor());
    }
}
