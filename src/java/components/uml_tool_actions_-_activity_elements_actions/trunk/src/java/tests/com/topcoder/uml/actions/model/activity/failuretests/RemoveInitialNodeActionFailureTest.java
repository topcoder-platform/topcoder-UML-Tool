/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import com.topcoder.uml.actions.model.activity.RemoveForkNodeAction;
import com.topcoder.uml.actions.model.activity.RemoveInitialNodeAction;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>RemoveInitialNodeAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class RemoveInitialNodeActionFailureTest extends TestCase {

    /**
     * <p>
     * The Pseudostate instance created for testing.
     * </p>
     */
    private Pseudostate state;

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
     * Failure test for <code>RemoveInitialNodeAction(Pseudostate state)</code>.
     * </p>
     * <p>
     * content is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveInitialNodeActionNullState() {
        try {
            new RemoveInitialNodeAction(null);
            fail("content is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>RemoveInitialNodeAction(Pseudostate state)</code>.
     * </p>
     * <p>
     * Pseudostate is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveInitialNodeActionNullPseudostate() {
        try {
            new RemoveForkNodeAction(state);
            fail("Pseudostate is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>RemoveInitialNodeAction(Pseudostate state)</code>.
     * </p>
     * <p>
     * Pseudostate is not INITIAL, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveInitialNodeActionInvalidPseudostate() {
        try {
            state.setKind(PseudostateKind.JOIN);
            new RemoveInitialNodeAction(state);
            fail("Pseudostate is not INITIAL, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
