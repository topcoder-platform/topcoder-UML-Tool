/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.IllegalGraphElementException;
import com.topcoder.gui.diagramviewer.uml.activityelements.ObjectFlowNode;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;

/**
 * <p>
 * Failure test for <code>{@link ObjectFlowNode}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ObjectFlowNodeFailureTests extends TestCase {
    /**
     * <p>
     * Represents the GraphNode instance.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        graphNode = FailureTestHelper.createGraphNodeForAction(new ObjectFlowStateImpl());
    }

    /**
     * <p>
     * Failure test <code>{@link ObjectFlowNode}</code> constructor.
     * </p>
     */
    public void testObjectFlowNodeIAE1() {
        try {
            new ObjectFlowNode(null, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ObjectFlowNode}</code> constructor.
     * </p>
     */
    public void testObjectFlowNodeIAE2() {
        try {
            new ObjectFlowNode(graphNode, null, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ObjectFlowNode}</code> constructor.
     * </p>
     */
    public void testObjectFlowNodeIAE3() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "Hello");
        try {
            new ObjectFlowNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ObjectFlowNode}</code> constructor.
     * </p>
     */
    public void testObjectFlowNodeIAE4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", null);
        try {
            new ObjectFlowNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ObjectFlowNode}</code> constructor.
     * </p>
     */
    public void testObjectFlowNodeIAE5() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new ObjectFlowNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ObjectFlowNode}</code> constructor.
     * </p>
     */
    public void testObjectFlowNodeIAE6() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new ObjectFlowNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ObjectFlowNode}</code> constructor.
     * </p>
     */
    public void testObjectFlowNodeIAE8() {
        try {
            new ObjectFlowNode(graphNode, new HashMap<String, String>(), null, new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ObjectFlowNode}</code> constructor.
     * </p>
     */
    public void testObjectFlowNodeIAE9() {
        try {
            new ObjectFlowNode(graphNode, new HashMap<String, String>(), new Point(), null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ObjectFlowNode}</code> constructor.
     * </p>
     */
    public void testObjectFlowNodeIllegalGraphElementException1() {
        graphNode.clearContaineds();
        try {
            new ObjectFlowNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ObjectFlowNode}</code> constructor.
     * </p>
     */
    public void testObjectFlowNodeIllegalGraphElementException2() {
        graphNode.removeContained(0);
        try {
            new ObjectFlowNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ObjectFlowNode}</code> constructor.
     * </p>
     */
    public void testObjectFlowNodeIllegalGraphElementException3() {
        graphNode.addContained(graphNode);
        try {
            new ObjectFlowNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ObjectFlowNode}</code> constructor.
     * </p>
     */
    public void testObjectFlowNodeIllegalGraphElementException4() {
        graphNode.addContained(0, new GraphEdge());
        try {
            new ObjectFlowNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }
}
