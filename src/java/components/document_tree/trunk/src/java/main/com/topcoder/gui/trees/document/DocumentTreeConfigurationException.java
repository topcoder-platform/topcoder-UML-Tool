/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import com.topcoder.util.errorhandling.BaseRuntimeException;

/**
 * <p>
 * This exception is thrown to indicate an error on configuration issues.
 * </p>
 *
 * <p>
 * It is shown as a runtime exception because classes are created and
 * configured many times during the operation of the GUI and hence we
 * cannot thrown a non-runtime exception.
 * </p>
 *
 * <p>
 * Thread Safety: This class is thread safe as it has no state and its
 * base class is thread safe.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public class DocumentTreeConfigurationException extends BaseRuntimeException {
    /**
     * <p>
     * Constructs this exception without an error message or cause.
     * </p>
     */
    public DocumentTreeConfigurationException() {
        // empty
    }

    /**
     * <p>
     * Constructs the exception taking a message as to why it was thrown.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from
     * meaningful messages.
     * </p>
     *
     * @param message A descriptive message of why it was thrown.
     */
    public DocumentTreeConfigurationException(String message) {
        super(message);
    }

    /**
     * <p>
     * Constructs the exception taking a message as to why it was thrown,
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
    public DocumentTreeConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
