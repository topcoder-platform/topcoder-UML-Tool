/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import junit.framework.TestCase;

import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>AbstractAuxiliaryUndoableAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AbstractAuxiliaryUndoableActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>DummyAbstractAuxiliaryUndoableAction</code> used in this test.
     * </p>
     */
    private DummyAbstractAuxiliaryUndoableAction action;

    /**
     * <p>
     * Set up environment.
     * </p>
     */
    public void setUp() {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
        this.action = new DummyAbstractAuxiliaryUndoableAction("Action");
    }

    /**
     * <p>
     * Clear the environment.
     * </p>
     */
    public void tearDown() {
        UnitTestHelper.clearConfig();
    }
    /**
     * <p>
     * Test constructor <code>AbstractAuxiliaryUndoableAction(String name)</code> for
     * failure with null name, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullName() {
        try {
            new DummyAbstractAuxiliaryUndoableAction(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AbstractAuxiliaryUndoableAction(String name)</code> for
     * failure with empty name, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_EmptyName() {
        try {
            new DummyAbstractAuxiliaryUndoableAction("  ");
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AbstractAuxiliaryUndoableAction(String name)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create action!",
                new DummyAbstractAuxiliaryUndoableAction("Action"));
    }


    /**
     * <p>
     * Test method <code>redo()</code> for accuracy.
     * </p>
     * @throws ActionExecutionException to JUnit
     */
    public void testRedo() throws ActionExecutionException {
        // execute the action
        this.action.execute();
        assertTrue("The action should be executed.", this.action.isExecuted());
        // undo the action
        this.action.undo();
        assertFalse("The action should be undone.", this.action.isExecuted());
        // redo the action
        this.action.redo();
        assertTrue("The action should be redone.", this.action.isExecuted());
    }

    /**
     * <p>
     * Test method <code>logException(String message, Throwable exception)</code>
     * for failure with null exception, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testLogException_NullException() {
        try {
            this.action.logException("message", null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>logException(String message, Throwable exception)</code>
     * accuracy.
     * </p>
     */
    public void testLogException_Accuracy() {
        this.action.logException("Message", new Exception());
    }

    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect presentation name!", "Action", this.action.getPresentationName());
    }

    /**
     * <p>
     * Dummy implementation of <code>AbstractAuxiliaryUndoableAction</code>,
     * it is used for testing.
     * </p>
     * @version 1.0
     * @author TCSDEVELOPER
     */
    private static final class DummyAbstractAuxiliaryUndoableAction extends AbstractAuxiliaryUndoableAction {
        /**
         * <p>
         * Indicates if this action is executed or not.
         * </p>
         */
        private boolean isExecuted = false;
        /**
         * <p>
         * Create a new <code>DummyAbstractAuxiliaryUndoableAction</code>.
         * </p>
         * @param name the representation name of this action.
         * @throws IllegalArgumentException If name is null or empty string.
         */
        public DummyAbstractAuxiliaryUndoableAction(String name) {
            super(name);
        }

        /**
         * <p>
         * Execute the action.
         * </p>
         * @throws ActionExecutionException Never throw this exception.
         */
        public void execute() throws ActionExecutionException {
            this.isExecuted = true;
        }

        /**
         * <p>
         * Undo the action.
         * </p>
         */
        public void undo() {
            super.undo();
            this.isExecuted = false;
        }
        /**
         * <p>
         * Return if the action is executed or not.
         * </p>
         * @return if the action is executed or not.
         */
        public boolean isExecuted() {
            return this.isExecuted;
        }
    }
}
