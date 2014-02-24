/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test cases for class XMIReaderConfigException. All constructors are tested.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMIReaderConfigExceptionUnitTests extends TestCase {
    /** The error message used for testing. */
    private static final String ERROR_MESSAGE = "test error message";

    /** An exception instance used to create the XMIReaderConfigException. */
    private final Exception cause = new Exception();

    /**
     * Test constructor1 : XMIReaderConfigException(String), with correct message. The message can
     * be retrieved correctly later.
     */
    public void testCtor1() {
        XMIReaderConfigException xmirce = new XMIReaderConfigException(ERROR_MESSAGE);

        assertNotNull("Unable to instantiate XMIReaderConfigException.", xmirce);
        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE,
            xmirce.getMessage());
    }

    /**
     * Test constructor1 : XMIReaderConfigException(String), with null message.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullMessage() {
        try {
            new XMIReaderConfigException(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor1 : XMIReaderConfigException(String), with empty message.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithEmptyMessage() {
        try {
            new XMIReaderConfigException("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor1 : XMIReaderConfigException(String), with trimmed empty message.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithTrimmedEmptyMessage() {
        try {
            new XMIReaderConfigException("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderConfigException(String, Throwable), with correct error message,
     * cause. The message and cause can be retrieved correctly later.
     */
    public void testCtor2() {
        XMIReaderConfigException xmirce = new XMIReaderConfigException(ERROR_MESSAGE, cause);

        assertNotNull("Unable to instantiate XMIReaderConfigException.", xmirce);
        assertTrue("Error message is not properly propagated to super class.",
            xmirce.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("The inner exception should match.", cause, xmirce.getCause());
    }

    /**
     * Test constructor2: XMIReaderConfigException(String, Throwable), with null message,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullMessage() {
        try {
            new XMIReaderConfigException(null, cause);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderConfigException(String, Throwable), with empty message,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithEmptyMessage() {
        try {
            new XMIReaderConfigException("", cause);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderConfigException(String, Throwable), with trimmed empty message,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithTrimmedEmptyMessage() {
        try {
            new XMIReaderConfigException("   ", cause);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test constructor2: XMIReaderConfigException(String, Throwable), with null inner exception,
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullCause() {
        try {
            new XMIReaderConfigException(ERROR_MESSAGE, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }
}
