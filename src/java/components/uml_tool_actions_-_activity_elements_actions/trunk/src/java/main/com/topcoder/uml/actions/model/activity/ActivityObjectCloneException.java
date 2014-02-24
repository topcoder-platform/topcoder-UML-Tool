/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * ActivityObjectCloneException class extends the ActionExecutionException class,
 * and this exception is used if the the clone operation of activity objects fails.
 * </p>
 *
 * <p>
 * Thread Safety: This class is immutable and so is thread safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class ActivityObjectCloneException extends ActionExecutionException {
    /**
     * <p>
     * Constructor with error message.
     * </p>
     *
     * @param message the error message.
     */
    public ActivityObjectCloneException(String message) {
        super(message);
    }

    /**
     * <p>
     * Constructor with error message and inner cause.
     * </p>
     *
     * @param message the error message
     * @param cause the inner cause
     */
    public ActivityObjectCloneException(String message, Throwable cause) {
        super(message, cause);
    }
}
