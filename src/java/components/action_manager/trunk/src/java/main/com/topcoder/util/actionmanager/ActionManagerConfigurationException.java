/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * This exception is thrown from the constructor of ActionManager when it is initialized with a configuration
 * namespace to read the required configuration properties from the configuration file and the required
 * properties are either found to be missing or found to contain invalid values. It also acts as a wrapper
 * exception over the exception thrown from the Configuration Manager component.
 * </p>
 *
 * <p>
 * Basically this exception indicates that the initialization of ActionManager is not possible because of
 * problems in the configuration file [missing properties or properties with invalid values] or the configuration
 * of the Configuration Manager component.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is immutable and thread safe.
 * </p>
 *
 * @author fastprogrammer, biotrail
 * @version 1.0
 */
public class ActionManagerConfigurationException extends BaseException {
    /**
     * <p>
     * Constructs a new ActionManagerConfigurationException with the given message.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from meaningful messages.
     * </p>
     *
     *
     * @param message the message describing the exception
     */
    public ActionManagerConfigurationException(String message) {
        super(message);
    }

    /**
     * <p>
     * Constructs a new ActionManagerConfigurationException with the given message.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from meaningful messages.
     * </p>
     *
     * <p>
     * The cause is the inner exception.
     * </p>
     *
     * @param message the message describing the exception
     * @param cause the cause of the exception
     */
    public ActionManagerConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
