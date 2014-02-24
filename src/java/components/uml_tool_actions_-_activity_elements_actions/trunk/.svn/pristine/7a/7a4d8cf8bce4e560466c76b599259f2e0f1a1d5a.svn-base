/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import com.topcoder.util.log.Level;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

import javax.swing.undo.AbstractUndoableEdit;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * This abstract class implements the UndoableAction interface and extends the AbstractUndoableEdit abstract class.
 * </p>
 *
 * <p>
 * It is used as the base class for all the undoable actions, it also provides a logging method that
 * could be used by its subclasses to log the exceptions raised in the redo/undo methods, and its name attribute
 * is used as the action's presentation name.
 * </p>
 *
 * <p>
 * Thread Safety: This class is immutable and thread-safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public abstract class AbstractActivityUndoableAction extends AbstractUndoableEdit implements UndoableAction {
    /**
     * <p>
     * Represents the presentation name of the undoable action.
     * </p>
     *
     * <p>
     * Accessed by its getter (getPresentationName method).
     * It is also used to get the Log object from LogFactory in constructor.
     * </p>
     *
     * <p>
     * Initialized in the constructor, and never changed afterwards.
     * Must be non-null, non-empty string.
     * </p>
     */
    private final String name;

    /**
     * <p>
     * Represents the Log object to log the exceptions, used in the logException method.
     * </p>
     *
     * <p>
     * Initialized in the constructor, and never changed afterwards. Must be non-null.
     * </p>
     */
    private final Log logger;

    /**
     * <p>
     * Construct an AbstractActivityUndoableAction with name specified.
     * </p>
     *
     * @param name the presentation name of the undoable action
     *
     * @throws IllegalArgumentException if the argument is null or empty string
     */
    protected AbstractActivityUndoableAction(String name) {
        Util.checkString(name, "name");

        this.name = name;
        this.logger = LogFactory.getLog(name);
    }

    /**
     * <p>
     * Log the error message and the exception.
     * </p>
     *
     * <p>
     * Note, the message could be null or empty string, in this case, it is simply ignored.
     * </p>
     *
     * <p>
     * The given message and the stack trace of the given exception are logged using the
     * Level.ERROR level.
     * </p>
     *
     * @param message the error message to log, can be null or empty
     * @param exception the exception to log
     *
     * @throws IllegalArgumentException if the exception argument is null
     */
    protected void logException(String message, Throwable exception) {
        Util.checkNull(exception, "exception");

        // log the exception stack trace
        StringWriter writer = new StringWriter();

        if (message != null && message.trim().length() != 0) {
            writer.write(message + "\n");
        }

        writer.write("Track Information : \n");
        exception.printStackTrace(new PrintWriter(writer));

        logger.log(Level.ERROR, writer.toString());
    }

    /**
     * <p>
     * Return the presentation name of the action.
     * </p>
     *
     * @return the presentation name of the action
     */
    public String getPresentationName() {
        return this.name;
    }

    /**
     * <p>
     * Redo the action.
     * </p>
     *
     * <p>
     * Note, all exceptions thrown except the CannotRedoException will be logged.
     * </p>
     *
     * @throws CannotRedoException if canRedo returns false
     */
    public void redo() {
        super.redo();

        try {
            execute();
        } catch (ActionExecutionException e) {
            logException("ActionExecutionException thrown in the redo method.", e);
        }
    }
}
