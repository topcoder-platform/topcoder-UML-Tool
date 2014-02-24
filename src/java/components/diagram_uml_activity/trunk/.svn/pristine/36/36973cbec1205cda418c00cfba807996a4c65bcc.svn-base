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
import com.topcoder.gui.diagramviewer.uml.activityelements.SendSignalAction;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;

/**
 * <p>
 * Failure test for <code>{@link SendSignalAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class SendSignalActionFailureTests extends TestCase {
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

        graphNode = FailureTestHelper.createGraphNodeForAction(new SimpleStateImpl());
    }

    /**
     * <p>
     * Failure test <code>{@link SendSignalAction}</code> constructor.
     * </p>
     */
    public void testSendSignalActionIAE1() {
        try {
            new SendSignalAction(null, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link SendSignalAction}</code> constructor.
     * </p>
     */
    public void testSendSignalActionIAE2() {
        try {
            new SendSignalAction(graphNode, null, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link SendSignalAction}</code> constructor.
     * </p>
     */
    public void testSendSignalActionIAE3() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "Hello");
        try {
            new SendSignalAction(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link SendSignalAction}</code> constructor.
     * </p>
     */
    public void testSendSignalActionIAE4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", null);
        try {
            new SendSignalAction(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link SendSignalAction}</code> constructor.
     * </p>
     */
    public void testSendSignalActionIAE5() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new SendSignalAction(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link SendSignalAction}</code> constructor.
     * </p>
     */
    public void testSendSignalActionIAE6() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new SendSignalAction(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link SendSignalAction}</code> constructor.
     * </p>
     */
    public void testSendSignalActionIAE8() {
        try {
            new SendSignalAction(graphNode, new HashMap<String, String>(), null, new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link SendSignalAction}</code> constructor.
     * </p>
     */
    public void testSendSignalActionIAE9() {
        try {
            new SendSignalAction(graphNode, new HashMap<String, String>(), new Point(), null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link SendSignalAction}</code> constructor.
     * </p>
     */
    public void testSendSignalActionIllegalGraphElementException1() {
        graphNode.clearContaineds();
        try {
            new SendSignalAction(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link SendSignalAction}</code> constructor.
     * </p>
     */
    public void testSendSignalActionIllegalGraphElementException2() {
        graphNode.removeContained(0);
        try {
            new SendSignalAction(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link SendSignalAction}</code> constructor.
     * </p>
     */
    public void testSendSignalActionIllegalGraphElementException3() {
        graphNode.addContained(graphNode);
        try {
            new SendSignalAction(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link SendSignalAction}</code> constructor.
     * </p>
     */
    public void testSendSignalActionIllegalGraphElementException4() {
        graphNode.addContained(0, new GraphEdge());
        try {
            new SendSignalAction(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }
}
