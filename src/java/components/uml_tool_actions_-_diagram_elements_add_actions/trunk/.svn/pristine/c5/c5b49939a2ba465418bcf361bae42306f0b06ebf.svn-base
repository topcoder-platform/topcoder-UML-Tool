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
 * Unit test cases for AddRemoveAttributeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddRemoveAttributeActionTests extends TestCase {
    /**
     * <p>
     * AddRemoveAttributeAction instance for testing.
     * </p>
     */
    private AddRemoveAttributeAction action;

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
    private GraphNode attribute;

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
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("AttributeCompartment"));
        GraphElement delimitedElement = new GraphNode();
        delimitedElement.setSemanticModel(TestHelper.createSimpleSemanticModel("DelimitedSection"));
        element.addContained(delimitedElement);
        delimitedElement.setContainer(element);
        extractor.setGraphElement(element);

        attribute = new GraphNode();

        action = (AddRemoveAttributeAction) AddRemoveAttributeAction.createAddAttributeAction(extractor, attribute);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        extractor = null;
        attribute = null;
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
        return new TestSuite(AddRemoveAttributeActionTests.class);
    }

    /**
     * <p>
     * Tests AddRemoveAttributeAction#executeRemove() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The attribute should be removed.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecuteRemove() throws Exception {
        GraphElement element = (GraphElement) extractor.getGraphElement().getContaineds().get(0);
        element.addContained(attribute);

        action.executeRemove();

        assertFalse("The attribute should be removed.", element.containsContained(attribute));
    }

    /**
     * <p>
     * Tests AddRemoveAttributeAction#executeRemove() for failure.
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
     * Tests AddRemoveAttributeAction#executeRemove() for failure.
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
     * Tests AddRemoveAttributeAction#executeRemove() for failure.
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
     * Tests AddRemoveAttributeAction#executeAdd() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The attribute should be added.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecuteAdd() throws Exception {
        GraphElement element = (GraphElement) extractor.getGraphElement().getContaineds().get(0);

        action.executeAdd();

        assertTrue("The attribute should be added.", element.containsContained(attribute));
    }

    /**
     * <p>
     * Tests AddRemoveAttributeAction#executeAdd() for failure.
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
     * Tests AddRemoveAttributeAction#executeAdd() for failure.
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
     * Tests AddRemoveAttributeAction#executeAdd() for failure.
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
     * Tests AddRemoveAttributeAction#createRemoveAttributeAction(CompartmentExtractor,GraphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created AddRemoveAttributeAction instance should not be null.
     * </p>
     */
    public void testCreateRemoveAttributeAction() {
        assertNotNull("Failed to create a remove attribute action.",
            AddRemoveAttributeAction.createRemoveAttributeAction(extractor, new GraphNode()));
    }

    /**
     * <p>
     * Tests AddRemoveAttributeAction#createRemoveAttributeAction(CompartmentExtractor,GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when extractor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateRemoveAttributeAction_NullExtractor() {
        try {
            AddRemoveAttributeAction.createRemoveAttributeAction(null, new GraphNode());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddRemoveAttributeAction#createRemoveAttributeAction(CompartmentExtractor,GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when attribute is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateRemoveAttributeAction_NullAttribute() {
        try {
            AddRemoveAttributeAction.createRemoveAttributeAction(extractor, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddRemoveAttributeAction#createAddAttributeAction(CompartmentExtractor,GraphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created AddRemoveAttributeAction instance should not be null.
     * </p>
     */
    public void testCreateAddAttributeAction() {
        assertNotNull("Failed to create an add attribute action.", AddRemoveAttributeAction.createAddAttributeAction(
            extractor, new GraphNode()));
    }

    /**
     * <p>
     * Tests AddRemoveAttributeAction#createAddAttributeAction(CompartmentExtractor,GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when extractor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateAddAttributeAction_NullExtractor() {
        try {
            AddRemoveAttributeAction.createAddAttributeAction(null, new GraphNode());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddRemoveAttributeAction#createAddAttributeAction(CompartmentExtractor,GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when attribute is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateAddAttributeAction_NullAttribute() {
        try {
            AddRemoveAttributeAction.createAddAttributeAction(extractor, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}