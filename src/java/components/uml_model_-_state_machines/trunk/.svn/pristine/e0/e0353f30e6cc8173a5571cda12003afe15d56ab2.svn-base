/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;


/**
 * <p>A transition is a progression (or a moving from) from one state to another and is triggered by an event that
 * is either internal or external to the entity being modeled. For a class, transitions are typically the result of
 * the invocation of an operation that causes an important change in state, although it is important to understand
 * that not all method invocations will result in transitions.</p>
 *  <p>An action is something, in the case of a class it is an operation, that is invoked by/on the entity being
 * modeled. A transition is a directed relationship between a source vertex and a target vertex. It may be part of a
 * compound transition, which takes the state machine from one state configuration to another, representing the
 * complete response of the state machine to an occurrence of an event of a particular type.(OMG Unified Modeling
 * Language Specification - UML 2.0 Superstructure Specification, p. 624)</p>
 *  <p><b>Thread Safety</b>: Implementation is mutable, and since there is no requirement to make implementations
 * thread-safety this is NOT thread-safe.</p>
 *
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public class TransitionImpl extends ModelElementAbstractImpl implements Transition {
    /**
     * <p>Represents the StateMachine to which this transition belongs. We can almost think of this state
     * machine as a general container for the transition.</p>
     *  <p>It is initialized through the 2nd constructor or through a dedicated setter.It can be null and is
     * mutable through a setter.</p>
     */
    private StateMachine stateMachine;

    /**
     * <p>Represnts the source state for this transition. Another way of looking at this is that this is the
     * origin or starting point of the transition itself.</p>
     *  <p>It is initialized through the 2nd constructor or through a dedicated setter.It can be null and is
     * mutable through a setter.</p>
     */
    private StateVertex source;

    /**
     * <p>Represnts the target state for this transition. Another way of looking at this is that this is the
     * destination or end point of the transition itself.</p>
     *  <p>It is initialized through the 2nd constructor or through a dedicated setter.It can be null and is
     * mutable.</p>
     */
    private StateVertex target;

    /**
     * <p>Represents the guard for this transition. A guard is basically a boolean expression that represents a
     * threshold of accepted transition transfer. A guard can prevent a transition from one state to another when the
     * guard condition is NOT met.</p>
     *  <p>It is initialized through the 2nd constructor or through a dedicated setter.It can be null and is
     * mutable through a setter.</p>
     */
    private Guard guard;

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    public TransitionImpl() {
        // do nothing
    }

/**
     * <p>
     * General constructor which allows for complete initialization of a Transition instance.
     * </p>
     *
     * @param stateMachine
     *            State Machine owner
     * @param source
     *            source state for this transition
     * @param target
     *            target state for this transition
     * @param guard
     *            guard for this transition
     */
    public TransitionImpl(StateMachine stateMachine, StateVertex source, StateVertex target, Guard guard) {
        setStateMachine(stateMachine);
        setSource(source);
        setTarget(target);
        setGuard(guard);
    }

    /**
     * <p>Returns the StateMachine to which this transition belongs.</p>
     *
     * @return The currently assigned State Machine owner
     */
    public StateMachine getStateMachine() {
        return stateMachine;
    }

    /**
     * <p>Sets the StateMachine to which this transition belongs.</p>
     *
     * @param stateMachine State Machine owner
     */
    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    /**
     * <p>Returns the source state for this transition.</p>
     *  <p>Another way of looking at this is that this is the origin or starting point of the transition
     * itself.</p>
     *
     * @return source state for this transition
     */
    public StateVertex getSource() {
        return source;
    }

    /**
     * <p>Sets the source state for this transition.</p>
     *  <p>Another way of looking at this is that this is the origin or starting point of the transition
     * itself.</p>
     *
     * @param source source state for this transition
     */
    public void setSource(StateVertex source) {
        this.source = source;
    }

    /**
     * <p>Returns the target state for this transition.</p>
     *  <p>Another way of looking at this is that this is the destination or end point of the transition
     * itself.</p>
     *
     * @return target state for this transition
     */
    public StateVertex getTarget() {
        return target;
    }

    /**
     * <p>Sets the target state for this transition.</p>
     *  <p>Another way of looking at this is that this is the destination or end point of the transition
     * itself.</p>
     *
     * @param target target state of the transition
     */
    public void setTarget(StateVertex target) {
        this.target = target;
    }

    /**
     * <p>Sets the guard for this transition.</p>
     *
     * @param guard the guard for this transition
     */
    public void setGuard(Guard guard) {
        this.guard = guard;
    }

    /**
     * <p>Returns the guard for this transition.</p>
     *
     * @return the current guard for this transition
     */
    public Guard getGuard() {
        return guard;
    }
}
