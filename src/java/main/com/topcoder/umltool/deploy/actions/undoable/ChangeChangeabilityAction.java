/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the changeability property of a model
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
public class ChangeChangeabilityAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the changeability. This variable is set in the constructor, is immutable
     * (the reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction
     * methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old changeability of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final ChangeableKind oldChangeability;

    /**
     * <p>
     * Represents the new changeability of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final ChangeableKind newChangeability;

    /**
     * <p>
     * Creates an instance of the ChangeChangeabilityAction.
     * </p>
     * @param element
     *            the non null model element to change the changeability
     * @param changeability
     *            the new changeability of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeChangeabilityAction(ModelElement element, ChangeableKind changeability) {
        super("Change changeability to " + changeability);
        DeployHelper.checkNotNull(element, "element");
        DeployHelper.checkNotNull(changeability, "changeability");
        this.element = element;
        if (element instanceof AssociationEnd) {
            oldChangeability = ((AssociationEnd) element).getChangeability();
        } else {
            oldChangeability = ((Attribute) element).getChangeability();
        }
        newChangeability = changeability;
    }

    /**
     * <p>
     * Undo the change entity changeability action.
     * </p>
     */
    public void undoAction() {
        updateChangeability(oldChangeability);
    }

    /**
     * <p>
     * Redo the change entity changeability action.
     * </p>
     */
    public void redoAction() {
        updateChangeability(newChangeability);
    }

    /**
     * <p>
     * Execute the change entity changeability action.
     * </p>
     */
    public void executeAction() {
        updateChangeability(newChangeability);
    }

    /**
     * <p>
     * Changes entity's changeability property.
     * </p>
     * @param kind
     *            the new value of changeability property
     */
    private void updateChangeability(ChangeableKind kind) {
        if (element instanceof AssociationEnd) {
            ((AssociationEnd) element).setChangeability(kind);
        } else {
            ((Attribute) element).setChangeability(kind);
        }
    }
}
