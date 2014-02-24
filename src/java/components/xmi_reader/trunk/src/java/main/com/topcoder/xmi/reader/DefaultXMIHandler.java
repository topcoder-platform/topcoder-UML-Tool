/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import org.xml.sax.helpers.DefaultHandler;


/**
 * <p>
 * This is a default implementation of the XMIHandler interface. All the methods in the interface
 * are implemented, as well as set methods for the properties.
 * </p>
 *
 * <p>
 * <strong>Thread Safety:</strong> This class is thread-safe since all of the 'set' methods are
 * synchronized and the 'get' methods merely return the corresponding property.
 * </p>
 *
 * @author dplass, magicpig
 * @version 1.0
 */
public abstract class DefaultXMIHandler extends DefaultHandler implements XMIHandler {
    /**
     * <p>
     * The current XMIReader that is being used for parsing. It is set either in the constructor or
     * by the setXMIReader method. This property may be null until it is set. Once set, it cannot
     * be changed.
     * </p>
     */
    private XMIReader reader = null;

    /**
     * <p>
     * This represents the last object created by this handler. Population and usage of this
     * property is implementation-dependent. The specific protocol used between XMIHandler classes
     * is not part of this component and will be determined by each individual XMIHandler
     * implementation. This property may be null. It is set by setLastRefObject and retrieved by
     * getLastRefObject.
     * </p>
     */
    private Object lastRefObject = null;

    /**
     * <p>
     * Represents the last property name that was processed. This is required so that handlers of
     * child nodes can determine what the last property was. The specific protocol used between
     * XMIHandler classes is not part of this component and will be determined by each individual
     * XMIHandler implementation class. This property is set by setLastProperty and accessed by
     * getLastProperty. This value might be null but will never be empty after trimmed.
     * </p>
     */
    private String lastProperty = null;

    /**
     * <p>
     * Constructs this handler with all properties null.
     * </p>
     */
    protected DefaultXMIHandler() {
        // does nothing
    }

    /**
     * <p>
     * Constructs this handler with the given XMIReader.
     * </p>
     *
     * @param reader the XMIReader instance to attach to this handler
     *
     * @throws IllegalArgumentException if reader is null.
     */
    protected DefaultXMIHandler(XMIReader reader) {
        ReaderHelper.validateNotNull(reader, "reader");
        this.reader = reader;
    }

    /**
     * <p>
     * Retrieves the value of the 'reader' property.
     * </p>
     *
     * @return the value of the 'reader' property, which may be null if not set.
     */
    public XMIReader getXMIReader() {
        return reader;
    }

    /**
     * <p>
     * Sets the value of the 'reader' property if it has not been set yet.
     * </p>
     *
     * @param reader the XMIReader instance to attach to this handler
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws IllegalStateException if the 'reader' property is already set.
     */
    public synchronized void setXMIReader(XMIReader reader) {
        ReaderHelper.validateNotNull(reader, "reader");

        if (this.reader != null) {
            throw new IllegalStateException("reader property has already been set.");
        }

        this.reader = reader;
    }

    /**
     * <p>
     * Returns the value of the 'lastRefObject' property, as set by the setLastRefObject method.
     * </p>
     *
     * @return the value of the 'lastReference' property, which may be null.
     */
    public Object getLastRefObject() {
        return lastRefObject;
    }

    /**
     * <p>
     * Sets the value of the lastRefObject property. Note that 'null' is a valid argument.
     * </p>
     *
     * @param lastRefObject the value of the lastRefObject. May be null in order to clear the
     *        property.
     */
    public synchronized void setLastRefObject(Object lastRefObject) {
        this.lastRefObject = lastRefObject;
    }

    /**
     * <p>
     * Returns the value of the lastProperty property.
     * </p>
     *
     * @return the value of the lastProperty property, which may be null.
     */
    public String getLastProperty() {
        return lastProperty;
    }

    /**
     * <p>
     * Sets the value of the lastProperty property. Note that null is a valid argument, but empty
     * (after trimmed) is not.
     * </p>
     *
     * @param lastProperty the value of the lastProperty to set. May be null in order to clear the
     *        property.
     *
     * @throws IllegalArgumentException if lastProperty is empty after trimmed
     */
    public synchronized void setLastProperty(String lastProperty) {
        ReaderHelper.validateEmpty(lastProperty, "lastProperty");
        this.lastProperty = lastProperty;
    }
}
