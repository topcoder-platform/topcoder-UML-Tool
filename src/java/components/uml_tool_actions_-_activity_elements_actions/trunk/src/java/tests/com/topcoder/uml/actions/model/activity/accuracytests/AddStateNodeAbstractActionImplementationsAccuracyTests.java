/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.AddAcceptEventActionAction;
import com.topcoder.uml.actions.model.activity.AddActionStateAction;
import com.topcoder.uml.actions.model.activity.AddDecisionNodeAction;
import com.topcoder.uml.actions.model.activity.AddFinalNodeAction;
import com.topcoder.uml.actions.model.activity.AddFlowFinalNodeAction;
import com.topcoder.uml.actions.model.activity.AddForkNodeAction;
import com.topcoder.uml.actions.model.activity.AddInitialNodeAction;
import com.topcoder.uml.actions.model.activity.AddJoinNodeAction;
import com.topcoder.uml.actions.model.activity.AddMergeNodeAction;
import com.topcoder.uml.actions.model.activity.AddObjectFlowStateAction;
import com.topcoder.uml.actions.model.activity.AddSendSignalActionAction;
import com.topcoder.uml.actions.model.activity.AddStateNodeAbstractAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * This class aggregates accuracy tests for concrete implementations of AddStateNodeAbstractAction abstract class.
 *
 * @author ch_music
 * @version 1.0
 */
public class AddStateNodeAbstractActionImplementationsAccuracyTests extends TestCase {

    /**
     * A AddStateNodeAbstractAction instance used for testing.
     */
    private AddStateNodeAbstractAction test;

    /**
     * An ActivityGraph instance used for testing.
     */
    private ActivityGraph activityGraph;

    /**
     * The UMLModelManager instance used for testing purposes.
     */
    private UMLModelManager modelManager;

    /**
     * Sets up the environment for testing.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.LOG_NAMESPACE, AccuracyTestHelper.LOG_CONFIGPATH);

        activityGraph = new ActivityGraphImpl();
        activityGraph.setTop(new CompositeStateImpl());
        modelManager = AccuracyTestHelper.createModelManager();
    }

    /**
     * Tears down the environment.
     */
    protected void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests AddAcceptEventActionAction constructor.
     */
    public void testAddAcceptEventActionAction() {
        test = new AddAcceptEventActionAction(AccuracyTestHelper.createAcceptEventAction(), activityGraph,
                modelManager);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Add Accept Event Action", test
                .getPresentationName());
    }

    /**
     * Tests AddActionStateAction constructor.
     */
    public void testAddActionStateAction() {
        test = new AddActionStateAction(AccuracyTestHelper.createActionState(), activityGraph, modelManager);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Add Action State", test
                .getPresentationName());
    }

    /**
     * Tests AddDecisionNodeAction constructor.
     */
    public void testAddDecisionNodeAction() {
        test = new AddDecisionNodeAction(AccuracyTestHelper.createDecisionNode(), activityGraph, modelManager);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Add Decision Node", test
                .getPresentationName());
    }

    /**
     * Tests AddFinalNodeAction constructor.
     */
    public void testAddFinalNodeAction() {
        test = new AddFinalNodeAction(AccuracyTestHelper.createFinalNode(), activityGraph, modelManager);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Add Final Node", test
                .getPresentationName());
    }

    /**
     * Tests AddFlowFinalNodeAction constructor.
     */
    public void testAddFlowFinalNodeAction() {
        test = new AddFlowFinalNodeAction(AccuracyTestHelper.createFlowFinalNode(), activityGraph, modelManager);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Add Flow Final Node", test
                .getPresentationName());
    }

    /**
     * Tests AddForkNodeAction constructor.
     */
    public void testAddForkNodeAction() {
        test = new AddForkNodeAction(AccuracyTestHelper.createForkNode(), activityGraph, modelManager);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Add Fork Node", test
                .getPresentationName());
    }

    /**
     * Tests AddInitialNodeAction constructor.
     */
    public void testAddInitialNodeAction() {
        test = new AddInitialNodeAction(AccuracyTestHelper.createInitialNode(), activityGraph, modelManager);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Add Initial Node", test
                .getPresentationName());
    }

    /**
     * Tests AddJoinNodeAction constructor.
     */
    public void testAddJoinNodeAction() {
        test = new AddJoinNodeAction(AccuracyTestHelper.createJoinNode(), activityGraph, modelManager);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Add Join Node", test
                .getPresentationName());
    }

    /**
     * Tests AddMergeNodeAction constructor.
     */
    public void testAddMergeNodeAction() {
        test = new AddMergeNodeAction(AccuracyTestHelper.createMergeNode(), activityGraph, modelManager);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Add Merge Node", test
                .getPresentationName());
    }

    /**
     * Tests AddObjectFlowStateAction constructor.
     */
    public void testAddObjectFlowStateAction() {
        test = new AddObjectFlowStateAction(AccuracyTestHelper.createObjectFlowState(), activityGraph,
                modelManager);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Add Object Flow State", test
                .getPresentationName());
    }

    /**
     * Tests AddSendSignalActionAction constructor.
     */
    public void testAddSendSignalActionAction() {
        test = new AddSendSignalActionAction(AccuracyTestHelper.createSendSignalAction(), activityGraph,
                modelManager);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Add Send Signal Action", test
                .getPresentationName());
    }

}
