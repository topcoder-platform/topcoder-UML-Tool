/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * The <code>ConfigurationException</code> exception is used to wrap any specific exception or indicate any errors
 * when there are required properties missing or invalid value in configuration file. These exceptions are thrown by the
 * <code>PrintManager</code> class when in the constructor.
 * </p>
 * <p>
 * This class is thread safe since it is immutable.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class DeployConfigException extends BaseException {

    /**
     * <p>
     * Creates a new <code>ConfigurationException</code> with given error message.
     * </p>
     * @param message
     *            the error message of this exception
     */
    public DeployConfigException(String message) {
        super(message);
    }

    /**
     * <p>
     * Creates a new <code>ConfigurationException</code> with given error message and inner cause.
     * </p>
     * @param message
     *            the error message of this exception
     * @param cause
     *            the inner cause of this exception
     */
    public DeployConfigException(String message, Throwable cause) {
        super(message, cause);
    }
}
