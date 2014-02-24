/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test case for <c>StateVertexAbstractImpl</c>.
 * </p>
 *
 * @author catcher
 * @version 1.0
 */
public class StateVertexAbstractImplUnitTests extends TestCase {

    /**
     * Represent the instance of <c>TransitionImpl</c> used for test.
     */
    private TransitionImpl transition = new TransitionImpl();

    /**
     * Represent the instance of <c>StateVertexAbstractImpl</c> used for test.
     */
    private StateVertexAbstractImpl stateVertex;

    /**
     * Represent the instance of <c>CompositeState</c> used for test.
     */
    private CompositeState testContainer = new CompositeStateImpl();

    /**
     * Represent the instance of <c>Collection</c> used for test.
     */
    private Collection<Transition> testTransitions = new ArrayList<Transition>();

    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception
     *             if any error occurs when set up
     */
    protected void setUp() throws Exception {
        stateVertex = new StateVertexImpl();
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>StateVertexAbstractImpl()</code>. The instance of
     * <code>StateVertexAbstractImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of StateVertexAbstractImpl should be created", new StateVertexImpl());
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>StateVertexAbstractImpl(CompositeState, Collection, Collection)</code>.
     * The instance of <code>StateVertexAbstractImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy1() {
        assertNotNull("instance of StateVertexAbstractImpl should be created", new StateVertexImpl(testContainer,
                testTransitions, testTransitions));
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>StateVertexAbstractImpl(CompositeState, Collection, Collection)</code>
     * with null container. The instance of <code>StateVertexAbstractImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy2() {
        assertNotNull("instance of StateVertexAbstractImpl should be created", new StateVertexImpl(null,
                testTransitions, testTransitions));
    }

    /**
     * <p>
     * Test the constructor <code>StateVertexAbstractImpl(CompositeState, Collection, Collection)</code> with
     * null Transitions. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithNullTransitions() {
        try {
            new StateVertexImpl(testContainer, null, testTransitions);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor <code>StateVertexAbstractImpl(CompositeState, Collection, Collection)</code> with
     * transitions contains null element. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithTransitionsContainNull() {
        try {
            testTransitions.add(null);
            new StateVertexImpl(testContainer, testTransitions, new ArrayList<Transition>());
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor <code>StateVertexAbstractImpl(CompositeState, Collection, Collection)</code> with
     * null Transitions. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithNullTransitions2() {
        try {
            new StateVertexImpl(testContainer, testTransitions, null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor <code>StateVertexAbstractImpl(CompositeState, Collection, Collection)</code> with
     * transitions contains null element. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithTransitionsContainNull2() {
        try {
            testTransitions.add(null);
            new StateVertexImpl(testContainer, new ArrayList<Transition>(), testTransitions);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method <code>addIncomingTransition((Transition transition)</code> with null transition.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testaddIncomingTransitionWithNulltransition() throws Exception {
        try {
            stateVertex.addIncomingTransition(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>addIncomingTransition(Transition transition)</code>, the transition should
     * be add.
     * </p>
     */
    public void testaddIncomingTransitionAccuracy() {
        try {
            stateVertex.addIncomingTransition(transition);
            assertEquals("the transition should be add", 1, stateVertex.countIncomingTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>removeIncomingTransition(Transition transition)</code> with null transition.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testremoveIncomingTransitionWithNulltransition() throws Exception {
        try {
            stateVertex.removeIncomingTransition(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>removeIncomingTransition(Transition transition)</code> the transition should
     * be removed.
     * </p>
     */
    public void testremoveIncomingTransitionAccuracy() {
        try {
            stateVertex.addIncomingTransition(transition);
            assertTrue("the transition should be removed", stateVertex.removeIncomingTransition(transition));
            assertEquals("the transition should be removed", 0, stateVertex.countIncomingTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>removeIncomingTransition(Transition transition)</code> with the new
     * transition ,it should not be removed and false should be returned.
     * </p>
     */
    public void testremoveIncomingTransitionAccuracy2() {
        try {
            stateVertex.addIncomingTransition(transition);
            assertFalse("false should be returned", stateVertex.removeIncomingTransition(new TransitionImpl()));
            assertEquals("the transition should not be removed", 1, stateVertex.countIncomingTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>countTransitions()</code> The zero should be returned.
     * </p>
     */
    public void testCountIncomingTransitionsAccuracy() {
        try {
            assertEquals("the 0 should be returned", 0, stateVertex.countIncomingTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>countIncomingTransitions()</code> with duplicated transitions, the
     * duplicate should be returned.
     * </p>
     */
    public void testCountIncomingTransitionsAccuracyDuplicate() {
        try {
            stateVertex.addIncomingTransition(transition);
            stateVertex.addIncomingTransition(transition);
            assertEquals("the 2 should be returned", 2, stateVertex.countIncomingTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>clearIncomingTransitions()</code>, the transitions should be cleared.
     * </p>
     */
    public void testClearIncomingTransitionsAccuracy() {
        try {
            stateVertex.addIncomingTransition(transition);
            stateVertex.addIncomingTransition(transition);
            stateVertex.clearIncomingTransitions();
            assertEquals("the transitions should be cleared", 0, stateVertex.countIncomingTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>containsIncomingTransition(Transition transition)</code> with null transition.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testContainsIncomingTransitionWithNulltransition() throws Exception {
        try {
            stateVertex.containsIncomingTransition(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>containsIncomingTransition(Transition transition)</code> with contained
     * transition, the true should be returned.
     * </p>
     */
    public void testContainsIncomingTransitionAccuracyExisted() {
        try {
            stateVertex.addIncomingTransition(transition);
            assertTrue("the true should be returned", stateVertex.containsIncomingTransition(transition));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>containsIncomingTransition(Transition transition)</code> with unknown
     * transition, the true should be returned.
     * </p>
     */
    public void testContainsIncomingTransitionAccuracyInexisted() {
        try {
            assertFalse("the true should be returned", stateVertex.containsIncomingTransition(transition));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>addOutgoingTransition((Transition transition)</code> with null transition.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testaddOutgoingTransitionWithNulltransition() throws Exception {
        try {
            stateVertex.addOutgoingTransition(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>addOutgoingTransition(Transition transition)</code>, the transition should
     * be add.
     * </p>
     */
    public void testaddOutgoingTransitionAccuracy() {
        try {
            stateVertex.addOutgoingTransition(transition);
            assertEquals("the transition should be add", 1, stateVertex.countOutgoingTransitions());
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
            stateVertex.removeOutgoingTransition(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>removeOutgoingTransition(Transition transition)</code> the transition should
     * be removed.
     * </p>
     */
    public void testremoveOutgoingTransitionAccuracy() {
        try {
            stateVertex.addOutgoingTransition(transition);
            assertTrue("the transition should be removed", stateVertex.removeOutgoingTransition(transition));
            assertEquals("the transition should be removed", 0, stateVertex.countOutgoingTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>removeOutgoingTransition(Transition transition)</code> with the new
     * transition ,it should not be removed and false should be returned.
     * </p>
     */
    public void testremoveOutgoingTransitionAccuracy2() {
        try {
            stateVertex.addOutgoingTransition(transition);
            assertFalse("false should be returned", stateVertex.removeOutgoingTransition(new TransitionImpl()));
            assertEquals("the transition should not be removed", 1, stateVertex.countOutgoingTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>countTransitions()</code> The zero should be returned.
     * </p>
     */
    public void testCountOutgoingTransitionsAccuracy() {
        try {
            assertEquals("the 0 should be returned", 0, stateVertex.countOutgoingTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>countOutgoingTransitions()</code> with duplicate transitions, the
     * duplicate should be returned.
     * </p>
     */
    public void testCountOutgoingTransitionsAccuracyDuplicate() {
        try {
            stateVertex.addOutgoingTransition(transition);
            stateVertex.addOutgoingTransition(transition);
            assertEquals("the 2 should be returned", 2, stateVertex.countOutgoingTransitions());
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
            stateVertex.addOutgoingTransition(transition);
            stateVertex.addOutgoingTransition(transition);
            stateVertex.clearOutgoingTransitions();
            assertEquals("the transitions should be cleared", 0, stateVertex.countOutgoingTransitions());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>containsOutgoingTransition(Transition transition)</code> with null transition.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testContainsOutgoingTransitionWithNulltransition() throws Exception {
        try {
            stateVertex.containsOutgoingTransition(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>containsOutgoingTransition(Transition transition)</code> with contained
     * transition, the true should be returned.
     * </p>
     */
    public void testContainsOutgoingTransitionAccuracyExisted() {
        try {
            stateVertex.addOutgoingTransition(transition);
            assertTrue("the true should be returned", stateVertex.containsOutgoingTransition(transition));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>containsOutgoingTransition(Transition transition)</code> with unknown
     * transition, the true should be returned.
     * </p>
     */
    public void testContainsOutgoingTransitionAccuracyInexisted() {
        try {
            assertFalse("the true should be returned", stateVertex.containsOutgoingTransition(transition));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setContainer</code> with null, the <c>container</c> field should be set
     * correctly.
     * </p>
     */
    public void testSetContainerAccuracyWithNull() {
        try {
            stateVertex.setContainer(null);
            assertNull("The container field should be set correctly", stateVertex.getContainer());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setContainer</code>, the <c>container</c> field should be set correctly.
     * </p>
     */
    public void testSetContainerAccuracy() {
        try {
            stateVertex.setContainer(testContainer);
            assertEquals("The container field should be set correctly", testContainer, stateVertex.getContainer());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getContainer</code>, the <c>container</c> field should be returned
     * correctly.
     * </p>
     */
    public void testGetContainerAccuracy() {
        try {
            stateVertex.setContainer(testContainer);
            assertEquals("The container field should be returned correctly", testContainer, stateVertex.getContainer());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
