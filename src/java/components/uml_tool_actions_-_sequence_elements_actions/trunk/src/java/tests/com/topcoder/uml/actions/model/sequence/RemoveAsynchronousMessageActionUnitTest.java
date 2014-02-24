/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for
 * {@link RemoveAsynchronousMessageAction} class. The accuracy test cases gives all valid inputs to the
 * methods/constructors and checks for inconsistencies The failure test cases gives all invalid inputs to the
 * methods/constructors and checks for expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class RemoveAsynchronousMessageActionUnitTest extends TestCase {

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus stimulus = null;

    /**
     * RemoveAsynchronousMessageAction instance to be used for the testing.
     */
    private RemoveAsynchronousMessageAction removeAsynchronousMessageAction = null;

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
        removeAsynchronousMessageAction = new RemoveAsynchronousMessageAction(stimulus);
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
        removeAsynchronousMessageAction = null;
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
        return new TestSuite(RemoveAsynchronousMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveAsynchronousMessageAction#RemoveAsynchronousMessageAction(Stimulus)}
     * constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_RemoveAsynchronousMessageAction() throws Exception {
        // check for null
        assertNotNull("RemoveAsynchronousMessageAction creation failed", removeAsynchronousMessageAction);
        // check for the variable initialization.
        assertEquals("RemoveAsynchronousMessageAction creation failed", stimulus, removeAsynchronousMessageAction
            .getStimulus());
    }

    /**
     * <p>
     * Failure test for {@link RemoveAsynchronousMessageAction#RemoveAsynchronousMessageAction(Stimulus)}
     * constructor.
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
    public void test_failure_RemoveAsynchronousMessageAction() throws Exception {
        try {
            new RemoveAsynchronousMessageAction(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as Expected
        }
    }

    /**
     * <p>
     * Failure test for {@link RemoveAsynchronousMessageAction#RemoveAsynchronousMessageAction(Stimulus)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        Stimulus stimulus : Valid Value
     * </pre>
     *
     * <p>
     * The stimulus is not of correct message type.
     * </p>
     * <p>
     * Expected {@link SequenceConfigurationException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_RemoveAsynchronousMessageAction1() throws Exception {
        try {
            new RemoveAsynchronousMessageAction(TestHelper.getReturnMessage());
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveAsynchronousMessageAction#getPresentationName()} method.
     * </p>
     * <p>
     * Checks the presentation name.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getPresentationName() throws Exception {
        assertEquals("getPresentationName failed", removeAsynchronousMessageAction.getPresentationName(),
            "Remove Asynchronous Message");
    }
}
