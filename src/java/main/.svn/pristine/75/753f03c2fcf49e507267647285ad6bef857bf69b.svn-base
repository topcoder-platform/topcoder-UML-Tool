/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the active property of a model element.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the action, undo to
 * undo the action and execute to execute the action.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeActiveAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the model element to change the active. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old active of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final boolean oldIsActive;

    /**
     * <p>
     * Represents the new active of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final boolean newIsActive;

    /**
     * <p>
     * Creates an instance of the ChangeActiveAction.
     * </p>
     * @param element
     *            the non null model element to change the active
     * @param isActive
     *            the new active of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeActiveAction(ModelElement element, boolean isActive) {
        super("Change active to " + isActive);
        DeployHelper.checkNotNull(element, "element");
        this.element = element;
        if (element instanceof Class) {
            oldIsActive = ((Class) element).isActive();
        } else {
            oldIsActive = false;
        }
        newIsActive = isActive;
    }

    /**
     * <p>
     * Undo the change entity active action.
     * </p>
     */
    public void undoAction() {
        updateActive(oldIsActive);
    }

    /**
     * <p>
     * Redo the change entity active action.
     * </p>
     */
    public void redoAction() {
        updateActive(newIsActive);
    }

    /**
     * <p>
     * Execute the change entity active action.
     * </p>
     */
    public void executeAction() {
        updateActive(newIsActive);
    }

    /**
     * <p>
     * Changes entity's active property.
     * </p>
     * @param isActive
     *            the new value of active property
     */
    private void updateActive(boolean isActive) {
        if (element instanceof Class) {
            ((Class) element).setActive(isActive);
        }
    }
}
