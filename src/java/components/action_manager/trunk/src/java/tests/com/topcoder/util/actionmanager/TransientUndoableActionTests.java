/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for TransientUndoableAction.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class TransientUndoableActionTests extends TestCase {
    /**
     * <p>
     * TransientUndoableAction instance for testing.
     * </p>
     */
    private TransientUndoableAction action;

    /**
     * <p>
     * The original TransientAction for helping testing.
     * </p>
     */
    private PrintClassDiagramAction originalAction;

    /**
     * <p>
     * The Logger instance for helping testing.
     * </p>
     */
    private MyLogger logger;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        originalAction = new PrintClassDiagramAction();
        action = new TransientUndoableAction(originalAction, "TransientUndoableAction");
        logger = new MyLogger("MyLogger");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        originalAction = null;
        action = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(TransientUndoableActionTests.class);
    }

    /**
     * <p>
     * Tests ctor TransientUndoableAction#TransientUndoableAction(TransientAction,String,Log) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created TransientUndoableAction instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new TransientUndoableAction instance.", new TransientUndoableAction(
            originalAction, "PresentationName", logger));
    }

    /**
     * <p>
     * Tests ctor TransientUndoableAction#TransientUndoableAction(TransientAction,String,Log) for failure.
     * It tests the case that when originalAction is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullOriginalAction() {
        try {
            new TransientUndoableAction(null, "PresentationName", logger);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor TransientUndoableAction#TransientUndoableAction(TransientAction,String,Log) for failure.
     * It tests the case that when presentationName is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullPresentationName() {
        try {
            new TransientUndoableAction(originalAction, null, logger);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor TransientUndoableAction#TransientUndoableAction(TransientAction,String,Log) for failure.
     * It tests the case that when presentationName is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyPresentationName() {
        try {
            new TransientUndoableAction(originalAction, " ", logger);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor TransientUndoableAction#TransientUndoableAction(TransientAction,String,Log) for failure.
     * It tests the case that when logger is null and expects success.
     * </p>
     */
    public void testCtor1_NullLogger() {
        assertNotNull("No exception should be thrown when the logger is null.", new TransientUndoableAction(
            originalAction, "PresentationName", null));
    }

    /**
     * <p>
     * Tests ctor TransientUndoableAction#TransientUndoableAction(TransientAction,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created TransientUndoableAction instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new TransientUndoableAction instance.", new TransientUndoableAction(
            originalAction, "PresentationName"));
    }

    /**
     * <p>
     * Tests ctor TransientUndoableAction#TransientUndoableAction(TransientAction,String) for failure.
     * It tests the case that when originalAction is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullOriginalAction() {
        try {
            new TransientUndoableAction(null, "PresentationName");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor TransientUndoableAction#TransientUndoableAction(TransientAction,String) for failure.
     * It tests the case that when presentationName is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullPresentationName() {
        try {
            new TransientUndoableAction(originalAction, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor TransientUndoableAction#TransientUndoableAction(TransientAction,String) for failure.
     * It tests the case that when presentationName is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_EmptyPresentationName() {
        try {
            new TransientUndoableAction(originalAction, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests TransientUndoableAction#getLastException() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the default value for lastException should be null.
     * </p>
     */
    public void testGetLastException() {
        assertNull("The default value should be null.", action.getLastException());
    }

    /**
     * <p>
     * Tests TransientUndoableAction#getLastException() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the exception thrown in the last method invoked should be stored.
     * </p>
     */
    public void testGetLastException2() {
        action.die();
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            // ignored
        }

        assertNotNull("The exception thrown by execute() should be stored.", action.getLastException());
    }

    /**
     * <p>
     * Tests TransientUndoableAction#addEdit(UndoableEdit) for accuracy.
     * </p>
     *
     * <p>
     * Verify : false should be returned.
     * </p>
     */
    public void testAddEdit() {
        assertFalse("Expects the false value be returned.", action.addEdit(new MockUndoableEdit()));
    }

    /**
     * <p>
     * Tests TransientUndoableAction#addEdit(UndoableEdit) for accuracy.
     * It tests the case that when edit is null and expects false.
     * </p>
     */
    public void testAddEdit_NullEdit() {
        assertFalse("Expects the false value should be returned.", action.addEdit(null));
    }

    /**
     * <p>
     * Tests TransientUndoableAction#canRedo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : true should be returned.
     * </p>
     */
    public void testCanRedoForTrue() {
        assertTrue("Expects the false value should be returned.", action.canRedo());
    }

    /**
     * <p>
     * Tests TransientUndoableAction#canRedo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : false should be returned.
     * </p>
     */
    public void testCanRedoForFalse() {
        action.die();
        assertFalse("Expects the false value should be returned.", action.canRedo());
    }

    /**
     * <p>
     * Tests TransientUndoableAction#canUndo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : true should be returned.
     * </p>
     */
    public void testCanUndoForTrue() {
        assertTrue("Expects the true value should be returned.", action.canUndo());
    }

    /**
     * <p>
     * Tests TransientUndoableAction#canUndo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : false should be returned.
     * </p>
     */
    public void testCanUndoForFalse() {
        action.die();
        assertFalse("Expects the false value should be returned.", action.canUndo());
    }

    /**
     * <p>
     * Tests TransientUndoableAction#die() for accuracy.
     * </p>
     *
     * <p>
     * If the die() method has been called, then the execute() method should throw ActionExecutionException.
     * </p>
     */
    public void testDie() {
        action.die();

        try {
            action.execute();
            fail("Expects ActionExecutionException.");
        } catch (ActionExecutionException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests TransientUndoableAction#getPresentationName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the presentation name should be correct.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Expects equal presentation name.", "TransientUndoableAction", action.getPresentationName());
    }

    /**
     * <p>
     * Tests TransientUndoableAction#getRedoPresentationName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the redo presentation name should be correct.
     * </p>
     */
    public void testGetRedoPresentationName() {
        assertEquals("Expects equal redo presentation name.", "Redo: TransientUndoableAction",
            action.getRedoPresentationName());
    }

    /**
     * <p>
     * Tests TransientUndoableAction#getUndoPresentationName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the undo presentation name should be correct.
     * </p>
     */
    public void testGetUndoPresentationName() {
        assertEquals("Expects equal undo presentation name.", "Undo: TransientUndoableAction",
            action.getUndoPresentationName());
    }

    /**
     * <p>
     * Tests TransientUndoableAction#isSignificant() for accuracy.
     * </p>
     *
     * <p>
     * Verify : false should be returned.
     * </p>
     */
    public void testIsSignificant() {
        assertFalse("Expects false.", action.isSignificant());
    }

    /**
     * <p>
     * Tests TransientUndoableAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The execute() method of the original action should be called.
     * </p>
     */
    public void testRedo() {
        action.redo();

        assertTrue("The execute() method of the original action should be called.", originalAction.isExecuted());
    }

    /**
     * <p>
     * Tests TransientUndoableAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the die() method has been called and expects no exception should be thrown
     * from redo() method.
     * </p>
     */
    public void testRedo2() {
        action.die();

        // though the die() method has been called, no exception should be thrown when invoking redo() method.
        action.redo();
    }

    /**
     * <p>
     * Tests TransientUndoableAction#replaceEdit(UndoableEdit) for accuracy.
     * </p>
     *
     * <p>
     * Verify : false should be returned.
     * </p>
     */
    public void testReplaceEdit() {
        assertFalse("Expects false.", action.replaceEdit(new MockUndoableEdit()));
    }

    /**
     * <p>
     * Tests TransientUndoableAction#replaceEdit(UndoableEdit) for accuracy.
     * It tests the case that when edit is null and expects false.
     * </p>
     */
    public void testReplaceEdit_NullEdit() {
        assertFalse("Expects false.", action.replaceEdit(null));
    }

    /**
     * <p>
     * Tests TransientUndoableAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * Note, this method to be tested is empty and so no assertion here.
     * </p>
     */
    public void testUndo() {
        // note, this method is empty and so no assertion here.
        action.undo();
    }

    /**
     * <p>
     * Tests TransientUndoableAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The execute() method of the original action should be called.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        action.execute();

        assertTrue("The execute() method of the original action should be called.", originalAction.isExecuted());
    }

    /**
     * <p>
     * Tests TransientUndoableAction#execute() for failure.
     * It tests the case when die() method is invoked already and expects ActionExecutionException.
     * </p>
     */
    public void testExecute_ActionExecutionException() {
        action.die();
        try {
            action.execute();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests TransientUndoableAction#execute() for failure.
     * It tests the case when the wrapped action throws exception and expects ActionExecutionException.
     * </p>
     */
    public void testExecute_ActionExecutionException2() {
        System.setProperty("execute", "exception");
        try {
            action.execute();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        } finally {
            System.clearProperty("execute");
        }
    }
}