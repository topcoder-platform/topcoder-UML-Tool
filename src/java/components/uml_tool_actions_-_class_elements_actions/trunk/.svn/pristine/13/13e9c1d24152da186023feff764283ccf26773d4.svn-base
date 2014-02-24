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
public interface Operation extends BehavioralFeature {

    /**
     * <p>
     * Sets the concurrency of the current object.
     * </p>
     *
     * @param concurrency
     *            the concurrency to be set for this object
     */
    public void setConcurrency(CallConcurrencyKind concurrency);

    /**
     * <p>
     * Gets the concurrency of the current object.
     * </p>
     *
     * @return the concurrency of this object
     */
    public CallConcurrencyKind getConcurrency();

    /**
     * <p>
     * Sets if the current object is root.
     * </p>
     *
     * @param isRoot
     *            a boolean value stating if the current object is root
     */
    public void setRoot(boolean isRoot);

    /**
     * <p>
     * Gets a boolean value that is true if the current object is root.
     * </p>
     *
     * @return <code>true</code> if the current object is root, otherwise
     *         <code>false</code>
     */
    public boolean isRoot();

    /**
     * <p>
     * Sets if the current object is leaf.
     * </p>
     *
     * @param isLeaf
     *            a boolean value stating if the current object is leaf
     */
    public void setLeaf(boolean isLeaf);

    /**
     * <p>
     * Gets a boolean value that is true if the current object is leaf.
     * </p>
     *
     * @return <code>true</code> if the current object is leaf, otherwise
     *         <code>false</code>
     */
    public boolean isLeaf();

    /**
     * <p>
     * Sets if the current object is abstract.
     * </p>
     *
     * @param isAbstract
     *            a boolean value stating if the current object is abstract
     */
    public void setAbstract(boolean isAbstract);

    /**
     * <p>
     * Gets a boolean value that is true if the current object is abstract.
     * </p>
     *
     * @return <code>true</code> if the current object is abstract, otherwise
     *         <code>false</code>
     */
    public boolean isAbstract();

    /**
     * <p>
     * Sets the specification of the current object.
     * </p>
     *
     * @param specification
     *            the specification to be set for this object
     */
    public void setSpecification(String specification);

    /**
     * <p>
     * Gets the specification of the current object.
     * </p>
     *
     * @return the specification of this object
     */
    public String getSpecification();

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
    public void addMethod(Method method);

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
    public boolean removeMethod(Method method);

    /**
     * <p>
     * Removes all the objects of type "method" from the collection of the
     * current object.
     * </p>
     */
    public void clearMethods();

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
    public Collection<Method> getMethods();

    /**
     * <p>
     * Checks if a method is contained in the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if <code>method</code> is contained in the
     *         collection of the current object
     * @param method
     */
    public boolean containsMethod(Method method);

    /**
     * <p>
     * Returns the number of objects of type "method" previously added to the
     * collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Method</code> inserted in
     *         the collection of the current object
     */
    public int countMethods();
}