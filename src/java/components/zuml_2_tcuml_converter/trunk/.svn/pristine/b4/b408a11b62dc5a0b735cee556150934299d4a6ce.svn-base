/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;


/**
 * <p>
 * The abstract XMIConverter implementation is used to provide the convenience to sub-classes.
 * The sub-classes can just override the method they want to implement. All the processing
 * methods in this class just delegate the calling to next chain.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is stateless and immutable.
 * </p>
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public abstract class DefaultXMIConverter implements XMIConverter {
    /**
     * <p>Empty constructor as a placeholder for future use.</p>
     */
    protected DefaultXMIConverter() {
    }

    /**
     * <p>
     * Receive notification of the beginning of a document fired by XMIReader. The XMIReader will
     * invoke this method only once,&nbsp; before any other event callbacks. This method may be
     * not called if the previous chain doesn't call this converter.
     * </p>
     *
     * @param chain the next chain of the chains of converters
     * @param reader the XMIReader instance firing this callback
     * @param handler the XMIHandler instance this converter added to
     * @throws SAXException if any error occurs in this method
     */
    public void startDocument(XMIConverterChain chain, XMIReader reader,
        XMIHandler handler) throws SAXException {
        chain.startDocument(reader, handler);
    }

    /**
     * <p>
     * Receive notification of the end of a document fired by XMIReader. The XMI reader will invoke
     * this method only once, and it will be the last method invoked during the parse. The reader
     * shall not invoke this method until it has either abandoned parsing (because of an unrecoverable
     * error) or reached the end of input. This method may be not called if the previous chain doesn't
     * call this converter.
     * </p>
     *
     * @param chain the next chain of the chains of converters
     * @param reader the XMIReader instance firing this callback
     * @param handler the XMIHandler instance this converter added to
     * @throws SAXException if any error occurs
     */
    public void endDocument(XMIConverterChain chain, XMIReader reader,
        XMIHandler handler) throws SAXException {
        chain.endDocument(reader, handler);
    }

    /**
     * <p>
     * Receive notification of the beginning of an element. The XMI reader will invoke this method
     * at the beginning of every element in the XML document, there will be a corresponding
     * endElement event for every startElement event (even when the element is empty). All of the
     * element's content will be reported, in order, before the corresponding endElement event.
     * This method may be not called if the previous chain doesn't call this converter.
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
        chain.startElement(uri, localName, qName, attrs, reader, handler);
    }

    /**
     * <p>
     * Receive notification of the end of an element. The XMI Reader will invoke this method
     * at the end of every element in the XML document, there will be a corresponding
     * startElement event for every endElement event (even when the element is empty). This
     * method may be not called if the previous chain doesn't call this converter.
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
        chain.endElement(uri, localName, qName, reader, handler);
    }

    /**
     * <p>
     * Receive notification of character data. The XMI Reader will call this method to report
     * each chunk of character data. SAX parsers may return all contiguous character data in
     * a single chunk, or they may split it into several chunks, however, all of the characters
     * in any single event must come from the same external entity so that the Locator provides
     * useful information. This method may be not called if the previous chain doesn't call
     * this converter.
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
        chain.characters(ch, start, length, reader, handler);
    }
}
