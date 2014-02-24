/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AddActionStateAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddActionStateActionTests extends TestCase {

    /**
     * <p>
     * The AddActionStateAction instance for testing.
     * </p>
     */
    private AddActionStateAction action;

    /**
     * <p>
     * The ActionState instance for testing.
     * </p>
     */
    private ActionState state;

    /**
     * <p>
     * The ActivityGraph instance for testing.
     * </p>
     */
    private ActivityGraph activityGraph;

    /**
     * <p>
     * The UMLModelManager instance for testing.
     * </p>
     */
    private UMLModelManager manager;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.configProjectConfiguration();

        state = new ActionStateImpl();
        state.setContainer(new CompositeStateImpl());
        activityGraph = new ActivityGraphImpl();
        manager = TestHelper.setUpModelManager();
        action = new AddActionStateAction(state, activityGraph, manager);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        action = null;
        manager = null;
        activityGraph = null;
        state = null;

        TestHelper.clearProjectConfiguration();
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(AddActionStateActionTests.class);
    }

    /**
     * <p>
     * Tests ctor AddActionStateAction#AddActionStateAction(ActionState,ActivityGraph,UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created AddActionStateAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AddActionStateAction instance.", action);
        assertTrue("The state should be formatted.", state.isSpecification());
    }

    /**
     * <p>
     * Tests ctor AddActionStateAction#AddActionStateAction(ActionState,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new AddActionStateAction(null, activityGraph, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddActionStateAction#AddActionStateAction(ActionState,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when activityGraph is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullActivityGraph() {
        try {
            new AddActionStateAction(state, null, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddActionStateAction#AddActionStateAction(ActionState,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when ProjectConfigurationException occurs and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_ProjectConfigurationException() {
        System.setProperty("exception", "ProjectConfigurationException");
        try {
            new AddActionStateAction(state, activityGraph, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        } finally {
            System.clearProperty("exception");
        }
    }

    /**
     * <p>
     * Tests ctor AddActionStateAction#AddActionStateAction(ActionState,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when manager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullManager() {
        try {
            new AddActionStateAction(state, activityGraph, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}