/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import com.topcoder.umltool.xmiconverters.poseidon5.converters.MockConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.handlers.MockHandler;

import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.XMIReaderConfigException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.xml.sax.SAXException;


/**
 * <p>
 * Unit tests for <code>DefaultXMIConverter</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultXMIConverterUnitTest extends TestCase {
    /**
     * <p>The XMIConverterChain instance for test.</p>
     */
    private XMIConverterChain chain;

    /**
     * <p>The XMIHandler instance for test.</p>
     */
    private MockHandler handler;

    /**
     * <p>The DefaultXMIConverter instance for test.</p>
     */
    private DefaultXMIConverter converter;

    /**
     * <p>Set up the environment.</p>
     */
    protected void setUp() {
        chain = new DefaultXMIConverterChain();
        handler = new MockHandler();
        converter = new MockConverter();
    }

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DefaultXMIConverterUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>DefaultXMIConverter()</code>.
     * </p>
     */
    public void testCtor() {
        //MockConverter is a mock implementation of DefaultXMIConverter,
        //It just delegate all method to its parent DefaultXMIConverter.
        converter = new MockConverter();

        assertNotNull("Unable to create MockConverter instance.", converter);
    }

    /**
     * <p>
     * Accuracy test for <code>startDocument(XMIConverterChain, XMIReader, XMIHandler)</code>.
     * </p>
     * <p>
     * MockConverter is a mock implementation of DefaultXMIConverter, it just delegate the
     * method to DefaultXMIConverter.
     * </p>
     *
     * @throws XMIReaderConfigException if any error occurs while creating XMIReader
     */
    public void testStartDocument() throws XMIReaderConfigException {
        try {
            converter.startDocument(chain, new XMIReader(), handler);

            //The chain is in the end, so handler will be called
            assertEquals("The handler's startDocument should be called.",
                "startDocument", handler.getLastOperation());
        } catch (SAXException e) {
            fail("Fail to call startDocument().");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>startElement(String, String, String, String,
     * XMIConverterChain, XMIReader, XMIHandler)</code>.
     * </p>
     * <p>
     * MockConverter is a mock implementation of DefaultXMIConverter, it just delegate the
     * method to DefaultXMIConverter.
     * </p>
     *
     * @throws XMIReaderConfigException if any error occurs while creating XMIReader
     */
    public void testStartElement() throws XMIReaderConfigException {
        try {
            converter.startElement(null, null, null, null, chain,
                new XMIReader(), handler);

            //The chain is in the end, so handler will be called
            assertEquals("The handler's startElement should be called.",
                "startElement", handler.getLastOperation());
        } catch (SAXException e) {
            fail("Fail to call startElement().");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endDocument(XMIConverterChain, XMIReader, XMIHandler)</code>.
     * </p>
     * <p>
     * MockConverter is a mock implementation of DefaultXMIConverter, it just delegate the
     * method to DefaultXMIConverter.
     * </p>
     *
     * @throws XMIReaderConfigException if any error occurs while creating XMIReader
     */
    public void testEndDocument() throws XMIReaderConfigException {
        try {
            converter.endDocument(chain, new XMIReader(), handler);

            //The chain is in the end, so handler will be called
            assertEquals("The handler's endDocument should be called.",
                "endDocument", handler.getLastOperation());
        } catch (SAXException e) {
            fail("Fail to call endDocument().");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String, String,
     * XMIConverterChain, XMIReader, XMIHandler)</code>.
     * </p>
     * <p>
     * MockConverter is a mock implementation of DefaultXMIConverter, it just delegate the
     * method to DefaultXMIConverter.
     * </p>
     *
     * @throws XMIReaderConfigException if any error occurs while creating XMIReader
     */
    public void testEndElement() throws XMIReaderConfigException {
        try {
            converter.endElement(null, null, null, chain, new XMIReader(),
                handler);

            //The chain is in the end, so handler will be called
            assertEquals("The handler's endElement should be called.",
                "endElement", handler.getLastOperation());
        } catch (SAXException e) {
            fail("Fail to call endElement().");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>characters(char[], int, int, XMIConverterChain, XMIReader, XMIHandler)</code>.
     * </p>
     * <p>
     * MockConverter is a mock implementation of DefaultXMIConverter, it just delegate the
     * method to DefaultXMIConverter.
     * </p>
     * @throws XMIReaderConfigException if any error occurs while creating the XMIReader
     */
    public void testCharacters() throws XMIReaderConfigException {
        try {
            converter.characters(new char[0], 0, 0, chain, new XMIReader(),
                handler);

            // The chain is in the end, so handler will be called
            assertEquals("The handler's characters should be called.",
                "characters", handler.getLastOperation());
        } catch (SAXException e) {
            fail("Fail to call characters().");
        }
    }
}
