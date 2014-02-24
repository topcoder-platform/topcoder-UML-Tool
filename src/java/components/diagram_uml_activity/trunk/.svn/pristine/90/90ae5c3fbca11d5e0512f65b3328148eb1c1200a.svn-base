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
import com.topcoder.gui.diagramviewer.uml.activityelements.FlowFinalNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.IllegalGraphElementException;
import com.topcoder.uml.model.statemachines.FinalStateImpl;

/**
 * <p>
 * Failure test for <code>{@link FlowFinalNode}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class FlowFinalNodeFailureTests extends TestCase {

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

        graphNode = FailureTestHelper.createGraphNodeForState(new FinalStateImpl());
    }

    /**
     * <p>
     * Failure test <code>{@link FlowFinalNode}</code> constructor.
     * </p>
     */
    public void testFlowFinalNodeIAE1() {
        try {
            new FlowFinalNode(null, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FlowFinalNode}</code> constructor.
     * </p>
     */
    public void testFlowFinalNodeIAE2() {
        try {
            new FlowFinalNode(graphNode, null, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FlowFinalNode}</code> constructor.
     * </p>
     */
    public void testFlowFinalNodeIAE3() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "Hello");
        try {
            new FlowFinalNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FlowFinalNode}</code> constructor.
     * </p>
     */
    public void testFlowFinalNodeIAE4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", null);
        try {
            new FlowFinalNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FlowFinalNode}</code> constructor.
     * </p>
     */
    public void testFlowFinalNodeIAE5() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new FlowFinalNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FlowFinalNode}</code> constructor.
     * </p>
     */
    public void testFlowFinalNodeIAE6() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new FlowFinalNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FlowFinalNode}</code> constructor.
     * </p>
     */
    public void testFlowFinalNodeIAE8() {
        try {
            new FlowFinalNode(graphNode, new HashMap<String, String>(), null, new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FlowFinalNode}</code> constructor.
     * </p>
     */
    public void testFlowFinalNodeIAE9() {
        try {
            new FlowFinalNode(graphNode, new HashMap<String, String>(), new Point(), null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FlowFinalNode}</code> constructor.
     * </p>
     */
    public void testFlowFinalNodeIllegalGraphElementException1() {
        graphNode.clearContaineds();
        try {
            new FlowFinalNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FlowFinalNode}</code> constructor.
     * </p>
     */
    public void testFlowFinalNodeIllegalGraphElementException2() {
        graphNode.removeContained(0);
        try {
            new FlowFinalNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FlowFinalNode}</code> constructor.
     * </p>
     */
    public void testFlowFinalNodeIllegalGraphElementException3() {
        graphNode.addContained(graphNode);
        try {
            new FlowFinalNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FlowFinalNode}</code> constructor.
     * </p>
     */
    public void testFlowFinalNodeIllegalGraphElementException4() {
        graphNode.addContained(0, new GraphEdge());
        try {
            new FlowFinalNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }
}
