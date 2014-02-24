/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import com.topcoder.uml.actions.model.activity.PasteJoinNodeAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>PasteJoinNodeAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class PasteJoinNodeActionFailureTest extends TestCase {

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
     * <code>PasteJoinNodeAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteJoinNodeActionNullState() {
        try {
            new PasteJoinNodeAction(null, activityGraph);
            fail("content is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteJoinNodeAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * activityGraph is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteJoinNodeActionNullActivityGraph() {
        try {
            state.setKind(PseudostateKind.JOIN);
            new PasteJoinNodeAction(state, null);
            fail("activityGraph is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteJoinNodeAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is not of type Pseudostate, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteJoinNodeActionInvalidObject() {
        try {
            new PasteJoinNodeAction(new Object(), null);
            fail("content is not of type Pseudostate, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteJoinNodeAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * Pseudostate is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteJoinNodeActionNullPseudostate() {
        try {
            new PasteJoinNodeAction(state, activityGraph);
            fail("Pseudostate is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteJoinNodeAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * Pseudostate is not JOIN, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteJoinNodeActionInvalidPseudostate() {
        try {
            state.setKind(PseudostateKind.CHOICE);
            new PasteJoinNodeAction(state, activityGraph);
            fail("Pseudostate is not JOIN, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
