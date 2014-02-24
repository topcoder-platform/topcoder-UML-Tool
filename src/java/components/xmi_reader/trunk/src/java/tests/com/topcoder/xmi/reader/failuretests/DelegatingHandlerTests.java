/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.reader.failuretests;

import junit.framework.TestCase;
import com.topcoder.xmi.reader.XMIReader;
import org.xml.sax.Attributes;

/**
 * Tests the inner DelegatingHandler class
 */
public class DelegatingHandlerTests extends TestCase
{
    /**
     * Test object
     */
    private XMIReader.DelegatingHandler handler;

    /**
     * String used as a URI for method tests
     */
    private final String someUri = "/hello.txt";

    /**
     * Test char array.
     * This array is of known length and is used to test the
     * boundary validations of the code.
     */
    private char[] chArray = new char[]{'A', 'c'};

    /**
     * The length of the test char array.
     */
    private final int arrayLength = chArray.length;

    /**
     * Initializes objects used during the test
     * @throws Exception
     */
    protected void setUp() throws Exception
    {
        handler = new MockXMIReader().factoryDelegatingHandler();
    }

    /**
     * tests startElement(String, String, String, Attributes)
     *
     * Attempts to pass both localName and qName as null
     */
    public void testStartElementWithNull() throws Exception
    {
        Attributes attrs = new MockAttributes();
        try
        {
            handler.startElement(someUri, null, null, attrs);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests startElement(String, String, String, Attributes)
     *
     * Attempts to pass both localName and qName as empty strings
     */
    public void testStartElementWithEmpty() throws Exception
    {
        Attributes attrs = new MockAttributes();
        try
        {
            handler.startElement(someUri, "", "", attrs);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests endElement(String, String, String)
     *
     * Attempts to pass both localName and qName as null
     */
    public void testEndElementWithNull() throws Exception
    {
        try
        {
            handler.endElement(someUri, null, null);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests endElement(String, String, String)
     *
     * Attempts to pass both localName and qName as empty strings
     */
    public void testEndElementWithEmpty() throws Exception
    {
        try
        {
            handler.endElement(someUri, "", "");
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests ignorableWhitespace(char[], int, int)
     *
     * Attempts to pass a null char array
     */
    public void testIgnorableWhitespaceWithNull() throws Exception
    {
        try
        {
            handler.ignorableWhitespace(null, 0, 1);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests ignorableWhitespace(char[], int, int)
     *
     * Attempts to pass a negative start index
     */
    public void testIgnorableWhitespaceWithNegativeStart() throws Exception
    {
        try
        {
            handler.ignorableWhitespace(chArray, -1, 1);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests ignorableWhitespace(char[], int, int)
     *
     * Attempts to pass a negative length
     */
    public void testIgnorableWhitespaceWithNegativeLength() throws Exception
    {
        try
        {
            handler.ignorableWhitespace(chArray, 0, -1);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests ignorableWhitespace(char[], int, int)
     *
     * Attempts to pass an out of bounds start index
     */
    public void testIgnorableWhitespaceWithOutofBoundsStart() throws Exception
    {
        try
        {
            handler.ignorableWhitespace(chArray, arrayLength, 1);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests ignorableWhitespace(char[], int, int)
     *
     * Attempts to pass a length that gets out of bounds
     */
    public void testIgnorableWhitespaceWithOutofBoundsLength() throws Exception
    {
        try
        {
            handler.ignorableWhitespace(chArray, 0, arrayLength + 1);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests ignorableWhitespace(char[], int, int)
     *
     * Attempts to pass a length that gets out of bounds
     */
    public void testIgnorableWhitespaceWithOutofBoundsLength_2() throws Exception
    {
        try
        {
            handler.ignorableWhitespace(chArray, arrayLength - 1, 2);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests processingInstruction(String, String)
     *
     * Attempts to pass a null target
     * @throws Exception
     */
    public void testProcessingInstruction() throws Exception
    {
        try
        {
            handler.processingInstruction(null, someUri);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests characters(char[], int, int)
     *
     * Attempts to pass a null char array
     */
    public void testCharactersWithNull() throws Exception
    {
        try
        {
            handler.characters(null, 0, 1);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests characters(char[], int, int)
     *
     * Attempts to pass a negative start index
     */
    public void testCharactersWithNegativeStart() throws Exception
    {
        try
        {
            handler.characters(chArray, -1, 1);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests characters(char[], int, int)
     *
     * Attempts to pass a negative length
     */
    public void testCharactersWithNegativeLength() throws Exception
    {
        try
        {
            handler.characters(chArray, 0, -1);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests characters(char[], int, int)
     *
     * Attempts to pass an out of bounds start index
     */
    public void testCharactersWithOutofBoundsStart() throws Exception
    {
        try
        {
            handler.characters(chArray, arrayLength, 1);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }

    /**
     * tests characters(char[], int, int)
     *
     * Attempts to pass a length that gets out of bounds
     */
    public void testCharactersWithOutofBoundsLength() throws Exception
    {
        try
        {
            handler.characters(chArray, 0, arrayLength + 1);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }
    /**
     * tests characters(char[], int, int)
     *
     * Attempts to pass a length that gets out of bounds
     */
    public void testCharactersWithOutofBoundsLength_2() throws Exception
    {
        try
        {
            handler.characters(chArray, arrayLength - 1, 2);
            fail("IllegalArgumentException expected");
        }
        catch(IllegalArgumentException iae)
        {
        }
    }
}
