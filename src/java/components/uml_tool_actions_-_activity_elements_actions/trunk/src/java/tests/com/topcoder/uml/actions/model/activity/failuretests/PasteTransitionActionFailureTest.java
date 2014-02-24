/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.MockedTransition;
import com.topcoder.uml.actions.model.activity.PasteTransitionAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * Failure test for <code>PasteTransitionAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class PasteTransitionActionFailureTest extends TestCase {
    /**
     * <p>
     * The Transition instance created for testing.
     * </p>
     */
    private Transition transition;

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
        transition = new MockedTransition("name");
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
     * <code>PasteTransitionAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteStateNodeAbstractActionNullState() {
        try {
            new PasteTransitionAction(null, activityGraph);
            fail("content is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteTransitionAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * activityGraph is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteStateNodeAbstractActionNullActivityGraph() {
        try {
            new PasteTransitionAction(transition, null);
            fail("activityGraph is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteTransitionAction(Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is not of type Transition, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteStateNodeAbstractActionInvalidObject() {
        try {
            new PasteTransitionAction(new Object(), null);
            fail("content is not of type Transition, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
