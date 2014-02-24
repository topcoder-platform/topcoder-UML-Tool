/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * HTMLDocumentatioEditorExceptionTest.java
 */
package com.topcoder.gui.panels.documentation.plugins.html;

import com.topcoder.util.errorhandling.ExceptionData;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>Unit tests for <code>HTMLDocumentationEditorException</code> class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HTMLDocumentationEditorExceptionTest extends TestCase {
    /**
     * <p>The error message used for testing.</p>
     */
    private static final String MESSAGE = "the error message";

    /**
     * <p>The ExceptionData used for testing.</p>
     */
    private static final ExceptionData DATA = new ExceptionData();

    /**
     * <p>The inner exception for testing.</p>
     */
    private static final Throwable CAUSE = new Exception();

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(HTMLDocumentationEditorExceptionTest.class);
    }

    /**
     * <p>Accuracy test for constructor <code>HTMLDocumentationEditorException(String)</code>.</p>
     *  <p>Verify that the exception can be created successfully.</p>
     */
    public void testCtorStr() {
        HTMLDocumentationEditorException exception = new HTMLDocumentationEditorException(MESSAGE);
        assertNotNull("Unable to create HTMLDocumentationEditorException instance.", exception);
        assertTrue("Should be instance of HTMLDocumentationEditorException.",
            exception instanceof HTMLDocumentationEditorException);
        assertEquals("The error message should match.", MESSAGE, exception.getMessage());
    }

    /**
     * <p>Accuracy test for constructor <code>HTMLDocumentationEditorException(String)</code>.</p>
     *  <p>Verify that the exception can be created successfully with null message.</p>
     */
    public void testCtorStr_Null() {
        HTMLDocumentationEditorException exception = new HTMLDocumentationEditorException((String) null);
        assertNotNull("Unable to create HTMLDocumentationEditorException instance.", exception);
        assertTrue("Should be instance of HTMLDocumentationEditorException.",
            exception instanceof HTMLDocumentationEditorException);
        assertNull("The error message should match.", exception.getMessage());
    }

    /**
     * <p>Accuracy test for constructor <code>HTMLDocumentationEditorException(String, ExceptionData)</code>.</p>
     *  <p>Verify that the exception can be created successfully.</p>
     */
    public void testCtorStrExp() {
        HTMLDocumentationEditorException exception = new HTMLDocumentationEditorException(MESSAGE, DATA);
        assertNotNull("Unable to create HTMLDocumentationEditorException instance.", exception);
        assertTrue("Should be instance of HTMLDocumentationEditorException.",
            exception instanceof HTMLDocumentationEditorException);
        assertEquals("The error message should match.", MESSAGE, exception.getMessage());
    }

    /**
     * <p>Accuracy test for constructor <code>HTMLDocumentationEditorException(String, ExceptionData)</code>.</p>
     *  <p>Verify that the exception can be created successfully with null message and exception data.</p>
     */
    public void testCtorStrExp_Null() {
        HTMLDocumentationEditorException exception = new HTMLDocumentationEditorException(null, (ExceptionData) null);
        assertNotNull("Unable to create HTMLDocumentationEditorException instance.", exception);
        assertTrue("Should be instance of HTMLDocumentationEditorException.",
            exception instanceof HTMLDocumentationEditorException);
        assertNull("The error message should match.", exception.getMessage());
    }

    /**
     * <p>Accuracy test for constructor <code>HTMLDocumentationEditorException(String, Throwable)</code>.</p>
     *  <p>Verify that the exception can be created successfully.</p>
     */
    public void testCtorStrThrowable() {
        HTMLDocumentationEditorException exception = new HTMLDocumentationEditorException(MESSAGE, CAUSE);
        assertNotNull("Unable to create HTMLDocumentationEditorException instance.", exception);
        assertTrue("Should be instance of HTMLDocumentationEditorException.",
            exception instanceof HTMLDocumentationEditorException);
        assertEquals("The error message should match.", MESSAGE, exception.getMessage());
        assertEquals("The inner cause should match.", CAUSE, exception.getCause());
    }

    /**
     * <p>Accuracy test for constructor <code>HTMLDocumentationEditorException(String, Throwable)</code>.</p>
     *  <p>Verify that the exception can be created successfully with null message and cause.</p>
     */
    public void testCtorStrThrowable_Null() {
        HTMLDocumentationEditorException exception = new HTMLDocumentationEditorException(null, (Throwable) null);
        assertNotNull("Unable to create HTMLDocumentationEditorException instance.", exception);
        assertTrue("Should be instance of HTMLDocumentationEditorException.",
            exception instanceof HTMLDocumentationEditorException);
        assertNull("The error message should match.", exception.getMessage());
        assertNull("The inner cause should match.", exception.getCause());
    }

    /**
     * <p>Accuracy test for constructor <code>HTMLDocumentationEditorException(String, Throwable,
     * ExceptionData)</code>.</p>
     *  <p>Verify that the exception can be created successfully.</p>
     */
    public void testCtorStrThrowableExp() {
        HTMLDocumentationEditorException exception = new HTMLDocumentationEditorException(MESSAGE, CAUSE, DATA);
        assertNotNull("Unable to create HTMLDocumentationEditorException instance.", exception);
        assertTrue("Should be instance of HTMLDocumentationEditorException.",
            exception instanceof HTMLDocumentationEditorException);
        assertEquals("The error message should match.", MESSAGE, exception.getMessage());
        assertEquals("The inner cause should match.", CAUSE, exception.getCause());
    }

    /**
     * <p>Accuracy test for constructor <code>HTMLDocumentationEditorException(String, Throwable,
     * ExceptionData)</code>.</p>
     *  <p>Verify that the exception can be created successfully with null arguments.</p>
     */
    public void testCtorStrThrowableExp_Null() {
        HTMLDocumentationEditorException exception = new HTMLDocumentationEditorException(null, null, null);
        assertNotNull("Unable to create HTMLDocumentationEditorException instance.", exception);
        assertTrue("Should be instance of HTMLDocumentationEditorException.",
            exception instanceof HTMLDocumentationEditorException);
        assertNull("The error message should match.", exception.getMessage());
        assertNull("The inner cause should match.", exception.getCause());
    }
}
