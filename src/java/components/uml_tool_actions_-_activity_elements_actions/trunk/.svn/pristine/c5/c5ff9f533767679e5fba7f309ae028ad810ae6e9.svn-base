/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.ActivityObjectCloneException;
import com.topcoder.uml.actions.model.activity.CopyTransitionAction;
import com.topcoder.uml.actions.model.activity.MockedTransition;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Failure test for <code>CopyTransitionAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class CopyTransitionActionFailureTest extends TestCase {

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
     * Failure test for
     * <code>CopyTransitionAction(Transition transition, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyObjectFlowStateActionNullState() {
        try {
            new CopyTransitionAction(null, clipboard);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>CopyTransitionAction(Transition transition, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * clipboard is null, No IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyTransitionActionNullClipboard() {
        try {
            new CopyTransitionAction(transition, null);
        } catch (IllegalArgumentException e) {
            fail("clipboard is null, No IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for <code>execute()</code>.
     * </p>
     * <p>
     * transition is not cloneable, ActivityObjectCloneException is expected.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testExecute() throws ActionExecutionException {
        try {
            new CopyTransitionAction(transition, clipboard).execute();
            fail("transition is not cloneable, ActivityObjectCloneException is expected");
        } catch (ActivityObjectCloneException e) {
            // expect
        }
    }
}
