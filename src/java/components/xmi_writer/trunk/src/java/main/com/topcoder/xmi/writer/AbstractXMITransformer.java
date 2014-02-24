/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

/**
 * <p>
 * This abstract class implements the <code>{@link XMITransformer}</code> interface, and it provides implementation to
 * the <code>setXMIWriter</code> and <code>getXMIWriter</code> from the interface.
 * </p>
 * <p>
 * All <code>{@link XMITransformer}</code> implementations should extend this abstract class for convenience.
 * </p>
 * <p>
 * <strong>Thread-safety</strong>: it is mutable, and not thread-safe.
 * </p>
 *
 * @author Standlove, FireIce
 * @version 1.0
 */
public abstract class AbstractXMITransformer implements XMITransformer {

    /**
     * <p>
     * Represents the <code>XMIWriter</code> object this transformer registered to.
     * </p>
     * <p>
     * It is initially null, and initialized in its setter, it is accessed and changed via its getter and setter. It
     * shouldn't be null when the transform is running. This variable could be used in the transform method in certain
     * <code>XMITransformer</code> implementations.
     * </p>
     */
    private XMIWriter xmiWriter;

    /**
     * <p>
     * Constructs an instance of <code>AbstractXMITransformer</code> with xmiWriter field set to null.
     * </p>
     */
    protected AbstractXMITransformer() {
    }

    /**
     * <p>
     * Sets the <code>{@link XMIWriter}</code> object for this transformer.
     * </p>
     *
     * @param xmiWriter
     *            the XMIWriter object this transformer registered to.
     * @throws IllegalArgumentException
     *             if the xmiWriter is <code>null</code>.
     */
    public void setXMIWriter(XMIWriter xmiWriter) {
        Helper.validateObject(xmiWriter, "xmiWriter");

        this.xmiWriter = xmiWriter;
    }

    /**
     * <p>
     * Gets the <code>{@link XMIWriter}</code> object for this transformer.
     * </p>
     *
     * @return the XMIWriter object this transformer registered to.
     */
    public XMIWriter getXMIWriter() {
        return xmiWriter;
    }
}
