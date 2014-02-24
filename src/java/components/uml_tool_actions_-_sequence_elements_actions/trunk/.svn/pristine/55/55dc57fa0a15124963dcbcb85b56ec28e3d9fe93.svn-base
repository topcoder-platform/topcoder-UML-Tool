/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link CopyMessageAction} class. The
 * accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The
 * failure test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class CopyMessageActionUnitTest extends TestCase {

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus asynchronousMessage = null;

    /**
     * CopyMessageAction instance to be used for the testing.
     */
    private CopyMessageAction copyMessageAction = null;

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
        copyMessageAction = new MockCopyMessageAction(asynchronousMessage);
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
        copyMessageAction = null;
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
        return new TestSuite(CopyMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link CopyMessageAction#CopyMessageAction(Stimulus)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CopyMessageAction() throws Exception {
        // check for null
        assertNotNull("CopyMessageAction creation failed", copyMessageAction);
    }

    /**
     * <p>
     * Failure test for {@link CopyMessageAction#CopyMessageAction(Stimulus)} constructor.
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
    public void test_failure_CopyMessageAction() throws Exception {
        try {
            new MockCopyMessageAction(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in CopyMessageAction#CopyMessageAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CopyMessageAction#CopyMessageAction(Stimulus, Clipboard)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CopyMessageAction1() throws Exception {
        Clipboard clipboard = new Clipboard("test");
        CopyMessageAction copyMessageAction1 = new MockCopyMessageAction(asynchronousMessage, clipboard);
        // check for null
        assertNotNull("CopyMessageAction creation failed", copyMessageAction1);
    }

    /**
     * <p>
     * Failure test for {@link CopyMessageAction#CopyMessageAction(Stimulus, Clipboard)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Stimulus stimulus : null value
     *         Clipboard clipboard : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CopyMessageAction1() throws Exception {
        try {
            new MockCopyMessageAction(null, new Clipboard("test"));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in CopyMessageAction#CopyMessageAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test for {@link CopyMessageAction#CopyMessageAction(Stimulus, Clipboard)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Stimulus stimulus : Valid value
     *         Clipboard clipboard : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CopyMessageAction2() throws Exception {
        try {
            new MockCopyMessageAction(asynchronousMessage, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "clipboard in CopyMessageAction#CopyMessageAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CopyMessageAction#execute()} method.
     * </p>
     * <p>
     * Executes and checks whether the message copied is the same message.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        copyMessageAction.execute();
        assertTrue("execute failed", copyMessageAction.getMessageUtil().checkAsynchronousMessage(
            (Stimulus) Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(
                CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR)));
    }

    /**
     * <p>
     * Accuracy test for {@link CopyMessageAction#getMessageUtil()} method.
     * </p>
     * <p>
     * Checks whether the returned message util is not null.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getMessageUtil() throws Exception {
        assertNotNull("getMessageUtil failed", copyMessageAction.getMessageUtil());
    }
}
