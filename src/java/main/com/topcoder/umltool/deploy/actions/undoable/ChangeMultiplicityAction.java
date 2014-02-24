/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the multiplicity property of a model
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
public class ChangeMultiplicityAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the multiplicity. This variable is set in the constructor, is immutable
     * (the reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction
     * methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old multiplicity of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final Multiplicity oldMultiplicity;

    /**
     * <p>
     * Represents the new multiplicity of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final Multiplicity newMultiplicity;

    /**
     * <p>
     * Creates an instance of the ChangeMultiplicityAction.
     * </p>
     * @param element
     *            the non null model element to change the multiplicity
     * @param multiplicity
     *            the new multiplicity of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeMultiplicityAction(ModelElement element, Multiplicity multiplicity) {
        super("Change multiplicity to " + multiplicity);
        DeployHelper.checkNotNull(element, "element");
        DeployHelper.checkNotNull(multiplicity, "multiplicity");
        this.element = element;
        if (element instanceof Attribute) {
            oldMultiplicity = ((Attribute) element).getMultiplicity();
        } else {
            oldMultiplicity = ((AssociationEnd) element).getMultiplicity();
        }
        newMultiplicity = multiplicity;
    }

    /**
     * <p>
     * Undo the change entity multiplicity action.
     * </p>
     */
    public void undoAction() {
        updateMultiplicity(oldMultiplicity);
    }

    /**
     * <p>
     * Redo the change entity multiplicity action.
     * </p>
     */
    public void redoAction() {
        updateMultiplicity(newMultiplicity);
    }

    /**
     * <p>
     * Execute the change entity multiplicity action.
     * </p>
     */
    public void executeAction() {
        updateMultiplicity(newMultiplicity);
    }

    /**
     * <p>
     * Changes entity's multiplicity property.
     * </p>
     * @param multiplicity
     *            the new value of multiplicity property
     */
    private void updateMultiplicity(Multiplicity multiplicity) {
        if (element instanceof Attribute) {
            ((Attribute) element).setMultiplicity(multiplicity);
        } else {
            ((AssociationEnd) element).setMultiplicity(multiplicity);
        }
    }
}
