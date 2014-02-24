/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Edges Version 1.0 Accuracytests.
 *
 * @ WayPointEventAccuracyTests.java
 */
package com.topcoder.gui.diagramviewer.edges.accuracytests;

import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.WayPointEvent;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Point;


/**
 * <p>
 * The <code>WayPointEvent</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>WayPointEvent</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class WayPointEventAccuracyTests extends TestCase {
    /**
     * <p>
     * Represents an instance of <code>WayPointEvent</code> uses for accuracy tests.
     * </p>
     */
    private WayPointEvent test = null;

    /**
     * <p>
     * Represents an instance of <code>Edge</code> uses for accuracy tests.
     * </p>
     */
    private Edge edge = null;

    /**
     * <p>
     * Test suite of <code>WayPointEventAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>WayPointEventAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(WayPointEventAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     */
    protected void setUp() {
        edge = TestHelper.getEdge();
        test = new WayPointEvent(edge, 1, new Point(3, 4));
    }

    /**
     * <p>
     * Accuracy Test of the <code>WayPointEvent</code>'s constructor.
     * It tests the WayPointEvent(Edge, int , Point) constructor.
     * </p>
     */
    public void testConstructor_Change() {
        // creat a new instance to check the constructor.
        assertNotNull("Constructor should work well.", test);

        // get the attribute index to check the constructor.
        assertEquals("The index should be set to 1.", 1, test.getIndex());
        //  get the attribute oldPosition to check the constructor.
        assertEquals("The oldPosition should be set to (10, 10).",
            new Point(10, 10), test.getOldPosition());
        // get the attribute offset to check the constructor.
        assertEquals("The offset should be set to (3, 4).", new Point(3, 4),
            test.getOffset());
        //  get the new position to check the constructor.
        assertEquals("The new position should be set to (13, 14).",
            new Point(13, 14), test.getNewPosition());
    }

    /**
     * <p>
     * Accuracy Test of the <code>WayPointEvent</code>'s constructor.
     * It tests the WayPointEvent(Edge, Point , Point) constructor.
     * </p>
     */
    public void testConstructor_Creat() {
        test = new WayPointEvent(edge, new Point(5, 5), new Point(3, 5));
        //  creat a new instance to check the constructor.
        assertNotNull("Constructor should work well.", test);

        // get the attribute index to check the constructor.
        assertEquals("The index should be set to -1.", -1, test.getIndex());
        //  get the attribute oldPosition to check the constructor.
        assertEquals("The oldPosition should be set to (5, 5).",
            new Point(5, 5), test.getOldPosition());
        // get the attribute offset to check the constructor.
        assertEquals("The offset should be set to (3, 5).", new Point(3, 5),
            test.getOffset());
        //  get the new position to check the constructor.
        assertEquals("The new position should be set to (8, 10).",
            new Point(8, 10), test.getNewPosition());
    }
}
