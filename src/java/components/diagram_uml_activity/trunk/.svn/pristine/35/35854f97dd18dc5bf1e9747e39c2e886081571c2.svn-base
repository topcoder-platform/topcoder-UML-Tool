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
import com.topcoder.gui.diagramviewer.uml.activityelements.JoinNode;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Failure test for <code>{@link JoinNode}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class JoinNodeFailureTests extends TestCase {
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

        Pseudostate pseudostate = new PseudostateImpl();
        pseudostate.setKind(PseudostateKind.JOIN);
        graphNode = FailureTestHelper.createGraphNodeForState(pseudostate);
    }

    /**
     * <p>
     * Failure test <code>{@link JoinNode}</code> constructor.
     * </p>
     */
    public void testJoinNodeIAE1() {
        try {
            new JoinNode(null, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link JoinNode}</code> constructor.
     * </p>
     */
    public void testJoinNodeIAE2() {
        try {
            new JoinNode(graphNode, null, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link JoinNode}</code> constructor.
     * </p>
     */
    public void testJoinNodeIAE3() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "Hello");
        try {
            new JoinNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link JoinNode}</code> constructor.
     * </p>
     */
    public void testJoinNodeIAE4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", null);
        try {
            new JoinNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link JoinNode}</code> constructor.
     * </p>
     */
    public void testJoinNodeIAE5() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new JoinNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link JoinNode}</code> constructor.
     * </p>
     */
    public void testJoinNodeIAE6() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new JoinNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link JoinNode}</code> constructor.
     * </p>
     */
    public void testJoinNodeIAE8() {
        try {
            new JoinNode(graphNode, new HashMap<String, String>(), null, new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link JoinNode}</code> constructor.
     * </p>
     */
    public void testJoinNodeIAE9() {
        try {
            new JoinNode(graphNode, new HashMap<String, String>(), new Point(), null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link JoinNode}</code> constructor.
     * </p>
     */
    public void testJoinNodeIllegalGraphElementException1() {
        graphNode.clearContaineds();
        try {
            new JoinNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link JoinNode}</code> constructor.
     * </p>
     */
    public void testJoinNodeIllegalGraphElementException2() {
        graphNode.removeContained(0);
        try {
            new JoinNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link JoinNode}</code> constructor.
     * </p>
     */
    public void testJoinNodeIllegalGraphElementException3() {
        graphNode.addContained(graphNode);
        try {
            new JoinNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link JoinNode}</code> constructor.
     * </p>
     */
    public void testJoinNodeIllegalGraphElementException4() {
        graphNode.addContained(0, new GraphEdge());
        try {
            new JoinNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }
}
