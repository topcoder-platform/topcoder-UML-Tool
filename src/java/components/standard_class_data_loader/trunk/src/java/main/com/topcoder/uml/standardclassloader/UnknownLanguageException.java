/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * This is an exception and it is thrown whenever a language is passed to a
 * standard loader, which can not be recognized by the loader.
 * </p>
 *
 * <p>
 * This is raised while loading the namespaces in StandardDataClassLoader class,
 * and any of its implementations, for whenever the required language is unknown.
 * </p>
 *
 * <p>
 * Thread Safety : This class is immutable and so thread safety.
 * </p>
 *
 * @author sql_lall, TCSDEVELOPER
 * @version 1.0
 */
public class UnknownLanguageException extends BaseException {
    /**
     * <p>
     * Construct a new exception, giving a message detailing which language was not known.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from
     * meaningful messages.
     * </p>
     *
     * @param message Message to attach to exception.
     */
    public UnknownLanguageException(String message) {
        super(message);
    }
}
