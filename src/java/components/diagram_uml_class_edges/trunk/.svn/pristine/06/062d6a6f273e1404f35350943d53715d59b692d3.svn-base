/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>BaseEdge</code>.
 * Since this class is abstract, a mock subclass named <code>MockBaseEdge</code> is used for testing.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class BaseEdgeUnitTests extends TestCase {

    /** <code>BaseEdge</code> instance used for testing. */
    private BaseEdge baseEdge;

    /** <code>GraphEdge</code> instance used for testing. */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        graphEdge = UnitTestsHelper.createGraphEdgeForAbstractionEdge();
        baseEdge = new MockBaseEdge(graphEdge, new LineStyle(5, 0), new OpenArrow(), new ClosedArrow());
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        graphEdge = null;
        baseEdge = null;
    }

    /**
     * <p>
     * Failure test of constructor <code>BaseEdge(GraphEdge, LineStyle, EdgeEnding, EdgeEnding)</code>.
     * With null <code>graphEdge</code>.
     * Should throw IAE.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Failure_NullGraphEdge() throws Exception {
        try {
            new MockBaseEdge(null, new LineStyle(5, 0), null, null);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Failure test of constructor <code>BaseEdge(GraphEdge, LineStyle, EdgeEnding, EdgeEnding)</code>.
     * With null <code>lineStyle</code>.
     * Should throw IAE.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Failure_NullLineStyle() throws Exception {
        try {
            new MockBaseEdge(graphEdge, null, null, null);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Failure test of constructor <code>BaseEdge(GraphEdge, LineStyle, EdgeEnding, EdgeEnding)</code>.
     * With bad <code>GraphEdge</code> structure: doesn't contain 2 way points.
     * Should throw IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Failure_Not2WayPoints() throws Exception {
        graphEdge.removeWaypoint(0);

        try {
            new MockBaseEdge(graphEdge, new LineStyle(5, 0), null, null);
            fail("Should throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            //pass
        }
    }

    /**
     * <p>
     * Accuracy test of constructor <code>BaseEdge(GraphEdge, LineStyle, EdgeEnding, EdgeEnding)</code>.
     * Should create the instance successfully.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Accuracy() throws Exception {
        assertNotNull("Should create the instance successfully.", baseEdge);
    }

    /**
     * <p>
     * Accuracy test of method <code>getNameCompartment()</code>.
     * Should return the name compartment.
     * </p>
     */
    public void testGetNameCompartment() {
        assertNotNull("Should return the name compartment.", baseEdge.getNameCompartment());
    }

    /**
     * <p>
     * Accuracy test of method <code>getStereotypeCompartment()</code>.
     * Should return the stereotype compartment.
     * </p>
     */
    public void testGetStereotypeCompartment() {
        assertNotNull("Should return the stereotype compartment.", baseEdge.getStereotypeCompartment());
    }

    /**
     * <p>
     * Accuracy test of method <code>consumeEvent(MouseEvent)</code>.
     * Should return false.
     * </p>
     */
    public void testConsumeEvent() {
        assertFalse("Should return false.", baseEdge.consumeEvent(null));
    }

    /**
     * <p>
     * Accuracy test of method <code>notifyNameVisibilityChanged()</code>.
     * Should notify name visibility changed.
     * </p>
     */
    public void testNotifyNameVisibilityChanged() {
        baseEdge.notifyNameVisibilityChanged();
        String message = ((MockBaseEdge) baseEdge).getMessage();
        assertTrue("Should notify name visibility changed.", message.startsWith("name"));
    }

    /**
     * <p>
     * Accuracy test of method <code>notifyStereotypeVisibilityChanged()</code>.
     * Should notify stereotype visibility changed.
     * </p>
     */
    public void testNotifyStereotypeVisibilityChanged() {
        baseEdge.notifyStereotypeVisibilityChanged();
        String message = ((MockBaseEdge) baseEdge).getMessage();
        assertTrue("Should notify stereotype visibility changed.", message.startsWith("stereotype"));
    }

}
