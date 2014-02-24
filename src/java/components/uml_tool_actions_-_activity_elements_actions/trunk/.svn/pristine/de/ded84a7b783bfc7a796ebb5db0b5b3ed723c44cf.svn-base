/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ActivityObjectClipboardUtility.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActivityObjectClipboardUtilityTests extends TestCase {
    /**
     * <p>
     * The Transition instance for testing.
     * </p>
     */
    private Transition transition;

    /**
     * <p>
     * The StateVertex instance for testing.
     * </p>
     */
    private StateVertex state;

    /**
     * <p>
     * The Clipboard instance for testing.
     * </p>
     */
    private Clipboard clipboard;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        transition = new TransitionImpl();
        state = new ActionStateImpl();
        clipboard = new Clipboard("test");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        clipboard = null;
        state = null;
        transition = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ActivityObjectClipboardUtilityTests.class);
    }

    /**
     * <p>
     * Tests ActivityObjectClipboardUtility#copyTransition(Transition,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : CopyTransition is executed correctly, and the transition is copied to the clipboard.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCopyTransition() throws Exception {
        StateVertex source = new SimpleStateImpl();
        StateVertex target = new SimpleStateImpl();
        Guard guard = new GuardImpl();
        transition.setSource(source);
        transition.setTarget(target);
        transition.setGuard(guard);

        ActivityObjectClipboardUtility.copyTransition(transition, clipboard);

        Object content = clipboard.getData(ActivityDataFlavor.TRANSITION);
        assertTrue("Expects Transition type.", content != null && content instanceof Transition);
        assertNotSame("Expects the content is cloned", content, transition);

        Transition clonedTransition = (Transition) content;
        assertSame("The source should be set by reference.", source, clonedTransition.getSource());
        assertSame("The target should be set by reference.", target, clonedTransition.getTarget());
        assertNotSame("The guard should be set by clone", guard, clonedTransition.getGuard());
    }

    /**
     * <p>
     * Tests ActivityObjectClipboardUtility#copyTransition(Transition,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transition is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCopyTransition_NullTransition() throws ActivityObjectCloneException {
        try {
            ActivityObjectClipboardUtility.copyTransition(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectClipboardUtility#copyTransition(Transition,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when clipboard is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCopyTransition_NullClipboard() throws ActivityObjectCloneException {
        try {
            ActivityObjectClipboardUtility.copyTransition(transition, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectClipboardUtility#copyTransition(Transition,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the default constructor is not defined and
     * expects ActivityObjectCloneException.
     * </p>
     */
    public void testCopyTransition_ActivityObjectCloneException() {
        MockTransition mockTransition = new MockTransition("Test");
        try {
            ActivityObjectClipboardUtility.copyTransition(mockTransition, clipboard);
            fail("ActivityObjectCloneException expected.");
        } catch (ActivityObjectCloneException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectClipboardUtility#copyStateNode(StateVertex,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : CopyStateNode is executed correctly, and the state is copied to the clipboard.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode() throws Exception {
        ActivityObjectClipboardUtility.copyStateNode(state, clipboard);

        Object content = clipboard.getData(ActivityDataFlavor.ACTION_STATE);
        assertTrue("Expects SimpleState type.", content != null && content instanceof ActionState);
        assertNotSame("Expects the content is cloned", content, state);
    }

    /**
     * <p>
     * Tests ActivityObjectClipboardUtility#copyStateNode(StateVertex,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode_NullState() throws Exception {
        try {
            ActivityObjectClipboardUtility.copyStateNode(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectClipboardUtility#copyStateNode(StateVertex,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when clipboard is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCopyStateNode_NullClipboard() throws Exception {
        try {
            ActivityObjectClipboardUtility.copyStateNode(state, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectClipboardUtility#copyStateNode(StateVertex,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when default constructor is not defined for the state and
     * expects ActivityObjectCloneException.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testCopyStateNode_ActivityObjectCloneException() throws ActionExecutionException {
        MockObjectFlowState mockObjectFlowState = new MockObjectFlowState("Test");
        try {
            ActivityObjectClipboardUtility.copyStateNode((StateVertex) mockObjectFlowState, clipboard);
            fail("ActivityObjectCloneException expected.");
        } catch (ActivityObjectCloneException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectClipboardUtility#copyStateNode(StateVertex,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the type of the state is unknown and expects ActionExecutionException.
     * </p>
     */
    public void testCopyStateNode_UnknownStateVertex() {
        StateVertex stateVertex = new MockStateVertex();
        try {
            ActivityObjectClipboardUtility.copyStateNode(stateVertex, clipboard);
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectClipboardUtility#copyStateNode(StateVertex,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the kind of the state is not set and expects ActionExecutionException.
     * </p>
     */
    public void testCopyStateNode_PseudostateKindNotSet() {
        Pseudostate pseudostate = new PseudostateImpl();
        try {
            ActivityObjectClipboardUtility.copyStateNode(pseudostate, clipboard);
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectClipboardUtility#copyStateNode(StateVertex,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the simple state is invalid and expects ActionExecutionException.
     * </p>
     */
    public void testCopyStateNode_InvalidSimpleState() {
        SimpleState simpleState = new SimpleStateImpl();
        try {
            ActivityObjectClipboardUtility.copyStateNode(simpleState, clipboard);
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

}