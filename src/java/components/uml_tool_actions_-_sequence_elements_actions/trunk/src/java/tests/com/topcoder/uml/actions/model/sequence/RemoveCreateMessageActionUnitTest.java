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
 * This Junit Test suite contains the accuracy and failure test cases for {@link RemoveCreateMessageAction}
 * class. The accuracy test cases gives all valid inputs to the methods/constructors and checks for
 * inconsistencies The failure test cases gives all invalid inputs to the methods/constructors and checks for
 * expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class RemoveCreateMessageActionUnitTest extends TestCase {

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus stimulus = null;

    /**
     * RemoveCreateMessageAction instance to be used for the testing.
     */
    private RemoveCreateMessageAction removeCreateMessageAction = null;

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
        stimulus = TestHelper.getCreateMessage();
        removeCreateMessageAction = new RemoveCreateMessageAction(stimulus);
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
        removeCreateMessageAction = null;
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
        return new TestSuite(RemoveCreateMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveCreateMessageAction#RemoveCreateMessageAction(Stimulus)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_RemoveCreateMessageAction() throws Exception {
        // check for null
        assertNotNull("RemoveCreateMessageAction creation failed", removeCreateMessageAction);
        // check for the variable initialization.
        assertEquals("RemoveCreateMessageAction creation failed", stimulus, removeCreateMessageAction
            .getStimulus());
    }

    /**
     * <p>
     * Failure test for {@link RemoveCreateMessageAction#RemoveCreateMessageAction(Stimulus)} constructor.
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
    public void test_failure_RemoveCreateMessageAction() throws Exception {
        try {
            new RemoveCreateMessageAction(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as Expected
        }
    }

    /**
     * <p>
     * Failure test for {@link RemoveCreateMessageAction#RemoveCreateMessageAction(Stimulus)} constructor.
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
    public void test_failure_RemoveCreateMessageAction1() throws Exception {
        try {
            new RemoveCreateMessageAction(TestHelper.getReturnMessage());
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveCreateMessageAction#getPresentationName()} method.
     * </p>
     * <p>
     * Checks the presentation name.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getPresentationName() throws Exception {
        assertEquals("getPresentationName failed", removeCreateMessageAction.getPresentationName(),
            "Remove Create Message");
    }
}
