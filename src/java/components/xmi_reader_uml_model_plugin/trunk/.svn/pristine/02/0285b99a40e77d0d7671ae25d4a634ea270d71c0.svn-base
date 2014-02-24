/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.model;

import org.xml.sax.Attributes;

import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.xmi.reader.DefaultXMIHandler;

/**
 * <p>
 * This class extends the DefaultXMIHandler abstract class and is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class OtherXMIHandler extends DefaultXMIHandler {
    /**
     * <p>
     * This method implements the startElement(String,String,String,Attributes) in ContentHandler interface.
     * </p>
     *
     * <p>
     * Note, it is only used for testing.
     * </p>
     *
     * @param uri the Namespace URI;
     * @param localName The local name (without prefix), or the empty string if Namespace processing is not
     * being performed.
     * @param qName The qualified name (with prefix), or the empty string if qualified names are not available.
     * @param attributes The attributes attached to the element. If there are no attributes, it shall be an empty
     * Attributes object.
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        this.setLastProperty(qName);
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
