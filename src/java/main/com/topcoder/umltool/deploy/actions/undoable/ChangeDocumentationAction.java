/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action changes the documentation of a model element.
 * The documentation is added as a taggedValue to the model element, using the &ldquo;documentation&rdquo;
 * TagDefinition.
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
public class ChangeDocumentationAction extends UndoableAbstractAction implements ReturningAction {

    /**
     * <p>
     * Represents the type name of the &quot;documentation&quot; taggedValue.
     * </p>
     */
    private final String documentName = "documentation";

    /**
     * <p>
     * Represents the &quot;documentation&quot; taggedValue of the model element to be change the documentation.
     * This variable is set in the constructor, is immutable (the reference) and never be null. This variable is
     * referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final TaggedValue taggedValue;

    /**
     * <p>
     * Represents the old documentation of the model element before this action performed. This variable is set in
     * the constructor, is immutable (the reference) and can be null, possible empty. This variable is referenced
     * in the undoAction method.
     * </p>
     */
    private final String oldDocumentation;

    /**
     * <p>
     * Represents the new documentation of the model element after this action performed. This variable is set in
     * the constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced
     * in the redoAction and executeAction methods.
     * </p>
     */
    private final String newDocumentation;

    private List<UpdateModelElementAction> actions;

    /**
     * <p>
     * Constructor of the change documentation action.
     * </p>
     *
     * @param element
     *            the non null model element to be change the documentation
     * @param documentation
     *            the non null, possible empty new documentation of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeDocumentationAction(ModelElement element, String documentation) {
        super("Change documentation to " + documentation);
        Helper.checkNotNull(element, "element");
        Helper.checkNotNull(documentation, "documentation");
        Iterator<TaggedValue> iter = element.getTaggedValues().iterator();
        TaggedValue value = null;
        while (iter.hasNext()) {
            value = iter.next();
            if (value.getType().getTagType().equals(documentName)) {
                break;
            }
            value = null;
        }

        if (value == null) {
            // create new one if we can't find it in the element
            TagDefinition tagDefinition = getDocumentationTagDefinition();
            taggedValue = new TaggedValueImpl();
            taggedValue.setType(tagDefinition);
            element.addTaggedValue(taggedValue);
        } else {
            taggedValue = value;
        }
        oldDocumentation = taggedValue.getDataValue();
        newDocumentation = documentation;

        actions = new ArrayList<UpdateModelElementAction>();

        if (element instanceof Operation) {
            Operation operation = (Operation) element;
            List<Operation> childOps = getAllExtensions(operation);

            for (Operation childOperation : childOps) {
                Classifier owner = childOperation.getOwner();
                UpdateModelElementAction action = new UpdateModelElementAction(owner);
                action.put(new ChangeDocumentationAction(childOperation, documentation), childOperation);
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
                action.put(new ChangeDocumentationAction(p, documentation), p);
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
     * Redo the changes the documentation.
     * </p>
     */
    public void redoAction() {
        taggedValue.setDataValue(newDocumentation);
    }

    /**
     * <p>
     * Undo the changes the documentation.
     * </p>
     */
    public void undoAction() {
        taggedValue.setDataValue(oldDocumentation);
    }

    /**
     * <p>
     * Execute the changes the documentation.
     * </p>
     */
    public void executeAction() {
        taggedValue.setDataValue(newDocumentation);
    }

    /**
     * <p>
     * Gets the tag definition of documentaion.
     * </p>
     *
     * @return the tag definition
     */
    private TagDefinition getDocumentationTagDefinition() {
        UMLModelManager manager = UMLModelManager.getInstance();
        Model root = manager.getModel();

        // traverse all the model elements owned by the root model
        for (ModelElement modelElement : root.getOwnedElements()) {
            if (modelElement instanceof TagDefinition) {
                if (documentName.equals(((TagDefinition) modelElement).getTagType())) {
                    return (TagDefinition) modelElement;
                }
            }
        }

        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType(documentName);
        tagDefinition.setNamespace(root);
        root.addOwnedElement(tagDefinition);
        return tagDefinition;
    }

    public List<UpdateModelElementAction> getActions() {
        return actions;
    }
}
