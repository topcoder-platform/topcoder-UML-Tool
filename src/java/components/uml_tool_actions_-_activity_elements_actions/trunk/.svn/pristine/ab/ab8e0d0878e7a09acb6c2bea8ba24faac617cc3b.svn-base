/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for RemoveStateNodeAbstractAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveStateNodeAbstractActionTests extends TestCase {

    /**
     * <p>
     * The RemoveStateNodeAbstractAction instance for testing.
     * </p>
     */
    private RemoveStateNodeAbstractAction action;

    /**
     * <p>
     * The StateVertex instance for testing.
     * </p>
     */
    private StateVertex state;

    /**
     * <p>
     * The CompositeState instance for testing.
     * </p>
     */
    private CompositeState container;

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

        state = new SimpleStateImpl();
        container = new CompositeStateImpl();
        state.setContainer(container);
        action = new MockRemoveStateNodeAbstractAction("Remove", state);
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
        container = null;
        state = null;

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
        return new TestSuite(RemoveStateNodeAbstractActionTests.class);
    }

    /**
     * <p>
     * Tests ctor RemoveStateNodeAbstractAction#RemoveStateNodeAbstractAction(String,StateVertex) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created RemoveStateNodeAbstractAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new RemoveStateNodeAbstractAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor RemoveStateNodeAbstractAction#RemoveStateNodeAbstractAction(String,StateVertex) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullName() {
        try {
            new MockRemoveStateNodeAbstractAction(null, state);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor RemoveStateNodeAbstractAction#RemoveStateNodeAbstractAction(String,StateVertex) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyName() {
        try {
            new MockRemoveStateNodeAbstractAction(" ", state);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor RemoveStateNodeAbstractAction#RemoveStateNodeAbstractAction(String,StateVertex) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new MockRemoveStateNodeAbstractAction("Remove", null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests RemoveStateNodeAbstractAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Undo action is executed correctly.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testUndo() throws ActionExecutionException {
        action.execute();
        action.undo();
        assertTrue("Failed to execute undo action.", container.containsSubVertex(state));
    }

    /**
     * <p>
     * Tests RemoveStateNodeAbstractAction#undo() for failure.
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
     * Tests RemoveStateNodeAbstractAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Execute is executed correctly, the sub vertex is removed.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testExecute() throws ActionExecutionException {
        action.execute();
        assertFalse("Failed to execute the Execute() method.", container.containsSubVertex(state));
    }
}