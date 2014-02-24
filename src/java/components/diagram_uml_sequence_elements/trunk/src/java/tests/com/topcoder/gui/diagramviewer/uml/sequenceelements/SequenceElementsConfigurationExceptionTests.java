/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for SequenceElementsConfigurationException.
 * </p>
 *
 * <p>
 * This class is pretty simple. The test cases simply verifies the exception can be instantiated
 * with the error message and cause properly propagated, and that it comes with correct inheritance.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class SequenceElementsConfigurationExceptionTests extends TestCase {
    /**
     * <p>
     * The error message used for testing.
     * </p>
     */
    private static final String ERROR_MESSAGE = "test error message";

    /**
     * <p>
     * An exception instance used to create the SequenceElementsConfigurationException.
     * </p>
     */
    private static final Exception CAUSE_EXCEPTION = new NullPointerException();

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(SequenceElementsConfigurationExceptionTests.class);
    }

    /**
     * <p>
     * Creation test.
     * </p>
     *
     * <p>
     * It verifies the newly created exception instance should not be null.
     * </p>
     */
    public void testSequenceElementsConfigurationException1() {
        SequenceElementsConfigurationException exception = new SequenceElementsConfigurationException();
        assertNotNull("Unable to instantiate SequenceElementsConfigurationException.", exception);
    }

    /**
     * <p>
     * Creation test.
     * </p>
     *
     * <p>
     * Verifies the error message is properly propagated.
     * </p>
     */
    public void testSequenceElementsConfigurationException2() {
        SequenceElementsConfigurationException exception = new SequenceElementsConfigurationException(ERROR_MESSAGE);
        assertNotNull("Unable to instantiate SequenceElementsConfigurationException.", exception);
        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE, exception.getMessage());
    }

    /**
     * <p>
     * Creation test.
     * </p>
     *
     * <p>
     * Verifies the error message and the cause are properly propagated.
     * </p>
     */
    public void testSequenceElementsConfigurationException3() {
        SequenceElementsConfigurationException exception = new SequenceElementsConfigurationException(ERROR_MESSAGE,
            CAUSE_EXCEPTION);

        assertNotNull("Unable to instantiate SequenceElementsConfigurationException.", exception);
        assertTrue("The error message should match", exception.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("Cause is not properly propagated to super class.", CAUSE_EXCEPTION, exception.getCause());
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies SequenceElementsConfigurationException subclasses Exception.
     * </p>
     */
    public void testSequenceElementsConfigurationExceptionInheritance1() {
        SequenceElementsConfigurationException exception = new SequenceElementsConfigurationException();
        assertTrue("SequenceElementsConfigurationException does not subclass Exception.",
            exception instanceof Exception);
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies SequenceElementsConfigurationException subclasses Exception.
     * </p>
     */
    public void testSequenceElementsConfigurationExceptionInheritance2() {
        SequenceElementsConfigurationException exception = new SequenceElementsConfigurationException(ERROR_MESSAGE);
        assertTrue("SequenceElementsConfigurationException does not subclass Exception.",
            exception instanceof Exception);
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies SequenceElementsConfigurationException subclasses Exception.
     * </p>
     */
    public void testSequenceElementsConfigurationExceptionInheritance3() {
        SequenceElementsConfigurationException exception = new SequenceElementsConfigurationException(ERROR_MESSAGE,
            CAUSE_EXCEPTION);
        assertTrue("SequenceElementsConfigurationException does not subclass Exception.",
            exception instanceof Exception);
    }
}