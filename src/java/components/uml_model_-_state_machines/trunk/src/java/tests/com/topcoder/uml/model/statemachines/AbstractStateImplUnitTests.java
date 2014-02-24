/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test case for <c>AbstractStateImpl</c>.
 * </p>
 *
 * @author catcher
 * @version 1.0
 */
public class AbstractStateImplUnitTests extends TestCase {

    /**
     * Represent the instance of <c>AbstractStateImpl</c> used for test.
     */
    private AbstractStateImpl abstractStateImpl;

    /**
     * Represent the instance of <c>StateMachine</c> used for test.
     */
    private StateMachine testStateMachine = new StateMachineImpl();

    /**
     * Represent the instance of <c>CompositeState</c> used for test.
     */
    private CompositeState testContainer = new CompositeStateImpl();

    /**
     * Represent the instance of <c>Collection</c> used for test.
     */
    private Collection<Transition> testTransitions;

    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception
     *             if any error occurs when set up
     */
    protected void setUp() throws Exception {
        abstractStateImpl = new FinalStateImpl();
        testTransitions = new ArrayList<Transition>();
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>AbstractStateImpl()</code>. The instance of
     * <code>AbstractStateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of AbstractStateImpl should be created", new FinalStateImpl());
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>AbstractStateImpl(CompositeState, Collection,Collection , StateMachine)</code>. The instance of
     * <code>AbstractStateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy1() {
        assertNotNull("instance of AbstractStateImpl should be created", new FinalStateImpl(testContainer,
                testTransitions, testTransitions, testStateMachine));
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>AbstractStateImpl(CompositeState, Collection,Collection , StateMachine)</code> with null Container. The
     * instance of <code>AbstractStateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy2() {
        assertNotNull("instance of AbstractStateImpl should be created", new FinalStateImpl(null, testTransitions,
                testTransitions, testStateMachine));
    }

    /**
     * <p>
     * Test the constructor <code>AbstractStateImpl(CompositeState,Collection,Collection,StateMachine)</code> with
     * null Transitions. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithNullTransitions() {
        try {
            new FinalStateImpl(testContainer, null, testTransitions, testStateMachine);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor <code>AbstractStateImpl(CompositeState,Collection,Collection,StateMachine)</code> with
     * transitions contains null element. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithTransitionsContainNull() {
        try {
            testTransitions.add(null);
            new FinalStateImpl(testContainer, testTransitions, new ArrayList<Transition>(), testStateMachine);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor <code>AbstractStateImpl(CompositeState,Collection,Collection,StateMachine)</code> with
     * null Transitions. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithNullTransitions2() {
        try {
            new FinalStateImpl(testContainer, testTransitions, null, testStateMachine);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor <code>AbstractStateImpl(CompositeState,Collection,Collection,StateMachine)</code> with
     * transitions contains null element. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithTransitionsContainNull2() {
        try {
            testTransitions.add(null);
            new FinalStateImpl(testContainer, new ArrayList<Transition>(), testTransitions, testStateMachine);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>AbstractStateImpl(CompositeState, Collection,Collection , StateMachine)</code> with null stateMachine,
     * The instance of <code>AbstractStateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy3() {
        assertNotNull("instance of AbstractStateImpl should be created", new FinalStateImpl(testContainer,
                testTransitions, testTransitions, null));
    }

    /**
     * <p>
     * Accuracy test for the method <code>setStateMachine</code> with null, the <c>stateMachine</c> field should be
     * set correctly.
     * </p>
     */
    public void testSetStateMachineAccuracyWithNull() {
        try {
            abstractStateImpl.setStateMachine(null);
            assertNull("The stateMachine field should be set correctly", abstractStateImpl.getStateMachine());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setStateMachine</code>, the <c>stateMachine</c> field should be set
     * correctly.
     * </p>
     */
    public void testSetStateMachineAccuracy() {
        try {
            abstractStateImpl.setStateMachine(testStateMachine);
            assertEquals("The stateMachine field should be set correctly", testStateMachine, abstractStateImpl
                    .getStateMachine());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getStateMachine</code>, the <c>stateMachine</c> field should be returned
     * correctly.
     * </p>
     */
    public void testGetStateMachineAccuracy() {
        try {
            abstractStateImpl.setStateMachine(testStateMachine);
            assertEquals("The stateMachine field should be returned correctly", testStateMachine, abstractStateImpl
                    .getStateMachine());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
