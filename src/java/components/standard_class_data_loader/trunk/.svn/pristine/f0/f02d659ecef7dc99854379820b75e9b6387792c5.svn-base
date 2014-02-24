/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * This is an exception and it is thrown whenever there is a problem initializing a data
 * class loader or any classes it relies on.
 * </p>
 *
 * <p>
 * This exception can be thrown from the constructors of implementations of StandardDataClassLoader,
 * or during the initial lazy loading inside the XML loader.
 * </p>
 *
 * <p>
 * Thread Safety : This class is immutable and so thread safety.
 * </p>
 *
 * @author sql_lall, TCSDEVELOPER
 * @version 1.0
 */
public class ClassDataLoaderConfigurationException extends BaseException {
    /**
     * <p>
     * Construct the exception taking a message as to why it was thrown.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from
     * meaningful messages.
     * </p>
     *
     * @param message A descriptive message of why it was thrown.
     */
    public ClassDataLoaderConfigurationException(String message) {
        super(message);
    }

    /**
     * <p>
     * Construct the exception taking a message as to why it was thrown,
     * as well as an original cause.
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
     * @param message A descriptive message of why it was thrown.
     * @param cause The exception or error that originally caused this to be thrown.
     */
    public ClassDataLoaderConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
