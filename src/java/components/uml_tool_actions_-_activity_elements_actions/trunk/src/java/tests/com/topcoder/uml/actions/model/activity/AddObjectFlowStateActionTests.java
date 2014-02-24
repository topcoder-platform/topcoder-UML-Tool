/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AddObjectFlowStateAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddObjectFlowStateActionTests extends TestCase {

    /**
     * <p>
     * The AddObjectFlowStateAction instance for testing.
     * </p>
     */
    private AddObjectFlowStateAction action;

    /**
     * <p>
     * The ObjectFlowState instance for testing.
     * </p>
     */
    private ObjectFlowState state;

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

        state = new ObjectFlowStateImpl();
        state.setContainer(new CompositeStateImpl());
        activityGraph = new ActivityGraphImpl();
        manager = TestHelper.setUpModelManager();
        action = new AddObjectFlowStateAction(state, activityGraph, manager);
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
        return new TestSuite(AddObjectFlowStateActionTests.class);
    }

    /**
     * <p>
     * Tests ctor AddObjectFlowStateAction#AddObjectFlowStateAction
     * (ObjectFlowState,ActivityGraph,UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created AddObjectFlowStateAction
     * instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AddObjectFlowStateAction instance.", action);
        assertTrue("The state should be formatted.", state.isSpecification());
    }

    /**
     * <p>
     * Tests ctor AddObjectFlowStateAction#AddObjectFlowStateAction
     * (ObjectFlowState,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new AddObjectFlowStateAction(null, activityGraph, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddObjectFlowStateAction#AddObjectFlowStateAction
     * (ObjectFlowState,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when activityGraph is null
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullActivityGraph() {
        try {
            new AddObjectFlowStateAction(state, null, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddObjectFlowStateAction#AddObjectFlowStateAction
     * (ObjectFlowState,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when manager is null
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullManager() {
        try {
            new AddObjectFlowStateAction(state, activityGraph, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddObjectFlowStateAction#AddObjectFlowStateAction
     * (ObjectFlowState,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when ProjectConfigurationException
     * occurs and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_ProjectConfigurationException() {
        System.setProperty("exception", "ProjectConfigurationException");
        try {
            new AddObjectFlowStateAction(state, activityGraph, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        } finally {
            System.clearProperty("exception");
        }
    }
}