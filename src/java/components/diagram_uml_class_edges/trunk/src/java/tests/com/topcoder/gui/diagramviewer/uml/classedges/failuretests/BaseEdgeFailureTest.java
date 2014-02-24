/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>BaseEdge</code> class.
 *
 * @author still
 * @version 1.0
 */
public class BaseEdgeFailureTest extends TestCase {

    /** GraphEdge instance used in this failure test. */
    private GraphEdge graphEdge;

    /**
     * Test suite of BaseEdge.
     *
     * @return Test suite of BaseEdge.
     */
    public static Test suite() {
        return new TestSuite(BaseEdgeFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     *
     * @throws Expception to JUnit
     */
    protected void setUp() throws Exception {
        // set up for test
        graphEdge = new GraphEdge();
        graphEdge.addWaypoint(new Point());
        graphEdge.addWaypoint(new Point());
        graphEdge.addContained(new GraphNode());
        graphEdge.addContained(new GraphNode());
    }

    /**
     * <p>
     * Test of BaseEdge(GraphEdge, LineStyle, EdgeEnding, EdgeEnding) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null GraphEdge.
     */
    public void testBaseEdgeForException1() throws Exception {
        try {
            new MockBaseEdge(null, new LineStyle(5, 2), null, null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of BaseEdge(GraphEdge, LineStyle, EdgeEnding, EdgeEnding) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null GraphEdge.
     */
    public void testBaseEdgeForException2() throws Exception {
        try {
            new MockBaseEdge(graphEdge, null, null, null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of BaseEdge(GraphEdge, LineStyle, EdgeEnding, EdgeEnding) for IllegalGraphElementException.
     * </p>
     * IllegalGraphElementException must be thrown when encountering GraphEdge with not enough contained elements.
     */
    public void testBaseEdgeForException3() throws Exception {
        try {
            graphEdge = new GraphEdge();
            graphEdge.addWaypoint(new Point());
            graphEdge.addWaypoint(new Point());


            new MockBaseEdge(graphEdge, new LineStyle(5, 2), null, null);
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of BaseEdge(GraphEdge, LineStyle, EdgeEnding, EdgeEnding) for IllegalGraphElementException.
     * </p>
     * IllegalGraphElementException must be thrown when encountering GraphEdge with less than 2 way points.
     */
    public void testBaseEdgeForException4() throws Exception {
        try {
            graphEdge = new GraphEdge();
            graphEdge.addContained(new GraphNode());
            graphEdge.addContained(new GraphNode());


            new MockBaseEdge(graphEdge, new LineStyle(5, 2), null, null);
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }
    }
}
