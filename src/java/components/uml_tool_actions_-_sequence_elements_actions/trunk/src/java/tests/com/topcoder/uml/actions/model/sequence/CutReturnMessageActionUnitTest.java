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
 * This Junit Test suite contains the accuracy and failure test cases for {@link CutReturnMessageAction}
 * class. The accuracy test cases gives all valid inputs to the methods/constructors and checks for
 * inconsistencies The failure test cases gives all invalid inputs to the methods/constructors and checks for
 * expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class CutReturnMessageActionUnitTest extends TestCase {

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus stimulus = null;

    /**
     * CutReturnMessageAction instance to be used for the testing.
     */
    private CutReturnMessageAction cutReturnMessageAction = null;

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
        stimulus = TestHelper.getReturnMessage();
        cutReturnMessageAction = new CutReturnMessageAction(stimulus);
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
        stimulus = null;
        cutReturnMessageAction = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(CutReturnMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link CutReturnMessageAction#CutReturnMessageAction(Stimulus)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CutReturnMessageAction() throws Exception {
        // check for null
        assertNotNull("CutReturnMessageAction creation failed", cutReturnMessageAction);
        // check for the variable initialization.
        assertEquals("CutReturnMessageAction creation failed", stimulus, cutReturnMessageAction.getStimulus());
    }

    /**
     * <p>
     * Failure test for {@link CutReturnMessageAction#CutReturnMessageAction(Stimulus)} constructor.
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
    public void test_failure_CutReturnMessageAction() throws Exception {
        try {
            new CutReturnMessageAction(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CutReturnMessageAction#CutReturnMessageAction(Stimulus)} constructor.
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
    public void test_failure_CutReturnMessageAction1() throws Exception {
        try {
            new CutReturnMessageAction(TestHelper.getCreateMessage());
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CutReturnMessageAction#CutReturnMessageAction(Stimulus, Clipboard)}
     * constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CutReturnMessageAction1() throws Exception {
        CutReturnMessageAction cutReturnMessageAction1 = new CutReturnMessageAction(stimulus, new Clipboard("test"));
        // check for null
        assertNotNull("CutReturnMessageAction creation failed", cutReturnMessageAction1);
        // check for the variable initialization.
        assertEquals("CutReturnMessageAction creation failed", stimulus, cutReturnMessageAction1.getStimulus());
    }

    /**
     * <p>
     * Failure test for {@link CutReturnMessageAction#CutReturnMessageAction(Stimulus, Clipboard)}
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
    public void test_failure_CutReturnMessageAction2() throws Exception {
        try {
            new CutReturnMessageAction(null, new Clipboard("test"));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CutReturnMessageAction#CutReturnMessageAction(Stimulus, Clipboard)}
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
    public void test_failure_CutReturnMessageAction3() throws Exception {
        try {
            new CutReturnMessageAction(stimulus, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CutReturnMessageAction#CutReturnMessageAction(Stimulus, Clipboard)}
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
    public void test_failure_CutReturnMessageAction4() throws Exception {
        try {
            new CutReturnMessageAction(TestHelper.getCreateMessage(), new Clipboard("test"));
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CutReturnMessageAction#getPresentationName()} method.
     * </p>
     * <p>
     * Checks the presentation name.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getPresentationName() throws Exception {
        assertEquals("getPresentationName failed", cutReturnMessageAction.getPresentationName(),
            "Cut Return Message Action");

    }
}
