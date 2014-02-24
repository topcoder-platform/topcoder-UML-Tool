/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for
 * {@link SequenceConfigurationException} class. The accuracy test cases gives all valid inputs to the
 * methods/constructors and checks for inconsistencies The failure test cases gives all invalid inputs to the
 * methods/constructors and checks for expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class SequenceConfigurationExceptionUnitTest extends TestCase {

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(SequenceConfigurationExceptionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link SequenceConfigurationException#SequenceConfigurationException(String)}
     * constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_SequenceConfigurationException() throws Exception {
        SequenceConfigurationException sequenceConfigurationException = new SequenceConfigurationException("Test");

        // check for null
        assertNotNull("sequenceConfigurationException creation failed", sequenceConfigurationException);

        // check for instance
        assertTrue("SequenceConfigurationException Instantiation Failed",
            sequenceConfigurationException instanceof SequenceConfigurationException);
        // check whether the parameters are added
        assertEquals("SequenceConfigurationException parameter initialization failed", "Test",
            sequenceConfigurationException.getMessage());
    }

    /**
     * <p>
     * Accuracy test for
     * {@link SequenceConfigurationException#SequenceConfigurationException(String, Throwable)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_SequenceConfigurationException1() throws Exception {
        Throwable throwable = new Throwable();
        SequenceConfigurationException sequenceConfigurationException = new SequenceConfigurationException("Test",
            throwable);

        // check for null
        assertNotNull("sequenceConfigurationException creation failed", sequenceConfigurationException);

        // check for instance
        assertTrue("SequenceConfigurationException Instantiation Failed",
            sequenceConfigurationException instanceof SequenceConfigurationException);
        // check whether the parameters are added
        assertEquals("SequenceConfigurationException parameter initialization failed", true,
            sequenceConfigurationException.getMessage().startsWith("Test"));
        // check whether the parameters are added
        assertEquals("SequenceConfigurationException parameter initialization failed", throwable,
            sequenceConfigurationException.getCause());
    }
}
