/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link MessageUndoableAction} class.
 * The accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies
 * The failure test cases gives all invalid inputs to the methods/constructors and checks for expected
 * exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class MessageUndoableActionUnitTest extends TestCase {

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus asynchronousMessage = null;

    /**
     * MessageUndoableAction instance to be used for the testing.
     */
    private MessageUndoableAction messageUndoableAction = null;

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
        messageUndoableAction = new MockMessageUndoableAction(asynchronousMessage);
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
        messageUndoableAction = null;
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
        return new TestSuite(MessageUndoableActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUndoableAction#MessageUndoableAction(Stimulus)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_MessageUndoableAction() throws Exception {
        // check for null
        assertNotNull("MessageUndoableAction creation failed", messageUndoableAction);
        // check for the variable initialization.
        assertEquals("MessageUndoableAction creation failed", asynchronousMessage, messageUndoableAction
            .getStimulus());
    }

    /**
     * <p>
     * Failure test for {@link MessageUndoableAction#MessageUndoableAction(Stimulus)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_MessageUndoableAction() throws Exception {
        try {
            new MockMessageUndoableAction(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in MessageUndoableAction#MessageUndoableAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUndoableAction#MessageUndoableAction(Transferable, DataFlavor)}
     * constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_MessageUndoableAction1() throws Exception {
        MessageUndoableAction messageUndoableAction1 = new MockMessageUndoableAction(new CollaborationTransfer(
            asynchronousMessage), CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR);
        // check for null
        assertNotNull("MessageUndoableAction creation failed", messageUndoableAction1);
        // check for the variable initialization.
        assertEquals("MessageUndoableAction creation failed", asynchronousMessage, messageUndoableAction1
            .getStimulus());
    }

    /**
     * <p>
     * Failure test for {@link MessageUndoableAction#MessageUndoableAction(Transferable, DataFlavor)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Transferable transferable : null value
     *         DataFlavor dataFlavor : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_MessageUndoableAction1() throws Exception {
        try {
            new MockMessageUndoableAction(null, CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "transferable in MessageUndoableAction#MessageUndoableAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test for {@link MessageUndoableAction#MessageUndoableAction(Transferable, DataFlavor)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Transferable transferable : Valid value
     *         DataFlavor dataFlavor : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_MessageUndoableAction2() throws Exception {
        try {
            new MockMessageUndoableAction(new CollaborationTransfer(asynchronousMessage), null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "dataFlavor in MessageUndoableAction#MessageUndoableAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test for {@link MessageUndoableAction#MessageUndoableAction(Transferable, DataFlavor)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Transferable transferable : Valid Value
     *         DataFlavor dataFlavor : Valid Value
     * </pre>
     *
     * <p>
     * The flavor not corresponding to the transferable instance.
     * </p>
     * <p>
     * Expected {@link SequenceConfigurationException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_MessageUndoableAction3() throws Exception {
        try {
            new MockMessageUndoableAction(new CollaborationTransfer(asynchronousMessage),
                CollaborationTransfer.CREATE_MESSAGE_FLAVOR);
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUndoableAction#getMessageUtil()} method.
     * </p>
     * <p>
     * Checks if the message util is not null.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getMessageUtil() throws Exception {
        assertNotNull("getMessageUtil failed", messageUndoableAction.getMessageUtil());
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUndoableAction#getLog()} method.
     * </p>
     * <p>
     * Checks if the Log is not null.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getLog() throws Exception {
        assertNotNull("getLog failed", messageUndoableAction.getLog());
    }
}
