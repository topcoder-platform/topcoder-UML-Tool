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
 * This is the default implementation of XMIConverterChain interface. It stores the next chain
 * and corresponding XMIConverter instance, if neither next nor converter is null, the chain's
 * processing method will call the converter to do the processing, otherwise, it will call the
 * handler directly to do the processing. It is created by XMIConverterHandler and never used
 * by user directly.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * It is mutable. Both the next and converter variables are mutable. So it's not thread-safe.
 * </p>
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
class DefaultXMIConverterChain implements XMIConverterChain {
    /**
     * <p>
     * The next chain of XMI Converter. It is initialized in the constructor and never be changed.
     * It can be null. It is accessed by the all methods and retrieved by the getter.
     * </p>
     */
    private final XMIConverterChain next;

    /**
     * <p>
     * The converter instance in this chain. It is initialized in the constructor and never be changed.
     * It can be null. It is accessed by the all methods and retrieved by the getter.
     * </p>
     */
    private final XMIConverter converter;

    /**
     * <p>
     * Construct this class without arguments. The next chain the converter will be set to null.
     * This is the end chain so that none converter is provided.
     * </p>
     */
    public DefaultXMIConverterChain() {
        this.next = null;
        this.converter = null;
    }

    /**
     * <p>
     * Construct this chain with next chain and the converter instance.
     * This is not the end chain of the chains.
     * </p>
     *
     * @param next the next chain to set
     * @param converter the converter instance of this chain
     * @throws IllegalArgumentException if any argument is null
     */
    public DefaultXMIConverterChain(XMIConverterChain next,
        XMIConverter converter) {
        Helper.checkNull(next, "next");
        Helper.checkNull(converter, "converter");

        this.next = next;
        this.converter = converter;
    }

    /**
     * <p>
     * This method is used to call the converter startDocument if it is set or call the given
     * handler startDocument if the this is the end chain.
     * </p>
     *
     * @param reader the XMIReader instance firing this callback
     * @param handler the XMIHandler instance this converter added to
     * @throws SAXException if any error occurs in this method
     */
    public void startDocument(XMIReader reader, XMIHandler handler)
        throws SAXException {
        //Next and converter will both be null or both be non-null
        //So we only need to check one variable
        if (next != null) {
            converter.startDocument(next, reader, handler);
        } else {
            //This is the end of the chain.
            handler.startDocument();
        }
    }

    /**
     * <p>
     * This method is used to call the converter startElement if it is set or call the given
     * handler startElement if the this is the end chain.
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
     * @param reader the XMIReader instance firing this callback
     * @param handler the XMIHandler instance this converter added to
     * @throws SAXException if any error occurs in this method
     */
    public void startElement(String uri, String localName, String qName,
        Attributes attrs, XMIReader reader, XMIHandler handler)
        throws SAXException {
        //Next and converter will both be null or both be non-null
        //So we only need to check one variable
        if (next != null) {
            converter.startElement(uri, localName, qName, attrs, next, reader,
                handler);
        } else {
            // This is the end of the chain.
            handler.startElement(uri, localName, qName, attrs);
        }
    }

    /**
     * <p>
     * This method is used to call the converter endElement if it is set or call the given
     * handler endElement if the this is the end chain.
     * </p>
     *
     * @param uri
     *        the Namespace URI, or the empty string if the element has no Namespace URI
     *        or if Namespace processing is not being performed
     * @param localName
     *        the local name (without prefix), or the empty string if Namespace processing is not being performed
     * @param qName
     *        the qualified name (with prefix), or the empty string if qualified names are not available
     * @param reader the XMIReader instance firing this callback
     * @param handler the XMIHandler instance this converter added to
     * @throws SAXException if any error occurs in this method
     */
    public void endElement(String uri, String localName, String qName,
        XMIReader reader, XMIHandler handler) throws SAXException {
        //Next and converter will both be null or both be non-null
        //So we only need to check one variable
        if (next != null) {
            converter.endElement(uri, localName, qName, next, reader, handler);
        } else {
            // This is the end of the chain.
            handler.endElement(uri, localName, qName);
        }
    }

    /**
     * <p>
     * This method is used to call the converter endDocument if it is set or call the given
     * handler endDocument if the this is the end chain.
     * </p>
     *
     * @param reader the XMIReader instance firing this callback
     * @param handler the XMIHandler instance this converter added to
     * @throws SAXException if any error occurs in this method
     */
    public void endDocument(XMIReader reader, XMIHandler handler)
        throws SAXException {
        //Next and converter will both be null or both be non-null
        //So we only need to check one variable
        if (next != null) {
            converter.endDocument(next, reader, handler);
        } else {
            // This is the end of the chain.
            handler.endDocument();
        }
    }

    /**
     * <p>See XMIConverterChain.characters for descriptions.</p>
     * <p>
     * This method is used to call the converter characters if it is set or call the given
     * handler characters if the this is the end chain.
     * </p>
     *
     * @param ch the characters from the XML document
     * @param start the start position in the array
     * @param length the number of characters to read from the array
     * @param reader the XMIReader instance firing this callback
     * @param handler the XMIHandler instance this converter added to
     * @throws SAXException if any error occurs in this method
     */
    public void characters(char[] ch, int start, int length, XMIReader reader,
        XMIHandler handler) throws SAXException {
        //Next and converter will both be null or both be non-null
        //So we only need to check one variable
        if (next != null) {
            converter.characters(ch, start, length, next, reader, handler);
        } else {
            // This is the end of the chain.
            handler.characters(ch, start, length);
        }
    }

    /**
     * <p>Get the next chain to this one.</p>
     *
     * @return the next variable
     */
    public XMIConverterChain getNext() {
        return next;
    }

    /**
     * <p>Get the converter in this chain.</p>
     *
     * @return the converter variable
     */
    public XMIConverter getConverter() {
        return converter;
    }
}
