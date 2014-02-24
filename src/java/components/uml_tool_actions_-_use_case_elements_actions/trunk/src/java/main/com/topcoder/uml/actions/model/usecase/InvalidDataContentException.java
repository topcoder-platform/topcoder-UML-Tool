/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.util.errorhandling.BaseException;


/**
 * <p>
 * This exception may be thrown in two situation when data in transferable object  is incorrect or when we use
 * incorrect utility class for current element
 * </p>
 *
 * <p>
 * Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class InvalidDataContentException extends BaseException {
    /**
     * <p>
     * constructor which create exception with given text message.
     * </p>
     *
     * @param message the message to associate with this exception
     */
    public InvalidDataContentException(String message) {
        super(message);
    }

    /**
     * <p>
     * Constructor which create exception with given text message and underlying cause.
     * </p>
     *
     * @param message the message to associate with this exception
     * @param cause the underlying exception
     */
    public InvalidDataContentException(String message, Throwable cause) {
        super(message, cause);
    }
}
