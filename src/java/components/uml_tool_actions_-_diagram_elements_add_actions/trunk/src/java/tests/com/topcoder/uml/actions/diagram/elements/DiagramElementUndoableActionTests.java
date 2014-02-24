/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for DiagramElementUndoableAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DiagramElementUndoableActionTests extends TestCase {
    /**
     * <p>
     * DiagramElementUndoableAction instance for testing.
     * </p>
     */
    private DiagramElementUndoableAction action;

    /**
     * <p>
     * GraphElement instance for helping testing.
     * </p>
     */
    private GraphElement element;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        element = new GraphNode();
        action = new MockDiagramElementUndoableAction(element);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        element = null;
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
        return new TestSuite(DiagramElementUndoableActionTests.class);
    }

    /**
     * <p>
     * Tests ctor DiagramElementUndoableAction#DiagramElementUndoableAction(GraphElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created DiagramElementUndoableAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new DiagramElementUndoableAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor DiagramElementUndoableAction#DiagramElementUndoableAction(GraphElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects success.
     * </p>
     */
    public void testCtor_NullElement() {
        assertNotNull("Failed to create a new DiagramElementUndoableAction instance.",
            new MockDiagramElementUndoableAction(null));
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#executionSuccess() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Expect the action can be un-done.
     * </p>
     */
    public void testExecutionSuccess() {
        action.executionSuccess();

        assertTrue("Expect the action can be un-done.", action.canUndo());
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#redoSuccess() for accuracy.
     * </p>
     *
     * <p>
     * Expect the action can be un-done and cannot be re-done.
     * </p>
     */
    public void testRedoSuccess() {
        action.redoSuccess();

        assertTrue("Expect the action can be un-done.", action.canUndo());
        assertFalse("Expect the action can not be re-done.", action.canRedo());
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#getLastException() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The default value should be null.
     * </p>
     */
    public void testGetLastException() {
        assertNull("Expects the lastException be null.", action.getLastException());
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#setLastException(ActionExecutionException) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The lastException should be set correctly.
     * </p>
     */
    public void testSetLastException() {
        ActionExecutionException e = new ActionExecutionException("error");
        action.setLastException(e);

        assertSame("Failed to set the lastException.", e, action.getLastException());
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#setLastException(ActionExecutionException) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when exception is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetLastException_NullException() {
        try {
            action.setLastException(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#undoSuccess() for accuracy.
     * </p>
     *
     * <p>
     * Expect the action can be re-done and cannot be un-done.
     * </p>
     */
    public void testUndoSuccess() {
        action.undoSuccess();

        assertTrue("Expects the action can be re-done", action.canRedo());
        assertFalse("Expects the action can not be un-done", action.canUndo());
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#getElement() for accuracy.
     * </p>
     *
     * <p>
     * Verify : getElement() is correct.
     * </p>
     */
    public void testGetElement() {
        assertSame("Failed to get the correct element", element, action.getElement());
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#canRedo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The action cannot be re-done initially.
     * </p>
     */
    public void testCanRedo() {
        assertFalse("The action cannot be re-done initially.", action.canRedo());
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#canUndo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The action cannot be un-done initially.
     * </p>
     */
    public void testCanUndo() {
        assertFalse("The action cannot be un-done initially.", action.canUndo());
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action can be uns-done and expects no exception.
     * </p>
     */
    public void testUndo() {
        action.executionSuccess();

        // no exception should be thrown
        action.undo();
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action can not be un-done and expects CannotUndoException.
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
     * Tests DiagramElementUndoableAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action can be re-done and expects no exception.
     * </p>
     */
    public void testRedo() {
        action.undoSuccess();

        // no exception should be thrown
        action.redo();
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#redo() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the action can not be re-done and expects CannotRedoException.
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
     * Tests DiagramElementUndoableAction#addEdit(UndoableEdit) for failure.
     * </p>
     *
     * <p>
     * Expects UnsupportedOperationException.
     * </p>
     */
    public void testAddEdit() {
        try {
            action.addEdit(null);
            fail("UnsupportedOperationException expected.");
        } catch (UnsupportedOperationException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#die() for failure.
     * </p>
     *
     * <p>
     * Expects UnsupportedOperationException.
     * </p>
     */
    public void testDie() {
        try {
            action.die();
            fail("UnsupportedOperationException expected.");
        } catch (UnsupportedOperationException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#getPresentationName() for failure.
     * </p>
     *
     * <p>
     * Expects UnsupportedOperationException.
     * </p>
     */
    public void testGetPresentationName() {
        try {
            action.getPresentationName();
            fail("UnsupportedOperationException expected.");
        } catch (UnsupportedOperationException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#getRedoPresentationName() for failure.
     * </p>
     *
     * <p>
     * Expects UnsupportedOperationException.
     * </p>
     */
    public void testGetRedoPresentationName() {
        try {
            action.getRedoPresentationName();
            fail("UnsupportedOperationException expected.");
        } catch (UnsupportedOperationException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#getUndoPresentationName() for failure.
     * </p>
     *
     * <p>
     * Expects UnsupportedOperationException.
     * </p>
     */
    public void testGetUndoPresentationName() {
        try {
            action.getUndoPresentationName();
            fail("UnsupportedOperationException expected.");
        } catch (UnsupportedOperationException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#isSignificant() for failure.
     * </p>
     *
     * <p>
     * Expects UnsupportedOperationException.
     * </p>
     */
    public void testIsSignificant() {
        try {
            action.isSignificant();
            fail("UnsupportedOperationException expected.");
        } catch (UnsupportedOperationException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DiagramElementUndoableAction#replaceEdit(UndoableEdit) for failure.
     * </p>
     *
     * <p>
     * Expects UnsupportedOperationException.
     * </p>
     */
    public void testReplaceEdit() {
        try {
            action.replaceEdit(null);
            fail("UnsupportedOperationException expected.");
        } catch (UnsupportedOperationException e) {
            // good
        }
    }

    /**
     * <p>
     * This class extends DiagramElementUndoableAction class and is used for testing DiagramElementUndoableAction class.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    public class MockDiagramElementUndoableAction extends DiagramElementUndoableAction {
        /**
         * <p>
         * Constructor with element specified.
         * </p>
         *
         * @param element graph element
         */
        protected MockDiagramElementUndoableAction(GraphElement element) {
            super(element);
        }

        /**
         * <p>
         * Implements the execute() in DiagramElementUndoableAction.
         * </p>
         */
        public void execute() {
        }
    }

}