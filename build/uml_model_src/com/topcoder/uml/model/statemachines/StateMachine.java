/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import com.topcoder.uml.model.core.ModelElement;

import java.util.Collection;


/**
 * <p>
 * A State Machine models the behaviour of a single object, specifying the sequence of events that an object goes
 * through during its lifetime in response to events. It is a specification that describes all possible behaviors of
 * some dynamic model element (i.e. object). Behavior is modeled as a traversal of a graph of state nodes interconnected
 * by one or more joined transitions (i.e. transition arcs) that are triggered by the dispatching of series of event
 * instances. During this traversal, the state machine executes a series of actions associated with various elements of
 * the state machine. StateMachine contains a top State, which represents the top-level state, and a set of transitions.
 * This means that a state machine owns its transitions and its top state. All remaining states are transitively owned
 * through the state containment hierarchy rooted in the top state (i.e. top state is like a root in a graph) The
 * association to ModelElement provides the context of the state machine. A common case of the context relation is where
 * a state machine is used to specify the life cycle of a classifier.
 * </p>
 * <p>
 * <b>Thread Safety</b>: Implementations are mutable, there is no requirement to make implementations of this interface
 * thread-safe.
 * </p>
 *
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public interface StateMachine extends ModelElement {
    /**
     * <p>Returns the context for this StateMachine. This is basically some other UML element which contains
     * this state machine.</p>
     *
     * @return the context of this state machine
     */
    public ModelElement getContext();

    /**
     * <p>Sets the context for this StateMachine. This is basically some other UML element which contains this
     * state machine.</p>
     *
     * @param context the context to be set for this state machine
     */
    public void setContext(ModelElement context);

    /**
     * <p>Sets the top state for this StateMachine. A top state acts as a root for the state machine's state
     * hierarchy. The top state is always a composite state.</p>
     *
     * @param top the top (or root) state for this state machine
     */
    public void setTop(State top);

    /**
     * <p>Returns the top state for this StateMachine. A top state acts as a root for the state machine's state
     * hierarchy.</p>
     *
     * @return the top (or root) state for this state machine
     */
    public State getTop();

    /**
     * <p>Add a transition to this state machine.</p>
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     * @param transition a state machine transition between two state
     */
    public void addTransition(Transition transition);

    /**
     * <p>Remove the first matched transition from this state machine.</p>
     *
     * @param transition a state machine transition to be removed
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     * @return true if successfully removed; false otherwise
     */
    public boolean removeTransition(Transition transition);

    /**
     * <p>Remove all transitions from this state machine.</p>
     */
    public void clearTransitions();

    /**
     * <p>Return an unordered collection containing all of the transitions in this state machine.</p>
     *
     * @return a collection of currently contained transitions
     */
    public Collection<Transition> getTransitions();

    /**
     * <p>Returns true if the input transaction instance is contained in the collection of transactions for
     * this state machine and false if it is not.</p>
     *
     * @param transition transition to be tested for containment in this state machine
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     * @return true if transition is contained; false if it is not
     */
    public boolean containsTransition(Transition transition);

    /**
     * <p>Returns the current number of transitions in the state machine.</p>
     *
     * @return count of transitions contained in this state machine
     */
    public int countTransitions();
}
