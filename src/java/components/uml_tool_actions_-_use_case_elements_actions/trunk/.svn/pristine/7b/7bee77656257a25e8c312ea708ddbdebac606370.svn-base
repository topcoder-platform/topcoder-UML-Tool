/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.util.errorhandling.BaseException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link InvalidDataContentException}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class InvalidDataContentExceptionTest extends TestCase {
    /** The InvalidDataContentException instance for testing. */
    private InvalidDataContentException invalidDataContentException;

    /** The String instance for testing. */
    private String message;

    /** The Throwable instance for testing. */
    private Throwable exception;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        message = "message";
        exception = new Exception();
    }

    /**
     * Test the <code>{@link InvalidDataContentException#InvalidDataContentException(String)}</code> with success
     * process.
     */
    public void testConstructor_String_Success() {
        invalidDataContentException = new InvalidDataContentException(message);
        assertNotNull(invalidDataContentException);
        assertTrue(invalidDataContentException instanceof BaseException);
        assertEquals(message, invalidDataContentException.getMessage());
        assertNull(invalidDataContentException.getCause());
    }

    /**
     * Test the <code>{@link InvalidDataContentException#InvalidDataContentException(String, Throwable)}</code> with
     * success process.
     */
    public void testConstructor_StringThrowable_Success() {
        invalidDataContentException = new InvalidDataContentException(message, exception);
        assertNotNull(invalidDataContentException);
        assertTrue(invalidDataContentException instanceof BaseException);
        assertTrue(invalidDataContentException.getMessage().indexOf(message) != -1);
        assertEquals(exception, invalidDataContentException.getCause());
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(InvalidDataContentExceptionTest.class);
    }
}
