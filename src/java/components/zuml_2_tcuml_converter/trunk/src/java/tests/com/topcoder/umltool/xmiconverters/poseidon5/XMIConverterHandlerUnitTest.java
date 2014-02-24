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

import java.lang.reflect.Field;


/**
 * <p>
 * Unit tests for <code>XMIConverterHandler</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMIConverterHandlerUnitTest extends TestCase {
    /**
     * <p>XMIHandler instance for test.</p>
     */
    private MockHandler handler;

    /**
     * <p>XMIReader instance for test.</p>
     */
    private XMIReader reader;

    /**
     * <p>XMIConverterHandler instance for test.</p>
     */
    private XMIConverterHandler converterHandler;

    /**
     * <p>Set up the environment.</p>
     * @throws XMIReaderConfigException if any error occurs while creating the XMIReader
     */
    protected void setUp() throws XMIReaderConfigException {
        handler = new MockHandler();
        reader = new XMIReader();

        converterHandler = new XMIConverterHandler(handler, reader);
    }

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(XMIConverterHandlerUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>XMIConverterHandler(XMIHandler, XMIReader)</code>.
     * </p>
     * @throws XMIReaderConfigException if any error occurs while creating XMIReader
     */
    public void testCtor() throws XMIReaderConfigException {
        converterHandler = new XMIConverterHandler(handler, reader);
        assertNotNull("Unable to create XMIConverterHandler instance.",
            converterHandler);
    }

    /**
     * <p>
     * Failure test for constructor <code>XMIConverterHandler(XMIHandler, XMIReader)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the handler is null, IllegalArgumentException is expected.
     * </p>
     * @throws XMIReaderConfigException if any error occurs while creating XMIReader
     */
    public void testCtor_Failure1() throws XMIReaderConfigException {
        try {
            new XMIConverterHandler(null, new XMIReader());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>XMIConverterHandler(XMIHandler, XMIReader)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the reader is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_Failure2() {
        try {
            new XMIConverterHandler(new MockHandler(), null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>addConverter(XMIConverter)</code>.
     * </p>
     */
    public void testAddConverter_Accuracy() {
        //It should process successfully
        MockConverter converter = new MockConverter();
        converterHandler.addConverter(converter);

        try {
            Field chainField = converterHandler.getClass()
                                               .getDeclaredField("rootChain");
            chainField.setAccessible(true);

            DefaultXMIConverterChain chain = (DefaultXMIConverterChain) chainField.get(converterHandler);
            assertEquals("The converter should be in the chain.", converter,
                chain.getConverter());
        } catch (SecurityException e) {
            fail("Fail to check the addConverter's function.");
        } catch (NoSuchFieldException e) {
            fail("Fail to check the addConverter's function.");
        } catch (IllegalArgumentException e) {
            fail("Fail to check the addConverter's function.");
        } catch (IllegalAccessException e) {
            fail("Fail to check the addConverter's function.");
        }
    }

    /**
     * <p>
     * Failure test for <code>addConverter(XMIConverter)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the converter to add is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddConverter_Failure() {
        try {
            converterHandler.addConverter(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>setXMIReader(XMIReader)</code>.
     * </p>
     *
     * @throws XMIReaderConfigException if any error occurs while creating the XMIReader
     */
    public void testSetXMIReader_Accuracy() throws XMIReaderConfigException {
        //It should process successfully
        converterHandler.setXMIReader(new XMIReader());
    }

    /**
     * <p>
     * Failure test for <code>setXMIReader(XMIReader)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the reader is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetXMIReader_Failure() {
        try {
            converterHandler.setXMIReader(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>getLastRefObject()</code>.
     * </p>
     */
    public void testGetLastRefObject() {
        //It should process successfully
        Object obj = converterHandler.getLastRefObject();

        assertNull("There is no any last ref object now.", obj);
    }

    /**
     * <p>
     * Accuracy test for <code>getLastProperty()</code>.
     * </p>
     */
    public void testGetLastProperty() {
        //It should process successufully
        assertNull("The last property is null.",
            converterHandler.getLastProperty());
    }

    /**
     * <p>
     * Accuracy test for <code>characters(char[], int, int)</code>.
     * When there is not additional converter, the characters method is delegated
     * to innerHandler.
     * </p>
     */
    public void testCharacters() {
        try {
            converterHandler.characters(new char[0], 0, 0);

            //There is no additional converter in the chain, so the innerHandler is called directly
            assertEquals("The innerHanlder's characters should be called.",
                "characters", handler.getLastOperation());
        } catch (SAXException e) {
            fail("It should process successfully.");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>ignorableWhitespace()</code>.
     * </p>
     */
    public void testIgnorableWhitespace() {
        try {
            converterHandler.ignorableWhitespace(new char[0], 0, 0);
            assertEquals("The innerHanlder's ignorableWhitespace should be called.",
                "ignorableWhitespace", handler.getLastOperation());
        } catch (SAXException e) {
            fail("It should process successfully.");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>processingInstruction(String, String)</code>.
     * </p>
     */
    public void testProcessingInstruction() {
        try {
            converterHandler.processingInstruction("", "");
            assertEquals("The innerHanlder's processingInstruction should be called.",
                "processingInstruction", handler.getLastOperation());
        } catch (SAXException e) {
            fail("It should process successfully.");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>setDocumentLocator(Locator)</code>.
     * </p>
     */
    public void testSetDocumentLocator() {
        converterHandler.setDocumentLocator(null);
        assertEquals("The innerHanlder's setDocumentLocator should be called.",
            "setDocumentLocator", handler.getLastOperation());
    }

    /**
     * <p>
     * Accuracy test for <code>startDocument()</code>.
     * </p>
     */
    public void testStartDocument() {
        try {
            converterHandler.startDocument();

            //There is no additional converter in the chain, so the innerHandler is called directly
            assertEquals("The innerHanlder's startDocument should be called.",
                "startDocument", handler.getLastOperation());
        } catch (SAXException e) {
            fail("It should process successfully.");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>startElement(String, String, String, Attributes)</code>.
     * </p>
     */
    public void testStartElement() {
        try {
            converterHandler.startElement(null, null, null, null);

            //There is no additional converter in the chain, so the innerHandler is called directly
            assertEquals("The innerHanlder's startElement should be called.",
                "startElement", handler.getLastOperation());
        } catch (SAXException e) {
            fail("It should process successfully.");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String)</code>.
     * </p>
     */
    public void testendElement() {
        try {
            converterHandler.endElement(null, null, null);

            //There is no additional converter in the chain, so the innerHandler is called directly
            assertEquals("The innerHanlder's endElement should be called.",
                "endElement", handler.getLastOperation());
        } catch (SAXException e) {
            fail("It should process successfully.");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endDocument()</code>.
     * </p>
     */
    public void testendDocument() {
        try {
            converterHandler.endDocument();

            //There is no additional converter in the chain, so the innerHandler is called directly
            assertEquals("The innerHanlder's endDocument should be called.",
                "endDocument", handler.getLastOperation());
        } catch (SAXException e) {
            fail("It should process successfully.");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>startPrefixMapping(String, String)</code>.
     * </p>
     */
    public void testStartPrefixMapping() {
        try {
            converterHandler.startPrefixMapping("", "");
            assertEquals("The innerHanlder's startPrefixMapping should be called.",
                "startPrefixMapping", handler.getLastOperation());
        } catch (SAXException e) {
            fail("It should process successfully.");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endPrefixMapping(String)</code>.
     * </p>
     */
    public void testEndPrefixMapping() {
        try {
            converterHandler.endPrefixMapping("");
            assertEquals("The innerHanlder's endPrefixMapping should be called.",
                "endPrefixMapping", handler.getLastOperation());
        } catch (SAXException e) {
            fail("It should process successfully.");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>skippedEntity(String)</code>.
     * </p>
     */
    public void testSkippedEntity() {
        try {
            converterHandler.skippedEntity("");
            assertEquals("The innerHanlder's skippedEntity should be called.",
                "skippedEntity", handler.getLastOperation());
        } catch (SAXException e) {
            fail("It should process successfully.");
        }
    }
}
