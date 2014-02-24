/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.Collection;

/**
 * <p>
 * A composite state is decomposed into two or more concurrent substates (called regions) or into mutually exclusive
 * disjoint substates (i.e. sequential). A given state may only be refined in one of these two ways. Naturally, any
 * substate of a composite state can also be a composite state of either type. (OMG Unified Modeling Language
 * Specification - UML 1.5 UML Notation, p. 540)
 * </p>
 * <p>
 * A composite state is a state that contains other state vertices (states, pseudostates, etc.). The association between
 * the composite and the contained vertices is a composition association. Hence, a state vertex can be a part of at most
 * one composite state.
 * </p>
 * <p>
 * <b>Thread Safety</b>: Implementations are mutable, there is no requirement to make implementations of this interface
 * thread-safe.
 * </p>
 *
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public interface CompositeState extends State {
    /**
     * <p>
     * Tests to see if concurrency indicator for this state is set. If this attribute is true, then the composite state
     * is decomposed directly into two or more orthogonal conjunctive components (usually associated with concurrent
     * execution). If this attribute is false, then there are no direct orthogonal components in the composite.
     * </p>
     *
     * @return true if this state is concurrent;false otherwise
     */
    public boolean isConcurrent();

    /**
     * <p>
     * Sets the concurrency indicator for this state to either true or false. - If this attribute is true, then the
     * composite state is decomposed directly into two or more orthogonal conjunctive components (usually associated
     * with concurrent execution). - If this attribute is false, then there are no direct orthogonal components in the
     * composite.
     * </p>
     *
     * @param concurrent
     *            concurrent flag
     */
    public void setConcurrent(boolean concurrent);

    /**
     * <p>
     * Add a sub-vertex to this composite state. We do allow duplicate elements. Add at the end of the collection
     * </p>
     *
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     * @param subVertex
     *            sub vertex (region) to be added.
     */
    public void addSubVertex(StateVertex subVertex);

    /**
     * <p>
     * Remove a sub-vertex from this composite state. If the sub-vertex doesn't exist (or for some reason we cannot
     * remove the element) we return false. We return true if successful.
     * </p>
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     * @param subVertex
     *            sub vertex (region) to be removed from this composite state
     * @return true if we successfully removed the element;false otherwise
     */
    public boolean removeSubVertex(StateVertex subVertex);

    /**
     * <p>
     * Remove all contained sub-vertexes from this composite state. After this is done the count should be 0;
     * </p>
     */
    public void clearSubVertexes();

    /**
     * <p>
     * Return an unordered collection containing all of the sub-vertexes in this composite state.
     * </p>
     *
     * @return a collection of all vertexes for this state.
     */
    public Collection<StateVertex> getSubVertexes();

    /**
     * <p>
     * Returns true if the input sub-vertex instance is contained in the collection of sub-vertexes for this composite
     * state and false if it is not.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     * @param subVertex
     *            sub vertex (region) to be tested
     * @return true if the sub vertex is contained in this composite state
     */
    public boolean containsSubVertex(StateVertex subVertex);

    /**
     * <p>
     * Returns the current number of sub-vertexes in the composite state.
     * </p>
     *
     * @return the number of sub vertexes that are currently part of this composite state
     */
    public int countSubVertexes();
}
