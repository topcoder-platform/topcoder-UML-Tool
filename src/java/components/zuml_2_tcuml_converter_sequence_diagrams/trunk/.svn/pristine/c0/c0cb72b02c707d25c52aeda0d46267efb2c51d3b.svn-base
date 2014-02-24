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
 * This is the responsibility interface of Chains of Responsibility Pattern. Post-processing
 * or pre-processing tasks can be done in this interface. It can also ignore the processing
 * of the original XMIHandler. In a word, it provides the full control of the original handler's processing.
 * </p>
 *
 * <p>
 * When adding the XMIConverter instances to original XMIHandler in XMIReader, the order of
 * them is important. May be some converter should be called earlier and the another converter.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * The implementation of this interface is not required to be thread-safe.
 * </p>
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public interface XMIConverter {
    /**
     * <p>
     * Receive notification of the beginning of a document fired by XMIReader. The XMIReader
     * will invoke this method only once,&nbsp; before any other event callbacks.
     * </p>
     *
     * <p>
     * This method may be not called if the previous chain deosn't call this converter.
     * </p>
     *
     * @param chain the next chain of the chains of converters
     * @param reader the XMIReader instance firing this callback
     * @param handler the XMIHandler instance this converter added to
     * @throws SAXException if any error occurs in this method
     */
    public void startDocument(XMIConverterChain chain, XMIReader reader,
        XMIHandler handler) throws SAXException;

    /**
     * <p>
     * Receive notification of the end of a document fired by XMIReader. The XMI reader will
     * invoke this method only once, and it will be the last method invoked during the parse.
     * The reader shall not invoke this method until it has either abandoned parsing (because
     * of an unrecoverable error) or reached the end of input.
     * </p>
     *
     * <p>
     * This method may be not called if the previous chain deosn't call this converter.
     * </p>
     *
     * @param chain the next chain of the chains of converters
     * @param reader the XMIReader instance firing this callback
     * @param handler the XMIHandler instance this converter added to
     * @throws SAXException if any error occurs in this method
     */
    public void endDocument(XMIConverterChain chain, XMIReader reader,
        XMIHandler handler) throws SAXException;

    /**
     * <p>
     * Receive notification of the beginning of an element. The XMI reader will invoke this
     * method at the beginning of every element in the XML document, there will be a corresponding
     * endElement event for every startElement event (even when the element is empty). All of
     * the element's content will be reported, in order, before the corresponding endElement event.
     * </p>
     *
     * <p>
     * This method may be not called if the previous chain deosn't call this converter.
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
     *        the attributes attached to the element. If there are no attributes,
     *        it shall be an empty Attributes object. The value of this object after startElement returns is undefined
     * @param chain the next chain of the chains of converters
     * @param reader the XMIReader instance firing this callback
     * @param handler the XMIHandler instance this converter added to
     * @throws SAXException if any error occurs in this method
     */
    public void startElement(String uri, String localName, String qName,
        Attributes attrs, XMIConverterChain chain, XMIReader reader,
        XMIHandler handler) throws SAXException;

    /**
     * <p>
     * Receive notification of the end of an element. The XMI Reader will invoke this method
     * at the end of every element in the XML document; there will be a corresponding startElement
     * event for every endElement event (even when the element is empty).
     * </p>
     *
     * <p>
     * This method may be not called if the previous chain deosn't call this converter.
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
        throws SAXException;

    /**
     * <p>
     * Receive notification of character data. The XMI Reader will call this method to report
     * each chunk of character data. SAX parsers may return all contiguous character data in
     * a single chunk, or they may split it into several chunks; however, all of the characters
     * in any single event must come from the same external entity so that the Locator provides
     * useful information.
     * </p>
     *
     * <p>
     * This method may be not called if the previous chain deosn't call this converter.
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
        throws SAXException;
}
