/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the UndoableAbstractAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class UndoableAbstractActionUnitTests extends TestCase {
    /**
     * <p>
     * This is a mock class which extends from <code>UndoableAbstractAction</code>. This class is
     * only used in unit test.
     * </p>
     */
    private class UndoableAbstractActionMock extends UndoableAbstractAction {
        /**
         * <p>
         * Default constructor, call super().
         * </p>
         *
         * @param presentationName
         *        the non null, non empty string representing the presentation name
         * @throws IllegalArgumentException
         *         if presentationName is null or empty
         */
        public UndoableAbstractActionMock(String presentationName) {
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
         * @throws ActionExecutionException
         *         if the action have already been executed or it is thrown by the executeAction
         */
        public void executeAction() throws ActionExecutionException {
        }
    }

    /**
     * Represents the test action presentation name.
     */
    private static final String PRESENTATION_NAME = "test action";

    /**
     * Represents the UndoableAbstractAction instance used for tests.
     */
    private UndoableAbstractAction testUndoableAbstractAction;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        testUndoableAbstractAction = new UndoableAbstractActionMock(PRESENTATION_NAME);
    }

    /**
     * Test the constructor of UndoableAbstractAction.
     */
    public void testUndoableAbstractActionConstructor() {
        UndoableAbstractAction action = new UndoableAbstractActionMock("ABC");
        assertNotNull("Create UndoableAbstractAction incorrectly.", action);
        assertEquals("Create UndoableAbstractAction incorrectly.", "ABC", action.getPresentationName());
    }

    /**
     * Test the constructor of UndoableAbstractAction with null presentation name. Should throw
     * IllegalArgumentException.
     */
    public void testUndoableAbstractActionConstructorNull() {
        try {
            new UndoableAbstractActionMock(null);
            fail("IllegalArgumentException should be thrown when the passed presentation name is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor of UndoableAbstractAction with empty presentation name. Should throw
     * IllegalArgumentException.
     */
    public void testUndoableAbstractActionConstructorEmpty() {
        try {
            new UndoableAbstractActionMock(" ");
            fail("IllegalArgumentException should be thrown when the passed presentation name is empty.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>addEdit(UndoableEdit)</code>. It always return false.
     */
    public void testAddEdit() {
        assertFalse("addEdit should return false.", testUndoableAbstractAction.addEdit(null));
    }

    /**
     * Accuracy test for the method <code>canRedo()</code>.
     */
    public void testCanRedo() {
        UndoableAbstractAction action = new UndoableAbstractActionMock("Redo");
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            // success
        }
        assertFalse("The action can't redo.", action.canRedo());
        action.undo();
        assertTrue("The action can redo.", action.canRedo());
    }

    /**
     * Accuracy test for the method <code>canUndo()</code>.
     */
    public void testCanUndo() {
        UndoableAbstractAction action = new UndoableAbstractActionMock("Undo");
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            // success
        }
        assertTrue("The action can  undo.", action.canUndo());
        action.undo();
        assertFalse("The action can't undo.", action.canUndo());
    }

    /**
     * Accuracy test for the method <code>die()</code>.
     */
    public void testDie() {
        testUndoableAbstractAction.die();
    }

    /**
     * Accuracy test for the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertEquals("getPresentationName incorrectly", PRESENTATION_NAME, testUndoableAbstractAction
                .getPresentationName());
    }

    /**
     * Accuracy test for the method <code>getRedoPresentationName()</code>.
     */
    public void testGetRedoPresentationName() {
        assertEquals("getRedoPresentationName incorrectly", "Redo " + PRESENTATION_NAME, testUndoableAbstractAction
                .getRedoPresentationName());
    }

    /**
     * Accuracy test for the method <code>getUndoPresentationName()</code>.
     */
    public void testGetUndoPresentationName() {
        assertEquals("getUndoPresentationName incorrectly", "Undo " + PRESENTATION_NAME, testUndoableAbstractAction
                .getUndoPresentationName());
    }

    /**
     * Accuracy test for the method <code>isSignificant()</code>. It always return true.
     */
    public void testIsSignificant() {
        assertTrue("isSignificant should return true.", testUndoableAbstractAction.isSignificant());
    }

    /**
     * Accuracy test for the method <code>replaceEdit(UndoableEdit)</code>. It always return
     * false.
     */
    public void testReplaceEdit() {
        assertFalse("replaceEdit should return false.", testUndoableAbstractAction.replaceEdit(null));
    }

    /**
     * Accuracy test for the method <code>log(String)</code>.
     */
    public void testLogString() {
        testUndoableAbstractAction.log("message");
    }

    /**
     * Accuracy test for the method <code>logError(String)</code>.
     */
    public void testLogError() {
        testUndoableAbstractAction.logError("test error");
    }

    /**
     * Accuracy test for the method <code>log(Level, String)</code>.
     */
    public void testLogLevelString() {
        testUndoableAbstractAction.log(Level.INFO, "test level log");
    }

    /**
     * Test the method <code>log(Level, String)</code> with null level. Should throw
     * IllegalArgumentException.
     */
    public void testLogLevelStringNullLevel() {
        try {
            testUndoableAbstractAction.log(null, "test level log");
            fail("IllegalArgumentException should be thrown when the passed level is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>redo()</code>.
     */
    public void testRedo() {
        testUndoableAbstractAction.redo();
    }

    /**
     * Accuracy test for the method <code>undo()</code>.
     */
    public void testUndo() {
        testUndoableAbstractAction.undo();
    }

    /**
     * Accuracy test for the method <code>execute()</code>.
     */
    public void testExecute() {
        try {
            testUndoableAbstractAction.execute();
        } catch (ActionExecutionException e) {
            // success
        }
    }

    /**
     * Test invoking the method <code>execute()</code> twice. Should throw
     * ActionExecutionException.
     */
    public void testExecuteNotOneTime() {
        try {
            testUndoableAbstractAction.execute();
            testUndoableAbstractAction.execute();
            fail("ActionExecutionException should be thrown when execute() method is executed twice.");
        } catch (ActionExecutionException e) {
            // success
        }
    }
}
