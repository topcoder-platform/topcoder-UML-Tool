/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.converters;

import com.topcoder.umltool.xmiconverters.poseidon5.DefaultXMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterChain;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;


/**
 * <p>
 * Mock class for DefaultXMIConverter, in order to capture the call to XMIConverter.
 * The test cases can call getLastOperation() to test whether the specified method
 * in XMIConverter is called.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockConverter extends DefaultXMIConverter {
    /**
     * <p>The name of last operation on this XMIConverter.</p>
     */
    private String operation;

    /**
     * <p>Empty constructor.</p>
     */
    public MockConverter() {
    }

    /**
     * <p>Get the name of the last operation on this XMIConverter.</p>
     *
     * @return the name of the last operation
     */
    public String getLastOperation() {
        return operation;
    }

    /**
     * <p>Set the name of the last operation.</p>
     *
     * @param operation the name of the last operation
     */
    public void setLastOperaiton(String operation) {
        this.operation = operation;
    }

    /**
     * <p>
     * Override method, just assign the operation's value here, and then delegate to super.
     * </p>
     *
    * @param ch the characters from the XML document
    * @param start the start position in the array
    * @param length the number of characters to read from the array
    * @param chain the next chain of the chains of converters
    * @param reader the XMIReader instance firing this callback
    * @param handler the XMIHandler instance this converter added to
    * @throws SAXException if any error occurs in this method
     */
    public void characters(char[] ch, int start, int length,
        XMIConverterChain chain, XMIReader reader, XMIHandler handler)
        throws SAXException {
        operation = "characters";

        super.characters(ch, start, length, chain, reader, handler);
    }

    /**
     * <p>
     * Override method, just assign the operation's value here, and then delegate to super.
     * </p>
     *
    * @param chain the next chain of the chains of converters
    * @param reader the XMIReader instance firing this callback
    * @param handler the XMIHandler instance this converter added to
    * @throws SAXException if any error occurs
     */
    public void endDocument(XMIConverterChain chain, XMIReader reader,
        XMIHandler handler) throws SAXException {
        operation = "endDocument";

        super.endDocument(chain, reader, handler);
    }

    /**
     * <p>
     * Override method, just assign the operation's value here, and then delegate to super.
     * </p>
     *
    * @param uri
    *        the Namespace URI, or the empty string if the element has no Namespace URI
    *        or if Namespace processing is not being performed
    * @param localName
    *        the local name (without prefix), or the empty string if Namespace processing is not being performed
    * @param qName
    *        the qualified XML name (with prefix), or the empty string if qualified names are not available
    * @param chain the next chain of the chains of converters
    * @param reader the XMIReader instance firing this callback
    * @param handler the XMIHandler instance this converter added to
    * @throws SAXException if any error occurs in this method
     */
    public void endElement(String uri, String localName, String qName,
        XMIConverterChain chain, XMIReader reader, XMIHandler handler)
        throws SAXException {
        operation = "endElement";

        super.endElement(uri, localName, qName, chain, reader, handler);
    }

    /**
     * <p>
     * Override method, just assign the operation's value here, and then delegate to super.
     * </p>
    * @param chain the next chain of the chains of converters
    * @param reader the XMIReader instance firing this callback
    * @param handler the XMIHandler instance this converter added to
    * @throws SAXException if any error occurs in this method
     */
    public void startDocument(XMIConverterChain chain, XMIReader reader,
        XMIHandler handler) throws SAXException {
        operation = "startDocument";

        super.startDocument(chain, reader, handler);
    }

    /**
     * <p>
     * Override method, just assign the operation's value here, and then delegate to super.
     * </p>
     *
    * @param uri
    *        the Namespace URI, or the empty string if the element has no Namespace URI
    *        or if Namespace processing is not being performed
    * @param localName
    *        the local name (without prefix), or the empty string if Namespace processing is not being performed
    * @param qName
    *        the qualified name (with prefix), or the empty string if qualified names are not available
    * @param attrs
    *        the attributes attached to the element. If there are no attributes, it shall be an empty
    *        Attributes object. The value of this object after startElement returns is undefined
    * @param chain the next chain of the chains of converters
    * @param reader the XMIReader instance firing this callback
    * @param handler the XMIHandler instance this converter added to
    * @throws SAXException if any error occurs in this method
     */
    public void startElement(String uri, String localName, String qName,
        Attributes attrs, XMIConverterChain chain, XMIReader reader,
        XMIHandler handler) throws SAXException {
        operation = "startElement";

        super.startElement(uri, localName, qName, attrs, chain, reader, handler);
    }
}
