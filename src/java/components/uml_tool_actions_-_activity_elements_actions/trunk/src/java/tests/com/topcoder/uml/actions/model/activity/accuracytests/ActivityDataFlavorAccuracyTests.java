/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.awt.datatransfer.DataFlavor;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.ActivityDataFlavor;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * This class aggregates accuracy tests for ActivityDataFlavor class.
 *
 * @author ch_music
 * @version 1.0
 */
public class ActivityDataFlavorAccuracyTests extends TestCase {

    /**
     * This is a placeholder for the tested DataFlavor instance.
     */
    private DataFlavor test;

    /**
     * Tests ACCEPT_EVENT_ACTION public static variable.
     */
    public void testPublicStaticVar_ACCEPT_EVENT_ACTION() {
        test = ActivityDataFlavor.ACCEPT_EVENT_ACTION;
        assertNotNull("Not supposed to return null.", test);
        assertEquals("Not DataFlavor type", DataFlavor.class, test.getClass());
        assertEquals("Wrong representation class.", SimpleState.class, test.getRepresentationClass());
        assertEquals("Wrong human presentable name.", "AcceptEventAction", test.getHumanPresentableName());
    }

    /**
     * Tests INITIAL_NODE public static variable.
     */
    public void testPublicStaticVar_INITIAL_NODE() {
        test = ActivityDataFlavor.INITIAL_NODE;
        assertNotNull("Not supposed to return null.", test);
        assertEquals("Not DataFlavor type", DataFlavor.class, test.getClass());
        assertEquals("Wrong representation class.", Pseudostate.class, test.getRepresentationClass());
        assertEquals("Wrong human presentable name.", "InitialNode", test.getHumanPresentableName());
    }

    /**
     * Tests OBJECT_FLOW_STATE public static variable.
     */
    public void testPublicStaticVar_OBJECT_FLOW_STATE() {
        test = ActivityDataFlavor.OBJECT_FLOW_STATE;
        assertNotNull("Not supposed to return null.", test);
        assertEquals("Not DataFlavor type", DataFlavor.class, test.getClass());
        assertEquals("Wrong representation class.", ObjectFlowState.class, test.getRepresentationClass());
        assertEquals("Wrong human presentable name.", "ObjectFlowState", test.getHumanPresentableName());
    }

    /**
     * Tests ACTION_STATE public static variable.
     */
    public void testPublicStaticVar_ACTION_STATE() {
        test = ActivityDataFlavor.ACTION_STATE;
        assertNotNull("Not supposed to return null.", test);
        assertEquals("Not DataFlavor type", DataFlavor.class, test.getClass());
        assertEquals("Wrong representation class.", ActionState.class, test.getRepresentationClass());
        assertEquals("Wrong human presentable name.", "ActionState", test.getHumanPresentableName());
    }

    /**
     * Tests SEND_SIGNAL_ACTION public static variable.
     */
    public void testPublicStaticVar_SEND_SIGNAL_ACTION() {
        test = ActivityDataFlavor.SEND_SIGNAL_ACTION;
        assertNotNull("Not supposed to return null.", test);
        assertEquals("Not DataFlavor type", DataFlavor.class, test.getClass());
        assertEquals("Wrong representation class.", SimpleState.class, test.getRepresentationClass());
        assertEquals("Wrong human presentable name.", "SendSignalAction", test.getHumanPresentableName());
    }

    /**
     * Tests FORK_NODE public static variable.
     */
    public void testPublicStaticVar_FORK_NODE() {
        test = ActivityDataFlavor.FORK_NODE;
        assertNotNull("Not supposed to return null.", test);
        assertEquals("Not DataFlavor type", DataFlavor.class, test.getClass());
        assertEquals("Wrong representation class.", Pseudostate.class, test.getRepresentationClass());
        assertEquals("Wrong human presentable name.", "ForkNode", test.getHumanPresentableName());
    }

    /**
     * Tests JOIN_NODE public static variable.
     */
    public void testPublicStaticVar_JOIN_NODE() {
        test = ActivityDataFlavor.JOIN_NODE;
        assertNotNull("Not supposed to return null.", test);
        assertEquals("Not DataFlavor type", DataFlavor.class, test.getClass());
        assertEquals("Wrong representation class.", Pseudostate.class, test.getRepresentationClass());
        assertEquals("Wrong human presentable name.", "JoinNode", test.getHumanPresentableName());
    }

    /**
     * Tests DECISION_NODE public static variable.
     */
    public void testPublicStaticVar_DECISION_NODE() {
        test = ActivityDataFlavor.DECISION_NODE;
        assertNotNull("Not supposed to return null.", test);
        assertEquals("Not DataFlavor type", DataFlavor.class, test.getClass());
        assertEquals("Wrong representation class.", Pseudostate.class, test.getRepresentationClass());
        assertEquals("Wrong human presentable name.", "DecisionNode", test.getHumanPresentableName());
    }

    /**
     * Tests FLOW_FINAL_NODE public static variable.
     */
    public void testPublicStaticVar_FLOW_FINAL_NODE() {
        test = ActivityDataFlavor.FLOW_FINAL_NODE;
        assertNotNull("Not supposed to return null.", test);
        assertEquals("Not DataFlavor type", DataFlavor.class, test.getClass());
        assertEquals("Wrong representation class.", FinalState.class, test.getRepresentationClass());
        assertEquals("Wrong human presentable name.", "FlowFinalNode", test.getHumanPresentableName());
    }

    /**
     * Tests FINAL_NODE public static variable.
     */
    public void testPublicStaticVar_FINAL_NODE() {
        test = ActivityDataFlavor.FINAL_NODE;
        assertNotNull("Not supposed to return null.", test);
        assertEquals("Not DataFlavor type", DataFlavor.class, test.getClass());
        assertEquals("Wrong representation class.", FinalState.class, test.getRepresentationClass());
        assertEquals("Wrong human presentable name.", "FinalNode", test.getHumanPresentableName());
    }

    /**
     * Tests TRANSITION public static variable.
     */
    public void testPublicStaticVar_TRANSITION() {
        test = ActivityDataFlavor.TRANSITION;
        assertNotNull("Not supposed to return null.", test);
        assertEquals("Not DataFlavor type", DataFlavor.class, test.getClass());
        assertEquals("Wrong representation class.", Transition.class, test.getRepresentationClass());
        assertEquals("Wrong human presentable name.", "Transition", test.getHumanPresentableName());
    }
}
