/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.AddTransitionAction;
import com.topcoder.uml.actions.model.activity.MockedTransition;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>AddTransitionAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class AddTransitionActionFailureTest extends TestCase {
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
        transition = new MockedTransition("name");
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
     * Failure test for <code>AddTransitionAction
     * (Transition transition, ActivityGraph activityGraph, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * transition is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddTransitionActionNullTransition() {
        try {
            new AddTransitionAction(null, activityGraph, manager);
            fail("transition is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>AddTransitionAction
     * (Transition transition,ActivityGraph activityGraph,UMLModelManager manager)</code>.
     * </p>
     * <p>
     * activityGraph is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddDecisionNodeActionNullActivityGraph() {
        try {
            new AddTransitionAction(transition, (ActivityGraph) null, manager);
            fail("activityGraph is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>AddTransitionAction
     * (Transition transition,ActivityGraph activityGraph,UMLModelManager manager)</code>.
     * </p>
     * <p>
     * manager is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddActionStateActionNullManager() {
        try {
            new AddTransitionAction(transition, activityGraph, (UMLModelManager) null);
            fail("manager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
