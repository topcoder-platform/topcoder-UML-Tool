/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import javax.swing.undo.CannotRedoException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AbstractActivityUndoableAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AbstractActivityUndoableActionTests extends TestCase {

    /**
     * <p>
     * The MockAbstractActivityUndoableAction instance for testing.
     * </p>
     */
    private MockAbstractActivityUndoableAction action;

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
        action = new MockAbstractActivityUndoableAction("Add");
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
        return new TestSuite(AbstractActivityUndoableActionTests.class);
    }

    /**
     * <p>
     * Tests ctor AbstractActivityUndoableAction#AbstractActivityUndoableAction(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created AbstractActivityUndoableAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AbstractActivityUndoableAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor AbstractActivityUndoableAction#AbstractActivityUndoableAction(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullName() {
        try {
            new MockAbstractActivityUndoableAction(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AbstractActivityUndoableAction#AbstractActivityUndoableAction(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyName() {
        try {
            new MockAbstractActivityUndoableAction(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractActivityUndoableAction#logException(String,Throwable) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The message and exception stack information should be logged to the
     * System.out.
     * </p>
     */
    public void testLogException() {
        action.logException("message", new IllegalArgumentException("exception"));

        // No assertion here
        // The message and exception stack information should be logged to the System.out
    }

    /**
     * <p>
     * Tests AbstractActivityUndoableAction#logException(String,Throwable) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when message is null and expects success.
     * </p>
     */
    public void testLogException_NullMessage() {
        action.logException(null, new IllegalArgumentException("exception"));

        // No assertion here
        // The exception stack information should be logged to the System.out
    }

    /**
     * <p>
     * Tests AbstractActivityUndoableAction#logException(String,Throwable) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when message is empty and expects success.
     * </p>
     */
    public void testLogException_EmptyMessage() {
        action.logException(" ", new IllegalArgumentException("exception"));

        // No assertion here
        // The exception stack information should be logged to the System.out
    }

    /**
     * <p>
     * Tests AbstractActivityUndoableAction#logException(String,Throwable) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when exception is null and expects IllegalArgumentException.
     * </p>
     */
    public void testLogException_NullException() {
        try {
            action.logException("message", null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractActivityUndoableAction#getPresentationName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The return value should be correct.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("The return value is not correct.", "Add", action.getPresentationName());
    }

    /**
     * <p>
     * Tests AbstractActivityUndoableAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The redo action should be executed correctly.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedo() throws Exception {
        // set up the environment to make the action can be re-done
        action.execute();
        action.undo();

        action.redo();
        assertTrue("The redo action should be executed correctly.", action.getIsExecuted());
    }

    /**
     * <p>
     * Tests AbstractActivityUndoableAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when the execute() method throws ActionExecutionException and this method should
     * caught it, log the exception and ignore it.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedo_ActionExecutionException() throws Exception {
        // set up the environment to make the action can be re-done
        action.execute();
        action.undo();

        // set the environment to make the execute() method throw ActionExecutionException
        System.setProperty("exception", "ActionExecutionException");

        try {
            // In this case, the ActionExecutionException should be thrown by the execute() method
            // The redo() method should log the exception and ignore it
            // so, no exception should be thrown here
            action.redo();
        } finally {
            // clear the system property
            System.clearProperty("exception");
        }
    }

    /**
     * <p>
     * Tests AbstractActivityUndoableAction#redo() for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the action can not be re-don and expects CannotRedoException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedo_CannotRedoException() throws Exception {
        action.execute();

        try {
            action.redo();
            fail("CannotRedoException expected.");
        } catch (CannotRedoException e) {
            // good
        }
    }

}