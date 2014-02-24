/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core;

import java.util.*;

import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.Generalization;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public abstract class ClassifierAbstractImpl extends GeneralizableElementAbstractImpl implements Classifier {
    /**
     * An ordered list of Features, like Attribute, Operation, Method owned by
     * the Classifier. This ordered collection is instantiated as an empty
     * Linked during construction.The value of this attribute cannot be changed
     * after construction; the content of the collection itself can be modified
     * through the appropriate methods (add, remove...). Every object of the
     * appropriate type can be inserted into it, except for null values;
     * duplicated entries are allowed.
     */
    private final List<Feature> feature = new LinkedList<Feature>();

    /**
     * An unordered collection of StructuralFeatures owned by the Classifier.
     * This unordered collection is instantiated as an empty ArrayList during
     * construction.The value of this attribute cannot be changed after
     * construction; the content of the collection itself can be modified
     * through the appropriate methods (add, remove...). Every object of the
     * appropriate type can be inserted into it; null values are not allowed;
     * duplicate entries are allowed.
     */
    private final Collection<StructuralFeature> typedFeatures = new ArrayList<StructuralFeature>();

    /**
     * An unordered collection of Parameters owned by the Classifier. This
     * unordered collection is instantiated as an empty ArrayList during
     * construction.The value of this attribute cannot be changed after
     * construction; the content of the collection itself can be modified
     * through the appropriate methods (add, remove...). Every object of the
     * appropriate type can be inserted into it; null values are not allowed;
     * duplicate entries are allowed.
     */
    private final Collection<Parameter> typedParameters = new ArrayList<Parameter>();

    /**
     * Denotes the AssociationEnd of an Association in which the Classifier
     * participates at the given end. This unordered collection is instantiated
     * as an empty ArrayList during construction.The value of this attribute
     * cannot be changed after construction; the content of the collection
     * itself can be modified through the appropriate methods (add, remove...).
     * Every object of the appropriate type can be inserted into it; null values
     * are not allowed; duplicate entries are allowed.
     */
    private final Collection<AssociationEnd> associations = new ArrayList<AssociationEnd>();

    /**
     * Indicates an AssociationEnd for which the given Classifier specifies
     * operations that may be applied to instances obtained by traversing the
     * association from the other end. This unordered collection is instantiated
     * as an empty ArrayList during construction.The value of this attribute
     * cannot be changed after construction; the content of the collection
     * itself can be modified through the appropriate methods (add, remove...).
     * Every object of the appropriate type can be inserted into it; null values
     * are not allowed; duplicate entries are allowed.
     */
    private final Collection<AssociationEnd> specifiedEnds = new ArrayList<AssociationEnd>();

    /**
     * Designates zero or more Generalizations for which the Classifier is a
     * powertype. This unordered collection is instantiated as an empty
     * ArrayList during construction.The value of this attribute cannot be
     * changed after construction; the content of the collection itself can be
     * modified through the appropriate methods (add, remove...). Every object
     * of the appropriate type can be inserted into it; null values are not
     * allowed; duplicate entries are allowed.
     */
    private final Collection<Generalization> powertypeRanges = new ArrayList<Generalization>();

    /**
     * An unordered collection of ObjectFlowStates owned by the Classifier. This
     * unordered collection is instantiated as an empty ArrayList during
     * construction.The value of this attribute cannot be changed after
     * construction; the content of the collection itself can be modified
     * through the appropriate methods (add, remove...). Every object of the
     * appropriate type can be inserted into it; null values are not allowed;
     * duplicate entries are allowed.
     */
    private final Collection<ObjectFlowState> objectFlowStates = new ArrayList<ObjectFlowState>();

    /**
     * An unordered collection of Instances owned by the Classifier. This
     * unordered collection is instantiated as an empty ArrayList during
     * construction.The value of this attribute cannot be changed after
     * construction; the content of the collection itself can be modified
     * through the appropriate methods (add, remove...). Every object of the
     * appropriate type can be inserted into it; null values are not allowed;
     * duplicate entries are allowed.
     */
    private final Collection<Instance> instances = new ArrayList<Instance>();

    /**
     * A set of ModelElements owned by the Namespace. This unordered collection
     * is instantiated as an empty ArrayList during construction.The value of
     * this attribute cannot be changed after construction; the content of the
     * collection itself can be modified through the appropriate methods (add,
     * remove...). Every object of the appropriate type can be inserted into it;
     * null values are not allowed; duplicate entries are allowed.
     */
    private final Collection<ModelElement> ownedElements = new ArrayList<ModelElement>();

    /**
     * <p>
     * Adds a feature at the end of the ordered collection of the current
     * object.
     * </p>
     *
     * @param feature
     *            the feature to be added
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null
     */
    public void addFeature(Feature feature) {
        this.feature.add(feature);
    }

    /**
     * <p>
     * Adds a feature at specified index of the ordered collection of the
     * current object.
     * </p>
     *
     * @param index
     * @param feature
     *            the feature to be added
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is not valid, i.e. the condition <i>0 <=
     *             index < countFeatures()</i> does not hold.
     */
    public void addFeature(int index, Feature feature) {
    }

    /**
     * <p>
     * Sets the feature at specified index of the ordered collection of the
     * current object.
     * </p>
     *
     * @param index
     * @param feature
     *            the feature to be added
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is not valid, i.e. the condition <i>0 <=
     *             index < countFeatures()</i> does not hold.
     */
    public void setFeature(int index, Feature feature) {
    }

    /**
     * <p>
     * Removes (and fetches) the feature at specified index from the ordered
     * collection of the current object.
     * </p>
     *
     * @return the removed object of type <code>Feature</code>
     * @param index
     *            the index of the feature to be removed
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is not valid, i.e. the condition <i>0 <=
     *             index < countFeatures()</i> does not hold.
     */
    public Feature removeFeature(int index) {
        return null;
    }

    /**
     * <p>
     * Removes a feature from the ordered collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         feature
     * @param feature
     *            the feature to be removed
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null
     */
    public boolean removeFeature(Feature feature) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "feature" from the ordered collection of
     * the current object.
     * </p>
     */
    public void clearFeatures() {
    }

    /**
     * <p>
     * Gets all the objects of type "feature" previously added to the ordered
     * collection of the current object.
     * </p>
     *
     * @return a <code>java.util.List</code> instance, containing all the
     *         objects of type <code>Feature</code> added to the collection of
     *         current object
     */
    public List<Feature> getFeatures() {
        return this.feature;
    }

    /**
     * <p>
     * Checks if a feature is contained in the ordered collection of the current
     * object.
     * </p>
     *
     * @return <code>true</code> if <code>feature</code> is contained in the
     *         collection of the current object
     * @param feature
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null
     */
    public boolean containsFeature(Feature feature) {
        return this.feature.contains(feature);
    }

    /**
     * <p>
     * Gets the index of the specified feature in the ordered collection of the
     * current object, or -1 if such a collection doesn't contain it.
     * </p>
     *
     * @return the index of the specified <code>Feature</code> in the ordered
     *         collection of the current object, or -1 if such a collection
     *         doesn't contain it.
     * @param feature
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null
     */
    public int indexOfFeature(Feature feature) {
        return 0;
    }

    /**
     * <p>
     * Returns the number of objects of type "feature" previously added to the
     * ordered collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Feature</code> inserted
     *         in the ordered collection of the current object
     */
    public int countFeatures() {
        return this.feature.size();
    }

    /**
     * <p>
     * Adds a typed feature to the collection of the current object.
     * </p>
     *
     * @param typedFeature
     *            the typed feature to be added
     * @throws IllegalArgumentException
     *             if <code>typedFeature</code> is null
     */
    public void addTypedFeature(StructuralFeature typedFeature) {
        this.typedFeatures.add(typedFeature);
    }

    /**
     * <p>
     * Removes a typed feature from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified typed
     *         feature
     * @param typedFeature
     *            the typed feature to be removed
     * @throws IllegalArgumentException
     *             if <code>typedFeature</code> is null
     */
    public boolean removeTypedFeature(StructuralFeature typedFeature) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "typed feature" from the collection of
     * the current object.
     * </p>
     */
    public void clearTypedFeatures() {
    }

    /**
     * <p>
     * Gets all the objects of type "typed feature" previously added to the
     * collection of the current object.
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>StructuralFeature</code> added to the
     *         collection of current object
     */
    public Collection<StructuralFeature> getTypedFeatures() {
        return this.typedFeatures;
    }

    /**
     * <p>
     * Checks if a typed feature is contained in the collection of the current
     * object.
     * </p>
     *
     * @return <code>true</code> if <code>typedFeature</code> is contained
     *         in the collection of the current object
     * @param typedFeature
     */
    public boolean containsTypedFeature(StructuralFeature typedFeature) {
        return this.typedFeatures.contains(typedFeature);
    }

    /**
     * <p>
     * Returns the number of objects of type "typed feature" previously added to
     * the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>StructuralFeature</code>
     *         inserted in the collection of the current object
     */
    public int countTypedFeatures() {
        return 0;
    }

    /**
     * <p>
     * Adds a typed parameter to the collection of the current object.
     * </p>
     *
     * @param typedParameter
     *            the typed parameter to be added
     * @throws IllegalArgumentException
     *             if <code>typedParameter</code> is null
     */
    public void addTypedParameter(Parameter typedParameter) {
        this.typedParameters.add(typedParameter);
    }

    /**
     * <p>
     * Removes a typed parameter from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified typed
     *         parameter
     * @param typedParameter
     *            the typed parameter to be removed
     * @throws IllegalArgumentException
     *             if <code>typedParameter</code> is null
     */
    public boolean removeTypedParameter(Parameter typedParameter) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "typed parameter" from the collection of
     * the current object.
     * </p>
     */
    public void clearTypedParameters() {
    }

    /**
     * <p>
     * Gets all the objects of type "typed parameter" previously added to the
     * collection of the current object.
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>Parameter</code> added to the
     *         collection of current object
     */
    public Collection<Parameter> getTypedParameters() {
        return this.typedParameters;
    }

    /**
     * <p>
     * Checks if a typed parameter is contained in the collection of the current
     * object.
     * </p>
     *
     * @return <code>true</code> if <code>typedParameter</code> is contained
     *         in the collection of the current object
     * @param typedParameter
     */
    public boolean containsTypedParameter(Parameter typedParameter) {
        return this.typedParameters.contains(typedParameter);
    }

    /**
     * <p>
     * Returns the number of objects of type "typed parameter" previously added
     * to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Parameter</code> inserted
     *         in the collection of the current object
     */
    public int countTypedParameters() {
        return 0;
    }

    /**
     * <p>
     * Adds a association to the collection of the current object.
     * </p>
     *
     * @param association
     *            the association to be added
     * @throws IllegalArgumentException
     *             if <code>association</code> is null
     */
    public void addAssociation(AssociationEnd association) {
        this.associations.add(association);
    }

    /**
     * <p>
     * Removes a association from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         association
     * @param association
     *            the association to be removed
     * @throws IllegalArgumentException
     *             if <code>association</code> is null
     */
    public boolean removeAssociation(AssociationEnd association) {
        return this.associations.remove(association);
    }

    /**
     * <p>
     * Removes all the objects of type "association" from the collection of the
     * current object.
     * </p>
     */
    public void clearAssociations() {
    }

    /**
     * <p>
     * Gets all the objects of type "association" previously added to the
     * collection of the current object.
     * </p>
     *
     * <p>
     * Additions and removals of elements to and from the returned collection do
     * not change the state of current object (i.e. the returned collection is a
     * copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified
     * accordingly (i.e. the internal and the returned collections share
     * references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>AssociationEnd</code> added to the
     *         collection of current object
     */
    public Collection<AssociationEnd> getAssociations() {
        return this.associations;
    }

    /**
     * <p>
     * Checks if a association is contained in the collection of the current
     * object.
     * </p>
     *
     * @return <code>true</code> if <code>association</code> is contained in
     *         the collection of the current object
     * @param association
     */
    public boolean containsAssociation(AssociationEnd association) {
        return this.associations.contains(association);
    }

    /**
     * <p>
     * Returns the number of objects of type "association" previously added to
     * the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>AssociationEnd</code>
     *         inserted in the collection of the current object
     */
    public int countAssociations() {
        return 0;
    }

    /**
     * <p>
     * Adds a specified end to the collection of the current object.
     * </p>
     *
     * @param specifiedEnd
     *            the specified end to be added
     * @throws IllegalArgumentException
     *             if <code>specifiedEnd</code> is null
     */
    public void addSpecifiedEnd(AssociationEnd specifiedEnd) {
    }

    /**
     * <p>
     * Removes a specified end from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         specified end
     * @param specifiedEnd
     *            the specified end to be removed
     * @throws IllegalArgumentException
     *             if <code>specifiedEnd</code> is null
     */
    public boolean removeSpecifiedEnd(AssociationEnd specifiedEnd) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "specified end" from the collection of
     * the current object.
     * </p>
     */
    public void clearSpecifiedEnds() {
    }

    /**
     * <p>
     * Gets all the objects of type "specified end" previously added to the
     * collection of the current object.
     * </p>
     *
     * <p>
     * Additions and removals of elements to and from the returned collection do
     * not change the state of current object (i.e. the returned collection is a
     * copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified
     * accordingly (i.e. the internal and the returned collections share
     * references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>AssociationEnd</code> added to the
     *         collection of current object
     */
    public Collection<AssociationEnd> getSpecifiedEnds() {
        return null;
    }

    /**
     * <p>
     * Checks if a specified end is contained in the collection of the current
     * object.
     * </p>
     *
     * @return <code>true</code> if <code>specifiedEnd</code> is contained
     *         in the collection of the current object
     * @param specifiedEnd
     */
    public boolean containsSpecifiedEnd(AssociationEnd specifiedEnd) {
        return false;
    }

    /**
     * <p>
     * Returns the number of objects of type "specified end" previously added to
     * the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>AssociationEnd</code>
     *         inserted in the collection of the current object
     */
    public int countSpecifiedEnds() {
        return 0;
    }

    /**
     * <p>
     * Adds a powertype range to the collection of the current object.
     * </p>
     *
     * @param powertypeRange
     *            the powertype range to be added
     * @throws IllegalArgumentException
     *             if <code>powertypeRange</code> is null
     */
    public void addPowertypeRange(Generalization powertypeRange) {
        this.powertypeRanges.add(powertypeRange);
    }

    /**
     * <p>
     * Removes a powertype range from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         powertype range
     * @param powertypeRange
     *            the powertype range to be removed
     * @throws IllegalArgumentException
     *             if <code>powertypeRange</code> is null
     */
    public boolean removePowertypeRange(Generalization powertypeRange) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "powertype range" from the collection of
     * the current object.
     * </p>
     */
    public void clearPowertypeRanges() {
    }

    /**
     * <p>
     * Gets all the objects of type "powertype range" previously added to the
     * collection of the current object.
     * </p>
     *
     * <p>
     * Additions and removals of elements to and from the returned collection do
     * not change the state of current object (i.e. the returned collection is a
     * copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified
     * accordingly (i.e. the internal and the returned collections share
     * references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>Generalization</code> added to the
     *         collection of current object
     */
    public Collection<Generalization> getPowertypeRanges() {
        return this.powertypeRanges;
    }

    /**
     * <p>
     * Checks if a powertype range is contained in the collection of the current
     * object.
     * </p>
     *
     * @return <code>true</code> if <code>powertypeRange</code> is contained
     *         in the collection of the current object
     * @param powertypeRange
     */
    public boolean containsPowertypeRange(Generalization powertypeRange) {
        return this.powertypeRanges.contains(powertypeRange);
    }

    /**
     * <p>
     * Returns the number of objects of type "powertype range" previously added
     * to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Generalization</code>
     *         inserted in the collection of the current object
     */
    public int countPowertypeRanges() {
        return 0;
    }

    /**
     * <p>
     * Adds a object flow state to the collection of the current object.
     * </p>
     *
     * @param objectFlowState
     *            the object flow state to be added
     * @throws IllegalArgumentException
     *             if <code>objectFlowState</code> is null
     */
    public void addObjectFlowState(ObjectFlowState objectFlowState) {
        this.objectFlowStates.add(objectFlowState);
    }

    /**
     * <p>
     * Removes a object flow state from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         object flow state
     * @param objectFlowState
     *            the object flow state to be removed
     * @throws IllegalArgumentException
     *             if <code>objectFlowState</code> is null
     */
    public boolean removeObjectFlowState(ObjectFlowState objectFlowState) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "object flow state" from the collection
     * of the current object.
     * </p>
     */
    public void clearObjectFlowStates() {
    }

    /**
     * <p>
     * Gets all the objects of type "object flow state" previously added to the
     * collection of the current object.
     * </p>
     *
     * <p>
     * Additions and removals of elements to and from the returned collection do
     * not change the state of current object (i.e. the returned collection is a
     * copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified
     * accordingly (i.e. the internal and the returned collections share
     * references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>ObjectFlowState</code> added to the
     *         collection of current object
     */
    public Collection<ObjectFlowState> getObjectFlowStates() {
        return this.objectFlowStates;
    }

    /**
     * <p>
     * Checks if a object flow state is contained in the collection of the
     * current object.
     * </p>
     *
     * @return <code>true</code> if <code>objectFlowState</code> is
     *         contained in the collection of the current object
     * @param objectFlowState
     */
    public boolean containsObjectFlowState(ObjectFlowState objectFlowState) {
        return this.objectFlowStates.contains(objectFlowState);
    }

    /**
     * <p>
     * Returns the number of objects of type "object flow state" previously
     * added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>ObjectFlowState</code>
     *         inserted in the collection of the current object
     */
    public int countObjectFlowStates() {
        return 0;
    }

    /**
     * <p>
     * Adds a instance to the collection of the current object.
     * </p>
     *
     * @param instance
     *            the instance to be added
     * @throws IllegalArgumentException
     *             if <code>instance</code> is null
     */
    public void addInstance(Instance instance) {
        this.instances.add(instance);
    }

    /**
     * <p>
     * Removes a instance from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         instance
     * @param instance
     *            the instance to be removed
     * @throws IllegalArgumentException
     *             if <code>instance</code> is null
     */
    public boolean removeInstance(Instance instance) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "instance" from the collection of the
     * current object.
     * </p>
     */
    public void clearInstances() {
    }

    /**
     * <p>
     * Gets all the objects of type "instance" previously added to the
     * collection of the current object.
     * </p>
     *
     * <p>
     * Additions and removals of elements to and from the returned collection do
     * not change the state of current object (i.e. the returned collection is a
     * copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified
     * accordingly (i.e. the internal and the returned collections share
     * references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>Instance</code> added to the
     *         collection of current object
     */
    public Collection<Instance> getInstances() {
        return this.instances;
    }

    /**
     * <p>
     * Checks if a instance is contained in the collection of the current
     * object.
     * </p>
     *
     * @return <code>true</code> if <code>instance</code> is contained in
     *         the collection of the current object
     * @param instance
     */
    public boolean containsInstance(Instance instance) {
        return this.instances.contains(instance);
    }

    /**
     * <p>
     * Returns the number of objects of type "instance" previously added to the
     * collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Instance</code> inserted
     *         in the collection of the current object
     */
    public int countInstances() {
        return 0;
    }

    /**
     * <p>
     * Adds a owned element to the collection of the current object.
     * </p>
     *
     * @param ownedElement
     *            the owned element to be added
     * @throws IllegalArgumentException
     *             if <code>ownedElement</code> is null
     */
    public void addOwnedElement(ModelElement ownedElement) {
    }

    /**
     * <p>
     * Removes a owned element from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified owned
     *         element
     * @param ownedElement
     *            the owned element to be removed
     * @throws IllegalArgumentException
     *             if <code>ownedElement</code> is null
     */
    public boolean removeOwnedElement(ModelElement ownedElement) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "owned element" from the collection of
     * the current object.
     * </p>
     */
    public void clearOwnedElements() {
    }

    /**
     * <p>
     * Gets all the objects of type "owned element" previously added to the
     * collection of the current object.
     * </p>
     *
     * <p>
     * Additions and removals of elements to and from the returned collection do
     * not change the state of current object (i.e. the returned collection is a
     * copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified
     * accordingly (i.e. the internal and the returned collections share
     * references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>ModelElement</code> added to the
     *         collection of current object
     */
    public Collection<ModelElement> getOwnedElements() {
        return null;
    }

    /**
     * <p>
     * Checks if a owned element is contained in the collection of the current
     * object.
     * </p>
     *
     * @return <code>true</code> if <code>ownedElement</code> is contained
     *         in the collection of the current object
     * @param ownedElement
     */
    public boolean containsOwnedElement(ModelElement ownedElement) {
        return false;
    }

    /**
     * <p>
     * Returns the number of objects of type "owned element" previously added to
     * the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>ModelElement</code>
     *         inserted in the collection of the current object
     */
    public int countOwnedElements() {
        return 0;
    }
}