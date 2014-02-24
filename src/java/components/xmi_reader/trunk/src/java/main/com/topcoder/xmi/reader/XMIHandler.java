/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import org.xml.sax.ContentHandler;


/**
 * <p>
 * This interface represents the functionality that is required for all descendants of
 * ContentHandler to implement in order to be used with the XMIReader. Implementations of this
 * interface must either provide a public no-argument constructor, or a public one-argument
 * constructor that accepts an XMIReader as its only argument.
 * </p>
 *
 * <p>
 * <strong>Thread Safety:</strong> Implementations of this interface are required to be
 * thread-safe.
 * </p>
 *
 * @author dplass, magicpig
 * @version 1.0
 */
public interface XMIHandler extends ContentHandler {
    /**
     * <p>
     * Captures the given XMIReader for later usage.
     * </p>
     *
     * @param reader the XMIReader that will be used for parsing.
     *
     * @throws IllegalArgumentException if reader is null
     */
    void setXMIReader(XMIReader reader);

    /**
     * <p>
     * Returns the last object reference that was created. This is required so that handlers of
     * child nodes can retrieve the current object and modify it. The specific protocol used
     * between XMIHandler classes is not part of this component and will be determined by each
     * individual XMIHandler implementation class.
     * </p>
     *
     * @return the last reference that was created.
     */
    Object getLastRefObject();

    /**
     * <p>
     * Returns the last property name that was processed. This is required so that handlers of
     * child nodes can determine what the last property was.  The specific protocol used between
     * XMIHandler classes is not part of this component and will be determined by each individual
     * XMIHandler implementation class.
     * </p>
     *
     * @return the last property name that was processed
     */
    String getLastProperty();
}
