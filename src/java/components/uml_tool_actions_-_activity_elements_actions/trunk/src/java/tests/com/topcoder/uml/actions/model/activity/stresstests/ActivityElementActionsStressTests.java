/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.stresstests;

import java.awt.datatransfer.Clipboard;
import java.io.File;

import com.topcoder.uml.actions.model.activity.ActivityDataFlavor;
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
import com.topcoder.uml.actions.model.activity.AddTransitionAction;
import com.topcoder.uml.actions.model.activity.CutAcceptEventActionAction;
import com.topcoder.uml.actions.model.activity.CutActionStateAction;
import com.topcoder.uml.actions.model.activity.CutDecisionNodeAction;
import com.topcoder.uml.actions.model.activity.CutFinalNodeAction;
import com.topcoder.uml.actions.model.activity.CutFlowFinalNodeAction;
import com.topcoder.uml.actions.model.activity.CutForkNodeAction;
import com.topcoder.uml.actions.model.activity.CutInitialNodeAction;
import com.topcoder.uml.actions.model.activity.CutJoinNodeAction;
import com.topcoder.uml.actions.model.activity.CutMergeNodeAction;
import com.topcoder.uml.actions.model.activity.CutObjectFlowStateAction;
import com.topcoder.uml.actions.model.activity.CutSendSignalActionAction;
import com.topcoder.uml.actions.model.activity.CutTransitionAction;
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
import com.topcoder.uml.actions.model.activity.PasteTransitionAction;
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
import com.topcoder.uml.actions.model.activity.RemoveTransitionAction;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.FinalStateImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The stress test of activity element actions component.
 * </P>
 *
 * @author victorsam
 * @version 1.0
 */
public class ActivityElementActionsStressTests extends TestCase {

    /**
     * This constant represents the current time used for testing.
     */
    private static long current = -1;

    /**
     * This constant represents the test count used for testing.
     */
    private static final int NUMBER = 10000;

    /**
     * The Pseudostate instance is used for testing.
     */
    private Pseudostate initialNode;

    /**
     * The ObjectFlowState instance is used for testing.
     */
    private ObjectFlowState objectFlowState;

    /**
     * The ActionState instance is used for testing.
     */
    private ActionState actionState;

    /**
     * The SimpleState instance is used for testing.
     */
    private SimpleState sendSignalActionNode;

    /**
     * The SimpleState instance is used for testing.
     */
    private SimpleState acceptEventActionNode;

    /**
     * The Pseudostate instance is used for testing.
     */
    private Pseudostate forkNode;

    /**
     * The Pseudostate instance is used for testing.
     */
    private Pseudostate joinNode;

    /**
     * The Pseudostate instance is used for testing.
     */
    private Pseudostate decisionNode;

    /**
     * The Pseudostate instance is used for testing.
     */
    private Pseudostate mergeNode;

    /**
     * The FinalState instance is used for testing.
     */
    private FinalState flowFinalNode;

    /**
     * The FinalState instance is used for testing.
     */
    private FinalState finalNode;

    /**
     * The Transition instance is used for testing.
     */
    private Transition transition;

    /**
     * The Clipboard instance is used for testing.
     */
    private Clipboard clipboard;

    /**
     * The ActivityGraph instance is used for testing.
     */
    private ActivityGraph activityGraph;

    /**
     * The UMLModelManager instance is used for testing.
     */
    private UMLModelManager manager;

    /**
     * The CompositeState instance is used for testing.
     */
    private CompositeState compositeState;

    /**
     * The StateMachine instance is used for testing.
     */
    private StateMachine stateMachine;

    /**
     * Tears down test environment.
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        loadXMLFile("com.topcoder.util.log", "test_files/stresstests/Logging.xml");
        loadXMLFile(ProjectConfigurationManager.class.getName(), "test_files/stresstests/configuration.xml");
        loadXMLFile(ProjectConfigurationManager.class.getName() + ".objectfactory",
            "test_files/stresstests/objectfactory.xml");

        compositeState = new CompositeStateImpl();

        initialNode = new PseudostateImpl();
        initialNode.setKind(PseudostateKind.INITIAL);
        initialNode.setContainer(compositeState);

        objectFlowState = new ObjectFlowStateImpl();
        objectFlowState.setContainer(compositeState);

        actionState = new ActionStateImpl();
        actionState.setContainer(compositeState);

        sendSignalActionNode = new SimpleStateImpl();
        sendSignalActionNode.setContainer(compositeState);
        sendSignalActionNode.addTaggedValue(createTaggedValue("SendSignalAction", "True"));

        acceptEventActionNode = new SimpleStateImpl();
        acceptEventActionNode.setContainer(compositeState);
        acceptEventActionNode.addTaggedValue(createTaggedValue("AcceptEventAction", "True"));

        forkNode = new PseudostateImpl();
        forkNode.setContainer(compositeState);
        forkNode.setKind(PseudostateKind.FORK);

        joinNode = new PseudostateImpl();
        joinNode.setContainer(compositeState);
        joinNode.setKind(PseudostateKind.JOIN);

        decisionNode = new PseudostateImpl();
        decisionNode.setContainer(compositeState);
        decisionNode.setKind(PseudostateKind.CHOICE);

        mergeNode = new PseudostateImpl();
        mergeNode.setContainer(compositeState);
        mergeNode.setKind(PseudostateKind.JUNCTION);

        flowFinalNode = new FinalStateImpl();
        flowFinalNode.setContainer(compositeState);
        flowFinalNode.addTaggedValue(createTaggedValue("FinalNodeType", "FlowFinalNode"));

        finalNode = new FinalStateImpl();
        finalNode.setContainer(compositeState);

        transition = new TransitionImpl();
        stateMachine = new StateMachineImpl();
        transition.setStateMachine(stateMachine);

        clipboard = new Clipboard("Test");

        activityGraph = new ActivityGraphImpl();
        activityGraph.setTop(compositeState);

        manager = new UMLModelManager();
        ProjectConfigurationManager configManager = new ProjectConfigurationManager(manager);
        manager.setProjectConfigurationManager(configManager);
        manager.setProjectLanguage("Java");
    }

    /**
     * Tears down test environment.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        initialNode = null;

        clearConfigFile(ProjectConfigurationManager.class.getName() + ".objectfactory");
        clearConfigFile(ProjectConfigurationManager.class.getName());
        clearConfigFile("com.topcoder.util.log");
    }

    /**
     * Return all tests.
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ActivityElementActionsStressTests.class);
    }

    /**
     * Test of Method of AddInitialNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddInitialNodeAction() throws ActionExecutionException {
        // add initialNode
        AddInitialNodeAction action = new AddInitialNodeAction(initialNode, activityGraph, manager);
        start();

        action.execute();
        assertTrue("Failed to add sub vertex.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(initialNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(initialNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(initialNode));
        }

        printResult("AddInitialNodeAction");
    }

    /**
     * Test of Method of AddObjectFlowStateAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddObjectFlowStateAction() throws ActionExecutionException {
        // add objectFlowState
        AddObjectFlowStateAction action = new AddObjectFlowStateAction(objectFlowState, activityGraph, manager);
        start();

        action.execute();
        assertTrue("Failed to add sub vertex.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(objectFlowState));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(objectFlowState));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(objectFlowState));
        }

        printResult("AddObjectFlowStateAction");
    }

    /**
     * Test of Method of AddActionStateAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddActionStateAction() throws ActionExecutionException {
        // add actionState
        AddActionStateAction action = new AddActionStateAction(actionState, activityGraph, manager);
        start();

        action.execute();
        assertTrue("Failed to add sub vertex.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(actionState));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(actionState));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(actionState));
        }

        printResult("AddActionStateAction");
    }

    /**
     * Test of Method of AddSendSignalActionAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddSendSignalActionAction() throws ActionExecutionException {
        // add sendSignalActionNode
        AddSendSignalActionAction action = new AddSendSignalActionAction(sendSignalActionNode, activityGraph, manager);
        start();

        action.execute();
        assertTrue("Failed to add sub vertex.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(sendSignalActionNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(sendSignalActionNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(sendSignalActionNode));
        }

        printResult("AddSendSignalActionAction");
    }

    /**
     * Test of Method of AddAcceptEventActionAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddAcceptEventActionAction() throws ActionExecutionException {
        // add acceptEventActionNode
        AddAcceptEventActionAction action = new AddAcceptEventActionAction(acceptEventActionNode, activityGraph,
            manager);
        start();

        action.execute();
        assertTrue("Failed to add sub vertex.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(acceptEventActionNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(acceptEventActionNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(acceptEventActionNode));
        }

        printResult("AddAcceptEventActionAction");
    }

    /**
     * Test of Method of AddForkNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddForkNodeAction() throws ActionExecutionException {
        // add forkNode
        AddForkNodeAction action = new AddForkNodeAction(forkNode, activityGraph, manager);
        start();

        action.execute();
        assertTrue("Failed to add sub vertex.", ((CompositeState) activityGraph.getTop()).containsSubVertex(forkNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(forkNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(forkNode));
        }

        printResult("AddForkNodeAction");
    }

    /**
     * Test of Method of AddJoinNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddJoinNodeAction() throws ActionExecutionException {
        // add joinNode
        AddJoinNodeAction action = new AddJoinNodeAction(joinNode, activityGraph, manager);
        start();

        action.execute();
        assertTrue("Failed to add sub vertex.", ((CompositeState) activityGraph.getTop()).containsSubVertex(joinNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(joinNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(joinNode));
        }

        printResult("AddJoinNodeAction");
    }

    /**
     * Test of Method of AddDecisionNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddDecisionNodeAction() throws ActionExecutionException {
        // add decisionNode
        AddDecisionNodeAction action = new AddDecisionNodeAction(decisionNode, activityGraph, manager);
        start();

        action.execute();
        assertTrue("Failed to add sub vertex.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(decisionNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(decisionNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(decisionNode));
        }

        printResult("AddDecisionNodeAction");
    }

    /**
     * Test of Method of AddMergeNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddMergeNodeAction() throws ActionExecutionException {
        // add mergeNode
        AddMergeNodeAction action = new AddMergeNodeAction(mergeNode, activityGraph, manager);
        start();

        action.execute();
        assertTrue("Failed to add sub vertex.", ((CompositeState) activityGraph.getTop()).containsSubVertex(mergeNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(mergeNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(mergeNode));
        }

        printResult("AddMergeNodeAction");
    }

    /**
     * Test of Method of AddFlowFinalNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddFlowFinalNodeAction() throws ActionExecutionException {
        // add flowFinalNode
        AddFlowFinalNodeAction action = new AddFlowFinalNodeAction(flowFinalNode, activityGraph, manager);
        start();

        action.execute();
        assertTrue("Failed to add sub vertex.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(flowFinalNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(flowFinalNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(flowFinalNode));
        }

        printResult("AddFlowFinalNodeAction");
    }

    /**
     * Test of Method of AddFinalNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddFinalNodeAction() throws ActionExecutionException {
        // add finalNode
        AddFinalNodeAction action = new AddFinalNodeAction(finalNode, activityGraph, manager);
        start();

        action.execute();
        assertTrue("Failed to add sub vertex.", ((CompositeState) activityGraph.getTop()).containsSubVertex(finalNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(finalNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(finalNode));
        }

        printResult("AddFinalNodeAction");
    }

    /**
     * Test of Method of AddTransitionAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddTransitionAction() throws ActionExecutionException {
        // add transition
        AddTransitionAction action = new AddTransitionAction(transition, activityGraph, manager);
        start();

        action.execute();
        assertTrue("Failed to add the transition.", activityGraph.containsTransition(transition));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.", activityGraph.containsTransition(transition));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.", activityGraph.containsTransition(transition));
        }

        printResult("AddTransitionAction");
    }

    /**
     * Test of Method of RemoveInitialNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testRemoveInitialNodeAction() throws ActionExecutionException {
        // remove initialNode
        RemoveInitialNodeAction action = new RemoveInitialNodeAction(initialNode);
        start();

        action.execute();
        assertFalse("Failed to remove sub vertex.", compositeState.containsSubVertex(initialNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(initialNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(initialNode));
        }

        printResult("RemoveInitialNodeAction");
    }

    /**
     * Test of Method of RemoveObjectFlowStateAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testRemoveObjectFlowStateAction() throws ActionExecutionException {
        // remove objectFlowState
        RemoveObjectFlowStateAction action = new RemoveObjectFlowStateAction(objectFlowState);
        start();

        action.execute();
        assertFalse("Failed to remove sub vertex.", compositeState.containsSubVertex(objectFlowState));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(objectFlowState));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(objectFlowState));
        }

        printResult("RemoveObjectFlowStateAction");
    }

    /**
     * Test of Method of RemoveActionStateAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testRemoveActionStateAction() throws ActionExecutionException {
        // remove actionState
        RemoveActionStateAction action = new RemoveActionStateAction(actionState);
        start();

        action.execute();
        assertFalse("Failed to remove sub vertex.", compositeState.containsSubVertex(actionState));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(actionState));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(actionState));
        }

        printResult("RemoveActionStateAction");
    }

    /**
     * Test of Method of RemoveSendSignalActionAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testRemoveSendSignalActionAction() throws ActionExecutionException {
        // remove sendSignalActionNode
        RemoveSendSignalActionAction action = new RemoveSendSignalActionAction(sendSignalActionNode);
        start();

        action.execute();
        assertFalse("Failed to remove sub vertex.", compositeState.containsSubVertex(sendSignalActionNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(sendSignalActionNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(sendSignalActionNode));
        }

        printResult("RemoveSendSignalActionAction");
    }

    /**
     * Test of Method of RemoveAcceptEventActionAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testRemoveAcceptEventActionAction() throws ActionExecutionException {
        // remove acceptEventActionNode
        RemoveAcceptEventActionAction action = new RemoveAcceptEventActionAction(acceptEventActionNode);
        start();

        action.execute();
        assertFalse("Failed to remove sub vertex.", compositeState.containsSubVertex(acceptEventActionNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(acceptEventActionNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(acceptEventActionNode));
        }

        printResult("RemoveAcceptEventActionAction");
    }

    /**
     * Test of Method of RemoveForkNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testRemoveForkNodeAction() throws ActionExecutionException {
        // remove forkNode
        RemoveForkNodeAction action = new RemoveForkNodeAction(forkNode);
        start();

        action.execute();
        assertFalse("Failed to remove sub vertex.", compositeState.containsSubVertex(forkNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(forkNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(forkNode));
        }

        printResult("RemoveForkNodeAction");
    }

    /**
     * Test of Method of RemoveJoinNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testRemoveJoinNodeAction() throws ActionExecutionException {
        // remove joinNode
        RemoveJoinNodeAction action = new RemoveJoinNodeAction(joinNode);
        start();

        action.execute();
        assertFalse("Failed to remove sub vertex.", compositeState.containsSubVertex(joinNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(joinNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(joinNode));
        }

        printResult("RemoveJoinNodeAction");
    }

    /**
     * Test of Method of RemoveDecisionNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testRemoveDecisionNodeAction() throws ActionExecutionException {
        // remove decisionNode
        RemoveDecisionNodeAction action = new RemoveDecisionNodeAction(decisionNode);
        start();

        action.execute();
        assertFalse("Failed to remove sub vertex.", compositeState.containsSubVertex(decisionNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(decisionNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(decisionNode));
        }

        printResult("RemoveDecisionNodeAction");
    }

    /**
     * Test of Method of RemoveMergeNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testRemoveMergeNodeAction() throws ActionExecutionException {
        // remove mergeNode
        RemoveMergeNodeAction action = new RemoveMergeNodeAction(mergeNode);
        start();

        action.execute();
        assertFalse("Failed to remove sub vertex.", compositeState.containsSubVertex(mergeNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(mergeNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(mergeNode));
        }

        printResult("RemoveMergeNodeAction");
    }

    /**
     * Test of Method of RemoveFlowFinalNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testRemoveFlowFinalNodeAction() throws ActionExecutionException {
        // remove flowFinalNode
        RemoveFlowFinalNodeAction action = new RemoveFlowFinalNodeAction(flowFinalNode);
        start();

        action.execute();
        assertFalse("Failed to remove sub vertex.", compositeState.containsSubVertex(flowFinalNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(flowFinalNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(flowFinalNode));
        }

        printResult("RemoveFlowFinalNodeAction");
    }

    /**
     * Test of Method of RemoveFinalNodeAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testRemoveFinalNodeAction() throws ActionExecutionException {
        // remove finalNode
        RemoveFinalNodeAction action = new RemoveFinalNodeAction(finalNode);
        start();

        action.execute();
        assertFalse("Failed to remove sub vertex.", compositeState.containsSubVertex(finalNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(finalNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(finalNode));
        }

        printResult("RemoveFinalNodeAction");
    }

    /**
     * Test of Method of RemoveTransitionAction.
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testRemoveTransitionAction() throws ActionExecutionException {
        // remove transition
        RemoveTransitionAction action = new RemoveTransitionAction(transition);
        start();

        action.execute();
        assertFalse("Failed to remove the transition.", stateMachine.containsTransition(transition));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", stateMachine.containsTransition(transition));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", stateMachine.containsTransition(transition));
        }

        printResult("RemoveTransitionAction");
    }

    /**
     * Test of Method of CutInitialNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testCutInitialNodeAction() throws Exception {
        // cut initialNode
        CutInitialNodeAction action = new CutInitialNodeAction(initialNode, clipboard);
        start();

        action.execute();
        Object content = clipboard.getData(ActivityDataFlavor.INITIAL_NODE);
        assertTrue("Expects the content is cloned", content != initialNode);
        assertFalse("Failed to cut the sub vertex to the clipboard.", compositeState.containsSubVertex(initialNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(initialNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(initialNode));
        }

        printResult("CutInitialNodeAction");
    }

    /**
     * Test of Method of CutObjectFlowStateAction.
     *
     * @throws Exception to JUnit.
     */
    public void testCutObjectFlowStateAction() throws Exception {
        // cut objectFlowState
        CutObjectFlowStateAction action = new CutObjectFlowStateAction(objectFlowState, clipboard);
        start();

        action.execute();
        Object content = clipboard.getData(ActivityDataFlavor.OBJECT_FLOW_STATE);
        assertTrue("Expects the content is cloned", content != objectFlowState);
        assertFalse("Failed to cut the sub vertex to the clipboard.",
            compositeState.containsSubVertex(objectFlowState));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(objectFlowState));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(objectFlowState));
        }

        printResult("CutObjectFlowStateAction");
    }

    /**
     * Test of Method of CutActionStateAction.
     *
     * @throws Exception to JUnit.
     */
    public void testCutActionStateAction() throws Exception {
        // cut actionState
        CutActionStateAction action = new CutActionStateAction(actionState, clipboard);
        start();

        action.execute();
        Object content = clipboard.getData(ActivityDataFlavor.ACTION_STATE);
        assertTrue("Expects the content is cloned", content != actionState);
        assertFalse("Failed to cut the sub vertex to the clipboard.", compositeState.containsSubVertex(actionState));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(actionState));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(actionState));
        }

        printResult("CutActionStateAction");
    }

    /**
     * Test of Method of CutSendSignalActionAction.
     *
     * @throws Exception to JUnit.
     */
    public void testCutSendSignalActionAction() throws Exception {
        // cut sendSignalActionNode
        CutSendSignalActionAction action = new CutSendSignalActionAction(sendSignalActionNode, clipboard);
        start();

        action.execute();
        Object content = clipboard.getData(ActivityDataFlavor.SEND_SIGNAL_ACTION);
        assertTrue("Expects the content is cloned", content != sendSignalActionNode);
        assertFalse("Failed to cut the sub vertex to the clipboard.",
            compositeState.containsSubVertex(sendSignalActionNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(sendSignalActionNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(sendSignalActionNode));
        }

        printResult("CutSendSignalActionAction");
    }

    /**
     * Test of Method of CutAcceptEventActionAction.
     *
     * @throws Exception to JUnit.
     */
    public void testCutAcceptEventActionAction() throws Exception {
        // cut acceptEventActionNode
        CutAcceptEventActionAction action = new CutAcceptEventActionAction(acceptEventActionNode, clipboard);
        start();

        action.execute();
        Object content = clipboard.getData(ActivityDataFlavor.ACCEPT_EVENT_ACTION);
        assertTrue("Expects the content is cloned", content != acceptEventActionNode);
        assertFalse("Failed to cut the sub vertex to the clipboard.",
            compositeState.containsSubVertex(acceptEventActionNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(acceptEventActionNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(acceptEventActionNode));
        }

        printResult("CutAcceptEventActionAction");
    }

    /**
     * Test of Method of CutForkNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testCutForkNodeAction() throws Exception {
        // cut forkNode
        CutForkNodeAction action = new CutForkNodeAction(forkNode, clipboard);
        start();

        action.execute();
        Object content = clipboard.getData(ActivityDataFlavor.FORK_NODE);
        assertTrue("Expects the content is cloned", content != forkNode);
        assertFalse("Failed to cut the sub vertex to the clipboard.", compositeState.containsSubVertex(forkNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(forkNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(forkNode));
        }

        printResult("CutForkNodeAction");
    }

    /**
     * Test of Method of CutJoinNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testCutJoinNodeAction() throws Exception {
        // cut joinNode
        CutJoinNodeAction action = new CutJoinNodeAction(joinNode, clipboard);
        start();

        action.execute();
        Object content = clipboard.getData(ActivityDataFlavor.JOIN_NODE);
        assertTrue("Expects the content is cloned", content != joinNode);
        assertFalse("Failed to cut the sub vertex to the clipboard.", compositeState.containsSubVertex(joinNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(joinNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(joinNode));
        }

        printResult("CutJoinNodeAction");
    }

    /**
     * Test of Method of CutDecisionNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testCutDecisionNodeAction() throws Exception {
        // cut decisionNode
        CutDecisionNodeAction action = new CutDecisionNodeAction(decisionNode, clipboard);
        start();

        action.execute();
        Object content = clipboard.getData(ActivityDataFlavor.DECISION_NODE);
        assertTrue("Expects the content is cloned", content != decisionNode);
        assertFalse("Failed to cut the sub vertex to the clipboard.", compositeState.containsSubVertex(decisionNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(decisionNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(decisionNode));
        }

        printResult("CutDecisionNodeAction");
    }

    /**
     * Test of Method of CutMergeNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testCutMergeNodeAction() throws Exception {
        // cut mergeNode
        CutMergeNodeAction action = new CutMergeNodeAction(mergeNode, clipboard);
        start();

        action.execute();
        Object content = clipboard.getData(ActivityDataFlavor.MERGE_NODE);
        assertTrue("Expects the content is cloned", content != mergeNode);
        assertFalse("Failed to cut the sub vertex to the clipboard.", compositeState.containsSubVertex(mergeNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(mergeNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(mergeNode));
        }

        printResult("CutMergeNodeAction");
    }

    /**
     * Test of Method of CutFlowFinalNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testCutFlowFinalNodeAction() throws Exception {
        // cut flowFinalNode
        CutFlowFinalNodeAction action = new CutFlowFinalNodeAction(flowFinalNode, clipboard);
        start();

        action.execute();
        Object content = clipboard.getData(ActivityDataFlavor.FLOW_FINAL_NODE);
        assertTrue("Expects the content is cloned", content != flowFinalNode);
        assertFalse("Failed to cut the sub vertex to the clipboard.", compositeState.containsSubVertex(flowFinalNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(flowFinalNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(flowFinalNode));
        }

        printResult("CutFlowFinalNodeAction");
    }

    /**
     * Test of Method of CutFinalNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testCutFinalNodeAction() throws Exception {
        // cut finalNode
        CutFinalNodeAction action = new CutFinalNodeAction(finalNode, clipboard);
        start();

        action.execute();
        Object content = clipboard.getData(ActivityDataFlavor.FINAL_NODE);
        assertTrue("Expects the content is cloned", content != finalNode);
        assertFalse("Failed to cut the sub vertex to the clipboard.", compositeState.containsSubVertex(finalNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", compositeState.containsSubVertex(finalNode));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", compositeState.containsSubVertex(finalNode));
        }

        printResult("CutFinalNodeAction");
    }

    /**
     * Test of Method of CutTransitionAction.
     *
     * @throws Exception to JUnit.
     */
    public void testCutTransitionAction() throws Exception {
        // cut transition
        CutTransitionAction action = new CutTransitionAction(transition, clipboard);
        start();

        action.execute();
        Object content = clipboard.getData(ActivityDataFlavor.TRANSITION);
        assertTrue("Expects the content is cloned", content != transition);
        assertFalse("Failed to cut the transition to the clipboard.", stateMachine.containsTransition(transition));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertTrue("Failed to execute undo() method.", stateMachine.containsTransition(transition));

            // redo the action
            action.redo();
            assertFalse("Failed to execute redo() method.", stateMachine.containsTransition(transition));
        }

        printResult("CutTransitionAction");
    }

    /**
     * Test of Method of PasteInitialNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testPasteInitialNodeAction() throws Exception {
        // paste initialNode
        PasteInitialNodeAction action = new PasteInitialNodeAction(initialNode, activityGraph);
        start();

        action.execute();
        assertTrue("Failed to paste the sub vertex to the activity graph.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(initialNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(initialNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(initialNode));
        }

        printResult("PasteInitialNodeAction");
    }

    /**
     * Test of Method of PasteObjectFlowStateAction.
     *
     * @throws Exception to JUnit.
     */
    public void testPasteObjectFlowStateAction() throws Exception {
        // paste objectFlowState
        PasteObjectFlowStateAction action = new PasteObjectFlowStateAction(objectFlowState, activityGraph);
        start();

        action.execute();
        assertTrue("Failed to paste the sub vertex to the activity graph.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(objectFlowState));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(objectFlowState));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(objectFlowState));
        }

        printResult("PasteObjectFlowStateAction");
    }

    /**
     * Test of Method of PasteActionStateAction.
     *
     * @throws Exception to JUnit.
     */
    public void testPasteActionStateAction() throws Exception {
        // paste actionState
        PasteActionStateAction action = new PasteActionStateAction(actionState, activityGraph);
        start();

        action.execute();
        assertTrue("Failed to paste the sub vertex to the activity graph.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(actionState));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(actionState));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(actionState));
        }

        printResult("PasteActionStateAction");
    }

    /**
     * Test of Method of PasteSendSignalActionAction.
     *
     * @throws Exception to JUnit.
     */
    public void testPasteSendSignalActionAction() throws Exception {
        // paste sendSignalActionNode
        PasteSendSignalActionAction action = new PasteSendSignalActionAction(sendSignalActionNode, activityGraph);
        start();

        action.execute();
        assertTrue("Failed to paste the sub vertex to the activity graph.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(sendSignalActionNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(sendSignalActionNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(sendSignalActionNode));
        }

        printResult("PasteSendSignalActionAction");
    }

    /**
     * Test of Method of PasteAcceptEventActionAction.
     *
     * @throws Exception to JUnit.
     */
    public void testPasteAcceptEventActionAction() throws Exception {
        // paste acceptEventActionNode
        PasteAcceptEventActionAction action = new PasteAcceptEventActionAction(acceptEventActionNode, activityGraph);
        start();

        action.execute();
        assertTrue("Failed to paste the sub vertex to the activity graph.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(acceptEventActionNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(acceptEventActionNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(acceptEventActionNode));
        }

        printResult("PasteAcceptEventActionAction");
    }

    /**
     * Test of Method of PasteForkNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testPasteForkNodeAction() throws Exception {
        // paste forkNode
        PasteForkNodeAction action = new PasteForkNodeAction(forkNode, activityGraph);
        start();

        action.execute();
        assertTrue("Failed to paste the sub vertex to the activity graph.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(forkNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(forkNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(forkNode));
        }

        printResult("PasteForkNodeAction");
    }

    /**
     * Test of Method of PasteJoinNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testPasteJoinNodeAction() throws Exception {
        // paste joinNode
        PasteJoinNodeAction action = new PasteJoinNodeAction(joinNode, activityGraph);
        start();

        action.execute();
        assertTrue("Failed to paste the sub vertex to the activity graph.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(joinNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(joinNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(joinNode));
        }

        printResult("PasteJoinNodeAction");
    }

    /**
     * Test of Method of PasteDecisionNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testPasteDecisionNodeAction() throws Exception {
        // paste decisionNode
        PasteDecisionNodeAction action = new PasteDecisionNodeAction(decisionNode, activityGraph);
        start();

        action.execute();
        assertTrue("Failed to paste the sub vertex to the activity graph.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(decisionNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(decisionNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(decisionNode));
        }

        printResult("PasteDecisionNodeAction");
    }

    /**
     * Test of Method of PasteMergeNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testPasteMergeNodeAction() throws Exception {
        // paste mergeNode
        PasteMergeNodeAction action = new PasteMergeNodeAction(mergeNode, activityGraph);
        start();

        action.execute();
        assertTrue("Failed to paste the sub vertex to the activity graph.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(mergeNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(mergeNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(mergeNode));
        }

        printResult("PasteMergeNodeAction");
    }

    /**
     * Test of Method of PasteFlowFinalNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testPasteFlowFinalNodeAction() throws Exception {
        // paste flowFinalNode
        PasteFlowFinalNodeAction action = new PasteFlowFinalNodeAction(flowFinalNode, activityGraph);
        start();

        action.execute();
        assertTrue("Failed to paste the sub vertex to the activity graph.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(flowFinalNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(flowFinalNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(flowFinalNode));
        }

        printResult("PasteFlowFinalNodeAction");
    }

    /**
     * Test of Method of PasteFinalNodeAction.
     *
     * @throws Exception to JUnit.
     */
    public void testPasteFinalNodeAction() throws Exception {
        // paste finalNode
        PasteFinalNodeAction action = new PasteFinalNodeAction(finalNode, activityGraph);
        start();

        action.execute();
        assertTrue("Failed to paste the sub vertex to the activity graph.",
            ((CompositeState) activityGraph.getTop()).containsSubVertex(finalNode));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(finalNode));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.",
                ((CompositeState) activityGraph.getTop()).containsSubVertex(finalNode));
        }

        printResult("PasteFinalNodeAction");
    }

    /**
     * Test of Method of PasteTransitionAction.
     *
     * @throws Exception to JUnit.
     */
    public void testPasteTransitionAction() throws Exception {
        // paste transition
        PasteTransitionAction action = new PasteTransitionAction(transition, activityGraph);
        start();

        action.execute();
        assertTrue("Failed to paste the transition to the activity graph.",
            activityGraph.containsTransition(transition));

        for (int i = 0; i < NUMBER; i++) {
            // undo the action
            action.undo();
            assertFalse("Failed to execute undo() method.", activityGraph.containsTransition(transition));

            // redo the action
            action.redo();
            assertTrue("Failed to execute redo() method.", activityGraph.containsTransition(transition));
        }

        printResult("PasteTransitionAction");
    }

    /**
     * Start to count time.
     */
    private static void start() {
        current = System.currentTimeMillis();
    }

    /**
     * Print test result.
     *
     * @param name the test name
     */
    private static void printResult(String name) {
        System.out.println("The test " + name + " running " + NUMBER + " times, took time: "
            + (System.currentTimeMillis() - current) + " ms");
    }

    /**
     * Use the given file to config the given namespace the format of the config file is
     * ConfigManager.CONFIG_XML_FORMAT.
     *
     * @param namespace use the namespace to load config information to ConfigManager
     * @param fileName config file to set up environment
     *
     * @throws Exception when any exception occurs
     */
    private static void loadXMLFile(String namespace, String fileName) throws Exception {
        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        //config namespace
        if (config.existsNamespace(namespace)) {
            config.removeNamespace(namespace);
        }

        config.add(namespace, file.getCanonicalPath(), ConfigManager.CONFIG_XML_FORMAT);
    }

    /**
     * Remove the given namespace in the ConfigManager.
     *
     * @param namespace namespace use to remove the config information in ConfigManager
     *
     * @throws Exception when any exception occurs
     */
    private static void clearConfigFile(String namespace) throws Exception {
        ConfigManager config = ConfigManager.getInstance();

        //clear the environment
        if (config.existsNamespace(namespace)) {
            config.removeNamespace(namespace);
        }
    }

    /**
     * Create a tag value with the given type and data value. It is used to
     * add a taggedValue to a state.
     *
     * @param type the tagDefinition type
     * @param dataValue the tag value
     * @return a taggedValue with the given type and value
     */
    private static TaggedValue createTaggedValue(String type, String dataValue) {
        TaggedValue taggedValue = new TaggedValueImpl();
        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType(type);
        taggedValue.setType(tagDefinition);
        taggedValue.setDataValue(dataValue);

        return taggedValue;
    }
}
