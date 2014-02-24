/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AddMergeNodeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddMergeNodeActionTests extends TestCase {

    /**
     * <p>
     * The AddMergeNodeAction instance for testing.
     * </p>
     */
    private AddMergeNodeAction action;

    /**
     * <p>
     * The Pseudostate instance for testing.
     * </p>
     */
    private Pseudostate state;

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

        state = new PseudostateImpl();
        state.setKind(PseudostateKind.JUNCTION);
        state.setContainer(new CompositeStateImpl());
        activityGraph = new ActivityGraphImpl();
        manager = TestHelper.setUpModelManager();
        action = new AddMergeNodeAction(state, activityGraph, manager);
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
        return new TestSuite(AddMergeNodeActionTests.class);
    }

    /**
     * <p>
     * Tests ctor AddMergeNodeAction#AddMergeNodeAction(Pseudostate,ActivityGraph,UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created AddMergeNodeAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AddMergeNodeAction instance.", action);
        assertTrue("The state should be formatted.", state.isSpecification());
    }

    /**
     * <p>
     * Tests ctor AddMergeNodeAction#AddMergeNodeAction(Pseudostate,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new AddMergeNodeAction(null, activityGraph, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddMergeNodeAction#AddMergeNodeAction(Pseudostate,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when activityGraph is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullActivityGraph() {
        try {
            new AddMergeNodeAction(state, null, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddMergeNodeAction#AddMergeNodeAction(Pseudostate,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when manager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullManager() {
        try {
            new AddMergeNodeAction(state, activityGraph, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddMergeNodeAction#AddMergeNodeAction(Pseudostate,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when ProjectConfigurationException occurs and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_ProjectConfigurationException() {
        System.setProperty("exception", "ProjectConfigurationException");
        try {
            new AddMergeNodeAction(state, activityGraph, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        } finally {
            System.clearProperty("exception");
        }
    }

    /**
     * <p>
     * Tests ctor AddMergeNodeAction#AddMergeNodeAction(Pseudostate,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state kind attribute doesn't equal to
     * PseudostateKind.JUNCTION and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_WrongKind() {
        state = new PseudostateImpl();
        try {
            new AddMergeNodeAction(state, activityGraph, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}