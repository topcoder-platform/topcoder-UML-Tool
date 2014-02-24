/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.GraphEdge;

import com.topcoder.gui.diagramviewer.edges.LineStyle;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import java.awt.Dimension;

import javax.swing.JFrame;


/**
 * <p>
 * Unit test cases for CommentLinkEdge.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CommentLinkEdgeTests extends TestCase {
    /**
     * <p>
     * The CommentLinkEdge instance for helping testing.
     * </p>
     */
    private CommentLinkEdge edge;

    /**
     * <p>
     * The GraphEdge instance for helping testing.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        // set up the graphEdge instance
        graphEdge = new GraphEdge();
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));

        edge = new CommentLinkEdge(graphEdge);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        graphEdge = null;
        edge = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(CommentLinkEdgeTests.class);
    }

    /**
     * <p>
     * Tests constructor CommentLinkEdge#CommentLinkEdge(GraphEdge graphEdge) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CommentLinkEdge instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor() throws Exception {
        assertNotNull("Failed to create a new CommentLinkEdge instance.", edge);
        assertNotNull("The newly created CommentLinkEdge should have MouseListeners.", edge.getMouseListeners());
        assertNull("The newly created CommentLinkEdge should have a null leftEnding.", edge.getLeftEnding());
        assertNull("The newly created CommentLinkEdge should have a null rightEnding.", edge.getRightEnding());
        assertNotNull("The newly created CommentLinkEdge should not have a null lineStyle.", edge.getLineStyle());
        assertTrue("The newly created CommentLinkEdge's getLineStyle's return value should be a LineStyle.",
                edge.getLineStyle() instanceof LineStyle);
    }

    /**
     * <p>
     * Tests constructor CommentLinkEdge#CommentLinkEdge(GraphEdge graphEdge) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphEdge is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_NullGraphEdge() throws Exception {
        try {
            new CommentLinkEdge(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CommentLinkEdge#consumeEvent(MouseEvent event) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the CommentLinkEdge#consumeEvent(MouseEvent event) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConsumeEvent() throws Exception {
        assertFalse("The CommentLinkEdge#ConsumeEvent() should always return false.", edge.consumeEvent(null));
    }

    /**
     * <p>
     * Frame Demo.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFrame() throws Exception {
        // set up the graphEdge instance
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));

        // set up the edge instance
        edge = new CommentLinkEdge(graphEdge);

        // set up the JFrame instance and show it
        JFrame frame = new JFrame();
        frame.setTitle("CommentLinkEdge Frame Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(edge);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);

        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }
}
