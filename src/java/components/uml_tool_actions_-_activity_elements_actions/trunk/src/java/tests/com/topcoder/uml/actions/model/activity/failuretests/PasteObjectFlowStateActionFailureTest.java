/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.PasteObjectFlowStateAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;

/**
 * <p>
 * Failure test for <code>PasteObjectFlowStateAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class PasteObjectFlowStateActionFailureTest extends TestCase {

    /**
     * <p>
     * The ObjectFlowState instance created for testing.
     * </p>
     */
    private ObjectFlowState state;

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
        state = new ObjectFlowStateImpl();
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
     * <code>PasteObjectFlowStateAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteObjectFlowStateActionNullState() {
        try {
            new PasteObjectFlowStateAction(null, activityGraph);
            fail("content is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteObjectFlowStateAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * activityGraph is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteObjectFlowStateActionNullActivityGraph() {
        try {
            new PasteObjectFlowStateAction(state, null);
            fail("activityGraph is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteObjectFlowStateAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is not of type Pseudostate, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteObjectFlowStateActionInvalidObject() {
        try {
            new PasteObjectFlowStateAction(new Object(), null);
            fail("content is not of type Pseudostate, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
