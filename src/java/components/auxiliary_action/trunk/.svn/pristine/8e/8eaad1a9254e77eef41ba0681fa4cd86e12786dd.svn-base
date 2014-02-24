/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>CutPolylineAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class CutPolylineActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>CutPolylineAction</code> used in this test.
     * </p>
     */
    private CutPolylineAction action;

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
        this.action = new CutPolylineAction(this.polylineGraphEdge, null);
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
     * Test method <code>CutPolylineAction(GraphEdge polylineGraphEdge, Clipboard clipboard)</code>
     * for failure with null polylineGraphEdge, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullPolylineGraphEdge() {
        try {
            new CutPolylineAction(null, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>CutPolylineAction(GraphEdge polylineGraphEdge, Clipboard clipboard)</code>
     * for failure with polylineGraphEdge has no Polyline, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_IllegalPolylineGraphEdge1() {
        try {
            new CutPolylineAction(new GraphEdge(), null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>CutPolylineAction(GraphEdge polylineGraphEdge, Clipboard clipboard)</code>
     * for failure with polylineGraphEdge has no container, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_IllegalPolylineGraphEdge2() {
        this.polylineGraphEdge.setContainer(null);
        try {
            new CutPolylineAction(this.polylineGraphEdge, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>CutPolylineAction(GraphEdge polylineGraphEdge, Clipboard clipboard)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new CutPolylineAction(this.polylineGraphEdge, null));
    }
    /**
     * <p>
     * Test method <code>copyToClipboard(GraphElement node, Clipboard clipboard)</code>
     * for failure with null node, <code>IllegalArgumentException</code>.
     * </p>
     * @throws ActionExecutionException to JUnit
     * @throws AuxiliaryElementCloneException to JUnit
     */
    public void testCopyToClipboard_NullNode() throws AuxiliaryElementCloneException, ActionExecutionException {
        try {
            this.action.copyToClipboard(null, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>copyToClipboard(GraphElement node, Clipboard clipboard)</code>
     * for failure with null node, <code>IllegalArgumentException</code>.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCopyToClipboard_Accuracy() throws Exception {
        Clipboard clipboard = new Clipboard("Test");
        this.action.copyToClipboard(this.polylineGraphEdge, clipboard);
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.POLYLINE);
        assertNotNull("Failed to copy the node!", obj);
        assertTrue("Failed to copy the node!", obj instanceof GraphEdge);
        UnitTestHelper.assertEquals(this.polylineGraphEdge, (GraphEdge) obj, "Failed to copy!");
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Cut Polyline", this.action.getPresentationName());
    }
}
