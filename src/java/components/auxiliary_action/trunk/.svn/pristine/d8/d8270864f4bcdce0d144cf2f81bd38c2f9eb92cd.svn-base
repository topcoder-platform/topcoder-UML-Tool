/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.log.Level;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

/**
 * <p>
 * This abstract class implements the <code>UndoableAction</code> interface and extends the
 * <code>AbstractUndoableEdit</code> abstract class.
 * </p>
 * <p>
 * It is used as the base class for all the undoable actions in this design, it also provides
 * a logging method that could be used by its subclasses to log the exceptions raised in the
 * redo/undo methods, and its name attribute is used as the action's presentation name.
 * </p>
 * <p>
 * Thread-safety: This class is immutable and thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public abstract class AbstractAuxiliaryUndoableAction extends AbstractUndoableEdit implements UndoableAction {
    /**
     * <p>
     * Represents the <code>Log</code> object to log the exceptions, used in the
     * <code>logException</code> method.
     * </p>
     */
    private final Log logger;

    /**
     * <p>
     * Represents the presentation name of the undoable action, accessed by its
     * getter (getPresentationName method).
     * </p>
     * <p>
     * It is also used to get the <code>Log</code> object from <code>LogFactory</code>
     * in constructor.
     * </p>
     */
    private final String name;

    /**
     * <p>
     * Create a new <code>AbstractAuxiliaryUndoableAction</code> with the given
     * presentation name.
     * </p>
     * @param name the presentation name of the action
     * @throws IllegalArgumentException If name is null or empty string.
     */
    protected AbstractAuxiliaryUndoableAction(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null!");
        }
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("name cannot be empty!");
        }
        this.name = name;
        this.logger = LogFactory.getLog(name);
    }

    /**
     * <p>
     * Log the error message and the exception.
     * </p>
     * <p>
     * Note that the message could be null or empty string, in this case,
     * it is simply ignored.
     * </p>
     * @param message
     *            the error message to log
     * @param exception
     *            the exception to log.
     * @throws IllegalArgumentException If the exception is null.
     */
    protected void logException(String message, Throwable exception) {
        if (exception == null) {
            throw new IllegalArgumentException("exception cannot be null!");
        }
        if (message != null && message.trim().length() != 0) {
            this.logger.log(Level.ERROR, message);
        }
        this.logger.log(Level.ERROR, formatException(exception));
    }

    /**
     * <p>
     * Return the presentation name of the action.
     * </p>
     * @return the presentation name of the action.
     */
    public String getPresentationName() {
        return this.name;
    }

    /**
     * <p>
     * Redo the action.
     * </p>
     * <p>
     * Note that exceptions except <code>CannotRedoException</code> will be logged.
     * </p>
     * @throws CannotRedoException If <code>canRedo</code> returns <code>false</code>.
     */
    public void redo() {
        super.redo();
        try {
            this.execute();
        } catch (ActionExecutionException e) {
            this.logException("ActionExecutionException is caught while trying to redo the action!", e);
        }
    }

    /**
     * <p>
     * Format the given exception, the the error message and the stack trace will be in the formatted
     * string.
     * </p>
     * @param t the exception.
     * @return The formatted exception string.
     */
    private static String formatException(Throwable t) {
        StringWriter writer = new StringWriter();
        t.printStackTrace(new PrintWriter(writer));
        return writer.toString();
    }
}
