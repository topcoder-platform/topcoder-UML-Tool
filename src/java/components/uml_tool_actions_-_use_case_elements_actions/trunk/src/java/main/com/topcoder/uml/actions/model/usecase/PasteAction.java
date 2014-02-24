/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;

import com.topcoder.util.log.Level;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;


/**
 * <p>
 * This abstract class extends from UsecaseUndoableAction. It implements all logic of paste action for all elements in
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
abstract class PasteAction extends UsecaseUndoableAction {
    /**
     * <p>
     * Represent Namespace instance for current action. It used for setting this namespace into execute() method.
     * </p>
     */
    private final Namespace namespace;

    /**
     * <p>
     * Constructor which provides configuration for paste action.
     * </p>
     *
     * @param transferable Transferable instance, should not be null.
     * @param dataFlavor DataFlavor instance, should not be null.
     * @param usecaseToolUtil usecaseToolUtil instance, should not be null.
     * @param namespace Namespace instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null.
     * @throws InvalidDataContentException when transferable contain incorrect data flavor
     */
    protected PasteAction(Transferable transferable, DataFlavor dataFlavor, UsecaseToolUtil usecaseToolUtil,
        Namespace namespace) throws InvalidDataContentException {
        super(transferable, dataFlavor, usecaseToolUtil);
        Helper.checkNull("namespace", namespace);
        this.namespace = namespace;
    }

    /**
     * <p>
     * This method provides adding current instance of ModelElement to namespace.
     * </p>
     */
    public void execute() {
        getUsecaseToolUtil().addElementToModel(getModelElement(), namespace);
    }

    /**
     * <p>
     * This is method which is used by ActionManager for implementing undo functionality.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            getUsecaseToolUtil().addElementToModel(getModelElement(), namespace);
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
            if (!getUsecaseToolUtil().removeElementFromModel(getModelElement())) {
                getLog().log(Level.WARN, "Given element doesn't exist in namespace.");
            }

            super.undo();
        } else {
            getLog().log(Level.WARN, "Impossible provide undo action.");
        }
    }
}
