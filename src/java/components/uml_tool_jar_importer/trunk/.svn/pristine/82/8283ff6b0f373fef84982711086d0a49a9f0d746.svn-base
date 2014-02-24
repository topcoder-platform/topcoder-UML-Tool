/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.importer.jarimporter.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.importer.jarimporter.JarImporterException;
import com.topcoder.util.errorhandling.ExceptionData;

/**
 * Set of tests for testing JarImporterException class.
 * @author vilain
 * @version 1.0
 */
public class JarImporterExceptionAccuracyTest extends TestCase {

    /**
     * Exception message for testing.
     */
    private String message = "message";

    /**
     * Exception for testing.
     */
    private Exception e = new Exception();

    /**
     * Instance of ExceptionData for testing.
     */
    private ExceptionData exceptionData = new ExceptionData();

    /**
     * Constructor under test for JarImporterException(String). Accuracy testing
     * of correctly assigned exception message and data.
     */
    public final void testJarImporterExceptionString() {
        JarImporterException exception = new JarImporterException(message);
        // testing for equal messages
        assertEquals("messages must be equal", message, exception.getMessage());
    }

    /**
     * Constructor under test for JarImporterException(String, Throwable).
     * Accuracy testing of correctly assigned exception message and cause.
     */
    public final void testJarImporterExceptionStringThrowable() {
        JarImporterException exception = new JarImporterException(message, e);
        // testing for cause and message
        assertTrue("message must be included", exception.getMessage().indexOf(message) != -1);
        assertEquals("causes must be equal", e, exception.getCause());
    }

    /**
     * Constructor under test for JarImporterException(String, ExceptionData).
     * Accuracy testing of correctly assigned exception message and data.
     */
    public final void testJarImporterExceptionStringExceptionData() {
        JarImporterException exception = new JarImporterException(message, exceptionData);
        // testing for cause and message
        assertTrue("message must be included", exception.getMessage().indexOf(message) != -1);
        assertEquals("exception datas must be equal", exceptionData.getCreationDate(), exception.getCreationDate());
    }

    /**
     * Constructor under test for JarImporterException(String, Throwable,
     * ExceptionData). Accuracy testing of correctly assigned exception message,
     * cause, and data.
     */
    public final void testJarImporterExceptionStringThrowableExceptionData() {
        JarImporterException exception = new JarImporterException(message, e, exceptionData);
        // testing for cause and message
        assertTrue("message must be included", exception.getMessage().indexOf(message) != -1);
        assertEquals("causes must be equal", e, exception.getCause());
        assertEquals("exception datas must be equal", exceptionData.getCreationDate(), exception.getCreationDate());
    }
}
