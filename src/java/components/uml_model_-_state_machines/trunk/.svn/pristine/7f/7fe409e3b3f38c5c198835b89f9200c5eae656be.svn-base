/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.accuracytests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.statemachines.AbstractStateImpl;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;

import junit.framework.TestCase;
/**
 * The accuracy test of the class <code>AbstractStateImpl</code>.
 *
 * @author hfx
 * @version 1.0
 */
public class AbstractStateImplAccuracyTests extends TestCase {
    /**
     * The instance for unit test.
     */
    private AbstractStateImpl abstractStateImpl = null;
    /**
     * The setUp of the test, create the instance.
     */
    protected void setUp() {
        abstractStateImpl = new AbstractStateImplMock();
    }
    /**
     * Accuracy test of the default constructor.
     *
     */
    public void test_emptyconstructor() {
        assertNotNull("can not create the AbstractStateImpl.", abstractStateImpl);
    }
    /**
     * Accuracy test of the constructor with parameters.
     *
     */
    public void test_constructor_withParam() {
        Collection<Transition> collection1 = new ArrayList<Transition>();
        Collection<Transition> collection2 = new ArrayList<Transition>();

        assertNotNull("can not create the AbstractStateImpl.",
                new AbstractStateImplMock(new CompositeStateImpl(), collection1, collection2, new StateMachineImpl()));
    }
    /**
     * Accuracy test of the method setStateMachine and getStateMachine.
     *
     */
    public void test_setStateMachineAndgetStateMachine() {
        StateMachine state = new StateMachineImpl();
        abstractStateImpl.setStateMachine(state);
        assertTrue("The state machine is not set or get correctly.", state == abstractStateImpl.getStateMachine());
    }
}
