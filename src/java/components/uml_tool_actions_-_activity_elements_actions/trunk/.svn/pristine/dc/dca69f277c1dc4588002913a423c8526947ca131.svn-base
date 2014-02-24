/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
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
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {

    /**
     * <p>
     * The Pseudostate instance for testing.
     * </p>
     */
    private Pseudostate initialNode;

    /**
     * <p>
     * The ObjectFlowState instance for testing.
     * </p>
     */
    private ObjectFlowState objectFlowState;

    /**
     * <p>
     * The ActionState instance for testing.
     * </p>
     */
    private ActionState actionState;

    /**
     * <p>
     * The SimpleState instance for testing.
     * </p>
     */
    private SimpleState sendSignalActionNode;

    /**
     * <p>
     * The SimpleState instance for testing.
     * </p>
     */
    private SimpleState acceptEventActionNode;

    /**
     * <p>
     * The Pseudostate instance for testing.
     * </p>
     */
    private Pseudostate forkNode;

    /**
     * <p>
     * The Pseudostate instance for testing.
     * </p>
     */
    private Pseudostate joinNode;

    /**
     * <p>
     * The Pseudostate instance for testing.
     * </p>
     */
    private Pseudostate decisionNode;

    /**
     * <p>
     * The Pseudostate instance for testing.
     * </p>
     */
    private Pseudostate mergeNode;

    /**
     * <p>
     * The FinalState instance for testing.
     * </p>
     */
    private FinalState flowFinalNode;

    /**
     * <p>
     * The FinalState instance for testing.
     * </p>
     */
    private FinalState finalNode;

    /**
     * <p>
     * The Transition instance for testing.
     * </p>
     */
    private Transition transition;

    /**
     * <p>
     * The Clipboard instance for testing.
     * </p>
     */
    private Clipboard clipboard;

    /**
     * <p>
     * The ActivityGraph instance for testing.
     * </p>
     */
    private ActivityGraph activityGraph;

    /**
     * <p>
     * The UMLModelManager instance for testing.
     * </p>
     */
    private UMLModelManager manager;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.configProjectConfiguration();

        CompositeState compositeState = new CompositeStateImpl();

        initialNode = new PseudostateImpl();
        initialNode.setKind(PseudostateKind.INITIAL);
        initialNode.setContainer(compositeState);

        objectFlowState = new ObjectFlowStateImpl();
        objectFlowState.setContainer(compositeState);

        actionState = new ActionStateImpl();
        actionState.setContainer(compositeState);

        sendSignalActionNode = new SimpleStateImpl();
        sendSignalActionNode.setContainer(compositeState);
        sendSignalActionNode.addTaggedValue(TestHelper.createTaggedValue("SendSignalAction", "True"));

        acceptEventActionNode = new SimpleStateImpl();
        acceptEventActionNode.setContainer(compositeState);
        acceptEventActionNode.addTaggedValue(TestHelper.createTaggedValue("AcceptEventAction", "True"));

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
        flowFinalNode.addTaggedValue(TestHelper.createTaggedValue("FinalNodeType", "FlowFinalNode"));

        finalNode = new FinalStateImpl();
        finalNode.setContainer(compositeState);

        transition = new TransitionImpl();
        StateMachine stateMachine = new StateMachineImpl();
        transition.setStateMachine(stateMachine);

        clipboard = new Clipboard("Test");

        activityGraph = new ActivityGraphImpl();
        activityGraph.setTop(compositeState);

        manager = TestHelper.setUpModelManager();

    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        manager = null;
        activityGraph = null;
        clipboard = null;
        transition = null;
        finalNode = null;
        flowFinalNode = null;
        mergeNode = null;
        decisionNode = null;
        joinNode = null;
        forkNode = null;
        acceptEventActionNode = null;
        sendSignalActionNode = null;
        actionState = null;
        objectFlowState = null;
        initialNode = null;

        TestHelper.clearProjectConfiguration();
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DemoTests.class);
    }

    /**
     * <p>
     * Execute actions to add specific nodes.
     * </P>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testAddActions() throws ActionExecutionException {

        // add initialNode
        AddInitialNodeAction action1 = new AddInitialNodeAction(initialNode, activityGraph, manager);
        action1.execute();

        // undo the action
        action1.undo();

        // redo the action
        action1.redo();

        // add objectFlowState
        AddObjectFlowStateAction action2 = new AddObjectFlowStateAction(objectFlowState, activityGraph, manager);
        action2.execute();

        // undo the action
        action2.undo();

        // redo the action
        action2.redo();

        // add actionState
        AddActionStateAction action3 = new AddActionStateAction(actionState, activityGraph, manager);
        action3.execute();

        // undo the action
        action3.undo();

        // redo the action
        action3.redo();

        // add sendSignalActionNode
        AddSendSignalActionAction action4 = new AddSendSignalActionAction(sendSignalActionNode, activityGraph, manager);
        action4.execute();

        // undo the action
        action4.undo();

        // redo the action
        action4.redo();

        // add acceptEventActionNode
        AddAcceptEventActionAction action5 = new AddAcceptEventActionAction(acceptEventActionNode, activityGraph,
            manager);
        action5.execute();

        // undo the action
        action5.undo();

        // redo the action
        action5.redo();

        // add forkNode
        AddForkNodeAction action6 = new AddForkNodeAction(forkNode, activityGraph, manager);
        action6.execute();

        // undo the action
        action6.undo();

        // redo the action
        action6.redo();

        // add joinNode
        AddJoinNodeAction action7 = new AddJoinNodeAction(joinNode, activityGraph, manager);
        action7.execute();

        // undo the action
        action7.undo();

        // redo the action
        action7.redo();

        // add decisionNode
        AddDecisionNodeAction action8 = new AddDecisionNodeAction(decisionNode, activityGraph, manager);
        action8.execute();

        // undo the action
        action8.undo();

        // redo the action
        action8.redo();

        // add mergeNode
        AddMergeNodeAction action9 = new AddMergeNodeAction(mergeNode, activityGraph, manager);
        action9.execute();

        // undo the action
        action9.undo();

        // redo the action
        action9.redo();

        // add flowFinalNode
        AddFlowFinalNodeAction action10 = new AddFlowFinalNodeAction(flowFinalNode, activityGraph, manager);
        action10.execute();

        // undo the action
        action10.undo();

        // redo the action
        action10.redo();

        // add finalNode
        AddFinalNodeAction action11 = new AddFinalNodeAction(finalNode, activityGraph, manager);
        action11.execute();

        // undo the action
        action11.undo();

        // redo the action
        action11.redo();

        // add transition
        AddTransitionAction action12 = new AddTransitionAction(transition, activityGraph, manager);
        action12.execute();

        // undo the action
        action12.undo();

        // redo the action
        action12.redo();
    }

    /**
     * <p>
     * Execute actions to remove specific nodes.
     * </P>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testRemoveActions() throws ActionExecutionException {
        // remove initialNode
        RemoveInitialNodeAction action1 = new RemoveInitialNodeAction(initialNode);
        action1.execute();

        // undo the action
        action1.undo();

        // redo the action
        action1.redo();

        // remove objectFlowState
        RemoveObjectFlowStateAction action2 = new RemoveObjectFlowStateAction(objectFlowState);
        action2.execute();

        // undo the action
        action2.undo();

        // redo the action
        action2.redo();

        // remove actionState
        RemoveActionStateAction action3 = new RemoveActionStateAction(actionState);
        action3.execute();

        // undo the action
        action3.undo();

        // redo the action
        action3.redo();

        // remove sendSignalActionNode
        RemoveSendSignalActionAction action4 = new RemoveSendSignalActionAction(sendSignalActionNode);
        action4.execute();

        // undo the action
        action4.undo();

        // redo the action
        action4.redo();

        // remove acceptEventActionNode
        RemoveAcceptEventActionAction action5 = new RemoveAcceptEventActionAction(acceptEventActionNode);
        action5.execute();

        // undo the action
        action5.undo();

        // redo the action
        action5.redo();

        // remove forkNode
        RemoveForkNodeAction action6 = new RemoveForkNodeAction(forkNode);
        action6.execute();

        // undo the action
        action6.undo();

        // redo the action
        action6.redo();

        // remove joinNode
        RemoveJoinNodeAction action7 = new RemoveJoinNodeAction(joinNode);
        action7.execute();

        // undo the action
        action7.undo();

        // redo the action
        action7.redo();

        // remove decisionNode
        RemoveDecisionNodeAction action8 = new RemoveDecisionNodeAction(decisionNode);
        action8.execute();

        // undo the action
        action8.undo();

        // redo the action
        action8.redo();

        // remove mergeNode
        RemoveMergeNodeAction action9 = new RemoveMergeNodeAction(mergeNode);
        action9.execute();

        // undo the action
        action9.undo();

        // redo the action
        action9.redo();

        // remove flowFinalNode
        RemoveFlowFinalNodeAction action10 = new RemoveFlowFinalNodeAction(flowFinalNode);
        action10.execute();

        // undo the action
        action10.undo();

        // redo the action
        action10.redo();

        // remove finalNode
        RemoveFinalNodeAction action11 = new RemoveFinalNodeAction(finalNode);
        action11.execute();

        // undo the action
        action11.undo();

        // redo the action
        action11.redo();

        // remove transition
        RemoveTransitionAction action12 = new RemoveTransitionAction(transition);
        action12.execute();

        // undo the action
        action12.undo();

        // redo the action
        action12.redo();
    }

    /**
     * <p>
     * Execute actions to cut specific nodes.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCutActions() throws Exception {

        // cut initialNode
        CutInitialNodeAction action1 = new CutInitialNodeAction(initialNode, clipboard);
        action1.execute();

        // undo the action
        action1.undo();

        // redo the action
        action1.redo();

        // cut objectFlowState
        CutObjectFlowStateAction action2 = new CutObjectFlowStateAction(objectFlowState, clipboard);
        action2.execute();

        // undo the action
        action2.undo();

        // redo the action
        action2.redo();

        // cut actionState
        CutActionStateAction action3 = new CutActionStateAction(actionState, clipboard);
        action3.execute();

        // undo the action
        action3.undo();

        // redo the action
        action3.redo();

        // cut sendSignalActionNode
        CutSendSignalActionAction action4 = new CutSendSignalActionAction(sendSignalActionNode, clipboard);
        action4.execute();

        // undo the action
        action4.undo();

        // redo the action
        action4.redo();

        // cut acceptEventActionNode
        CutAcceptEventActionAction action5 = new CutAcceptEventActionAction(acceptEventActionNode, clipboard);
        action5.execute();

        // undo the action
        action5.undo();

        // redo the action
        action5.redo();

        // cut forkNode
        CutForkNodeAction action6 = new CutForkNodeAction(forkNode, clipboard);
        action6.execute();

        // undo the action
        action6.undo();

        // redo the action
        action6.redo();

        // cut joinNode
        CutJoinNodeAction action7 = new CutJoinNodeAction(joinNode, clipboard);
        action7.execute();

        // undo the action
        action7.undo();

        // redo the action
        action7.redo();

        // cut decisionNode
        CutDecisionNodeAction action8 = new CutDecisionNodeAction(decisionNode, clipboard);
        action8.execute();

        // undo the action
        action8.undo();

        // redo the action
        action8.redo();

        // cut mergeNode
        CutMergeNodeAction action9 = new CutMergeNodeAction(mergeNode, clipboard);
        action9.execute();

        // undo the action
        action9.undo();

        // redo the action
        action9.redo();

        // cut flowFinalNode
        CutFlowFinalNodeAction action10 = new CutFlowFinalNodeAction(flowFinalNode, clipboard);
        action10.execute();

        // undo the action
        action10.undo();

        // redo the action
        action10.redo();

        // cut finalNode
        CutFinalNodeAction action11 = new CutFinalNodeAction(finalNode, clipboard);
        action11.execute();

        // undo the action
        action11.undo();

        // redo the action
        action11.redo();

        // cut transition
        CutTransitionAction action12 = new CutTransitionAction(transition, clipboard);
        action12.execute();

        // undo the action
        action12.undo();

        // redo the action
        action12.redo();

        // if we want to use system clipboard, just pass in null clipboard
        action12 = new CutTransitionAction(transition, null);
        action12.execute();
    }

    /**
     * <p>
     * Execute actions to copy specific nodes.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCopyActions() throws Exception {

        // copy initialNode
        CopyInitialNodeAction action1 = new CopyInitialNodeAction(initialNode, clipboard);
        action1.execute();

        // copy objectFlowState
        CopyObjectFlowStateAction action2 = new CopyObjectFlowStateAction(objectFlowState, clipboard);
        action2.execute();

        // copy actionState
        CopyActionStateAction action3 = new CopyActionStateAction(actionState, clipboard);
        action3.execute();

        // copy sendSignalActionNode
        CopySendSignalActionAction action4 = new CopySendSignalActionAction(sendSignalActionNode, clipboard);
        action4.execute();

        // copy acceptEventActionNode
        CopyAcceptEventActionAction action5 = new CopyAcceptEventActionAction(acceptEventActionNode, clipboard);
        action5.execute();

        // copy forkNode
        CopyForkNodeAction action6 = new CopyForkNodeAction(forkNode, clipboard);
        action6.execute();

        // copy joinNode
        CopyJoinNodeAction action7 = new CopyJoinNodeAction(joinNode, clipboard);
        action7.execute();

        // copy decisionNode
        CopyDecisionNodeAction action8 = new CopyDecisionNodeAction(decisionNode, clipboard);
        action8.execute();

        // copy mergeNode
        CopyMergeNodeAction action9 = new CopyMergeNodeAction(mergeNode, clipboard);
        action9.execute();

        // copy flowFinalNode
        CopyFlowFinalNodeAction action10 = new CopyFlowFinalNodeAction(flowFinalNode, clipboard);
        action10.execute();

        // copy finalNode
        CopyFinalNodeAction action11 = new CopyFinalNodeAction(finalNode, clipboard);
        action11.execute();

        // copy transition
        CopyTransitionAction action12 = new CopyTransitionAction(transition, clipboard);
        action12.execute();

        // if we want to use system clipboard, just pass in null clipboard
        action12 = new CopyTransitionAction(transition, null);
        action12.execute();
    }

    /**
     * <p>
     * Execute actions to paste specific nodes.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testPasteActions() throws ActionExecutionException {

        // paste initialNode
        PasteInitialNodeAction action1 = new PasteInitialNodeAction(initialNode, activityGraph);
        action1.execute();

        // undo the action
        action1.undo();

        // redo the action
        action1.redo();

        // paste objectFlowState
        PasteObjectFlowStateAction action2 = new PasteObjectFlowStateAction(objectFlowState, activityGraph);
        action2.execute();

        // undo the action
        action2.undo();

        // redo the action
        action2.redo();

        // paste actionState
        PasteActionStateAction action3 = new PasteActionStateAction(actionState, activityGraph);
        action3.execute();

        // undo the action
        action3.undo();

        // redo the action
        action3.redo();

        // paste sendSignalActionNode
        PasteSendSignalActionAction action4 = new PasteSendSignalActionAction(sendSignalActionNode, activityGraph);
        action4.execute();

        // undo the action
        action4.undo();

        // redo the action
        action4.redo();

        // paste acceptEventActionNode
        PasteAcceptEventActionAction action5 = new PasteAcceptEventActionAction(acceptEventActionNode, activityGraph);
        action5.execute();

        // undo the action
        action5.undo();

        // redo the action
        action5.redo();

        // paste forkNode
        PasteForkNodeAction action6 = new PasteForkNodeAction(forkNode, activityGraph);
        action6.execute();

        // undo the action
        action6.undo();

        // redo the action
        action6.redo();

        // paste joinNode
        PasteJoinNodeAction action7 = new PasteJoinNodeAction(joinNode, activityGraph);
        action7.execute();

        // undo the action
        action7.undo();

        // redo the action
        action7.redo();

        // paste decisionNode
        PasteDecisionNodeAction action8 = new PasteDecisionNodeAction(decisionNode, activityGraph);
        action8.execute();

        // undo the action
        action8.undo();

        // redo the action
        action8.redo();

        // paste mergeNode
        PasteMergeNodeAction action9 = new PasteMergeNodeAction(mergeNode, activityGraph);
        action9.execute();

        // undo the action
        action9.undo();

        // redo the action
        action9.redo();

        // paste flowFinalNode
        PasteFlowFinalNodeAction action10 = new PasteFlowFinalNodeAction(flowFinalNode, activityGraph);
        action10.execute();

        // undo the action
        action10.undo();

        // redo the action
        action10.redo();

        // paste finalNode
        PasteFinalNodeAction action11 = new PasteFinalNodeAction(finalNode, activityGraph);
        action11.execute();

        // undo the action
        action11.undo();

        // redo the action
        action11.redo();

        // paste transition
        PasteTransitionAction action12 = new PasteTransitionAction(transition, activityGraph);
        action12.execute();

        // undo the action
        action12.undo();

        // redo the action
        action12.redo();
    }

    /**
     * <p>
     * Paste actions are expected to be selected by the application using this component.
     * </p>
     *
     * <p>
     * Note, other types of actions are omitted because they are the same as the CopyInitialNodeAction.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSelectPasteAction() throws Exception {
        // copy initialNode
        CopyInitialNodeAction action = new CopyInitialNodeAction(initialNode, clipboard);
        action.execute();

        // an initialNode has been copied to the clipboard,
        // the code below shows how to call the correct paste action.
        Transferable contents = clipboard.getContents(null);
        if (contents.isDataFlavorSupported(ActivityDataFlavor.INITIAL_NODE)) {
            // get the pasted object
            Object data = contents.getTransferData(ActivityDataFlavor.INITIAL_NODE);
            PasteInitialNodeAction action1 = new PasteInitialNodeAction(data, activityGraph);

            // execute the action to add data into activityGraph
            action1.execute();
        }

        // other types of actions are just the same and so it omitted here.
    }
}
