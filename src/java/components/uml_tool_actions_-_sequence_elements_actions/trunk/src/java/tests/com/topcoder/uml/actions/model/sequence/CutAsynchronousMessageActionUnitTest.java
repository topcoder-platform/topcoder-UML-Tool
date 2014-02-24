/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Clipboard;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link CutAsynchronousMessageAction}
 * class. The accuracy test cases gives all valid inputs to the methods/constructors and checks for
 * inconsistencies The failure test cases gives all invalid inputs to the methods/constructors and checks for
 * expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class CutAsynchronousMessageActionUnitTest extends TestCase {

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus asynchronousMessage = null;

    /**
     * CutAsynchronousMessageAction instance to be used for the testing.
     */
    private CutAsynchronousMessageAction cutAsynchronousMessageAction = null;

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
        cutAsynchronousMessageAction = new CutAsynchronousMessageAction(asynchronousMessage);
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
        TestHelper.releaseConfig();
        asynchronousMessage = null;
        cutAsynchronousMessageAction = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(CutAsynchronousMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link CutAsynchronousMessageAction#CutAsynchronousMessageAction(Stimulus)}
     * constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CutAsynchronousMessageAction() throws Exception {
        // check for null
        assertNotNull("CutAsynchronousMessageAction creation failed", cutAsynchronousMessageAction);
        // check for the variable initialization.
        assertEquals("CutAsynchronousMessageAction creation failed", asynchronousMessage,
            cutAsynchronousMessageAction.getStimulus());
    }

    /**
     * <p>
     * Failure test for {@link CutAsynchronousMessageAction#CutAsynchronousMessageAction(Stimulus)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *       Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CutAsynchronousMessageAction() throws Exception {
        try {
            new CutAsynchronousMessageAction(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CutAsynchronousMessageAction#CutAsynchronousMessageAction(Stimulus)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *       Stimulus stimulus : Valid Value
     * </pre>
     *
     * <p>
     * If the message is not of the correct type.
     * </p>
     * <p>
     * Expected {@link SequenceConfigurationException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CutAsynchronousMessageAction1() throws Exception {
        try {
            new CutAsynchronousMessageAction(TestHelper.getCreateMessage());
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for
     * {@link CutAsynchronousMessageAction#CutAsynchronousMessageAction(Stimulus, Clipboard)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CutAsynchronousMessageAction1() throws Exception {
        CutAsynchronousMessageAction cutAsynchronousMessageAction1 = new CutAsynchronousMessageAction(
            asynchronousMessage, new Clipboard("test"));
        // check for null
        assertNotNull("CutAsynchronousMessageAction creation failed", cutAsynchronousMessageAction1);
        // check for the variable initialization.
        assertEquals("CutAsynchronousMessageAction creation failed", asynchronousMessage,
            cutAsynchronousMessageAction1.getStimulus());
    }

    /**
     * <p>
     * Failure test for {@link CutAsynchronousMessageAction#CutAsynchronousMessageAction(Stimulus, Clipboard)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *       Stimulus stimulus : null value
     *       Clipboard clipboard : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CutAsynchronousMessageAction2() throws Exception {
        try {
            new CutAsynchronousMessageAction(null, new Clipboard("test"));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CutAsynchronousMessageAction#CutAsynchronousMessageAction(Stimulus, Clipboard)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *       Stimulus stimulus : Valid value
     *       Clipboard clipboard : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CutAsynchronousMessageAction3() throws Exception {
        try {
            new CutAsynchronousMessageAction(asynchronousMessage, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CutAsynchronousMessageAction#CutAsynchronousMessageAction(Stimulus, Clipboard)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *       Stimulus stimulus : Valid Value
     *       Clipboard clipboard : Valid Value
     * </pre>
     *
     * <p>
     * If the message is not of the correct type.
     * </p>
     * <p>
     * Expected {@link SequenceConfigurationException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CutAsynchronousMessageAction4() throws Exception {
        try {
            new CutAsynchronousMessageAction(TestHelper.getCreateMessage(), new Clipboard("test"));
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CutAsynchronousMessageAction#getPresentationName()} method.
     * </p>
     * <p>
     * Checks the presentation name.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getPresentationName() throws Exception {
        assertEquals("getPresentationName failed", cutAsynchronousMessageAction.getPresentationName(),
            "Cut Asynchronous Message");

    }
}
