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
public interface BehavioralFeature extends Feature {
    /**
     * <p>
     * Sets if the current object is query.
     * </p>
     *
     * @param isQuery
     *            a boolean value stating if the current object is query
     */
    public void setQuery(boolean isQuery);

    /**
     * <p>
     * Gets a boolean value that is true if the current object is query.
     * </p>
     *
     * @return <code>true</code> if the current object is query, otherwise
     *         <code>false</code>
     */
    public boolean isQuery();

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
    public void addParameter(Parameter parameter);

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
    public void addParameter(int index, Parameter parameter);

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
    public void setParameter(int index, Parameter parameter);

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
    public Parameter removeParameter(int index);

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
    public boolean removeParameter(Parameter parameter);

    /**
     * <p>
     * Removes all the objects of type "parameter" from the ordered collection
     * of the current object.
     * </p>
     */
    public void clearParameters();

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
    public List<Parameter> getParameters();

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
    public boolean containsParameter(Parameter parameter);

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
    public int indexOfParameter(Parameter parameter);

    /**
     * <p>
     * Returns the number of objects of type "parameter" previously added to the
     * ordered collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Parameter</code> inserted
     *         in the ordered collection of the current object
     */
    public int countParameters();
}