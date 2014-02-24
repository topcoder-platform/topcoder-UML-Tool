/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * This is the base exception for all custom exceptions defined in this component, like following.
 * <ul>
 * <li><code>{@link ElementAlreadyExistsException}</code></li>
 * <li><code>{@link UnknownElementException}</code></li>
 * <li><code>{@link XMITransformException}</code></li>
 * </ul>
 * </p>
 *
 * @author Standlove, FireIce
 * @version 1.0
 */
public class XMIWriterException extends BaseException {

    /**
     * serial version unique id.
     */
    private static final long serialVersionUID = 3558462388559232204L;

    /**
     * <p>
     * Constructs an <code>{@link XMIWriterException}</code> object with the error message.
     * </p>
     *
     * @param message
     *            the error message.
     */
    public XMIWriterException(String message) {
        super(message);
    }

    /**
     * <p>
     * Constructs an <code>{@link XMIWriterException}</code> object with the error message and the inner cause.
     * </p>
     *
     * @param message
     *            the error message.
     * @param cause
     *            the inner cause.
     */
    public XMIWriterException(String message, Throwable cause) {
        super(message, cause);
    }
}
