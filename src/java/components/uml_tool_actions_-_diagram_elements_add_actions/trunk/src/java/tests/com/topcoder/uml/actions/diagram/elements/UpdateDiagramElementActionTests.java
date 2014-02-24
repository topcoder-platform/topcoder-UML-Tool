/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for UpdateDiagramElementAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UpdateDiagramElementActionTests extends TestCase {
    /**
     * <p>
     * UpdateDiagramElementAction instance for testing.
     * </p>
     */
    private UpdateDiagramElementAction action;

    /**
     * <p>
     * CompartmentExtractor instance for helping testing.
     * </p>
     */
    private CompartmentExtractor extractor;

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
        extractor = new MockCompartmentExtractor();
        element = new GraphNode();

        action = new MockUpdateDiagramElementAction(extractor);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        extractor = null;
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
        return new TestSuite(UpdateDiagramElementActionTests.class);
    }

    /**
     * <p>
     * Tests ctor UpdateDiagramElementAction#UpdateDiagramElementAction(GraphElement,CompartmentExtractor) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created UpdateDiagramElementAction instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new UpdateDiagramElementAction instance.",
            new MockUpdateDiagramElementAction(null, extractor));
    }

    /**
     * <p>
     * Tests ctor UpdateDiagramElementAction#UpdateDiagramElementAction(GraphElement,CompartmentExtractor) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when both element and extractor are null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullElementNullExtractor() {
        try {
            new MockUpdateDiagramElementAction(null, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor UpdateDiagramElementAction#UpdateDiagramElementAction(GraphElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created UpdateDiagramElementAction instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new UpdateDiagramElementAction instance.",
            new MockUpdateDiagramElementAction(element));
    }

    /**
     * <p>
     * Tests ctor UpdateDiagramElementAction#UpdateDiagramElementAction(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullElement() {
        try {
            new MockUpdateDiagramElementAction((GraphElement) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor UpdateDiagramElementAction#UpdateDiagramElementAction(CompartmentExtractor) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created UpdateDiagramElementAction instance should not be null.
     * </p>
     */
    public void testCtor3() {
        assertNotNull("Failed to create a new UpdateDiagramElementAction instance.",
            new MockUpdateDiagramElementAction(extractor));
    }

    /**
     * <p>
     * Tests ctor UpdateDiagramElementAction#UpdateDiagramElementAction(CompartmentExtractor) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when extractor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor3_NullExtractor() {
        try {
            new MockUpdateDiagramElementAction((CompartmentExtractor) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UpdateDiagramElementAction#getExtractor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : getExtractor() is correct.
     * </p>
     */
    public void testGetExtractor() {
        assertSame("Failed to get correct extractor.", extractor, action.getExtractor());
    }

    /**
     * <p>
     * Tests UpdateDiagramElementAction#undo() for accuracy.
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
     * Tests UpdateDiagramElementAction#undo() for accuracy.
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
     * Tests UpdateDiagramElementAction#redo() for accuracy.
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
     * Tests UpdateDiagramElementAction#redo() for failure.
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
     * This class extends UpdateDiagramElementAction class and is used for testing UpdateDiagramElementAction.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    public class MockUpdateDiagramElementAction extends UpdateDiagramElementAction {
        /**
         * <p>
         * Constructor. Delegates to the corresponding super constructor.
         * </p>
         *
         * @param element graph element
         * @param extractor compartment extractor
         *
         * @throws IllegalArgumentException if both element and extractor are null
         */
        public MockUpdateDiagramElementAction(GraphElement element, CompartmentExtractor extractor) {
            super(element, extractor);
        }

        /**
         * <p>
         * Constructor. Delegates to the corresponding super constructor.
         * </p>
         *
         * @param element graph element
         *
         * @throws IllegalArgumentException if element is null
         */
        public MockUpdateDiagramElementAction(GraphElement element) {
            super(element);
        }

        /**
         * <p>
         * Constructor. Delegates to the corresponding super constructor.
         * </p>
         *
         * @param extractor compartment extractor
         *
         * @throws IllegalArgumentException if extractor is null
         */
        protected MockUpdateDiagramElementAction(CompartmentExtractor extractor) {
            super(extractor);
        }

        /**
         * <p>
         * Implements the execute() method in super class.
         * </p>
         */
        public void execute() {
            this.executionSuccess();
        }
    }
}