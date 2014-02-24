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
import com.topcoder.gui.diagramviewer.uml.activityelements.MergeNode;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Failure test for <code>{@link MergeNode}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class MergeNodeFailureTests extends TestCase {
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
        pseudostate.setKind(PseudostateKind.JUNCTION);
        graphNode = FailureTestHelper.createGraphNodeForState(pseudostate);
    }

    /**
     * <p>
     * Failure test <code>{@link MergeNode}</code> constructor.
     * </p>
     */
    public void testMergeNodeIAE1() {
        try {
            new MergeNode(null, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link MergeNode}</code> constructor.
     * </p>
     */
    public void testMergeNodeIAE2() {
        try {
            new MergeNode(graphNode, null, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link MergeNode}</code> constructor.
     * </p>
     */
    public void testMergeNodeIAE3() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "Hello");
        try {
            new MergeNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link MergeNode}</code> constructor.
     * </p>
     */
    public void testMergeNodeIAE4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", null);
        try {
            new MergeNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link MergeNode}</code> constructor.
     * </p>
     */
    public void testMergeNodeIAE5() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new MergeNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link MergeNode}</code> constructor.
     * </p>
     */
    public void testMergeNodeIAE6() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new MergeNode(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link MergeNode}</code> constructor.
     * </p>
     */
    public void testMergeNodeIAE8() {
        try {
            new MergeNode(graphNode, new HashMap<String, String>(), null, new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link MergeNode}</code> constructor.
     * </p>
     */
    public void testMergeNodeIAE9() {
        try {
            new MergeNode(graphNode, new HashMap<String, String>(), new Point(), null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link MergeNode}</code> constructor.
     * </p>
     */
    public void testMergeNodeIllegalGraphElementException1() {
        graphNode.clearContaineds();
        try {
            new MergeNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link MergeNode}</code> constructor.
     * </p>
     */
    public void testMergeNodeIllegalGraphElementException2() {
        graphNode.removeContained(0);
        try {
            new MergeNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link MergeNode}</code> constructor.
     * </p>
     */
    public void testMergeNodeIllegalGraphElementException3() {
        graphNode.addContained(graphNode);
        try {
            new MergeNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link MergeNode}</code> constructor.
     * </p>
     */
    public void testMergeNodeIllegalGraphElementException4() {
        graphNode.addContained(0, new GraphEdge());
        try {
            new MergeNode(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }
}
