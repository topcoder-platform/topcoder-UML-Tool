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
 * This Junit Test suite contains the accuracy and failure test cases for {@link CopySendSignalMessageAction}
 * class. The accuracy test cases gives all valid inputs to the methods/constructors and checks for
 * inconsistencies The failure test cases gives all invalid inputs to the methods/constructors and checks for
 * expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class CopySendSignalMessageActionUnitTest extends TestCase {

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
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(CopySendSignalMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link CopySendSignalMessageAction#CopySendSignalMessageAction(Stimulus)}
     * constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CopySendSignalMessageAction() throws Exception {
        // check for null
        assertNotNull("CopySendSignalMessageAction creation failed", new CopySendSignalMessageAction(TestHelper
            .getSendSignalMessage()));
    }

    /**
     * <p>
     * Failure test for {@link CopySendSignalMessageAction#CopySendSignalMessageAction(Stimulus)} constructor.
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
    public void test_failure_CopySendSignalMessageAction() throws Exception {
        try {
            new CopySendSignalMessageAction(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CopySendSignalMessageAction#CopySendSignalMessageAction(Stimulus)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *      Input
     *           Stimulus stimulus : Valid Value
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
    public void test_failure_CopySendSignalMessageAction1() throws Exception {
        try {
            new CopySendSignalMessageAction(TestHelper.getCreateMessage());
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CopySendSignalMessageAction#CopySendSignalMessageAction(Stimulus, Clipboard)}
     * constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CopySendSignalMessageAction1() throws Exception {
        // check for null
        assertNotNull("CopySendSignalMessageAction creation failed", new CopySendSignalMessageAction(TestHelper
            .getSendSignalMessage(), new Clipboard("test")));
    }

    /**
     * <p>
     * Failure test for {@link CopySendSignalMessageAction#CopySendSignalMessageAction(Stimulus, Clipboard)}
     * constructor.
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
    public void test_failure_CopySendSignalMessageAction2() throws Exception {
        try {
            new CopySendSignalMessageAction(null, new Clipboard("test"));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CopySendSignalMessageAction#CopySendSignalMessageAction(Stimulus, Clipboard)}
     * constructor.
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
    public void test_failure_CopySendSignalMessageAction3() throws Exception {
        try {
            new CopySendSignalMessageAction(TestHelper.getSendSignalMessage(), null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CopySendSignalMessageAction#CopySendSignalMessageAction(Stimulus, Clipboard)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *      Input
     *           Stimulus stimulus : Valid Value
     *           Clipboard clipboard : Valid Value
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
    public void test_failure_CopySendSignalMessageAction4() throws Exception {
        try {
            new CopySendSignalMessageAction(TestHelper.getCreateMessage(), new Clipboard("test"));
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }
}
