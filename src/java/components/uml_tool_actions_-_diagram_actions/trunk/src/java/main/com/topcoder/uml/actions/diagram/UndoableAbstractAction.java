/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import javax.swing.undo.UndoableEdit;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.log.Level;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

/**
 * <p>
 * This class is an abstract implementation of <code>UndoableAction</code>.
 * </p>
 *
 * <p>
 * It applies the template pattern to provide undoable functionalities for its subclass.And it will log the
 * execute/undo/redo actions in INFO level and log the exceptions in ERROR level.
 * </p>
 *
 * <p>
 * The application will call <code>execute</code>, <code>redo</code>, <code>undo</code> and others methods to interact
 * with this class.
 * </p>
 *
 * <p>
 * Note that the class is package private.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b>
 * This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, TCSDEVELOPER
 * @version 1.0
 */
abstract class UndoableAbstractAction implements UndoableAction {

    /**
     * <p>
     * Represents the state of the action.
     * </p>
     *
     * <p>
     * This variable is set to ActionState.UNEXECUTED, is mutable and never be null.
     * </p>
     *
     * <p>
     * This variable is referenced in the canRedo, canUndo, die, redo, undo and execute methods.
     * </p>
     */
    private ActionState state = ActionState.UNEXECUTED;

    /**
     * <p>
     * Represents a localized, human readable description of this edit suitable for use in.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference) and never be null and never be empty.
     * </p>
     *
     * <p>
     * This variable is referenced in the <code>getPresentationName</code>, <code>getRedoPresentationName</code>,
     * <code>getUndoPresentationName</code>  and <code>execute()</code> methods.
     * </p>
     */
    private final String presentationName;

    /**
     * <p>
     * Represents the logger used by this component.
     * </p>
     *
     * <p>
     * This variable is set to a LogFactory.getLog(getClass().getName()), is immutable (the reference) and never be
     * null.
     * </p>
     *
     * <p>
     * This variable is referenced in the <code>log(Level, String)</code> method.
     * </p>
     */
    private final Log log = LogFactory.getLog(getClass().getName());

    /**
     * <p>
     * Constructor of the undoable action.
     * </p>
     *
     * <p>
     * The presentationName should not be null or empty.
     * </p>
     *
     * @param presentationName A string representing the presentation name.
     *
     * @throws IllegalArgumentException if presentationName is null or empty
     */
    protected UndoableAbstractAction(String presentationName) {
        Helper.checkString(presentationName, "presentationName");
        this.presentationName = presentationName;
    }

    /**
     * <p>
     * This UndoableEdit should absorb anEdit if it can. Returns true if has been incorporated, false if it has not.
     * </p>
     *
     * @param anEdit the undoable edit to be added
     *
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
     * <p>
     * If the state is REDOABLE, return true; otherwise return false.
     * </p>
     *
     * @return True if it is still possible to redo this operation, otherwise false.
     */
    public boolean canRedo() {
        return state == ActionState.REDOABLE;
    }

    /**
     * <p>
     * True if it is still possible to undo this operation.
     * </p>
     *
     * <p>
     * If the state is UNDOABLE, return true; otherwise return false.
     * </p>
     *
     * @return True if it is still possible to undo this operation, otherwise false.
     */
    public boolean canUndo() {
        return state == ActionState.UNDOABLE;
    }

    /**
     * <p>
     * May be sent to inform an edit that it should no longer be used.
     * </p>
     *
     * <p>
     * Set the state to DIED.
     * </p>
     */
    public void die() {
        state = ActionState.DIED;
    }

    /**
     * <p>
     * Provides a human readable description of this edit suitable for use in, say, a change log.
     * </p>
     *
     * @return the non null, non empty description
     */
    public String getPresentationName() {
        return presentationName;
    }

    /**
     * <p>
     * Provides a human readable description of the redoable form of this edit, e.g. for use as a Redo menu item.
     * </p>
     *
     * @return the non null, non empty description
     */
    public String getRedoPresentationName() {
        return "Redo " + presentationName;
    }

    /**
     * <p>
     * Provides a human readable description of the undoable form of this edit, e.g. for use as an Undo menu item.
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
     * Returns true if this <code>UndoableEdit</code> should replace anEdit.
     * </p>
     *
     * <p>
     * The receiver should incorporate anEdit's state before returning true.
     * </p>
     *
     * @param anEdit the undoable edit to be replaced
     *
     * @return always false
     */
    public boolean replaceEdit(UndoableEdit anEdit) {
        return false;
    }

    /**
     * <p>
     * Logs the message as INFO Level.
     * </p>
     *
     * @param message the possible null, possible empty message
     */
    protected void log(String message) {
        log(Level.INFO, message);
    }

    /**
     * <p>
     * Logs the message as ERROR Level.
     * </p>
     *
     * @param message the possible null, possible empty message
     */
    protected void logError(String message) {
        log(Level.ERROR, message);
    }

    /**
     * <p>
     * Logs the message with given level.
     * </p>
     *
     * @param level the non null level
     * @param message the possible null, possible empty message
     *
     * @throws IllegalArgumentException if the level is null
     */
    protected void log(Level level, String message) {
        Helper.checkNotNull(level, "The level");
        log.log(level, message);
    }

    /**
     * <p>
     * Re-applies the edit, assuming that it has been undone.
     * </p>
     *
     * <p>
     * No exceptions will be thrown. All the exceptions will be logged in ERROR level.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            state = ActionState.UNDOABLE;
            try {
                redoAction();
            } catch (UndoableActionException e) {
                logError(e.getMessage());
                return;
            }
            log(getRedoPresentationName());
        } else {
            logError("Can't " + getRedoPresentationName() + " current state is " + state);
        }
    }

    /**
     * <p>
     * Undoes the edit that was made.
     * </p>
     *
     * <p>
     * No exceptions will be thrown. All the exceptions will be logged in ERROR level.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            state = ActionState.REDOABLE;
            try {
                undoAction();
            } catch (UndoableActionException e) {
                logError(e.getMessage());
                return;
            }
            log(getUndoPresentationName());
        } else {
            logError("Can't " + getUndoPresentationName() + " current state is " + state);
        }
    }

    /**
     * <p>
     * Executes this auction.
     * </p>
     *
     * <p>
     * An ActionExecutionException will be thrown if the action has already been executed or fails to execute.
     * </p>
     *
     * @throws ActionExecutionException if the action has already been executed or failed to execute the action.
     */
    public void execute() throws ActionExecutionException {
        if (state == ActionState.UNEXECUTED) {
            state = ActionState.UNDOABLE;
            try {
                executeAction();
            } catch (ActionExecutionException e) {
                logError(e.getMessage());
                throw e;
            }
            log(presentationName);
        } else {
            logError("Can't execute " + presentationName + " current state is " + state);
            throw new ActionExecutionException("The action have already been executed");
        }
    }

    /**
     * <p>
     * The method actually undo the edit that was made.
     * </p>
     *
     * @throws UndoableActionException any exception prevents this methods from completing successfully
     */
    protected abstract void undoAction() throws UndoableActionException;

    /**
     * <p>
     * The method actually redo the edit.
     * </p>
     *
     * @throws UndoableActionException any exception prevents this methods from completing successfully
     */
    protected abstract void redoAction() throws UndoableActionException;

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     *
     * @throws ActionExecutionException if any exception prevents this method from completing successfully
     */
    protected abstract void executeAction() throws ActionExecutionException;

    /**
     * <p>
     * This class is an enumeration which representing the state of the undoable action.
     * </p>
     *
     * <p>
     * <b>Thread Safety:</b>
     * This class is thread safe by being immutable.
     * </p>
     *
     * @author kinzz, TCSDEVELOPER
     * @version 1.0
     */
    private enum ActionState {
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
}
