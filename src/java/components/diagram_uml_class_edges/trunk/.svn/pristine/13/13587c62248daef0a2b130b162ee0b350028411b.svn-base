/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.uml.classedges.event.EdgeSelectionTrigger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>EdgeSelectionTrigger</code> class.
 *
 * @author still
 * @version 1.0
 */
public class EdgeSelectionTriggerFailureTest extends TestCase {
    /** EdgeSelectionTrigger instance used in this failure test. */
    private EdgeSelectionTrigger trigger;
    /**
     * Test suite of EdgeSelectionTrigger.
     *
     * @return Test suite of EdgeSelectionTrigger.
     */
    public static Test suite() {
        return new TestSuite(EdgeSelectionTriggerFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        // set up for test
        GraphEdge graphEdge = new GraphEdge();
        graphEdge.addWaypoint(new Point());
        graphEdge.addWaypoint(new Point());
        graphEdge.addContained(new GraphNode());
        graphEdge.addContained(new GraphNode());
        trigger = new EdgeSelectionTrigger(
            new MockBaseEdge(graphEdge, new LineStyle(1, 1), null, null));
    }


    /**
     * <p>
     * Test of EdgeSelectionTrigger(BaseEdge) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null BaseEdge.
     */
    public void testEdgeSelectionTriggerForException() {
        try {
            new EdgeSelectionTrigger(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }
    /**
     * <p>
     * Test of mouseClicked(MouseEvent) for ignoring null event.
     * </p>
     *
     * No exception should be thrown when encountering null event.
     */
    public void testMouseClickedForIgnoreNullEvent() {
        try {
            // should not throw any exception
            trigger.mouseClicked(null);
        } catch (Exception e) {
            // should be here
            fail("No exception expected.");
        }
    }

}
