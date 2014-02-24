/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.CopyForkNodeAction;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Failure test for <code>CopyForkNodeAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class CopyForkNodeActionFailureTest extends TestCase {

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
     * Failure test for
     * <code>CopyActionStateAction(Pseudostate state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyForkNodeActionNullState() {
        try {
            new CopyForkNodeAction(null, clipboard);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>CopyForkNodeAction(Pseudostate state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * PseudostateKind is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyForkNodeActionInvalidState1() {
        try {
            new CopyForkNodeAction(state, clipboard);
            fail("PseudostateKind is not FORK, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>CopyForkNodeAction(Pseudostate state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * PseudostateKind is not FORK, IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyForkNodeActionInvalidState2() {
        try {
            state.setKind(PseudostateKind.CHOICE);
            new CopyForkNodeAction(state, clipboard);
            fail("PseudostateKind is not FORK, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
