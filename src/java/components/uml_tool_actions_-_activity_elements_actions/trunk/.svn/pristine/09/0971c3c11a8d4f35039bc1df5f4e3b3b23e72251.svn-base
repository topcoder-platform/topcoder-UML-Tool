/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.AddSendSignalActionAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>AddSendSignalActionAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class AddSendSignalActionActionFailureTest extends TestCase {

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
     * The UMLModelManager instance created for testing.
     * </p>
     */
    private UMLModelManager manager;

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
        manager = new UMLModelManager();
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
     * Failure test for <code>AddSendSignalActionAction
     * (SimpleState state, ActivityGraph activityGraph, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddSendSignalActionActionNullState() {
        try {
            new AddSendSignalActionAction(null, activityGraph, manager);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>AddSendSignalActionAction
     * (SimpleState state, ActivityGraph activityGraph, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * activityGraph is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddSendSignalActionActionNullActivityGraph() {
        try {
            new AddSendSignalActionAction(state, (ActivityGraph) null, manager);
            fail("activityGraph is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>AddSendSignalActionAction
     * (SimpleState state, ActivityGraph activityGraph, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * manager is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddSendSignalActionActionNullManager() {
        try {
            new AddSendSignalActionAction(state, activityGraph, null);
            fail("manager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
