/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;

/**
 * <p>
 * Unit tests on class <code>PastePolylineAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class PastePolylineActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>PastePolylineAction</code> used in this test.
     * </p>
     */
    private PastePolylineAction action;

    /**
     * <p>
     * Polyline graph edge.
     * </p>
     */
    private GraphEdge polylineGraphEdge;
    /**
     * <p>
     * Diagram.
     * </p>
     */
    private GraphNode diagram;
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
        this.diagram = new Diagram();
        this.action = new PastePolylineAction(this.polylineGraphEdge, this.diagram);
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
     * Test method <code>PastePolylineAction(Object content, GraphNode diagram)</code>
     * for failure with null polylineGraphEdge, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullPolylineGraphEdge() {
        try {
            new PastePolylineAction(null, this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>PastePolylineAction(Object content, GraphNode diagram)</code>
     * for failure with null diagram, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullDiagram() {
        try {
            new PastePolylineAction(this.polylineGraphEdge, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>PastePolylineAction(Object content, GraphNode diagram)</code>
     * for failure with non-GraphEdge polylineGraphEdge, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testCtor_NonGraphEdgePolylineGraphEdge() {
        try {
            new PastePolylineAction("String", this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>PastePolylineAction(Object content, GraphNode diagram)</code>
     * for failure with polylineGraphEdge has no Polyline, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_IllegalPolylineGraphEdge() {
        try {
            new PastePolylineAction(new GraphEdge(), this.diagram);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>PastePolylineAction(Object content, GraphNode diagram)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new PastePolylineAction(this.polylineGraphEdge, this.diagram));
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Paste Polyline", this.action.getPresentationName());
    }
}
