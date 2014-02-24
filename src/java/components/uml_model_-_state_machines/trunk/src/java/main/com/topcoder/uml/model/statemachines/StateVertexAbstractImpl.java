/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;

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
 * <b>Thread Safety</b>: This Implementation is mutable, and is not thread-safe. There is no requirement to make any
 * implementation of StateVertex thread-safe.
 * </p>
 *
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public abstract class StateVertexAbstractImpl extends ModelElementAbstractImpl implements StateVertex {

    /**
     * <p>
     * Represents the composite state (the container) that contains this vertex. Note that a vertex doesn't have to be
     * contained.
     * </p>
     * <p>
     * It is initialized through the 2nd constructor or through a dedicated setter.It can be null and is mutable through
     * a setter.
     * </p>
     */
    private CompositeState container;

    /**
     * <p>
     * Represents an on-ordered collection of all outgoing transitions that originate in this vertex (state)
     * </p>
     * <p>
     * It is initialized to a new ArrayList()in default constructor. It can also be initialized through the 2nd
     * constructor. If an actual collection is passed in it make a shallow copy of its contents.
     * </p>
     * <p>
     * It is not mutable after initialization, but the contents are. We can remove as well as add elements.
     * </p>
     * <p>
     * It can not be null and cannot contain null elements.
     * </p>
     */
    private final Collection<Transition> outgoingTransitions = new ArrayList<Transition>();

    /**
     * <p>
     * Represents an on-ordered collection of all incoming transitions that end in this vertex (state)
     * </p>
     * <p>
     * It is initialized to a new ArrayList()in default constructor. It can also be initialized through the 2nd
     * constructor. If an actual collection is passed in it make a shallow copy of its contents.
     * </p>
     * <p>
     * It is not mutable after initialization, but the contents are. We can remove as well as add elements.
     * </p>
     * <p>
     * It can not be null and cannot contain null elements.
     * </p>
     */
    private final Collection<Transition> incomingTransitions = new ArrayList<Transition>();

    /**
     * <p>
     * Default constructor.
     * </p>
     */
    protected StateVertexAbstractImpl() {
    }

    /**
     * <p>
     * General constructor which allows for complete initialization of a StateVertex instance. A shallow copy will be
     * used for the outgoingTransitions and incomingTransitions.
     * </p>
     *
     * @param container
     *            the composite state that contains this vertex
     * @param outgoingTransitions
     *            a collection of outgoing transitions
     * @param incomingTransitions
     *            a collection of incoming transitions
     * @throws IllegalArgumentException
     *             if the passed collections is null or contain null element
     */
    protected StateVertexAbstractImpl(CompositeState container, Collection<Transition> outgoingTransitions,
            Collection<Transition> incomingTransitions) {
        setContainer(container);
        Helper.chekCollection(outgoingTransitions, "outgoingTransitions");
        Helper.chekCollection(incomingTransitions, "incomingTransitions");
        outgoingTransitions = new ArrayList<Transition>(outgoingTransitions);
        incomingTransitions = new ArrayList<Transition>(incomingTransitions);

    }

    /**
     * <p>
     * Sets the composite state (the container) that contains this vertex.
     * </p>
     * <p>
     * <b>Note:</b>A vertex doesn't have to be contained.
     * </p>
     *
     * @param container
     *            the composite state that contains this vertex
     */
    public void setContainer(CompositeState container) {
        this.container = container;
    }

    /**
     * <p>
     * Returns the composite state (the container) that contains this vertex.
     * </p>
     * <p>
     * <b>Note:</b>A vertex doesn't have to be contained.
     * </p>
     *
     * @return the composite state that contains this vertex; null if this vertex is not contained
     */
    public CompositeState getContainer() {

        return container;
    }

    /**
     * <p>
     * Add an outgoing transition to this vertex. We do allow duplicate elements.
     * </p>
     *
     * @param outgoingTransition
     *            an outgoing transition(pointing out of this vertex) to be added to this vertex.
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     */
    public void addOutgoingTransition(Transition outgoingTransition) {
        Helper.checkNotNull(outgoingTransition, "outgoingTransition");
        outgoingTransitions.add(outgoingTransition);
    }

    /**
     * <p>
     * Remove the input outgoing transition from this vertex.
     * </p>
     *
     * @param outgoingTransition
     *            an outgoing transition (pointing out of this vertex) to be removed from this vertex.
     * @return true if removal was successful; false otherwise
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     */
    public boolean removeOutgoingTransition(Transition outgoingTransition) {
        Helper.checkNotNull(outgoingTransition, "outgoingTransition");
        return outgoingTransitions.remove(outgoingTransition);
    }

    /**
     * <p>
     * Remove all outgoing transitions from this vertex. After this the count should be 0.
     * </p>
     */
    public void clearOutgoingTransitions() {
        outgoingTransitions.clear();
    }

    /**
     * <p>
     * Return an unordered collection containing all of the outgoing transitions in this vertex. Make sure to return a
     * copy of the collection and NOT the reference to the inner structure.
     * </p>
     *
     * @return an unordered collection containing all of the outgoing transitions
     */
    public Collection<Transition> getOutgoingTransitions() {
        return new ArrayList<Transition>(outgoingTransitions);
    }

    /**
     * <p>
     * Returns true if the input outgoing transition instance is contained in the collection of outgoing transactions
     * for this vertex, and false if it is not contained.
     * </p>
     *
     * @param outgoingTransition
     *            a collection of currently contained outgoing transitions
     * @return true if transition is contained; false if it is not
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     */
    public boolean containsOutgoingTransition(Transition outgoingTransition) {
        Helper.checkNotNull(outgoingTransition, "outgoingTransition");
        return outgoingTransitions.contains(outgoingTransition);
    }

    /**
     * <p>
     * Return the current number of outgoing transitions in in this vertex.
     * </p>
     * <p>
     * <b>Note:</b>Transitions can be duplicated so that implementations of this method might bring a count that
     * doesn't count 'unique' members.
     * </p>
     *
     * @return true if transition is contained; false if it is not
     */
    public int countOutgoingTransitions() {
        return outgoingTransitions.size();
    }

    /**
     * <p>
     * Add an incoming transition to this vertex.
     * </p>
     * <p>
     * <b>NOTE:</b>Duplicate elements is allowed here.
     * </p>
     *
     * @param incomingTransition
     *            incoming transition( to be added to this vertex) but which points into of this vertex.
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     */
    public void addIncomingTransition(Transition incomingTransition) {
        Helper.checkNotNull(incomingTransition, "incomingTransition");
        incomingTransitions.add(incomingTransition);
    }

    /**
     * <p>
     * Remove the input incoming transition from this vertex.
     * </p>
     *
     * @param incomingTransition
     *            an incoming transition (pointing into this vertex) to be removed from this vertex.
     * @return true if successfully removed; false otherwise
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     */
    public boolean removeIncomingTransition(Transition incomingTransition) {
        Helper.checkNotNull(incomingTransition, "incomingTransition");
        return incomingTransitions.remove(incomingTransition);
    }

    /**
     * <p>
     * Remove all incoming transitions from this vertex.
     * </p>
     */
    public void clearIncomingTransitions() {
        incomingTransitions.clear();
    }

    /**
     * <p>
     * Return an unordered collection containing all of the incoming transitions in this vertex.
     * </p>
     *
     * @return a collection of currently contained incoming transitions
     */
    public Collection<Transition> getIncomingTransitions() {
        return new ArrayList<Transition>(incomingTransitions);
    }

    /**
     * <p>
     * Returns true if the input incoming transaction instance is contained in the collection of incoming transactions
     * for this vertex and false if it is not.
     * </p>
     *
     * @param incomingTransition
     *            transition to be tested for containment in this vertex
     * @return true if transition is contained; false if it is not
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     */
    public boolean containsIncomingTransition(Transition incomingTransition) {
        Helper.checkNotNull(incomingTransition, "incomingTransition");
        return incomingTransitions.contains(incomingTransition);
    }

    /**
     * <p>
     * Returns the current number of incoming transitions in in this vertex.
     * </p>
     *
     * @return count of incoming transitions contained in this vertex
     */
    public int countIncomingTransitions() {

        return incomingTransitions.size();
    }
}
