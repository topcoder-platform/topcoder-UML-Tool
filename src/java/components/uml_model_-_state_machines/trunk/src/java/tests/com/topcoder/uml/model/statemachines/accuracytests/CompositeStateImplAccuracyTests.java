/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.accuracytests;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * The accuracy test of the class <code>CompositeStateImpl</code>.
 *
 * @author hfx
 * @version 1.0
 */
public class CompositeStateImplAccuracyTests extends TestCase {
    /**
     * The instance for accuracy test.
     */
    private CompositeStateImpl compositeStateImpl = null;
    /**
     * The setup of the test, create the instance for testing.
     */
    protected void setUp() {
        compositeStateImpl = new CompositeStateImpl();
    }
    /**
     * The accuracy test of the default constructor.
     *
     */
    public void test_default_ctor() {
        assertNotNull("can not create the compositeStateImpl with default ctor.", compositeStateImpl);
    }
    /**
     * The accuracy test of the ctor with parameters.
     *
     */
    public void test_parameter_ctor() {
        CompositeState compositeState = new CompositeStateImpl();
        StateMachine stateMachine = new StateMachineImpl();
        Collection<StateVertex> collection1 = new ArrayList<StateVertex>();
        StateVertex stateVertex = new SimpleStateImpl();
        assertNotNull("can not create the compositeStateImpl.",
                new CompositeStateImpl(compositeState, new ArrayList<Transition>(),
                new ArrayList<Transition>(), stateMachine, true, collection1));
    }
    /**
     * The accuracy test of the method setConcurrent and isConcurrent.
     *
     */
    public void test_isConcurrentAndsetConcurrent() {
        compositeStateImpl.setConcurrent(true);
        assertTrue("The concurrect is not set correctly.", compositeStateImpl.isConcurrent());
    }
    /**
     * The accuracy test of the method getSubVertexes.
     *
     */
    public void test_getSubVertexes() {
        StateVertex stateVertex = new SimpleStateImpl();
        compositeStateImpl.addSubVertex(stateVertex);
        
        Collection<StateVertex> collection = compositeStateImpl.getSubVertexes();
        assertEquals("the subvertex is not added successfully.", 1, collection.size());
    }
    /**
     * The accuracy test of the method countSubVertexes.
     *
     */
    public void test_countSubVertexes() {
        StateVertex stateVertex = new SimpleStateImpl();
        compositeStateImpl.addSubVertex(stateVertex);

        assertEquals("the subvertex is not added successfully.", 1, compositeStateImpl.countSubVertexes());
    }
    /**
     * The accuracy test of the method clearSubVertexes.
     *
     */
    public void test_clearSubVertexes() {
        StateVertex stateVertex = new SimpleStateImpl();
        compositeStateImpl.addSubVertex(stateVertex);
        compositeStateImpl.clearSubVertexes();

        assertEquals("the subvertex is not cleared successfully.", 0, compositeStateImpl.countSubVertexes());
    }
    /**
     * The accuracy test of the method removeSubVertexes.
     *
     */
    public void test_removeSubVertexes() {
        StateVertex stateVertex = new SimpleStateImpl();
        compositeStateImpl.addSubVertex(stateVertex);
        compositeStateImpl.removeSubVertex(stateVertex);

        assertEquals("the subvertex is not removed successfully.", 0, compositeStateImpl.countSubVertexes());
    }
    /**
     * The accuracy test of the method addSubVertex.
     *
     */
    public void test_aetSubVertexes() {
        StateVertex stateVertex = new SimpleStateImpl();
        compositeStateImpl.addSubVertex(stateVertex);
        
        Collection<StateVertex> collection = compositeStateImpl.getSubVertexes();
        assertEquals("the subvertex is not added successfully.", 1, collection.size());
    }
}
