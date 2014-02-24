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
import com.topcoder.gui.diagramviewer.uml.activityelements.ActionState;
import com.topcoder.gui.diagramviewer.uml.activityelements.IllegalGraphElementException;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link ActionState}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ActionStateFailureTests extends TestCase {
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

        graphNode = FailureTestHelper.createGraphNodeForAction(new ActionStateImpl());
    }

    /**
     * <p>
     * Failure test <code>{@link ActionState}</code> constructor.
     * </p>
     */
    public void testActionStateIAE1() {
        try {
            new ActionState(null, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ActionState}</code> constructor.
     * </p>
     */
    public void testActionStateIAE2() {
        try {
            new ActionState(graphNode, null, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ActionState}</code> constructor.
     * </p>
     */
    public void testActionStateIAE3() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "Hello");
        try {
            new ActionState(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ActionState}</code> constructor.
     * </p>
     */
    public void testActionStateIAE4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", null);
        try {
            new ActionState(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ActionState}</code> constructor.
     * </p>
     */
    public void testActionStateIAE5() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new ActionState(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ActionState}</code> constructor.
     * </p>
     */
    public void testActionStateIAE6() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new ActionState(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ActionState}</code> constructor.
     * </p>
     */
    public void testActionStateIAE8() {
        try {
            new ActionState(graphNode, new HashMap<String, String>(), null, new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ActionState}</code> constructor.
     * </p>
     */
    public void testActionStateIAE9() {
        try {
            new ActionState(graphNode, new HashMap<String, String>(), new Point(), null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ActionState}</code> constructor.
     * </p>
     */
    public void testActionStateIllegalGraphElementException1() {
        graphNode.clearContaineds();
        try {
            new ActionState(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ActionState}</code> constructor.
     * </p>
     */
    public void testActionStateIllegalGraphElementException2() {
        graphNode.removeContained(0);
        try {
            new ActionState(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ActionState}</code> constructor.
     * </p>
     */
    public void testActionStateIllegalGraphElementException3() {
        graphNode.addContained(graphNode);
        try {
            new ActionState(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link ActionState}</code> constructor.
     * </p>
     */
    public void testActionStateIllegalGraphElementException4() {
        graphNode.addContained(0, new GraphEdge());
        try {
            new ActionState(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }
}
