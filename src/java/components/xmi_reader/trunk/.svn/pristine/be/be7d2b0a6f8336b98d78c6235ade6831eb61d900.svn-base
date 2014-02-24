/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test cases for class XMIReaderIOException. All constructors are tested.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMIReaderIOExceptionUnitTests extends TestCase {
    /** The error message used for testing. */
    private static final String ERROR_MESSAGE = "test error message";

    /** An exception instance used to create the XMIReaderIOException. */
    private final Exception cause = new Exception();

    /**
     * Test constructor1 : XMIReaderIOException(String), with correct message. The message can be
     * retrieved correctly later.
     */
    public void testCtor1() {
        XMIReaderIOException xmirioe = new XMIReaderIOException(ERROR_MESSAGE);

        assertNotNull("Unable to instantiate XMIReaderIOException.", xmirioe);
        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE,
            xmirioe.getMessage());
    }

    /**
     * Test constructor1 : XMIReaderIOException(String), with null message.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullMessage() {
        try {
            new XMIReaderIOException(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor1 : XMIReaderIOException(String), with empty message.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithEmptyMessage() {
        try {
            new XMIReaderIOException("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor1 : XMIReaderIOException(String), with trimmed empty message.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithTrimmedEmptyMessage() {
        try {
            new XMIReaderIOException("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderIOException(String, Throwable), with correct error message,
     * cause. The message and cause can be retrieved correctly later.
     */
    public void testCtor2() {
        XMIReaderIOException xmirioe = new XMIReaderIOException(ERROR_MESSAGE, cause);

        assertNotNull("Unable to instantiate XMIReaderIOException.", xmirioe);
        assertTrue("Error message is not properly propagated to super class.",
            xmirioe.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("The inner exception should match.", cause, xmirioe.getCause());
    }

    /**
     * Test constructor2: XMIReaderIOException(String, Throwable), with null message,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullMessage() {
        try {
            new XMIReaderIOException(null, cause);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderIOException(String, Throwable), with empty message,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithEmptyMessage() {
        try {
            new XMIReaderIOException("", cause);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderIOException(String, Throwable), with trimmed empty message,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithTrimmedEmptyMessage() {
        try {
            new XMIReaderIOException("  ", cause);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderIOException(String, Throwable), with null inner exception,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullCause() {
        try {
            new XMIReaderIOException(ERROR_MESSAGE, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }
}
