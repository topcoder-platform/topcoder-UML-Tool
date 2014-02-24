/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test cases for class XMIReaderParseException. All constructors are tested.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMIReaderParseExceptionUnitTests extends TestCase {
    /** The error message used for testing. */
    private static final String ERROR_MESSAGE = "test error message";

    /** An exception instance used to create the XMIReaderParseException. */
    private final Exception cause = new Exception();

    /**
     * Test constructor1 : XMIReaderParseException(String), with correct message. The message can
     * be retrieved correctly later.
     */
    public void testCtor1() {
        XMIReaderParseException xmirpe = new XMIReaderParseException(ERROR_MESSAGE);

        assertNotNull("Unable to instantiate XMIReaderParseException.", xmirpe);
        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE,
            xmirpe.getMessage());
    }

    /**
     * Test constructor1 : XMIReaderParseException(String), with null message.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullMessage() {
        try {
            new XMIReaderParseException(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor1 : XMIReaderParseException(String), with empty message.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithEmptyMessage() {
        try {
            new XMIReaderParseException("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor1 : XMIReaderParseException(String), with  trimmed empty message.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithTrimmedEmptyMessage() {
        try {
            new XMIReaderParseException("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderParseException(String, Throwable), with correct error message,
     * cause. The message and cause can be retrieved correctly later.
     */
    public void testCtor2() {
        XMIReaderParseException xmirpe = new XMIReaderParseException(ERROR_MESSAGE, cause);

        assertNotNull("Unable to instantiate XMIReaderParseException.", xmirpe);
        assertTrue("Error message is not properly propagated to super class.",
            xmirpe.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("The inner exception should match.", cause, xmirpe.getCause());
    }

    /**
     * Test constructor2: XMIReaderParseException(String, Throwable), with null message,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullMessage() {
        try {
            new XMIReaderParseException(null, cause);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderParseException(String, Throwable), with empty message,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithEmptyMessage() {
        try {
            new XMIReaderParseException("", cause);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderParseException(String, Throwable), with trimmed empty message,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithTrimmedEmptyMessage() {
        try {
            new XMIReaderParseException("  ", cause);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderParseException(String, Throwable), with null inner exception,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullCause() {
        try {
            new XMIReaderParseException(ERROR_MESSAGE, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }
}
