/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.accuracytests;

import com.topcoder.xmi.writer.ElementAlreadyExistsException;

import junit.framework.TestCase;
/**
 * <p>
 * Accuracy Test for <code>ElementAlreadyExistsException</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class ElementAlreadyExistsExceptionAccuracyTest extends TestCase {
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
    private ElementAlreadyExistsException exception = null;

    /**
     * <p>
     * Set up the enviroment.
     * </p>
     */
    protected void setUp() {
        exception = new ElementAlreadyExistsException(message, object);
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
     * <code>ElementAlreadyExistsException(String message, Object element)</code>.
     * </p>
     */
    public void testElementAlreadyExistsExceptionAccuracy() {
        assertNotNull("the ElementAlreadyExistsException instance creation failed.", exception);
        assertEquals("the ElementAlreadyExistsException instance creation failed.", message, exception.getMessage());
    }

    /**
     * <p>
     * Failure Test for
     * <code>ElementAlreadyExistsException(String message, Object element)</code>.
     * </p>
     * <p>
     * The element is null, but no IllegalArgumentException is expected.
     * </p>
     */
    public void testElementAlreadyExistsExceptionFailure() {
        try {
            new ElementAlreadyExistsException(message, null);
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
