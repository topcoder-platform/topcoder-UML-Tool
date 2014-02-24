/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core;

import java.util.*;

import com.topcoder.uml.model.datatypes.CallConcurrencyKind;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class OperationImpl extends BehavioralFeatureAbstractImpl implements Operation {

    /**
     * Specifies the semantics of concurrent calls to the same passive instance
     * (i.e., an Instance originating from a Classifier with isActive=false).
     * This attribute is initially left set to null; after construction, it can
     * be set to any value (null included) through the appropriate setter.
     */
    private CallConcurrencyKind concurrency;

    /**
     * If true, then the class must not inherit a declaration of the same
     * operation. This value is initially left set to false; after construction,
     * it can be set to either true or false through the appropriate setter.
     */
    private boolean isRoot;

    /**
     * If true, then the implementation of the operation may not be overriden by
     * a descendant class. This value is initially left set to false; after
     * construction, it can be set to either true or false through the
     * appropriate setter.
     */
    private boolean isLeaf;

    /**
     * If true, then the operation does not have an implementation, and one must
     * be supplied by a descendant. This value is initially left set to false;
     * after construction, it can be set to either true or false through the
     * appropriate setter.
     */
    private boolean isAbstract;

    /**
     * A String specification for the Operation. This attribute is initially
     * left set to null; after construction, it can be set to any value (null
     * included) through the appropriate setter.
     */
    private String specification;

    /**
     * An unordered collection of Methods owned by the Operation. This unordered
     * collection is instantiated as an empty ArrayList during construction.The
     * value of this attribute cannot be changed after construction; the content
     * of the collection itself can be modified through the appropriate methods
     * (add, remove...). Every object of the appropriate type can be inserted
     * into it; null values are not allowed; duplicate entries are allowed.
     */
    private final Collection<Method> methods = new ArrayList<Method>();

    /**
     * <p>
     * Constructs a basic instance of this class.
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
    }

    /**
     * <p>
     * Gets the concurrency of the current object.
     * </p>
     *
     * @return the concurrency of this object
     */
    public CallConcurrencyKind getConcurrency() {
        return null;
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
    }

    /**
     * <p>
     * Gets a boolean value that is true if the current object is root.
     * </p>
     *
     * @return <code>true</code> if the current object is root, otherwise
     *         <code>false</code>
     */
    public boolean isRoot() {
        return false;
    }

    /**
     * <p>
     * Sets if the current object is leaf.
     * </p>
     *
     * @poseidon-object-id [I6a868a04m10e5cf1ec66mm700e]
     * @param isLeaf
     *            a boolean value stating if the current object is leaf
     */
    public void setLeaf(boolean isLeaf) {
    }

    /**
     * <p>
     * Gets a boolean value that is true if the current object is leaf.
     * </p>
     *
     * @return <code>true</code> if the current object is leaf, otherwise
     *         <code>false</code>
     */
    public boolean isLeaf() {
        return false;
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
    }

    /**
     * <p>
     * Gets a boolean value that is true if the current object is abstract.
     * </p>
     *
     * @return <code>true</code> if the current object is abstract, otherwise
     *         <code>false</code>
     */
    public boolean isAbstract() {
        return false;
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
    }

    /**
     * <p>
     * Gets the specification of the current object.
     * </p>
     *
     * @return the specification of this object
     */
    public String getSpecification() {
        return null;
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
    }

    /**
     * <p>
     * Removes a method from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         method
     * @param method
     *            the method to be removed
     * @throws IllegalArgumentException
     *             if <code>method</code> is null
     */
    public boolean removeMethod(Method method) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "method" from the collection of the
     * current object.
     * </p>
     */
    public void clearMethods() {
    }

    /**
     * <p>
     * Gets all the objects of type "method" previously added to the collection
     * of the current object.
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>Method</code> added to the collection
     *         of current object
     */
    public Collection<Method> getMethods() {
        return this.methods;
    }

    /**
     * <p>
     * Checks if a method is contained in the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if <code>method</code> is contained in the
     *         collection of the current object
     * @param method
     */
    public boolean containsMethod(Method method) {
        return false;
    }

    /**
     * <p>
     * Returns the number of objects of type "method" previously added to the
     * collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Method</code> inserted in
     *         the collection of the current object
     */
    public int countMethods() {
        return 0;
    }
}