/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * This exception may be thrown by any message action if the passed Stimulus contains incorrect action
 * instance. Also it will be thrown when there is a problem with getting proper element from transferable
 * parameter. It may also be thrown for unsupported data flavor or transferable not containing the correct
 * model element for concrete action.
 * </p>
 * <p>
 * <b>Thread Safety :</b> Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
public class SequenceConfigurationException extends BaseException {

    /**
     * <p>
     * Creates a new instance of this exception, with a descriptive message.
     * </p>
     *
     * @param message
     *            a descriptive message about the exception. Can be <code>null</code>.
     */
    public SequenceConfigurationException(String message) {
        super(message);
    }

    /**
     * <p>
     * Creates a new instance of this exception, with a descriptive message, and cause of the exception.
     * </p>
     *
     * @param message
     *            a descriptive message about the exception. Can be <code>null</code>.
     * @param cause
     *            the cause of this exception. Can be <code>null</code>.
     */
    public SequenceConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
