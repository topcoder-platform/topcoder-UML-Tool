/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test case for <c>TransitionImpl</c>.
 * </p>
 *
 * @author catcher
 * @version 1.0
 */
public class TransitionImplUnitTests extends TestCase {

    /**
     * Represent the instance of <c>TransitionImpl</c> used for test.
     */
    private TransitionImpl transition;

    /**
     * Represent the instance of <c>StateMachine</c> used for test.
     */
    private StateMachine testStateMachine = new StateMachineImpl();

    /**
     * Represent the instance of <c>StateVertex</c> used for test.
     */
    private StateVertex testSource = new PseudostateImpl();

    /**
     * Represent the instance of <c>StateVertex</c> used for test.
     */
    private StateVertex testTarget = new PseudostateImpl();

    /**
     * Represent the instance of <c>Guard</c> used for test.
     */
    private Guard testGuard = new GuardImpl();

    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception
     *             if any error occurs when set up
     */
    protected void setUp() throws Exception {

        transition = new TransitionImpl();
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>TransitionImpl()</code>. The instance of <code>TransitionImpl</code>
     * should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of TransitionImpl should be created", new TransitionImpl());
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>TransitionImpl(StateMachine stateMachine, StateVertex source, StateVertex target, Guard guard)</code>
     * with null testGguard. The instance of <code>TransitionImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy2() {
        assertNotNull("instance of TransitionImpl should be created", new TransitionImpl(testStateMachine, testSource,
                testTarget, null));
    }

    /**
     * <p>
     * Accuracy test for the method <code>setStateMachine</code> with null, the <c>stateMachine</c> field should be
     * set correctly.
     * </p>
     */
    public void testSetStateMachineAccuracyWithNull() {
        try {
            transition.setStateMachine(null);
            assertNull("The stateMachine field should be set correctly", transition.getStateMachine());
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
            transition.setStateMachine(testStateMachine);
            assertEquals("The stateMachine field should be set correctly", testStateMachine, transition
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
            transition.setStateMachine(testStateMachine);
            assertEquals("The stateMachine field should be returned correctly", testStateMachine, transition
                    .getStateMachine());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setSource</code> with null, the <c>source</c> field should be set
     * correctly.
     * </p>
     */
    public void testSetSourceAccuracyWithNull() {
        try {
            transition.setSource(null);
            assertNull("The source field should be set correctly", transition.getSource());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setSource</code>, the <c>source</c> field should be set correctly.
     * </p>
     */
    public void testSetSourceAccuracy() {
        try {
            transition.setSource(testSource);
            assertEquals("The source field should be set correctly", testSource, transition.getSource());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getSource</code>, the <c>source</c> field should be returned correctly.
     * </p>
     */
    public void testGetSourceAccuracy() {
        try {
            transition.setSource(testSource);
            assertEquals("The source field should be returned correctly", testSource, transition.getSource());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setTarget</code> with null, the <c>target</c> field should be set
     * correctly.
     * </p>
     */
    public void testSetTargetAccuracyWithNull() {
        try {
            transition.setTarget(null);
            assertNull("The target field should be set correctly", transition.getTarget());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setTarget</code>, the <c>target</c> field should be set correctly.
     * </p>
     */
    public void testSetTargetAccuracy() {
        try {
            transition.setTarget(testTarget);
            assertEquals("The target field should be set correctly", testTarget, transition.getTarget());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getTarget</code>, the <c>target</c> field should be returned correctly.
     * </p>
     */
    public void testGetTargetAccuracy() {
        try {
            transition.setTarget(testTarget);
            assertEquals("The target field should be returned correctly", testTarget, transition.getTarget());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setGuard</code> with null, the <c>guard</c> field should be set correctly.
     * </p>
     */
    public void testSetGuardAccuracyWithNull() {
        try {
            transition.setGuard(null);
            assertNull("The guard field should be set correctly", transition.getGuard());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setGuard</code>, the <c>guard</c> field should be set correctly.
     * </p>
     */
    public void testSetGuardAccuracy() {
        try {
            transition.setGuard(testGuard);
            assertEquals("The guard field should be set correctly", testGuard, transition.getGuard());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getGuard</code>, the <c>guard</c> field should be returned correctly.
     * </p>
     */
    public void testGetGuardAccuracy() {
        try {
            transition.setGuard(testGuard);
            assertEquals("The guard field should be returned correctly", testGuard, transition.getGuard());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
