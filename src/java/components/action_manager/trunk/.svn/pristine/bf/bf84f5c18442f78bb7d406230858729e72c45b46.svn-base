/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

/**
 * <p>
 * This exception extends the ActionExecutionException and is thrown by the redoActions() method of AdvancedUndoManager.
 * </p>
 *
 * <p>
 * This exception is used to indicate that the redo of the UndoableAction's till the passed UndoableAction could not be
 * successfully completed. This could happen when the UndoableAction till which the UndoableAction's have to be re-done
 * is not found to be present with the AdvancedUndoManager.
 * </p>
 *
 * <p>
 * Note that the undo() method of the UndoableAction is not supposed to throw any exception [even runtime exception] and
 * hence this will "not" act as a wrapper exception as the redo() method of UndoableAction does not throw any exception.
 * Also it is worthwhile to note the redoActions() methods of ActionManager will "not" throw this exception as the
 * redoActions() method of ActionManager do not throw any checked exceptions.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is immutable and thread safe.
 * </p>
 *
 * @author fastprogrammer, biotrail
 * @version 1.0
 */
public class RedoActionExecutionException extends ActionExecutionException {
    /**
     * <p>
     * Constructs a new RedoActionExecutionException with the given message.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from meaningful messages.
     * </p>
     *
     *
     * @param message the message describing the exception
     */
    public RedoActionExecutionException(String message) {
        super(message);
    }

    /**
     * <p>
     * Constructs a new RedoActionExecutionException with the given message and cause.
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
    public RedoActionExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
