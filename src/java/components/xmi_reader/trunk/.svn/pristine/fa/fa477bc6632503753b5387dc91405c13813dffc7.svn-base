/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import com.topcoder.util.errorhandling.BaseException;


/**
 * <p>
 * This class represents an exception which occurred in the XMI Reader component. It can be used to
 * wrap other exceptions.
 * </p>
 *
 * @author dplass, magicpig
 * @version 1.0
 */
public class XMIReaderException extends BaseException {
    /**
     * <p>
     * Creates this exception with the given message.
     * </p>
     *
     * @param message the message to associate with this exception. It is required.
     *
     * @throws IllegalArgumentException if message is null or empty after trimmed.
     */
    public XMIReaderException(String message) {
        super(ReaderHelper.validateString(message, "message"));
    }

    /**
     * <p>
     * Creates this exception with the given message and underlying cause.
     * </p>
     *
     * @param message the message to associate with this exception. It is required.
     * @param cause the underlying exception. It is required.
     *
     * @throws IllegalArgumentException if either argument is null or if message is empty after
     *         trimmed.
     */
    public XMIReaderException(String message, Throwable cause) {
        super(ReaderHelper.validateString(message, "message"),
            (Throwable) ReaderHelper.validateNotNull(cause, "cause"));
    }
}
