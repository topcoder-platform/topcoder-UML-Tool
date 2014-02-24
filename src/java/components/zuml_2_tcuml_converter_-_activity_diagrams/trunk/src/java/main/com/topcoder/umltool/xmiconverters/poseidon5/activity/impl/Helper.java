/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;


/**
 * <p>
 * This class is used by this component only. Provide some common utility methods.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is mutable, so it's not thread safe.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public final class Helper {
    /**
     * <p>
     * It' required that there is only on TagDefinition instance for the same tag type.
     * This map is used to store the only instance for each tag type. The key of the map
     * is tag type, and the value is TagDefinition instance.
     * </p>
     */
    private static Map<String, TagDefinition> map = new HashMap<String, TagDefinition>();

    /**
     * <p>
     * Only the TagDefinition used in Model should be added to the Model finally. This field
     * represents the new used tagDefinitions in the converting process. It will share the
     * TagDefinitions with the whole map.
     * </p>
     */
    private static Map<String, TagDefinition> usedTags = new HashMap<String, TagDefinition>();

    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private Helper() {
        // do nothing
    }

    /**
     * <p>
     * Checks whether the given object is null. If null,
     * <code>IllegalArgumentException</code> will be thrown.
     * </p>
     *
     * @param param
     *            the argument to be checked
     * @param paramName
     *            the name of the argument to be checked
     * @throws IllegalArgumentException
     *            if param is null
     */
    public static void checkNull(final Object param, final String paramName) {
        if (param == null) {
            throw new IllegalArgumentException("The argument '" + paramName
                    + "' should not be null.");
        }
    }

    /**
     * <p>
     * Check whether the string is null or empty. If it is, IllegalArgumentException is expected.
     * </p>
     *
     * @param param the string to be checked
     * @param paramName the name of the string
     * @throws IllegalArgumentException if the string is null or empty
     */
    static void checkString(final String param, final String paramName) {
        if ((param == null) || (param.trim().length() == 0)) {
            throw new IllegalArgumentException("The argument '" + paramName
                    + "' should not null or empty string.");
        }
    }

    /**
     * <p>
     * Check whether the object array is null or contains null element.
     * If it is null or contains null element, IllegalArgumentException is expected.
     * </p>
     *
     * @param param the object array to check
     * @param paramName the name of the object array
     * @throws IllegalArgumentException if the object array is null or contains null element.
     */
    static void checkObjectArray(final Object[] param, final String paramName) {
        checkNull(param, paramName);

        for (Object obj : param) {
            if (obj == null) {
                throw new IllegalArgumentException("The object array '"
                        + paramName + "' should not contain null element.");
            }
        }
    }

    /**
     * <p>
     * Copy base common attributes of ModelElement from the source ModelElement instance
     * to the destination ModelElement instance. As this is a utility method only used in
     * this component, we are sure that it will be used properly, so we don't have to check
     * the argument. This will improve the efficiency.
     * </p>
     *
     * <p>
     * Note: The taggedValues property isn't copied, as it's meaningless in tcuml.
     * </p>
     *
     * @param source the source ModelElement to copy attributes from
     * @param destination the destination ModelElement to copy attributes to
     */
    static void copyAttribute(final ModelElement source,
        final ModelElement destination) {
        //Copy the name property
        destination.setName(source.getName());

        //Copy the visibility property
        destination.setVisibility(source.getVisibility());

        //Copy the specification property
        destination.setSpecification(source.isSpecification());

        //Copy the stereotypes property
        for (Stereotype sterotype : source.getStereotypes()) {
            destination.addStereotype(sterotype);
            sterotype.addExtendedElement(destination);
        }

        //Copy the referenceTag property
        for (TaggedValue taggedValue : source.getReferenceTags()) {
            destination.addReferenceTag(taggedValue);
        }

        //Copy the namespace property
        destination.setNamespace(source.getNamespace());

        //Copy the supplireDependency property
        for (Dependency dependency : source.getSupplierDependencies()) {
            destination.addSupplierDependency(dependency);
            dependency.addSupplier(destination);
        }

        //Copy the clientDependencies property
        for (Dependency dependency : source.getClientDependencies()) {
            destination.addClientDependency(dependency);
            dependency.addClient(destination);
        }

        //Copy the comments property
        for (Comment comment : source.getComments()) {
            destination.addComment(comment);
        }

        //Copy the parameterTemplate property
        destination.setParameterTemplate(source.getParameterTemplate());

        //Copy the defaultParameters property
        for (TemplateParameter parameter : source.getDefaultParameters()) {
            destination.addDefaultParameter(parameter);
        }

        //Copy the templateParameters property
        for (TemplateParameter parameter : source.getTemplateParameters()) {
            destination.addTemplateParameter(parameter);
        }

        //Copy the templateArgument property
        for (TemplateArgument argument : source.getTemplateArguments()) {
            destination.addTemplateArgument(argument);
        }

        //Copy the elementImports property
        for (ElementImport elementImport : source.getElementImports()) {
            destination.addElementImport(elementImport);
        }

        //Copy the behaviors property
        for (StateMachine sm : source.getBehaviors()) {
            destination.addBehavior(sm);
        }
    }

    /**
     * <p>
     * Gets the TagDefinition instance for the specified tagType. It returns the same TagDefinition
     * instance for the same tagType.
     * </p>
     *
     * @param tagType the tag type of the TagDefinition to be got
     * @return the TagDefinition instance of tagType
     */
    static TagDefinition getTagDefinition(String tagType) {
        TagDefinition tagDefinition;

        if (map.containsKey(tagType)) {
            tagDefinition = map.get(tagType);
        } else {
            tagDefinition = new TagDefinitionImpl();
            tagDefinition.setTagType(tagType);
            map.put(tagType, tagDefinition);
        }

        //Add a new used tagDefinition
        usedTags.put(tagType, tagDefinition);

        return tagDefinition;
    }

    /**
     * <p>
     * Converts an AbstractZUMLActivityEdge instance to TCUML instance.
     * </p>
     *
     * @param edge the AbstractZUMLActivityEdge to convert
     * @return the converted TCUML representation of the original AbstractZUMLActivityEdge
     */
    static Transition convertEdgeToTCUML(AbstractZUMLActivityEdge edge) {
        Transition transition = new TransitionImpl();

        copyAttribute(edge, transition);

        if (edge.getSource() != null) {
            transition.setSource((StateVertex) edge.getSource().convertToTCUML());
        }

        if (edge.getTarget() != null) {
            transition.setTarget((StateVertex) edge.getTarget().convertToTCUML());
        }

        //The edge can have no guard.
        if (edge.getGuard() != null) {
            transition.setGuard((Guard) edge.getGuard().convertToTCUML());
        }

        return transition;
    }

    /**
     * <p>
     * Clear the usedTags map. It indicates the beginning of a new converting process.
     * </p>
     */
    public static void clearUsedTagDefinitions() {
        usedTags.clear();
    }

    /**
     * <p>
     * Returns all the used TagDefinitions in the converting process.
     * </p>
     *
     * @return all the used TagDefinitions in the converting process
     */
    public static Collection<TagDefinition> getUsedTagDefinitions() {
        return usedTags.values();
    }

    /**
     * <p>
     * Create a PseudostateImpl instance using the kind, and copy all basic attributes from
     * source to the created instance.
     * </p>
     *
     * @param source the basic attributes to copy from
     * @param kind the Pseudostate's kind
     * @return the created Pseudostate instance
     */
    static Pseudostate createPseudostate(ModelElement source, PseudostateKind kind) {
        Pseudostate transformed = new PseudostateImpl();

        copyAttribute(source, transformed);

        transformed.setKind(kind);

        return transformed;
    }

    /**
     * <p>
     * Copy base attributes from source to the state. And add a taggedValue with data value dataValue,
     * and a TagDefinition tagType to the state.
     * </p>
     *
     * @param source the source ModelElement to copy attributes from
     * @param state the destination ModelElement
     * @param dataValue the data value of the taggedValue
     * @param tagType the tag type of the TagDefinition
     */
    static void initializeState(ModelElement source, ModelElement state, String dataValue, String tagType) {
        copyAttribute(source, state);

        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue(dataValue);

        taggedValue.setType(Helper.getTagDefinition(tagType));

        state.addTaggedValue(taggedValue);
    }
}
