/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.topcoder.uml.actions.general.operationtypes.SetEntityStereotypesOperationType;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action updates the list of stereotypes
 * of a model element - ModelElement.stereotypes property.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the
 * action, undo to undo the action and execute to execute the action. If any exception prevents
 * redo/undo methods from completing successfully, it should be log with logError.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, rainday
 * @version 1.0
 */
public class SetEntityStereotypesAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the model element to update the stereotype. This variable is set in the
     * constructor, is immutable (the reference). This variable is referenced in the redoAction
     * undoAction and executeAction methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the operation type of the action. This variable is set in the constructor, is
     * immutable (the reference) and never be null. This variable is referenced in the redoAction
     * undoAction and executeAction methods.
     * </p>
     */
    private final SetEntityStereotypesOperationType operationType;

    /**
     * <p>
     * Represents the old stereotypes of the element before this action performed. This variable is
     * set in the constructor, is immutable (the reference). It won't contain null element. This
     * variable is referenced in the undoAction method.
     * </p>
     */
    private final Set<Stereotype> oldStereotypes;

    /**
     * <p>
     * Represents the new stereotypes of the elements after this action performed. This variable is
     * set in the constructor, is immutable (the reference). It won't contain null element. This
     * variable is referenced in the redoAction and executeAction methods.
     * </p>
     */
    private final Set<Stereotype> newStereotypes;

    /**
     * <p>
     * Constructor of the set entity stereotypes action.
     * </p>
     *
     * @param element
     *        the non null model element to update the stereotype
     * @param stereotypes
     *        the non null new stereotypes of the elements
     * @param operationType
     *        the non null operation type of the action
     * @throws IllegalArgumentException
     *         if any non null argument is null
     */
    public SetEntityStereotypesAction(ModelElement element, Set<Stereotype> stereotypes,
            SetEntityStereotypesOperationType operationType) {
        super("Set entity stereotypes");
        Helper.checkNotNull(element, "element");
        Helper.checkNotNull(operationType, "operationType");
        Helper.checkNotNullAndNotContainsNull(stereotypes, "stereotypes");
        this.element = element;
        newStereotypes = stereotypes;
        this.operationType = operationType;
        if (operationType == SetEntityStereotypesOperationType.UPDATE) {
            oldStereotypes = new HashSet<Stereotype>(element.getStereotypes());
        } else {
            oldStereotypes = null;
        }
    }

    /**
     * <p>
     * Execute the set entity stereotype action.
     * </p>
     */
    public void executeAction() {
        redoAction();
    }

    /**
     * <p>
     * Undo the set entity stereotype action.
     * </p>
     */
    public void undoAction() {
        Iterator<Stereotype> newIter = newStereotypes.iterator();
        if (operationType == SetEntityStereotypesOperationType.ADD) {
            while (newIter.hasNext()) {
                element.removeStereotype(newIter.next());
            }
        } else if (operationType == SetEntityStereotypesOperationType.REMOVE) {
            while (newIter.hasNext()) {
                element.addStereotype(newIter.next());
            }
        } else {
            // clear the new stereotypes, changed that to the old ones.
            element.clearStereotypes();
            Iterator<Stereotype> oldIter = oldStereotypes.iterator();
            while (oldIter.hasNext()) {
                element.addStereotype(oldIter.next());
            }
        }
    }

    /**
     * <p>
     * Redo the set entity stereotype action.
     * </p>
     */
    public void redoAction() {
        Iterator<Stereotype> newIter = newStereotypes.iterator();
        if (operationType == SetEntityStereotypesOperationType.ADD) {
            while (newIter.hasNext()) {
                element.addStereotype(newIter.next());
            }
        } else if (operationType == SetEntityStereotypesOperationType.REMOVE) {
            while (newIter.hasNext()) {
                element.removeStereotype(newIter.next());
            }
        } else {
            // clear old stereotypes, add the new ones.
            element.clearStereotypes();
            while (newIter.hasNext()) {
                element.addStereotype(newIter.next());
            }
        }
    }
}
