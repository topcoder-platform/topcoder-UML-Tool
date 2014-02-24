/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the navigable property of a model
 * element.
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
public class ChangeNavigableAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the navigable. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old navigable of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final boolean oldIsNavigable;

    /**
     * <p>
     * Represents the new navigable of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final boolean newIsNavigable;

    /**
     * <p>
     * Creates an instance of the ChangeNavigableAction.
     * </p>
     * @param element
     *            the non null model element to change the navigable
     * @param isNavigable
     *            the new navigable of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeNavigableAction(ModelElement element, boolean isNavigable) {
        super("Change navigable to " + isNavigable);
        DeployHelper.checkNotNull(element, "element");
        this.element = element;
        if (element instanceof AssociationEnd) {
            oldIsNavigable = ((AssociationEnd) element).isNavigable();
        } else {
            oldIsNavigable = false;
        }
        newIsNavigable = isNavigable;
    }

    /**
     * <p>
     * Undo the change entity navigable action.
     * </p>
     */
    public void undoAction() {
        updateNavigable(oldIsNavigable);
    }

    /**
     * <p>
     * Redo the change entity navigable action.
     * </p>
     */
    public void redoAction() {
        updateNavigable(newIsNavigable);
    }

    /**
     * <p>
     * Execute the change entity navigable action.
     * </p>
     */
    public void executeAction() {
        updateNavigable(newIsNavigable);
    }

    /**
     * <p>
     * Changes entity's navigable property.
     * </p>
     * @param isNavigable
     *            the new value of navigable property
     */
    private void updateNavigable(boolean isNavigable) {
        if (element instanceof AssociationEnd) {
            ((AssociationEnd) element).setNavigable(isNavigable);
        }
    }
}
