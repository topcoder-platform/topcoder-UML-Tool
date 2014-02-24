/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test case for <c>SimpleStateImpl</c>.
 * </p>
 *
 * @author catcher
 * @version 1.0
 */
public class SimpleStateImplUnitTests extends TestCase {


    /**
     * Represent the instance of <c>StateMachine</c> used for test.
     */
    private StateMachine testStateMachine = new StateMachineImpl();

    /**
     * Represent the instance of <c>PseudostateKind</c> used for test.
     */
    private CompositeState testContainer = new CompositeStateImpl();

    /**
     * Represent the instance of <c>Collection</c> used for test.
     */
    private Collection<Transition> testTransitions = new ArrayList<Transition>();


    /**
     * <p>
     * Accuracy test for the constructor <code>SimpleStateImpl()</code>. The instance of
     * <code>SimpleStateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of SimpleStateImpl should be created", new SimpleStateImpl());
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>SimpleStateImpl(CompositeState, Collection,Collection , StateMachine)</code>. The instance of
     * <code>SimpleStateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy1() {
        assertNotNull("instance of SimpleStateImpl should be created", new SimpleStateImpl(testContainer,
                testTransitions, testTransitions, testStateMachine));
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>SimpleStateImpl(CompositeState, Collection,Collection , StateMachine)</code> with null container, The
     * instance of <code>SimpleStateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy2() {
        assertNotNull("instance of SimpleStateImpl should be created", new SimpleStateImpl(null, testTransitions,
                testTransitions, testStateMachine));
    }

    /**
     * <p>
     * Test the constructor <code>SimpleStateImpl(CompositeState,Collection,Collection,StateMachine)</code> with
     * null Transitions. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithNullTransitions() {
        try {
            new SimpleStateImpl(testContainer, null, testTransitions, testStateMachine);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor <code>SimpleStateImpl(CompositeState,Collection,Collection,StateMachine)</code> with
     * transitions contains null element. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithTransitionsContainNull() {
        try {
            testTransitions.add(null);
            new SimpleStateImpl(testContainer, testTransitions, new ArrayList<Transition>(), testStateMachine);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor <code>SimpleStateImpl(CompositeState,Collection,Collection,StateMachine)</code> with
     * null Transitions. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithNullTransitions2() {
        try {
            new SimpleStateImpl(testContainer, testTransitions, null, testStateMachine);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor <code>SimpleStateImpl(CompositeState,Collection,Collection,StateMachine)</code> with
     * transitions contains null element. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithTransitionsContainNull2() {
        try {
            testTransitions.add(null);
            new SimpleStateImpl(testContainer, new ArrayList<Transition>(), testTransitions, testStateMachine);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>SimpleStateImpl(CompositeState, Collection,Collection , StateMachine)</code> with null stateMachine,
     * The instance of <code>SimpleStateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy3() {
        assertNotNull("instance of SimpleStateImpl should be created", new SimpleStateImpl(testContainer,
                testTransitions, testTransitions, null));
    }

}
