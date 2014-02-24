/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * This exception will be thrown by all the <code>undoAction</code> and <code>redoAction</code> methods in subclasses
 * of <code>UndoableAbstractAction</code> when the redo/undo action can't complete successfully.
 * </p>
 *
 * <p>
 * This exception will be created and thrown by all the subclasses of <code>UndoableAbstractAction</code> when their
 * redo/undo actions can't complete successfully.
 * </p>
 *
 * <p>
 * Note that this exception is package private and will be exposed to the <code>UndoableAbstractAction</code>'s
 * redo/undo methods.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b>
 * This exception is thread safe by having no state information.
 * </p>
 *
 * @author kinzz, TCSDEVELOPER
 * @version 1.0
 */
class UndoableActionException extends BaseException {

    /**
     * <p>
     * Constructs the exception from the specified message.
     * </p>
     *
     * @param message A possibly null, possibly empty (trim'd) error message
     */
    UndoableActionException(String message) {
        super(message);
    }

    /**
     * <p>
     * Constructs the exception from the specified message and cause.
     * </p>
     *
     * @param message A possibly null, possibly empty (trim'd) error message
     * @param cause A possibly null cause exception
     */
    UndoableActionException(String message, Throwable cause) {
        super(message, cause);
    }
}
