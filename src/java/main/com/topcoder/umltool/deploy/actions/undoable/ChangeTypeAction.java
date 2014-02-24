/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.InstanceAbstractImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.StructuralFeature;
import com.topcoder.uml.model.core.StructuralFeatureAbstractImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the type property of a model
 * element.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the action, undo
 * to undo the action and execute to execute the action.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeTypeAction extends UndoableAbstractAction implements ReturningAction {
    /**
     * <p>
     * Represents the model element to change the type. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction
     * methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old type of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in
     * the undoAction method.
     * </p>
     */
    private final Classifier oldClassifier;

    /**
     * <p>
     * Represents the new type of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in
     * the redoAction and executeAction methods.
     * </p>
     */
    private final Classifier newClassifier;

    private List<UpdateModelElementAction> actions;

    /**
     * <p>
     * Creates an instance of the ChangeTypeAction.
     * </p>
     *
     * @param element
     *            the non null model element to change the type
     * @param classifier
     *            the new type of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeTypeAction(ModelElement element, Classifier classifier, boolean autoGenerate) {
        super("Change classifier to " + classifier);
        DeployHelper.checkNotNull(element, "element");
        DeployHelper.checkNotNull(classifier, "classifier");
        this.element = element;
        if (element instanceof StructuralFeature) {
            oldClassifier = ((StructuralFeature) element).getType();
            StructuralFeatureAbstractImpl.setType((StructuralFeature) element, null);
        } else if (element instanceof Parameter) {
            actions = new ArrayList<UpdateModelElementAction>();
            oldClassifier = ((Parameter) element).getType();
            if (autoGenerate) {
                Parameter parameter = (Parameter) element;
                Operation operation = (Operation) parameter.getBehavioralFeature();
                int paramIndex = operation.getParameters().indexOf(parameter);
                List<Operation> childOps = DeployHelper.getAllExtensions(operation);

                for (Operation childOperation : childOps) {
                    Classifier owner = childOperation.getOwner();
                    UpdateModelElementAction action = new UpdateModelElementAction(owner);
                    action.put(new ChangeTypeAction(childOperation.getParameters().get(paramIndex), classifier,
                        false));
                    actions.add(action);
                }
            }
            ParameterImpl.setType((Parameter) element, null);
        } else if (element instanceof AssociationEnd) {
            oldClassifier = ((AssociationEnd) element).getParticipant();
        } else if (element instanceof Instance) {
            oldClassifier = ((Instance) element).getClassifier();
            InstanceAbstractImpl.setClassifier((Instance) element, null);
        } else {
            oldClassifier = null;
        }
        newClassifier = classifier;

    }

    /**
     * <p>
     * Undo the change entity type action.
     * </p>
     */
    public void undoAction() {
        updateType(oldClassifier);
    }

    /**
     * <p>
     * Redo the change entity type action.
     * </p>
     */
    public void redoAction() {
        updateType(newClassifier);
    }

    /**
     * <p>
     * Execute the change entity type action.
     * </p>
     */
    public void executeAction() {
        updateType(newClassifier);
    }

    /**
     * <p>
     * Changes entity's type property.
     * </p>
     *
     * @param classifier
     *            the new value of type property
     */
    private void updateType(Classifier classifier) {
        if (element instanceof StructuralFeature) {
            StructuralFeatureAbstractImpl.setType((StructuralFeature) element, classifier);
        } else if (element instanceof Parameter) {
            ParameterImpl.setType((Parameter) element, classifier);
        } else if (element instanceof AssociationEnd) {
            ((AssociationEnd) element).setParticipant(classifier);
        } else if (element instanceof Instance) {
            InstanceAbstractImpl.setClassifier((Instance) element, classifier);
        }
    }

    public List<UpdateModelElementAction> getActions() {
        return actions;
    }
}
