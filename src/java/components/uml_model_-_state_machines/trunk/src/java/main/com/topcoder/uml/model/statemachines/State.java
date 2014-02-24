/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

/**
 * <p>
 * A state is a stage (or step) in the behavior life-cycle of an entity. Another way of stating it is that a state is a
 * condition during the life of an object or an interaction during which it satisfies some condition, performs some
 * action, or waits for some event. A state is associated with a state-machine to which it belongs.
 * </p>
 * <p>
 * <b>Thread Safety</b>: Implementations are mutable, there is no requirement to make implementations of this interface
 * thread-safe.
 * </p>
 *
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public interface State extends StateVertex {
    /**
     * <p>
     * Returns the state machine to which this state belongs.
     * </p>
     *
     * @return state machine to which this state belongs
     */
    public StateMachine getStateMachine();

    /**
     * <p>
     * Sets the state machine to which this state belongs.
     * </p>
     *
     * @param stateMachine
     *            state machine to which this state belongs
     */
    public void setStateMachine(StateMachine stateMachine);
}
