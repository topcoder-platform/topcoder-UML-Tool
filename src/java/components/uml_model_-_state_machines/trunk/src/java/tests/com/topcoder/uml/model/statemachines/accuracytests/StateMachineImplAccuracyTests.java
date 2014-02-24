/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.uml.model.statemachines.accuracytests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.State;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

import junit.framework.TestCase;
/**
 * The accuracy test of the class <code>StateMachineImpl</code>.
 *
 * @author hfx
 * @version 1.0
 */
public class StateMachineImplAccuracyTests extends TestCase {
    /**
     * The accuracy test of the constructor.
     */
    private StateMachineImpl stateMachineImpl = null;
    /**
     * The setup, create the instance for testing.
     */
    protected void setUp() {
        stateMachineImpl = new StateMachineImpl();
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_ctor_accuracy1() {
        assertNotNull("can not create the instance.", stateMachineImpl);
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_ctor_accuracy2() {
        assertNotNull("can not create the instance.",
                new StateMachineImpl(new ModelElementMock(), new SimpleStateImpl(), new ArrayList<Transition>()));
    }
    /**
     * The accuracy test of the method getContext and setContext.
     *
     */
    public void test_getContextAndsetContext() {
        ModelElement element = new ModelElementMock();
        
        stateMachineImpl.setContext(element);
        assertEquals("The context is not set correctly.", element, stateMachineImpl.getContext());
    }
    /**
     * The accuracy test of the method getTop and setTop.
     *
     */
    public void test_getTopAndsetTop() {
        State top = new SimpleStateImpl();
        
        stateMachineImpl.setTop(top);
        assertEquals("The top is not set correctly.", top, stateMachineImpl.getTop());
    }
    /**
     * The accuracy test of the method getTransition.
     *
     */
    public void test_getTransition() {
        Transition transition = new TransitionImpl();
        stateMachineImpl.addTransition(transition);
        
        Collection<Transition> collection = stateMachineImpl.getTransitions();
        assertEquals("the Transition is not added successfully.", 1, collection.size());
    }
    /**
     * The accuracy test of the method countTransition.
     *
     */
    public void test_countTransition() {
        Transition transition = new TransitionImpl();
        stateMachineImpl.addTransition(transition);

        assertEquals("the Transition is not added successfully.", 1, stateMachineImpl.countTransitions());
    }
    /**
     * The accuracy test of the method clearTransition.
     *
     */
    public void test_clearTransition() {
        Transition transition = new TransitionImpl();
        stateMachineImpl.addTransition(transition);
        stateMachineImpl.clearTransitions();

        assertEquals("the Transition is not cleared successfully.", 0, stateMachineImpl.countTransitions());
    }
    /**
     * The accuracy test of the method removeTransition.
     *
     */
    public void test_removeTransition() {
        Transition transition = new TransitionImpl();
        stateMachineImpl.addTransition(transition);
        stateMachineImpl.removeTransition(transition);

        assertEquals("the Transition is not removed successfully.", 0, stateMachineImpl.countTransitions());
    }
    /**
     * The accuracy test of the method addTransition.
     *
     */
    public void test_aetTransition() {
        Transition transition = new TransitionImpl();
        stateMachineImpl.addTransition(transition);
        
        Collection<Transition> collection = stateMachineImpl.getTransitions();
        assertEquals("the Transition is not added successfully.", 1, collection.size());
    }
}
