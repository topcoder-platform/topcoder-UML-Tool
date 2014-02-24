/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * JarImporterExceptionTest.java
 */
package com.topcoder.uml.importer.jarimporter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.util.errorhandling.ExceptionData;
/**
 * <p>Unit tests for <code>JarImporterException</code> class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */

public class JarImporterExceptionTest extends TestCase {
    /**
     * <p>
     * The error message used for testing.
     * </p>
     */
    private static final String MESSAGE = "the error message";

    /**
     * <p>
     * The ExceptionData used for testing.
     * </p>
     */
    private static final ExceptionData DATA = new ExceptionData();

    /**
     * <p>
     * The inner exception for testing.
     * </p>
     */
    private static final Throwable CAUSE = new Exception();

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(JarImporterExceptionTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>JarImporterException(String)</code>.
     * </p>
     * <p>
     * Verify that the exception can be created successfully.
     * </p>
     */
    public void testCtorStr() {
        JarImporterException exception = new JarImporterException(MESSAGE);
        assertNotNull("Unable to create JarImporterException instance.",
                exception);
        assertTrue("Should be instance of JarImporterException.",
                exception instanceof JarImporterException);
        assertEquals("The error message should match.", MESSAGE, exception
                .getMessage());
    }

    /**
     * <p>
     * Accuracy test for constructor <code>JarImporterException(String)</code>.
     * </p>
     * <p>
     * Verify that the exception can be created successfully with null message.
     * </p>
     */
    public void testCtorStr_Null() {
        JarImporterException exception = new JarImporterException((String) null);
        assertNotNull("Unable to create JarImporterException instance.",
                exception);
        assertTrue("Should be instance of JarImporterException.",
                exception instanceof JarImporterException);
        assertNull("The error message should match.", exception.getMessage());
    }

    /**
     * <p>
     * Accuracy test for constructor
     * <code>JarImporterException(String, ExceptionData)</code>.
     * </p>
     * <p>
     * Verify that the exception can be created successfully.
     * </p>
     */
    public void testCtorStrExp() {
        JarImporterException exception = new JarImporterException(MESSAGE, DATA);
        assertNotNull("Unable to create JarImporterException instance.",
                exception);
        assertTrue("Should be instance of JarImporterException.",
                exception instanceof JarImporterException);
        assertEquals("The error message should match.", MESSAGE, exception
                .getMessage());
    }

    /**
     * <p>
     * Accuracy test for constructor
     * <code>JarImporterException(String, ExceptionData)</code>.
     * </p>
     * <p>
     * Verify that the exception can be created successfully with null message
     * and exception data.
     * </p>
     */
    public void testCtorStrExp_Null() {
        JarImporterException exception = new JarImporterException(null,
                (ExceptionData) null);
        assertNotNull("Unable to create JarImporterException instance.",
                exception);
        assertTrue("Should be instance of JarImporterException.",
                exception instanceof JarImporterException);
        assertNull("The error message should match.", exception.getMessage());
    }

    /**
     * <p>
     * Accuracy test for constructor
     * <code>JarImporterException(String, Throwable)</code>.
     * </p>
     * <p>
     * Verify that the exception can be created successfully.
     * </p>
     */
    public void testCtorStrThrowable() {
        JarImporterException exception = new JarImporterException(MESSAGE,
                CAUSE);
        assertNotNull("Unable to create JarImporterException instance.",
                exception);
        assertTrue("Should be instance of JarImporterException.",
                exception instanceof JarImporterException);
        assertEquals("The error message should match.", MESSAGE, exception
                .getMessage());
        assertEquals("The inner cause should match.", CAUSE, exception
                .getCause());
    }

    /**
     * <p>
     * Accuracy test for constructor
     * <code>JarImporterException(String, Throwable)</code>.
     * </p>
     * <p>
     * Verify that the exception can be created successfully with null message
     * and cause.
     * </p>
     */
    public void testCtorStrThrowable_Null() {
        JarImporterException exception = new JarImporterException(null,
                (Throwable) null);
        assertNotNull("Unable to create JarImporterException instance.",
                exception);
        assertTrue("Should be instance of JarImporterException.",
                exception instanceof JarImporterException);
        assertNull("The error message should match.", exception.getMessage());
        assertNull("The inner cause should match.", exception.getCause());
    }

    /**
     * <p>
     * Accuracy test for constructor
     * <code>JarImporterException(String, Throwable,
     * ExceptionData)</code>.
     * </p>
     * <p>
     * Verify that the exception can be created successfully.
     * </p>
     */
    public void testCtorStrThrowableExp() {
        JarImporterException exception = new JarImporterException(MESSAGE,
                CAUSE, DATA);
        assertNotNull("Unable to create JarImporterException instance.",
                exception);
        assertTrue("Should be instance of JarImporterException.",
                exception instanceof JarImporterException);
        assertEquals("The error message should match.", MESSAGE, exception
                .getMessage());
        assertEquals("The inner cause should match.", CAUSE, exception
                .getCause());
    }

    /**
     * <p>
     * Accuracy test for constructor
     * <code>JarImporterException(String, Throwable,
     * ExceptionData)</code>.
     * </p>
     * <p>
     * Verify that the exception can be created successfully with null
     * arguments.
     * </p>
     */
    public void testCtorStrThrowableExp_Null() {
        JarImporterException exception = new JarImporterException(null, null,
                null);
        assertNotNull("Unable to create JarImporterException instance.",
                exception);
        assertTrue("Should be instance of JarImporterException.",
                exception instanceof JarImporterException);
        assertNull("The error message should match.", exception.getMessage());
        assertNull("The inner cause should match.", exception.getCause());
    }
}
