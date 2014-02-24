/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import java.awt.Point;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.edges.Edge;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>Edge</code> class.
 *
 * @author still
 * @version 1.0
 */
public class EdgeFailureTest extends TestCase {
    /** MockEdge instance used in failure tests of <code>Edge</code> class. */
    private Edge edge;

    /** GraphEdge instance used in the call of <code>Edge</code> class. */
    private GraphEdge graphEdge;
    /**
     * Test suite of Edge.
     *
     * @return Test suite of Edge.
     */
    public static Test suite() {
        return new TestSuite(EdgeFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
        graphEdge = new GraphEdge();
        graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
        graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
        graphEdge.addWaypoint(new com.topcoder.diagraminterchange.Point());
        edge = new MockEdge(graphEdge);
    }

    /**
     * Test of Edge(GraphEdge, LineStyle, EdgeEnding, EdgeEnding) for IllegalArgumentException.
     */
    public void testEdgeForException_NullGraphEdge() {
        try {
            new MockEdge(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of Edge(GraphEdge, LineStyle, EdgeEnding, EdgeEnding) for IllegalArgumentException.
     */
    public void testEdgeForException_NullLineStyle() {
        try {
            new MockEdge(graphEdge,  null, new MockEdgeEnding(), new MockEdgeEnding());
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of notifyRemoveWayPoint(int, Point) for IllegalArgumentException.
     */
    public void testNotifyRemoveWayPointForException_NullRemovedPoint() {
        try {
            edge.notifyChangeWayPoint(0, null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of notifyRemoveWayPoint(int, Point) for IndexOutOfBoundsException.
     */
    public void testNotifyRemoveWayPointForException_InvalidIndex() {
        try {
            edge.notifyChangeWayPoint(-1, new Point());
            // should not be here
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // should be here
        }

        try {
            edge.notifyChangeWayPoint(3, new Point());
            // should not be here
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // should be here
        }
    }

    /**
     * Test of notifyAddWayPoint(int) for IndexOutOfBoundsException.
     */
    public void testNotifyAddWayPointForException() {
        try {
            edge.notifyAddWayPoint(10);
            // should not be here
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // should be here
        }

        try {
            edge.notifyAddWayPoint(-1);
            // should not be here
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // should be here
        }
    }

    /**
     * Test of notifyChangeWayPoint(int, Point) for IllegalArgumentException.
     */
    public void testNotifyChangeWayPointForException_IllegalArgumentException() {
        try {
            edge.notifyChangeWayPoint(1, null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of notifyChangeWayPoint(int, Point) for IndexOutOfBoundsException.
     */
    public void testNotifyChangeWayPointForException_IndexOutOfBoundsException() {
        try {
            edge.notifyChangeWayPoint(-1, new Point());
            // should not be here
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // should be here
        }

        try {
            edge.notifyChangeWayPoint(10, new Point());
            // should not be here
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // should be here
        }
    }

    /**
     * Test of addTextField(GraphNode, String, AnchorType) for IllegalArgumentException.
     */
    public void testAddTextFieldForException_NullGraphNode() {
        try {
            edge.addTextField(null, "text", AnchorType.LeftEnding);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of addTextField(GraphNode, String, AnchorType) for IllegalArgumentException.
     */
    public void testAddTextFieldForException_NullText() {
        try {
            edge.addTextField(new GraphNode(), null, AnchorType.LeftEnding);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of addTextField(GraphNode, String, AnchorType) for IllegalArgumentException.
     */
    public void testAddTextFieldForException_NullAnchorType() {
        try {
            edge.addTextField(new GraphNode(), "text", null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of getTextField(GraphNode) for IllegalArgumentException.
     */
    public void testGetTextFieldForException() {
        try {
            edge.getTextField(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of removeTextField(GraphNode) for IllegalArgumentException.
     */
    public void testRemoveTextFieldForException() {
        try {
            edge.removeTextField(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setActiveWidth(int) for IllegalArgumentException.
     */
    public void testSetActiveWidthForException_ZeroWidth() {
        try {
            edge.setActiveWidth(0);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setActiveWidth(int) for IllegalArgumentException.
     */
    public void testSetActiveWidthForException_NegativeWidth() {
        try {
            edge.setActiveWidth(-10);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setAlignDeviation(double) for IllegalArgumentException.
     */
    public void testSetAlignDeviationForException() {
        try {
            edge.setAlignDeviation(-1.0);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setLocation(int, int) for IllegalArgumentException.
     */
    public void testSetLocationForException() {
        try {
            edge.setLocation(0, 1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }

        try {
            edge.setLocation(1, 0);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }

        try {
            edge.setLocation(0, 0);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * Test of setBounds(int, int, int, int) for IllegalArgumentException.
     */
    public void testSetBoundsForException() {
        try {
            edge.setBounds(0, 1, 1, 1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }

        try {
            edge.setBounds(1, 0, 1, 1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }

        try {
            edge.setBounds(1, 1, 1, 1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }


        try {
            edge.setBounds(0, 0, 0, 1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }

        try {
            edge.setBounds(0, 0, 1, 0);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }

        try {
            edge.setBounds(0, 0, 1, -1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }

        try {
            edge.setBounds(0, 0, -1, 1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }

        try {
            edge.setBounds(0, 0, -1, -1);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

}
