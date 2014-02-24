/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.DataFlavor;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.Transition;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ActivityDataFlavor.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActivityDataFlavorTests extends TestCase {

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ActivityDataFlavorTests.class);
    }

    /**
     * <p>
     * Tests the data flavor for initial node for accuracy.
     * </p>
     *
     * <p>
     * Verify : representation class and hum presentable name are verified.
     * </p>
     */
    public void testInitailNodeFlavor() {
        DataFlavor flavor = ActivityDataFlavor.INITIAL_NODE;

        assertEquals("Failed to get the correct representation class.", Pseudostate.class,
            flavor.getRepresentationClass());
        assertEquals("Failed to get the correct human presentable name.", "InitialNode",
            flavor.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests the data flavor for object flow state for accuracy.
     * </p>
     *
     * <p>
     * Verify : representation class and hum presentable name are verified.
     * </p>
     */
    public void testObjectFlowState() {
        DataFlavor flavor = ActivityDataFlavor.OBJECT_FLOW_STATE;

        assertEquals("Failed to get the correct representation class.", ObjectFlowState.class,
            flavor.getRepresentationClass());
        assertEquals("Failed to get the correct human presentable name.", "ObjectFlowState",
            flavor.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests the data flavor for action state for accuracy.
     * </p>
     *
     * <p>
     * Verify : representation class and hum presentable name are verified.
     * </p>
     */
    public void testActionState() {
        DataFlavor flavor = ActivityDataFlavor.ACTION_STATE;

        assertEquals("Failed to get the correct representation class.", ActionState.class,
            flavor.getRepresentationClass());
        assertEquals("Failed to get the correct human presentable name.", "ActionState",
            flavor.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests the data flavor for send signal action for accuracy.
     * </p>
     *
     * <p>
     * Verify : representation class and hum presentable name are verified.
     * </p>
     */
    public void testSendSignalAction() {
        DataFlavor flavor = ActivityDataFlavor.SEND_SIGNAL_ACTION;

        assertEquals("Failed to get the correct representation class.", SimpleState.class,
            flavor.getRepresentationClass());
        assertEquals("Failed to get the correct human presentable name.", "SendSignalAction",
            flavor.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests the data flavor for accept event action for accuracy.
     * </p>
     *
     * <p>
     * Verify : representation class and hum presentable name are verified.
     * </p>
     */
    public void testAcceptEventAction() {
        DataFlavor flavor = ActivityDataFlavor.ACCEPT_EVENT_ACTION;

        assertEquals("Failed to get the correct representation class.", SimpleState.class,
            flavor.getRepresentationClass());
        assertEquals("Failed to get the correct human presentable name.", "AcceptEventAction",
            flavor.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests the data flavor for fork node for accuracy.
     * </p>
     *
     * <p>
     * Verify : representation class and hum presentable name are verified.
     * </p>
     */
    public void testForkNode() {
        DataFlavor flavor = ActivityDataFlavor.FORK_NODE;

        assertEquals("Failed to get the correct representation class.", Pseudostate.class,
            flavor.getRepresentationClass());
        assertEquals("Failed to get the correct human presentable name.", "ForkNode", flavor.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests the data flavor for join node for accuracy.
     * </p>
     *
     * <p>
     * Verify : representation class and hum presentable name are verified.
     * </p>
     */
    public void testJoinNode() {
        DataFlavor flavor = ActivityDataFlavor.JOIN_NODE;

        assertEquals("Failed to get the correct representation class.", Pseudostate.class,
            flavor.getRepresentationClass());
        assertEquals("Failed to get the correct human presentable name.", "JoinNode", flavor.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests the data flavor for decision node for accuracy.
     * </p>
     *
     * <p>
     * Verify : representation class and hum presentable name are verified.
     * </p>
     */
    public void testDecisionNode() {
        DataFlavor flavor = ActivityDataFlavor.DECISION_NODE;

        assertEquals("Failed to get the correct representation class.", Pseudostate.class,
            flavor.getRepresentationClass());
        assertEquals("Failed to get the correct human presentable name.", "DecisionNode",
            flavor.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests the data flavor for merge node for accuracy.
     * </p>
     *
     * <p>
     * Verify : representation class and hum presentable name are verified.
     * </p>
     */
    public void testMergeNode() {
        DataFlavor flavor = ActivityDataFlavor.MERGE_NODE;

        assertEquals("Failed to get the correct representation class.", Pseudostate.class,
            flavor.getRepresentationClass());
        assertEquals("Failed to get the correct human presentable name.",
            "MergeNode", flavor.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests the data flavor for flow final node for accuracy.
     * </p>
     *
     * <p>
     * Verify : representation class and hum presentable name are verified.
     * </p>
     */
    public void testFlowFinalNode() {
        DataFlavor flavor = ActivityDataFlavor.FLOW_FINAL_NODE;

        assertEquals("Failed to get the correct representation class.", FinalState.class,
            flavor.getRepresentationClass());
        assertEquals("Failed to get the correct human presentable name.", "FlowFinalNode",
            flavor.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests the data flavor for final node for accuracy.
     * </p>
     *
     * <p>
     * Verify : representation class and hum presentable name are verified.
     * </p>
     */
    public void testFinalNode() {
        DataFlavor flavor = ActivityDataFlavor.FINAL_NODE;

        assertEquals("Failed to get the correct representation class.", FinalState.class,
            flavor.getRepresentationClass());
        assertEquals("Failed to get the correct human presentable name.",
            "FinalNode", flavor.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests the data flavor for transition for accuracy.
     * </p>
     *
     * <p>
     * Verify : representation class and hum presentable name are verified.
     * </p>
     */
    public void testTransition() {
        DataFlavor flavor = ActivityDataFlavor.TRANSITION;

        assertEquals("Failed to get the correct representation class.", Transition.class,
            flavor.getRepresentationClass());
        assertEquals("Failed to get the correct human presentable name.", "Transition",
            flavor.getHumanPresentableName());
    }
}