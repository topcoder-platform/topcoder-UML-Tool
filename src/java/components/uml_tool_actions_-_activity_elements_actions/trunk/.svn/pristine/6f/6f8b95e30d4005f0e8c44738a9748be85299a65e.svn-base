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
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for PasteStateNodeAbstractAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteStateNodeAbstractActionTests extends TestCase {

    /**
     * <p>
     * The PasteStateNodeAbstractAction instance for testing.
     * </p>
     */
    private PasteStateNodeAbstractAction action;

    /**
     * <p>
     * The StateVertex instance for testing.
     * </p>
     */
    private StateVertex content;

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

        content = new SimpleStateImpl();
        activityGraph = new ActivityGraphImpl();
        CompositeState compositeState = new CompositeStateImpl();
        activityGraph.setTop(compositeState);
        action = new MockPasteStateNodeAbstractAction("Paste", content, activityGraph);
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
        return new TestSuite(PasteStateNodeAbstractActionTests.class);
    }

    /**
     * <p>
     * Tests ctor PasteStateNodeAbstractAction#PasteStateNodeAbstractAction(String,Object,ActivityGraph) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created PasteStateNodeAbstractAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new PasteStateNodeAbstractAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor PasteStateNodeAbstractAction#PasteStateNodeAbstractAction(String,Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullName() {
        try {
            new MockPasteStateNodeAbstractAction(null, content, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteStateNodeAbstractAction#PasteStateNodeAbstractAction(String,Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyName() {
        try {
            new MockPasteStateNodeAbstractAction(" ", content, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteStateNodeAbstractAction#PasteStateNodeAbstractAction(String,Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when content is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullContent() {
        try {
            new MockPasteStateNodeAbstractAction("Paste", null, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteStateNodeAbstractAction#PasteStateNodeAbstractAction(String,Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when activityGraph is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullActivityGraph() {
        try {
            new MockPasteStateNodeAbstractAction("Paste", content, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteStateNodeAbstractAction#PasteStateNodeAbstractAction(String,Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the content object is not of StateVertex
     * type and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_WrongType() {
        Transition transition = new TransitionImpl();
        try {
            new MockPasteStateNodeAbstractAction("Paste", transition, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests PasteStateNodeAbstractAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Undo is execute correctly, the sub vertex is removed.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testUndo() throws ActionExecutionException {
        action.execute();
        action.undo();
        assertFalse("Failed to execute the undo() method.", Util.getTop(activityGraph).containsSubVertex(content));
    }

    /**
     * <p>
     * Tests PasteStateNodeAbstractAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when throws ActionExecutionException and this method should
     * caught it, log the exception and ignore it.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testUndo_CatchActionExecutionException() throws ActionExecutionException {
        action.execute();

        // set the environment throw ActionExecutionException
        activityGraph.setTop(null);

        // In this case, the ActionExecutionException should be thrown
        // The undo() method should log the exception and ignore it
        // so, no exception should be thrown here
        action.undo();

    }

    /**
     * <p>
     * Tests PasteStateNodeAbstractAction#undo() for failure.
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
     * Tests PasteStateNodeAbstractAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Execute is executed correctly, the sub vertex is added.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testExecute() throws ActionExecutionException {
        action.execute();
        assertTrue("Failed to execute the Executed() method.", Util.getTop(activityGraph).containsSubVertex(content));
        assertSame("The state machine should be set for the simple state.", activityGraph,
            ((SimpleState) content).getStateMachine());
    }

    /**
     * <p>
     * Tests PasteStateNodeAbstractAction#execute() for failure.
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