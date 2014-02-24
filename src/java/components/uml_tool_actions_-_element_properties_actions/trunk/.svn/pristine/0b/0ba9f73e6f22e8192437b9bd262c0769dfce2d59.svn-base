/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.feature;

import java.util.Iterator;

import com.topcoder.uml.actions.general.Helper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.StructuralFeatureAbstractImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.datatypes.expressions.Expression;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will update the given attribute. The received
 * parameters should be complete. This action will simply update the all the attributes according to the given
 * parameters.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the action, undo
 * to undo the action and execute to execute the action. If any exception prevents redo/undo methods from
 * completing successfully, it should be log with logError.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, rainday
 * @version 1.0
 */
public class UpdateAttributeAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the new multiplicity of the attribute after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final Multiplicity newMultiplicity;

    /**
     * <p>
     * Represents the new visibility of the attribute after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final VisibilityKind newVisibility;

    /**
     * <p>
     * Represents the new name of the attribute after this action performed. This variable is set in the
     * constructor, is immutable and never be null, possible empty. This variable is referenced in the doAction
     * method.
     * </p>
     */
    private final String newName;

    /**
     * <p>
     * Represents the old name of the attribute before this action performed. This variable is set in the
     * constructor, is immutable and never be null, possible empty. This variable is referenced in the doAction
     * method.
     * </p>
     */
    private final String oldName;

    /**
     * <p>
     * Represents the old changeability of the attribute before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final ChangeableKind oldChangeability;

    /**
     * <p>
     * Represents the new changeability of the attribute after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final ChangeableKind newChangeability;

    /**
     * <p>
     * Represents the old multiplicity of the attribute before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final Multiplicity oldMultiplicity;

    /**
     * <p>
     * Represents the old visibility of the attribute before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final VisibilityKind oldVisibility;

    /**
     * <p>
     * Represents the old initial value of the attribute before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final Expression oldInitialValue;

    /**
     * <p>
     * Represents the new initial value of the attribute after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final Expression newInitialValue;

    /**
     * <p>
     * Represents the new type of the attribute after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final Classifier newType;

    /**
     * <p>
     * Represents the old type of the attribute before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final Classifier oldType;

    /**
     * <p>
     * Represents the new isTransient value of the attribute after this action performed. This variable is set in
     * the constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final boolean newIsTransient;

    /**
     * <p>
     * Represents the old isTransient of the attribute before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final boolean oldIsTransient;

    /**
     * <p>
     * Represents the new owner kind (INSTANCE is for non-static, CLASSIFIER is for static) of the attribute after
     * this action performed. This variable is set in the constructor, is immutable. This variable is referenced in
     * the doAction method.
     * </p>
     */
    private final ScopeKind newOwnerKind;

    /**
     * <p>
     * Represents the old owner kind (INSTANCE is for non-static, CLASSIFIER is for static) of the attribute before
     * this action performed. This variable is set in the constructor, is immutable. This variable is referenced in
     * the doAction method.
     * </p>
     */
    private final ScopeKind oldOwnerKind;

    /**
     * <p>
     * Represents the attribute to be updated. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction and executeAction methods.
     * </p>
     */
    private final Attribute attribute;

    /**
     * <p>
     * Constructor of the update attribute action. The parameters should be complete given by the caller.
     * </p>
     *
     * @param attribute
     *            the non null attribute to be updated
     * @param visibility
     *            the new visibility of the attribute
     * @param name
     *            the non null and possible empty new name of the attribute
     * @param type
     *            the new type of the attribute
     * @param initialValue
     *            the new initial value of the attribute
     * @param changeability
     *            the new changeability of the attribute
     * @param multiplicity
     *            the new multiplicity of the attribute
     * @param ownerKind
     *            the new owner kind of the attribute
     * @param isTransient
     *            the new isTransient value of the attribute
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public UpdateAttributeAction(Attribute attribute, VisibilityKind visibility, String name, Classifier type,
        Expression initialValue, ChangeableKind changeability, Multiplicity multiplicity, ScopeKind ownerKind,
        boolean isTransient) {
        super("Update Attribute");
        Helper.checkNotNull(attribute, "attribute");
        Helper.checkNotNull(name, "name");
        this.attribute = attribute;
        oldVisibility = attribute.getVisibility();
        newVisibility = visibility;

        oldName = attribute.getName();
        newName = name;

        oldType = attribute.getType();
        newType = type;

        oldInitialValue = attribute.getInitialValue();
        newInitialValue = initialValue;

        oldChangeability = attribute.getChangeability();
        newChangeability = changeability;

        oldMultiplicity = attribute.getMultiplicity();
        newMultiplicity = multiplicity;

        oldOwnerKind = attribute.getOwnerScope();
        newOwnerKind = ownerKind;

        Iterator<TaggedValue> iter = attribute.getTaggedValues().iterator();
        TaggedValue value = null;
        while (iter.hasNext()) {
            value = iter.next();
            if (value.getType().getTagType().equals("transient")) {
                break;
            }
            value = null;
        }

        if (value == null) {
            oldIsTransient = isTransient;
        } else {
            oldIsTransient = Boolean.parseBoolean(value.getDataValue());
        }
        newIsTransient = isTransient;
    }

    /**
     * <p>
     * Execute the update attribute action.
     * </p>
     */
    public void executeAction() {
        redoAction();
    }

    /**
     * <p>
     * Redo the update attribute action.
     * </p>
     */
    public void redoAction() {
        updateAttributeValues(newVisibility, newName, newType, newInitialValue, newChangeability, newMultiplicity,
            newOwnerKind, newIsTransient);
    }

    /**
     * <p>
     * Undo the update attribute action.
     * </p>
     */
    public void undoAction() {
        updateAttributeValues(oldVisibility, oldName, oldType, oldInitialValue, oldChangeability, oldMultiplicity,
            oldOwnerKind, oldIsTransient);
    }

    /**
     * <p>
     * Update the fields of the attribute.
     * </p>
     *
     * @param visibility
     *            the new visibility of the attribute
     * @param name
     *            the non null and possible empty new name of the attribute
     * @param type
     *            the new type of the attribute
     * @param initialValue
     *            the new initial value of the attribute
     * @param changeability
     *            the new changeability of the attribute
     * @param multiplicity
     *            the new multiplicity of the attribute
     * @param ownerKind
     *            the new owner kind of the attribute
     * @param isTransient
     *            the new isTransient value of the attribute
     */
    private void updateAttributeValues(VisibilityKind visibility, String name, Classifier type,
        Expression initialValue, ChangeableKind changeability, Multiplicity multiplicity, ScopeKind ownerKind,
        boolean isTransient) {
        if (oldIsTransient != newIsTransient) {
            Iterator<TaggedValue> iter = attribute.getTaggedValues().iterator();
            TaggedValue value = null;
            while (iter.hasNext()) {
                value = iter.next();
                if (value.getType().getTagType().equals("transient")) {
                    value.setDataValue(Boolean.toString(isTransient));
                    break;
                }
            }
        }
        attribute.setVisibility(visibility);
        attribute.setName(name);
        StructuralFeatureAbstractImpl.setType(attribute, type);
        attribute.setInitialValue(initialValue);
        attribute.setChangeability(changeability);
        attribute.setMultiplicity(multiplicity);
        attribute.setOwnerScope(ownerKind);
    }
}
