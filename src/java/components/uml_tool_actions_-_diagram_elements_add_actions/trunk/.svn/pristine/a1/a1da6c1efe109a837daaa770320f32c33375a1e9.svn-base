/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.MockCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AddRemoveOperationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddRemoveOperationActionTests extends TestCase {
    /**
     * <p>
     * AddRemoveOperationAction instance for testing.
     * </p>
     */
    private AddRemoveOperationAction action;

    /**
     * <p>
     * MockCompartmentExtractor instance for helping testing.
     * </p>
     */
    private MockCompartmentExtractor extractor;

    /**
     * <p>
     * GraphNode instance for helping testing.
     * </p>
     */
    private GraphNode operation;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        // set up the MockCompartmentExtractor for testing
        extractor = new MockCompartmentExtractor();
        GraphElement element = new GraphNode();
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("OperationCompartment"));
        GraphElement delimitedElement = new GraphNode();
        delimitedElement.setSemanticModel(TestHelper.createSimpleSemanticModel("DelimitedSection"));
        element.addContained(delimitedElement);
        delimitedElement.setContainer(element);
        extractor.setGraphElement(element);

        operation = new GraphNode();

        action = (AddRemoveOperationAction) AddRemoveOperationAction.createAddOperationAction(extractor, operation);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        extractor = null;
        operation = null;
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
        return new TestSuite(AddRemoveOperationActionTests.class);
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#executeRemove() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The operation should be removed.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecuteRemove() throws Exception {
        GraphElement element = (GraphElement) extractor.getGraphElement().getContaineds().get(0);
        element.addContained(operation);

        action.executeRemove();

        assertFalse("The attribute should be removed.", element.containsContained(operation));
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#executeRemove() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the extractor throws CompartmentNotSupportedException and
     * expects ActionExecutionException.
     * </p>
     *
     */
    public void testExecuteRemove_CompartmentNotSupportedException() {
        System.setProperty("exception", "CompartmentNotSupportedException");

        try {
            action.executeRemove();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#executeRemove() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the extractor throws CompartmentNotFoundException and
     * expects ActionExecutionException.
     * </p>
     *
     */
    public void testExecuteRemove_CompartmentNotFoundException() {
        System.setProperty("exception", "CompartmentNotFoundException");

        try {
            action.executeRemove();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#executeRemove() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the extractor throws CompartmentMalformedException and
     * expects ActionExecutionException.
     * </p>
     *
     */
    public void testExecuteRemove_CompartmentMalformedException() {
        System.setProperty("exception", "CompartmentMalformedException");

        try {
            action.executeRemove();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#executeAdd() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The operation should be added.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecuteAdd() throws Exception {
        GraphElement element = (GraphElement) extractor.getGraphElement().getContaineds().get(0);

        action.executeAdd();

        assertTrue("The attribute should be added.", element.containsContained(operation));
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#executeAdd() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the extractor throws CompartmentNotSupportedException and
     * expects ActionExecutionException.
     * </p>
     *
     */
    public void testExecuteAdd_CompartmentNotSupportedException() {
        System.setProperty("exception", "CompartmentNotSupportedException");

        try {
            action.executeAdd();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#executeAdd() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the extractor throws CompartmentNotFoundException and
     * expects ActionExecutionException.
     * </p>
     *
     */
    public void testExecuteAdd_CompartmentNotFoundException() {
        System.setProperty("exception", "CompartmentNotFoundException");

        try {
            action.executeAdd();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#executeAdd() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the extractor throws CompartmentMalformedException and
     * expects ActionExecutionException.
     * </p>
     *
     */
    public void testExecuteAdd_CompartmentMalformedException() {
        System.setProperty("exception", "CompartmentMalformedException");

        try {
            action.executeAdd();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#createRemoveOperationAction(CompartmentExtractor,GraphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created AddRemoveOperationAction instance should not be null.
     * </p>
     */
    public void testCreateRemoveOperationAction() {
        assertNotNull("Failed to create a remove operation action.",
            AddRemoveOperationAction.createRemoveOperationAction(extractor, new GraphNode()));
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#createRemoveOperationAction(CompartmentExtractor,GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when extractor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateRemoveOperationAction_NullExtractor() {
        try {
            AddRemoveOperationAction.createRemoveOperationAction(null, operation);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#createRemoveOperationAction(CompartmentExtractor,GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when operation is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateRemoveOperationAction_NullOperation() {
        try {
            AddRemoveOperationAction.createRemoveOperationAction(extractor, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#createAddOperationAction(CompartmentExtractor,GraphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created AddRemoveOperationAction instance should not be null.
     * </p>
     */
    public void testCreateAddOperationAction() {
        assertNotNull("Failed to create a remove operation action.", AddRemoveOperationAction.createAddOperationAction(
            extractor, new GraphNode()));
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#createAddOperationAction(CompartmentExtractor,GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when extractor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateAddOperationAction_NullExtractor() {
        try {
            AddRemoveOperationAction.createAddOperationAction(null, operation);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddRemoveOperationAction#createAddOperationAction(CompartmentExtractor,GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when operation is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateAddOperationAction_NullOperation() {
        try {
            AddRemoveOperationAction.createAddOperationAction(extractor, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}