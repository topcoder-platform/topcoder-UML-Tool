/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.accuracytests;

import junit.framework.TestCase;

import com.topcoder.xmi.writer.UnknownElementException;
/**
 * <p>
 * Accuracy Test for <code>UnknownElementException</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class UnknownElementExceptionAccuracyTest extends TestCase {
    /**
     * <p>
     * The error message created for the testing.
     * </p>
     */
    private String message = "error messages";

    /**
     * <p>
     * The object created for the testing.
     * </p>
     */
    private Object object = new Object();

    /**
     * <p>
     * The exception instance created for testing.
     * </p>
     */
    private UnknownElementException exception = null;

    /**
     * <p>
     * Set up the enviroment.
     * </p>
     */
    protected void setUp() {
        exception = new UnknownElementException(message, object);
    }

    /**
     * <p>
     * Clear the enviroment.
     * </p>
     */
    protected void tearDown() {
        // empty
    }

    /**
     * <p>
     * Accuracy Test for
     * <code>UnknownElementException(String message, Object element)</code>.
     * </p>
     */
    public void testElementAlreadyExistsExceptionAccuracy() {
        assertNotNull("the UnknownElementException instance creation failed.", exception);
        assertEquals("the UnknownElementException instance creation failed.", message, exception.getMessage());
    }

    /**
     * <p>
     * Failure Test for
     * <code>UnknownElementException(String message, Object element)</code>.
     * </p>
     * <p>
     * The element is null, but no IllegalArgumentException is expected.
     * </p>
     */
    public void testElementAlreadyExistsExceptionFailure() {
        try {
            new UnknownElementException(message, null);
        } catch (IllegalArgumentException e) {
            fail("The element is null, but no IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Accuracy Test for<code>getElement()</code>.
     * </p>
     */
    public void testGetElement() {
        assertEquals("getElement failed.", object, exception.getElement());
    }
}
