/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.Collection;

/**
 * <p>
 * The simple state is a state that does not have substates, i.e. it has no regions and it has no submachine state
 * machine.(OMG Unified Modeling Lanauge Specification - UML 2.0 Superstructure Specification, p. 600) We could state
 * that a simple state is the opposite of a Composite state.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This (empty) implementation is not thread-safe as it is extended from non-thread-safe base
 * class.
 * </p>
 *
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public class SimpleStateImpl extends AbstractStateImpl implements SimpleState {
    /**
     * <p>
     * Default constructor.
     * </p>
     */
    public SimpleStateImpl() {
        // do nothing
    }

    /**
     * <p>
     * General constructor which allows for complete initialization of a <code>SimpleStateImpl</code> instance.
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
     * @throws IllegalArgumentException
     *             if the passed collections is null or contain null element
     */
    public SimpleStateImpl(CompositeState container, Collection<Transition> outgoingTransitions,
            Collection<Transition> incomingTransitions, StateMachine stateMachine) {
        super(container, outgoingTransitions, incomingTransitions, stateMachine);
    }
}
