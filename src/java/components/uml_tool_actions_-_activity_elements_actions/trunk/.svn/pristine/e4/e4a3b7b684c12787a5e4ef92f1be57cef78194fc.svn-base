/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Failure test for <code>ActivityObjectClipboardUtility</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class ActivityObjectClipboardUtilityFailureTest extends TestCase {
    /**
     * <p>
     * Failure test for
     * <code>copyStateNode(StateVertex state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCopyStateNodeNullStateVertex() throws ActivityObjectCloneException, ActionExecutionException {
        try {
            ActivityObjectClipboardUtility.copyStateNode(null, new Clipboard("name"));
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>copyStateNode(StateVertex state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * clipboard is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCopyStateNodeNullClipboard() throws ActivityObjectCloneException, ActionExecutionException {
        try {
            ActivityObjectClipboardUtility.copyStateNode(new ActionStateImpl(), null);
            fail("clipboard is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>copyStateNode(StateVertex state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * state is unknown, ActionExecutionException is expected.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCopyStateNodeUnkonwnClipboard() throws ActivityObjectCloneException {
        try {
            ActivityObjectClipboardUtility.copyStateNode(new MockedStateVertex("name"), new Clipboard("name"));
            fail("state is unknown, ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>copyTransition(Transition transition, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * transition is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCopyTransitionNullTransition() throws ActivityObjectCloneException {
        try {
            ActivityObjectClipboardUtility.copyTransition(null, new Clipboard("name"));
            fail("transition is unknown, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>copyTransition(Transition transition, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * clipboard is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCopyTransitionNullClipboard() throws ActivityObjectCloneException {
        try {
            ActivityObjectClipboardUtility.copyTransition(new TransitionImpl(), null);
            fail("clipboard is unknown, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>copyTransition(Transition transition, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * No default constructor is present, ActivityObjectCloneException is expected.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCopyTransitionCloneFailed() throws ActivityObjectCloneException {
        try {
            ActivityObjectClipboardUtility.copyTransition(new MockedTransition("name"), new Clipboard("name"));
            fail("No default constructor is present, ActivityObjectCloneException is expected.");
        } catch (ActivityObjectCloneException e) {
            // expect
        }
    }
}
