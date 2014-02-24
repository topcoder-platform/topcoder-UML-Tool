/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * This is an implementation of the CompositeState Interface which is an extension old State which is in turn an
 * extension of a StateVertes. A composite state is decomposed into two or more concurrent substates (called regions) or
 * into mutually exclusive disjoint substates (i.e. sequential). A given state may only be refined in one of these two
 * ways. Naturally, any substate of a composite state can also be a composite state of either type. (OMG Unified
 * Modeling Language Specification - UML 1.5 UML Notation, p. 540) A composite state is a state that contains other
 * state vertices (states, pseudostates, etc.). The association between the composite and the contained vertices is a
 * composition association. Hence, a state vertex can be a part of at most one composite state.
 * </p>
 * <p>
 * <b>Thread Safety</b>:This Implementation is mutable and is thus NOT thread-safe. There is no requirement to make
 * implementations of CompositeState interface thread-safe.
 * </p>
 *
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public class CompositeStateImpl extends AbstractStateImpl implements CompositeState {

    /**
     * <p>
     * Represents a concurrency indicator for this composite state. If this attribute is true, then the composite state
     * is decomposed directly into two or more orthogonal conjunctive components (usually associated with concurrent
     * execution). If this attribute is false, then there are no direct orthogonal components in the composite.
     * </p>
     * <p>
     * It is initialized through the 2nd constructor or through a dedicated setter and is mutable through a setter.
     * </p>
     */
    private boolean isConcurrent = false;

    /**
     * <p>
     * Represents an unordered collection containing all of the sub-vertexes in this composite state
     * </p>
     * <p>
     * It is initialized in constructor. If an actual collection is passed in we make a shallow copy of its contents. It
     * cannot be null and is not mutable after initialization. But the contents are mutable, we can remove as well as
     * add elements.The collection can not contain null elements.
     * </p>
     */
    private Collection<StateVertex> subVertexes;

    /**
     * <p>
     * Default constructor.
     * </p>
     */
    public CompositeStateImpl() {
        subVertexes = new ArrayList<StateVertex>();
    }

    /**
     * <p>
     * General constructor which allows for complete initialization of a CompositeStateImpl instance.
     * </p>
     *
     * @param container
     *            the composite state that contains this state
     * @param outgoingTransitions
     *            a collection of outgoing transitions
     * @param incomingTransitions
     *            a collection of incoming transitions
     * @param stateMachine
     *            state machine which contains this state
     * @param isConcurrent
     *            concurrent flag
     * @param subVertexes
     *            a collection of all vertexes for this state.
     * @throws IllegalArgumentException
     *             if the passed collections is null or contain null element
     */
    public CompositeStateImpl(CompositeState container, Collection<Transition> outgoingTransitions,
            Collection<Transition> incomingTransitions, StateMachine stateMachine, boolean isConcurrent,
            Collection<StateVertex> subVertexes) {
        super(container, outgoingTransitions, incomingTransitions, stateMachine);
        Helper.chekCollection(subVertexes,"subVertexes");
        this.isConcurrent = isConcurrent;
        this.subVertexes = new ArrayList<StateVertex>(subVertexes);
    }

    /**
     * <p>
     * Tests to see if concurrency indicator for this state is set.
     * </p>
     * <p>
     * <b>NOTE</b>:
     * <p>
     * If this attribute is true, then the composite state is decomposed directly into two or more orthogonal
     * conjunctive components (usually associated with concurrent execution).
     * </p>
     * <p>
     * If this attribute is false, then there are no direct orthogonal components in the
     * </p>
     *
     * @return true if this state is concurrent;false otherwise
     */
    public boolean isConcurrent() {
        return isConcurrent;
    }

    /**
     * <p>
     * Sets the concurrency indicator for this state to either true or false. composite.
     * </p>
     * <p>
     * <b>NOTE</b>:
     * <p>
     * If this attribute is true, then the composite state is decomposed directly into two or more orthogonal
     * conjunctive components (usually associated with concurrent execution).
     * </p>
     * <p>
     * If this attribute is false, then there are no direct orthogonal components in the
     * </p>
     *
     * @param concurrent
     *            concurrent flag
     */
    public void setConcurrent(boolean concurrent) {
        this.isConcurrent = concurrent;
    }

    /**
     * <p>
     * Add a sub-vertex to this composite state.
     * </p>
     * <p>
     * <b>NOTE</b>: Duplicate elements is allowed.
     * </p>
     *
     * @param subVertex
     *            sub vertex (region) to be added.
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     */
    public void addSubVertex(StateVertex subVertex) {
        Helper.checkNotNull(subVertex, "subVertex");
        subVertexes.add(subVertex);
    }

    /**
     * <p>
     * Remove a sub-vertex from this composite state. If the sub-vertex doesn't exist (or for some reason we cannot
     * remove the element) return false, return true if successful.
     * </p>
     *
     * @param subVertex
     *            sub vertex (region) to be removed from this composite state
     * @return true if we successfully removed the element;false otherwise
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     */
    public boolean removeSubVertex(StateVertex subVertex) {
        Helper.checkNotNull(subVertex, "subVertex");
        return subVertexes.remove(subVertex);
    }

    /**
     * <p>
     * Remove all contained sub-vertexes from this composite state.
     * </p>
     */
    public void clearSubVertexes() {
        subVertexes.clear();
    }

    /**
     * <p>
     * Return an unordered collection containing all of the sub-vertexes in this composite state.
     * </p>
     * <p>
     * <b>NOTE</b>:A shallow copy of the vertexes will be returned.
     * </p>
     *
     * @return a collection of all vertexes for this state.
     */
    public Collection<StateVertex> getSubVertexes() {
        return new ArrayList<StateVertex>(subVertexes);
    }

    /**
     * <p>
     * Returns true if the input sub-vertex instance is contained in the collection of sub-vertexes for this composite
     * state and false if it is not.
     * </p>
     *
     * @param subVertex
     *            sub vertex (region) to be tested
     * @return true if the sub vertex is contained in this composite state
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     */
    public boolean containsSubVertex(StateVertex subVertex) {
        Helper.checkNotNull(subVertex, "subVertex");
        return subVertexes.contains(subVertex);
    }

    /**
     * <p>
     * Return the current number of sub-vertexes in the composite state.
     * </p>
     *
     * @return the number of sub vertexes that are currently part of this composite state
     */
    public int countSubVertexes() {
        return subVertexes.size();
    }

}
