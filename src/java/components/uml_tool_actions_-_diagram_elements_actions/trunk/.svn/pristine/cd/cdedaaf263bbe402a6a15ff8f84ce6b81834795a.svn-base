/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * The super class of all actions in this component.
 * </p>
 *
 * <p>
 * This class extends UndoableAction and provide default implementation of the interface.
 * </p>
 *
 * <p>
 * This class stores the parent GraphElement to be the parent container or to be updated.
 * In addition, it provides basic undo/redo mechanism.
 * </p>
 *
 * <p>
 * Note, not all methods are relevant, those methods who are not supported by this class
 * will throw UnsupportedOperationException if called.
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe as execute, redo and undo can interfere
 * each other.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public abstract class DiagramElementUndoableAction implements UndoableAction {
    /**
     * <p>
     * Represents the graph element to be manipulated in the case of update or
     * it could be the parent GraphElement in the case of Add Action.
     * </p>
     *
     * <p>
     * Might be null (eg : for update, some times only the extractor is needed).
     * </p>
     *
     * <p>
     * Will not be changed after initialized.
     * </p>
     */
    private final GraphElement element;

    /**
     * <p>
     * Represents whether undo operation can be called at this state.
     * </p>
     *
     * <p>
     * True if the last operation was execute or redo.
     * </p>
     *
     * <p>
     * This variable can be changed.
     * </p>
     *
     */
    private boolean isUndoable = false;

    /**
     * <p>
     * Represents whether redo method can be called in this state.
     * </p>
     *
     * <p>
     * True if the last operation was undo.
     * </p>
     *
     * <p>
     * This variable can be changed.
     * </p>
     */
    private boolean isRedoable = false;

    /**
     * <p>
     * Represents the exception that was last occurred during a call to
     * undo/redo method.
     * </p>
     *
     * <p>
     * This is necessary as undo and redo method can not throw any exception.
     * The client should call getLastException() to obtain the exception occurred
     * (if any).
     * </p>
     *
     * <p>
     * This variable can be null and changed.
     * It Will be set by implementation of undo and redo method.
     * </p>
     */
    private ActionExecutionException lastException;

    /**
     * <p>
     * Constructor a new DiagramElementUndoableAction instance.
     * </p>
     *
     * @param element the element to be processed, can be null
     */
    protected DiagramElementUndoableAction(GraphElement element) {
        this.element = element;
    }

    /**
     * <p>
     * Redo the action represented by this component.
     * </p>
     *
     * <p>
     * This method will only check if redo is allowed, otherwise CannotRedoException will be thrown.
     * </p>
     *
     * <p>
     * Subclasses of this class should provide the actual implementation of this method.
     * Such implementation should first call redo method of this class.
     * </p>
     *
     * <p>
     * In the case of exception occurs, Implementation of this method should set the lastException
     * instance variable and return silently.
     * It is the responsibility of the client to call getLastException to ensure there was no exception.
     * </p>
     *
     * @throws CannotRedoException if redo operation cannot be performed
     */
    public void redo() {
        // only check the action can be redo or not
        if (!this.canRedo()) {
            throw new CannotRedoException();
        }
    }

    /**
     * <p>
     * Undo the action represented by this component.
     * </p>
     *
     * <p>
     * This method will only check if undo is allowed, otherwise CannotUndoException will be thrown.
     * </p>
     *
     * <p>
     * Subclasses of this class should provide the actual implementation of this method.
     * Such implementation should first call undo method of this class.
     * </p>
     *
     * <p>
     * In the case of exception occurs, Implementation of this method should set the
     * lastException instance variable and return silently. It is the responsibility of the client
     * to call getLastException to ensure there was no exception.
     * </p>
     *
     * @throws CannotUndoException if undo operation cannot be performed
     */
    public void undo() {
        // only check the action can be undo or not
        if (!this.canUndo()) {
            throw new CannotUndoException();
        }
    }

    /**
     * <p>
     * Get the GraphElement set in constructor.
     * </p>
     *
     * @return the element to be processed
     */
    public GraphElement getElement() {
        return this.element;
    }

    /**
     * <p>
     * Return true if undo is supported at this state, false otherwise.
     * </p>
     *
     * @return true if undo is supported at this time, false otherwise
     */
    public boolean canUndo() {
        return this.isUndoable;
    }

    /**
     * <p>
     * This operation is not supported yet.
     * </p>
     *
     * @throws UnsupportedOperationException all the time unless it is overridden
     */
    public void die() {
        throw new UnsupportedOperationException("The die() method is not supported.");
    }

    /**
     * <p>
     * Return true if redo is supported at this state, false otherwise.
     * </p>
     *
     * @return true if redo is supported at this state, false otherwise
     */
    public boolean canRedo() {
        return isRedoable;
    }

    /**
     * <p>
     * This operation is not supported yet.
     * </p>
     *
     * @throws UnsupportedOperationException all the time unless it is overridden
     *
     * @return not used
     */
    public boolean isSignificant() {
        throw new UnsupportedOperationException("The isSignificant() method is not supported.");
    }

    /**
     * <p>
     * This operation is not supported yet.
     * </p>
     *
     * @param anEdit not used
     * @throws UnsupportedOperationException all the time unless it is overridden
     *
     * @return not used
     */
    public boolean addEdit(UndoableEdit anEdit) {
        throw new UnsupportedOperationException("The addEdit(UndoableEdit) method is not supported.");
    }

    /**
     * <p>
     * This operation is not supported yet.
     * </p>
     *
     * @param anEdit not used
     * @throws UnsupportedOperationException all the time unless it is overridden
     *
     * @return not used
     */
    public boolean replaceEdit(UndoableEdit anEdit) {
        throw new UnsupportedOperationException("The replaceEdit(UndoableEdit) method is not supported.");
    }

    /**
     * <p>
     * This operation is not supported yet.
     * </p>
     *
     * @throws UnsupportedOperationException all the time unless it is overridden
     *
     * @return not used
     */
    public String getUndoPresentationName() {
        throw new UnsupportedOperationException("The getUndoPresentationName() method is not supported.");
    }

    /**
     * <p>
     * This operation is not supported yet.
     * </p>
     *
     * @throws UnsupportedOperationException all the time unless it is overridden
     *
     * @return not used
     */
    public String getRedoPresentationName() {
        throw new UnsupportedOperationException("The getRedoPresentationName() method is not supported.");
    }

    /**
     * <p>
     * This operation is not supported yet.
     * </p>
     *
     * @throws UnsupportedOperationException all the time unless it is overridden
     *
     * @return not used
     */
    public String getPresentationName() {
        throw new UnsupportedOperationException("The getPresentationName() method is not supported.");
    }

    /**
     * <p>
     * Indicates that the last execution of the action (not redo/undo) was successful.
     * </p>
     *
     * <p>
     * Note, this reflects the status of canUndo() and canRedo().
     * </p>
     */
    protected void executionSuccess() {
        this.isUndoable = true;
    }

    /**
     * <p>
     * Indicates that the execution of the last redo was successful.
     * </p>
     *
     * <p>
     * Note, this reflects the status of canUndo() and canRedo().
     * </p>
     */
    protected void redoSuccess() {
        this.isRedoable = false;
        this.isUndoable = true;
    }

    /**
     * <p>
     * Indicates that the execution of the last redo was successful.
     * </p>
     *
     * <p>
     * Note, this reflects the status of canUndo() and canRedo().
     * </p>
     */
    protected void undoSuccess() {
        this.isRedoable = true;
        this.isUndoable = false;
    }

    /**
     * <p>
     * Return the last exception occurred in a call to undo or redo method.
     * </p>
     *
     * @return the last exception occurred in a call to undo or redo method.
     */
    public ActionExecutionException getLastException() {
        return this.lastException;
    }

    /**
     * <p>
     * Set the last exception occurred during execution of redo or undo method.
     * </p>
     *
     * @param exception the last exception occurred during execution of redo or undo method.
     *
     * @throws IllegalArgumentException if exception is null
     */
    protected void setLastException(ActionExecutionException exception) {
        Util.checkNull(exception, "exception");

        this.lastException = exception;
    }
}
