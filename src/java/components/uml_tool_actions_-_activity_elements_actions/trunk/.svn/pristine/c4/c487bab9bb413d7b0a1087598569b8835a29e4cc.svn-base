/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AddTransitionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddTransitionActionTests extends TestCase {

    /**
     * <p>
     * The AddTransitionAction instance for testing.
     * </p>
     */
    private AddTransitionAction action;

    /**
     * <p>
     * The Transition instance for testing.
     * </p>
     */
    private Transition transition;

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

        transition = new TransitionImpl();
        transition.setStateMachine(new StateMachineImpl());
        activityGraph = new ActivityGraphImpl();
        manager = TestHelper.setUpModelManager();

        action = new AddTransitionAction(transition, activityGraph, manager);
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
        transition = null;

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
        return new TestSuite(AddTransitionActionTests.class);
    }

    /**
     * <p>
     * Tests ctor AddTransitionAction#AddTransitionAction(Transition,ActivityGraph,UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created AddTransitionAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AddTransitionAction instance.", action);
        assertTrue("The state should be formatted.", transition.isSpecification());
    }

    /**
     * <p>
     * Tests ctor AddTransitionAction#AddTransitionAction(Transition,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transition is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullTransition() {
        try {
            new AddTransitionAction(null, activityGraph, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddTransitionAction#AddTransitionAction(Transition,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when activityGraph is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullActivityGraph() {
        try {
            new AddTransitionAction(transition, null, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddTransitionAction#AddTransitionAction(Transition,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when manager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullManager() {
        try {
            new AddTransitionAction(transition, activityGraph, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddTransitionAction#AddTransitionAction(Transition,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when ProjectConfigurationException occurs and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_ProjectConfigurationException() {
        System.setProperty("exception", "ProjectConfigurationException");
        try {
            new AddTransitionAction(transition, activityGraph, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        } finally {
            System.clearProperty("exception");
        }
    }

    /**
     * <p>
     * Tests AddTransitionAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Undo is correct and remove the transition.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndo() throws Exception {
        action.execute();
        action.undo();
        assertFalse("Failed to undo correct and remove the transition.", activityGraph.containsTransition(transition));
    }

    /**
     * <p>
     * Tests AddTransitionAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when the transition not exist and this method should
     * ignore it.
     * </p>
     */
    public void testUndo_NoExistTransition() {

        // In this case, the transition not exist
        // The undo() method should ignore it
        action.undo();

    }

    /**
     * <p>
     * Tests AddTransitionAction#undo() for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the action can not be undo and expects CannotUndoException.
     * </p>
     */
    public void testUndo_CannotUndoException() {
        action.undo();
        try {
            action.undo();
            fail("CannotUndoException expected.");
        } catch (CannotUndoException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests AddTransitionAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Execute is correct and add the transition.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        action.execute();
        assertTrue("Failed to execute correct and add the transition.", activityGraph.containsTransition(transition));
    }

}