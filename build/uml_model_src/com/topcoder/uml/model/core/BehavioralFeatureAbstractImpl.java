/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import java.util.List;
import java.util.LinkedList;

/**
 * <p>
 * This abstract class is a default implementation of the <code>BehavioralFeature</code> interface.
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
public abstract class BehavioralFeatureAbstractImpl extends FeatureAbstractImpl implements BehavioralFeature {

    /**
     * <p>
     * Specifies whether an execution of the Feature leaves the state of the system unchanged.
     * </p>
     * <p>
     * This value is initially left set to false; after construction, it can be set to either true or false through the
     * appropriate setter.
     * </p>
     */
    private boolean isQuery;

    /**
     * <p>
     * An ordered list of Parameters for the Operation.
     * </p>
     * <p>
     * This ordered collection is instantiated as an empty <code>LinkedList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it, except
     * for null values; duplicated entries are allowed.
     * </p>
     */
    private final List<Parameter> parameters = new LinkedList<Parameter>();

    /**
     * <p>
     * Constructs a basic instance of this class.
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
     *            a boolean value stating if the current object is query.
     */
    public void setQuery(boolean isQuery) {
        this.isQuery = isQuery;
    }

    /**
     * <p>
     * Gets a boolean value that is true if the current object is query.
     * </p>
     *
     * @return <code>true</code> if the current object is query, otherwise <code>false</code>.
     */
    public boolean isQuery() {
        return isQuery;
    }

    /**
     * <p>
     * Adds a parameter at the end of the ordered collection of the current object.
     * </p>
     *
     * @param parameter
     *            the parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     */
    public void addParameter(Parameter parameter) {
        if (parameter == null) {
            throw new IllegalArgumentException("The parameter to be added can't be null.");
        }
        parameters.add(parameter);
    }

    /**
     * <p>
     * Adds a parameter at specified index of the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            index at which the specified parameter is to be added.
     * @param parameter
     *            the parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or &gt; parameters.size.
     */
    public void addParameter(int index, Parameter parameter) {
        if (parameter == null) {
            throw new IllegalArgumentException("The parameter to be added can't be null.");
        }
        parameters.add(index, parameter);
    }

    /**
     * <p>
     * Sets the parameter at specified index of the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            index at which the specified parameter is to be set.
     * @param parameter
     *            the parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or &gt;= parameters.size.
     */
    public void setParameter(int index, Parameter parameter) {
        if (parameter == null) {
            throw new IllegalArgumentException("The parameter to be set can't be null.");
        }
        parameters.set(index, parameter);
    }

    /**
     * <p>
     * Removes (and fetches) the parameter at specified index from the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            the index of the parameter to be removed.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or &gt;= parameters.size.
     * @return the removed object of type <code>Parameter</code>.
     */
    public Parameter removeParameter(int index) {
        return parameters.remove(index);
    }

    /**
     * <p>
     * Removes a parameter from the ordered collection of the current object.
     * </p>
     *
     * @param parameter
     *            the parameter to be removed.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removeParameter(Parameter parameter) {
        if (parameter == null) {
            throw new IllegalArgumentException("The parameter to be removed can't be null.");
        }
        return parameters.remove(parameter);
    }

    /**
     * <p>
     * Removes all the objects of type "parameter" from the ordered collection of the current object.
     * </p>
     */
    public void clearParameters() {
        parameters.clear();
    }

    /**
     * <p>
     * Gets all the objects of type "parameter" previously added to the ordered collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned list do not change the state of current object (i.e.
     * the returned list is a copy of the internal one of the current object). However, if an element contained in it is
     * modified, the state of the current object is modified accordingly (i.e. the internal and the returned lists share
     * references to the same objects).
     * </p>
     *
     * @return a <code>java.util.List</code> instance, containing all the objects of type <code>Parameter</code>
     *         added to the collection of current object.
     */
    public List<Parameter> getParameters() {
        return new LinkedList<Parameter>(parameters);
    }

    /**
     * <p>
     * Checks if a parameter is contained in the ordered collection of the current object.
     * </p>
     *
     * @param parameter
     *            the parameter to be tested.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @return <code>true</code> if <code>parameter</code> is contained in the collection of the current object.
     */
    public boolean containsParameter(Parameter parameter) {
        if (parameter == null) {
            throw new IllegalArgumentException("The parameter to check can't be null.");
        }
        return parameters.contains(parameter);
    }

    /**
     * <p>
     * Gets the index of the specified template parameter in the ordered collection of the current object, or -1 if such
     * a collection doesn't contain it.
     * </p>
     *
     * @param parameter
     *            the desired parameter.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @return the index of the specified <code>Parameter</code> in the ordered collection of the current object, or
     *         -1 if such a collection doesn't contain it.
     */
    public int indexOfParameter(Parameter parameter) {
        if (parameter == null) {
            throw new IllegalArgumentException("The parameter to query can't be null.");
        }
        return parameters.indexOf(parameter);
    }

    /**
     * <p>
     * Returns the number of objects of type "parameter" previously added to the ordered collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>Parameter</code> inserted in the ordered collection of the
     *         current object.
     */
    public int countParameters() {
        return parameters.size();
    }
}
