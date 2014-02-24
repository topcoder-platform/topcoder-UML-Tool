/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.MockCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for UpdateAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UpdateActionTests extends TestCase {
    /**
     * <p>
     * UpdateAction instance for testing.
     * </p>
     */
    private UpdateAction action;

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
        element.setVisible(false);

        action = new MockUpdateAction(element, true);
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
        return new TestSuite(UpdateActionTests.class);
    }

    /**
     * <p>
     * Tests ctor UpdateAction#UpdateAction(GraphElement,Object) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created UpdateAction instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new UpdateAction instance.", new MockUpdateAction(element, true));
    }

    /**
     * <p>
     * Tests ctor UpdateAction#UpdateAction(GraphElement,Object) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when value is null and expects success.
     * </p>
     */
    public void testCtor1_NullValue() {
        assertNotNull("Failed to create a new UpdateAction instance.", new MockUpdateAction(element, null));
    }

    /**
     * <p>
     * Tests ctor UpdateAction#UpdateAction(GraphElement,Object) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullElement() {
        try {
            new MockUpdateAction((GraphElement) null, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor UpdateAction#UpdateAction(GraphElement,CompartmentExtractor,Object) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created UpdateAction instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new UpdateAction instance.", new MockUpdateAction(element,
            new MockCompartmentExtractor(), true));
    }

    /**
     * <p>
     * Tests ctor UpdateAction#UpdateAction(GraphElement,CompartmentExtractor,Object) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when value is null and expects success.
     * </p>
     */
    public void testCtor2_NullValue() {
        assertNotNull("Failed to create a new UpdateAction instance.", new MockUpdateAction(element,
            new MockCompartmentExtractor(), null));
    }

    /**
     * <p>
     * Tests ctor UpdateAction#UpdateAction(GraphElement,CompartmentExtractor,Object) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when both element and extractor are null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullElementNullExtractor() {
        try {
            new MockUpdateAction(null, null, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor UpdateAction#UpdateAction(CompartmentExtractor,Object) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created UpdateAction instance should not be null.
     * </p>
     */
    public void testCtor3() {
        assertNotNull("Failed to create a new UpdateAction instance.", new MockUpdateAction(
            new MockCompartmentExtractor(), true));
    }

    /**
     * <p>
     * Tests ctor UpdateAction#UpdateAction(CompartmentExtractor,Object) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when value is null and expects success.
     * </p>
     */
    public void testCtor3_NullValue() {
        assertNotNull("Failed to create a new UpdateAction instance.", new MockUpdateAction(
            new MockCompartmentExtractor(), null));
    }

    /**
     * <p>
     * Tests ctor UpdateAction#UpdateAction(CompartmentExtractor,Object) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when extractor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor3_NullExtractor() {
        try {
            new MockUpdateAction((CompartmentExtractor) null, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UpdateAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : redo() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedo() throws Exception {
        action.execute();
        action.undo();

        action.redo();

        assertTrue("The action should be re-done.", element.isVisible());
    }

    /**
     * <p>
     * Tests UpdateAction#redo() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the action cannot be re-don and expects CannotRedoExcepiton.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedo_CannotRedoException() throws Exception {
        try {
            action.redo();
            fail("CannotRedoException expected.");
        } catch (CannotRedoException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests UpdateAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action throws ActionExecutionException and expects it
     * is stored to lastException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedo_ActionExecutionException() throws Exception {
        action.execute();
        action.undo();

        // set the exception condition
        System.setProperty("exception", "ActionExecutionException");

        // expects no exception
        action.redo();

        assertNotNull("The ActionExecutionException should be set to lastException.", action.getLastException());
    }

    /**
     * <p>
     * Tests UpdateAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : undo() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndo() throws Exception {
        action.execute();

        action.undo();

        assertFalse("The action should be un-done.", element.isVisible());
    }

    /**
     * <p>
     * Tests UpdateAction#undo() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the action cannot be un-done and expects CannotUndoExceptionl
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndo_CannotUndoException() throws Exception {
        try {
            action.undo();
            fail("CannotUndoException expected.");
        } catch (CannotUndoException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests UpdateAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action throws ActionExecutionException and expects it
     * is stored to lastException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndo_ActionExecutionException() throws Exception {
        action.execute();

        // set the exception condition
        System.setProperty("exception", "ActionExecutionException");

        // expects no exception
        action.undo();

        assertNotNull("The ActionExecutionException should be set to lastException.", action.getLastException());
    }

    /**
     * <p>
     * This class extends UpdateAction class and is used for testing UpdateAction.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    public class MockUpdateAction extends UpdateAction {
        /**
         * <p>
         * Create MockUpdateAction with given compartment extractor and new value to update.
         * </p>
         *
         * @param extractor compartment extractor to be used
         * @param value the new value to replace the old one
         *
         * @throws IllegalArgumentException if extractor argument is null
         */
        public MockUpdateAction(CompartmentExtractor extractor, Object value) {
            super(extractor, value);
        }

        /**
         * <p>
         * Create MockUpdateAction with given parent element and compartment
         * extractor and the new value to update the old one.
         * </p>
         *
         * @param element graph element to be updated
         * @param extractor compartment extractor to be used
         * @param value new value to replace the old one
         *
         * @throws IllegalArgumentException if both element and extractor are null
         */
        public MockUpdateAction(GraphElement element, CompartmentExtractor extractor, Object value) {
            super(element, extractor, value);
        }

        /**
         * <p>
         * Create MockUpdateAction with given parent element and new value to update.
         * </p>
         *
         * @param element graph element to be updated
         * @param value the new value to replace the old one
         *
         * @throws IllegalArgumentException if element argument is null
         */
        public MockUpdateAction(GraphElement element, Object value) {
            super(element, value);
        }

        /**
         * <p>
         * Implements the execute() method in super class.
         * </p>
         *
         * @throws ActionExecutionException if the value of system property
         * &quot;exception&quot; is &quot;ActionExecutionException&quot;
         */
        public void execute() throws ActionExecutionException {
            if ("ActionExecutionException".equals(System.getProperty("exception"))) {
                throw new ActionExecutionException("exception.");
            }

            element = this.getElement();
            if (element != null) {
                savedValue = element.isVisible();
                element.setVisible((Boolean) executeValue);
            }
            this.executionSuccess();
        }
    }

}