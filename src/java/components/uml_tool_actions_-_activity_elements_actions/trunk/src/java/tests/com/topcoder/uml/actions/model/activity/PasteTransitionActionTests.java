/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for PasteTransitionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteTransitionActionTests extends TestCase {

    /**
     * <p>
     * The PasteTransitionAction instance for testing.
     * </p>
     */
    private PasteTransitionAction action;

    /**
     * <p>
     * The Transition instance for testing.
     * </p>
     */
    private Transition content;

    /**
     * <p>
     * The ActivityGraph instance for testing.
     * </p>
     */
    private ActivityGraph activityGraph;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);

        content = new TransitionImpl();
        activityGraph = new ActivityGraphImpl();
        action = new PasteTransitionAction(content, activityGraph);
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
        activityGraph = null;
        content = null;

        TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(PasteTransitionActionTests.class);
    }

    /**
     * <p>
     * Tests ctor PasteTransitionAction#PasteTransitionAction(Object,ActivityGraph) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created PasteTransitionAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new PasteTransitionAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor PasteTransitionAction#PasteTransitionAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when content is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullContent() {
        try {
            new PasteTransitionAction(null, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteTransitionAction#PasteTransitionAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when activityGraph is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullActivityGraph() {
        try {
            new PasteTransitionAction(content, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteTransitionAction#PasteTransitionAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the content object is not of Transition
     * type and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_WrongType() {
        StateVertex transition = new SimpleStateImpl();
        try {
            new PasteTransitionAction(transition, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PasteTransitionAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Execute is executed correctlyly, the transition is added.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testExecute() throws ActionExecutionException {
        action.execute();
        assertTrue("Failed to execute the Executed() method.", activityGraph.containsTransition(content));
    }

    /**
     * <p>
     * Tests PasteTransitionAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Undo is executed correctly, the transition is removed.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndo() throws Exception {
        action.execute();
        action.undo();
        assertFalse("Failed to execute the undo() method.", activityGraph.containsTransition(content));
    }

    /**
     * <p>
     * Tests PasteTransitionAction#undo() for failure.
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
}