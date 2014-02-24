/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test cases for class XMIReaderException. All constructors are tested.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMIReaderExceptionUnitTests extends TestCase {
    /** The error message used for testing. */
    private static final String ERROR_MESSAGE = "test error message";

    /** An exception instance used to create the XMIReaderException. */
    private final Exception cause = new Exception();

    /**
     * Test constructor1: XMIReaderException(String), with correct message. The message can be
     * retrieved correctly later.
     */
    public void testCtor1() {
        XMIReaderException xmire = new XMIReaderException(ERROR_MESSAGE);

        assertNotNull("Unable to instantiate XMIReaderException.", xmire);
        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE,
            xmire.getMessage());
    }

    /**
     * Test constructor1: XMIReaderException(String), with null message. IllegalArgumentException
     * is expected.
     */
    public void testCtor1WithNullMessage() {
        try {
            new XMIReaderException(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor1: XMIReaderException(String), with empty message. IllegalArgumentException
     * is expected.
     */
    public void testCtor1WithEmptyMessage() {
        try {
            new XMIReaderException("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor1: XMIReaderException(String), with trimmed empty message.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithTrimmedEmptyMessage() {
        try {
            new XMIReaderException("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderException(String, Throwable), with correct error message, cause.
     * The message and cause can be retrieved correctly later.
     */
    public void testCtor2() {
        XMIReaderException xmire = new XMIReaderException(ERROR_MESSAGE, cause);

        assertNotNull("Unable to instantiate XMIReaderException.", xmire);
        assertTrue("Error message is not properly propagated to super class.",
            xmire.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("The inner exception should match.", cause, xmire.getCause());
    }

    /**
     * Test constructor2: XMIReaderException(String, Throwable), with null message,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullMessage() {
        try {
            new XMIReaderException(null, cause);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderException(String, Throwable), with empty message,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithEmptyMessage() {
        try {
            new XMIReaderException("", cause);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderException(String, Throwable), with trimmed empty message,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithTrimmedEmptyMessage() {
        try {
            new XMIReaderException("  ", cause);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderException(String, Throwable), with null inner exception,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullCause() {
        try {
            new XMIReaderException(ERROR_MESSAGE, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }
}
