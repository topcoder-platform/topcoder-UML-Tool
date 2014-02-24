/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.modelfactory;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * This exception derives from BaseException.
 * </p>
 *
 * <p>
 * It is thrown when the ModelElementFactory cannot create the requested instance.
 * This could be due to reflection issues, sandbox security issues,
 * or something else.
 * </p>
 *
 * <p>
 * Thread Safety : This class is immutable and so thread safety.
 * </p>
 *
 * @author AleaActaEst, biotrail
 * @version 1.0
 */
public class ElementCreationException extends BaseException {
    /**
     * <p>
     * Create an empty instance.
     * </p>
     */
    public ElementCreationException() {
        // empty
    }

    /**
     * <p>
     * Create an  instance initialized with a message.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from
     * meaningful messages.
     * </p>
     *
     * @param message A possibly null, possibly empty (trimmed) error message
     */
    public ElementCreationException(String message) {
        super(message);
    }

    /**
     * <p>
     * Create an  instance initialized with a message and a cause.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from
     * meaningful messages.
     * </p>
     *
     * <p>
     * The cause is the inner exception.
     * </p>
     *
     * @param message A possibly null, possibly empty (trimmed) error message
     * @param cause A possibly null cause exception
     */
    public ElementCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
