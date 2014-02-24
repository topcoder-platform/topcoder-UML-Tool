/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.MockCompartmentExtractor;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for UpdateSecondAssociationEndAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UpdateSecondAssociationEndActionTests extends TestCase {
    /**
     * <p>
     * UpdateSecondAssociationEndAction instance for testing.
     * </p>
     */
    private UpdateSecondAssociationEndAction action;

    /**
     * <p>
     * GraphElement instance for helping testing.
     * </p>
     */
    private GraphElement newElement;

    /**
     * <p>
     * MockCompartmentExtractor instance for helping testing.
     * </p>
     */
    private MockCompartmentExtractor extractor;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        newElement = new GraphNode();
        extractor = new MockCompartmentExtractor();

        action = new UpdateSecondAssociationEndAction(extractor, newElement);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        newElement = null;
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
        return new TestSuite(UpdateSecondAssociationEndActionTests.class);
    }

    /**
     * <p>
     * Tests ctor UpdateSecondAssociationEndAction#UpdateSecondAssociationEndAction(
     * CompartmentExtractor,GraphElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created UpdateSecondAssociationEndAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new UpdateSecondAssociationEndAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor UpdateSecondAssociationEndAction#UpdateSecondAssociationEndAction(
     * CompartmentExtractor,GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when extractor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullExtractor() {
        try {
            new UpdateSecondAssociationEndAction(null, newElement);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor UpdateSecondAssociationEndAction#UpdateSecondAssociationEndAction(
     * CompartmentExtractor,GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newAssociationEnd is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNewAssociationEnd() {
        try {
            new UpdateSecondAssociationEndAction(extractor, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UpdateSecondAssociationEndAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The second association end is updated and the action can be un-done.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        action.execute();

        Diagram diagram = (Diagram) extractor.getGraphElement().getContainer();
        assertEquals("The first association end should be updated.", "updateSecondAssociationEnd", diagram.getName());
        assertTrue("The action should can be un-done.", action.canUndo());
    }

    /**
     * <p>
     * Tests UpdateSecondAssociationEndAction#execute() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the extractor throws CompartmentNotSupportedException
     * and expects ActionExecutionException.
     * </p>
     */
    public void testExecute_CompartmentNotSupportedException() {
        System.setProperty("exception", "CompartmentNotSupportedException");

        try {
            action.execute();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests UpdateSecondAssociationEndAction#execute() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the extractor throws CompartmentNotFoundException
     * and expects ActionExecutionException.
     * </p>
     */
    public void testExecute_CompartmentNotFoundException() {
        System.setProperty("exception", "CompartmentNotFoundException");

        try {
            action.execute();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests UpdateSecondAssociationEndAction#execute() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the extractor throws CompartmentMalformedException
     * and expects ActionExecutionException.
     * </p>
     */
    public void testExecute_CompartmentMalformedException() {
        System.setProperty("exception", "CompartmentMalformedException");

        try {
            action.execute();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }
}