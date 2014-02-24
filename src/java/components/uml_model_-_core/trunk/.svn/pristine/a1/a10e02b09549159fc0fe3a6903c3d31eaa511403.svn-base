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

/**
 * <p>
 * A classifier is an element that describes behavioral and structural features; it comes in several specific forms,
 * including class, data type, interface, component, artifact, and others that are defined in other meta model packages.
 * </p>
 * <p>
 * In the meta model, a Classifier declares a collection of Features, such as Attributes, Methods, and Operations. It
 * has a name, which is unique in the Namespace enclosing the Classifier. Classifier is an abstract meta class.
 * </p>
 * <p>
 * Classifier is a child of GeneralizableElement and Namespace. As a GeneralizableElement, it may inherit Features and
 * participation in Associations (in addition to things inherited as a ModelElement). It also inherits ownership of
 * StateMachines, Collaborations, etc.
 * </p>
 * <p>
 * As a Namespace, a Classifier may declare other Classifiers nested in its scope. Nested Classifiers may be accessed by
 * other Classifiers only if the nested Classifiers have adequate visibility. There are no data value or state
 * consequences of nested Classifiers (i.e., it is not an aggregation or composition).
 * </p>
 * <p>
 * A Classifier has the following properties:
 * <ul>
 * <li>features: An ordered list of Features, like Attribute, Operation, Method owned by the Classifier.</li>
 * <li>typedFeatures: An unordered collection of StructuralFeatures owned by the Classifier.</li>
 * <li>typedParameters: An unordered collection of Parameters owned by the Classifier.</li>
 * <li>associations: Denotes the AssociationEnd of an Association in which the Classifier participates at the given
 * end. This is the inverse of the participant association from AssociationEnd. A link of the association contains a
 * reference to an instance of the class in the given position. </li>
 * <li>specifiedEnds: Indicates an AssociationEnd for which the given Classifier specifies operations that may be
 * applied to instances obtained by traversing the association from the other end. (This relationship does not define
 * the structure of the association, merely operations that may be applied on traversing it.) </li>
 * <li>powertypeRanges: Designates zero or more Generalizations for which the Classifier is a powertype. If the
 * cardinality is zero, then the Classifier is not a powertype; if the cardinality is greater than zero, then the
 * Classifier is a powertype over the set of Generalizations designated by the association, and the child elements of
 * the Generalizations are the instances of the Classifier as a powertype.</li>
 * <li>objectFlowStates: An unordered collection of ObjectFlowStates owned by the Classifier.</li>
 * <li>instances: An unordered collection of Instances owned by the Classifier.</li>
 * </ul>
 * </p>
 * <p>
 * <b>Thread Safety</b>: Implementations of this interface are not required to be thread-safe, since thread safety
 * should be handled by the application itself.
 * </p>
 *
 * @author Pisky, vividmxx
 * @version 1.0
 */
public interface Classifier extends GeneralizableElement, Namespace {
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
    void addFeature(Feature feature);

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
     *             if <code>index</code> is &lt; 0 or &gt; features.size.
     */
    void addFeature(int index, Feature feature);

    /**
     * <p>
     * Sets the feature at specified index of the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            index of feature to replace.
     * @param feature
     *            the feature to be added.
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or &gt;= features.size.
     */
    void setFeature(int index, Feature feature);

    /**
     * <p>
     * Removes (and fetches) the feature at specified index from the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            the index of the feature to be removed.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or &gt;= features.size.
     * @return the removed object of type <code>Feature</code>.
     */
    Feature removeFeature(int index);

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
    boolean removeFeature(Feature feature);

    /**
     * <p>
     * Removes all the objects of type "feature" from the ordered collection of the current object.
     * </p>
     */
    void clearFeatures();

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
    List<Feature> getFeatures();

    /**
     * <p>
     * Checks if a feature is contained in the ordered collection of the current object.
     * </p>
     *
     * @param feature
     *            the feature to be tested.
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null.
     * @return <code>true</code> if <code>feature</code> is contained in the collection of the current object.
     */
    boolean containsFeature(Feature feature);

    /**
     * <p>
     * Gets the index of the specified feature in the ordered collection of the current object, or -1 if such a
     * collection doesn't contain it.
     * </p>
     *
     * @param feature
     *            the desired feature.
     * @throws IllegalArgumentException
     *             if <code>feature</code> is null.
     * @return the index of the specified <code>Feature</code> in the ordered collection of the current object, or -1
     *         if such a collection doesn't contain it.
     */
    int indexOfFeature(Feature feature);

    /**
     * <p>
     * Returns the number of objects of type "feature" previously added to the ordered collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Feature</code> inserted in the ordered collection of the current
     *         object.
     */
    int countFeatures();

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
    void addTypedFeature(StructuralFeature typedFeature);

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
    boolean removeTypedFeature(StructuralFeature typedFeature);

    /**
     * <p>
     * Removes all the objects of type "typed feature" from the collection of the current object.
     * </p>
     */
    void clearTypedFeatures();

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
    Collection<StructuralFeature> getTypedFeatures();

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
    boolean containsTypedFeature(StructuralFeature typedFeature);

    /**
     * <p>
     * Returns the number of objects of type "typed feature" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>StructuralFeature</code> inserted in the collection of the
     *         current object.
     */
    int countTypedFeatures();

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
    void addTypedParameter(Parameter typedParameter);

    /**
     * <p>
     * Removes a typed parameter from the collection of the current object.
     * </p>
     *
     * @param typedParameter
     *            the typed parameter to be removed.
     * @throws IllegalArgumentException
     *             if <code>typedParameter</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal, i.e. its collection
     *         contained the specified typed parameter.
     */
    boolean removeTypedParameter(Parameter typedParameter);

    /**
     * <p>
     * Removes all the objects of type "typed parameter" from the collection of the current object.
     * </p>
     */
    void clearTypedParameters();

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
    Collection<Parameter> getTypedParameters();

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
    boolean containsTypedParameter(Parameter typedParameter);

    /**
     * <p>
     * Returns the number of objects of type "typed parameter" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Parameter</code> inserted in the collection of the current
     *         object.
     */
    int countTypedParameters();

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
    void addAssociation(AssociationEnd association);

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
    boolean removeAssociation(AssociationEnd association);

    /**
     * <p>
     * Removes all the objects of type "association" from the collection of the current object.
     * </p>
     */
    void clearAssociations();

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
    Collection<AssociationEnd> getAssociations();

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
    boolean containsAssociation(AssociationEnd association);

    /**
     * <p>
     * Returns the number of objects of type "association" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>AssociationEnd</code> inserted in the collection of the current
     *         object.
     */
    int countAssociations();

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
    void addSpecifiedEnd(AssociationEnd specifiedEnd);

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
    boolean removeSpecifiedEnd(AssociationEnd specifiedEnd);

    /**
     * <p>
     * Removes all the objects of type "specified end" from the collection of the current object.
     * </p>
     */
    void clearSpecifiedEnds();

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
    Collection<AssociationEnd> getSpecifiedEnds();

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
    boolean containsSpecifiedEnd(AssociationEnd specifiedEnd);

    /**
     * <p>
     * Returns the number of objects of type "specified end" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>AssociationEnd</code> inserted in the collection of the current
     *         object.
     */
    int countSpecifiedEnds();

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
    void addPowertypeRange(Generalization powertypeRange);

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
    boolean removePowertypeRange(Generalization powertypeRange);

    /**
     * <p>
     * Removes all the objects of type "powertype range" from the collection of the current object.
     * </p>
     */
    void clearPowertypeRanges();

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
    Collection<Generalization> getPowertypeRanges();

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
    boolean containsPowertypeRange(Generalization powertypeRange);

    /**
     * <p>
     * Returns the number of objects of type "powertype range" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Generalization</code> inserted in the collection of the current
     *         object.
     */
    int countPowertypeRanges();

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
    void addObjectFlowState(ObjectFlowState objectFlowState);

    /**
     * <p>
     * Removes a object flow state from the collection of the current object.
     * </p>
     *
     * @param objectFlowState
     *            the object flow state to be removed.
     * @throws IllegalArgumentException
     *             if <code>objectFlowState</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    boolean removeObjectFlowState(ObjectFlowState objectFlowState);

    /**
     * <p>
     * Removes all the objects of type "object flow state" from the collection of the current object.
     * </p>
     */
    void clearObjectFlowStates();

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
    Collection<ObjectFlowState> getObjectFlowStates();

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
    boolean containsObjectFlowState(ObjectFlowState objectFlowState);

    /**
     * <p>
     * Returns the number of objects of type "object flow state" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>ObjectFlowState</code> inserted in the collection of the current
     *         object.
     */
    int countObjectFlowStates();

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
    void addInstance(Instance instance);

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
    boolean removeInstance(Instance instance);

    /**
     * <p>
     * Removes all the objects of type "instance" from the collection of the current object.
     * </p>
     */
    void clearInstances();

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
    Collection<Instance> getInstances();

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
    boolean containsInstance(Instance instance);

    /**
     * <p>
     * Returns the number of objects of type "instance" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Instance</code> inserted in the collection of the current object.
     */
    int countInstances();
}
