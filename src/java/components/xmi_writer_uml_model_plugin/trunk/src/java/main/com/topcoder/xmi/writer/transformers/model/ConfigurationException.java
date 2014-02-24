/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import com.topcoder.util.errorhandling.BaseException;


/**
 * <p>
 * This exception is used to indicate any error in configuration.
 * The error can be internal error in ConfigurationManager component, or invalid configuration value.
 * </p>
 *
 * <p>
 * This exception can be thrown from ReflectedXMIDescription's constructor and Model2XMITransformer's constructor.
 * </p>
 *
 * <p>
 * This class is immutable, thus it is thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class ConfigurationException extends BaseException {
    /**
     * <p>Constructor with error message.</p>
     *
     * @param message the error message.
     */
    public ConfigurationException(String message) {
        super(message);
    }

    /**
     * <p>Constructor with the error message and inner cause.</p>
     *
     * @param message the error message.
     * @param cause the inner cause.
     */
    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
