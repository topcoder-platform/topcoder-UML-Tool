/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentLinkEdge;

/**
 * <p>
 * Accuracy test of <code>CommentLinkEdge</code>.
 * </p>
 * 
 * @author Achilles_2005
 * @version 1.0
 */
public class CommentLinkEdgeAccuracyTest extends TestCase {

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private CommentLinkEdge commentLinkEdge;

    /**
     * <p>
     * Private <code>GraphEdge</code> instance used for test.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * 
     * @throws Exception
     *             exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();

        // graph edge
        graphEdge = new GraphEdge();
        Point pt1 = new Point();
        Point pt2 = new Point();
        pt1.setX(100);
        pt1.setY(200);
        pt2.setX(300);
        pt2.setY(400);
        graphEdge.addWaypoint(pt1);
        graphEdge.addWaypoint(pt2);
        // comment link edge
        commentLinkEdge = new CommentLinkEdge(graphEdge);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * 
     * @throws Exception
     *             exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        graphEdge = null;
        commentLinkEdge = null;
    }

    /**
     * <p>
     * Tests accuracy of constructor.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance should not be null.", commentLinkEdge);
        assertTrue("getLineStyle's return value should be a LineStyle.",
            commentLinkEdge.getLineStyle() instanceof LineStyle);
    }

    /**
     * <p>
     * Tests accuracy of <code>consumeEvent(MouseEvent)</code>.
     * </p>
     * 
     * @throws Exception
     *             exception to JUnit.
     */
    public void testConsumeEventAccuracy() throws Exception {
        // expose the visibility of consumeEvent method
        commentLinkEdge = new MockCommentLinkEdge(graphEdge);
        assertFalse("returned value should be false.", ((MockCommentLinkEdge) commentLinkEdge)
            .consumeEvent(null));
    }
}
