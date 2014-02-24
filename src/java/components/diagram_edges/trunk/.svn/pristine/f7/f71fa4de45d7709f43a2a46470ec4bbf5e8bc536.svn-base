/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.diagramviewer.edges.EdgeEnding;


/**
 * Failure test case of <code>EdgeEnding</code> class.
 *
 * @author still
 * @version 1.0
 */
public class EdgeEndingFailureTest extends TestCase {
    /** Mocked EdgeEnding(it is abstract) instance used between failure tests.*/
    private EdgeEnding instance;

    /**
     * Test suite of EdgeEnding.
     *
     * @return Test suite of EdgeEnding.
     */
    public static Test suite() {
        return new TestSuite(EdgeEndingFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
        instance = new MockEdgeEnding();
    }


    /**
     * Test of EdgeEnding(double, Point) for IllegalArgumentException.
     */
    public void testEdgeEndingForException() {
        try {
            new MockEdgeEnding(0.0, null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setEndingPoint(Point) for IllegalArgumentException.
     */
    public void testSetEndingPointForException() {
        try {
            instance.setEndingPoint(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }


}
