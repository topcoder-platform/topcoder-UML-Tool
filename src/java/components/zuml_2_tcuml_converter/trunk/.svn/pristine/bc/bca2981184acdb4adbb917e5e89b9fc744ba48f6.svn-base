/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.handlers;

import com.topcoder.xmi.reader.DefaultXMIHandler;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;


/**
 * <p>
 * Mock class for DefaultXMIHandler, in order to capture the call to XMIHandler.
 * The test cases can call getLastOperation() to test whether the specified method
 * in XMIHandler is called.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockHandler extends DefaultXMIHandler {
    /**
     * <p>The name of last operation on this XMIHandler.</p>
     */
    private String operation;

    /**
     * <p>Empty constructor.</p>
     */
    public MockHandler() {
    }

    /**
     * <p>Get the name of the last operation on this XMIHandler.</p>
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
     * <p>Override method, just assign the operation's value here.</p>
     * @param ch ignored in this mock class
     * @param start ignored in this mock class
     * @param length ignored in this mock class
     */
    public void characters(char[] ch, int start, int length) {
        operation = "characters";
    }

    /**
     * <p>Override method, just assign the operation's value here.</p>
     *
     * @param ch ignored in this mock class
     * @param start ignored in this mock class
     * @param length ignored in this mock class
     */
    public void ignorableWhitespace(char[] ch, int start, int length) {
        operation = "ignorableWhitespace";
    }

    /**
     * <p>Override method, just assign the operation's value here.</p>
     * @param target ignored in this mock class
     * @param data ignored in this mock class
     */
    public void processingInstruction(String target, String data) {
        operation = "processingInstruction";
    }

    /**
     * <p>Override method, just assign the operation's value here.</p>
     * @param locator ignored in this mock class
     */
    public void setDocumentLocator(Locator locator) {
        operation = "setDocumentLocator";
    }

    /**
     * <p>Override method, just assign the operation's value here.</p>
     */
    public void endDocument() {
        operation = "endDocument";
    }

    /**
     * <p>Override method, just assign the operation's value here.</p>
     * @param uri ignored in this mock class
     * @param localName ignored in this mock class
     * @param qName ignored in this mock class
     */
    public void endElement(String uri, String localName, String qName) {
        operation = "endElement";
    }

    /**
     * <p>Override method, just assign the operation's value here.</p>
     */
    public void startDocument() {
        operation = "startDocument";
    }

    /**
     * <p>Override method, just assign the operation's value here.</p>
     * @param uri ignored in this mock class
     * @param localName ignored in this mock class
     * @param qName ignored in this mock class
     * @param attributes ignored in this mock class
     */
    public void startElement(String uri, String localName, String qName,
        Attributes attributes) {
        operation = "startElement";
    }

    /**
     * <p>Override method, just assign the operation's value here.</p>
     * @param prefix ignored in this mock class
     */
    public void endPrefixMapping(String prefix) {
        operation = "endPrefixMapping";
    }

    /**
     * <p>Override method, just assign the operation's value here.</p>
     * @param name ignored in this mock class
     */
    public void skippedEntity(String name) {
        operation = "skippedEntity";
    }

    /**
     * <p>Override method, just assign the operation's value here.</p>
     * @param prefix ignored in this mock class
     * @param uri ignored in this mock class
     */
    public void startPrefixMapping(String prefix, String uri) {
        operation = "startPrefixMapping";
    }
}
