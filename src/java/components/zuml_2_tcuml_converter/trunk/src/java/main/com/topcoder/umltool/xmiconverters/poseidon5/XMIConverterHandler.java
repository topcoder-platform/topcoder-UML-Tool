/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;


/**
 * <p>
 * This class is a wrapper of XMIHandler to provide the functionality to add XMIConverter
 * chains to existing XMIHandler instances in XMIReader. It delegates most of the methods
 * to the inner XMIHandler instance and only dispatches startDocument, endDocument, startElement,
 * endElement and characters methods to the XMIConverter chain. It will be created by
 * XMIConverterUtil and used to replace the existing XMIHandler instance in XMIReader, the
 * user can not use it directly.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * Because the used classes(XMIConverterChain and XMIConverter) are not required to be thread-safe,
 * this class is not thread-safe.
 * </p>
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
class XMIConverterHandler implements XMIHandler {
    /**
     * <p>
     * The inner handler this handler wrapped. It is initialized in the constructor and never be changed.
     * It can not be null. It is used by the all methods.
     * </p>
     */
    private final XMIHandler innerHandler;

    /**
     * <p>
     * The root chain of the XMIConverters added in this handler. It is initialized in the constructor
     * but is mutable, it will be changed to the last added converter's chain. It can not be null.
     * It is used to delegate the processing methods (startDocument, endDocument, startElement, endElement,
     * and characters) to the converters.
     * </p>
     */
    private XMIConverterChain rootChain;

    /**
     * <p>
     * The XMIReader instance this handler added to. It is initialized by the constructor and can be
     * changed by the setXMIReader method. It can not be null. It is used by the all processing methods.
     * (startDocument, endDocument, startElement, endElement, and characters)
     * </p>
     */
    private XMIReader reader;

    /**
     * <p>
     * Construct this class with the wrapped handler and the XMIReader instance.
     * </p>
     *
     * @param innerHandler the wrapped handler the converters will be added to
     * @param reader the XMIReader instance
     * @throws IllegalArgumentException if any argument is null
     */
    public XMIConverterHandler(XMIHandler innerHandler, XMIReader reader) {
        Helper.checkNull(innerHandler, "innerHandler");
        Helper.checkNull(reader, "reader");

        this.innerHandler = innerHandler;
        this.reader = reader;

        rootChain = new DefaultXMIConverterChain();
    }

    /**
     * <p>
     * Add a XMIConverter to the this handler so that it can do some convertion for the wrapped handler.
     * </p>
     *
     * @param converter the XMIConverter to add to do some convertion for the wrapped handler
     * @throws IllegalArgumentException if converter is null
     */
    public void addConverter(XMIConverter converter) {
        Helper.checkNull(converter, "converter");

        rootChain = new DefaultXMIConverterChain(rootChain, converter);
    }

    /**
     * <p>
     * Captures the given XMIReader for later usage. Delegate to the inner handler.
     * </p>
     *
     * @param reader the XMIHeader instance
     * @throws IllegalArgumentException if the reader is null
     */
    public void setXMIReader(XMIReader reader) {
        Helper.checkNull(reader, "reader");

        innerHandler.setXMIReader(reader);
        this.reader = reader;
    }

    /**
     * <p>
     * Returns the last object reference that was created. This is required so that handlers of
     * child nodes can retrieve the current object and modify it. The specific protocol used
     * between XMIHandler classes is not part of this component and will be determined by each
     * individual XMIHandler implementation class.
     * </p>
     *
     * @return  the last object reference that was created
     */
    public Object getLastRefObject() {
        return innerHandler.getLastRefObject();
    }

    /**
     * <p>
     * Returns the last property name that was processed. This is required so that handlers of
     * child nodes can determine what the last property was. The specific protocol used between
     * XMIHandler classes is not part of this component and will be determined by each individual
     * XMIHandler implementation class.
     * </p>
     *
     * @return the last property name that was processed
     */
    public String getLastProperty() {
        return innerHandler.getLastProperty();
    }

    /**
     * <p>
     * See org.xml.sax.ContentHandler.characters for descriptions.
     * In this method, it will call the rootChain.characters to start the chains of converters.
     * </p>
     *
     * @param ch the characters from the XML document
     * @param start the start position in the array
     * @param length the number of characters to read from the array
     * @throws SAXException if any error occurs in this method
     */
    public void characters(char[] ch, int start, int length)
        throws SAXException {
        rootChain.characters(ch, start, length, reader, innerHandler);
    }

    /**
     * <p>
     * See org.xml.sax.ContentHandler.ignorableWhitespace for descriptions.
     * In this method, it will delegate to inner handler.
     * </p>
     *
     * @param ch the characters from the XML document
     * @param start the start position in the array
     * @param length the number of characters to read from the array
     * @throws SAXException if any error occurs in this method
     */
    public void ignorableWhitespace(char[] ch, int start, int length)
        throws SAXException {
        innerHandler.ignorableWhitespace(ch, start, length);
    }

    /**
     * <p>
     * See org.xml.sax.ContentHandler.processingInstruction for descriptions.
     * In this method, it will delegate to inner handler.
     * </p>
     *
     * @param target the processing instruction target
     * @param data
     *        the processing instruction data, or null if none was supplied.
     *        The data does not include any whitespace separating it from the target
     * @throws SAXException if any error occurs in this method
     */
    public void processingInstruction(String target, String data)
        throws SAXException {
        innerHandler.processingInstruction(target, data);
    }

    /**
     * <p>
     * See org.xml.sax.ContentHandler.setDocumentLocator for descriptions.
     * In this method, it will delegate to inner handler.
     * </p>
     *
     * @param locator an object that can return the location of any SAX document event
     */
    public void setDocumentLocator(Locator locator) {
        innerHandler.setDocumentLocator(locator);
    }

    /**
     * <p>
     * See org.xml.sax.ContentHandler.startDocument for descriptions.
     * In this method, it will call the rootChain.startDocument to start the chains of converters.
     * </p>
     *
     * @throws SAXException if any error occurs in this method
     */
    public void startDocument() throws SAXException {
        rootChain.startDocument(reader, innerHandler);
    }

    /**
     * <p>
     * See org.xml.sax.ContentHandler.startElement for descriptions.
     * In this method, it will call the rootChain.startElement to start the chains of converters.
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
     * @throws SAXException if any error occurs in this method
     */
    public void startElement(String uri, String localName, String qName,
        Attributes attrs) throws SAXException {
        rootChain.startElement(uri, localName, qName, attrs, reader,
            innerHandler);
    }

    /**
     * <p>
     * See org.xml.sax.ContentHandler.endElement for descriptions.
     * In this method, it will call the rootChain.endElement to start the chains of converters.
     * </p>
     *
     * @param uri
     *        the Namespace URI, or the empty string if the element has no Namespace URI
     *        or if Namespace processing is not being performed
     * @param localName
     *        the local name (without prefix), or the empty string if Namespace processing is not being performed
     * @param qName
     *        the qualified name (with prefix), or the empty string if qualified names are not available
     * @throws SAXException if any error occurs in this method
     */
    public void endElement(String uri, String localName, String qName)
        throws SAXException {
        rootChain.endElement(uri, localName, qName, reader, innerHandler);
    }

    /**
     * <p>
     * See org.xml.sax.ContentHandler.endDocument for descriptions.
     * In this method, it will call the rootChain.endDocument to start the chains of converters.
     * </p>
     *
     * @throws SAXException if any error occurs in this method
     */
    public void endDocument() throws SAXException {
        rootChain.endDocument(reader, innerHandler);
    }

    /**
     * <p>
     * See org.xml.sax.ContentHandler.startPrefixMapping for descriptions.
     * In this method, it will delegate to inner handler.
     * </p>
     *
     * @param prefix
     *        the Namespace prefix being declared.
     *        An empty string is used for the default element namespace, which has no prefix.
     * @param uri the Namespace URI the prefix is mapped to
     * @throws SAXException if any error occurs in this method
     */
    public void startPrefixMapping(String prefix, String uri)
        throws SAXException {
        innerHandler.startPrefixMapping(prefix, uri);
    }

    /**
     * <p>
     * See org.xml.sax.ContentHandler.endPrefixMapping for descriptions.
     * In this method, it will delegate to inner handler.
     * </p>
     *
     * @param prefix
     *        the Namespace prefix being declared.
     *        An empty string is used for the default element namespace, which has no prefix.
     * @throws SAXException if any error occurs in this method
     */
    public void endPrefixMapping(String prefix) throws SAXException {
        innerHandler.endPrefixMapping(prefix);
    }

    /**
     * <p>
     * See org.xml.sax.ContentHandler.skippedEntity for descriptions.
     * In this method, it will delegate to inner handler.
     * </p>
     *
     * @param name
     *        the name of the skipped entity.
     *        If it is a parameter entity, the name will begin with '%', and if it is the external DTD subset,
     *        it will be the string "[dtd]"
     * @throws SAXException if any error occurs in this method
     */
    public void skippedEntity(String name) throws SAXException {
        innerHandler.skippedEntity(name);
    }
}
