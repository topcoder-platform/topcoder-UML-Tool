/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.model.accuracytests;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.xmi.reader.DefaultXMIHandler;

/**
 * <p>
 * This class <code>SimpleXMIHandler</code> extends the <code>DefaultXMIHandler</code>. It is only used for
 * accuracy testing.
 * </p>
 *
 * @author mittu
 * @version 1.0
 */
public class SimpleXMIHandler extends DefaultXMIHandler {
    /**
     * <p>
     * This method implements the startElement(String,String,String,Attributes) in ContentHandler interface.
     * </p>
     *
     * <p>
     * This method receives notification of the beginning of an element. The UMLModelElements for State Machine and
     * Activity Graph are handled by this method for accuracy testing.
     * </p>
     *
     * @param uri
     *            the Namespace URI;
     * @param localName
     *            The local name (without prefix), or the empty string if Namespace processing is not being performed.
     * @param qName
     *            The qualified name (with prefix), or the empty string if qualified names are not available.
     * @param atts
     *            The attributes attached to the element. If there are no attributes, it shall be an empty Attributes
     *            object.
     *
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

    }

    /**
     * <p>
     * This method overrides the getLastRefObject() method in DefaultXMIHandler class.
     * </p>
     *
     * <p>
     * Note, it is only used for testing.
     * </p>
     *
     * @return an Uml1SemanticModelBridge instance, used for testing only.
     */
    public Object getLastRefObject() {
        return new Uml1SemanticModelBridge();
    }
}
