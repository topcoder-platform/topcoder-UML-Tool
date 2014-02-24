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
 * This Junit Test suite contains the accuracy and failure test cases for {@link CutSendSignalMessageAction}
 * class. The accuracy test cases gives all valid inputs to the methods/constructors and checks for
 * inconsistencies The failure test cases gives all invalid inputs to the methods/constructors and checks for
 * expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class CutSendSignalMessageActionUnitTest extends TestCase {

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus stimulus = null;

    /**
     * CutSendSignalMessageAction instance to be used for the testing.
     */
    private CutSendSignalMessageAction cutSendSignalMessageAction = null;

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
        stimulus = TestHelper.getSendSignalMessage();
        cutSendSignalMessageAction = new CutSendSignalMessageAction(stimulus);
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
        cutSendSignalMessageAction = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(CutSendSignalMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link CutSendSignalMessageAction#CutSendSignalMessageAction(Stimulus)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CutSendSignalMessageAction() throws Exception {
        // check for null
        assertNotNull("CutSendSignalMessageAction creation failed", cutSendSignalMessageAction);
        // check for the variable initialization.
        assertEquals("CutSendSignalMessageAction creation failed", stimulus, cutSendSignalMessageAction
            .getStimulus());
    }

    /**
     * <p>
     * Failure test for {@link CutSendSignalMessageAction#CutSendSignalMessageAction(Stimulus)} constructor.
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
    public void test_failure_CutSendSignalMessageAction() throws Exception {
        try {
            new CutSendSignalMessageAction(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CutSendSignalMessageAction#CutSendSignalMessageAction(Stimulus)} constructor.
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
    public void test_failure_CutSendSignalMessageAction1() throws Exception {
        try {
            new CutSendSignalMessageAction(TestHelper.getCreateMessage());
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CutSendSignalMessageAction#CutSendSignalMessageAction(Stimulus, Clipboard)}
     * constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CutSendSignalMessageAction1() throws Exception {
        CutSendSignalMessageAction cutSendSignalMessageAction1 = new CutSendSignalMessageAction(stimulus,
            new Clipboard("test"));
        // check for null
        assertNotNull("CutSendSignalMessageAction creation failed", cutSendSignalMessageAction1);
        // check for the variable initialization.
        assertEquals("CutSendSignalMessageAction creation failed", stimulus, cutSendSignalMessageAction1
            .getStimulus());
    }

    /**
     * <p>
     * Failure test for {@link CutSendSignalMessageAction#CutSendSignalMessageAction(Stimulus, Clipboard)}
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
    public void test_failure_CutSendSignalMessageAction2() throws Exception {
        try {
            new CutSendSignalMessageAction(null, new Clipboard("test"));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CutSendSignalMessageAction#CutSendSignalMessageAction(Stimulus, Clipboard)}
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
    public void test_failure_CutSendSignalMessageAction3() throws Exception {
        try {
            new CutSendSignalMessageAction(stimulus, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CutSendSignalMessageAction#CutSendSignalMessageAction(Stimulus, Clipboard)}
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
    public void test_failure_CutSendSignalMessageAction4() throws Exception {
        try {
            new CutSendSignalMessageAction(TestHelper.getCreateMessage(), new Clipboard("test"));
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CutSendSignalMessageAction#getPresentationName()} method.
     * </p>
     * <p>
     * Checks the presentation name.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getPresentationName() throws Exception {
        assertEquals("getPresentationName failed", cutSendSignalMessageAction.getPresentationName(),
            "Cut Send Signal Message");

    }
}
