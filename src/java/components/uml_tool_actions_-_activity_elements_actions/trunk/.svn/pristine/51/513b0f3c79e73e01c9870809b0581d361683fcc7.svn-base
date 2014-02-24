/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.RemoveDecisionNodeAction;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Failure test for <code>RemoveDecisionNodeAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class RemoveDecisionNodeActionFailureTest extends TestCase {

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
            new RemoveDecisionNodeAction(null);
            fail("content is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>RemoveDecisionNodeAction(Pseudostate state)</code>.
     * </p>
     * <p>
     * Pseudostate is not CHOICE, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveDecisionNodeActionInvalidPseudostate() {
        try {
            state.setKind(PseudostateKind.JOIN);
            new RemoveDecisionNodeAction(state);
            fail("Pseudostate is not CHOICE, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
