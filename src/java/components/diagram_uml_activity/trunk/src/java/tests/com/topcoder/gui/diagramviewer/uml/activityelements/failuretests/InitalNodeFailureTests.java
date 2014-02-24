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
import com.topcoder.gui.diagramviewer.uml.activityelements.InitialNode;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Failure test for <code>{@link InitialNode}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class InitalNodeFailureTests extends TestCase {
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
        pseudostate.setKind(PseudostateKind.INITIAL);
        graphNode = FailureTestHelper.createGraphNodeForState(pseudostate);
    }

    /**
     * <p>
     * Failure test <code>{@link InitialNode}</code> constructor.
     * </p>
     */
    public void testInitialNodeIAE1() {
        try {
            new InitialNode(null, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link InitialNode}</code> constructor.
     * </p>
     */
    public void testInitialNodeIAE2() {
        try {
            new InitialNode(graphNode, null, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link InitialNode}</code> constructor.
     * </p>
     */
    public void testInitialNodeIAE3() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "Hello");
        try {
            new InitialNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link InitialNode}</code> constructor.
     * </p>
     */
    public void testInitialNodeIAE4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", null);
        try {
            new InitialNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link InitialNode}</code> constructor.
     * </p>
     */
    public void testInitialNodeIAE5() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new InitialNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link InitialNode}</code> constructor.
     * </p>
     */
    public void testInitialNodeIAE6() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new InitialNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link InitialNode}</code> constructor.
     * </p>
     */
    public void testInitialNodeIAE8() {
        try {
            new InitialNode(graphNode, new HashMap<String, String>(), null, new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link InitialNode}</code> constructor.
     * </p>
     */
    public void testInitialNodeIAE9() {
        try {
            new InitialNode(graphNode, new HashMap<String, String>(), new Point(), null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link InitialNode}</code> constructor.
     * </p>
     */
    public void testInitialNodeIllegalGraphElementException1() {
        graphNode.clearContaineds();
        try {
            new InitialNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link InitialNode}</code> constructor.
     * </p>
     */
    public void testInitialNodeIllegalGraphElementException2() {
        graphNode.removeContained(0);
        try {
            new InitialNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link InitialNode}</code> constructor.
     * </p>
     */
    public void testInitialNodeIllegalGraphElementException3() {
        graphNode.addContained(graphNode);
        try {
            new InitialNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link InitialNode}</code> constructor.
     * </p>
     */
    public void testInitialNodeIllegalGraphElementException4() {
        graphNode.addContained(0, new GraphEdge());
        try {
            new InitialNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }
}
