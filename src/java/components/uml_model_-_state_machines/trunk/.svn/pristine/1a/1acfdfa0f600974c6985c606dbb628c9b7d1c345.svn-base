/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.Collection;

/**
 * <p>
 * This is an abstract implementation of the <code>State</code> interface. A state is a stage (or step) in the
 * behavior life-cycle of an entity. Another way of stating it is that a state is a condition during the life of an
 * object or an interaction during which it satisfies some condition, performs some action, or waits for some event. A
 * state is associated with a state-machine to which it belongs.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This implementation is mutable, there is no requirement to make implementations of State
 * interface thread-safe.
 * </p>
 *
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public abstract class AbstractStateImpl extends StateVertexAbstractImpl implements State {
    /**
     * <p>
     * Represents the StateMachine to which this state belongs.
     * </p>
     * <p>
     * It is initialized through the 2nd constructor or through a dedicated setter.It can be null and is mutable through
     * a setter.
     * </p>
     */
    private StateMachine stateMachine;

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    protected AbstractStateImpl() {
        
        // do nothing
    }

    /**
     * <p>
     * General constructor which allows for complete initialization of a State instance.
     * </p>
     * s
     *
     * @param container
     *            the composite state that contains this state
     * @param outgoingTransitions
     *            a collection of outgoing transitions
     * @param incomingTransitions
     *            a collection of incoming transitions
     * @param stateMachine
     *            state machine which contains this state
     * @throws IllegalArgumentException
     *             if the passed collections is null or contain null element
     */
    protected AbstractStateImpl(CompositeState container, Collection<Transition> outgoingTransitions,
            Collection<Transition> incomingTransitions, StateMachine stateMachine) {
        super(container, outgoingTransitions, incomingTransitions);
        setStateMachine(stateMachine);
    }

    /**
     * <p>
     * Sets the StateMachine to which this state belongs.
     * </p>
     *
     * @param stateMachine
     *            state machine to which this state will belong
     */
    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    /**
     * <p>
     * Returns the StateMachine to which this state belongs.
     * </p>
     *
     * @return state machine to which this state belongs
     */
    public StateMachine getStateMachine() {
        return stateMachine;
    }
}
