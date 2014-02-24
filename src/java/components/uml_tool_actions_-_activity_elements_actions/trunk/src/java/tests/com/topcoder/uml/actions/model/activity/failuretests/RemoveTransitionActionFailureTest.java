/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.MockedTransition;
import com.topcoder.uml.actions.model.activity.RemoveTransitionAction;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * Failure test for <code>RemoveTransitionAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class RemoveTransitionActionFailureTest extends TestCase {
    /**
     * <p>
     * The Transition instance created for testing.
     * </p>
     */
    private Transition transition;

    /**
     * <p>
     * Set up the environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
        transition = new MockedTransition("name");
    }

    /**
     * <p>
     * Clear the namespace.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        Helper.unloadConfig();
    }

    /**
     * <p>
     * Failure test for
     * <code>RemoveTransitionAction(Transition transition)</code>.
     * </p>
     * <p>
     * transition is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteStateNodeAbstractActionNullTransition() {
        try {
            new RemoveTransitionAction(null);
            fail("transition is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>RemoveTransitionAction(Transition transition)</code>.
     * </p>
     * <p>
     * statemachine of transition is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteStateNodeAbstractActionNullStateMachine() {
        try {
            new RemoveTransitionAction(transition);
            fail("statemachine of transition is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
