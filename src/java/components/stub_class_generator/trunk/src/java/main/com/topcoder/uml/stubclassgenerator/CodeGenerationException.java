/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import com.topcoder.util.errorhandling.BaseException;


/**
 * <p>
 * The base exception for other exceptions used in this component.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CodeGenerationException extends BaseException {
    /**
     * <p>
     * Creates a new {@link CodeGenerationException} with given text message.
     * </p>
     *
     * @param message
     *            the message to be associated with this
     *            {@link CodeGenerationException}
     */
    public CodeGenerationException(String message) {
        super(message);
    }

    /**
     * <p>
     * Creates a new {@link CodeGenerationException} with given text message and
     * underlying cause.
     * </p>
     *
     * @param message
     *            the message to be associated with this
     *            {@link CodeGenerationException}
     * @param cause
     *            the underlying exception
     */
    public CodeGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}
