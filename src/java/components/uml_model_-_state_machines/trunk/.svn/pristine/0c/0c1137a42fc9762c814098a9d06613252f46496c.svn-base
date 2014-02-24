/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.accuracytests;

import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.TransitionImpl;

import junit.framework.TestCase;
/**
 * <p>
 * The accuracy test of the TransitionImpl class.
 * </p>
 *
 * @author hfx
 * @version 1.0
 */
public class TransitionImplAcuracyTests extends TestCase {
    /**
     * The TransitionImpl instance for test.
     */
    private TransitionImpl transitionImpl = null;
    /**
     * The setUp, create the instance for test.
     */
    protected void setUp() {
        transitionImpl = new TransitionImpl();
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_ctor_accuracy1() {
        assertNotNull("can not create the TransitionImpl.", transitionImpl);
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_ctor_accuracy2() {
        assertNotNull("can not create the TransitionImpl.",
                new TransitionImpl(new StateMachineImpl(), new SimpleStateImpl(), new SimpleStateImpl(),
                        new GuardImpl()));
    }
    /**
     * The accuracy test of the method setStateMachine and getStateMachine.
     *
     */
    public void test_getStateMachineAndsetStateMachine() {
        StateMachine instance = new StateMachineImpl();
        transitionImpl.setStateMachine(instance);
        assertEquals("The state machine is not set correctly.", instance, transitionImpl.getStateMachine());
    }
    /**
     * The accuracy test of the method getSource and setSource.
     *
     */
    public void test_getSourceAndsetSource() {
        StateVertex instance = new SimpleStateImpl();
        transitionImpl.setSource(instance);
        assertEquals("The state machine is not set correctly.", instance, transitionImpl.getSource());
    }
    /**
     * The accuracy test of the method getTarget and setTarget.
     *
     */
    public void test_getTargetAndsetTarget() {
        StateVertex instance = new SimpleStateImpl();
        transitionImpl.setTarget(instance);
        assertEquals("The state machine is not set correctly.", instance, transitionImpl.getTarget());
    }
    /**
     * The accuracy test of the method setGuard and getGuard.
     *
     */
    public void test_getGuardAndsetGuard() {
        Guard instance = new GuardImpl();
        transitionImpl.setGuard(instance);
        assertEquals("The Guard is not set correctly.", instance, transitionImpl.getGuard());
    }
}
