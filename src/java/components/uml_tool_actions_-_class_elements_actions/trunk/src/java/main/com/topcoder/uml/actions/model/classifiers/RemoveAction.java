/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

/**
 * <p>
 * This abstract class extends from ClassUndoableAction. It implements all logic
 * of remove action for all elements in component. It contains three methods:
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
abstract class RemoveAction extends ClassUndoableAction {

    /**
     * <p>
     * Constructor which provide configuration for remove action.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @param classToolUtil
     *            ClassToolUtil instance, null impossible
     * @throws IllegalArgumentException
     *             when some parameter is null
     */
    protected RemoveAction(ModelElement modelElement, ClassToolUtil classToolUtil) {
        super(modelElement, classToolUtil);
    }

    /**
     * <p>
     * This method provide removing current instance of ModelElement from
     * namespace.
     * </p>
     *
     * @throws ActionExecutionException
     *             when impossible execute action
     */
    public void execute() throws ActionExecutionException {
        if (!getClassToolUtil().removeElementFromModel(getModelElement())) {
            throw new ActionExecutionException("Impossible provide execute remove action.");
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
            getLog().log(Level.WARN, "Impossible provide redo remove action.");
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
            getLog().log(Level.WARN, "Impossible provide undo remove action");
        }
    }
}