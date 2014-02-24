/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * This class is a default implementation of the <code>Operation</code> interface.
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
public class OperationImpl extends BehavioralFeatureAbstractImpl implements Operation {

    /**
     * <p>
     * Specifies the semantics of concurrent calls to the same passive instance (i.e., an Instance originating from a
     * Classifier with isActive=false).
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private CallConcurrencyKind concurrency;

    /**
     * <p>
     * If true, then the class must not inherit a declaration of the same operation.
     * </p>
     * <p>
     * This value is initially left set to false; after construction, it can be set to either true or false through the
     * appropriate setter.
     * </p>
     */
    private boolean isRoot;

    /**
     * <p>
     * If true, then the implementation of the operation may not be overriden by a descendant class.
     * </p>
     * <p>
     * This value is initially left set to false; after construction, it can be set to either true or false through the
     * appropriate setter.
     * </p>
     */
    private boolean isLeaf;

    /**
     * <p>
     * If true, then the operation does not have an implementation, and one must be supplied by a descendant.
     * </p>
     * <p>
     * This value is initially left set to false; after construction, it can be set to either true or false through the
     * appropriate setter.
     * </p>
     */
    private boolean isAbstract;

    /**
     * <p>
     * A String specification for the Operation.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private String specification;

    /**
     * <p>
     * An unordered collection of Methods owned by the Operation.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction.The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<Method> methods = new ArrayList<Method>();

    /**
     * <p>
     * Constructs a basic instance of this class.
     * </p>
     * <p>
     * This constructor doen't actually initialize anything; the non-collection attributes of the class are simply left
     * assigned to <code>null</code> references, while the collection attributes are instantiated to
     * <code>ArrayList</code>s or <code>LinkedList</code>s with initialization clauses specified in the
     * declaration of the attributes themselves. That is, the JVM should have already set the attributes to the correct
     * references before the execution of this constructor occurs.
     * </p>
     * <p>
     * In case of boolean attributes, they're set to <code>false</code>.
     * </p>
     */
    public OperationImpl() {
    }

    /**
     * <p>
     * Sets the concurrency of the current object.
     * </p>
     *
     * @param concurrency
     *            the concurrency to be set for this object
     */
    public void setConcurrency(CallConcurrencyKind concurrency) {
        this.concurrency = concurrency;
    }

    /**
     * <p>
     * Gets the concurrency of the current object.
     * </p>
     *
     * @return the concurrency of this object
     */
    public CallConcurrencyKind getConcurrency() {
        return concurrency;
    }

    /**
     * <p>
     * Sets if the current object is root.
     * </p>
     *
     * @param isRoot
     *            a boolean value stating if the current object is root
     */
    public void setRoot(boolean isRoot) {
        this.isRoot = isRoot;
    }

    /**
     * <p>
     * Gets a boolean value that is true if the current object is root.
     * </p>
     *
     * @return <code>true</code> if the current object is root, otherwise <code>false</code>
     */
    public boolean isRoot() {
        return isRoot;
    }

    /**
     * <p>
     * Sets if the current object is leaf.
     * </p>
     *
     * @param isLeaf
     *            a boolean value stating if the current object is leaf
     */
    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * <p>
     * Gets a boolean value that is true if the current object is leaf.
     * </p>
     *
     * @return <code>true</code> if the current object is leaf, otherwise <code>false</code>
     */
    public boolean isLeaf() {
        return isLeaf;
    }

    /**
     * <p>
     * Sets if the current object is abstract.
     * </p>
     *
     * @param isAbstract
     *            a boolean value stating if the current object is abstract
     */
    public void setAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    /**
     * <p>
     * Gets a boolean value that is true if the current object is abstract.
     * </p>
     *
     * @return <code>true</code> if the current object is abstract, otherwise <code>false</code>
     */
    public boolean isAbstract() {
        return isAbstract;
    }

    /**
     * <p>
     * Sets the specification of the current object.
     * </p>
     *
     * @param specification
     *            the specification to be set for this object
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * <p>
     * Gets the specification of the current object.
     * </p>
     *
     * @return the specification of this object
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * <p>
     * Adds a method to the collection of the current object.
     * </p>
     *
     * @param method
     *            the method to be added
     * @throws IllegalArgumentException
     *             if <code>method</code> is null
     */
    public void addMethod(Method method) {
        if (method == null) {
            throw new IllegalArgumentException("The method to be added can't be null.");
        }
        methods.add(method);
    }

    /**
     * <p>
     * Removes a method from the collection of the current object.
     * </p>
     *
     * @param method
     *            the method to be removed
     * @throws IllegalArgumentException
     *             if <code>method</code> is null
     * @return <code>true</code> if the current object state changed because of the removal, i.e. its collection
     *         contained the specified method
     */
    public boolean removeMethod(Method method) {
        if (method == null) {
            throw new IllegalArgumentException("The method to be removed can't be null.");
        }
        return methods.remove(method);
    }

    /**
     * <p>
     * Removes all the objects of type "method" from the collection of the current object.
     * </p>
     */
    public void clearMethods() {
        methods.clear();
    }

    /**
     * <p>
     * Gets all the objects of type "method" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type <code>Method</code>
     *         added to the collection of current object
     */
    public Collection<Method> getMethods() {
        return new ArrayList<Method>(methods);
    }

    /**
     * <p>
     * Checks if a method is contained in the collection of the current object.
     * </p>
     *
     * @param method
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>method</code> is null.
     * @return <code>true</code> if <code>method</code> is contained in the collection of the current object
     */
    public boolean containsMethod(Method method) {
        if (method == null) {
            throw new IllegalArgumentException("The method to be tested can't be null.");
        }
        return methods.contains(method);
    }

    /**
     * <p>
     * Returns the number of objects of type "method" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Method</code> inserted in the collection of the current object
     */
    public int countMethods() {
        return methods.size();
    }
}
