/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import com.topcoder.uml.actions.diagram.elements.UpdateDiagramElementAction;
import com.topcoder.uml.actions.diagram.elements.Util;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends the UpdateDiagramElementAction class and represents all update actions
 * which add a new object to the parent GraphElement or remove an existing object.
 * </p>
 *
 * <p>
 * Thread Safety : This class is mutable and so is not thread safe.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public abstract class AddRemoveAction extends UpdateDiagramElementAction {
    /**
     * <p>
     * Represents the new object to be added or to be removed.
     * </p>
     *
     * <p>
     * This variable can be null and can be changed.
     * </p>
     */
    private Object executeValue;

    /**
     * <p>
     * Indicate whether this action is add or remove.
     * </p>
     *
     * <p>
     * True for remove, false for add.
     * </p>
     *
     * <p>
     * This variable can be changed.
     * </p>
     */
    private boolean isRemove;

    /**
     * <p>
     * Create a new AddRemoveAction instance with extractor and object to be added/removed.
     * </p>
     *
     * <p>
     * If isRemove is false then this class will represent Add Action, otherwise it will
     * represent RemoveAction.
     * </p>
     *
     * @param extractor compartment extractor to be used
     * @param obj object to be added/removed
     * @param isRemove false for add, true for remove
     *
     * @throws IllegalArgumentException if extractor is null
     */
    protected AddRemoveAction(CompartmentExtractor extractor, Object obj, boolean isRemove) {
        super(extractor);

        Util.checkNull(obj, "obj");

        this.executeValue = obj;
        this.isRemove = isRemove;
    }

    /**
     * <p>
     * Execute the action represented by this class.
     * </p>
     *
     * @throws ActionExecutionException if fails to execute this action
     */
    public void execute() throws ActionExecutionException {
        if (isRemove) {
            executeRemove();
        } else {
            executeAdd();
        }

        // identify the action can be undo
        this.executionSuccess();
    }

    /**
     * <p>
     * Undo the action represented by this object.
     * </p>
     *
     * <p>
     * Note, the ActionExecutionException exception occurred is stored in lastException
     * and return silently.
     * </p>
     *
     * @throws CannotUndoExcepiton if undo operation cannot be performed
     */
    public void undo() {
        super.undo();
        try {
            // reverse the operation compared to execute() method
            if (isRemove) {
                executeAdd();
            } else {
                executeRemove();
            }

            // identify the action can be redo
            this.undoSuccess();
        } catch (ActionExecutionException e) {
            // The ActionExecutionException will be igored after saving to lastException variable
            this.setLastException(e);
        }
    }

    /**
     * <p>
     * Redo the action represented by this component.
     * </p>
     *
     * <p>
     * Note, the ActionExecutionException exception occurred is stored in lastException
     * and return silently.
     * </p>
     *
     * @throws CannotRedoException if redo operation cannot be performed
     */
    public void redo() {
        super.redo();
        try {
            this.execute();

            // identify the action can be undo
            this.redoSuccess();
        } catch (ActionExecutionException e) {
            // The ActionExecutionException will be igored after saving to lastException variable
            this.setLastException(e);
        }
    }

    /**
     * <p>
     * Execute the remove operation action represented by this object.
     * </p>
     *
     * @throws ActionExecutionException if fails to perform the remove action
     */
    protected abstract void executeRemove() throws ActionExecutionException;

    /**
     * <p>
     * Execute the add operation action represented by this object.
     * </p>
     *
     * @throws ActionExecutionException if fails to perform the add action
     */
    protected abstract void executeAdd() throws ActionExecutionException;

    /**
     * <p>
     * Return true if this class represents a remove action, false otherwise.
     * </p>
     *
     * @return true if this class represents a remove action, false otherwise
     */
    protected boolean isRemoveAction() {
        return isRemove;
    }

    /**
     * <p>
     * Set the executeValue to the given object.
     * </p>
     *
     * <p>
     * Note, null is allowed.
     * </p>
     *
     * @param executeValue the new value to update the old value, can be null
     */
    protected void setExecuteValue(Object executeValue) {
        this.executeValue = executeValue;
    }

    /**
     * <p>
     * Get the execute Value.
     * </p>
     *
     * <p>
     * Note, the return value may be null.
     * </p>
     *
     * @return the execute Value to update the old one, may be null
     */
    protected Object getExecuteValue() {
        return executeValue;
    }
}
