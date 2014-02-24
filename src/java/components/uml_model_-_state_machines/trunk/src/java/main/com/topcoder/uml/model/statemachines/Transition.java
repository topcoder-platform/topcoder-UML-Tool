/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import com.topcoder.uml.model.core.ModelElement;


/**
 * <p>
 * A transition is a progression (or a moving from) from one state to another and is triggered by an event that is
 * either internal or external to the entity being modeled. For a class, transitions are typically the result of the
 * invocation of an operation that causes an important change in state, although it is important to understand that not
 * all method invocations will result in transitions. An action is something, in the case of a class it is an operation,
 * that is invoked by/on the entity being modeled.
 * </p>
 * <p>
 * A transition is a directed relationship between a source vertex and a target vertex. It may be part of a compound
 * transition, which takes the state machine from one state configuration to another, representing the complete response
 * of the state machine to an occurrence of an event of a particular type.(OMG Unified Modeling Language Specification -
 * UML 2.0 Superstructure Specification, p. 624)
 * </p>
 * <p>
 * <b>Thread Safety</b>: Implementations are mutable, there is no requirement to make implementations of this interface
 * thread-safe.
 * </p>
 *
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public interface Transition extends ModelElement {
    /**
     * <p>Returns the StateMachine to which this transition belongs.</p>
     *
     * @return State Machine owner
     */
    public StateMachine getStateMachine();

    /**
     * <p>Sets the StateMachine to which this transition belongs.</p>
     *
     * @param stateMachine the owner state machine
     */
    public void setStateMachine(StateMachine stateMachine);

    /**
     * <p>Returns the source state for this transition.</p>
     *  <p>Another way of looking at this is that this is the origin or starting point of the transition
     * itself.</p>
     *
     * @return source state for this transition
     */
    public StateVertex getSource();

    /**
     * <p>Sets the source state for this transition.</p>
     *  <p>Another way of looking at this is that this is the origin or starting point of the transition
     * itself.</p>
     *
     * @param source source state for this transition
     */
    public void setSource(StateVertex source);

    /**
     * <p>Returns the target state for this transition.</p>
     *  <p>Another way of looking at this is that this is the destination or end point of the transition
     * itself.</p>
     *
     * @return target state for this transition
     */
    public StateVertex getTarget();

    /**
     * <p>Sets the target state for this transition.</p>
     *  <p>Another way of looking at this is that this is the destination or end point of the transition
     * itself.</p>
     *
     * @param target target state of the transition
     */
    public void setTarget(StateVertex target);

    /**
     * <p>Sets the guard for this transition.</p>
     *
     * @param guard guard for this transition
     */
    public void setGuard(Guard guard);

    /**
     * <p>Returns the guard for this transition.</p>
     *
     * @return the current guard for this transition
     */
    public Guard getGuard();
}
