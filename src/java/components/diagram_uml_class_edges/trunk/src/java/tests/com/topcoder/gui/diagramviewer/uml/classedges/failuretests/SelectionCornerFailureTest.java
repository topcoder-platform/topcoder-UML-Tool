/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import java.awt.Color;
import java.awt.Point;

import com.topcoder.gui.diagramviewer.edges.SelectionCorner;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>SelectionCorner</code> class.
 *
 * @author still
 * @version 1.0
 */
public class SelectionCornerFailureTest extends TestCase {
    /** SelectionCorner instance for failure test. */
    private SelectionCorner instance;
    /**
     * Test suite of SelectionCorner.
     *
     * @return Test suite of SelectionCorner.
     */
    public static Test suite() {
        return new TestSuite(SelectionCornerFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
        instance = new SelectionCorner(new Point());
    }


    /**
     * Test of SelectionCorner(Point) for IllegalArgumentException.
     */
    public void testSelectionCornerForException() {
        try {
            new SelectionCorner(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of SelectionCorner(Point, int, Color, Color) for IllegalArgumentException.
     */
    public void testSelectionCornerForException_NullPoint() {
        try {
            new SelectionCorner(null, 1, Color.GRAY, Color.BLACK);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of SelectionCorner(Point, int, Color, Color) for IllegalArgumentException.
     */
    public void testSelectionCornerForException_ZeroRadius() {
        try {
            new SelectionCorner(new Point(), 0, Color.GRAY, Color.BLACK);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of SelectionCorner(Point, int, Color, Color) for IllegalArgumentException.
     */
    public void testSelectionCornerForException_NegativeRadius() {
        try {
            new SelectionCorner(new Point(), -1, Color.GRAY, Color.BLACK);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of SelectionCorner(Point, int, Color, Color) for IllegalArgumentException.
     */
    public void testSelectionCornerForException_NullStrokeColor() {
        try {
            new SelectionCorner(new Point(), 1, null, Color.BLACK);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of SelectionCorner(Point, int, Color, Color) for IllegalArgumentException.
     */
    public void testSelectionCornerForException_NullFillColor() {
        try {
            new SelectionCorner(new Point(), 1, Color.BLACK, null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setRadius(int) for IllegalArgumentException.
     */
    public void testSetRadiusForException_ZeroRadius() {
        try {
            instance.setRadius(0);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setRadius(int) for IllegalArgumentException.
     */
    public void testSetRadiusForException_NegativeRadius() {
        try {
            instance.setRadius(-1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setCenter(Point) for IllegalArgumentException.
     */
    public void testSetCenterForException() {
        try {
            instance.setCenter(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setStrokeColor(Color) for IllegalArgumentException.
     */
    public void testSetStrokeColorForException() {
        try {
            instance.setStrokeColor(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setFillColor(Color) for IllegalArgumentException.
     */
    public void testSetFillColorForException() {
        try {
            instance.setFillColor(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

}
