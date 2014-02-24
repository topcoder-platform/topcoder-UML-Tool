/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import java.awt.Rectangle;

import com.topcoder.gui.diagramviewer.edges.connectors.RectangleConnector;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>RectangleConnector</code> class.
 *
 * @author still
 * @version 1.0
 */
public class RectangleConnectorFailureTest extends TestCase {
    /** RectangleConnector instance for failure tests. */
    private RectangleConnector instance;
    /**
     * Test suite of RectangleConnector.
     *
     * @return Test suite of RectangleConnector.
     */
    public static Test suite() {
        return new TestSuite(RectangleConnectorFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
        instance = new RectangleConnector(new Rectangle());
    }


    /**
     * Test of RectangleConnector(Rectangle) for IllegalArgumentException.
     */
    public void testRectangleConnectorForException() {
        try {
            new RectangleConnector(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setRectangle(Rectangle) for IllegalArgumentException.
     */
    public void testSetRectangleForException() {
        try {
            instance.setRectangle(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of getConnectionPoint(Point) for IllegalArgumentException.
     */
    public void testGetConnectionPointForException() {
        try {
            instance.getConnectionPoint(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

}
