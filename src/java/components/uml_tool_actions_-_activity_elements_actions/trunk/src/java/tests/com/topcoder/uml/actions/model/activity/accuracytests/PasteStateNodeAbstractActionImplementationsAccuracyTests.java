/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.PasteAcceptEventActionAction;
import com.topcoder.uml.actions.model.activity.PasteActionStateAction;
import com.topcoder.uml.actions.model.activity.PasteDecisionNodeAction;
import com.topcoder.uml.actions.model.activity.PasteFinalNodeAction;
import com.topcoder.uml.actions.model.activity.PasteFlowFinalNodeAction;
import com.topcoder.uml.actions.model.activity.PasteForkNodeAction;
import com.topcoder.uml.actions.model.activity.PasteInitialNodeAction;
import com.topcoder.uml.actions.model.activity.PasteJoinNodeAction;
import com.topcoder.uml.actions.model.activity.PasteMergeNodeAction;
import com.topcoder.uml.actions.model.activity.PasteObjectFlowStateAction;
import com.topcoder.uml.actions.model.activity.PasteSendSignalActionAction;
import com.topcoder.uml.actions.model.activity.PasteStateNodeAbstractAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;

/**
 * This class aggregates accuracy tests for PasteStateNodeAbstractAction concrete implementation classes.
 *
 * @author ch_music
 * @version 1.0
 */
public class PasteStateNodeAbstractActionImplementationsAccuracyTests extends TestCase {

    /**
     * A PasteStateNodeAbstractAction instance used for testing.
     */
    private PasteStateNodeAbstractAction test;

    /**
     * An ActivityGraph instance used for testing.
     */
    private ActivityGraph activityGraph;

    /**
     * Sets up the environment for testing.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.LOG_NAMESPACE, AccuracyTestHelper.LOG_CONFIGPATH);

        activityGraph = new ActivityGraphImpl();
        activityGraph.setTop(new CompositeStateImpl());
    }

    /**
     * Tears down the environment.
     */
    protected void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests PasteAcceptEventActionAction constructor.
     */
    public void testPasteAcceptEventActionAction() {
        test = new PasteAcceptEventActionAction(AccuracyTestHelper.createAcceptEventAction(), activityGraph);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Paste Accept Event Action", test
                .getPresentationName());
    }

    /**
     * Tests PasteActionStateAction constructor.
     */
    public void testPasteActionStateAction() {
        test = new PasteActionStateAction(AccuracyTestHelper.createActionState(), activityGraph);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Paste Action State", test
                .getPresentationName());
    }

    /**
     * Tests PasteDecisionNodeAction constructor.
     */
    public void testPasteDecisionNodeAction() {
        test = new PasteDecisionNodeAction(AccuracyTestHelper.createDecisionNode(), activityGraph);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Paste Decision Node", test
                .getPresentationName());
    }

    /**
     * Tests PasteFinalNodeAction constructor.
     */
    public void testPasteFinalNodeAction() {
        test = new PasteFinalNodeAction(AccuracyTestHelper.createFinalNode(), activityGraph);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Paste Final Node", test
                .getPresentationName());
    }

    /**
     * Tests PasteFlowFinalNodeAction constructor.
     */
    public void testPasteFlowFinalNodeAction() {
        test = new PasteFlowFinalNodeAction(AccuracyTestHelper.createFlowFinalNode(), activityGraph);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Paste Flow Final Node", test
                .getPresentationName());
    }

    /**
     * Tests PasteForkNodeAction constructor.
     */
    public void testPasteForkNodeAction() {
        test = new PasteForkNodeAction(AccuracyTestHelper.createForkNode(), activityGraph);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Paste Fork Node", test
                .getPresentationName());
    }

    /**
     * Tests PasteInitialNodeAction constructor.
     */
    public void testPasteInitialNodeAction() {
        test = new PasteInitialNodeAction(AccuracyTestHelper.createInitialNode(), activityGraph);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Paste Initial Node", test
                .getPresentationName());
    }

    /**
     * Tests PasteJoinNodeAction constructor.
     */
    public void testPasteJoinNodeAction() {
        test = new PasteJoinNodeAction(AccuracyTestHelper.createJoinNode(), activityGraph);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Paste Join Node", test
                .getPresentationName());
    }

    /**
     * Tests PasteMergeNodeAction constructor.
     */
    public void testPasteMergeNodeAction() {
        test = new PasteMergeNodeAction(AccuracyTestHelper.createMergeNode(), activityGraph);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Paste Merge Node", test
                .getPresentationName());
    }

    /**
     * Tests PasteObjectFlowStateAction constructor.
     */
    public void testPasteObjectFlowStateAction() {
        test = new PasteObjectFlowStateAction(AccuracyTestHelper.createObjectFlowState(), activityGraph);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Paste Object Flow State", test
                .getPresentationName());
    }

    /**
     * Tests PasteSendSignalActionAction constructor.
     */
    public void testPasteSendSignalActionAction() {
        test = new PasteSendSignalActionAction(AccuracyTestHelper.createSendSignalAction(), activityGraph);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Paste Send Signal Action", test
                .getPresentationName());
    }
}
