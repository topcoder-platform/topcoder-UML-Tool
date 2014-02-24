/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class InvalidDataContentException.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class InvalidDataContentExceptionTest extends TestCase {

    /**
     * The error message used for testing.
     */
    private static final String ERROR_MESSAGE = "test error message";

    /**
     * An exception instance used to create the InvalidDataContentException.
     */
    private final Exception cause = new Exception();

    /**
     * Test constructor1: InvalidDataContentException(String), with correct
     * message. The message can be retrieved correctly later.
     */
    public void testCtor1() {
        InvalidDataContentException idce = new InvalidDataContentException(ERROR_MESSAGE);

        assertNotNull("Unable to instantiate InvalidDataContentException.", idce);
        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE, idce.getMessage());
    }

    /**
     * Test constructor1: InvalidDataContentException(String), with null
     * message. Do the same as when it is right.
     */
    public void testCtor1WithNullMessage() {
        InvalidDataContentException idce = new InvalidDataContentException(null);

        assertNotNull("Unable to instantiate InvalidDataContentException.", idce);
        assertEquals("Error message is not properly propagated to super class.", null, idce.getMessage());
    }

    /**
     * Test constructor1: InvalidDataContentException(String), with empty
     * message. Do the same as when it is right.
     */
    public void testCtor1WithEmptyMessage() {
        InvalidDataContentException idce = new InvalidDataContentException("");

        assertNotNull("Unable to instantiate InvalidDataContentException.", idce);
        assertEquals("Error message is not properly propagated to super class.", "", idce.getMessage());
    }

    /**
     * Test constructor2: InvalidDataContentException(String, Throwable), with
     * correct error message, cause. The message and cause can be retrieved
     * correctly later.
     */
    public void testCtor2() {
        InvalidDataContentException idce = new InvalidDataContentException(ERROR_MESSAGE, cause);

        assertNotNull("Unable to instantiate InvalidDataContentException.", idce);
        assertTrue("Error message is not properly propagated to superclass.",
                idce.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("The inner exception should match.", cause, idce.getCause());
    }

    /**
     * Test constructor2: InvalidDataContentException(String, Throwable), with
     * null message. Do the same as when it is right.
     */
    public void testCtor2WithNullMessage() {
        InvalidDataContentException idce = new InvalidDataContentException(null, cause);

        assertNotNull("Unable to instantiate InvalidDataContentException.", idce);
        assertEquals("The inner exception should match.", cause, idce.getCause());
    }

    /**
     * Test constructor2: InvalidDataContentException(String, Throwable), with
     * empty message. Do the same as when it is right.
     */
    public void testCtor2WithEmptyMessage() {
        InvalidDataContentException idce = new InvalidDataContentException("", cause);

        assertNotNull("Unable to instantiate InvalidDataContentException.", idce);
        assertEquals("The inner exception should match.", cause, idce.getCause());
    }

    /**
     * Test constructor2: InvalidDataContentException(String, Throwable), with
     * null inner exception. Do the same as when it is right.
     */
    public void testCtor2WithNullCause() {
        InvalidDataContentException idce = new InvalidDataContentException(ERROR_MESSAGE, null);

        assertNotNull("Unable to instantiate InvalidDataContentException.", idce);
        assertTrue("Error message is not properly propagated to superclass.",
                idce.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("The inner exception should match.", null, idce.getCause());
    }
}