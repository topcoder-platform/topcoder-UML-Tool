/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.actions.diagram.elements.UpdateDiagramElementAction;
import com.topcoder.uml.actions.diagram.elements.Util;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends UpdateDiagramElementAction class and represents the super class of all
 * update action in this component.
 * </p>
 *
 * <p>
 * This action will change the existing value to another value (not addition or removal).
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe as undo, redo and execute might interfere
 * each other.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public abstract class UpdateAction extends UpdateDiagramElementAction {
    /**
     * <p>
     * Represent the old value of the data before it was updated.
     * </p>
     *
     * <p>
     * Updated in execute, undo or redo method.
     * </p>
     *
     * <p>
     * This variable can be null and can be changed.
     * </p>
     */
    protected Object savedValue;

    /**
     * <p>
     * Represents the new value to replace the old value.
     * </p>
     *
     * <p>
     * Updated in undo, execute or redo methods.
     * </p>
     *
     * <p>
     * This variable can be null and can be changed.
     * </p>
     */
    protected Object executeValue;

    /**
     * <p>
     * Create UpdateAction with given compartment extractor and new value to update.
     * </p>
     *
     * @param extractor compartment extractor to be used
     * @param value the new value to replace the old one
     *
     * @throws IllegalArgumentException if extractor argument is null
     */
    protected UpdateAction(CompartmentExtractor extractor, Object value) {
        super(extractor);

        this.executeValue = value;
    }

    /**
     * <p>
     * Create UpdateAction with given parent element and new value to update.
     * </p>
     *
     * @param element graph element to be updated
     * @param value the new value to replace the old one
     *
     * @throws IllegalArgumentException if element argument is null
     */
    protected UpdateAction(GraphElement element, Object value) {
        super(element);

        this.executeValue = value;
    }

    /**
     * <p>
     * Create UpdateAction with given parent element and compartment
     * extractor and the new value to update the old one.
     * </p>
     *
     * @param element graph element to be updated
     * @param extractor compartment extractor to be used
     * @param value new value to replace the old one
     *
     * @throws IllegalArgumentException if element or extractor is null
     */
    protected UpdateAction(GraphElement element, CompartmentExtractor extractor, Object value) {
        super(element, extractor);

        Util.checkNull(element, "element");
        Util.checkNull(extractor, "extractor");

        this.executeValue = value;
    }

    /**
     * <p>
     * Undo the update action represented by this component.
     * </p>
     *
     * <p>
     * Note, the ActionExecutionException exception occurred is stored in lastException
     * and return silently.
     * </p>
     *
     * @throws CannotUndoException if undo operation cannot be performed
     */
    public void undo() {
        super.undo();

        // undo the action
        swap();

        try {
            this.execute();
            // identify the action can be redo
            this.undoSuccess();
        } catch (ActionExecutionException e) {
            // the ActionExecutionException will be ignore after it is save to lastException variable
            this.setLastException(e);
        }

        swap();
    }

    /**
     * <p>
     * Redo the update action represented by this component.
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

        // redo the action
        try {
            this.execute();
            // identify the action can be undo
            this.redoSuccess();
        } catch (ActionExecutionException e) {
            // the ActionExecutionException will be ignore after it is save to lastException variable
            this.setLastException(e);
        }
    }

    /**
     * <p>
     * Swap the values of executeValue and savedValue variables.
     * This is used for undo action.
     * </p>
     */
    private void swap() {
        Object tmp = this.executeValue;
        this.executeValue = this.savedValue;
        this.savedValue = tmp;
    }
}
