/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.PasteDecisionNodeAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Failure test for <code>PasteDecisionNodeAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class PasteDecisionNodeActionFailureTest extends TestCase {

    /**
     * <p>
     * The Pseudostate instance created for testing.
     * </p>
     */
    private Pseudostate state;

    /**
     * <p>
     * The ActivityGraph instance created for testing.
     * </p>
     */
    private ActivityGraph activityGraph;

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
        activityGraph = new ActivityGraphImpl();
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
     * <code>PasteDecisionNodeAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteDecisionNodeActionNullState() {
        try {
            new PasteDecisionNodeAction(null, activityGraph);
            fail("content is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteDecisionNodeAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * activityGraph is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteDecisionNodeActionNullActivityGraph() {
        try {
            state.setKind(PseudostateKind.CHOICE);
            new PasteDecisionNodeAction(state, null);
            fail("activityGraph is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteDecisionNodeAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is not of type Pseudostate, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteDecisionNodeActionInvalidObject() {
        try {
            new PasteDecisionNodeAction(new Object(), null);
            fail("content is not of type Pseudostate, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteDecisionNodeAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * Pseudostate is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteDecisionNodeActionNullPseudostate() {
        try {
            new PasteDecisionNodeAction(state, activityGraph);
            fail("Pseudostate is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteDecisionNodeAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * Pseudostate is not CHOICE, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteDecisionNodeActionInvalidPseudostate() {
        try {
            state.setKind(PseudostateKind.DEEP_HISTORY);
            new PasteDecisionNodeAction(state, activityGraph);
            fail("Pseudostate is not CHOICE, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
