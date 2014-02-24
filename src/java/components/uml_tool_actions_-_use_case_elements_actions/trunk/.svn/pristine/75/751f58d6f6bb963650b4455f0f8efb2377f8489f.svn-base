/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.Method;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.StructuralFeature;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.statemachines.StateMachine;

import java.awt.datatransfer.Clipboard;

/**
 * <p>
 * This abstract class provides similar simple operations which are the same for all actions classes. Its children
 * provides unique logic for each element.
 * </p>
 *
 * <p>
 * Class is thread safety because it is immutable.
 * </p>
 *
 * <p>
 * This class also used in parameters of all abstract actions classes.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
abstract class UsecaseToolUtil {
    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    protected UsecaseToolUtil() {
    }

    /**
     * <p>
     * This methods provides adding ModelElement instance to namespace or directly to Model.
     * </p>
     *
     * @param modelElement ModelElement instance, should not be null.
     * @param namespace Namespace instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public void addElementToModel(ModelElement modelElement, Namespace namespace) {
        Helper.checkNull("modelElement", modelElement);
        Helper.checkNull("namespace", namespace);
        modelElement.setNamespace(namespace);
        modelElement.getNamespace().addOwnedElement(modelElement);
    }

    /**
     * <p>
     * This methods provides removing ModelElement instance from namespace.
     * </p>
     *
     * @param modelElement ModelElement instance, should not be null.
     *
     * @return true if deleted, otherwise false
     *
     * @throws IllegalArgumentException when parameter is null
     */
    public boolean removeElementFromModel(ModelElement modelElement) {
        Helper.checkNull("modelElement", modelElement);

        return (modelElement.getNamespace() == null) ? false
                                                     : modelElement.getNamespace().removeOwnedElement(modelElement);
    }

    /**
     * <p>
     * This methods provides adding ModelElement instance to clipboard.
     * </p>
     *
     * @param modelElement ModelElement instance, should not be null.
     * @param clipboard Clipboard instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null.
     */
    public abstract void addElementToClipboard(ModelElement modelElement, Clipboard clipboard);

    /**
     * <p>
     * This methods copy special attributes of given ModelElement, create new instance of ModelElement and return
     * it.This method should be implemented for each elements separately.
     * </p>
     *
     * @param modelElement ModelElement instance, should not be null.
     *
     * @return a ModelElement instance
     *
     * @throws IllegalArgumentException when parameter is null
     */
    public abstract ModelElement copyElement(ModelElement modelElement);

    /**
     * <p>
     * This method provides copying attributes which was inherited from  class - ModelElement. Copy these attributes as
     * described in the specification from old instance to new:
     * </p>
     *
     * <p>
     * for simple attributes and Strings, we copy them by value.
     * </p>
     *
     * <ol>
     * <li>
     * name
     * </li>
     * <li>
     * isSpecification
     * </li>
     * <li>
     * visibility
     * </li>
     * </ol>
     *
     * <p>
     * for Aggregation, such as stereotypes typedParameters ... we copy them by reference.
     * </p>
     *
     * <ol>
     * <li>
     * stereotypes
     * </li>
     * <li>
     * templateParameters
     * </li>
     * <li>
     * templateArguments
     * </li>
     * <li>
     * elementImports
     * </li>
     * <li>
     * behaviors
     * </li>
     * </ol>
     *
     * <p>
     * for other attributes we copy them by creating new instance.
     * </p>
     *
     * <ol>
     * <li>
     * taggedValues
     * </li>
     * <li>
     * referenceTags
     * </li>
     * <li>
     * parameterTemplate
     * </li>
     * <li>
     * defaultParameters
     * </li>
     * </ol>
     *
     *
     * @param oldModelElement oldModelElement ModelElement instance, should not be null.
     * @param newModelElement newModelElement ModelElement instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null.
     */
    protected void copyModelElementAttributes(ModelElement oldModelElement, ModelElement newModelElement) {
        Helper.checkNull("oldModelElement", oldModelElement);
        Helper.checkNull("newModelElement", newModelElement);
        //for simple attributes and Strings, we copy them by value.
        newModelElement.setName(oldModelElement.getName());
        newModelElement.setSpecification(oldModelElement.isSpecification());
        newModelElement.setVisibility(oldModelElement.getVisibility());

        //for Aggregation, such as stereotypes typedParameters ... we copy them by reference.
        for (Stereotype stereotype : oldModelElement.getStereotypes()) {
            stereotype.addExtendedElement(newModelElement);
            newModelElement.addStereotype(stereotype);
        }

        for (TemplateParameter parameter : oldModelElement.getTemplateParameters()) {
            newModelElement.addTemplateParameter(parameter);
        }

        for (TemplateArgument argument : oldModelElement.getTemplateArguments()) {
           newModelElement.addTemplateArgument(argument);
        }

        for (ElementImport elementImport : oldModelElement.getElementImports()) {
            newModelElement.addElementImport(elementImport);
        }

        for (StateMachine stateMachine : oldModelElement.getBehaviors()) {
            newModelElement.addBehavior(stateMachine);
        }

        //for other attributes we copy them by creating new instance.
        for (TaggedValue oldValue : oldModelElement.getTaggedValues()) {
            newModelElement.addTaggedValue(new TaggedValueImpl(oldValue.getDataValue(), oldValue.getType(),
                    newModelElement, oldValue.getReferenceValues()));
        }

        for (TaggedValue oldValue : oldModelElement.getReferenceTags()) {
            newModelElement.addReferenceTag(new TaggedValueImpl(oldValue.getDataValue(), oldValue.getType(),
                    newModelElement, oldValue.getReferenceValues()));
        }

        TemplateParameter newTemplateParameter = new TemplateParameterImpl();
        newTemplateParameter.setParameter(newModelElement);

        if (oldModelElement.getParameterTemplate() != null) {
            newTemplateParameter.setDefaultElement(oldModelElement.getParameterTemplate().getDefaultElement());
            newTemplateParameter.setTemplate(oldModelElement.getParameterTemplate().getTemplate());
        }

        newModelElement.setParameterTemplate(newTemplateParameter);

        for (TemplateParameter oldDefault : oldModelElement.getDefaultParameters()) {
            TemplateParameter newDefault = new TemplateParameterImpl();
            newDefault.setParameter(newModelElement);
            newDefault.setDefaultElement(oldDefault.getDefaultElement());
            newDefault.setTemplate(oldDefault.getTemplate());
            newModelElement.addDefaultParameter(newDefault);
        }
    }

    /**
     * <p>
     * This method provides copying attributes which was inherited from class  - Classifier and its parent
     * GeneralizableElement.
     * </p>
     *
     * <p>
     * For simple attributes and Strings, we copy them by value.
     * </p>
     *
     * <ol>
     * <li>
     * isRoot
     * </li>
     * <li>
     * isLeaf
     * </li>
     * <li>
     * isAbstract
     * </li>
     * </ol>
     *
     * <p>
     * for Aggregation, we copy them by reference.
     * </p>
     *
     * <ol>
     * <li>
     * typedFeatures
     * </li>
     * <li>
     * typedParameters
     * </li>
     * <li>
     * powertypeRanges
     * </li>
     * <li>
     * objectFlowStates
     * </li>
     * <li>
     * instances
     * </li>
     * </ol>
     *
     * <p>
     * for features attribute we copy them by creating new instance.
     * </p>
     *
     * <ol>
     * <li>
     * features
     * </li>
     * </ol>
     *
     *
     * @param oldClassifier oldClassifier Classifier instance, should not be null.
     * @param newClassifier newClassifier Classifier instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null.
     */
    protected void copyClassifierAttributes(Classifier oldClassifier, Classifier newClassifier) {
        Helper.checkNull("oldClassifier", oldClassifier);
        Helper.checkNull("newClassifier", newClassifier);
        //for simple attributes and Strings, we copy them by value.
        newClassifier.setRoot(oldClassifier.isRoot());
        newClassifier.setLeaf(oldClassifier.isLeaf());
        newClassifier.setAbstract(oldClassifier.isAbstract());

        //for Aggregation, such as typedFeatures typedParameters ... we copy them by reference.
        for (StructuralFeature structuralFeature : oldClassifier.getTypedFeatures()) {
            newClassifier.addTypedFeature(structuralFeature);
            structuralFeature.setType(newClassifier);
        }

        for (Parameter parameter : oldClassifier.getTypedParameters()) {
            newClassifier.addTypedParameter(parameter);
            parameter.setType(newClassifier);
        }

        for (Generalization generalization : oldClassifier.getPowertypeRanges()) {
            newClassifier.addPowertypeRange(generalization);
            generalization.setPowertype(newClassifier);
        }

        for (ObjectFlowState objectFlowState : oldClassifier.getObjectFlowStates()) {
            newClassifier.addObjectFlowState(objectFlowState);
            objectFlowState.setType(newClassifier);
        }

        for (Instance instance : oldClassifier.getInstances()) {
            newClassifier.addInstance(instance);
            instance.setClassifier(newClassifier);
        }

        //for features attribute we copy them by creating new instance.
        for (Feature oldFeature : oldClassifier.getFeatures()) {
            if (oldFeature instanceof Attribute) {
                Attribute oldAttribute = (Attribute) oldFeature;
                Attribute newAttribute = new AttributeImpl();
                //add to the classifier
                newClassifier.addFeature(newAttribute);
                copyAttribute(newAttribute, oldAttribute, newClassifier);
            } else if (oldFeature instanceof Method) {
                Method oldMethod = (Method) oldFeature;
                Method newMethod = new MethodImpl();
                //add to the classifier
                newClassifier.addFeature(newMethod);
                copyMethod(newMethod, oldMethod, newClassifier);
            } else if (oldFeature instanceof Operation) {
                Operation oldOperation = (Operation) oldFeature;
                Operation newOperation = new OperationImpl();
                //add to the classifier
                newClassifier.addFeature(newOperation);
                copyOperation(newOperation, oldOperation, newClassifier);
            }
        }
    }

    /**
     * Copy the following Attribute attributes.
     *
     * <ol>
     * <li>
     * Owner
     * </li>
     * <li>
     * OwnerScope
     * </li>
     * <li>
     * Multiplicity
     * </li>
     * <li>
     * Changeability
     * </li>
     * <li>
     * TargetScope
     * </li>
     * <li>
     * Type
     * </li>
     * <li>
     * InitialValue
     * </li>
     * <li>
     * AssociationEnd
     * </li>
     * <li>
     * And other attributes in the model element.
     * </li>
     * </ol>
     *
     * @param newAttribute the new Attribute.
     * @param oldAttribute the old Attribute.
     * @param newClassifier the new Classifier.
     */
    private void copyAttribute(Attribute newAttribute, Attribute oldAttribute, Classifier newClassifier) {
        //set the attributes
        newAttribute.setOwner(newClassifier);
        newAttribute.setOwnerScope(oldAttribute.getOwnerScope());
        newAttribute.setMultiplicity(oldAttribute.getMultiplicity());
        newAttribute.setChangeability(oldAttribute.getChangeability());
        newAttribute.setTargetScope(oldAttribute.getTargetScope());
        newAttribute.setType(newClassifier);
        newAttribute.setInitialValue(oldAttribute.getInitialValue());
        newAttribute.setAssociationEnd(oldAttribute.getAssociationEnd());
        //copy other attributes
        copyModelElementAttributes(oldAttribute, newAttribute);
    }

    /**
     * Copy the following Method attributes.
     *
     * <ol>
     * <li>
     * Owner
     * </li>
     * <li>
     * OwnerScope
     * </li>
     * <li>
     * Query
     * </li>
     * <li>
     * Parameters
     * </li>
     * <li>
     * Body
     * </li>
     * <li>
     * Specification
     * </li>
     * <li>
     * Procedure
     * </li>
     * <li>
     * And other attributes in the model element.
     * </li>
     * </ol>
     *
     * @param newMethod the new Method.
     * @param oldMethod the old Method.
     * @param newClassifier the new Classifier.
     */
    private void copyMethod(Method newMethod, Method oldMethod, Classifier newClassifier) {
        //set the attributes
        newMethod.setOwner(newClassifier);
        newMethod.setOwnerScope(oldMethod.getOwnerScope());
        newMethod.setQuery(oldMethod.isQuery());

        for (Parameter oldParameter : oldMethod.getParameters()) {
            Parameter newParameter = new ParameterImpl();
            newMethod.addParameter(newParameter);
            newParameter.setDefaultValue(oldParameter.getDefaultValue());
            newParameter.setKind(oldParameter.getKind());
            newParameter.setType(newClassifier);
            newParameter.setBehavioralFeature(oldParameter.getBehavioralFeature());
            copyModelElementAttributes(oldParameter, newParameter);
        }

        newMethod.setBody(oldMethod.getBody());
        newMethod.setSpecification(oldMethod.getSpecification());
        newMethod.setProcedure(oldMethod.getProcedure());
        //copy other attributes
        copyModelElementAttributes(oldMethod, newMethod);
    }

    /**
     * Copy the following Operation attributes.
     *
     * <ol>
     * <li>
     * Owner
     * </li>
     * <li>
     * OwnerScope
     * </li>
     * <li>
     * Query
     * </li>
     * <li>
     * Parameters
     * </li>
     * <li>
     * Concurrency
     * </li>
     * <li>
     * isRoot
     * </li>
     * <li>
     * isLeaf
     * </li>
     * <li>
     * isAbstract
     * </li>
     * <li>
     * Specification
     * </li>
     * <li>
     * Methods
     * </li>
     * <li>
     * And other attributes in the model element.
     * </li>
     * </ol>
     *
     * @param newOperation the new Operation.
     * @param oldOperation the old Operation.
     * @param newClassifier the new Classifier.
     */
    private void copyOperation(Operation newOperation, Operation oldOperation, Classifier newClassifier) {
        //set the attributes
        newOperation.setOwner(newClassifier);
        newOperation.setOwnerScope(oldOperation.getOwnerScope());
        newOperation.setQuery(oldOperation.isQuery());

        for (Parameter oldParameter : oldOperation.getParameters()) {
            Parameter newParameter = new ParameterImpl();
            newOperation.addParameter(newParameter);
            newParameter.setDefaultValue(oldParameter.getDefaultValue());
            newParameter.setKind(oldParameter.getKind());
            newParameter.setType(newClassifier);
            newParameter.setBehavioralFeature(oldParameter.getBehavioralFeature());
            copyModelElementAttributes(oldParameter, newParameter);
        }

        newOperation.setConcurrency(oldOperation.getConcurrency());
        newOperation.setRoot(oldOperation.isRoot());
        newOperation.setLeaf(oldOperation.isLeaf());
        newOperation.setAbstract(oldOperation.isAbstract());
        newOperation.setSpecification(oldOperation.getSpecification());

        for (Method oldMethod : oldOperation.getMethods()) {
            Method newMethod = new MethodImpl();
            newOperation.addMethod(newMethod);
            copyMethod(newMethod, oldMethod, newClassifier);
        }

        //set other attributes
        copyModelElementAttributes(oldOperation, newOperation);
    }
}
