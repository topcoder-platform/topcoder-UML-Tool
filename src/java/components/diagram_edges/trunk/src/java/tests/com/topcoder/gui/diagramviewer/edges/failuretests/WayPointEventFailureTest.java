/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.failuretests;

import java.awt.Point;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.WayPointEvent;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>WayPointEvent</code> class.
 *
 * @author still
 * @version 1.0
 */
public class WayPointEventFailureTest extends TestCase {

    /**
     * Test suite of WayPointEvent.
     *
     * @return Test suite of WayPointEvent.
     */
    public static Test suite() {
        return new TestSuite(WayPointEventFailureTest.class);
    }


    /**
     * Test of WayPointEvent(Edge, int, Point) for IllegalArgumentException.
     */
    public void testWayPointEventForException_NullEdge() {
        try {
            new WayPointEvent(null, 0, new Point());
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of WayPointEvent(Edge, int, Point) for IllegalArgumentException.
     */
    public void testWayPointEventForException_NullOffset() {
        try {
            GraphEdge graphEdge = new GraphEdge();
            graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
            graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
            graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
            new WayPointEvent(new MockEdge(graphEdge), 0, null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of WayPointEvent(Edge, int, Point) for IndexOutOfBoundsException.
     */
    public void testWayPointEventForException() {
        GraphEdge graphEdge = new GraphEdge();
        graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
        graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
        graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
        try {

            new WayPointEvent(new MockEdge(graphEdge), -1, new Point());
            // should not be here
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // should be here
        }
        try {

            new WayPointEvent(new MockEdge(graphEdge), 3, new Point());
            // should not be here
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // should be here
        }
    }

    /**
     * Test of WayPointEvent(Edge, Point, Point) for IllegalArgumentException.
     */
    public void testWayPointEventForException2_NullEdge() {
        try {
            new WayPointEvent(null, new Point(), new Point());
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of WayPointEvent(Edge, Point, Point) for IllegalArgumentException.
     */
    public void testWayPointEventForException2_NullNewWayPoint() {
        try {
            GraphEdge graphEdge = new GraphEdge();
            graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
            graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
            graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
            new WayPointEvent(new MockEdge(graphEdge), null, new Point());
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of WayPointEvent(Edge, Point, Point) for IllegalArgumentException.
     */
    public void testWayPointEventForException2_NullOffset() {
        try {
            GraphEdge graphEdge = new GraphEdge();
            graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
            graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
            graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
            new WayPointEvent(new MockEdge(graphEdge), new Point(), null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }
}
