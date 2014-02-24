/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CutTransitionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutTransitionActionTests extends TestCase {

    /**
     * <p>
     * The CutTransitionAction instance for testing.
     * </p>
     */
    private CutTransitionAction action;

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
     * The StateMachine instance for testing.
     * </p>
     */
    private StateMachine stateMachine;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);

        transition = new TransitionImpl();
        stateMachine = new StateMachineImpl();
        transition.setStateMachine(stateMachine);
        clipboard = new Clipboard("Test");
        action = new CutTransitionAction(transition, clipboard);
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
        action = null;
        clipboard = null;
        transition = null;

        TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(CutTransitionActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CutTransitionAction#CutTransitionAction(Transition,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutTransitionAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CutTransitionAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CutTransitionAction#CutTransitionAction(Transition,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutTransitionAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CutTransitionAction instance.",
            new CutTransitionAction(transition, null));
    }

    /**
     * <p>
     * Tests ctor CutTransitionAction#CutTransitionAction(Transition,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transition is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullTransition() {
        try {
            new CutTransitionAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CutTransitionAction#CutTransitionAction(Transition,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transition is not set the StateMachine and
     * expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullStateMachine() {
        transition = new TransitionImpl();
        try {
            new CutTransitionAction(transition, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests CutTransitionAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Undo is executed correctly, the transition is added.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndo() throws Exception {
        action.execute();
        action.undo();
        assertTrue("Failed to execute the undo() method.", stateMachine.containsTransition(transition));
    }

    /**
     * <p>
     * Tests CutTransitionAction#undo() for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the action can not be undo and expects CannotUndoException.
     * </p>
     */
    public void testUndo_CannotUndoException() {
        action.undo();
        try {
            action.undo();
            fail("CannotUndoException expected.");
        } catch (CannotUndoException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests CutTransitionAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Execute is executed correctly, the transition is removed.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        action.execute();

        Object content = clipboard.getData(ActivityDataFlavor.TRANSITION);
        assertTrue("Expects Transition type.", content != null && content instanceof Transition);
        assertTrue("Expects the content is cloned", content != transition);

        assertFalse("Failed to execute the Execute() method.", stateMachine.containsTransition(transition));
    }

    /**
     * <p>
     * Tests CutTransitionAction#execute() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the default constructor of the state
     * is not defined and expects ActivityObjectCloneException.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testExecute_ActivityObjectCloneException() throws ActionExecutionException {
        MockTransition state = new MockTransition("Test");
        state.setStateMachine(stateMachine);
        action = new CutTransitionAction((Transition) state, clipboard);
        try {
            action.execute();
            fail("ActivityObjectCloneException expected.");
        } catch (ActivityObjectCloneException e) {
            //good
        }
    }

}