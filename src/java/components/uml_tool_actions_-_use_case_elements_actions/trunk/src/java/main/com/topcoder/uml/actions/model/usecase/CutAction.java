/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * <p>
 * This abstract class extends from UsecaseUndoableAction. It implements all logic of cut action for all elements in
 * component. It contains three methods execute(), redo(), undo().
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
abstract class CutAction extends UsecaseUndoableAction {
    /**
     * <p>
     * Represent Clipboard for this action.
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Constructor which provides configuration for cut action.
     * </p>
     *
     * @param modelElement ModelElement instance, should not be null.
     * @param usecaseToolUtil usecaseToolUtil instance, should not be null.
     * @param clipboard Clipboard instance, can be null.
     *
     * @throws IllegalArgumentException when given ModelElement or UsecaseToolUtil is null.
     */
    protected CutAction(ModelElement modelElement, UsecaseToolUtil usecaseToolUtil, Clipboard clipboard) {
        super(modelElement, usecaseToolUtil);

        if (clipboard == null) {
            this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        } else {
            this.clipboard = clipboard;
        }
    }

    /**
     * <p>
     * This method provides removing cutting instance of ModelElement from namespace and putting its copy to clipboard.
     * </p>
     *
     * @throws ActionExecutionException when impossible execute action
     */
    public void execute() throws ActionExecutionException {
        getUsecaseToolUtil().addElementToClipboard(getUsecaseToolUtil().copyElement(getModelElement()), clipboard);

        if (!getUsecaseToolUtil().removeElementFromModel(getModelElement())) {
            throw new ActionExecutionException("This element are not exist in namespace or its namespace is null.");
        }
    }

    /**
     * <p>
     * This is method which is used by ActionManager for implementing redo functionality.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            if (!getUsecaseToolUtil().removeElementFromModel(getModelElement())) {
                getLog().log(Level.WARN, "Given element doesn't exist in namespace.");
            }

            super.redo();
        } else {
            getLog().log(Level.WARN, "Impossible provide redo action.");
        }
    }

    /**
     * <p>
     * This is method which is used by ActionManager for implementing undo functionality.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            getUsecaseToolUtil().addElementToModel(getModelElement(), getModelElement().getNamespace());
            super.undo();
        } else {
            getLog().log(Level.WARN, "Impossible provide undo action.");
        }
    }
}
