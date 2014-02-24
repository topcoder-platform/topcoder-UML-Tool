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
 * Unit tests for <code>DefaultXMIConverterChain</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultXMIConverterChainUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DefaultXMIConverterChainUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>DefaultXMIConverterChain()</code>.
     * </p>
     */
    public void testCtor() {
        DefaultXMIConverterChain chain = new DefaultXMIConverterChain();
        assertNotNull("Unable to create DefaultXMIConverterChain instance.",
            chain);

        assertNull("The chain's next should be null.", chain.getNext());
        assertNull("The chain's converter should be null.", chain.getConverter());
    }

    /**
     * <p>
     * Accuracy test for constructor <code>DefaultXMIConverterChain(XMIConverterChain, XMIConverter)</code>.
     * </p>
     */
    public void testCtor2() {
        DefaultXMIConverterChain next = new DefaultXMIConverterChain();
        MockConverter converter = new MockConverter();

        DefaultXMIConverterChain chain = new DefaultXMIConverterChain(next,
                converter);
        assertNotNull("Unable to create DefaultXMIConverterChain instance.",
            chain);

        assertEquals("The chain's next should match.", next, chain.getNext());
        assertEquals("The chain's converter should match.", converter,
            chain.getConverter());
    }

    /**
     * <p>
     * Failure test for constructor <code>DefaultXMIConverterChain(XMIConverterChain, XMIConverter)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If next is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2_Failure1() {
        try {
            DefaultXMIConverterChain next = null;
            MockConverter converter = new MockConverter();

            new DefaultXMIConverterChain(next, converter);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>DefaultXMIConverterChain(XMIConverterChain, XMIConverter)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If converter is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2_Failure2() {
        try {
            DefaultXMIConverterChain next = new DefaultXMIConverterChain();
            XMIConverter converter = null;

            new DefaultXMIConverterChain(next, converter);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>startDocument(XMIReader, XMIHandler)</code>.
     * We use MockConverter and MockHandler here to capture the chain's call graph.
     * </p>
     *
     * @throws XMIReaderConfigException if any error occurs while creating the XMIReader
     */
    public void testStartDocument() throws XMIReaderConfigException {
        try {
            MockHandler handler = new MockHandler();
            DefaultXMIConverterChain next = new DefaultXMIConverterChain();

            //next is the end of the chain, so the handler should be called.
            next.startDocument(new XMIReader(), handler);
            assertEquals("The handler's startDocument should be called.",
                "startDocument", handler.getLastOperation());

            MockConverter converter = new MockConverter();
            DefaultXMIConverterChain chain = new DefaultXMIConverterChain(next,
                    converter);

            //The chain is not the end, so converter should be called.
            chain.startDocument(new XMIReader(), handler);
            assertEquals("The converter's startDocument should be called.",
                "startDocument", converter.getLastOperation());
        } catch (SAXException e) {
            fail("Error happens while calling startDocument()");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>startElement(String, String, String, Attributes, XMIReader, XMIHandler)</code>.
     * We use MockConverter and MockHandler here to capture the chain's call graph.
     * </p>
     * @throws XMIReaderConfigException if any error occurs while creating the XMIReader
     */
    public void testStartElement() throws XMIReaderConfigException {
        try {
            MockHandler handler = new MockHandler();
            DefaultXMIConverterChain next = new DefaultXMIConverterChain();

            //next is the end of the chain, so the handler should be called.
            next.startElement(null, null, null, null, new XMIReader(), handler);
            assertEquals("The handler's startElement should be called.",
                "startElement", handler.getLastOperation());

            MockConverter converter = new MockConverter();
            DefaultXMIConverterChain chain = new DefaultXMIConverterChain(next,
                    converter);

            //The chain is not the end, so converter should be called.
            chain.startElement(null, null, null, null, new XMIReader(), handler);
            assertEquals("The converter's startElement should be called.",
                "startElement", converter.getLastOperation());
        } catch (SAXException e) {
            fail("Error happens while calling startElement()");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String, XMIReader, XMIHandler)</code>.
     * We use MockConverter and MockHandler here to capture the chain's call graph.
     * </p>
     * @throws XMIReaderConfigException if any error occurs while creating the XMIReader
     */
    public void testEndElement() throws XMIReaderConfigException {
        try {
            MockHandler handler = new MockHandler();
            DefaultXMIConverterChain next = new DefaultXMIConverterChain();

            //next is the end of the chain, so the handler should be called.
            next.endElement(null, null, null, new XMIReader(), handler);
            assertEquals("The handler's endElement should be called.",
                "endElement", handler.getLastOperation());

            MockConverter converter = new MockConverter();
            DefaultXMIConverterChain chain = new DefaultXMIConverterChain(next,
                    converter);

            //The chain is not the end, so converter should be called.
            chain.endElement(null, null, null, new XMIReader(), handler);
            assertEquals("The converter's endElement should be called.",
                "endElement", converter.getLastOperation());
        } catch (SAXException e) {
            fail("Error happens while calling endElement()");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endDocument(XMIReader, XMIHandler)</code>.
     * We use MockConverter and MockHandler here to capture the chain's call graph.
     * </p>
     * @throws XMIReaderConfigException if any error occurs while creating the XMIReader
     */
    public void testEndDocument() throws XMIReaderConfigException {
        try {
            MockHandler handler = new MockHandler();
            DefaultXMIConverterChain next = new DefaultXMIConverterChain();

            //next is the end of the chain, so the handler should be called.
            next.endDocument(new XMIReader(), handler);
            assertEquals("The handler's endDocument should be called.",
                "endDocument", handler.getLastOperation());

            MockConverter converter = new MockConverter();
            DefaultXMIConverterChain chain = new DefaultXMIConverterChain(next,
                    converter);

            //The chain is not the end, so converter should be called.
            chain.endDocument(new XMIReader(), handler);
            assertEquals("The converter's endDocument should be called.",
                "endDocument", converter.getLastOperation());
        } catch (SAXException e) {
            fail("Error happens while calling endDocument()");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>characters(char[], int, int, XMIReader, XMIHandler)</code>.
     * We use MockConverter and MockHandler here to capture the chain's call graph.
     * </p>
     * @throws XMIReaderConfigException if any error occurs while creating the XMIReader
     */
    public void testCharacters() throws XMIReaderConfigException {
        try {
            MockHandler handler = new MockHandler();
            DefaultXMIConverterChain next = new DefaultXMIConverterChain();

            //next is the end of the chain, so the handler should be called.
            next.characters(new char[0], 0, 0, new XMIReader(), handler);
            assertEquals("The handler's characters should be called.",
                "characters", handler.getLastOperation());

            MockConverter converter = new MockConverter();
            DefaultXMIConverterChain chain = new DefaultXMIConverterChain(next,
                    converter);

            //The chain is not the end, so converter should be called.
            chain.characters(new char[0], 0, 0, new XMIReader(), handler);
            assertEquals("The converter's characters should be called.",
                "characters", converter.getLastOperation());
        } catch (SAXException e) {
            fail("Error happens while calling characters()");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>getNext()</code>.
     * </p>
     */
    public void testGetNext() {
        DefaultXMIConverterChain next = new DefaultXMIConverterChain();
        MockConverter converter = new MockConverter();

        DefaultXMIConverterChain chain = new DefaultXMIConverterChain(next,
                converter);

        assertEquals("The chain's next should match.", next, chain.getNext());
    }

    /**
     * <p>
     * Accuracy test for <code>getConverter()</code>.
     * </p>
     */
    public void testGetConverter() {
        DefaultXMIConverterChain next = new DefaultXMIConverterChain();
        MockConverter converter = new MockConverter();

        DefaultXMIConverterChain chain = new DefaultXMIConverterChain(next,
                converter);
        assertEquals("The chain's converter should match.", converter,
            chain.getConverter());
    }
}
