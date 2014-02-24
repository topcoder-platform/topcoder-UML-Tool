/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link RemoveMessageAction} class.
 * The accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies
 * The failure test cases gives all invalid inputs to the methods/constructors and checks for expected
 * exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class RemoveMessageActionUnitTest extends TestCase {

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus stimulus = null;

    /**
     * RemoveMessageAction instance to be used for the testing.
     */
    private RemoveMessageAction removeMessageAction = null;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestHelper.loadConfig();
        stimulus = TestHelper.getAsynchronousMessage();
        Collaboration collaboration = new CollaborationImpl();
        collaboration.addOwnedElement(stimulus);
        stimulus.setNamespace(collaboration);
        removeMessageAction = new MockRemoveMessageAction(stimulus);
    }

    /**
     * <p>
     * Tears down the environment after the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        removeMessageAction = null;
        stimulus = null;
        TestHelper.releaseConfig();
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(RemoveMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveMessageAction#RemoveMessageAction(Stimulus)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_RemoveMessageAction() throws Exception {
        // check for null
        assertNotNull("RemoveMessageAction creation failed", removeMessageAction);
        // check for the variable initialization.
        assertEquals("RemoveMessageAction creation failed", stimulus, removeMessageAction.getStimulus());
    }

    /**
     * <p>
     * Failure test for {@link RemoveMessageAction#RemoveMessageAction(Stimulus)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_RemoveMessageAction() throws Exception {
        try {
            new MockRemoveMessageAction(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveMessageAction#execute()} method.
     * </p>
     * <p>
     * Checks whether the stimulus is removed from the namespace.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        removeMessageAction.execute();
        assertTrue("execute failed", !removeMessageAction.getMessageUtil().checkStimulusNamespace(stimulus));
    }

    /**
     * <p>
     * Failure test for {@link RemoveMessageAction#execute()} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     * <p>
     * Calling the execute twice.
     * </p>
     * <p>
     * Expected {@link ActionExecutionException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_execute() throws Exception {
        try {
            removeMessageAction.execute();
            removeMessageAction.execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveMessageAction#redo()} method.
     * </p>
     * <p>
     * Call redo and check whether the message is removed from the namespace and canRedo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo() throws Exception {
        removeMessageAction.execute();
        removeMessageAction.undo();
        removeMessageAction.redo();
        assertTrue("redo failed", !removeMessageAction.getMessageUtil().checkStimulusNamespace(stimulus));
        assertFalse("redo failed", removeMessageAction.canRedo());
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveMessageAction#redo()} method.
     * </p>
     * <p>
     * Calls redo before undo to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo1() throws Exception {
        removeMessageAction.execute();
        removeMessageAction.redo();
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveMessageAction#undo()} method.
     * </p>
     * <p>
     * Call undo and check whether the message is removed from the namespace and canUndo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo() throws Exception {
        removeMessageAction.execute();
        removeMessageAction.undo();
        assertTrue("Undo failed", removeMessageAction.getMessageUtil().checkStimulusNamespace(stimulus));
        assertFalse("Undo failed", removeMessageAction.canUndo());
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveMessageAction#undo()} method.
     * </p>
     * <p>
     * Calling undo twice to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo1() throws Exception {
        removeMessageAction.undo();
        removeMessageAction.undo();
    }
}
