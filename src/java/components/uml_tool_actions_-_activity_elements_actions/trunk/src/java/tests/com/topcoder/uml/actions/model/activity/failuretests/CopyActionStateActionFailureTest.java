/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.CopyActionStateAction;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;

/**
 * <p>
 * Failure test for <code>CopyActionStateAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class CopyActionStateActionFailureTest extends TestCase {
    /**
     * <p>
     * The ActionState instance created for testing.
     * </p>
     */
    private ActionState state;

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
        state = new ActionStateImpl();
        clipboard = new Clipboard("name");
    }

    /**
     * <p>
     * Failure test for
     * <code>CopyActionStateAction(SimpleState state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyActionStateActionNullState() {
        try {
            new CopyActionStateAction(null, clipboard);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>CopyActionStateAction(SimpleState state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * clipboard is null, No IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyActionStateActionNullClipboard() {
        try {
            new CopyActionStateAction(state, null);
        } catch (IllegalArgumentException e) {
            fail("clipboard is null, No IllegalArgumentException is expected.");
        }
    }
}
