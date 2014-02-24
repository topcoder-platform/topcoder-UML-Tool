/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.Collection;

/**
 * This is only a simple mock class extends from <c>StateVertexAbstractImpl</c>.
 *
 * @author catcher
 * @version 1.0
 */
public class StateVertexImpl extends StateVertexAbstractImpl {
    /**
     * <p>
     * Default constructor.
     * </p>
     */
    public StateVertexImpl() {
        super();
    }

    /**
     * <p>
     * General constructor which allows for complete initialization of a StateVertex instance. - Make sure that BEFORE
     * we assign outgoingTransitions to this.outgoingTransitions we make a copy (shallow) of the input parameter. - Same
     * allies to incomingTransitions, we also need to make a copy.
     * </p>
     *
     * @param container
     *            the composite state that contains this vertex
     * @param outgoingTransitions
     *            a collection of outgoing transitions
     * @param incomingTransitions
     *            a collection of incoming transitions
     */
    protected StateVertexImpl(CompositeState container, Collection<Transition> outgoingTransitions,
            Collection<Transition> incomingTransitions) {
        super(container, outgoingTransitions, incomingTransitions);

    }
}

