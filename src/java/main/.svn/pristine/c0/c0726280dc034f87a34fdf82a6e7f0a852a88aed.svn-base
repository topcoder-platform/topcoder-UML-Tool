/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.topcoder.uml.actions.general.Helper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.actions.general.operationtypes.UpdateDocumentationTagsOperationType;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action updates the documentation tags of a model
 * element. The documentation tags are added as taggedValues to the model element.
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
public class UpdateDocumentationTagsAction extends UndoableAbstractAction implements ReturningAction {

    /**
     * <p>
     * Represents the model element to update the documentation tags. This variable is set in the constructor, is
     * immutable (the reference). This variable is referenced in the redoAction undoAction and executeAction
     * methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old documentations of the tags before this action performed. This variable is set in the
     * constructor, is immutable (the reference). The type of the key is TaggedValue, which never be null. The type
     * of the value is String, it will never be null and possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final Map<TaggedValue, String> oldDocumentations;

    /**
     * <p>
     * Represents the operation type of the action. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction
     * methods.
     * </p>
     */
    private final UpdateDocumentationTagsOperationType operationType;

    /**
     * <p>
     * Represents the new documentations of the tags after this action performed. This variable is set in the
     * constructor, is immutable (the reference). The type of the key is TaggedValue, which never be null. The type
     * of the value is String, it will never be null and possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final Map<TaggedValue, String> newDocumentations;

    private List<UpdateModelElementAction> actions;

    /**
     * <p>
     * Constructor of the update documentation tags action.
     * </p>
     *
     * @param element
     *            the non null model element to update the documentation tags
     * @param documentations
     *            the non null new documentations of the tags after this action performed
     * @param operationType
     *            the non null operation type of the action
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public UpdateDocumentationTagsAction(ModelElement element, Map<TaggedValue, String> documentations,
        UpdateDocumentationTagsOperationType operationType) {
        super("Update documentation tags " + operationType);
        Helper.checkNotNull(element, "element");
        Helper.checkNotNull(documentations, "documentations");
        Helper.checkNotNull(operationType, "operationType");
        this.element = element;
        this.operationType = operationType;
        newDocumentations = documentations;
        if (operationType == UpdateDocumentationTagsOperationType.UPDATE) {
            oldDocumentations = new HashMap<TaggedValue, String>();
            Iterator<TaggedValue> iter = documentations.keySet().iterator();
            while (iter.hasNext()) {
                TaggedValue value = iter.next();
                oldDocumentations.put(value, value.getDataValue());
            }
        } else {
            oldDocumentations = null;
        }

        actions = new ArrayList<UpdateModelElementAction>();

        if (element instanceof Operation) {
            Operation operation = (Operation) element;
            List<Operation> childOps = getAllExtensions(operation);

            for (Operation childOperation : childOps) {
                Classifier owner = childOperation.getOwner();
                UpdateModelElementAction action = new UpdateModelElementAction(owner);
                action.put(new UpdateDocumentationTagsAction(childOperation, documentations, operationType),
                    childOperation);
                actions.add(action);
            }
        } else if (element instanceof Parameter) {
            Parameter parameter = (Parameter) element;
            Operation operation = (Operation) parameter.getBehavioralFeature();
            int paramIndex = operation.getParameters().indexOf(parameter);
            List<Operation> childOps = getAllExtensions(operation);

            for (Operation childOperation : childOps) {
                Classifier owner = childOperation.getOwner();
                UpdateModelElementAction action = new UpdateModelElementAction(owner);
                Parameter p = childOperation.getParameters().get(paramIndex);
                action.put(new UpdateDocumentationTagsAction(p, documentations, operationType), p);
                actions.add(action);
            }
        }
    }

    private List<Operation> getAllExtensions(Operation operation) {
        List<Operation> childOps = new ArrayList<Operation>();
        Classifier owner = operation.getOwner();
        if ((owner instanceof Class && operation.isAbstract() && owner.isAbstract()) || owner instanceof Interface) {
            List<Classifier> processingList = new ArrayList<Classifier>();
            processingList.add(owner);

            while (!processingList.isEmpty()) {
                Classifier classifier = processingList.get(0);
                processingList.remove(0);

                if (classifier instanceof Class) {
                    Class clasz = (Class) classifier;

                    boolean isImplemented = false;
                    if (clasz != owner) {
                        for (Feature feature : clasz.getFeatures()) {
                            if (feature instanceof Operation) {
                                Operation childOperation = (Operation) feature;
                                if (DeployHelper.isSameOperation(operation, childOperation)) {
                                    isImplemented = true;
                                    childOps.add(childOperation);
                                }
                            }
                        }
                    }

                    if (!isImplemented && clasz.isAbstract()) {
                        Collection<Generalization> specializations = clasz.getSpecializations();
                        for (Generalization specialization : specializations) {
                            if (specialization.getChild() instanceof Class) {
                                processingList.add((Class) specialization.getChild());
                            }
                        }
                    }
                } else if (classifier instanceof Interface) {
                    Interface ifc = (Interface) classifier;
                    Collection<Generalization> specializations = ifc.getSpecializations();
                    for (Generalization specialization : specializations) {
                        if (specialization.getChild() instanceof Interface) {
                            processingList.add((Interface) specialization.getChild());
                        }
                    }
                    Collection<Dependency> clientDependencies = ifc.getSupplierDependencies();
                    for (Dependency dependency : clientDependencies) {
                        if (dependency instanceof Abstraction) {
                            for (ModelElement modelElement : dependency.getClients()) {
                                if (modelElement instanceof Class) {
                                    processingList.add((Class) modelElement);
                                }
                            }
                        }
                    }
                }
            }

        }
        return childOps;
    }

    /**
     * <p>
     * Redo the update documentation tags action.
     * </p>
     */
    public void redoAction() {
        Iterator<TaggedValue> iter = newDocumentations.keySet().iterator();
        if (operationType == UpdateDocumentationTagsOperationType.ADD) {
            while (iter.hasNext()) {
                element.addTaggedValue(iter.next());
            }
        } else if (operationType == UpdateDocumentationTagsOperationType.REMOVE) {
            while (iter.hasNext()) {
                element.removeTaggedValue(iter.next());
            }
        } else if (operationType == UpdateDocumentationTagsOperationType.UPDATE) {
            while (iter.hasNext()) {
                TaggedValue value = iter.next();
                value.setDataValue(newDocumentations.get(value));
            }
        }
    }

    /**
     * <p>
     * Undo the update documentation tags action.
     * </p>
     */
    public void undoAction() {
        Iterator<TaggedValue> iter = newDocumentations.keySet().iterator();
        if (operationType == UpdateDocumentationTagsOperationType.ADD) {
            while (iter.hasNext()) {
                element.removeTaggedValue(iter.next());
            }
        } else if (operationType == UpdateDocumentationTagsOperationType.REMOVE) {
            while (iter.hasNext()) {
                element.addTaggedValue(iter.next());
            }
        } else if (operationType == UpdateDocumentationTagsOperationType.UPDATE) {
            while (iter.hasNext()) {
                TaggedValue value = iter.next();
                value.setDataValue(oldDocumentations.get(value));
            }
        }
    }

    /**
     * <p>
     * Execute the update documentation tags action.
     * </p>
     */
    public void executeAction() {
        redoAction();
    }

    public List<UpdateModelElementAction> getActions() {
        return actions;
    }
}
