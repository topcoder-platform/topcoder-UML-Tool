/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.CopyObjectFlowStateAction;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;

/**
 * <p>
 * Failure test for <code>CopyObjectFlowStateAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class CopyObjectFlowStateActionFailureTest extends TestCase {

    /**
     * <p>
     * The ObjectFlowState instance created for testing.
     * </p>
     */
    private ObjectFlowState state;

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
        state = new ObjectFlowStateImpl();
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
     * <code>CopyInitialNodeAction(ObjectFlowState state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyObjectFlowStateActionNullState() {
        try {
            new CopyObjectFlowStateAction(null, clipboard);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>CopyObjectFlowStateAction(ObjectFlowState state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * clipboard is null, No IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyObjectFlowStateActionNullClipboard() {
        try {
            new CopyObjectFlowStateAction(state, null);
        } catch (IllegalArgumentException e) {
            fail("clipboard is null, No IllegalArgumentException is expected.");
        }
    }
}
