/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the aggregation property of a model
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
public class ChangeAggregationAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the aggregation. This variable is set in the constructor, is immutable
     * (the reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction
     * methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old aggregation of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final AggregationKind oldAggregation;

    /**
     * <p>
     * Represents the new aggregation of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final AggregationKind newAggregation;

    /**
     * <p>
     * Creates an instance of the ChangeAggregationAction.
     * </p>
     * @param element
     *            the non null model element to change the aggregation
     * @param kind
     *            the new aggregation kind of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeAggregationAction(ModelElement element, AggregationKind kind) {
        super("Change aggregation to " + kind);
        DeployHelper.checkNotNull(element, "element");
        DeployHelper.checkNotNull(kind, "aggregationkind");
        this.element = element;
        oldAggregation = ((AssociationEnd) element).getAggregation();
        newAggregation = kind;
    }

    /**
     * <p>
     * Undo the change entity aggregation action.
     * </p>
     */
    public void undoAction() {
        updateAggregation(oldAggregation);
    }

    /**
     * <p>
     * Redo the change entity aggregation action.
     * </p>
     */
    public void redoAction() {
        updateAggregation(newAggregation);
    }

    /**
     * <p>
     * Execute the change entity aggregation action.
     * </p>
     */
    public void executeAction() {
        updateAggregation(newAggregation);
    }

    /**
     * <p>
     * Changes entity's aggregation property.
     * </p>
     * @param kind
     *            the new kind of aggregation property
     */
    private void updateAggregation(AggregationKind kind) {
        ((AssociationEnd) element).setAggregation(kind);
    }
}
