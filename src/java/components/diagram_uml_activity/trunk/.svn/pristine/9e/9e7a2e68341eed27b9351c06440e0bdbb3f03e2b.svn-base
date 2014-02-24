/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Test the functionality of <code>Util</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */

public class UtilTest extends TestCase {

    /**
     * <p>
     * Test the method <code>checkNotNull(Object argument, String name)</code> with <code>null</code> Argument.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testCheckNotNullWithNullArgument() {
        try {
            Util.checkNotNull(null, "test");
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Test the method <code>checkNotNull(Object argument, String name)</code> with non null Argument. No exception
     * should be thrown.
     * </p>
     */
    public void testCheckNotNullWithUnNullArgument() {
        try {
            Util.checkNotNull(new Object(), "test");
        } catch (IllegalArgumentException iae) {
            fail(iae.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>chekMapNotNullOrContainingEmpty(Map map, String name)</code> with <code>null</code>
     * Argument. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testChekMapNotNullOrEmptyWithNull() {
        try {
            Util.chekMapNotNullOrContainingEmpty(null, "test");
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Test the method <code>chekMapNotNullOrContainingEmpty(Map map, String name)</code> with map containing null.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testChekMapWithContainNull() {
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put(null, null);
            Util.chekMapNotNullOrContainingEmpty(map, "test");
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Test the method <code>chekMapNotNullOrContainingEmpty(Map map, String name)</code> with good map. No exception
     * should be thrown.
     * </p>
     */
    public void testChekMapNotNullOrEmpty() {
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("a", "b");
            Util.chekMapNotNullOrContainingEmpty(map, "test");
        } catch (IllegalArgumentException iae) {
            fail(iae.getMessage());
        }
    }

    /**
     * Test method for 'checkGraphEdge(GraphEdge)' with GraphEdge. No exception should be thrown.
     */
    public void testCheckGraphEdge_Accuracy() {
        try {
            GraphEdge graphEdge = TestUtil.createGraphEdgeForTransition();
            Util.checkGraphEdge(graphEdge);
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'checkNodeGraphNode(GraphNode, Class)' with correct node. No exception should be thrown.
     */
    public void testCheckNodeGraphNode_Accuracy() {
        try {
            GraphNode graphNode = TestUtil.createGraphNodeForActivityNode(new PseudostateImpl());
            Util.checkNodeGraphNode(graphNode, Pseudostate.class);
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'checkNodeGraphNode(GraphNode, Class)' with wrong node. IllegalGraphElementException should be
     * thrown.
     */
    public void testCheckNodeGraphNode_Failure() {
        try {
            GraphNode graphNode = TestUtil.createGraphNodeForActivityNode(new PseudostateImpl());
            Util.checkNodeGraphNode(graphNode, FinalState.class);
            fail("IllegalGraphElementException should be thrown");
        } catch (IllegalGraphElementException e) {
            // Success
        }
    }

    /**
     * Test method for 'checkActionGraphNode(GraphNode, Class)' with correct state. No exception should be thrown.
     */
    public void testCheckActionGraphNode_Accuracy() {
        try {
            GraphNode graphNode = TestUtil.createGraphNodeForActivityState(new ActionStateImpl());
            Util.checkActionGraphNode(graphNode, ActionState.class);
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'checkActionGraphNode(GraphNode, Class)' with wrong state. IllegalGraphElementException should be
     * thrown.
     */
    public void testCheckActionGraphNode_Failure() {
        try {
            GraphNode graphNode = TestUtil.createGraphNodeForActivityState(new ObjectFlowStateImpl());
            Util.checkActionGraphNode(graphNode, ActionState.class);
            fail("IllegalGraphElementException should be thrown");
        } catch (IllegalGraphElementException e) {
            // Success
        }
    }

}
