/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * This exception is thrown by the execute method of the Action interface and re thrown by the executeAction()
 * method of the ActionManager class.
 * </p>
 *
 * <p>
 * This exception primarily indicates that there was a problem in the execution of the Action and that the
 * execution of the Action could not be completed.
 * The exception is also thrown by the Action, if the Action determines that it cannot be executed at that
 * point in time [may be not having access to the required resources] or its execution could lead to problems.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is immutable and thread safe.
 * </p>
 *
 * @author fastprogrammer, biotrail
 * @version 1.0
 */
public class ActionExecutionException extends BaseException {
    /**
     * <p>
     * Constructs a new ActionExecutionException with the given message.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from meaningful messages.
     * </p>
     *
     * @param message the message describing the exception
     */
    public ActionExecutionException(String message) {
        super(message);
    }

    /**
     * <p>
     * Constructs a new ActionExecutionException with the given message and cause.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from meaningful messages.
     * </p>
     *
     * <p>
     * The cause is the inner exception.
     * </p>
     *
     * @param message the message describing the exception
     * @param cause the cause of the exception
     */
    public ActionExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
