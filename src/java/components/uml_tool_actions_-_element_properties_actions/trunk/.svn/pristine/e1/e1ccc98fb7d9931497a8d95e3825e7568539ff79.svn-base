/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.custom;

import com.topcoder.uml.actions.general.Helper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will update the attributes of an association end. The
 * received parameters should be complete. This action will simply update the all the attributes according to the given
 * parameters.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the action, undo to
 * undo the action and execute to execute the action. If any exception prevents redo/undo methods from completing
 * successfully, it should be log with logError.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 * @author kinzz, rainday
 * @version 1.0
 */
public class UpdateAssociationEndAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the association end to update the attributes. This variable is set in the constructor, is immutable
     * (the reference) and never be null. This variable is referenced in the doAction and undoAction method.
     * </p>
     */
    private final AssociationEnd associationEnd;

    /**
     * <p>
     * Represents the new visibility of the association end after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the redoAction and execute methods.
     * </p>
     */
    private final VisibilityKind newVisibility;

    /**
     * <p>
     * Represents the new name of the association end after this action performed. This variable is set in the
     * constructor, is immutable. It will never be null and possible empty(trim'd). This variable is referenced in the
     * redoAction and execute methods.
     * </p>
     */
    private final String newName;

    /**
     * <p>
     * Represents the new changeability of the association end after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the redoAction and execute methods.
     * </p>
     */
    private final ChangeableKind newChangeability;

    /**
     * <p>
     * Represents the new multiplicity of the association end after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the redoAction and execute methods.
     * </p>
     */
    private final Multiplicity newMultiplicity;

    /**
     * <p>
     * Represents the new ordering of the association end after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the redoAction and execute methods.
     * </p>
     */
    private final OrderingKind newOrdering;

    /**
     * <p>
     * Represents the new aggregation of the association end after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the redoAction and execute methods.
     * </p>
     */
    private final AggregationKind newAggregationKind;

    /**
     * <p>
     * Represents the old multiplicity of the association end before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final Multiplicity oldMultiplicity;

    /**
     * <p>
     * Represents the old name of the association end before this action performed. This variable is set in the
     * constructor, is immutable. It will never be null and possible empty(trim'd). This variable is referenced in the
     * doAction method.
     * </p>
     */
    private final String oldName;

    /**
     * <p>
     * Represents the old ordering of the association end before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final OrderingKind oldOrdering;

    /**
     * <p>
     * Represents the old visibility of the association end before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final VisibilityKind oldVisibility;

    /**
     * <p>
     * Represents the old changeability of the association end before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final ChangeableKind oldChangeability;

    /**
     * <p>
     * Represents the old aggregation of the association end before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final AggregationKind oldAggregationKind;

    /**
     * <p>
     * Represents the new target kind(isStatic) of the association end after this action performed. This variable is set
     * in the constructor, is immutable. This variable is referenced in the redoAction and execute methods.
     * </p>
     */
    private final ScopeKind newTargetKind;

    /**
     * <p>
     * Represents the old target kind of the association end before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final ScopeKind oldTargetKind;

    /**
     * <p>
     * Represents the old navigable of the association end before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final boolean oldNavigable;

    /**
     * <p>
     * Represents the new navigable of the association end after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the redoAction and execute methods.
     * </p>
     */
    private final boolean newNavigable;

    /**
     * <p>
     * Constructor of the update association end action. The parameters should be complete given by the caller.
     * </p>
     * @param associationEnd
     *            the non null association end to update the attributes
     * @param visibility
     *            the new visibility of the association end
     * @param name
     *            the non-null new name of the association end
     * @param changeability
     *            the new changeability of the association end
     * @param multiplicity
     *            the new multiplicity of the association end
     * @param ordering
     *            the new ordering of the association end
     * @param aggregationKind
     *            the new aggregation of the association end
     * @param targetKind
     *            the new target kind(isStatic) of the association end
     * @param navigable
     *            the new navigable of the association end
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public UpdateAssociationEndAction(AssociationEnd associationEnd, VisibilityKind visibility, String name,
        ChangeableKind changeability, Multiplicity multiplicity, OrderingKind ordering,
        AggregationKind aggregationKind, ScopeKind targetKind, boolean navigable) {
        super("Update association end action");
        Helper.checkNotNull(associationEnd, "associationEnd");
        Helper.checkNotNull(name, "name");

        this.associationEnd = associationEnd;
        oldVisibility = associationEnd.getVisibility();
        newVisibility = visibility;

        oldName = associationEnd.getName();
        newName = name;

        oldChangeability = associationEnd.getChangeability();
        newChangeability = changeability;

        oldMultiplicity = associationEnd.getMultiplicity();
        newMultiplicity = multiplicity;

        oldOrdering = associationEnd.getOrdering();
        newOrdering = ordering;

        oldAggregationKind = associationEnd.getAggregation();
        newAggregationKind = aggregationKind;

        oldTargetKind = associationEnd.getTargetKind();
        newTargetKind = targetKind;

        oldNavigable = associationEnd.isNavigable();
        newNavigable = navigable;
    }

    /**
     * <p>
     * Undo the update association end action.
     * </p>
     */
    public void undoAction() {
        updateAssociationEndValues(oldVisibility, oldName, oldChangeability, oldMultiplicity, oldOrdering,
                oldAggregationKind, oldTargetKind, oldNavigable);
    }

    /**
     * <p>
     * Execute the update association end action.
     * </p>
     */
    public void executeAction() {
        redoAction();
    }

    /**
     * <p>
     * Redo the update association end action.
     * </p>
     */
    public void redoAction() {
        updateAssociationEndValues(newVisibility, newName, newChangeability, newMultiplicity, newOrdering,
                newAggregationKind, newTargetKind, newNavigable);
    }

    /**
     * <p>
     * Update the fields of the associationEnd.
     * </p>
     * @param visibility
     *            the new visibility of the association end
     * @param name
     *            the new name of the association end
     * @param changeability
     *            the new changeability of the association end
     * @param multiplicity
     *            the new multiplicity of the association end
     * @param ordering
     *            the new ordering of the association end
     * @param aggregationKind
     *            the new aggregation of the association end
     * @param targetKind
     *            the new target kind(isStatic) of the association end
     * @param navigable
     *            the new navigable of the association end
     */
    private void updateAssociationEndValues(VisibilityKind visibility, String name, ChangeableKind changeability,
            Multiplicity multiplicity, OrderingKind ordering, AggregationKind aggregationKind, ScopeKind targetKind,
            boolean navigable) {
        associationEnd.setVisibility(visibility);
        associationEnd.setName(name);
        associationEnd.setChangeability(changeability);
        associationEnd.setMultiplicity(multiplicity);
        associationEnd.setOrdering(ordering);
        associationEnd.setAggregation(aggregationKind);
        associationEnd.setTargetKind(targetKind);
        associationEnd.setNavigable(navigable);
    }
}
