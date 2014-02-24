/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;

/**
 * <p>
 * Unit tests on class <code>RemovePolylineAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class RemovePolylineActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>RemovePolylineAction</code> used in this test.
     * </p>
     */
    private RemovePolylineAction action;

    /**
     * <p>
     * Polyline graph edge.
     * </p>
     */
    private GraphEdge polylineGraphEdge;
    /**
     * <p>
     * Set up environment.
     * </p>
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
        this.polylineGraphEdge = new GraphEdge();
        this.polylineGraphEdge.addContained(new Polyline());
        this.polylineGraphEdge.setContainer(new GraphNode());
        this.action = new RemovePolylineAction(this.polylineGraphEdge);
    }
    /**
     * <p>
     * Clear the environment.
     * </p>
     */
    public void tearDown() {
        UnitTestHelper.clearConfig();
    }

    /**
     * <p>
     * Test method <code>RemovePolylineAction(GraphEdge polylineGraphEdge)</code>
     * for failure with null polylineGraphEdge, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullPolylineGraphEdge() {
        try {
            new RemovePolylineAction(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>RemovePolylineAction(GraphEdge polylineGraphEdge)</code>
     * for failure with polylineGraphEdge has no Polyline, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_IllegalPolylineGraphEdge1() {
        try {
            new RemovePolylineAction(new GraphEdge());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>RemovePolylineAction(GraphEdge polylineGraphEdge)</code>
     * for failure with polylineGraphEdge has no container, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_IllegalPolylineGraphEdge2() {
        this.polylineGraphEdge.setContainer(null);
        try {
            new RemovePolylineAction(this.polylineGraphEdge);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>RemovePolylineAction(GraphEdge polylineGraphEdge)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new RemovePolylineAction(this.polylineGraphEdge));
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Remove Polyline", this.action.getPresentationName());
    }
}
