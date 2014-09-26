/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

/**
 * <p>
 * Imlementation of the stateMachine interface. A State Machine models the behaviour of a single object, specifying the
 * sequence of events that an object goes through during its lifetime in response to events. It is a specification that
 * describes all possible behaviors of some dynamic model element (i.e. object). Behavior is modeled as a traversal of a
 * graph of state nodes interconnected by one or more joined transitions (i.e. transition arcs) that are triggered by
 * the dispatching of series of event instances. During this traversal, the state machine executes a series of actions
 * associated with various elements of the state machine. StateMachine contains a top State, which represents the
 * top-level state, and a set of transitions. This means that a state machine owns its transitions and its top state.
 * All remaining states are transitively owned through the state containment hierarchy rooted in the top state (i.e. top
 * state is like a root in a graph) The association to ModelElement provides the context of the state machine. A common
 * case of the context relation is where a state machine is used to specify the life cycle of a classifier.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This implementation is mutable, and since there is no requirement to make implementations of
 * Statemachine interface thread-safe, this implementation is NOT thread-safe.
 * </p>
 *
 * @author AleaActaEst, catcher
 * @version 1.0
 */

public class StateMachineImpl extends ModelElementAbstractImpl implements StateMachine {

    /**
     * <p>
     * Represents the context for this StateMachine. This is basically some other UML element which contains this state
     * machine.
     * </p>
     * <p>
     * It is initialized through the 2nd constructor or through a dedicated setter.It can be null and is mutable through
     * a setter.
     * </p>
     */
    private ModelElement context;

    /**
     * <p>
     * Represents the top state for this StateMachine. A top state acts as a root for the state machine's state
     * hierarchy.
     * </p>
     * <p>
     * It is initialized through the 2nd constructor or through a dedicated setter.It can be null and is mutable through
     * a setter.
     * </p>
     * <p>
     * <b>NOTE:</b> A top state is always a composite since it has to be able to point to other states.
     * </p>
     */
    private State top;

    /**
     * <p>
     * Represents an on-ordered collection of all transitions that this StateMachine contains.
     * </p>
     * <p>
     * It is initialized to a new ArrayList() in default constructor and can also be initialized through the 2nd
     * constructor. If an actual collection is passed in we make a shallow copy of its contents.
     * </p>
     * <p>
     * It can not be null and can not contain null elements.It is not mutable after initialization, but the contents
     * are. We can remove as well as add elements.
     * </p>
     */
    private final Collection<Transition> transitions;

    /**
     * <p>
     * Default constructor.
     * </p>
     */
    public StateMachineImpl() {
        this.transitions = new ArrayList<Transition>();
    }

    /**
     * <p>
     * General constructor which allows for complete initialization of a StateMachine instance.
     * </p>
     *
     * @param context
     *            context for this StateMachine
     * @param top
     *            top state for this StateMachine
     * @param transitions
     *            transitions for this StateMachine.
     * @throws IllegalArgumentException
     *             if the passed collections is null or contain null element
     */
    public StateMachineImpl(ModelElement context, State top, Collection<Transition> transitions) {
        Helper.chekCollection(transitions,"transitions");
        setContext(context);
        setTop(top);
        this.transitions = new ArrayList<Transition>(transitions);
    }


    /**
     * <p>
     * Returns the context for this StateMachine. This is basically some other UML element which contains this state
     * machine.
     * </p>
     *
     * @return the context of this state machine
     */
    public ModelElement getContext() {
        return context;
    }

    /**
     * <p>
     * Sets the context for this StateMachine. This is basically some other UML element which contains this state
     * machine.
     * </p>
     *
     * @param context
     *            the context to be set for this state machine
     */
    public void setContext(ModelElement context) {
        this.context = context;
    }

    /**
     * <p>
     * Sets the top state for this StateMachine. A top state acts as a root for the state machine's state hierarchy.
     * </p>
     * <p>
     * <b>NOTE:</b>A top state should be always a composite.But it will not be checked here and will leave validation
     * to a dedicated validator.
     * </p>
     *
     * @param top
     *            the top (or root) state for this machine
     */
    public void setTop(State top) {
        this.top = top;
    }

    /**
     * <p>
     * Returns the top state for this StateMachine. A top state acts as a root for the state machine's state hierarchy.
     * </p>
     *
     * @return the top (or root) state for this State machine
     */
    public State getTop() {
        return top;
    }

    /**
     * <p>
     * Add a transition to this state machine.
     * </p>
     *
     * @param transition
     *            a state machine transition between two state
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     */
    public void addTransition(Transition transition) {
        Helper.checkNotNull(transition, "transition");
        transitions.add(transition);
    }

    /**
     * <p>
     * Remove the first matched transition from this state machine.
     * </p>
     *
     * @param transition
     *            a state machine transition to be removed
     * @return true if successfully removed; false otherwise
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     */
    public boolean removeTransition(Transition transition) {
        Helper.checkNotNull(transition, "transition");
        return transitions.remove(transition);
    }

    /**
     * <p>
     * Remove all transitions from this state machine.
     * </p>
     */
    public void clearTransitions() {
        this.transitions.clear();
    }

    /**
     * <p>
     * Return an unordered collection containing all of the transitions in this state machine.
     * </p>
     *
     * @return a collection of currently contained transitions
     */
    public Collection<Transition> getTransitions() {
        return new ArrayList<Transition>(transitions);
    }

    /**
     * <p>
     * Returns true if the input transaction instance is contained in the collection of transactions for this state
     * machine and false if it is not.
     * </p>
     *
     * @param transition
     *            transition to be tested for containment in this state machine
     * @return true if transition is contained; false if it is not
     * @throws IllegalArgumentException
     *             if the passed in parameter is null
     */
    public boolean containsTransition(Transition transition) {
        Helper.checkNotNull(transition, "transition");
        return transitions.contains(transition);
    }

    /**
     * <p>
     * Return the current number of transitions in the state machine.
     * </p>
     *
     * @return count of transitions contained in this state machine
     */
    public int countTransitions() {
        return transitions.size();
    }
}
