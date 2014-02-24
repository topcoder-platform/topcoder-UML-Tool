/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core;

import java.util.*;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public abstract class BehavioralFeatureAbstractImpl extends FeatureAbstractImpl implements BehavioralFeature {

    /**
     * Specifies whether an execution of the Feature leaves the state of the
     * system unchanged. This value is initially left set to false; after
     * construction, it can be set to either true or false through the
     * appropriate setter.
     *
     */
    private boolean isQuery;

    /**
     * An ordered list of Parameters for the Operation. This ordered collection
     * is instantiated as an empty LinkedList during construction.The value of
     * this attribute cannot be changed after construction; the content of the
     * collection itself can be modified through the appropriate methods (add,
     * remove...). Every object of the appropriate type can be inserted into it,
     * except for null values; duplicated entries are allowed.
     */
    private final List<Parameter> parameters = new LinkedList<Parameter>();

    /**
     * <p>
     * Constructs a basic instance of this class.
     * </p>
     *
     * <p>
     * This constructor doen't actually initialize nothing; the non-collection
     * attributes of the class are simply left assigned to <code>null</code>
     * references, while the collection attributes are instantiated to
     * <code>ArrayList</code>s or <code>LinkedList</code>s with
     * initialization clauses specified in the declaration of the attributes
     * theirselves. That is, the JVM should have already set the attributes to
     * the correct references before the execution of this constructor occurs.
     * </p>
     *
     * <p>
     * In case of boolean attributes, they're set to <code>false</code>.
     * </p>
     */
    protected BehavioralFeatureAbstractImpl() {
    }

    /**
     * <p>
     * Sets if the current object is query.
     * </p>
     *
     * @param isQuery
     *            a boolean value stating if the current object is query
     */
    public void setQuery(boolean isQuery) {
    }

    /**
     * <p>
     * Gets a boolean value that is true if the current object is query.
     * </p>
     *
     * @return <code>true</code> if the current object is query, otherwise
     *         <code>false</code>
     */
    public boolean isQuery() {
        return false;
    }

    /**
     * <p>
     * Adds a parameter at the end of the ordered collection of the current
     * object.
     * </p>
     *
     * @param parameter
     *            the parameter to be added
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null
     */
    public void addParameter(Parameter parameter) {
    }

    /**
     * <p>
     * Adds a parameter at specified index of the ordered collection of the
     * current object.
     * </p>
     *
     * @param index
     * @param parameter
     *            the parameter to be added
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is not valid, i.e. the condition <i>0 <=
     *             index < countParameters()</i> does not hold.
     */
    public void addParameter(int index, Parameter parameter) {
    }

    /**
     * <p>
     * Sets the parameter at specified index of the ordered collection of the
     * current object.
     * </p>
     *
     * @param index
     * @param parameter
     *            the parameter to be added
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is not valid, i.e. the condition <i>0 <=
     *             index < countParameters()</i> does not hold.
     */
    public void setParameter(int index, Parameter parameter) {
    }

    /**
     * <p>
     * Removes (and fetches) the parameter at specified index from the ordered
     * collection of the current object.
     * </p>
     *
     * @return the removed object of type <code>Parameter</code>
     * @param index
     *            the index of the parameter to be removed
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is not valid, i.e. the condition <i>0 <=
     *             index < countParameters()</i> does not hold.
     */
    public Parameter removeParameter(int index) {
        return null;
    }

    /**
     * <p>
     * Removes a parameter from the ordered collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         parameter
     * @param parameter
     *            the parameter to be removed
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null
     */
    public boolean removeParameter(Parameter parameter) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "parameter" from the ordered collection
     * of the current object.
     * </p>
     */
    public void clearParameters() {
    }

    /**
     * <p>
     * Gets all the objects of type "parameter" previously added to the ordered
     * collection of the current object.
     * </p>
     *
     * <p>
     * Additions and removals of elements to and from the returned list do not
     * change the state of current object (i.e. the returned list is a copy of
     * the internal one of the current object). However, if an element contained
     * in it is modified, the state of the current object is modified
     * accordingly (i.e. the internal and the returned lists share references to
     * the same objects).
     * </p>
     *
     * @return a <code>java.util.List</code> instance, containing all the
     *         objects of type <code>Parameter</code> added to the collection
     *         of current object
     */
    public List<Parameter> getParameters() {
        return this.parameters;
    }

    /**
     * <p>
     * Checks if a parameter is contained in the ordered collection of the
     * current object.
     * </p>
     *
     * @return <code>true</code> if <code>parameter</code> is contained in
     *         the collection of the current object
     * @param parameter
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null
     */
    public boolean containsParameter(Parameter parameter) {
        return false;
    }

    /**
     * <p>
     * Gets the index of the specified template parameter in the ordered
     * collection of the current object, or -1 if such a collection doesn't
     * contain it.
     * </p>
     *
     * @return the index of the specified <code>Parameter</code> in the
     *         ordered collection of the current object, or -1 if such a
     *         collection doesn't contain it.
     * @param parameter
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null
     */
    public int indexOfParameter(Parameter parameter) {
        return 0;
    }

    /**
     * <p>
     * Returns the number of objects of type "parameter" previously added to the
     * ordered collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Parameter</code> inserted
     *         in the ordered collection of the current object
     */
    public int countParameters() {
        return 0;
    }
}