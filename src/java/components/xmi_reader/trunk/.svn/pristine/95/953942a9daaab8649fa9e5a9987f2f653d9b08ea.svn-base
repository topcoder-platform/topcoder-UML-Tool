/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.reader.failuretests;

import junit.framework.TestCase;
import com.topcoder.xmi.reader.DefaultXMIHandler;
import com.topcoder.xmi.reader.XMIReader;

/**
 * Tests the failure modes of DefaultXMIHandler through
 * a test implementation (DefaultXMIHandlerImpl)
 */
public class DefaultXMIHandlerTests extends TestCase
{
    /**
     * a DefaultXMIHandlerImpl object
     * this object is initialized in setUp()
     */
    private DefaultXMIHandler handler;

    /**
     * XMIReader object used to test construction and assignment
     */
    private XMIReader theReader;

    /**
     * Sets up the objects to be used during tests
     */
    protected void setUp() throws Exception
    {
        handler = new DefaultXMIHandlerImpl();
        theReader = new XMIReader();
    }

    /**
     * Attempts to call the constructor
     * with a null argument.
     */
    public void testCtorWithNull()
    {
        try
        {
            new DefaultXMIHandlerImpl(null);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * Attempts to call setXMIReader(XMIReader)
     * with a null argument.
     */
    public void testSetXMIReaderWithNull()
    {
        try
        {
            handler.setXMIReader(null);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * Attempts to call setXMIReader(XMIReader)
     * when a reader has already been assigned.
     */
    public void testSetXMIReaderTwice()
    {
        handler.setXMIReader(theReader);
        try
        {
            handler.setXMIReader(theReader);
            fail("IllegalStateException expected");
        }
        catch(IllegalStateException ise)
        {
        }
    }

    /**
     * Attempts to call setLastProperty(String)
     * with a null argument.
     */
    public void testSetLastPropertyWithEmpty()
    {
        try
        {
            handler.setLastProperty("");
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }
}
