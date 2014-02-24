/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.RemoveJoinNodeAction;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Failure test for <code>RemoveJoinNodeAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class RemoveJoinNodeActionFailureTest extends TestCase {

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
            new RemoveJoinNodeAction(null);
            fail("content is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>RemoveJoinNodeAction(Pseudostate state)</code>.
     * </p>
     * <p>
     * state argument's kind attribute is null, IllegalArgumentException is
     * expected.
     * </p>
     */
    public void testRemoveJoinNodeActionNullPseudostate() {
        try {
            new RemoveJoinNodeAction(state);
            fail("state argument's kind attribute is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>RemoveJoinNodeAction(Pseudostate state)</code>.
     * </p>
     * <p>
     * Pseudostate is not JOIN, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveJoinNodeActionInvalidPseudostate() {
        try {
            state.setKind(PseudostateKind.CHOICE);
            new RemoveJoinNodeAction(state);
            fail("Pseudostate is not JOIN, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
