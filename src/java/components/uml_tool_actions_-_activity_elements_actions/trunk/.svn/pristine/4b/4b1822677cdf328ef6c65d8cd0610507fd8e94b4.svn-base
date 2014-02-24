/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.MockedStateVertex;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>AddStateNodeAbstractAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class AddStateNodeAbstractActionFailureTest extends TestCase {

    /**
     * <p>
     * The name.
     * </p>
     */
    private String name = "name";

    /**
     * <p>
     * The StateVertex instance created for testing.
     * </p>
     */
    private StateVertex state;

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
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
        state = new MockedStateVertex(name);
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
     * Failure test for
     * <code>AddStateNodeAbstractAction(String name, StateVertex state,
     *  ActivityGraph activityGraph, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * name is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStateNodeAbstractActionNullName() {
        try {
            new MockedAddStateNodeAbstractAction(null, state, activityGraph, manager);
            fail("name is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>AddStateNodeAbstractAction(String name, StateVertex state,
     *  ActivityGraph activityGraph, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * name is empty, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStateNodeAbstractActionEmptyName() {
        try {
            new MockedAddStateNodeAbstractAction(" ", state, activityGraph, manager);
            fail("name is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>AddStateNodeAbstractAction(String name, StateVertex state,
     *  ActivityGraph activityGraph, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStateNodeAbstractActionNullState() {
        try {
            new MockedAddStateNodeAbstractAction(name, null, activityGraph, manager);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>AddStateNodeAbstractAction(String name, StateVertex state,
     *  ActivityGraph activityGraph, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * activityGraph is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStateNodeAbstractActionNullActivityGraph() {
        try {
            new MockedAddStateNodeAbstractAction(name, state, null, manager);
            fail("activityGraph is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>AddStateNodeAbstractAction(String name, StateVertex state,
     * ActivityGraph activityGraph, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * manager is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStateNodeAbstractActionNullManager() {
        try {
            new MockedAddStateNodeAbstractAction(name, state, activityGraph, null);
            fail("manager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

}
