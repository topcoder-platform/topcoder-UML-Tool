/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.xmi.reader.failuretests;

import junit.framework.TestCase;
import com.topcoder.xmi.reader.XMIReaderParseException;

/**
 * Tests the XMIReaderParseException class
 * in its failure situations
 */
public class XMIReaderParseExceptionTests extends TestCase
{
    /**
     * Object used for an inner exception
     */
    private Throwable cause;

    /**
     * Default message for the exceptions
     */
    private final String message = "some message";

    /**
     * Creates the objects that will be used for testing
     */
    protected void setUp()
    {
        cause = new IllegalArgumentException();
    }

    /**
     * Test the XMIReaderParseException(String)
     *
     * Attempts to call it with a null argument
     */
    public void testCtor_WithNullString()
    {
        try
        {
            new XMIReaderParseException(null);
            fail("IllegalArgumentException is expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }
    /**
     * Test the XMIReaderParseException(String)
     *
     * Attempts to call it with an empty string
     */
    public void testCtor_WithEmptyString()
    {
        try
        {
            new XMIReaderParseException("");
            fail("IllegalArgumentException is expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * Test the XMIReaderParseException(String, Throwable)
     *
     * Attempts to call it with a null argument
     */
    public void testCtor2_WithNullString()
    {
        try
        {
            new XMIReaderParseException(null, cause);
            fail("IllegalArgumentException is expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * Test the XMIReaderParseException(String, Throwable)
     *
     * Attempts to call it with an empty string
     */
    public void testCtor2_WithEmptyString()
    {
        try
        {
            new XMIReaderParseException("", cause);
            fail("IllegalArgumentException is expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * Test the XMIReaderParseException(String, Throwable)
     *
     * Attempts to call it with a null cause
     */
    public void testCtor2_WithNullCause()
    {
        try
        {
            new XMIReaderParseException(message, null);
            fail("IllegalArgumentException is expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }
}
