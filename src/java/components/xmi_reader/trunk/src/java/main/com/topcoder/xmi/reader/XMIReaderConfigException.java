/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

/**
 * <p>
 * This class represents an exception which occurred while configuring the XMI Reader component. It
 * can be used to wrap other exceptions.
 * </p>
 *
 * @author dplass, magicpig
 * @version 1.0
 */
public class XMIReaderConfigException extends XMIReaderException {
    /**
     * <p>
     * Creates this exception with the given message.
     * </p>
     *
     * @param message the message to associate with this exception. It is required.
     *
     * @throws IllegalArgumentException if message is null or empty after trimmed.
     */
    public XMIReaderConfigException(String message) {
        // leaves the check to super class
        super(message);
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
    public XMIReaderConfigException(String message, Throwable cause) {
        // leaves the checks to super class
        super(message, cause);
    }
}
