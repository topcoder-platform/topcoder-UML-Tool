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
 * It will be thrown by the two ModelElementFactory constructors if there
 * are issues with configuration (i.e. wrong format or missing variables)
 * or if Configuration Manager thrown ConfigManagerException.
 * </p>
 *
 * <p>
 * Thread Safety : This class is immutable and so thread safety.
 * </p>
 *
 * @author AleaActaEst, biotrail
 * @version 1.0
 */
public class ConfigurationException extends BaseException {

    /**
     * <p>
     * Create an empty instance.
     * </p>
     */
    public ConfigurationException() {
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
    public ConfigurationException(String message) {
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
    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

}
