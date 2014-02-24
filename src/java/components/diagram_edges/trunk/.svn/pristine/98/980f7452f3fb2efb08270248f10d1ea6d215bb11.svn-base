/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Edges Version 1.0 Accuracytests.
 *
 * @ SelectionCornerAccuracyTests.java
 */
package com.topcoder.gui.diagramviewer.edges.accuracytests;

import com.topcoder.gui.diagramviewer.edges.SelectionCorner;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Color;
import java.awt.Point;


/**
 * <p>
 * The <code>SelectionCorner</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>SelectionCorner</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class SelectionCornerAccuracyTests extends TestCase {
    /**
     * <p>
     * Represents an instance of <code>SelectionCorner</code> uses for accuracy tests.
     * </p>
     */
    private SelectionCorner test = null;

    /**
     * <p>
     * Test suite of <code>SelectionCornerAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>SelectionCornerAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(SelectionCornerAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     */
    protected void setUp() {
        test = new SelectionCorner(new Point(2, 3));
    }

    /**
     * <p>
     * Accuracy Test of the <code>LineStyle</code>'s constructor.
     * It tests the simple constructor which only need one param.
     * </p>
     */
    public void testConstructor_Simple() {
        // creat a new instance to check the constructor.
        assertNotNull("Constructor should work well.", test);

        // get the attribute radius to check the constructor.
        assertEquals("The radius should be default to 5.", 5, test.getRadius());
        // get the attribute strokeColor to check the constructor.
        assertEquals("The strokeColor should be default to Color.BLACK.",
            Color.BLACK, test.getStrokeColor());
        // get the attribute fillColor to check the constructor.
        assertEquals("The fillColor should be default to Color.YELLOW.",
            Color.YELLOW, test.getFillColor());
        // get the attribute center to check the constructor.
        assertEquals("The center should be set to Point(2, 3).",
            new Point(2, 3), test.getCenter());
    }

    /**
     * <p>
     * Accuracy Test of the <code>LineStyle</code>'s constructor.
     * It tests the constructor which many params.
     * </p>
     */
    public void testConstructor_Complex() {
        // creat a new instance to check the constructor.
        test = new SelectionCorner(new Point(3, 5), 3, Color.BLACK, Color.BLUE);
        assertNotNull("Constructor should work well.", test);

        // get the attribute radius to check the constructor.
        assertEquals("The radius should be set to 3.", 3, test.getRadius());
        // get the attribute strokeColor to check the constructor.
        assertEquals("The strokeColor should be set to Color.BLACK.",
            Color.BLACK, test.getStrokeColor());
        // get the attribute fillColor to check the constructor.
        assertEquals("The fillColor should be set to Color.BLUE.", Color.BLUE,
            test.getFillColor());
        // get the attribute center to check the constructor.
        assertEquals("The center should be set to Point(3, 5).",
            new Point(3, 5), test.getCenter());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setRadius(int)</code> and <code>getRadius()</code>
     * methods.
     * </p>
     */
    public void testRadius_Operation() {
        // get the attribute radius to check the get operation.
        assertEquals("The radius should be default to 5.", 5, test.getRadius());
        // set the radius.
        test.setRadius(7);
        //  get the attribute radius to check the set operation.
        assertEquals("The radius should be set to 7.", 7, test.getRadius());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setCenter(Point)</code> and <code>getCenter()</code>
     * methods.
     * </p>
     */
    public void testCenter_Operation() {
        // get the attribute center to check the get operation.
        assertEquals("The center should be default to Point(2, 3).",
            new Point(2, 3), test.getCenter());
        // set the center.
        test.setCenter(new Point(3, 6));
        //  get the attribute radius to check the set operation.
        assertEquals("The center should be set to Point(3, 6).",
            new Point(3, 6), test.getCenter());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setStrokeColor(Color)</code> and <code>getStrokeColor()</code>
     * methods.
     * </p>
     */
    public void testStrokeColor_Operation() {
        // get the attribute strokeColor to check the get operation.
        assertEquals("The strokeColor should be default to Color.BLACK.",
            Color.BLACK, test.getStrokeColor());
        // set the strokeColor.
        test.setStrokeColor(Color.CYAN);
        //  get the attribute strokeColor to check the set operation.
        assertEquals("The strokeColor should be set to Color.CYAN.",
            Color.CYAN, test.getStrokeColor());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setFillColor(Color)</code> and <code>getFillColor()</code>
     * methods.
     * </p>
     */
    public void testFillColor_Operation() {
        // get the attribute fillColor to check the get operation.
        assertEquals("The fillColor should be default to Color.YELLOW.",
            Color.YELLOW, test.getFillColor());
        // set the fillColor.
        test.setFillColor(Color.LIGHT_GRAY);
        //  get the attribute fillColor to check the set operation.
        assertEquals("The fillColor should be set to Color.LIGHT_GRAY.",
            Color.LIGHT_GRAY, test.getFillColor());
    }

    /**
     * <p>
     * Accuracy Test of the <code>contains(int, int)</code> method.
     * </p>
     */
    public void testContains() {
        test = new SelectionCorner(new Point(0, 0));
        // test with the point (3, 4).
        assertTrue("The Point should be in the circle.", test.contains(3, 4));
        // test with the point (2, 2).
        assertTrue("The Point should be in the circle.", test.contains(2, 2));
        // test with the point (5, 0).
        assertTrue("The Point should be in the circle.", test.contains(5, 0));

        // test with the point (3, 5).
        assertFalse("The Point should not be in the circle.",
            test.contains(3, 5));
        // test with the point (6, 0).
        assertFalse("The Point should not be in the circle.",
            test.contains(6, 0));
    }
}
