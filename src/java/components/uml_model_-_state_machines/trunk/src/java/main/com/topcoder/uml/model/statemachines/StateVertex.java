/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import com.topcoder.uml.model.core.ModelElement;

import java.util.Collection;

/**
 * <p>
 * A StateVertex is an abstraction of a node in a state chart (state machine) graph. In general, it can be the source or
 * destination of any number of transitions. All types of states in a state machine are children of StateVertex.
 * Currently we have the following types of vertexes:
 * <ul>
 * <li> Pseudostate </li>
 * <li> State </li>
 * <li> FinalState </li>
 * <li> SimpleState </li>
 * <li> CompositeState</li>
 * </ul>
 * (recursive since a StateVertex aggregates a CompositeState as well)
 * </p>
 * <p>
 * <b>Thread Safety</b>: Implementations are mutable, there is no requirement to make implementations of this interface
 * thread-safe.
 * </p>
 * 
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public interface StateVertex extends ModelElement {
    /**
     * <p>
     * Sets the composite state (the container) that contains this vertex.
     * </p>
     * <p>
     * Note that a vertex doesn't have to be contained.
     * </p>
     * 
     * @param container
     *            the composite state that contains this vertex
     */
    public void setContainer(CompositeState container);

    /**
     * <p>
     * Returns the composite state (the container) that contains this vertex.
     * </p>
     * 
     * @return the composite state that contains this vertex; null if this vertex is not contained
     */
    public CompositeState getContainer();

    /**
     * <p>
     * Add an outgoing transition to this vertex.
     * </p>
     * 
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     * @param outgoingTransition
     *            an outgoing transition(pointing out of this vertex) to be added to this vertex.
     */
    public void addOutgoingTransition(Transition outgoingTransition);

    /**
     * <p>
     * Remove the input outgoing transition from this vertex.
     * </p>
     * 
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     * @param outgoingTransition
     *            an outgoing transition (pointing out of this vertex) to be removed from this vertex.
     * @return true if removal was successful; false otherwise
     */
    public boolean removeOutgoingTransition(Transition outgoingTransition);

    /**
     * <p>
     * Remove all outgoing transitions from this vertex. After this the count should be 0.
     * </p>
     */
    public void clearOutgoingTransitions();

    /**
     * <p>
     * Return an unordered collection containing all of the outgoing transitions in this vertex.
     * </p>
     * 
     * @return a collection of currently contained outgoing transitions
     */
    public Collection<Transition> getOutgoingTransitions();

    /**
     * <p>
     * Returns true if the input outgoing transition instance is contained in the collection of outgoing transactions
     * for this vertex, and false if it is not contained.
     * </p>
     * 
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     * @param outgoingTransition
     *            transition to be tested for containment in this vertex
     * @return true if transition is contained; false if it is not
     */
    public boolean containsOutgoingTransition(Transition outgoingTransition);

    /**
     * <p>
     * Return the current number of outgoing transitions in in this vertex.
     * </p>
     * 
     * @return count of outgoing transitions contained in this vertex
     */
    public int countOutgoingTransitions();

    /**
     * <p>
     * Add an incoming transition to this vertex.
     * </p>
     * 
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     * @param incomingTransition
     *            incoming transition( to be added to this vertex) but which points into of this vertex.
     */
    public void addIncomingTransition(Transition incomingTransition);

    /**
     * <p>
     * Remove the input incoming transition from this vertex.
     * </p>
     * 
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     * @param incomingTransition
     *            an incoming transition (pointing into this vertex) to be removed from this vertex.
     * @return true if successfully removed; false otherwise
     */
    public boolean removeIncomingTransition(Transition incomingTransition);

    /**
     * <p>
     * Remove all incoming transitions from this vertex.
     * </p>
     */
    public void clearIncomingTransitions();

    /**
     * <p>
     * Return an unordered collection containing all of the incoming transitions in this vertex.
     * </p>
     * 
     * @return a collection of currently contained incoming transitions
     */
    public Collection<Transition> getIncomingTransitions();

    /**
     * <p>
     * Returns true if the input incoming transaction instance is contained in the collection of incoming transactions
     * for this vertex and false if it is not.
     * </p>
     * 
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     * @param incomingTransition
     *            transition to be tested for containment in this vertex
     * @return true if transition is contained; false if it is not
     */
    public boolean containsIncomingTransition(Transition incomingTransition);

    /**
     * <p>
     * return the current number of incoming transitions in in this vertex.
     * </p>
     * 
     * @return count of incoming transitions contained in this vertex
     */
    public int countIncomingTransitions();
}
