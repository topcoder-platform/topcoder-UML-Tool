/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AddStateNodeAbstractAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddStateNodeAbstractActionTests extends TestCase {

    /**
     * <p>
     * The MockAddStateNodeAbstractAction instance for testing.
     * </p>
     */
    private MockAddStateNodeAbstractAction action;

    /**
     * <p>
     * The StateVertex instance for testing.
     * </p>
     */
    private StateVertex state;

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

        state = new SimpleStateImpl();
        state.setContainer(new CompositeStateImpl());
        activityGraph = new ActivityGraphImpl();
        CompositeState compositeState = new CompositeStateImpl();
        activityGraph.setTop(compositeState);
        manager = TestHelper.setUpModelManager();

        action = new MockAddStateNodeAbstractAction("add", state, activityGraph, manager);
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
        return new TestSuite(AddStateNodeAbstractActionTests.class);
    }

    /**
     * <p>
     * Tests ctor AddStateNodeAbstractAction#AddStateNodeAbstractAction
     * (String,StateVertex,ActivityGraph,UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created AddStateNodeAbstractAction
     * instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AddStateNodeAbstractAction instance.", action);
        assertTrue("The state should be formatted.", state.isSpecification());
    }

    /**
     * <p>
     * Tests ctor AddStateNodeAbstractAction#AddStateNodeAbstractAction
     * (String,StateVertex,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullName() {
        try {
            new MockAddStateNodeAbstractAction(null, state, activityGraph, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddStateNodeAbstractAction#AddStateNodeAbstractAction
     * (String,StateVertex,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyName() {
        try {
            new MockAddStateNodeAbstractAction(" ", state, activityGraph, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddStateNodeAbstractAction#AddStateNodeAbstractAction
     * (String,StateVertex,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new MockAddStateNodeAbstractAction("Add", null, activityGraph, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddStateNodeAbstractAction#AddStateNodeAbstractAction
     * (String,StateVertex,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when activityGraph is null
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullActivityGraph() {
        try {
            new MockAddStateNodeAbstractAction("Add", state, null, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddStateNodeAbstractAction#AddStateNodeAbstractAction
     * (String,StateVertex,ActivityGraph,UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when manager is null
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullManager() {
        try {
            new MockAddStateNodeAbstractAction("Add", state, activityGraph, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddStateNodeAbstractAction#AddStateNodeAbstractAction
     * (String,StateVertex,ActivityGraph,UMLModelManager) for failure.
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
            new MockAddStateNodeAbstractAction("Add", state, activityGraph, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        } finally {
            System.clearProperty("exception");
        }
    }

    /**
     * <p>
     * Tests AddStateNodeAbstractAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Undo action is executed correctly, and the state is removed.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testUndo() throws ActionExecutionException {
        action.execute();
        action.undo();
        assertFalse("Failed to execute undo action.", Util.getTop(activityGraph).containsSubVertex(state));
    }

    /**
     * <p>
     * Tests AddStateNodeAbstractAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when throws ActionExecutionException and this
     * method should caught it, log the exception and ignore it.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testUndo_CatchActionExecutionException() throws ActionExecutionException {
        action.execute();

        // set the environment throw ActionExecutionException
        Util.getTop(activityGraph).removeSubVertex(state);

        // In this case, the ActionExecutionException should be thrown
        // The undo() method should log the exception and ignore it
        // so, no exception should be thrown here
        action.undo();

    }

    /**
     * <p>
     * Tests AddStateNodeAbstractAction#undo() for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the action can not be
     * undo and expects CannotUndoException.
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
     * Tests AddStateNodeAbstractAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Execute is correct and add the sub vertex.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testExecute() throws ActionExecutionException {
        action.execute();
        assertTrue("Failed to add sub vertex.", Util.getTop(activityGraph).containsSubVertex(state));
        assertSame("The state machine should be set for the simple state.", activityGraph,
            ((SimpleState) state).getStateMachine());
    }

    /**
     * <p>
     * Tests AddStateNodeAbstractAction#execute() for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the top for activity graph is not set and
     * expects ActionExecutionException.
     * </p>
     */
    public void testExecute_ActionExecutionException() {
        activityGraph.setTop(null);
        try {
            action.execute();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }
}