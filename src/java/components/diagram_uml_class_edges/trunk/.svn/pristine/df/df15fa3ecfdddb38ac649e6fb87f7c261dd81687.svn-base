/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import java.awt.Point;

import javax.swing.DebugGraphics;

import com.topcoder.gui.diagramviewer.edges.LineStyle;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>LineStyle</code> class.
 *
 * @author still
 * @version 1.0
 */
public class LineStyleFailureTest extends TestCase {
    /** LineStyle instance used in failure test.*/
    private LineStyle instance;
    /**
     * Test suite of LineStyle.
     *
     * @return Test suite of LineStyle.
     */
    public static Test suite() {
        return new TestSuite(LineStyleFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
        instance = new LineStyle(1, 1);
    }

    /**
     * Test of LineStyle(int, int) for IllegalArgumentException.
     */
    public void testLineStyleForException_ZeroDashLength() {
        try {
            new LineStyle(0, 1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of LineStyle(int, int) for IllegalArgumentException.
     */
    public void testLineStyleForException_NegativeDashLength() {
        try {
            new LineStyle(-1, 1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of LineStyle(int, int) for IllegalArgumentException.
     */
    public void testLineStyleForException_NegativeBlankLength() {
        try {
            new LineStyle(1, -1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setDashLength(int) for IllegalArgumentException.
     */
    public void testSetDashLengthForException_ZeroDashLength() {
        try {
            instance.setDashLength(0);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setDashLength(int) for IllegalArgumentException.
     */
    public void testSetDashLengthForException_NegativeDashLength() {
        try {
            instance.setDashLength(-1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setBlankLength(int) for IllegalArgumentException.
     */
    public void testSetBlankLengthForException() {
        try {
            instance.setBlankLength(-1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of paint(Graphics, Point, Point) for IllegalArgumentException.
     */
    public void testPaintForException_NullGraphics() {
        try {
            instance.paint(null, new Point(), new Point());
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of paint(Graphics, Point, Point) for IllegalArgumentException.
     */
    public void testPaintForException_NullPoint1() {
        try {
            instance.paint(new DebugGraphics(), null, new Point());
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of paint(Graphics, Point, Point) for IllegalArgumentException.
     */
    public void testPaintForException_NullPoint2() {
        try {
            instance.paint(new DebugGraphics(), new Point(), null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }
}
