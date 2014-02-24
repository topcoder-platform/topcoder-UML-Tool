/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.accuracytests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.StateVertexAbstractImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

import junit.framework.TestCase;
/**
 * <p>
 * The accuracy test for <code>StateVertexAbstractImpl</code> abstract class.
 * </p>
 *
 * @author hfx
 * @version 1.0
 */
public class StateVertexAbstractImplAccuracyTests extends TestCase {
    /**
     * The instance for accuracy test.
     */
    private StateVertexAbstractImpl stateVertexAbstractImpl = null;
    /**
     * The setUp, create the instance for testing.
     */
    protected void setUp() {
        stateVertexAbstractImpl = new StateVertexAbstractImplMock();
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_ctor_accuracy1() {
        assertNotNull("can not create stateVertexAbstractImpl instance.", stateVertexAbstractImpl);
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_ctor_accuracy2() {
        assertNotNull("can not create stateVertexAbstractImpl instance.",
                new StateVertexAbstractImplMock(new CompositeStateImpl(),
                        new ArrayList<Transition>(), new ArrayList<Transition>()));
    }
    /**
     * The accuracy test of setContainer and getContainer.
     *
     */
    public void test_setContainerAndgetContainer() {
        CompositeState state = new CompositeStateImpl();
        stateVertexAbstractImpl.setContainer(state);
        assertEquals("The state is not set correctly.", state, stateVertexAbstractImpl.getContainer());
    }
    /**
     * The accuracy test of the method getOutgoingTransition.
     *
     */
    public void test_getOutgoingTransition() {
        Transition transition = new TransitionImpl();
        stateVertexAbstractImpl.addOutgoingTransition(transition);
        
        Collection<Transition> collection = stateVertexAbstractImpl.getOutgoingTransitions();
        assertEquals("the Transition is not added successfully.", 1, collection.size());
    }
    /**
     * The accuracy test of the method countOutgoingTransitions.
     *
     */
    public void test_countOutgoingTransitions() {
        Transition transition = new TransitionImpl();
        stateVertexAbstractImpl.addOutgoingTransition(transition);

        assertEquals("the Transition is not added successfully.",
                1, stateVertexAbstractImpl.countOutgoingTransitions());
    }
    /**
     * The accuracy test of the method clearOutgoingTransition.
     *
     */
    public void test_clearOutgoingTransition() {
        Transition transition = new TransitionImpl();
        stateVertexAbstractImpl.addOutgoingTransition(transition);
        stateVertexAbstractImpl.clearOutgoingTransitions();

        assertEquals("the Transition is not cleared successfully.",
                0, stateVertexAbstractImpl.countOutgoingTransitions());
    }
    /**
     * The accuracy test of the method removeOutgoingTransition.
     *
     */
    public void test_removeOutgoingTransition() {
        Transition transition = new TransitionImpl();
        stateVertexAbstractImpl.addOutgoingTransition(transition);
        stateVertexAbstractImpl.removeOutgoingTransition(transition);

        assertEquals("the Transition is not removed successfully.",
                0, stateVertexAbstractImpl.countOutgoingTransitions());
    }
    /**
     * The accuracy test of the method addOutgoingTransitions.
     *
     */
    public void test_aetOutgoingTransitions() {
        Transition transition = new TransitionImpl();
        stateVertexAbstractImpl.addOutgoingTransition(transition);
        
        Collection<Transition> collection = stateVertexAbstractImpl.getOutgoingTransitions();
        assertEquals("the Transition is not added successfully.", 1, collection.size());
    }
    /**
     * The accuracy test of the method countIncomingTransitions.
     *
     */
    public void test_countIncomingTransitions() {
        Transition transition = new TransitionImpl();
        stateVertexAbstractImpl.addIncomingTransition(transition);

        assertEquals("the Transition is not added successfully.",
                1, stateVertexAbstractImpl.countIncomingTransitions());
    }
    /**
     * The accuracy test of the method clearIncomingTransition.
     *
     */
    public void test_clearIncomingTransition() {
        Transition transition = new TransitionImpl();
        stateVertexAbstractImpl.addIncomingTransition(transition);
        stateVertexAbstractImpl.clearIncomingTransitions();

        assertEquals("the Transition is not cleared successfully.",
                0, stateVertexAbstractImpl.countOutgoingTransitions());
    }
    /**
     * The accuracy test of the method removeIncomingTransition.
     *
     */
    public void test_removeIncomingTransition() {
        Transition transition = new TransitionImpl();
        stateVertexAbstractImpl.addIncomingTransition(transition);
        stateVertexAbstractImpl.removeIncomingTransition(transition);

        assertEquals("the Transition is not removed successfully.",
                0, stateVertexAbstractImpl.countIncomingTransitions());
    }
    /**
     * The accuracy test of the method addIncomingTransitions.
     *
     */
    public void test_aetIncomingTransitions() {
        Transition transition = new TransitionImpl();
        stateVertexAbstractImpl.addIncomingTransition(transition);
        
        Collection<Transition> collection = stateVertexAbstractImpl.getIncomingTransitions();
        assertEquals("the Transition is not added successfully.", 1, collection.size());
    }
}
