/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.Generalization;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * <p>
 * This abstract class is a default implementation of the <code>Classifier</code> interface.
 * </p>
 * <p>
 * The non-collection attributes described by the interface are implemented by simple references to objects, that are
 * set to <code>null</code> by default; the unordered collection attributes are implemented with instances of
 * <code>ArrayList</code>, while the ordered collection attributes are implemented with instances of
 * <code>LinkedList</code>.
 * </p>
 * <p>
 * The non-collection attributes can be set to every reference of the correct type, either <code>null</code> or
 * non-null (and the String attributes can be set to the empty string); the collection attributes can't obviously be
 * <code>null</code>, since they are set during instantiation and can't be changed. Anyway, they can't contain
 * <code>null</code> references while they can contain duplicate entries.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread-safe, since thread safety should be handled by the application
 * itself.
 * </p>
 *
 * @author Pisky, vividmxx
 * @version 1.0
 */
public abstract class ClassifierAbstractImpl extends GeneralizableElementAbstractImpl implements Classifier {

    /**
     * <p>
     * An ordered list of Features, like Attribute, Operation, Method owned by the Classifier.
     * </p>
     * <p>
     * This ordered collection is instantiated as an empty <code>LinkedList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it, except
     * for null values; duplicated entries are allowed.
     * </p>
     */
    private final List<Feature> features;

    /**
     * <p>
     * An unordered collection of StructuralFeatures owned by the Classifier.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<StructuralFeature> typedFeatures;

    /**
     * <p>
     * An unordered collection of Parameters owned by the Classifier.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<Parameter> typedParameters;

    /**
     * <p>
     * Denotes the AssociationEnd of an Association in which the Classifier participates at the given end.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<AssociationEnd> associations;

    /**
     * <p>
     * Indicates an AssociationEnd for which the given Classifier specifies operations that may be applied to instances
     * obtained by traversing the association from the other end.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<AssociationEnd> specifiedEnds;

    /**
     * <p>
     * Designates zero or more Generalizations for which the Classifier is a powertype.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction.The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<Generalization> powertypeRanges;

    /**
     * <p>
     * An unordered collection of ObjectFlowStates owned by the Classifier.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<ObjectFlowState> objectFlowStates;

    /**
     * <p>
     * An unordered collection of Instances owned by the Classifier.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<Instance> instances;

    /**
     * <p>
     * A set of ModelElements owned by the Namespace.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<ModelElement> ownedElements;

    /**
     * <p>
     * Constructs a basic instance of this class.
     * </p>
     */
    protected ClassifierAbstractImpl() {
        features = new LinkedList<Feature>();
        typedFeatures = new ArrayList<StructuralFeature>();
        typedParameters = new ArrayList<Parameter>();
        associations = new ArrayList<AssociationEnd>();
        specifiedEnds = new ArrayList<AssociationEnd>();
        powertypeRanges = new ArrayList<Generalization>();
        objectFlowStates = new ArrayList<ObjectFlowState>();
        instances = new ArrayList<Instance>();
        ownedElements = new ArrayList<ModelElement>();
    }

    /**
     * <p>
     * Adds a feature at the end of the ordered collection of the current object.
     * </p>
     *
     * @param feature
     *            the feature to be added.
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null.
     */
    public void addFeature(Feature feature) {
        if (feature == null) {
            throw new IllegalArgumentException("The feature to be added can't be null.");
        }
        features.add(feature);
    }

    /**
     * <p>
     * Adds a feature at specified index of the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            index at which the specified element is to be added.
     * @param feature
     *            the feature to be added.
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or &gt; features.size().
     */
    public void addFeature(int index, Feature feature) {
        if (feature == null) {
            throw new IllegalArgumentException("The feature to be added can't be null.");
        }
        features.add(index, feature);
    }

    /**
     * <p>
     * Sets the feature at specified index of the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            index of element to replace.
     * @param feature
     *            the feature to be added.
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or &gt;= features.size().
     */
    public void setFeature(int index, Feature feature) {
        if (feature == null) {
            throw new IllegalArgumentException("The feature to set can't be null.");
        }
        features.set(index, feature);
    }

    /**
     * <p>
     * Removes (and fetches) the feature at specified index from the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            the index of the feature to be removed.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or &gt;= features.size().
     * @return the removed object of type <code>Feature</code>.
     */
    public Feature removeFeature(int index) {
        return features.remove(index);
    }

    /**
     * <p>
     * Removes a feature from the ordered collection of the current object.
     * </p>
     *
     * @param feature
     *            the feature to be removed.
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removeFeature(Feature feature) {
        if (feature == null) {
            throw new IllegalArgumentException("The feature to be removed can't be null.");
        }
        return features.remove(feature);
    }

    /**
     * <p>
     * Removes all the objects of type "feature" from the ordered collection of the current object.
     * </p>
     */
    public void clearFeatures() {
        features.clear();
    }

    /**
     * <p>
     * Gets all the objects of type "feature" previously added to the ordered collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned list do not change the state of current object (i.e.
     * the returned list is a copy of the internal one of the current object). However, if an element contained in it is
     * modified, the state of the current object is modified accordingly (i.e. the internal and the returned lists share
     * references to the same objects).
     * </p>
     *
     * @return a <code>java.util.List</code> instance, containing all the objects of type <code>Feature</code> added
     *         to the collection of current object.
     */
    public List<Feature> getFeatures() {
        return new LinkedList<Feature>(features);
    }

    /**
     * <p>
     * Checks if a feature is contained in the ordered collection of the current object.
     * </p>
     *
     * @param feature
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null.
     * @return <code>true</code> if <code>feature</code> is contained in the collection of the current object.
     */
    public boolean containsFeature(Feature feature) {
        if (feature == null) {
            throw new IllegalArgumentException("The feature to check can't be null.");
        }
        return features.contains(feature);
    }

    /**
     * <p>
     * Gets the index of the specified feature in the ordered collection of the current object, or -1 if such a
     * collection doesn't contain it.
     * </p>
     *
     * @param feature
     *            the desired element.
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null.
     * @return the index of the specified <code>Feature</code> in the ordered collection of the current object, or -1
     *         if such a collection doesn't contain it.
     */
    public int indexOfFeature(Feature feature) {
        if (feature == null) {
            throw new IllegalArgumentException("The feature to query can't be null.");
        }
        return features.indexOf(feature);
    }

    /**
     * <p>
     * Returns the number of objects of type "feature" previously added to the ordered collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Feature</code> inserted in the ordered collection of the current
     *         object.
     */
    public int countFeatures() {
        return features.size();
    }

    /**
     * <p>
     * Adds a typed feature to the collection of the current object.
     * </p>
     *
     * @param typedFeature
     *            the typed feature to be added.
     * @throws IllegalArgumentException
     *             if <code>typedFeature</code> is null.
     */
    public void addTypedFeature(StructuralFeature typedFeature) {
        if (typedFeature == null) {
            throw new IllegalArgumentException("The typedFeature to be added can't be null.");
        }
        typedFeatures.add(typedFeature);
    }

    /**
     * <p>
     * Removes a typed feature from the collection of the current object.
     * </p>
     *
     * @param typedFeature
     *            the typed feature to be removed.
     * @throws IllegalArgumentException
     *             if <code>typedFeature</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removeTypedFeature(StructuralFeature typedFeature) {
        if (typedFeature == null) {
            throw new IllegalArgumentException("The typedFeature to be removed can't be null.");
        }
        return typedFeatures.remove(typedFeature);
    }

    /**
     * <p>
     * Removes all the objects of type "typed feature" from the collection of the current object.
     * </p>
     */
    public void clearTypedFeatures() {
        typedFeatures.clear();
    }

    /**
     * <p>
     * Gets all the objects of type "typed feature" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>StructuralFeature</code> added to the collection of current object.
     */
    public Collection<StructuralFeature> getTypedFeatures() {
        return new ArrayList<StructuralFeature>(typedFeatures);
    }

    /**
     * <p>
     * Checks if a typed feature is contained in the collection of the current object.
     * </p>
     *
     * @param typedFeature
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>typedFeature</code> is null.
     * @return <code>true</code> if <code>typedFeature</code> is contained in the collection of the current object.
     */
    public boolean containsTypedFeature(StructuralFeature typedFeature) {
        if (typedFeature == null) {
            throw new IllegalArgumentException("The typedFeature to be tested can't be null.");
        }
        return typedFeatures.contains(typedFeature);
    }

    /**
     * <p>
     * Returns the number of objects of type "typed feature" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>StructuralFeature</code> inserted in the collection of the
     *         current object.
     */
    public int countTypedFeatures() {
        return typedFeatures.size();
    }

    /**
     * <p>
     * Adds a typed parameter to the collection of the current object.
     * </p>
     *
     * @param typedParameter
     *            the typed parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>typedParameter</code> is null.
     */
    public void addTypedParameter(Parameter typedParameter) {
        if (typedParameter == null) {
            throw new IllegalArgumentException("The typedParameter to be added can't be null.");
        }
        typedParameters.add(typedParameter);
    }

    /**
     * <p>
     * Removes a typed parameter from the collection of the current object.
     * </p>
     *
     * @param typedParameter
     *            the typed parameter to be removed.
     * @throws IllegalArgumentException
     *             if <code>typedParameter</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removeTypedParameter(Parameter typedParameter) {
        if (typedParameter == null) {
            throw new IllegalArgumentException("The typedParameter to be removed can't be null.");
        }
        return typedParameters.remove(typedParameter);
    }

    /**
     * <p>
     * Removes all the objects of type "typed parameter" from the collection of the current object.
     * </p>
     */
    public void clearTypedParameters() {
        typedParameters.clear();
    }

    /**
     * <p>
     * Gets all the objects of type "typed parameter" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type <code>Parameter</code>
     *         added to the collection of current object.
     */
    public Collection<Parameter> getTypedParameters() {
        return new ArrayList<Parameter>(typedParameters);
    }

    /**
     * <p>
     * Checks if a typed parameter is contained in the collection of the current object.
     * </p>
     *
     * @param typedParameter
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>typedParameter</code> is null.
     * @return <code>true</code> if <code>typedParameter</code> is contained in the collection of the current
     *         object.
     */
    public boolean containsTypedParameter(Parameter typedParameter) {
        if (typedParameter == null) {
            throw new IllegalArgumentException("The typedParameter to be tested can't be null.");
        }
        return typedParameters.contains(typedParameter);
    }

    /**
     * <p>
     * Returns the number of objects of type "typed parameter" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Parameter</code> inserted in the collection of the current
     *         object.
     */
    public int countTypedParameters() {
        return typedParameters.size();
    }

    /**
     * <p>
     * Adds a association to the collection of the current object.
     * </p>
     *
     * @param association
     *            the association to be added.
     * @throws IllegalArgumentException
     *             if <code>association</code> is null.
     */
    public void addAssociation(AssociationEnd association) {
        if (association == null) {
            throw new IllegalArgumentException("The association to be added can't be null.");
        }
        associations.add(association);
    }

    /**
     * <p>
     * Removes a association from the collection of the current object.
     * </p>
     *
     * @param association
     *            the association to be removed.
     * @throws IllegalArgumentException
     *             if <code>association</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removeAssociation(AssociationEnd association) {
        if (association == null) {
            throw new IllegalArgumentException("The association to be removed can't be null.");
        }
        return associations.remove(association);
    }

    /**
     * <p>
     * Removes all the objects of type "association" from the collection of the current object.
     * </p>
     */
    public void clearAssociations() {
        associations.clear();
    }

    /**
     * <p>
     * Gets all the objects of type "association" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>AssociationEnd</code> added to the collection of current object.
     */
    public Collection<AssociationEnd> getAssociations() {
        return new ArrayList<AssociationEnd>(associations);
    }

    /**
     * <p>
     * Checks if a association is contained in the collection of the current object.
     * </p>
     *
     * @param association
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>association</code> is null.
     * @return <code>true</code> if <code>association</code> is contained in the collection of the current object.
     */
    public boolean containsAssociation(AssociationEnd association) {
        if (association == null) {
            throw new IllegalArgumentException("The association to be tested can't be null.");
        }
        return associations.contains(association);
    }

    /**
     * <p>
     * Returns the number of objects of type "association" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>AssociationEnd</code> inserted in the collection of the current
     *         object.
     */
    public int countAssociations() {
        return associations.size();
    }

    /**
     * <p>
     * Adds a specified end to the collection of the current object.
     * </p>
     *
     * @param specifiedEnd
     *            the specified end to be added.
     * @throws IllegalArgumentException
     *             if <code>specifiedEnd</code> is null.
     */
    public void addSpecifiedEnd(AssociationEnd specifiedEnd) {
        if (specifiedEnd == null) {
            throw new IllegalArgumentException("The specifiedEnd to be added can't be null.");
        }
        specifiedEnds.add(specifiedEnd);
    }

    /**
     * <p>
     * Removes a specified end from the collection of the current object.
     * </p>
     *
     * @param specifiedEnd
     *            the specified end to be removed.
     * @throws IllegalArgumentException
     *             if <code>specifiedEnd</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removeSpecifiedEnd(AssociationEnd specifiedEnd) {
        if (specifiedEnd == null) {
            throw new IllegalArgumentException("The specifiedEnd to be removed can't be null.");
        }
        return specifiedEnds.remove(specifiedEnd);
    }

    /**
     * <p>
     * Removes all the objects of type "specified end" from the collection of the current object.
     * </p>
     */
    public void clearSpecifiedEnds() {
        specifiedEnds.clear();
    }

    /**
     * <p>
     * Gets all the objects of type "specified end" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>AssociationEnd</code> added to the collection of current object.
     */
    public Collection<AssociationEnd> getSpecifiedEnds() {
        return new ArrayList<AssociationEnd>(specifiedEnds);
    }

    /**
     * <p>
     * Checks if a specified end is contained in the collection of the current object.
     * </p>
     *
     * @param specifiedEnd
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>specifiedEnd</code> is null.
     * @return <code>true</code> if <code>specifiedEnd</code> is contained in the collection of the current object.
     */
    public boolean containsSpecifiedEnd(AssociationEnd specifiedEnd) {
        if (specifiedEnd == null) {
            throw new IllegalArgumentException("The specifiedEnd to be tested can't be null.");
        }
        return specifiedEnds.contains(specifiedEnd);
    }

    /**
     * <p>
     * Returns the number of objects of type "specified end" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>AssociationEnd</code> inserted in the collection of the current
     *         object.
     */
    public int countSpecifiedEnds() {
        return specifiedEnds.size();
    }

    /**
     * <p>
     * Adds a powertype range to the collection of the current object.
     * </p>
     *
     * @param powertypeRange
     *            the powertype range to be added.
     * @throws IllegalArgumentException
     *             if <code>powertypeRange</code> is null.
     */
    public void addPowertypeRange(Generalization powertypeRange) {
        if (powertypeRange == null) {
            throw new IllegalArgumentException("The powertypeRange to be added can't be null.");
        }
        powertypeRanges.add(powertypeRange);
    }

    /**
     * <p>
     * Removes a powertype range from the collection of the current object.
     * </p>
     *
     * @param powertypeRange
     *            the powertype range to be removed.
     * @throws IllegalArgumentException
     *             if <code>powertypeRange</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removePowertypeRange(Generalization powertypeRange) {
        if (powertypeRange == null) {
            throw new IllegalArgumentException("The powertypeRange to be removed can't be null.");
        }
        return powertypeRanges.remove(powertypeRange);
    }

    /**
     * <p>
     * Removes all the objects of type "powertype range" from the collection of the current object.
     * </p>
     */
    public void clearPowertypeRanges() {
        powertypeRanges.clear();
    }

    /**
     * <p>
     * Gets all the objects of type "powertype range" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>Generalization</code> added to the collection of current object.
     */
    public Collection<Generalization> getPowertypeRanges() {
        return new ArrayList<Generalization>(powertypeRanges);
    }

    /**
     * <p>
     * Checks if a powertype range is contained in the collection of the current object.
     * </p>
     *
     * @param powertypeRange
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>powertypeRange</code> is null.
     * @return <code>true</code> if <code>powertypeRange</code> is contained in the collection of the current
     *         object.
     */
    public boolean containsPowertypeRange(Generalization powertypeRange) {
        if (powertypeRange == null) {
            throw new IllegalArgumentException("The powertypeRange to be tested can't be null.");
        }
        return powertypeRanges.contains(powertypeRange);
    }

    /**
     * <p>
     * Returns the number of objects of type "powertype range" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Generalization</code> inserted in the collection of the current
     *         object.
     */
    public int countPowertypeRanges() {
        return powertypeRanges.size();
    }

    /**
     * <p>
     * Adds a object flow state to the collection of the current object.
     * </p>
     *
     * @param objectFlowState
     *            the object flow state to be added.
     * @throws IllegalArgumentException
     *             if <code>objectFlowState</code> is null.
     */
    public void addObjectFlowState(ObjectFlowState objectFlowState) {
        if (objectFlowState == null) {
            throw new IllegalArgumentException("The objectFlowState to be added can't be null.");
        }
        objectFlowStates.add(objectFlowState);
    }

    /**
     * <p>
     * Removes a object flow state from the collection of the current object.
     * </p>
     *
     * @param objectFlowState
     *            the object flow state to be removed.
     * @throws IllegalArgumentException
     *             if <code>objectFlowState</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal, i.e. its collection
     *         contained the specified object flow state.
     */
    public boolean removeObjectFlowState(ObjectFlowState objectFlowState) {
        if (objectFlowState == null) {
            throw new IllegalArgumentException("The objectFlowState to be removed can't be null.");
        }
        return objectFlowStates.remove(objectFlowState);
    }

    /**
     * <p>
     * Removes all the objects of type "object flow state" from the collection of the current object.
     * </p>
     */
    public void clearObjectFlowStates() {
        objectFlowStates.clear();
    }

    /**
     * <p>
     * Gets all the objects of type "object flow state" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>ObjectFlowState</code> added to the collection of current object.
     */
    public Collection<ObjectFlowState> getObjectFlowStates() {
        return new ArrayList<ObjectFlowState>(objectFlowStates);
    }

    /**
     * <p>
     * Checks if a object flow state is contained in the collection of the current object.
     * </p>
     *
     * @param objectFlowState
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>objectFlowState</code> is null.
     * @return <code>true</code> if <code>objectFlowState</code> is contained in the collection of the current
     *         object.
     */
    public boolean containsObjectFlowState(ObjectFlowState objectFlowState) {
        if (objectFlowState == null) {
            throw new IllegalArgumentException("The objectFlowState to be tested can't be null.");
        }
        return objectFlowStates.contains(objectFlowState);
    }

    /**
     * <p>
     * Returns the number of objects of type "object flow state" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>ObjectFlowState</code> inserted in the collection of the current
     *         object.
     */
    public int countObjectFlowStates() {
        return objectFlowStates.size();
    }

    /**
     * <p>
     * Adds a instance to the collection of the current object.
     * </p>
     *
     * @param instance
     *            the instance to be added.
     * @throws IllegalArgumentException
     *             if <code>instance</code> is null.
     */
    public void addInstance(Instance instance) {
        if (instance == null) {
            throw new IllegalArgumentException("The instance to be added can't be null.");
        }
        instances.add(instance);
    }

    /**
     * <p>
     * Removes a instance from the collection of the current object.
     * </p>
     *
     * @param instance
     *            the instance to be removed.
     * @throws IllegalArgumentException
     *             if <code>instance</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal, i.e. its collection
     *         contained the specified instance.
     */
    public boolean removeInstance(Instance instance) {
        if (instance == null) {
            throw new IllegalArgumentException("The instance to be removed can't be null.");
        }
        return instances.remove(instance);
    }

    /**
     * <p>
     * Removes all the objects of type "instance" from the collection of the current object.
     * </p>
     */
    public void clearInstances() {
        instances.clear();
    }

    /**
     * <p>
     * Gets all the objects of type "instance" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type <code>Instance</code>
     *         added to the collection of current object.
     */
    public Collection<Instance> getInstances() {
        return new ArrayList<Instance>(instances);
    }

    /**
     * <p>
     * Checks if a instance is contained in the collection of the current object.
     * </p>
     *
     * @param instance
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>instance</code> is null.
     * @return <code>true</code> if <code>instance</code> is contained in the collection of the current object.
     */
    public boolean containsInstance(Instance instance) {
        if (instance == null) {
            throw new IllegalArgumentException("The instance to be tested can't be null.");
        }
        return instances.contains(instance);
    }

    /**
     * <p>
     * Returns the number of objects of type "instance" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Instance</code> inserted in the collection of the current object.
     */
    public int countInstances() {
        return instances.size();
    }

    /**
     * <p>
     * Adds a owned element to the collection of the current object.
     * </p>
     *
     * @param ownedElement
     *            the owned element to be added.
     * @throws IllegalArgumentException
     *             if <code>ownedElement</code> is null.
     */
    public void addOwnedElement(ModelElement ownedElement) {
        if (ownedElement == null) {
            throw new IllegalArgumentException("The ownedElement to be added can't be null.");
        }
        ownedElements.add(ownedElement);
    }

    /**
     * <p>
     * Removes a owned element from the collection of the current object.
     * </p>
     *
     * @param ownedElement
     *            the owned element to be removed.
     * @throws IllegalArgumentException
     *             if <code>ownedElement</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removeOwnedElement(ModelElement ownedElement) {
        if (ownedElement == null) {
            throw new IllegalArgumentException("The ownedElement to be removed can't be null.");
        }
        return ownedElements.remove(ownedElement);
    }

    /**
     * <p>
     * Removes all the objects of type "owned element" from the collection of the current object.
     * </p>
     */
    public void clearOwnedElements() {
        ownedElements.clear();
    }

    /**
     * <p>
     * Gets all the objects of type "owned element" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>ModelElement</code> added to the collection of current object.
     */
    public Collection<ModelElement> getOwnedElements() {
        return new ArrayList<ModelElement>(ownedElements);
    }

    /**
     * <p>
     * Checks if a owned element is contained in the collection of the current object.
     * </p>
     *
     * @param ownedElement
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>ownedElement</code> is null.
     * @return <code>true</code> if <code>ownedElement</code> is contained in the collection of the current object.
     */
    public boolean containsOwnedElement(ModelElement ownedElement) {
        if (ownedElement == null) {
            throw new IllegalArgumentException("The ownedElement to be tested can't be null.");
        }
        return ownedElements.contains(ownedElement);
    }

    /**
     * <p>
     * Returns the number of objects of type "owned element" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>ModelElement</code> inserted in the collection of the current
     *         object.
     */
    public int countOwnedElements() {
        return ownedElements.size();
    }
}
