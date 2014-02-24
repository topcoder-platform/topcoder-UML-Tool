/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Mock subclass of <code>UndoableAbstractAction</code>. It is used for testing <code>UndoableAbstractAction</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockUndoableAbstractAction extends UndoableAbstractAction {

    /**
     * <p>
     * UndoableActionException for undoAction.
     * </p>
     */
    private UndoableActionException undoException;

    /**
     * <p>
     * UndoableActionException for redoAction.
     * </p>
     */
    private UndoableActionException redoException;

    /**
     * <p>
     * ActionExecutionException for executeAction.
     * </p>
     */
    private ActionExecutionException executeException;

    /**
     * <p>
     * Boolean indicating that a UndoableActionException for undoAction should be thrown or not.
     * </p>
     */
    private boolean isThrowUndoException;

    /**
     * <p>
     * Boolean indicating that a UndoableActionException for redoAction should be thrown or not.
     * </p>
     */
    private boolean isThrowRedoException;


    /**
     * <p>
     * Boolean indicating that a ActionExecutionException for executeAction should be thrown or not.
     * </p>
     */
    private boolean isThrowExecuteException;

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
    protected MockUndoableAbstractAction(String presentationName) {
        super(presentationName);
    }

    /**
     * <p>
     * The method actually undo the edit that was made.
     * </p>
     *
     * <p>
     * Throw an UndoableActionException if isThrowUndoException is true.
     * </p>
     *
     * @throws UndoableActionException any exception prevents this methods from completing successfully
     */
    protected void undoAction() throws UndoableActionException {
        undoException = new UndoableActionException("Cannot undo the action.");
        if (isThrowUndoException) {
            throw undoException;
        }
    }

    /**
     * <p>
     * The method actually redo the edit.
     * </p>
     *
     * <p>
     * Throw an UndoableActionException if isThrowRedoException is true.
     * </p>
     *
     * @throws UndoableActionException any exception prevents this methods from completing successfully
     */
    protected void redoAction() throws UndoableActionException {
        redoException = new UndoableActionException("Cannot redo the action.");
        if (isThrowRedoException) {
            throw redoException;
        }
    }

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     *
     * <p>
     * Throws an ActionExecutionException if isThrowExecuteException is true.
     * </p>
     *
     * @throws ActionExecutionException if any exception prevents this method from completing successfully
     */
    protected void executeAction() throws ActionExecutionException {
        executeException = new ActionExecutionException("Error occurs in executing the action.");
        if (isThrowExecuteException) {
            throw executeException;
        }
    }

    /**
     * <p>
     * ActionExecutionException for executeAction.
     * </p>
     *
     * @return ActionExecutionException for executeAction.
     */
    public ActionExecutionException getExecuteException() {
        return executeException;
    }

    /**
     * <p>
     * UndoableActionException for redoAction.
     * </p>
     *
     * @return UndoableActionException for redoAction.
     */
    public UndoableActionException getRedoException() {
        return redoException;
    }

    /**
     * <p>
     * UndoableActionException for undoAction.
     * </p>
     *
     * @return UndoableActionException for undoAction.
     */
    public UndoableActionException getUndoException() {
        return undoException;
    }

    /**
     * <p>
     * Sets whether an ActionExecutionException for executeAction should be thrown or not when the executeAction method
     * is invoked.
     * </p>
     *
     * @param isThrowExecuteException A boolean indicating whether an ActionExecutionException for executeAction should
     * be thrown or not when the executeAction method is invoked.
     */
    public void setThrowExecuteException(boolean isThrowExecuteException) {
        this.isThrowExecuteException = isThrowExecuteException;
    }

    /**
     * <p>
     * Sets whether a UndoableActionException for redoAction should be thrown or not when the redoAction method
     * is invoked.
     * </p>
     *
     * @param isThrowRedoException A boolean indicating whether a UndoableActionException for redoAction should
     * be thrown or not when the redoAction method is invoked.
     */
    public void setThrowRedoException(boolean isThrowRedoException) {
        this.isThrowRedoException = isThrowRedoException;
    }

    /**
     * <p>
     * Sets whether a UndoableActionException for undoAction should be thrown or not when the undoAction method
     * is invoked.
     * </p>
     *
     * @param isThrowUndoException A boolean indicating whether a UndoableActionException for undoAction should
     * be thrown or not when the undoAction method is invoked.
     */
    public void setThrowUndoException(boolean isThrowUndoException) {
        this.isThrowUndoException = isThrowUndoException;
    }
}
