/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test case for <c>CompositeStateImpl</c>.
 * </p>
 *
 * @author catcher
 * @version 1.0
 */
public class CompositeStateImplUnitTests extends TestCase {
    /**
     * Represent the instance of <c>CompositeStateImpl</c> used for test.
     */
    private CompositeStateImpl compositeStateImpl;

    /**
     * Represent the instance of <c>StateMachine</c> used for test.
     */
    private StateMachine testStateMachine = new StateMachineImpl();

    /**
     * Represent the instance of <c>PseudostateKind</c> used for test.
     */
    private CompositeState testContainer = new CompositeStateImpl();

    /**
     * Represent the instance of <c>Collection</c> of the transitions used for test.
     */
    private Collection<Transition> testTransitions = new ArrayList<Transition>();

    /**
     * Represent the instance of <c>Collection</c>of the stateVertex used for test.
     */
    private Collection<StateVertex> testVertexes = new ArrayList<StateVertex>();

    /**
     * Represent the instance of <c>StateVertex</c>of the stateVertex used for test.
     */
    private StateVertex testStateVertex = new StateVertexImpl();

    /**
     * Represent the <c>Concurrent</c> used for test.
     */
    private boolean testConcurrent = true;

    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception
     *             if any error occurs when set up
     */
    protected void setUp() throws Exception {
        compositeStateImpl = new CompositeStateImpl();
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>CompositeStateImpl()</code>. The instance of
     * <code>CompositeStateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of CompositeStateImpl should be created", new CompositeStateImpl());
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>CompositeStateImpl(CompositeState, Collection, Collection,StateMachine, boolean, Collection)</code>. The
     * instance of <code>AbstractStateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy1() {
        assertNotNull("instance of AbstractStateImpl should be created", new CompositeStateImpl(testContainer,
                testTransitions, testTransitions, testStateMachine, testConcurrent, testVertexes));
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>CompositeStateImpl(CompositeState, Collection, Collection,StateMachine, boolean, Collection)</code> with
     * null container, The instance of <code>AbstractStateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy2() {
        assertNotNull("instance of AbstractStateImpl should be created", new CompositeStateImpl(null, testTransitions,
                testTransitions, testStateMachine, testConcurrent, testVertexes));
    }

    /**
     * <p>
     * Test the constructor
     * <code>CompositeStateImpl(CompositeState, Collection, Collection,StateMachine, boolean, Collection)</code> with
     * null Transitions. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithNullTransitions() {
        try {
            new CompositeStateImpl(testContainer, null, testTransitions, testStateMachine, testConcurrent,
                    testVertexes);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor
     * <code>CompositeStateImpl(CompositeState, Collection, Collection,StateMachine, boolean, Collection)</code> with
     * transitions contains null element. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithTransitionsContainNull() {
        try {
            testTransitions.add(null);
            new CompositeStateImpl(testContainer, testTransitions, new ArrayList<Transition>(), testStateMachine,
                    testConcurrent, testVertexes);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor
     * <code>CompositeStateImpl(CompositeState, Collection, Collection,StateMachine, boolean, Collection)</code> with
     * null Transitions. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithNullTransitions2() {
        try {
            new CompositeStateImpl(testContainer, testTransitions, null, testStateMachine, testConcurrent,
                    testVertexes);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor
     * <code>CompositeStateImpl(CompositeState, Collection, Collection,StateMachine, boolean, Collection)</code> with
     * transitions contains null element. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithTransitionsContainNull2() {
        try {
            testTransitions.add(null);
            new CompositeStateImpl(testContainer, new ArrayList<Transition>(), testTransitions, testStateMachine,
                    testConcurrent, testVertexes);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>CompositeStateImpl(CompositeState, Collection, Collection,StateMachine, boolean, Collection)</code> with
     * null stateMachine, The instance of <code>AbstractStateImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy5() {
        assertNotNull("instance of AbstractStateImpl should be created", new CompositeStateImpl(testContainer,
                testTransitions, testTransitions, null, testConcurrent, testVertexes));
    }

    /**
     * <p>
     * Test the constructor
     * <code>CompositeStateImpl(CompositeState, Collection, Collection,StateMachine, boolean, Collection)</code> with
     * null Vertexes. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithNullVertexes() {
        try {
            new CompositeStateImpl(testContainer, testTransitions, testTransitions, testStateMachine, testConcurrent,
                    null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the constructor
     * <code>CompositeStateImpl(CompositeState, Collection, Collection,StateMachine, boolean, Collection)</code> with
     * vertexes contains null element. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testConstructorWithVertexesContainNull() {
        try {
            testVertexes.add(null);
            new CompositeStateImpl(testContainer, testTransitions, testTransitions, testStateMachine, testConcurrent,
                    testVertexes);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setConcurrent</code>, the <c>isconcurrent</c> field should be set
     * correctly.
     * </p>
     */
    public void testSetConcurrentAccuracy() {
        try {
            compositeStateImpl.setConcurrent(testConcurrent);
            assertEquals("The isconcurrent field should be set correctly", testConcurrent, compositeStateImpl
                    .isConcurrent());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getConcurrent</code>, the <c>isconcurrent</c> field should be returned
     * correctly.
     * </p>
     */
    public void testGetConcurrentAccuracy() {
        try {
            compositeStateImpl.setConcurrent(testConcurrent);
            assertEquals("The isconcurrent field should be returned correctly", testConcurrent, compositeStateImpl
                    .isConcurrent());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>addSubVertex(Transition transition)</code> with null transition.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testaddSubVertexWithNull() throws Exception {
        try {
            compositeStateImpl.addSubVertex(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>addSubVertex(Transition transition)</code>, the transition should be add.
     * </p>
     */
    public void testAddSubVertexAccuracy() {
        try {
            compositeStateImpl.addSubVertex(testStateVertex);
            assertEquals("the testStateVertex should be add", 1, compositeStateImpl.countSubVertexes());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>removeTransition(Transition testStateVertex)</code> with null testStateVertex.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testremoveTransitionWithNulltransition() throws Exception {
        try {
            compositeStateImpl.removeSubVertex(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>removeSubVertex(Transition transition)</code> the transition should be
     * removed.
     * </p>
     */
    public void testremoveSubVertexAccuracy() {
        try {
            compositeStateImpl.addSubVertex(testStateVertex);
            assertTrue("the transition should be removed", compositeStateImpl.removeSubVertex(testStateVertex));
            assertEquals("the transition should be removed", 0, compositeStateImpl.countSubVertexes());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>removeSubVertex(Transition transition)</code> with the new transition ,it
     * should not be removed and false should be returned.
     * </p>
     */
    public void testremoveSubVertexAccuracy2() {
        try {
            compositeStateImpl.addSubVertex(testStateVertex);
            assertFalse("false should be returned", compositeStateImpl.removeSubVertex(new StateVertexImpl()));
            assertEquals("the transition should not be removed", 1, compositeStateImpl.countSubVertexes());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>countSubVertexes()</code> The zero should be returned.
     * </p>
     */
    public void testCountTransitionsAccuracy() {
        try {
            assertEquals("the 0 should be returned", 0, compositeStateImpl.countSubVertexes());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>countSubVertexes()</code> with duplicate transitions, the duplicate should
     * be returned.
     * </p>
     */
    public void testCountTransitionsAccuracyDuplicate() {
        try {
            compositeStateImpl.addSubVertex(testStateVertex);
            compositeStateImpl.addSubVertex(testStateVertex);
            assertEquals("the 2 should be returned", 2, compositeStateImpl.countSubVertexes());
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
            compositeStateImpl.addSubVertex(testStateVertex);
            compositeStateImpl.addSubVertex(testStateVertex);
            compositeStateImpl.clearSubVertexes();
            assertEquals("the transitions should be cleared", 0, compositeStateImpl.countSubVertexes());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>containsSubVertex(Transition transition)</code> with null transition.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testContainsTransitionWithNulltransition() throws Exception {
        try {
            compositeStateImpl.containsSubVertex(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>containsSubVertex(Transition transition)</code> with contained transition,
     * the true should be returned.
     * </p>
     */
    public void testContainsTransitionAccuracyExisted() {
        try {
            compositeStateImpl.addSubVertex(testStateVertex);
            assertTrue("the true should be returned", compositeStateImpl.containsSubVertex(testStateVertex));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>containsSubVertex(Transition transition)</code> with unknown transition, the
     * true should be returned.
     * </p>
     */
    public void testContainsTransitionAccuracyInexisted() {
        try {
            assertFalse("the true should be returned", compositeStateImpl.containsSubVertex(testStateVertex));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
