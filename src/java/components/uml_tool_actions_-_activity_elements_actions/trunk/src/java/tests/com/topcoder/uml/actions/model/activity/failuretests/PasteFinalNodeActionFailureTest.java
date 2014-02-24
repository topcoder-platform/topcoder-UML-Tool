/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.PasteFinalNodeAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.FinalStateImpl;

/**
 * <p>
 * Failure test for <code>PasteFinalNodeAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class PasteFinalNodeActionFailureTest extends TestCase {

    /**
     * <p>
     * The FinalState instance created for testing.
     * </p>
     */
    private FinalState state;

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
        state = new FinalStateImpl();
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
     * <code>PasteFinalNodeAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteFinalNodeActionNullState() {
        try {
            new PasteFinalNodeAction(null, activityGraph);
            fail("content is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteFinalNodeAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * activityGraph is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteFinalNodeActionNullActivityGraph() {
        try {
            new PasteFinalNodeAction(state, null);
            fail("activityGraph is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteFinalNodeAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is not of type SimpleState, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteFinalNodeActionInvalidObject() {
        try {
            new PasteFinalNodeAction(new Object(), null);
            fail("content is not of type SimpleState, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
