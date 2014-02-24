/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.CutTransitionAction;
import com.topcoder.uml.actions.model.activity.MockedTransition;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * Failure test for <code>CutTransitionAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class CutTransitionActionFailureTest extends TestCase {
    /**
     * <p>
     * The Transition instance created for testing.
     * </p>
     */
    private Transition transition;

    /**
     * <p>
     * The Clipboard instance created for testing.
     * </p>
     */
    private Clipboard clipboard;

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
        clipboard = new Clipboard("name");
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
     * Failure test for <code>CutTransitionAction
     * (Transition transition, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * transition is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCutTransitionActionNullState() {
        try {
            new CutTransitionAction(null, clipboard);
            fail("transition is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>CutTransitionAction
     * (Transition transition, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * clipboard is null, No IllegalArgumentException is expected.
     * </p>
     */
    public void testAddDecisionNodeActionInvlidTransition() {
        try {
            transition.setStateMachine(new StateMachineImpl());
            new CutTransitionAction(transition, clipboard);
        } catch (IllegalArgumentException e) {
            fail("clipboard is null, No IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for <code>CutTransitionAction
     * (Transition transition, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * clipboard is null, No IllegalArgumentException is expected.
     * </p>
     */
    public void testAddDecisionNodeActionNullClipboard() {
        try {
            transition.setStateMachine(new StateMachineImpl());
            new CutTransitionAction(transition, null);
        } catch (IllegalArgumentException e) {
            fail("clipboard is null, No IllegalArgumentException is expected.");
        }
    }
}
