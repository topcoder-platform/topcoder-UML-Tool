/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.actions.diagram.elements.MockCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AddRemoveAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddRemoveActionTests extends TestCase {
    /**
     * <p>
     * AddRemoveAction instance for testing.
     * </p>
     */
    private MockAddRemoveAction action;

    /**
     * <p>
     * CompartmentExtractor instance for helping testing.
     * </p>
     */
    private CompartmentExtractor extractor;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        extractor = new MockCompartmentExtractor();
        action = new MockAddRemoveAction(extractor, "ValueToRemove", true);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        extractor = null;
        action = null;
        System.clearProperty("exception");
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(AddRemoveActionTests.class);
    }

    /**
     * <p>
     * Tests ctor AddRemoveAction#AddRemoveAction(CompartmentExtractor,Object,boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created AddRemoveAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AddRemoveAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor AddRemoveAction#AddRemoveAction(CompartmentExtractor,Object,boolean) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when obj is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullObj() {
        try {
            new MockAddRemoveAction(extractor, null, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddRemoveAction#AddRemoveAction(CompartmentExtractor,Object,boolean) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when extractor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullExtractor() {
        try {
            new MockAddRemoveAction(null, "value", true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddRemoveAction#isRemoveAction() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The action should be a remove action.
     * </p>
     */
    public void testIsRemoveAction() {
        assertTrue("Expects true.", action.isRemoveAction());
    }

    /**
     * <p>
     * Tests AddRemoveAction#isRemoveAction() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The action should be an add action.
     * </p>
     */
    public void testIsRemoveAction2() {
        action = new MockAddRemoveAction(extractor, "ValueToAdd", false);

        assertFalse("Expects false.", action.isRemoveAction());
    }

    /**
     * <p>
     * Tests AddRemoveAction#setExecuteValue(Object) for accuracy.
     * </p>
     *
     * <p>
     * Verify : SetExecuteValue is correct.
     * </p>
     */
    public void testSetExecuteValue() {
        action.setExecuteValue(true);

        assertTrue("The value should be set correctly.", (Boolean) action.getExecuteValue());
    }

    /**
     * <p>
     * Tests AddRemoveAction#setExecuteValue(Object) for success.
     * </p>
     *
     * <p>
     * It tests the case that when executeValue is null and expects success.
     * </p>
     */
    public void testSetExecuteValue_NullExecuteValue() {
        // no exception
        action.setExecuteValue(null);
    }

    /**
     * <p>
     * Tests AddRemoveAction#getExecuteValue() for accuracy.
     * </p>
     *
     * <p>
     * Verify : getExecuteValue() is correct.
     * </p>
     */
    public void testGetExecuteValue() {
        assertEquals("Failed to get correct value.", "ValueToRemove", action.getExecuteValue());
    }

    /**
     * <p>
     * Tests AddRemoveAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action is a remove action and verifies redo() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedo() throws Exception {
        action.execute();
        action.undo();
        action.reset();

        action.redo();

        assertTrue("The action should can be un-done.", action.canUndo());
        assertFalse("The action should can not be re-done.", action.canRedo());
        assertTrue("The remove action should be executed.", action.isRemoveActionExecuted());
        assertFalse("The add action should not be executed.", action.isAddActionExecuted());
    }

    /**
     * <p>
     * Tests AddRemoveAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action is an add action and verifies redo() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedo2() throws Exception {
        action = new MockAddRemoveAction(extractor, "ValueToAdd", false);
        action.execute();
        action.undo();
        action.reset();

        action.redo();

        assertTrue("The action should can be un-done.", action.canUndo());
        assertFalse("The action should can not be re-done.", action.canRedo());
        assertFalse("The remove action should not be executed.", action.isRemoveActionExecuted());
        assertTrue("The add action should be executed.", action.isAddActionExecuted());
    }

    /**
     * <p>
     * Tests AddRemoveAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when ActionExecutionException is caught and
     * expects it is saved to lastException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedo_ActionExecutionException() throws Exception {
        action.execute();
        action.undo();

        System.setProperty("exception", "ActionExecutionException");
        // no exception
        action.redo();

        assertNotNull("The lastException should be set.", action.getLastException());
    }

    /**
     * <p>
     * Tests AddRemoveAction#redo() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the action cannot be re-done and expects
     * CannotRedoException.
     * </p>
     */
    public void testRedo_CannotRedoException() {
        try {
            action.redo();
            fail("CannotRedoException expected.");
        } catch (CannotRedoException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests AddRemoveAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action is a remove action and verifies
     * undo() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndo() throws Exception {
        action.execute();
        action.reset();

        action.undo();

        assertTrue("The action should can be re-done.", action.canRedo());
        assertFalse("The action should can not be un-done.", action.canUndo());
        assertFalse("The remove action should not be executed.", action.isRemoveActionExecuted());
        assertTrue("The add action should be executed.", action.isAddActionExecuted());
    }

    /**
     * <p>
     * Tests AddRemoveAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action is an add action and verifies
     * undo() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndo2() throws Exception {
        action = new MockAddRemoveAction(extractor, "ValueToAdd", false);
        action.execute();
        action.reset();

        action.undo();

        assertTrue("The action should can be re-done.", action.canRedo());
        assertFalse("The action should can not be un-done.", action.canUndo());
        assertTrue("The remove action should be executed.", action.isRemoveActionExecuted());
        assertFalse("The add action should not be executed.", action.isAddActionExecuted());
    }

    /**
     * <p>
     * Tests AddRemoveAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when ActionExecutionException is caught and
     * expects it is saved to lastException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndo_ActionExecutionException() throws Exception {
        action.execute();

        System.setProperty("exception", "ActionExecutionException");
        // no exception
        action.undo();

        assertNotNull("The lastException should be set.", action.getLastException());
    }

    /**
     * <p>
     * Tests AddRemoveAction#undo() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the action cannot be re-done and expects
     * CannotUndoException.
     * </p>
     */
    public void testUndo_CannotUndoException() {
        try {
            action.undo();
            fail("CannotUndoException expected.");
        } catch (CannotUndoException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests AddRemoveAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action is a remove action and verifies
     * execute() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        action.execute();

        assertTrue("The action should can be un-done.", action.canUndo());
        assertTrue("The remove action should be executed.", action.isRemoveActionExecuted());
        assertFalse("The add action should not be executed.", action.isAddActionExecuted());
    }

    /**
     * <p>
     * Tests AddRemoveAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action is an add action and verifies
     * execute() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecute2() throws Exception {
        action = new MockAddRemoveAction(extractor, "ValueToAdd", false);
        action.execute();

        assertTrue("The action should can be un-do.", action.canUndo());
        assertFalse("The remove action should not be executed.", action.isRemoveActionExecuted());
        assertTrue("The add action should be executed.", action.isAddActionExecuted());
    }

    /**
     * <p>
     * Tests AddRemoveAction#execute() for failure.
     * </p>
     *
     * <p>
     * It tests the case when executeRemove() throws ActionExecutionException and
     * expects ActionExecutionException for this method too.
     * </p>
     */
    public void testExecute_ActionExecutionException() {
        System.setProperty("exception", "ActionExecutionException");

        try {
            action.execute();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * This class extends AddRemoveAction class and is used for testing AddRemoveAction.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    public class MockAddRemoveAction extends AddRemoveAction {
        /**
         * <p>
         * Flag to identify the remove action is executed.
         * </p>
         */
        private boolean isRemoveExecuted = false;

        /**
         * <p>
         * Flag to identify the add action is executed.
         * </p>
         */
        private boolean isAddExecuted = false;

        /**
         * <p>
         * Create a new MockAddRemoveAction instance with extractor and object to be added/removed.
         * </p>
         *
         * <p>
         * If isRemove is false then this class will represent Add Action, otherwise it will
         * represent RemoveAction.
         * </p>
         *
         * @param extractor compartment extractor to be used
         * @param obj object to be added/removed
         * @param isRemove false for add, true for remove
         *
         * @throws IllegalArgumentException if extractor is null
         */
        protected MockAddRemoveAction(CompartmentExtractor extractor, Object obj, boolean isRemove) {
            super(extractor, obj, isRemove);
        }

        /**
         * <p>
         * override the executeRemove() in super class.
         * </p>
         *
         * @throws ActionExecutionException if the value of system property
         * &quot;exception&quot; is &quot;ActionExecutionException&quot;
         */
        protected void executeRemove() throws ActionExecutionException {
            if ("ActionExecutionException".equals(System.getProperty("exception"))) {
                throw new ActionExecutionException("exception.");
            }

            isRemoveExecuted = true;
        }

        /**
         * <p>
         * override the executeAdd() in super class.
         * </p>
         *
         * @throws ActionExecutionException if the value of system property
         * &quot;exception&quot; is &quot;ActionExecutionException&quot;
         */
        protected void executeAdd() throws ActionExecutionException {
            if ("ActionExecutionException".equals(System.getProperty("exception"))) {
                throw new ActionExecutionException("exception.");
            }

            isAddExecuted = true;
        }

        /**
         * <p>
         * Show the remove action is executed or not.
         * </p>
         *
         * @return true if executeRemove() is invoked, false otherwise
         */
        public boolean isRemoveActionExecuted() {
            return isRemoveExecuted;
        }

        /**
         * <p>
         * Show the add action is executed or not.
         * </p>
         *
         * @return true if executeAdd() is invoked, false otherwise
         */
        public boolean isAddActionExecuted() {
            return isAddExecuted;
        }

        /**
         * <p>
         * Reset the two flags, isRemoveExecuted and isAddExecuted.
         * </p>
         */
        public void reset() {
            isRemoveExecuted = false;
            isAddExecuted = false;
        }
    }
}