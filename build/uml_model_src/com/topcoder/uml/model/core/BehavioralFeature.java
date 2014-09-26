/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import java.util.List;

/**
 * <p>
 * A behavioral feature refers to a dynamic feature of a model element, such as an operation or method.
 * </p>
 * <p>
 * In the meta model, a BehavioralFeature specifies a behavioral aspect of a Classifier. All different kinds of
 * behavioral aspects of a Classifier, such as Operation and Method, are subclasses of BehavioralFeature.
 * BehavioralFeature is an abstract meta class.
 * </p>
 * <p>
 * A BehavioralFeature has the following properties:
 * <ul>
 * <li> name (Inherited from ModelElement): The name of the BehavioralFeature. The entire signature of the
 * BehavioralFeature (name and parameter list) must be unique within its containing Classifier. </li>
 * <li> isQuery: Specifies whether an execution of the Feature leaves the state of the system unchanged. True indicates
 * that the state is unchanged; false indicates that side-effects may occur. </li>
 * <li> parameters: An ordered list of Parameters for the Operation. To call the Operation, the caller must supply a
 * list of values compatible with the types of the Parameters. </li>
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
public interface BehavioralFeature extends Feature {

    /**
     * <p>
     * Sets if the current object is query.
     * </p>
     *
     * @param isQuery
     *            a boolean value stating if the current object is query.
     */
    void setQuery(boolean isQuery);

    /**
     * <p>
     * Gets a boolean value that is true if the current object is query.
     * </p>
     *
     * @return <code>true</code> if the current object is query, otherwise <code>false</code>.
     */
    boolean isQuery();

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
    void addParameter(Parameter parameter);

    /**
     * <p>
     * Adds a parameter at specified index of the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            index at which the parameter is to be added.
     * @param parameter
     *            the parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or &gt; parameters.size.
     */
    void addParameter(int index, Parameter parameter);

    /**
     * <p>
     * Sets the parameter at specified index of the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            index at which the parameter is to be set.
     * @param parameter
     *            the parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or &gt;= parameters.size.
     */
    void setParameter(int index, Parameter parameter);

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
    Parameter removeParameter(int index);

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
    boolean removeParameter(Parameter parameter);

    /**
     * <p>
     * Removes all the objects of type "parameter" from the ordered collection of the current object.
     * </p>
     */
    void clearParameters();

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
    List<Parameter> getParameters();

    /**
     * <p>
     * Checks if a parameter is contained in the ordered collection of the current object.
     * </p>
     *
     * @param parameter
     *            element whose presence in this List is to be tested.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @return <code>true</code> if <code>parameter</code> is contained in the collection of the current object.
     */
    boolean containsParameter(Parameter parameter);

    /**
     * <p>
     * Gets the index of the specified template parameter in the ordered collection of the current object, or -1 if such
     * a collection doesn't contain it.
     * </p>
     *
     * @param parameter
     *            the search object.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @return the index of the specified <code>Parameter</code> in the ordered collection of the current object, or
     *         -1 if such a collection doesn't contain it.
     */
    int indexOfParameter(Parameter parameter);

    /**
     * <p>
     * Returns the number of objects of type "parameter" previously added to the ordered collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>Parameter</code> inserted in the ordered collection of the
     *         current object.
     */
    int countParameters();
}
