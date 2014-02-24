/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

/**
 * <p>
 * This exception is thrown by the <code>{@link XMIWriter}</code> and <code>{@link XMITransformer}</code>
 * implementations if there is no xmi id defined for the requested element object.
 * </p>
 *
 * @author Standlove, FireIce
 * @version 1.0
 */
public class UnknownElementException extends XMIWriterException {

    /**
     * serial version unique id.
     */
    private static final long serialVersionUID = -1708385929212716842L;
    /**
     * <p>
     * Represents the element object that has no xmi id defined.
     * </p>
     * <p>
     * Initialized in the constructor and would never be changed afterwards. Can be null.
     * </p>
     */
    private final Object element;

    /**
     * <p>
     * Constructs an <code>{@link UnknownElementException}</code> object with the error message and the element object
     * that has no xmi id defined.
     * </p>
     *
     * @param message
     *            the error message.
     * @param element
     *            the element object that has no xmi id defined, can be null, but not recommended.
     */
    public UnknownElementException(String message, Object element) {
        super(message);
        this.element = element;
    }

    /**
     * <p>
     * Gets the element object that has no xmi id defined.
     * </p>
     *
     * @return the element object that has no xmi id defined.
     */
    public Object getElement() {
        return element;
    }
}
