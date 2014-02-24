/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

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
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.statemachines.StateMachine;

/**
 * <p>
 * This abstract class provides similar simple operations which are the same for all actions classes. Its children
 * provides unique logic for each element.This class also used in parameters of all abstract actions classes.
 * </p>
 * <p>
 * Thread-safety: Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
abstract class ClassToolUtil {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    protected ClassToolUtil() {
    }

    /**
     * <p>
     * This methods provide adding ModelElement instance to namespace or directly to Model.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible;
     * @param namespace
     *            Namespace instance, null impossible
     * @throws IllegalArgumentException
     *             when modelElement or namespace is null
     */
    public void addElementToModel(ModelElement modelElement, Namespace namespace) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }
        if (namespace == null) {
            throw new IllegalArgumentException("Param namespace should not be null.");
        }

        modelElement.setNamespace(namespace);
        modelElement.getNamespace().addOwnedElement(modelElement);
    }

    /**
     * <p>
     * This methods provide removing ModelElement instance from namespace.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible;
     * @return true if deleted, otherwise false
     * @throws IllegalArgumentException
     *             when modelElement is null
     */
    public boolean removeElementFromModel(ModelElement modelElement) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }
        if (modelElement.getNamespace() == null) {
            throw new IllegalArgumentException("Param modelElement's namespace should not be null.");
        }

        return modelElement.getNamespace().removeOwnedElement(modelElement);
    }

    /**
     * <p>
     * This methods provide adding ModelElement instance to clipboard.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @param clipboard
     *            Clipboard instance, null impossible
     * @throws IllegalArgumentException
     *             when some parameter is null
     */
    public abstract void addElementToClipboard(ModelElement modelElement, Clipboard clipboard);

    /**
     * <p>
     * This methods copy special attributes of given ModelElement, create new instance of ModelElement and return
     * it.This method should be implemented for each elements separatly.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @return created ModelElement instance
     * @throws IllegalArgumentException
     *             when modelElement is null
     */
    public abstract ModelElement copyElement(ModelElement modelElement);

    /**
     * <p>
     * This method provide copying attributes which was inherited from class - ModelElement.
     * </p>
     *
     * @param oldModelElement
     *            ModelElement instance, null impossible
     * @param newModelElement
     *            ModelElement instance, null impossible
     * @throws IllegalArgumentException
     *             when oldModelElement or newModelElement is null
     */
    protected void copyModelElementAttributes(ModelElement oldModelElement, ModelElement newModelElement) {
        if (oldModelElement == null) {
            throw new IllegalArgumentException("Param oldModelElement should not be null.");
        }
        if (newModelElement == null) {
            throw new IllegalArgumentException("Param newModelElement should not be null.");
        }

        // 1. simple
        newModelElement.setName(oldModelElement.getName());
        newModelElement.setVisibility(oldModelElement.getVisibility());
        newModelElement.setSpecification(oldModelElement.isSpecification());

        // 2. by reference
        // 2.1 stereotypes
        for (Stereotype stereoType : oldModelElement.getStereotypes()) {
            newModelElement.addStereotype(stereoType);
            stereoType.addExtendedElement(newModelElement);
        }
        // 2.2 templateParameters
        for (TemplateParameter templateParameter : oldModelElement.getTemplateParameters()) {
            newModelElement.addTemplateParameter(templateParameter);
        }
        // 2.3 templateArguments
        for (TemplateArgument templateArgument : oldModelElement.getTemplateArguments()) {
            newModelElement.addTemplateArgument(templateArgument);
        }
        // 2.4 elementImports
        for (ElementImport elementImport : oldModelElement.getElementImports()) {
            newModelElement.addElementImport(elementImport);
        }
        // 2.5 behaviors
        for (StateMachine stateMachine : oldModelElement.getBehaviors()) {
            newModelElement.addBehavior(stateMachine);
        }

        // 3. by creating new object
        // 3.1 taggedValues
        for (TaggedValue tempTaggedValue : oldModelElement.getTaggedValues()) {
            TaggedValue newTaggedValue = new TaggedValueImpl();

            // copying attributes from tempTaggedValue to newTaggedValue
            copyModelElementAttributes(tempTaggedValue, newTaggedValue);

            newTaggedValue.setDataValue(tempTaggedValue.getDataValue());

            newTaggedValue.setType(tempTaggedValue.getType());

            for (ModelElement modelElement : tempTaggedValue.getReferenceValues()) {
                newTaggedValue.addReferenceValue(modelElement);
            }

            newModelElement.addTaggedValue(newTaggedValue);
            newTaggedValue.setModelElement(newModelElement);
        }
        // 3.2 referenceTags
        for (TaggedValue tempReferenceTag : oldModelElement.getReferenceTags()) {
            TaggedValue newReferenceTag = new TaggedValueImpl();

            // copying attributes from tempTaggedValue to newTaggedValue
            copyModelElementAttributes(tempReferenceTag, newReferenceTag);

            newReferenceTag.setDataValue(tempReferenceTag.getDataValue());
            newReferenceTag.setType(tempReferenceTag.getType());
            for (ModelElement modelElement : tempReferenceTag.getReferenceValues()) {
                newReferenceTag.addReferenceValue(modelElement);
            }

            newModelElement.addReferenceTag(newReferenceTag);
            newReferenceTag.setModelElement(newModelElement);
        }
        // 3.3 parameterTemplate
        TemplateParameter tempParameterTemplate = oldModelElement.getParameterTemplate();
        if (tempParameterTemplate != null) {
            TemplateParameter newParameterTemplate = new TemplateParameterImpl();

            newParameterTemplate.setParameter(tempParameterTemplate.getParameter());
            newParameterTemplate.setDefaultElement(tempParameterTemplate.getDefaultElement());
            newParameterTemplate.setTemplate(tempParameterTemplate.getTemplate());

            newModelElement.setParameterTemplate(newParameterTemplate);
        }
        // 3.4 defaultParameters
        for (TemplateParameter tempDefaultParameter : oldModelElement.getDefaultParameters()) {
            TemplateParameter newDefaultParameter = new TemplateParameterImpl();

            newDefaultParameter.setParameter(tempDefaultParameter.getParameter());
            newDefaultParameter.setDefaultElement(tempDefaultParameter.getDefaultElement());
            newDefaultParameter.setTemplate(tempDefaultParameter.getTemplate());

            newModelElement.addDefaultParameter(newDefaultParameter);
        }
    }

    /**
     * <p>
     * This method provide copying attributes which was inherited from class - Classifier and its parent
     * GeneralizableElement.
     * </p>
     *
     * @param oldClassifier
     *            Classifier instance, null impossible
     * @param newClassifier
     *            Classifier instance, null impossible
     * @throws IllegalArgumentException
     *             when oldClassifier or newClassifier is null
     */
    protected void copyClassifierAttributes(Classifier oldClassifier, Classifier newClassifier) {
        if (oldClassifier == null) {
            throw new IllegalArgumentException("Param oldClassifier should not be null.");
        }
        if (newClassifier == null) {
            throw new IllegalArgumentException("Param newClassifier should not be null.");
        }

        // 1. simple
        newClassifier.setRoot(oldClassifier.isRoot());
        newClassifier.setLeaf(oldClassifier.isLeaf());
        newClassifier.setAbstract(oldClassifier.isAbstract());

        // 2. by reference
        // 2.1 typedFeatures
        for (StructuralFeature typedFeature : oldClassifier.getTypedFeatures()) {
            newClassifier.addTypedFeature(typedFeature);
        }
        // 2.2 typedParameters
        for (Parameter parameter : oldClassifier.getTypedParameters()) {
            newClassifier.addTypedParameter(parameter);
        }
        // 2.3 powertypeRanges
        for (Generalization generalization : oldClassifier.getPowertypeRanges()) {
            newClassifier.addPowertypeRange(generalization);
        }
        // 2.4 objectFlowStates
        for (ObjectFlowState objectFlowState : oldClassifier.getObjectFlowStates()) {
            newClassifier.addObjectFlowState(objectFlowState);
        }
        // 2.5 instances
        for (Instance instance : oldClassifier.getInstances()) {
            newClassifier.addInstance(instance);
        }

        // 3. by creating new object
        for (Feature oldFeature : oldClassifier.getFeatures()) {
            if (oldFeature instanceof Attribute) {
                Attribute newAttribute = new AttributeImpl();
                Attribute oldAttribute = (Attribute) oldFeature;

                // simple and reference
                newAttribute.setOwner(newClassifier);
                newAttribute.setOwnerScope(oldAttribute.getOwnerScope());

                newAttribute.setMultiplicity(oldAttribute.getMultiplicity());
                newAttribute.setChangeability(oldAttribute.getChangeability());
                newAttribute.setTargetScope(oldAttribute.getTargetScope());
                // no need to force two way association since it's already handled before directly
                newAttribute.setType(oldAttribute.getType());

                /*
                 * Bugfix: UML-12686
                 */
                // old code
                // newAttribute.setInitialValue(oldAttribute.getInitialValue());
                Expression oldInitialValue = oldAttribute.getInitialValue();
                if (oldInitialValue != null) {
                    Expression newInitialValue = new ExpressionImpl();
                    newInitialValue.setProcedure(oldInitialValue.getProcedure());
                    newInitialValue.setLanguage(oldInitialValue.getLanguage());
                    newInitialValue.setBody(oldInitialValue.getBody());
                    newAttribute.setInitialValue(newInitialValue);
                } else {
                    newAttribute.setInitialValue(null);
                }

                newAttribute.setAssociationEnd(oldAttribute.getAssociationEnd());

                copyModelElementAttributes(oldAttribute, newAttribute);

                newClassifier.addFeature(newAttribute);
            } else if (oldFeature instanceof Operation) {
                Operation newOperation = new OperationImpl();
                Operation oldOperation = (Operation) oldFeature;

                // simple and reference
                newOperation.setOwner(newClassifier);
                newOperation.setOwnerScope(oldOperation.getOwnerScope());

                newOperation.setQuery(oldOperation.isQuery());

                newOperation.setConcurrency(oldOperation.getConcurrency());
                newOperation.setRoot(oldOperation.isRoot());
                newOperation.setLeaf(oldOperation.isLeaf());
                newOperation.setAbstract(oldOperation.isAbstract());
                newOperation.setSpecification(oldOperation.getSpecification());
                for (Method method : oldOperation.getMethods()) {
                    newOperation.addMethod(method);
                }

                // creation
                for (Parameter oldParameter : oldOperation.getParameters()) {
                    Parameter newParameter = new ParameterImpl();

                    newParameter.setDefaultValue(oldParameter.getDefaultValue());
                    newParameter.setKind(oldParameter.getKind());
                    newParameter.setType(oldParameter.getType());
                    newParameter.setBehavioralFeature(newOperation);

                    copyModelElementAttributes(oldParameter, newParameter);

                    newOperation.addParameter(newParameter);
                }

                copyModelElementAttributes(oldOperation, newOperation);

                newClassifier.addFeature(newOperation);
            } else if (oldFeature instanceof Method) {
                Method newMethod = new MethodImpl();
                Method oldMethod = (Method) oldFeature;

                // simple and reference
                newMethod.setOwner(newClassifier);
                newMethod.setOwnerScope(oldMethod.getOwnerScope());

                newMethod.setQuery(oldMethod.isQuery());

                newMethod.setBody(oldMethod.getBody());
                newMethod.setSpecification(oldMethod.getSpecification());
                newMethod.setProcedure(oldMethod.getProcedure());

                // creation
                for (Parameter oldParameter : oldMethod.getParameters()) {
                    Parameter newParameter = new ParameterImpl();

                    newParameter.setDefaultValue(oldParameter.getDefaultValue());
                    newParameter.setKind(oldParameter.getKind());
                    newParameter.setType(oldParameter.getType());
                    newParameter.setBehavioralFeature(newMethod);

                    copyModelElementAttributes(oldParameter, newParameter);

                    newMethod.addParameter(newParameter);
                }

                copyModelElementAttributes(oldMethod, newMethod);

                newClassifier.addFeature(newMethod);
            }
        }
    }
}