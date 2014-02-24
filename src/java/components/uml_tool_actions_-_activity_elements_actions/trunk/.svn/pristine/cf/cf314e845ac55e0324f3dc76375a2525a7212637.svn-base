/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.CopyDecisionNodeAction;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Failure test for <code>CopyDecisionNodeAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class CopyDecisionNodeActionFailureTest extends TestCase {
    /**
     * <p>
     * The Pseudostate instance created for testing.
     * </p>
     */
    private Pseudostate state;

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
        state = new PseudostateImpl();
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
     * Failure test for <code>CopyDecisionNodeAction
     * (Pseudostate state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyDecisionNodeActionNullState() {
        try {
            new CopyDecisionNodeAction(null, clipboard);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>CopyDecisionNodeAction
     * (Pseudostate state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * clipboard is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyDecisionNodeActionNullClipboard() {
        try {
            new CopyDecisionNodeAction(state, null);
            fail("clipboard is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>CopyDecisionNodeAction
     * (Pseudostate state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * state argument's kind attribute is null, IllegalArgumentException is
     * expected.
     * </p>
     */
    public void testCopyDecisionNodeActionInvalidPseudostate1() {
        try {
            new CopyDecisionNodeAction(state, clipboard);
            fail("state is invalid, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>CopyDecisionNodeAction
     * (Pseudostate state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * state is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyDecisionNodeActionInvalidPseudostate2() {
        try {
            state.setKind(PseudostateKind.DEEP_HISTORY);
            new CopyDecisionNodeAction(state, null);
            fail("state is invalid, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
