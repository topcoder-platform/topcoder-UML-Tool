/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for DocumentTreeConfigurationException.
 * </p>
 *
 * <p>
 * This class is pretty simple. The test cases simply verifies the exception can be
 * instantiated with the error message and cause properly propagated, and that it
 * comes with correct inheritance.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class DocumentTreeConfigurationExceptionTests extends TestCase {
    /**
     * <p>
     * The error message used for testing.
     * </p>
     */
    private static final String ERROR_MESSAGE = "test error message";

    /**
     * <p>
     * An exception instance used to create the DocumentTreeConfigurationException.
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
        return new TestSuite(DocumentTreeConfigurationExceptionTests.class);
    }

    /**
     * <p>
     * Creates DocumentTreeConfigurationException() test.
     * </p>
     *
     * <p>
     * Verifies the newly created DocumentTreeConfigurationException instance should not be null.
     * </p>
     */
    public void testDocumentTreeConfigurationException1() {
        DocumentTreeConfigurationException exception = new DocumentTreeConfigurationException();
        assertNotNull("Unable to instantiate DocumentTreeConfigurationException.", exception);
    }

    /**
     * <p>
     * Creates DocumentTreeConfigurationException(String) test.
     * </p>
     *
     * <p>
     * Verifies the error message is properly propagated.
     * </p>
     */
    public void testDocumentTreeConfigurationException2() {
        DocumentTreeConfigurationException exception = new DocumentTreeConfigurationException(ERROR_MESSAGE);
        assertNotNull("Unable to instantiate DocumentTreeConfigurationException.", exception);
        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE, exception.getMessage());
    }

    /**
     * <p>
     * Creates DocumentTreeConfigurationException(String, Throwable) test.
     * </p>
     *
     * <p>
     * Verifies the error message and the cause are properly propagated.
     * </p>
     */
    public void testDocumentTreeConfigurationException3() {
        DocumentTreeConfigurationException exception = new DocumentTreeConfigurationException(ERROR_MESSAGE,
            CAUSE_EXCEPTION);

        assertNotNull("Unable to instantiate DocumentTreeConfigurationException.", exception);
        assertTrue("The error message should match", exception.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("Cause is not properly propagated to super class.", CAUSE_EXCEPTION, exception.getCause());
    }

    /**
     * <p>
     * Inheritance test for DocumentTreeConfigurationException().
     * </p>
     *
     * <p>
     * Verifies DocumentTreeConfigurationException subclasses Exception.
     * </p>
     */
    public void testDocumentTreeConfigurationExceptionInheritance1() {
        DocumentTreeConfigurationException exception = new DocumentTreeConfigurationException();
        assertTrue("DocumentTreeConfigurationException does not subclass Exception.", exception instanceof Exception);
    }

    /**
     * <p>
     * Inheritance test for DocumentTreeConfigurationException(String).
     * </p>
     *
     * <p>
     * Verifies DocumentTreeConfigurationException subclasses Exception.
     * </p>
     */
    public void testDocumentTreeConfigurationExceptionInheritance2() {
        DocumentTreeConfigurationException exception = new DocumentTreeConfigurationException(ERROR_MESSAGE);
        assertTrue("DocumentTreeConfigurationException does not subclass Exception.", exception instanceof Exception);
    }

    /**
     * <p>
     * Inheritance test for DocumentTreeConfigurationException(String, Throwable).
     * </p>
     *
     * <p>
     * Verifies DocumentTreeConfigurationException subclasses Exception.
     * </p>
     */
    public void testDocumentTreeConfigurationExceptionInheritance3() {
        DocumentTreeConfigurationException exception = new DocumentTreeConfigurationException(ERROR_MESSAGE,
            CAUSE_EXCEPTION);
        assertTrue("DocumentTreeConfigurationException does not subclass Exception.", exception instanceof Exception);
    }
}