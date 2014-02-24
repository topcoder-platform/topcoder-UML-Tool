/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.PasteSendSignalActionAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;

/**
 * <p>
 * Failure test for <code>PasteSendSignalActionAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class PasteSendSignalActionActionFailureTest extends TestCase {

    /**
     * <p>
     * The SimpleState instance created for testing.
     * </p>
     */
    private SimpleState state;

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
        state = new SimpleStateImpl();
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
     * <code>PasteSendSignalActionAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteSendSignalActionActionNullState() {
        try {
            new PasteSendSignalActionAction(null, activityGraph);
            fail("content is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteSendSignalActionAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * activityGraph is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteSendSignalActionActionNullActivityGraph() {
        try {
            new PasteSendSignalActionAction(state, null);
            fail("activityGraph is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteSendSignalActionAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is not of type SimpleState, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteSendSignalActionActionInvalidObject() {
        try {
            new PasteSendSignalActionAction(new Object(), null);
            fail("content is not of type SimpleState, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
