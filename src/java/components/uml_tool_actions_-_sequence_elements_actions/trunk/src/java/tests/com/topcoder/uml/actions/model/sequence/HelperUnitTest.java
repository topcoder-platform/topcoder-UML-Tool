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
 * This Junit Test suite contains the accuracy and failure test cases for {@link Helper} class. The accuracy
 * test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The failure
 * test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class HelperUnitTest extends TestCase {

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(HelperUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link Helper#checkObjectNotNull(Object, String)} method.
     * </p>
     * <p>
     * Checks whether no exception is thrown for a valid object.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkObjectNotNull() throws Exception {
        Helper.checkObjectNotNull("String", "test");
    }

    /**
     * <p>
     * Failure test for {@link Helper#checkObjectNotNull(Object, String)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        Object obj : null value
     *        String name : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkObjectNotNull() throws Exception {
        try {
            Helper.checkObjectNotNull(null, "test");
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "test should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link Helper#checkMessage(MessageUtil, Stimulus, String)} method.
     * </p>
     * <p>
     * Checks whether no exception is thrown if asynchronous message and corresponding identifier is given.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkMessage() throws Exception {
        Helper.checkMessage(new MessageUtil(), TestHelper.getAsynchronousMessage(), Helper.ASYNCHRONOUS_MESSAGE);
    }

    /**
     * <p>
     * Accuracy test for {@link Helper#checkMessage(MessageUtil, Stimulus, String)} method.
     * </p>
     * <p>
     * Checks whether no exception is thrown if create message and corresponding identifier is given.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkMessage1() throws Exception {
        Helper.checkMessage(new MessageUtil(), TestHelper.getCreateMessage(), Helper.CREATE_MESSAGE);
    }

    /**
     * <p>
     * Accuracy test for {@link Helper#checkMessage(MessageUtil, Stimulus, String)} method.
     * </p>
     * <p>
     * Checks whether no exception is thrown if return message and corresponding identifier is given.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkMessage2() throws Exception {
        Helper.checkMessage(new MessageUtil(), TestHelper.getReturnMessage(), Helper.RETURN_MESSAGE);
    }

    /**
     * <p>
     * Accuracy test for {@link Helper#checkMessage(MessageUtil, Stimulus, String)} method.
     * </p>
     * <p>
     * Checks whether no exception is thrown if send signal message and corresponding identifier is given.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkMessage3() throws Exception {
        Helper.checkMessage(new MessageUtil(), TestHelper.getSendSignalMessage(), Helper.SEND_SIGNAL_MESSAGE);
    }

    /**
     * <p>
     * Accuracy test for {@link Helper#checkMessage(MessageUtil, Stimulus, String)} method.
     * </p>
     * <p>
     * Checks whether no exception is thrown if synchronous message and corresponding identifier is given.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkMessage4() throws Exception {
        Helper.checkMessage(new MessageUtil(), TestHelper.getSynchronousMessage(), Helper.SYNCHRONOUS_MESSAGE);
    }

    /**
     * <p>
     * Failure test for {@link Helper#checkMessage(MessageUtil, Stimulus, String)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        MessageUtil messageUtil : Valid Value
     *        Stimulus stimulus : Valid Value
     *        String messageType : Valid Value
     * </pre>
     *
     * <p>
     * Message not corresponding to the identifier.
     * </p>
     * <p>
     * Expected {@link SequenceConfigurationException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkMessage() throws Exception {
        try {
            Helper.checkMessage(new MessageUtil(), TestHelper.getAsynchronousMessage(), Helper.CREATE_MESSAGE);
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }
}
