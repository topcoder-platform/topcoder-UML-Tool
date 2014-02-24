/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.topcoder.uml.actions.general.Helper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the name of a model element -
 * ModelElement.name property.
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
public class ChangeEntityNameAction extends UndoableAbstractAction implements ReturningAction {

    /**
     * <p>
     * Represents the model element to change the name. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction
     * methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old name of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in
     * the undoAction method.
     * </p>
     */
    private final String oldName;

    /**
     * <p>
     * Represents the new name of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in
     * the redoAction and executeAction methods.
     * </p>
     */
    private final String newName;

    private List<UpdateModelElementAction> actions;

    /**
     * <p>
     * Constructor of the change entity name action.
     * </p>
     *
     * @param element
     *            the non null model element to change the name
     * @param name
     *            the non null, possible empty new name of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeEntityNameAction(ModelElement element, String name, boolean autoGenerate) {
        super("Change entity name to " + name);
        Helper.checkNotNull(element, "element");
        Helper.checkNotNull(name, "name");
        this.element = element;
        oldName = element.getName();
        newName = name;

        if (autoGenerate) {
            actions = new ArrayList<UpdateModelElementAction>();

            if (element instanceof Operation) {
                Operation operation = (Operation) element;
                List<Operation> childOps = getAllExtensions(operation);

                for (Operation childOperation : childOps) {
                    Classifier owner = childOperation.getOwner();
                    UpdateModelElementAction action = new UpdateModelElementAction(owner);
                    action.put(new ChangeEntityNameAction(childOperation, name, false));
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
                    action.put(new ChangeEntityNameAction(childOperation.getParameters().get(paramIndex), name,
                        false));
                    actions.add(action);
                }
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
     * Execute the change entity name actions.
     * </p>
     */
    public void executeAction() {
        element.setName(newName);
    }

    /**
     * <p>
     * Undo the change entity name action.
     * </p>
     */
    public void undoAction() {
        element.setName(oldName);
    }

    /**
     * <p>
     * Redo the change entity name action.
     * </p>
     */
    public void redoAction() {
        element.setName(newName);
    }

    public List<UpdateModelElementAction> getActions() {
        return actions;
    }
}
