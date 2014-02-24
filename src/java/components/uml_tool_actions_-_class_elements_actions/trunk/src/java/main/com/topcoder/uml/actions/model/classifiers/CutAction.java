/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

/**
 * <p>
 * This abstract class extends from ClassUndoableAction. It implements all logic
 * of cut action for all elements in component. It contains three methods:
 * execute(), redo(), undo().
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
abstract class CutAction extends ClassUndoableAction {

    /**
     * <p>
     * Represent Clipboard for this action.
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Constructor which provide configuration for cut action.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @param classToolUtil
     *            ClassToolUtil instance, null impossible
     * @param clipboard
     *            Clipboard instance, null possible
     * @throws IllegalArgumentException
     *             when some parameter is null except clipboard
     */
    protected CutAction(ModelElement modelElement, ClassToolUtil classToolUtil, Clipboard clipboard) {
        super(modelElement, classToolUtil);

        if (clipboard == null) {
            this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        } else {
            this.clipboard = clipboard;
        }
    }

    /**
     * <p>
     * This method provide cutting instance of ModelElement from namespace and
     * putting its copy to clipboard.
     * </p>
     *
     * @throws ActionExecutionException
     *             when impossible execute action
     */
    public void execute() throws ActionExecutionException {
        // copy
        getClassToolUtil().addElementToClipboard(getClassToolUtil().copyElement(getModelElement()), clipboard);

        // remove
        if (!getClassToolUtil().removeElementFromModel(getModelElement())) {
            throw new ActionExecutionException("Impossible provide execute cut action.");
        }
    }

    /**
     * <p>
     * This is method which is used by ActionManager for implementing redo
     * functionality.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            if (!getClassToolUtil().removeElementFromModel(getModelElement())) {
                getLog().log(Level.WARN, "Given element doesn't exist in the namespace.");
            }
            super.redo();
        } else {
            getLog().log(Level.WARN, "Impossible provide redo cut action.");
        }
    }

    /**
     * <p>
     * This is method which is used by ActionManager for implementing undo
     * functionality.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            getClassToolUtil().addElementToModel(getModelElement(), getModelElement().getNamespace());
            super.undo();
        } else {
            getLog().log(Level.WARN, "Impossible provide undo cut action.");
        }
    }
}