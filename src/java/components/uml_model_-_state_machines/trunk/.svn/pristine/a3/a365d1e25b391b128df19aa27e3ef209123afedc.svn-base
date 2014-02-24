/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test case for <c>StateMachineImpl</c>.
 * </p>
 *
 * @author catcher
 * @version 1.0
 */
public class StateMachineImplUnitTests extends TestCase {

    /**
     * Represent the instance of <c>TransitionImpl</c> used for test.
     */
    private TransitionImpl transition = new TransitionImpl();

    /**
     * Represent the instance of <c>StateMachineImpl</c> used for test.
     */
    private StateMachineImpl stateMachine;

    /**
     * Represent the instance of <c>ModelElement</c> used for test.
     */
    private ModelElement testContext = new ModelElementImpl();

    /**
     * Represent the instance of <c>State </c> used for test.
     */
    private State testTop = new SimpleStateImpl();

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

        stateMachine = new StateMachineImpl();
        testTransitions = new ArrayList<Transition>();
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>StateMachineImpl()</code>. The instance of
     * <code>StateMachineImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of StateMachineImpl should be created", new StateMachineImpl());
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>StateMachineImpl(ModelElement, State, Collection)</code>. The
     * instance of <code>StateMachineImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy1() {
        assertNotNull("instance of StateMachineImpl should be created", new StateMachineImpl(testContext, testTop,
                testTransitions));
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>StateMachineImpl(ModelElement,State,Collection)</code>with null
     * testContext, the instance of <code>StateMachineImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy2() {
        assertNotNull("instance of StateMachineImpl should be created", new StateMachineImpl(null, testTop,
                testTransitions));
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>StateMachineImpl(ModelElement,State,Collection)</code>with null
     * testTop, the instance of <code>StateMachineImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy3() {
        assertNotNull("instance of StateMachineImpl should be created", new StateMachineImpl(testContext, null,
                testTransitions));
    }


    /**
     * <p>
     * Test the constructor <code>SimpleStateImpl(CompositeState,Collection,Collection,StateMachine)</code> with
     * null Transitions. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithNullTransitions() {
        try {
            new StateMachineImpl(testContext, testTop, null);
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
            new StateMachineImpl(testContext, testTop, testTransitions);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setContext</code> with null, the <c>context</c> field should be set
     * correctly.
     * </p>
     */
    public void testSetContextAccuracyWithNull() {
        try {
            stateMachine.setContext(null);
            assertNull("The context field should be set correctly", stateMachine.getContext());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setContext</code>, the <c>context</c> field should be set correctly.
     * </p>
     */
    public void testSetContextAccuracy() {
        try {
            stateMachine.setContext(testContext);
            assertEquals("The context field should be set correctly", testContext, stateMachine.getContext());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getContext</code>, the <c>context</c> field should be returned correctly.
     * </p>
     */
    public void testGetContextAccuracy() {
        try {
            stateMachine.setContext(testContext);
            assertEquals("The context field should be returned correctly", testContext, stateMachine.getContext());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setTop</code> with null, the <c>top</c> field should be set correctly.
     * </p>
     */
    public void testSetTopAccuracyWithNull() {
        try {
            stateMachine.setTop(null);
            assertNull("The top field should be set correctly", stateMachine.getTop());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setTop</code>, the <c>top</c> field should be set correctly.
     * </p>
     */
    public void testSetTopAccuracy() {
        try {
            stateMachine.setTop(testTop);
            assertEquals("The top field should be set correctly", testTop, stateMachine.getTop());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getTop</code>, the <c>top</c> field should be returned correctly.
     * </p>
     */
    public void testGetTopAccuracy() {
        try {
            stateMachine.setTop(testTop);
            assertEquals("The top field should be returned correctly", testTop, stateMachine.getTop());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>addTransition(Transition transition)</code> with null transition.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testaddTransitionWithNulltransition() throws Exception {
        try {
            stateMachine.addTransition(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>addTransition(Transition transition)</code>, the transition should be add.
     * </p>
     */
    public void testaddTransitionAccuracy() {
        try {
            stateMachine.addTransition(transition);
            assertEquals("the transition should be add", 1, stateMachine.countTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>removeTransition(Transition transition)</code> with null transition.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testremoveTransitionWithNulltransition() throws Exception {
        try {
            stateMachine.removeTransition(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>removeTransition(Transition transition)</code> the transition should be
     * removed.
     * </p>
     */
    public void testremoveTransitionAccuracy() {
        try {
            stateMachine.addTransition(transition);
            assertTrue("the transition should be removed", stateMachine.removeTransition(transition));
            assertEquals("the transition should be removed", 0, stateMachine.countTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>removeTransition(Transition transition)</code> with the new transition ,it
     * should not be removed and false should be returned.
     * </p>
     */
    public void testremoveTransitionAccuracy2() {
        try {
            stateMachine.addTransition(transition);
            assertFalse("false should be returned", stateMachine.removeTransition(new TransitionImpl()));
            assertEquals("the transition should not be removed", 1, stateMachine.countTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>countTransitions()</code> The zero should be returned.
     * </p>
     */
    public void testCountTransitionsAccuracy() {
        try {
            assertEquals("the 0 should be returned", 0, stateMachine.countTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>countTransitions()</code> with duplicate transitions, the duplicate should
     * be returned.
     * </p>
     */
    public void testCountTransitionsAccuracyDuplicate() {
        try {
            stateMachine.addTransition(transition);
            stateMachine.addTransition(transition);
            assertEquals("the 2 should be returned", 2, stateMachine.countTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>clearTransitions()</code>, the transitions should be cleared.
     * </p>
     */
    public void testClearTransitionsAccuracy() {
        try {
            stateMachine.addTransition(transition);
            stateMachine.addTransition(transition);
            stateMachine.clearTransitions();
            assertEquals("the transitions should be cleared", 0, stateMachine.countTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>containsTransition(Transition transition)</code> with null transition.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testContainsTransitionWithNulltransition() throws Exception {
        try {
            stateMachine.containsTransition(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>containsTransition(Transition transition)</code> with contained transition,
     * the true should be returned.
     * </p>
     */
    public void testContainsTransitionAccuracyExisted() {
        try {
            stateMachine.addTransition(transition);
            assertTrue("the true should be returned", stateMachine.containsTransition(transition));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>containsTransition(Transition transition)</code> with unknown transition,
     * the true should be returned.
     * </p>
     */
    public void testContainsTransitionAccuracyInexisted() {
        try {
            assertFalse("the true should be returned", stateMachine.containsTransition(transition));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}

