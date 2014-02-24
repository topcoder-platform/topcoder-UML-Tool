/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.DecisionNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.IllegalGraphElementException;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link DecisionNode}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class DecisionNodeFailureTests extends TestCase {

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
        pseudostate.setKind(PseudostateKind.CHOICE);
        graphNode = FailureTestHelper.createGraphNodeForState(pseudostate);
    }

    /**
     * <p>
     * Failure test <code>{@link DecisionNode}</code> constructor.
     * </p>
     */
    public void testDecisionNodeIAE1() {
        try {
            new DecisionNode(null, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link DecisionNode}</code> constructor.
     * </p>
     */
    public void testDecisionNodeIAE2() {
        try {
            new DecisionNode(graphNode, null, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link DecisionNode}</code> constructor.
     * </p>
     */
    public void testDecisionNodeIAE3() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "Hello");
        try {
            new DecisionNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link DecisionNode}</code> constructor.
     * </p>
     */
    public void testDecisionNodeIAE4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", null);
        try {
            new DecisionNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link DecisionNode}</code> constructor.
     * </p>
     */
    public void testDecisionNodeIAE5() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new DecisionNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link DecisionNode}</code> constructor.
     * </p>
     */
    public void testDecisionNodeIAE6() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new DecisionNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link DecisionNode}</code> constructor.
     * </p>
     */
    public void testDecisionNodeIAE8() {
        try {
            new DecisionNode(graphNode, new HashMap<String, String>(), null, new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link DecisionNode}</code> constructor.
     * </p>
     */
    public void testDecisionNodeIAE9() {
        try {
            new DecisionNode(graphNode, new HashMap<String, String>(), new Point(), null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link DecisionNode}</code> constructor.
     * </p>
     */
    public void testDecisionNodeIllegalGraphElementException1() {
        graphNode.clearContaineds();
        try {
            new DecisionNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link DecisionNode}</code> constructor.
     * </p>
     */
    public void testDecisionNodeIllegalGraphElementException2() {
        graphNode.removeContained(0);
        try {
            new DecisionNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link DecisionNode}</code> constructor.
     * </p>
     */
    public void testDecisionNodeIllegalGraphElementException3() {
        graphNode.addContained(graphNode);
        try {
            new DecisionNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link DecisionNode}</code> constructor.
     * </p>
     */
    public void testDecisionNodeIllegalGraphElementException4() {
        graphNode.addContained(0, new GraphEdge());
        try {
            new DecisionNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }
}
