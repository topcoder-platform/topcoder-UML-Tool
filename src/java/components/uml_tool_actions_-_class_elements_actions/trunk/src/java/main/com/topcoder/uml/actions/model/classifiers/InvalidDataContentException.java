/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * This exception may be thrown in two situations: when data in transferable
 * object is incorrect or when we use incorrect utility class for current
 * element. Also it may be thrown by each constructor of exception actions, if
 * given Class instance has no "exception" stereotype.
 * </p>
 * <p>
 * Thread-safety: Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class InvalidDataContentException extends BaseException {

    /**
     * <p>
     * Constructor which create exception with given text message.
     * </p>
     *
     * @param message
     *            the message to associate with this exception
     */
    public InvalidDataContentException(String message) {
        super(message);
    }

    /**
     * <p>
     * Constructor which create exception with given text message and underlying
     * cause.
     * </p>
     *
     * @param message
     *            the message to associate with this exception
     * @param cause
     *            the underlying exception
     */
    public InvalidDataContentException(String message, Throwable cause) {
        super(message, cause);
    }
}