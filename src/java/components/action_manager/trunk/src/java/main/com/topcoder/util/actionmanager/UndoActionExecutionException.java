/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

/**
 * <p>
 * This exception extends the ActionExecutionException and is thrown by the undoActions() method of AdvancedUndoManager.
 * </p>
 *
 * <p>
 * This exception is used to indicate that the undo of the UndoableAction's till the passed UndoableAction could not be
 * successfully completed. This could happen when the UndoableAction till which the UndoableAction's have to be un-done
 * is not found to be present with the AdvancedUndoManager.
 * </p>
 *
 * <p>
 * Note that the undo() method of the UndoableAction is not supposed to throw any exception [even runtime exception]
 * and hence this will "not" act as a wrapper exception as the undo() method of UndoableAction does not throw any
 * exception. Also it is worthwhile to note the undoActions() methods of ActionManager will "not" throw this exception
 * as the undoActions() method of ActionManager do not throw any checked exceptions.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is immutable and thread safe.
 * </p>
 *
 * @author fastprogrammer, biotrail
 * @version 1.0
 */
public class UndoActionExecutionException extends ActionExecutionException {
    /**
     * <p>
     * Constructs a new UndoActionExecutionException with the given message.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from meaningful messages.
     * </p>
     *
     * @param message the message describing the exception
     */
    public UndoActionExecutionException(String message) {
        super(message);
    }

    /**
     * <p>
     * Constructs a new UndoActionExecutionException with the given message and cause.
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
    public UndoActionExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
