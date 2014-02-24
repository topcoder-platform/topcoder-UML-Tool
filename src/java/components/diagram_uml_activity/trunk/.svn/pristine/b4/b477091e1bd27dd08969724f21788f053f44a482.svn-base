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
import com.topcoder.gui.diagramviewer.uml.activityelements.FinalNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.IllegalGraphElementException;
import com.topcoder.uml.model.statemachines.FinalStateImpl;

/**
 * <p>
 * Failure test for <code>{@link FinalNode}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class FinalNodeFailureTests extends TestCase {
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
     * Failure test <code>{@link FinalNode}</code> constructor.
     * </p>
     */
    public void testFinalNodeIAE1() {
        try {
            new FinalNode(null, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FinalNode}</code> constructor.
     * </p>
     */
    public void testFinalNodeIAE2() {
        try {
            new FinalNode(graphNode, null, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FinalNode}</code> constructor.
     * </p>
     */
    public void testFinalNodeIAE3() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "Hello");
        try {
            new FinalNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FinalNode}</code> constructor.
     * </p>
     */
    public void testFinalNodeIAE4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", null);
        try {
            new FinalNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FinalNode}</code> constructor.
     * </p>
     */
    public void testFinalNodeIAE5() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new FinalNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FinalNode}</code> constructor.
     * </p>
     */
    public void testFinalNodeIAE6() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new FinalNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FinalNode}</code> constructor.
     * </p>
     */
    public void testFinalNodeIAE8() {
        try {
            new FinalNode(graphNode, new HashMap<String, String>(), null, new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FinalNode}</code> constructor.
     * </p>
     */
    public void testFinalNodeIAE9() {
        try {
            new FinalNode(graphNode, new HashMap<String, String>(), new Point(), null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FinalNode}</code> constructor.
     * </p>
     */
    public void testFinalNodeIllegalGraphElementException1() {
        graphNode.clearContaineds();
        try {
            new FinalNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FinalNode}</code> constructor.
     * </p>
     */
    public void testFinalNodeIllegalGraphElementException2() {
        graphNode.removeContained(0);
        try {
            new FinalNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FinalNode}</code> constructor.
     * </p>
     */
    public void testFinalNodeIllegalGraphElementException3() {
        graphNode.addContained(graphNode);
        try {
            new FinalNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link FinalNode}</code> constructor.
     * </p>
     */
    public void testFinalNodeIllegalGraphElementException4() {
        graphNode.addContained(0, new GraphEdge());
        try {
            new FinalNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }
}
