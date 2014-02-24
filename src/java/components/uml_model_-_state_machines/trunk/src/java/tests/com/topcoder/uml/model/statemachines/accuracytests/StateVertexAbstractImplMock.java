/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.accuracytests;

import java.util.Collection;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.StateVertexAbstractImpl;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * Mock class used for test.
 * </p>
 *
 * @author hfx
 * @version 1.0
 */
public class StateVertexAbstractImplMock extends StateVertexAbstractImpl {
    /**
     * The empty constructor of the mock.
     */
    public StateVertexAbstractImplMock() {
    }

    /**
     * The constructor of the mock with parameters.
     * 
     * @param container the container.
     * @param outgoingTransitions the outgoingTransitions.
     * @param incomingTransitions the incomingTransitions.
     */
    public StateVertexAbstractImplMock(CompositeState container, Collection<Transition> outgoingTransitions,
        Collection<Transition> incomingTransitions) {
        super(container, outgoingTransitions, incomingTransitions);
    }
}
