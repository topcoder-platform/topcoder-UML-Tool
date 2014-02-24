/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for UnknownLanguageException.
 * </p>
 *
 * <p>
 * This class is pretty simple. The test cases simply verifies the exception can be
 * instantiated with the error message, and that it comes with correct inheritance.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnknownLanguageExceptionTests extends TestCase {
    /**
     * <p>
     * The error message used for testing.
     * </p>
     */
    private static final String ERROR_MESSAGE = "test error message";

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(UnknownLanguageExceptionTests.class);
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
    public void testUnknownLanguageException() {
        UnknownLanguageException exception = new UnknownLanguageException(ERROR_MESSAGE);
        assertNotNull("Unable to instantiate UnknownLanguageException.", exception);
        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE, exception.getMessage());
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies UnknownLanguageException subclasses Exception.
     * </p>
     */
    public void testUnknownLanguageExceptionInheritance() {
        UnknownLanguageException exception = new UnknownLanguageException(ERROR_MESSAGE);
        assertTrue("UnknownLanguageException does not subclass Exception.", exception instanceof Exception);
    }
}