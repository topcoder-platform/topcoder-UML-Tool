/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import com.topcoder.util.errorhandling.BaseRuntimeException;


/**
 * <p>
 * This is a custom exception, which describes configuration errors.
 * If the default values loading functions will get a problem, then
 * this exception will throw. The inner exceptions from ConfigManager
 * are chained by this exception too.
 * </p>
 *
 * <p>
 * The message passed in the constructor should be something meaningful
 * to help the user to find the problem. In addition to the message,
 * the actual exception (if any) is passed to the user.
 * </p>
 *
 * <p>
 * Thread-Safety: This class is thread safe as its super class is also thread safe.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class SequenceElementsConfigurationException extends BaseRuntimeException {
    /**
     * <p>
     * The empty constructor. Simply create an instance without any additional actions.
     * </p>
     */
    public SequenceElementsConfigurationException() {
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
    public SequenceElementsConfigurationException(String message) {
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
     * @param exception The exception or error that originally caused this to be thrown.
     */
    public SequenceElementsConfigurationException(String message,
        Exception exception) {
        super(message, exception);
    }
}
