/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link CutMessageAction} class. The
 * accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The
 * failure test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class CutMessageActionUnitTest extends TestCase {

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus asynchronousMessage = null;

    /**
     * CutMessageAction instance to be used for the testing.
     */
    private CutMessageAction cutMessageAction = null;

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
        asynchronousMessage = TestHelper.getAsynchronousMessage();
        Collaboration collaboration = new CollaborationImpl();
        collaboration.addOwnedElement(asynchronousMessage);
        asynchronousMessage.setNamespace(collaboration);
        cutMessageAction = new MockCutMessageAction(asynchronousMessage);
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
        asynchronousMessage = null;
        cutMessageAction = null;
        Thread.sleep(10);
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
        return new TestSuite(CutMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link CutMessageAction#CutMessageAction(Stimulus)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CutMessageAction() throws Exception {
        // check for null
        assertNotNull("CutMessageAction creation failed", cutMessageAction);
        // check for the variable initialization.
        assertEquals("CutMessageAction creation failed", asynchronousMessage, cutMessageAction.getStimulus());
    }

    /**
     * <p>
     * Failure test for {@link CutMessageAction#CutMessageAction(Stimulus)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *      Input
     *           Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CutMessageAction() throws Exception {
        try {
            new MockCutMessageAction(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CutMessageAction#CutMessageAction(Stimulus, Clipboard)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CutMessageAction1() throws Exception {
        Clipboard clipboard = new Clipboard("test");
        CutMessageAction cutMessageAction1 = new MockCutMessageAction(asynchronousMessage, clipboard);
        // check for null
        assertNotNull("CutMessageAction creation failed", cutMessageAction1);
        // check for the variable initialization.
        assertEquals("CutMessageAction creation failed", asynchronousMessage, cutMessageAction1.getStimulus());
    }

    /**
     * <p>
     * Failure test for {@link CutMessageAction#CutMessageAction(Stimulus, Clipboard)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *      Input
     *           Stimulus stimulus : null value
     *           Clipboard clipboard : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CutMessageAction1() throws Exception {
        try {
            new MockCutMessageAction(null, new Clipboard("test"));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CutMessageAction#CutMessageAction(Stimulus, Clipboard)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *      Input
     *           Stimulus stimulus : Valid value
     *           Clipboard clipboard : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CutMessageAction2() throws Exception {
        try {
            new MockCutMessageAction(asynchronousMessage, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "clipboard in CutMessageAction#CutMessageAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CutMessageAction#execute()} method.
     * </p>
     * <p>
     * Executes and checks whether the message copied is the same message. Checks whether the stimulus is
     * removed from the namespace.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        cutMessageAction.execute();
        assertTrue("execute failed", cutMessageAction.getMessageUtil().checkAsynchronousMessage(
            (Stimulus) Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(
                CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR)));
        assertTrue("execute failed", !cutMessageAction.getMessageUtil()
            .checkStimulusNamespace(asynchronousMessage));
    }

    /**
     * <p>
     * Failure test for {@link CutMessageAction#execute()} method.
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
            cutMessageAction.execute();
            cutMessageAction.execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CutMessageAction#redo()} method.
     * </p>
     * <p>
     * Call redo and check whether the message is removed from the namespace and canRedo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo() throws Exception {
        cutMessageAction.execute();
        cutMessageAction.undo();
        cutMessageAction.redo();
        assertTrue("redo failed", !cutMessageAction.getMessageUtil().checkStimulusNamespace(asynchronousMessage));
        assertFalse("redo failed", cutMessageAction.canRedo());
    }

    /**
     * <p>
     * Accuracy test for {@link CutMessageAction#redo()} method.
     * </p>
     * <p>
     * Calls redo before undo to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo1() throws Exception {
        cutMessageAction.execute();
        cutMessageAction.redo();
    }

    /**
     * <p>
     * Accuracy test for {@link CutMessageAction#undo()} method.
     * </p>
     * <p>
     * Call undo and check whether the message is removed from the namespace and canUndo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo() throws Exception {
        cutMessageAction.execute();
        cutMessageAction.undo();
        assertTrue("Undo failed", cutMessageAction.getMessageUtil().checkStimulusNamespace(asynchronousMessage));
        assertFalse("Undo failed", cutMessageAction.canUndo());
    }

    /**
     * <p>
     * Accuracy test for {@link CutMessageAction#undo()} method.
     * </p>
     * <p>
     * Calling undo twice to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo1() throws Exception {
        cutMessageAction.undo();
        cutMessageAction.undo();
    }

}
