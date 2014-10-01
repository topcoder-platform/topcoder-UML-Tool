/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.util.errorhandling.BaseException;


/**
 * <p>
 * This exception is used to indicate the configuration errors.
 * Or some required properties are not configured.
 * </p>
 *
 * <p>
 * It can be thrown from the constructor of <code>PropertyMapping</code>.
 * </p>
 *
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class ConfigurationException extends BaseException {
    /**
     * <p>
     * Creates a new instance of <code>ConfigurationException</code> class with a detail error message.
     * </p>
     *
     * @param message - error message
     */
    public ConfigurationException(String message) {
        super(message);
    }

    /**
     * <p>
     * Creates a new instance of <code>ConfigurationException</code> class with a detail error message and the
     * original exception causing the error.
     * </p>
     *
     * @param message - error message
     * @param cause - the inner cause of this exception.
     */
    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
