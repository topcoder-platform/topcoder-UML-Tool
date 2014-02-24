/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.actions.general;

import javax.swing.undo.UndoableEdit;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.log.Level;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

/**
 * <p>
 * This class is an implementation of UndoableAction. It applies the template pattern to provide undoable
 * functionalities for its subclass.
 * </p>
 * <p>
 * The application will call execute, redo, undo and others methods to interact with this class.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, rainday
 * @version 1.0
 */
public abstract class UndoableAbstractAction implements UndoableAction {
    /**
     * <p>
     * This class is an enumeration which representing the state of the undoable action.
     * </p>
     * <p>
     * <b>Thread Safety</b>: This class is thread safe by being immutable.
     * </p>
     */
    enum ActionState {
        /**
         * <p>
         * Represents the unexecuted state of the undoable action. In this state, the action can only execute.
         * </p>
         */
        UNEXECUTED,

        /**
         * <p>
         * Represents the redoable state of the undoable action. In this state, the action can only redo.
         * </p>
         */
        REDOABLE,

        /**
         * <p>
         * Represents the undoable state of the undoable action. In this state, the action can only undo.
         * </p>
         */
        UNDOABLE,

        /**
         * <p>
         * Represents the died state of the undoable action. In this state, the action can perform no action.
         * </p>
         */
        DIED;
    }

    /**
     * <p>
     * Represents the state of the the action. This variable is set to ActionState.UNEXECUTED, is mutable and never
     * be null. This variable is referenced in the canRedo, canUndo, die, redo, undo and execute methods.
     * </p>
     */
    private ActionState state = ActionState.UNEXECUTED;

    /**
     * <p>
     * Represents a localized, human readable description of this edit suitable for use in. This variable is set in
     * the constructor, is immutable (the reference) and never be null and empty(trim'd). This variable is
     * referenced in the getPresentationName, getRedoPresentationName and getUndoPresentationName methods.
     * </p>
     */
    private final String presentationName;

    /**
     * <p>
     * Represents the logger used by this component. This variable is set to a
     * LogFactory.getLog(getClass().getName()), is immutable (the reference) and never be null. This variable is
     * referenced in the log, logError methods.
     * </p>
     */
    private final Log log = LogFactory.getLog(getClass().getName());

    /**
     * <p>
     * Constructor of the undoable action.
     * </p>
     *
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     * @throws IllegalArgumentException
     *             if presentationName is null or empty
     */
    protected UndoableAbstractAction(String presentationName) {
        Helper.checkNotNullAndNotEmpty(presentationName, "presentationName");
        this.presentationName = presentationName;
    }

    /**
     * <p>
     * This UndoableEdit should absorb anEdit if it can. Always return false.
     * </p>
     *
     * @param anEdit
     *            the undoable edit to be added
     * @return always false
     */
    public boolean addEdit(UndoableEdit anEdit) {
        return false;
    }

    /**
     * <p>
     * True if it is still possible to redo this operation.
     * </p>
     *
     * @return True if it is still possible to redo this operation, otherwise false.
     */
    public boolean canRedo() {
        return (state == ActionState.REDOABLE);
    }

    /**
     * <p>
     * True if it is still possible to undo this operation.
     * </p>
     *
     * @return True if it is still possible to undo this operation, otherwise false.
     */
    public boolean canUndo() {
        return (state == ActionState.UNDOABLE);
    }

    /**
     * <p>
     * May be sent to inform an edit that it should no longer be used.
     * </p>
     */
    public void die() {
        state = ActionState.DIED;
    }

    /**
     * <p>
     * Provides a localized, human readable description of this edit suitable for use in, say, a change log.
     * </p>
     *
     * @return the non null, non empty description
     */
    public String getPresentationName() {
        return presentationName;
    }

    /**
     * <p>
     * Provides a localized, human readable description of the redoable form of this edit, e.g. for use as a Redo
     * menu item. Typically derived from getPresentationName.
     * </p>
     *
     * @return the non null, non empty description
     */
    public String getRedoPresentationName() {
        return "Redo " + presentationName;
    }

    /**
     * <p>
     * Provides a localized, human readable description of the undoable form of this edit, e.g. for use as an Undo
     * menu item. Typically derived from getDescription.
     * </p>
     *
     * @return the non null, non empty description
     */
    public String getUndoPresentationName() {
        return "Undo " + presentationName;
    }

    /**
     * <p>
     * Returns false if this edit is insignificant.
     * </p>
     *
     * @return always true
     */
    public boolean isSignificant() {
        return true;
    }

    /**
     * <p>
     * Returns true if this UndoableEdit should replace anEdit. Always return false.
     * </p>
     *
     * @param anEdit
     *            the undoable edit to be replaced
     * @return always false
     */
    public boolean replaceEdit(UndoableEdit anEdit) {
        return false;
    }

    /**
     * <p>
     * Log the message as INFO.
     * </p>
     *
     * @param message
     *            A possibly null, possibly empty (trim'd) message to log
     */
    public void log(String message) {
        log.log(Level.INFO, message);
    }

    /**
     * <p>
     * Log the message as ERROR.
     * </p>
     *
     * @param message
     *            A possibly null, possibly empty (trim'd) message to log
     */
    public void logError(String message) {
        log.log(Level.ERROR, message);
    }

    /**
     * <p>
     * Log the message with given level.
     * </p>
     *
     * @param level
     *            A non-null level to use
     * @param message
     *            A possibly null, possibly empty (trim'd) message to log
     * @throws IllegalArgumentException
     *             if the level is null
     */
    public void log(Level level, String message) {
        Helper.checkNotNull(level, "level");
        log.log(level, message);
    }

    /**
     * <p>
     * Re-apply the edit, assuming that it has been undone.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            state = ActionState.UNDOABLE;
            redoAction();
            log.log(Level.INFO, getRedoPresentationName());
        } else {
            log.log(Level.ERROR, "Can't " + getRedoPresentationName() + ", current state is " + state.toString());
        }
    }

    /**
     * <p>
     * Undo the edit that was made.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            state = ActionState.REDOABLE;
            undoAction();
            log.log(Level.INFO, getUndoPresentationName());
        } else {
            log.log(Level.ERROR, "Can't " + getUndoPresentationName() + ", current state is " + state.toString());
        }
    }

    /**
     * <p>
     * Execute this auction.
     * </p>
     *
     * @throws ActionExecutionException
     *             if the action have already been executed or it is thrown by the executeAction
     */
    public void execute() throws ActionExecutionException {
        if (state == ActionState.UNEXECUTED) {
            state = ActionState.UNDOABLE;
            executeAction();
            log.log(Level.INFO, getPresentationName());
        } else {
            log.log(Level.ERROR, "Can't execute " + getPresentationName() + ", current state is "
                + state.toString());
            throw new ActionExecutionException("The action have already been executed.");
        }
    }

    /**
     * <p>
     * The method actually undo the edit that was made. If any exception prevents redo/undo methods from completing
     * successfully, it should be log with logError.
     * </p>
     */
    public abstract void undoAction();

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully,
     * it should be log with logError.
     * </p>
     */
    public abstract void redoAction();

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     *
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public abstract void executeAction() throws ActionExecutionException;
}
