/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers;

import com.topcoder.xmi.reader.DefaultXMIHandler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;


/**
 * <p>
 * This is the mock class of DefaultXMIHandler. It has some additional properties for counting time
 * of calling the methods.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockClassCountingXMIHandler extends DefaultXMIHandler {
    /** The counter of time for calling method startDocument. */
    public int count_startDocument = 0;

    /** The flag denote whether startDocument should throw SAXException. */
    public boolean exceptionFlag_startDocument = false;

    /** The counter of time for calling method startElement. */
    public int count_startElement = 0;

    /** The flag denote whether endElement should throw SAXException. */
    public boolean exceptionFlag_endElement = false;

    /** The counter of time for calling method endElement. */
    public int count_endElement = 0;

    /** The flag denote whether startElement should throw SAXException. */
    public boolean exceptionFlag_startElement = false;

    /** The counter of time for calling method ignorableWhitespace. */
    public int count_ignorableWhitespace = 0;

    /** The flag denote whether ignorableWhitespace should throw SAXException. */
    public boolean exceptionFlag_ignorableWhitespace = false;

    /** The counter of time for calling method characters. */
    public int count_characters = 0;

    /** The flag denote whether characters should throw SAXException. */
    public boolean exceptionFlag_characters = false;

    /** The counter of time for calling method endDocument. */
    public int count_endDocument = 0;

    /** The flag denote whether endDocument should throw SAXException. */
    public boolean exceptionFlag_endDocument = false;

    /** The counter of time for calling method processingInstruction. */
    public int count_processingInstruction = 0;

    /** The flag denote whether processingInstruction should throw SAXException. */
    public boolean exceptionFlag_processingInstruction = false;

    /**
     * <p>
     * The default constructor to create a MockClassCountingXMIHandler instance.
     * </p>
     */
    public MockClassCountingXMIHandler() {
        // does nothing
    }

    /**
     * <p>
     * Mock method for startDocument. It will increase the count_startDocument field or throw
     * SAXException when exceptionFlag_startDocument is true.
     * </p>
     *
     * @throws SAXException when exceptionFlag_startDocument is true
     */
    public void startDocument() throws SAXException {
        if (exceptionFlag_startDocument) {
            throw new SAXException("The exception is thrown.");
        }

        count_startDocument++;
    }

    /**
     * <p>
     * Mock method for startElement. It will increase the count_startElement field or throw
     * SAXException when exceptionFlag_startElement is true.
     * </p>
     *
     * @param uri the Namespace URI, or the empty string if the element has no Namespace URI or if
     *        Namespace processing is not being performed
     * @param localName the local name (without prefix), or the empty string if Namespace
     *        processing is not being performed
     * @param qname the qualified name (with prefix), or the empty string if qualified names are
     *        not available
     * @param atts the attributes attached to the element. This method does not use the attributes,
     *        but passes them unchanged into the currentHandler, if there is one.
     *
     * @throws SAXException when exceptionFlag_startElement is true
     */
    public void startElement(String uri, String localName, String qname, Attributes atts)
        throws SAXException {
        if (exceptionFlag_startElement) {
            throw new SAXException("The exception is thrown.");
        }

        count_startElement++;
    }

    /**
     * <p>
     * Mock method for endElement. It will increase the count_endElement field or throw
     * SAXException when exceptionFlag_endElement is true.
     * </p>
     *
     * @param uri the Namespace URI, or the empty string if the element has no Namespace URI or if
     *        Namespace processing is not being performed
     * @param localName the local name (without prefix), or the empty string if Namespace
     *        processing is not being performed
     * @param qname the qualified name (with prefix), or the empty string if qualified names are
     *        not available
     *
     * @throws SAXException when exceptionFlag_endElement is true
     */
    public void endElement(String uri, String localName, String qname)
        throws SAXException {
        if (exceptionFlag_endElement) {
            throw new SAXException("The exception is thrown.");
        }

        count_endElement++;
    }

    /**
     * <p>
     * Mock method for ignorableWhitespace. It will increase the count_ignorableWhitespace field or
     * throw SAXException when exceptionFlag_ignorableWhitespace is true.
     * </p>
     *
     * @param ch the characters from the XML document
     * @param start the start position in the array
     * @param length the number of characters to read from the array
     *
     * @throws SAXException when exceptionFlag_ignorableWhitespace is true
     */
    public void ignorableWhitespace(char[] ch, int start, int length)
        throws SAXException {
        if (exceptionFlag_ignorableWhitespace) {
            throw new SAXException("The exception is thrown.");
        }

        count_ignorableWhitespace++;
    }

    /**
     * <p>
     * Mock method for characters. It will increase the count_characters field or throw
     * SAXException when exceptionFlag_characters is true.
     * </p>
     *
     * @param ch the characters from the XML document
     * @param start the start position in the array
     * @param length the number of characters to read from the array
     *
     * @throws SAXException when exceptionFlag_characters is true
     */
    public void characters(char[] ch, int start, int length)
        throws SAXException {
        if (exceptionFlag_characters) {
            throw new SAXException("The exception is thrown.");
        }

        count_characters++;
    }

    /**
     * <p>
     * Mock method for endDocument. It will increase the count_endDocument field or throw
     * SAXException when exceptionFlag_endDocument is true.
     * </p>
     *
     * @throws SAXException when exceptionFlag_endDocument is true
     */
    public void endDocument() throws SAXException {
        if (exceptionFlag_endDocument) {
            throw new SAXException("The exception is thrown.");
        }

        count_endDocument++;
    }

    /**
     * <p>
     * Mock method for endDocument. It will increase the count_processingInstruction field or throw
     * SAXException when exceptionFlag_processingInstruction is true.
     * </p>
     *
     * @param target the processing instruction target
     * @param data the processing instruction data, or null if none was supplied. The data does
     *            not include any whitespace separating it from the target
     *
     * @throws SAXException when exceptionFlag_processingInstruction is true
     */
    public void processingInstruction(String target, String data)
        throws SAXException {
        if (exceptionFlag_processingInstruction) {
            throw new SAXException("The exception is thrown.");
        }

        count_processingInstruction++;
    }
}
