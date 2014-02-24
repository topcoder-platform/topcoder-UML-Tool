/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.accuracytests;

import java.util.Collection;

import com.topcoder.uml.model.statemachines.AbstractStateImpl;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.Transition;


/**
 * The simple mock which extends <code>AbstractStateImpl</code>.
 *
 * @author catcher
 * @version 1.0
 */
public class AbstractStateImplMock extends AbstractStateImpl {
    /**
     * <p>
     * The empty constructor of the mock.
     * </p>
     */
    public AbstractStateImplMock() {
    }

    /**
     * <p>
     * The constructor with the parameter of the mock.
     * </p>
     *
     * @param container the container
     * @param outgoingTransitions the outgoingTransitions
     * @param incomingTransitions the incomingTransitions
     * @param stateMachine the stateMachine
     */
    public AbstractStateImplMock(CompositeState container, Collection<Transition> outgoingTransitions,
        Collection<Transition> incomingTransitions, StateMachine stateMachine) {
        super(container, outgoingTransitions, incomingTransitions, stateMachine);
    }
}
