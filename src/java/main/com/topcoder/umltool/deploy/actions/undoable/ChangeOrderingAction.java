/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the ordering property of a model element.
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
public class ChangeOrderingAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the ordering. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old ordering of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final OrderingKind oldOrdering;

    /**
     * <p>
     * Represents the new ordering of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final OrderingKind newOrdering;

    /**
     * <p>
     * Creates an instance of the ChangeOrderingAction.
     * </p>
     * @param element
     *            the non null model element to change the ordering
     * @param ordering
     *            the new ordering of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeOrderingAction(ModelElement element, OrderingKind ordering) {
        super("Change ordering to " + ordering);
        DeployHelper.checkNotNull(element, "element");
        DeployHelper.checkNotNull(ordering, "ordering");
        this.element = element;
        oldOrdering = ((AssociationEnd) element).getOrdering();
        newOrdering = ordering;
    }

    /**
     * <p>
     * Undo the change entity ordering action.
     * </p>
     */
    public void undoAction() {
        updateOrdering(oldOrdering);
    }

    /**
     * <p>
     * Redo the change entity ordering action.
     * </p>
     */
    public void redoAction() {
        updateOrdering(newOrdering);
    }

    /**
     * <p>
     * Execute the change entity ordering action.
     * </p>
     */
    public void executeAction() {
        updateOrdering(newOrdering);
    }

    /**
     * <p>
     * Changes entity's ordering property.
     * </p>
     * @param ordering
     *            the new value of ordering property
     */
    private void updateOrdering(OrderingKind ordering) {
        ((AssociationEnd) element).setOrdering(ordering);
    }
}
