/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.converters;

import com.topcoder.umltool.xmiconverters.poseidon5.DefaultXMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterChain;
import com.topcoder.umltool.xmiconverters.poseidon5.handlers.ZUMLMethodHandler;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.List;


/**
 * <p>
 * This converter is used to ignore the &lt;UML:Operation&gt; element in &lt;UML:Method&gt;
 * element. It will check the active handlers in XMIReader, if the previous handler is
 * ZUMLMethodHandler instance, the processing will return immediately, the next chain will
 * not be called.
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
public class IgnoreOperationInMethodConverter extends DefaultXMIConverter {
    /**
     * <p>Empty constructor as a placeholder for future use.</p>
     */
    public IgnoreOperationInMethodConverter() {
    }

    /**
     * <p>
     * This method is used to ignore the handler processing for &lt;UML:Operation&gt; element
     * in &lt;UML:Method&gt; element.
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
        XMIHandler handler) throws SAXException {
        List<XMIHandler> handlers = reader.getActiveHandlers();

        if (handlers.size() >= 2) {
            if (handlers.get(handlers.size() - 2) instanceof ZUMLMethodHandler) {
                return;
            }
        }

        chain.startElement(uri, localName, qName, attrs, reader, handler);
    }

    /**
     * <p>
     * This method is used to ignore the handler processing for &lt;UML:Operation&gt;
     * element in &lt;UML:Method&gt; element.
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
        List<XMIHandler> handlers = reader.getActiveHandlers();

        if (handlers.size() >= 2) {
            if (handlers.get(handlers.size() - 2) instanceof ZUMLMethodHandler) {
                return;
            }
        }

        chain.endElement(uri, localName, qName, reader, handler);
    }
}
