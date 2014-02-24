/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.Collection;

/**
 * <p>
 * A final state represents the completion of activity in the enclosing state and it triggers a transition on the
 * enclosing state labeled by the implicit activity completion event, if such a transition is defined. If the enclosing
 * region is directly contained in a state machine and all other regions in the state machine also are completed, then
 * it means that the entire state machine is completed. (OMG Unified Modeling Lanauge Specification - UML 2.0
 * Superstructure Specification, p. 580)
 * </p>
 * <p>
 * <b>Thread Safety</b>: This (empty) implementation is not thread-safe as it is extended from non-thread-safe base
 * class.
 * </p>
 *
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public class FinalStateImpl extends AbstractStateImpl implements FinalState {
    /**
     * <p>
     * Default constructor.
     * </p>
     */
    public FinalStateImpl() {
        // do nothing
    }

    /**
     * <p>
     * General constructor which allows for complete initialization of a FinalStateImpl instance.
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
    public FinalStateImpl(CompositeState container, Collection<Transition> outgoingTransitions,
            Collection<Transition> incomingTransitions, StateMachine stateMachine) {
        super(container, outgoingTransitions, incomingTransitions, stateMachine);
    }
}
