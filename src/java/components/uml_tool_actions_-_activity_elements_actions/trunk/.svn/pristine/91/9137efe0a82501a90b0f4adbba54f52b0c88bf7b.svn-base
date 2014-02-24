/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.RemoveMergeNodeAction;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Failure test for <code>RemoveMergeNodeAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class RemoveMergeNodeActionFailureTest extends TestCase {

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
     * Failure test for <code>RemoveDecisionNodeAction(Pseudostate state)</code>.
     * </p>
     * <p>
     * content is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveDecisionNodeActionNullState() {
        try {
            new RemoveMergeNodeAction(null);
            fail("content is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>RemoveMergeNodeAction(Pseudostate state)</code>.
     * </p>
     * <p>
     * Pseudostate is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveMergeNodeActionNullPseudostate() {
        try {
            new RemoveMergeNodeAction(state);
            fail("Pseudostate is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>RemoveMergeNodeAction(Pseudostate state)</code>.
     * </p>
     * <p>
     * Pseudostate is not JUNCTION, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveMergeNodeActionInvalidPseudostate() {
        try {
            state.setKind(PseudostateKind.CHOICE);
            new RemoveMergeNodeAction(state);
            fail("Pseudostate is not JUNCTION, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
