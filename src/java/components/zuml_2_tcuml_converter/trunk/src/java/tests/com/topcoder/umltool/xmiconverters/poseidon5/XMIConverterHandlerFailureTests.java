/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import junit.framework.TestCase;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterHandler;
import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

/**
 * <p>
 * Failure test fixture for <code>XMIConverterHandler</code> class.
 * </p>
 * @author Thinfox
 * @version 1.0
 */
public class XMIConverterHandlerFailureTests extends TestCase {

    /**
     * <p>
     * XMIReader instance for helping testing.
     * </p>
     */
    private XMIReader reader;

    /**
     * <p>
     * MockXMIConverterInnerHandler instance for helping testing.
     * </p>
     */
    private MockXMIConverterInnerHandler innerHandler;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        reader = new XMIReader();
        innerHandler = new MockXMIConverterInnerHandler();
    }

    /**
     * <p>
     * Tests the ctor <code>XMIConverterHandler(XMIHandler, Reader)</code>.
     * </p>
     * <p>
     * When converter is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_NullInnerHandler() throws Exception {
        try {
            new XMIConverterHandler(null, reader);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests the ctor <code>XMIConverterHandler(XMIHandler, Reader)</code>.
     * </p>
     * <p>
     * When converter is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_NullReader() throws Exception {
        try {
            new XMIConverterHandler(innerHandler, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests the method <code>addConverter(XMIConverter)</code>.
     * </p>
     * <p>
     * When converter is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testAddConverter_NullConverter() throws Exception {
        try {
            new XMIConverterHandler(innerHandler, reader).addConverter(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests the method <code>setXMIReader(XMIReader)</code>.
     * </p>
     * <p>
     * When reader is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testSetXMIReader_NullReader() throws Exception {
        try {
            new XMIConverterHandler(innerHandler, reader).setXMIReader(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * This class is a mock XMIHandler used as XMIConverter inner handler to test
     * XMIXMIConverterHandler.
     * </p>
     * <p>
     * <strong>Thread-safe: </strong>this class is not thread-safe.
     * </p>
     * @author Thinfox
     * @version 1.0
     */
    public class MockXMIConverterInnerHandler implements XMIHandler {

        /**
         * <p>
         * Represents whether ignorableWhitespace method has been called.
         * </p>
         */
        public boolean ignorableWhitespace;

        /**
         * <p>
         * Represents whether processingInstruction method has been called.
         * </p>
         */
        public boolean processingInstruction;

        /**
         * <p>
         * Represents whether skippedEntity method has been called.
         * </p>
         */
        public boolean skippedEntity;

        /**
         * <p>
         * Represents whether endPrefixMapping method has been called.
         * </p>
         */
        public boolean endPrefixMapping;

        /**
         * <p>
         * Represents whether startPrefixMapping method has been called.
         * </p>
         */
        public boolean startPrefixMapping;

        /**
         * <p>
         * Represents whether setDocumentLocator method has been called.
         * </p>
         */
        public boolean haveSetDocumentLocator;

        /**
         * <p>
         * empty construct.
         * </p>
         */
        public MockXMIConverterInnerHandler() {
        }

        /**
         * <p>
         * Captures the given XMIReader for later usage.
         * </p>
         * @param reader the XMIHeader instance
         */
        public void setXMIReader(XMIReader reader) {
        }

        /**
         * <p>
         * mock method.
         * </p>
         * @return the last object reference that was created
         */
        public Object getLastRefObject() {
            return null;
        }

        /**
         * <p>
         * mock method.
         * </p>
         * @return the last property name that was processed
         */
        public String getLastProperty() {
            return null;
        }

        /**
         * <p>
         * mock method.
         * </p>
         * @param ch the characters from the XML document
         * @param start the start position in the array
         * @param length the number of characters to read from the array
         */
        public void ignorableWhitespace(char[] ch, int start, int length) {
        }

        /**
         * <p>
         * mock method.
         * </p>
         * @param target the processing instruction target
         * @param data the processing instruction data, or null if none was supplied. The data does
         *        not include any whitespace separating it from the target
         * @throws SAXException if any error occors in this method.
         */
        public void processingInstruction(String target, String data) throws SAXException {
        }

        /**
         * <p>
         * mock method.
         * </p>
         * @param locator an object that can return the location of any SAX document event
         */
        public void setDocumentLocator(org.xml.sax.Locator locator) {
        }

        /**
         * <p>
         * mock method.
         * </p>
         * @param prefix the Namespace prefix being declared. An empty string is used for the
         *        default element namespace, which has no prefix.
         * @param uri the Namespace URI the prefix is mapped to
         * @throws SAXException if any error occors in this method.
         */
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
        }

        /**
         * <p>
         * mock method.
         * </p>
         * @param prefix the Namespace prefix being declared. An empty string is used for the
         *        default element namespace, which has no prefix.
         * @throws SAXException if any error occors in this method.
         */
        public void endPrefixMapping(String prefix) throws SAXException {
        }

        /**
         * <p>
         * mock method.
         * </p>
         * @param name the name of the skipped entity. If it is a parameter entity, the name will
         *        begin with '%', and if it is the external DTD subset, it will be the string
         *        "[dtd]"
         * @throws SAXException if any error occors in this method.
         */
        public void skippedEntity(String name) throws SAXException {
        }

        /**
         * <p>
         * mock method.
         * </p>
         * @param ch the characters from the XML document
         * @param start the start position in the array
         * @param length the number of characters to read from the array
         * @throws SAXException if any error occors in this method.
         */
        public void characters(char[] ch, int start, int length) throws SAXException {
        }

        /**
         * <p>
         * mock method.
         * </p>
         * @throws SAXException if any error occors in this method.
         */
        public void startDocument() throws SAXException {
        }

        /**
         * <p>
         * mock method.
         * </p>
         * @param uri the Namespace URI, or the empty string if the element has no Namespace URI or
         *        if Namespace processing is not being performed
         * @param localName the local name (without prefix), or the empty string if Namespace
         *        processing is not being performed
         * @param qName the qualified name (with prefix), or the empty string if qualified names are
         *        not available
         * @param attrs the attributes attached to the element. If there are no attributes, it shall
         *        be an empty Attributes object. The value of this object after startElement returns
         *        is undefined
         * @throws SAXException if any error occors in this method.
         */
        public void startElement(String uri, String localName, String qName, Attributes attrs)
            throws SAXException {
        }

        /**
         * <p>
         * do nothing.
         * </p>
         * @param uri the Namespace URI, or the empty string if the element has no Namespace URI or
         *        if Namespace processing is not being performed
         * @param localName the local name (without prefix), or the empty string if Namespace
         *        processing is not being performed
         * @param qName the qualified name (with prefix), or the empty string if qualified names are
         *        not available
         * @throws SAXException if any error occors in this method.
         */
        public void endElement(String uri, String localName, String qName) throws SAXException {
        }

        /**
         * <p>
         * mock method.
         * </p>
         * @throws SAXException if any error occors in this method.
         */
        public void endDocument() throws SAXException {
        }

    }
}