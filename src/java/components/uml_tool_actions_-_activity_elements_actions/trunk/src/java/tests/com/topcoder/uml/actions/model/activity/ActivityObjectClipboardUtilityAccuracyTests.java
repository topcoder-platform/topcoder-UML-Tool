/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.accuracytests.AccuracyTestHelper;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * This class aggregates accuracy tests for ActivityObjectClipboardUtility class.
 * </p>
 * <p>
 * Note: Since the tested class is package-private, this class is located under the same package as the tested
 * class.
 * </p>
 *
 * @author ch_music
 * @version 1.0
 */
public class ActivityObjectClipboardUtilityAccuracyTests extends TestCase {

    /**
     * An instance of Clipboard for testing.
     */
    private Clipboard clipboard;

    /**
     * Initializes the testing environment.
     */
    protected void setUp() {
        clipboard = new Clipboard("test");
    }

    /**
     * Tests copyTransition method.
     *
     * @throws Exception to JUnit
     */
    public void testCopyTransition1() throws Exception {
        ActivityObjectClipboardUtility.copyTransition(AccuracyTestHelper.createTransition(), clipboard);

        // Retrieves clipboard content.
        Object content = clipboard.getContents(null);

        assertNotNull("Did not copy anything to clipboard (null).", content);
        assertTrue("Clipboard content is not an instance of ActivityObjectSelection",
                content instanceof ActivityObjectSelection);

        ActivityObjectSelection selectionObject = (ActivityObjectSelection) content;

        // Retrieves the Transition object
        Object retrievedTransition = selectionObject.getTransferData(ActivityDataFlavor.TRANSITION);

        assertNotNull("Clipboard's transferred data is null", retrievedTransition);
        assertTrue("Clipboard's transferred data is not of type Transition",
                retrievedTransition instanceof Transition);
    }

    /**
     * Tests copyTransition method.
     *
     * @throws Exception to JUnit
     */
    public void testCopyTransition2() throws Exception {
        Transition transition = AccuracyTestHelper.createTransition();

        transition.setGuard(new GuardImpl());
        transition.setSource(new SimpleStateImpl());
        transition.setTarget(new SimpleStateImpl());

        ActivityObjectClipboardUtility.copyTransition(transition, clipboard);

        // Retrieves clipboard content.
        Object content = clipboard.getContents(null);

        assertNotNull("Did not copy anything to clipboard (null).", content);
        assertTrue("Clipboard content is not an instance of ActivityObjectSelection",
                content instanceof ActivityObjectSelection);

        ActivityObjectSelection selectionObject = (ActivityObjectSelection) content;

        // Retrieves the Transition object
        Object retrievedTransition = selectionObject.getTransferData(ActivityDataFlavor.TRANSITION);

        assertNotNull("Clipboard's transferred data is null", retrievedTransition);
        assertTrue("Clipboard's transferred data is not of type Transition",
                retrievedTransition instanceof Transition);

        // Checks Transition object for guard, source, and target.
        Transition t = (Transition) retrievedTransition;
        assertNotNull("Guard is not set", t.getGuard());
        assertNotNull("Source is not set", t.getSource());
        assertNotNull("Target is not set", t.getTarget());
    }

    /**
     * Tests copyStateNode method.
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode1() throws Exception {
        ActivityObjectClipboardUtility.copyStateNode(AccuracyTestHelper.createInitialNode(), clipboard);

        Object content = getClipboardContents(clipboard, ActivityDataFlavor.INITIAL_NODE);
        assertNotNull("Fails to copy (null).", content);
        assertTrue("Fails to copy correctly (wrong type).", content instanceof Pseudostate);
        assertEquals("Fails to copy (wrong object).", ((Pseudostate) content).getKind(), PseudostateKind.INITIAL);
    }

    /**
     * Tests copyStateNode method.
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode2() throws Exception {
        ActivityObjectClipboardUtility.copyStateNode(AccuracyTestHelper.createForkNode(), clipboard);

        Object content = getClipboardContents(clipboard, ActivityDataFlavor.FORK_NODE);
        assertNotNull("Fails to copy (null).", content);
        assertTrue("Fails to copy correctly (wrong type).", content instanceof Pseudostate);
        assertEquals("Fails to copy (wrong object).", ((Pseudostate) content).getKind(), PseudostateKind.FORK);
    }

    /**
     * Tests copyStateNode method.
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode3() throws Exception {
        ActivityObjectClipboardUtility.copyStateNode(AccuracyTestHelper.createJoinNode(), clipboard);

        Object content = getClipboardContents(clipboard, ActivityDataFlavor.JOIN_NODE);
        assertNotNull("Fails to copy (null).", content);
        assertTrue("Fails to copy correctly (wrong type).", content instanceof Pseudostate);
        assertEquals("Fails to copy (wrong object).", ((Pseudostate) content).getKind(), PseudostateKind.JOIN);
    }

    /**
     * Tests copyStateNode method.
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode4() throws Exception {
        ActivityObjectClipboardUtility.copyStateNode(AccuracyTestHelper.createDecisionNode(), clipboard);

        Object content = getClipboardContents(clipboard, ActivityDataFlavor.DECISION_NODE);
        assertNotNull("Fails to copy (null).", content);
        assertTrue("Fails to copy correctly (wrong type).", content instanceof Pseudostate);
        assertEquals("Fails to copy (wrong object).", ((Pseudostate) content).getKind(), PseudostateKind.CHOICE);
    }

    /**
     * Tests copyStateNode method.
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode5() throws Exception {
        ActivityObjectClipboardUtility.copyStateNode(AccuracyTestHelper.createMergeNode(), clipboard);

        Object content = getClipboardContents(clipboard, ActivityDataFlavor.MERGE_NODE);
        assertNotNull("Fails to copy (null).", content);
        assertTrue("Fails to copy correctly (wrong type).", content instanceof Pseudostate);
        assertEquals("Fails to copy (wrong object).", ((Pseudostate) content).getKind(), PseudostateKind.JUNCTION);
    }

    /**
     * Tests copyStateNode method.
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode6() throws Exception {
        ActivityObjectClipboardUtility.copyStateNode(AccuracyTestHelper.createFinalNode(), clipboard);

        Object content = getClipboardContents(clipboard, ActivityDataFlavor.FINAL_NODE);
        assertNotNull("Fails to copy (null).", content);
        assertTrue("Fails to copy correctly (wrong type).", content instanceof FinalState);
    }

    /**
     * Tests copyStateNode method.
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode7() throws Exception {
        ActivityObjectClipboardUtility.copyStateNode(AccuracyTestHelper.createFlowFinalNode(), clipboard);

        Object content = getClipboardContents(clipboard, ActivityDataFlavor.FLOW_FINAL_NODE);
        assertNotNull("Fails to copy (null).", content);
        assertTrue("Fails to copy correctly (wrong type).", content instanceof FinalState);
        assertTrue("Fails to copy correctly (wrong TaggedValue)", AccuracyTestHelper.checkTaggedValue(
                (FinalState) content, "FinalNodeType", "FlowFinalNode"));
    }

    /**
     * Tests copyStateNode method.
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode8() throws Exception {
        ActivityObjectClipboardUtility.copyStateNode(AccuracyTestHelper.createObjectFlowState(), clipboard);

        Object content = getClipboardContents(clipboard, ActivityDataFlavor.OBJECT_FLOW_STATE);
        assertNotNull("Fails to copy (null).", content);
        assertTrue("Fails to copy correctly (wrong type).", content instanceof ObjectFlowState);
    }

    /**
     * Tests copyStateNode method.
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode9() throws Exception {
        ActivityObjectClipboardUtility.copyStateNode(AccuracyTestHelper.createActionState(), clipboard);

        Object content = getClipboardContents(clipboard, ActivityDataFlavor.ACTION_STATE);
        assertNotNull("Fails to copy (null).", content);
        assertTrue("Fails to copy correctly (wrong type).", content instanceof ActionState);
    }

    /**
     * Tests copyStateNode method.
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode10() throws Exception {
        ActivityObjectClipboardUtility.copyStateNode(AccuracyTestHelper.createSendSignalAction(), clipboard);

        Object content = getClipboardContents(clipboard, ActivityDataFlavor.SEND_SIGNAL_ACTION);
        assertNotNull("Fails to copy (null).", content);
        assertTrue("Fails to copy correctly (wrong type).", content instanceof SimpleState);
        assertTrue("Fails to copy correctly (wrong TaggedValue).", AccuracyTestHelper.checkTaggedValue(
                (SimpleState) content, "SendSignalAction", "True"));
    }

    /**
     * Tests copyStateNode method.
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode11() throws Exception {
        ActivityObjectClipboardUtility.copyStateNode(AccuracyTestHelper.createAcceptEventAction(), clipboard);

        Object content = getClipboardContents(clipboard, ActivityDataFlavor.ACCEPT_EVENT_ACTION);
        assertNotNull("Fails to copy (null).", content);
        assertTrue("Fails to copy correctly (wrong type).", content instanceof SimpleState);
        assertTrue("Fails to copy correctly (wrong TaggedValue).", AccuracyTestHelper.checkTaggedValue(
                (SimpleState) content, "AcceptEventAction", "True"));
    }

    /**
     * Retrieves Clipboard contents.
     *
     * @param clipboard the Clipboard with the desired content
     * @param flavor the expected DataFlavor of the content
     * @return the retrieved Clipboard contents
     * @throws Exception if any exception occurs
     */
    public static Object getClipboardContents(Clipboard clipboard, DataFlavor flavor) throws Exception {
        Object content = clipboard.getContents(null);
        if (content != null && content instanceof ActivityObjectSelection) {
            ActivityObjectSelection selectionObject = (ActivityObjectSelection) content;
            return selectionObject.getTransferData(flavor);
        } else {
            return null;
        }
    }
}
