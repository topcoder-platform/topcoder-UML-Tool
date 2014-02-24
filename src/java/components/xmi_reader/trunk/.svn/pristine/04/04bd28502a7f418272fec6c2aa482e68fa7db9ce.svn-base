/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.failuretests;

import com.topcoder.xmi.reader.XMIReader;
import junit.framework.TestCase;

/**
 * tests XMIReader's failure mode.
 */
public class XMIReaderTests extends TestCase
{
    /**
     * Test object
     */
    private Object someObject = "object";
    /**
     * XMIReader instance for testing.
     */
    private XMIReader reader;

    /**
     * String test value
     */
    private final String someText = "sometext";

    /**
     * Sets up testing environment.
     *
     * @throws Exception
     */
    protected void setUp() throws Exception
    {
        reader = new XMIReader();
    }

    /**
     * test addHandler with null type.
     */
    public void testAddHandlerWithNullType()
    {
        try
        {
            reader.addHandler(null, new DefaultXMIHandlerImpl());
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test addHandler with empty type.
     */
    public void testAddHandlerWithEmptyType()
    {
        try
        {
            reader.addHandler("", new DefaultXMIHandlerImpl());
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test addHandler with null handler.
     */
    public void testAddHandlerWithNullHandler()
    {
        try
        {
            reader.addHandler(someText, null);
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test removeHandler with null type.
     */
    public void testRemoveHandlerWithNullType()
    {
        try
        {
            reader.removeHandler(null);
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test removeHandler with empty type.
     */
    public void testRemoveHandlerWithEmptyType()
    {
        try
        {
            reader.removeHandler("");
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test getHandler with null type.
     */
    public void testGetHandlerWithNullType()
    {
        try
        {
            reader.getHandler(null);
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test getHandler with empty type.
     */
    public void testGetHandlerWithEmptyType()
    {
        try
        {
            reader.getHandler("");
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test putElement with null type.
     */
    public void testPutElementWithNullType()
    {
        try
        {
            reader.putElement(null, someObject);
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test putElement with empty type.
     */
    public void testPutElementWithEmptyType()
    {
        try
        {
            reader.putElement("", someObject);
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test putElement with null handler.
     */
    public void testPutElementWithNullHandler()
    {
        try
        {
            reader.putElement(someText, null);
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test putElement for failure: xmiId in foundElements map.
     */
    public void testPutElementWithXMIIdInFoundElementsMaps()
    {
        reader.putElement(someText, someObject);
        try
        {
            reader.putElementProperty(someText, "test2", someObject);
            fail("IllegalStateException is expected.");
        }
        catch (IllegalStateException ise)
        {
        }
    }

    /**
     * test removeElement with null type.
     */
    public void testRemoveElementWithNullType()
    {
        try
        {
            reader.removeElement(null);
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test removeElement with empty type.
     */
    public void testRemoveElementWithEmptyType()
    {
        try
        {
            reader.removeElement("");
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test getElement with null type.
     */
    public void testGetElementWithNullType()
    {
        try
        {
            reader.getElement(null);
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test getElement with empty type.
     */
    public void testGetElementWithEmptyType()
    {
        try
        {
            reader.getElement("");
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test putElementProperty with null xmiId.
     */
    public void testPutElementPropertyWithNullXmiId()
    {
        try
        {
            reader.putElementProperty(null, "1", "2");
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test putElementProperty with empty xmiId.
     */
    public void testPutElementPropertyWithEmptyXmiId()
    {
        try
        {
            reader.putElementProperty("", "1", "2");
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test putElementProperty with null property.
     */
    public void testPutElementPropertyWithNullProperty()
    {
        try
        {
            reader.putElementProperty("1", null, "2");
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test putElementProperty with empty property.
     */
    public void testPutElementPropertyWithEmptyProperty()
    {
        try
        {
            reader.putElementProperty("1", "", "2");
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test putElementProperty with null refObject.
     */
    public void testPutElementPropertyWithNullRefObject()
    {
        try
        {
            reader.putElementProperty("1", "2", null);
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test getElementProperties with null xmiId.
     */
    public void testGetElementPropertyWithNullXmiId()
    {
        try
        {
            reader.getElementProperties(null);
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test getElementProperties with empty xmiId.
     */
    public void testGetElementPropertyWithEmptyXmiId()
    {
        try
        {
            reader.getElementProperties("");
            fail("IllegalArgumentException is expected.");
        }
        catch (IllegalArgumentException iae)
        {
        }
    }

    /**
     * test getActiveHandlers when parsing is not currently occurring.
     */
    public void testGetActiveHandlersFailure()
    {
        try
        {
            reader.getActiveHandlers();
            fail("IllegalStateException is expected.");
        }
        catch (IllegalStateException ise)
        {
        }
    }
}
