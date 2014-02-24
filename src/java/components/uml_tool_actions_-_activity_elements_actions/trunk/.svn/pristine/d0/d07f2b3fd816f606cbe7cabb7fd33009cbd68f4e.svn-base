/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.RemoveAcceptEventActionAction;
import com.topcoder.uml.actions.model.activity.RemoveActionStateAction;
import com.topcoder.uml.actions.model.activity.RemoveDecisionNodeAction;
import com.topcoder.uml.actions.model.activity.RemoveFinalNodeAction;
import com.topcoder.uml.actions.model.activity.RemoveFlowFinalNodeAction;
import com.topcoder.uml.actions.model.activity.RemoveForkNodeAction;
import com.topcoder.uml.actions.model.activity.RemoveInitialNodeAction;
import com.topcoder.uml.actions.model.activity.RemoveJoinNodeAction;
import com.topcoder.uml.actions.model.activity.RemoveMergeNodeAction;
import com.topcoder.uml.actions.model.activity.RemoveObjectFlowStateAction;
import com.topcoder.uml.actions.model.activity.RemoveSendSignalActionAction;
import com.topcoder.uml.actions.model.activity.RemoveStateNodeAbstractAction;

/**
 * This class tests the concrete implementation classes of RemoveStateNodeAbstractAction abstract class.
 *
 * @author ch_music
 * @version 1.0
 */
public class RemoveStateNodeAbstractActionImplementationsAccuracyTests extends TestCase {

    /**
     * A RemoveStateNodeAbstractAction instance used for testing.
     */
    private RemoveStateNodeAbstractAction test;

    /**
     * Sets up the environment for testing.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.LOG_NAMESPACE, AccuracyTestHelper.LOG_CONFIGPATH);
    }

    /**
     * Tears down the environment.
     */
    protected void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests RemoveAcceptEventActionAction constructor.
     */
    public void testRemoveAcceptEventActionAction() {
        test = new RemoveAcceptEventActionAction(AccuracyTestHelper.createAcceptEventAction());
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Remove Accept Event Action", test
                .getPresentationName());
    }

    /**
     * Tests RemoveActionStateAction constructor.
     */
    public void testRemoveActionStateAction() {
        test = new RemoveActionStateAction(AccuracyTestHelper.createActionState());
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Remove Action State", test
                .getPresentationName());
    }

    /**
     * Tests RemoveDecisionNodeAction constructor.
     */
    public void testRemoveDecisionNodeAction() {
        test = new RemoveDecisionNodeAction(AccuracyTestHelper.createDecisionNode());
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Remove Decision Node", test
                .getPresentationName());
    }

    /**
     * Tests RemoveFinalNodeAction constructor.
     */
    public void testRemoveFinalNodeAction() {
        test = new RemoveFinalNodeAction(AccuracyTestHelper.createFinalNode());
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Remove Final Node", test
                .getPresentationName());
    }

    /**
     * Tests RemoveFlowFinalNodeAction constructor.
     */
    public void testRemoveFlowFinalNodeAction() {
        test = new RemoveFlowFinalNodeAction(AccuracyTestHelper.createFlowFinalNode());
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Remove Flow Final Node", test
                .getPresentationName());
    }

    /**
     * Tests RemoveForkNodeAction constructor.
     */
    public void testRemoveForkNodeAction() {
        test = new RemoveForkNodeAction(AccuracyTestHelper.createForkNode());
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Remove Fork Node", test
                .getPresentationName());
    }

    /**
     * Tests RemoveInitialNodeAction constructor.
     */
    public void testRemoveInitialNodeAction() {
        test = new RemoveInitialNodeAction(AccuracyTestHelper.createInitialNode());
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Remove Initial Node", test
                .getPresentationName());
    }

    /**
     * Tests RemoveJoinNodeAction constructor.
     */
    public void testRemoveJoinNodeAction() {
        test = new RemoveJoinNodeAction(AccuracyTestHelper.createJoinNode());
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Remove Join Node", test
                .getPresentationName());
    }

    /**
     * Tests RemoveMergeNodeAction constructor.
     */
    public void testRemoveMergeNodeAction() {
        test = new RemoveMergeNodeAction(AccuracyTestHelper.createMergeNode());
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Remove Merge Node", test
                .getPresentationName());
    }

    /**
     * Tests RemoveObjectFlowStateAction constructor.
     */
    public void testRemoveObjectFlowStateAction() {
        test = new RemoveObjectFlowStateAction(AccuracyTestHelper.createObjectFlowState());
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Remove Object Flow State", test
                .getPresentationName());
    }

    /**
     * Tests RemoveSendSignalActionAction constructor.
     */
    public void testRemoveSendSignalActionAction() {
        test = new RemoveSendSignalActionAction(AccuracyTestHelper.createSendSignalAction());
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Remove Send Signal Action", test
                .getPresentationName());
    }
}
