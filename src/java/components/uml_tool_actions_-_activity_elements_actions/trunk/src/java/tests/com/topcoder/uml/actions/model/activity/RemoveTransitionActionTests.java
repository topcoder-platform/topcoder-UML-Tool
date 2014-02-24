/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

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
 * Unit test cases for RemoveTransitionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveTransitionActionTests extends TestCase {

    /**
     * <p>
     * The RemoveTransitionAction instance for testing.
     * </p>
     */
    private RemoveTransitionAction action;

    /**
     * <p>
     * The Transition instance for testing.
     * </p>
     */
    private Transition transition;

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
        action = new RemoveTransitionAction(transition);
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
        transition = null;
        stateMachine = null;

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
        return new TestSuite(RemoveTransitionActionTests.class);
    }

    /**
     * <p>
     * Tests ctor RemoveTransitionAction#RemoveTransitionAction(Transition) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created RemoveTransitionAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new RemoveTransitionAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor RemoveTransitionAction#RemoveTransitionAction(Transition) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transition is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullTransition() {
        try {
            new RemoveTransitionAction(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests RemoveTransitionAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Undo is executed correctly, the transition is added.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testUndo() throws ActionExecutionException {
        action.execute();
        action.undo();
        assertTrue("Failed to execute the undo() method.", stateMachine.containsTransition(transition));
    }

    /**
     * <p>
     * Tests RemoveTransitionAction#undo() for failure.
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
     * Tests RemoveTransitionAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Execute is executed correctly, the transition is removed.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testExecute() throws ActionExecutionException {
        action.execute();
        assertFalse("Failed to execute the Execute() method.", stateMachine.containsTransition(transition));
    }
}