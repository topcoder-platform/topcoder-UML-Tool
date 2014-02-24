/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CompoundUndoableAction.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class CompoundUndoableActionTests extends TestCase {
    /**
     * <p>
     * CompoundUndoableAction instance for testing.
     * </p>
     */
    private CompoundUndoableAction action;

    /**
     * <p>
     * The Logger instance for helping testing.
     * </p>
     */
    private MyLogger logger;

    /**
     * <p>
     * The AddClassDiagramAction instance to be compound.
     * </p>
     */
    private AddClassDiagramAction actionToWrap;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        actionToWrap = new AddClassDiagramAction();
        action = new CompoundUndoableAction("CompoundUndoableAction");
        logger = new MyLogger("MyLogger");
        action.addEdit(actionToWrap);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        action = null;
        logger = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(CompoundUndoableActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CompoundUndoableAction#CompoundUndoableAction(String,Log) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CompoundUndoableAction instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new CompoundUndoableAction instance.", new CompoundUndoableAction(
            "PresentationName", logger));
    }

    /**
     * <p>
     * Tests ctor CompoundUndoableAction#CompoundUndoableAction(String,Log) for failure.
     * It tests the case that when presentationName is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullPresentationName() {
        try {
            new CompoundUndoableAction(null, logger);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CompoundUndoableAction#CompoundUndoableAction(String,Log) for failure.
     * It tests the case that when presentationName is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyPresentationName() {
        try {
            new CompoundUndoableAction(" ", logger);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CompoundUndoableAction#CompoundUndoableAction(String,Log) for accuracy.
     * It tests the case that when logger is null and expects success.
     * </p>
     */
    public void testCtor1_NullLogger() {
        assertNotNull("Failed to create a new CompoundUndoableAction instance.", new CompoundUndoableAction(
            "PresentationName", null));
    }

    /**
     * <p>
     * Tests ctor CompoundUndoableAction#CompoundUndoableAction(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CompoundUndoableAction instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new CompoundUndoableAction instance.", new CompoundUndoableAction(
            "PresentationName"));
    }

    /**
     * <p>
     * Tests ctor CompoundUndoableAction#CompoundUndoableAction(String) for failure.
     * It tests the case that when presentationName is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullPresentationName() {
        try {
            new CompoundUndoableAction(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CompoundUndoableAction#CompoundUndoableAction(String) for failure.
     * It tests the case that when presentationName is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_EmptyPresentationName() {
        try {
            new CompoundUndoableAction(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#getLastException() for accuracy.
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
     * Tests CompoundUndoableAction#getLastException() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the exception thrown in the last method should be stored.
     * </p>
     */
    public void testGetLastException2() {
        action.die();
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            // ignore
        }

        assertNotNull("The exception thrown by execute() should be stored.", action.getLastException());
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#addEdit(UndoableEdit) for accuracy.
     * </p>
     *
     * <p>
     * When the execute() method is not called, the addEdit() should return true, and after the execute()
     * method is called, then addEdit() should return false.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddEdit() throws Exception {
        AddClassMemberAction memberAction = new AddClassMemberAction();
        assertTrue("The memberAction should be added.", action.addEdit(memberAction));

        action.execute();
        // the execute method of memberAction should be invoked
        assertTrue("The execute method of memberAction should be invoked", memberAction.isExecuted());

        assertFalse("No edit can be added after invoking execute() method.", action.addEdit(new DeleteClassAction()));
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#addEdit(UndoableEdit) for failure.
     * It tests the case that when edit is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddEdit_NullEdit() {
        try {
            action.addEdit(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#addEdit(UndoableEdit) for failure.
     * It tests the case that when edit is not of UndoableAction type and expects IllegalArgumentException.
     * </p>
     */
    public void testAddEdit_OtherEdit() {
        try {
            action.addEdit(new MockUndoableEdit());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#canRedo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the canRedo() should return false after the action is executed and true after the action is un-done.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCanRedo() throws Exception {
        action.execute();

        assertFalse("Expects the action can not be re-done.", action.canRedo());

        action.undo();

        assertTrue("Expects the action can be re-done.", action.canRedo());
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#canUndo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the canUndo() should return true after the action is executed and false after the action is un-done.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCanUndo() throws Exception {
        action.execute();

        assertTrue("Expects the action can be un-done.", action.canUndo());

        action.undo();

        assertFalse("Expects the action can not be un-done.", action.canUndo());

    }

    /**
     * <p>
     * Tests CompoundUndoableAction#die() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the execute() method should throw exception after the die() method is called.
     * </p>
     */
    public void testDie() {
        action.die();

        // the execute() method should throw ActionExecutionException after the die() method is invoked.
        try {
            action.execute();
            fail("Expects ActionExecutionException.");
        } catch (ActionExecutionException e) {
            // ignore
        }
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#getPresentationName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the presentation name should be the correct one.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Expects correct presentation name.", "CompoundUndoableAction", action.getPresentationName());
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#getRedoPresentationName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the redo presentation name should be the correct one.
     * </p>
     */
    public void testGetRedoPresentationName() {
        assertEquals("Expects correct redo presentation name.", "Redo: CompoundUndoableAction",
            action.getRedoPresentationName());
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#getUndoPresentationName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the undo presentation name should be the correct one.
     * </p>
     */
    public void testGetUndoPresentationName() {
        assertEquals("Expects correct undo presentation name.", "Undo: CompoundUndoableAction",
            action.getUndoPresentationName());
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#isSignificant() for accuracy.
     * </p>
     *
     * <p>
     * Verify : if one of the actions contains returns true in its isSignificant(), then the CompoundUndoableAction
     * instance should return true, otherwise false.
     * </p>
     */
    public void testIsSignificant() {
        assertFalse("No significant edit is contained so expects false", action.isSignificant());

        action.addEdit(new AddClassMemberAction());

        assertTrue("Significant edit is contained so expects true.", action.isSignificant());
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The redo() method of the wrapped action should be called.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedo() throws Exception {
        action.execute();
        action.undo();
        action.redo();

        assertTrue("The redo() method of the wrapped action should be called.", actionToWrap.isRedoCalled());
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action can not be re-done and expects the exception be stored in the lastException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedoForException() throws Exception {
        action.execute();
        action.redo();

        assertNotNull("Exception should be thrown when invoking the redo() method.", action.getLastException());
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#replaceEdit(UndoableEdit) for accuracy.
     * </p>
     *
     * <p>
     * Verify : replaceEdit() is correct.
     * </p>
     */
    public void testReplaceEdit() {
        assertFalse("The replaceEdit() should return false.", action.replaceEdit(new AddClassMemberAction()));
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#replaceEdit(UndoableEdit) for failure.
     * It tests the case that when edit is null and expects IllegalArgumentException.
     * </p>
     */
    public void testReplaceEdit_NullEdit() {
        try {
            action.replaceEdit(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#replaceEdit(UndoableEdit) for failure.
     * It tests the case that when edit is not of UndoableAction type and expects IllegalArgumentException.
     * </p>
     */
    public void testReplaceEdit_OtherEdit() {
        try {
            action.replaceEdit(new MockUndoableEdit());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The undo() method of the wrapped action should be called.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndo() throws Exception {
        action.execute();
        action.undo();

        assertTrue("The undo() method of the wrapped action should be called.", actionToWrap.isUndoCalled());
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action can not be un-done and expects the exception be stored in the lastException.
     * </p>
     */
    public void testUndoForException() {
        action.redo();
        action.undo();

        assertNotNull("Exception should be thrown when invoking the undo() method.", action.getLastException());
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The execute() method of the wrapped action should be called.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        action.execute();

        assertTrue("The execute() method of the wrapped action should be called.", actionToWrap.isExecuted());
    }

    /**
     * <p>
     * Tests CompoundUndoableAction#execute() for failure.
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
     * Tests CompoundUndoableAction#execute() for failure.
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