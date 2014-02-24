/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.ChangeEntityNameAction;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

/**
 * Accuracy test cases for UndoableAbstractAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class UndoableAbstractActionAccuracyTest extends TestCase {
    /**
     * <p>
     * This is a mock class which extends from <code>UndoableAbstractAction</code>. This class is
     * only used in accuracy test.
     * </p>
     */
    private class MockACUndoableAbstractAction extends UndoableAbstractAction {
        /**
         * <p>
         * Default constructor, call super().
         * </p>
         *
         * @param presentationName the not-null, not-empty string representing the presentation name
         * @throws IllegalArgumentException if presentationName is null or empty
         */
        public MockACUndoableAbstractAction(String presentationName) {
            super(presentationName);
        }

        /**
         * <p>
         * Re-apply the edit, assuming that it has been undone.
         * </p>
         */
        public void redoAction() {
        }

        /**
         * <p>
         * Undo the edit that was made.
         * </p>
         */
        public void undoAction() {
        }

        /**
         * <p>
         * Execute this auction.
         * </p>
         *
         * @throws ActionExecutionException if the action have already been executed or it is thrown
         *             by the executeAction
         */
        public void executeAction() throws ActionExecutionException {
        }
    }

    /**
     * Instance of MockACUndoableAbstractAction used in this test.
     */
    private MockACUndoableAbstractAction instance;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        AccuracyHelper.loadDefaultConfig();
        instance = new MockACUndoableAbstractAction("TEST");
    }

    /**
     * Clear the environment.
     */
    protected void tearDown() {
        AccuracyHelper.unloadConfig();
    }

    /**
     * Test constructor.
     */
    public void testUndoableAbstractAction() {
        assertEquals("presentationName is incorrect", "TEST", instance.getPresentationName());
    }

    /**
     * Test addEdit(UndoableEdit).
     */
    public void testAddEdit() {
        assertFalse("addEdit should return false.", instance.addEdit(null));
    }

    /**
     * Test canRedo().
     *
     * @throws Exception exception to JUnit.
     */
    public void testCanRedo() throws Exception {
        instance.execute();
        assertFalse("canRedo() is incorrect.", instance.canRedo());
        instance.undo();
        assertTrue("canRedo() is incorrect.", instance.canRedo());
    }

    /**
     * Test canUndo().
     *
     * @throws Exception exception to JUnit.
     */
    public void testCanUndo() throws Exception {
        instance.execute();
        assertTrue("canUndo() is incorrect.", instance.canUndo());
        instance.undo();
        assertFalse("canUndo() is incorrect.", instance.canUndo());
    }

    /**
     * Test die().
     */
    public void testDie() {
        instance.die();
        assertFalse("die() is incorrect.", instance.canRedo());
        assertFalse("die() is incorrect.", instance.canRedo());
    }

    /**
     * Test getPresentationName().
     */
    public void testGetPresentationName() {
        assertEquals("getPresentationName is incorrect", "TEST", instance.getPresentationName());
    }

    /**
     * Test getRedoPresentationName().
     */
    public void testGetRedoPresentationName() {
        assertEquals("getRedoPresentationName is incorrect", "Redo TEST", instance
            .getRedoPresentationName());
    }

    /**
     * Test getUndoPresentationName().
     */
    public void testGetUndoPresentationName() {
        assertEquals("getUndoPresentationName is incorrect", "Undo TEST", instance
            .getUndoPresentationName());
    }

    /**
     * Test isSignificant().
     */
    public void testIsSignificant() {
        assertTrue("isSignificant() is incorrect.", instance.isSignificant());
    }

    /**
     * Test replaceEdit(UndoableEdit).
     */
    public void testReplaceEdit() {
        assertFalse("replaceEdit should return false.", instance.replaceEdit(null));
    }

    /**
     * Accuracy test for the method <code>log(String)</code>.
     */
    public void testLogString() {
        instance.log("message");
    }

    /**
     * Test logError(String).
     */
    public void testLogError() {
        instance.logError("test error");
    }

    /**
     * Test log(Level, String).
     */
    public void testLogLevelString() {
        instance.log(Level.INFO, "test level log");
    }

    /**
     * Test redo().
     *
     * @throws Exception exception to JUnit.
     */
    public void testUndo() throws Exception {
        ModelElement element = new OperationImpl();
        element.setName("oldName");
        ChangeEntityNameAction instance2 = new ChangeEntityNameAction(element, "newName");
        instance2.execute();
        instance2.undo();
        assertEquals("undo() is incorrect.", "oldName", element.getName());
    }

    /**
     * Test undo().
     *
     * @throws Exception exception to JUnit.
     */
    public void testRedo() throws Exception {
        ModelElement element = new OperationImpl();
        element.setName("oldName");
        ChangeEntityNameAction instance2 = new ChangeEntityNameAction(element, "newName");
        instance2.execute();
        instance2.undo();
        instance2.redo();
        assertEquals("redo() is incorrect.", "newName", element.getName());
    }

    /**
     * Test execute().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecute() throws Exception {
        ModelElement element = new OperationImpl();
        element.setName("oldName");
        ChangeEntityNameAction instance2 = new ChangeEntityNameAction(element, "newName");
        instance2.execute();
        assertEquals("execute() is incorrect.", "newName", element.getName());
    }
}
