/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.TestHelper;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ActivityStateCompartmentExtractor.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActivityStateCompartmentExtractorTests extends TestCase {
    /**
     * <p>
     * ActivityStateCompartmentExtractor instance for testing.
     * </p>
     */
    private ActivityStateCompartmentExtractor extractor;

    /**
     * <p>
     * GraphNode instance for helping testing.
     * </p>
     */
    private GraphNode node;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        node = TestHelper.createGraphNodeForActivityState();
        extractor = new ActivityStateCompartmentExtractor(node);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        node = null;
        extractor = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ActivityStateCompartmentExtractorTests.class);
    }

    /**
     * <p>
     * Tests ctor ActivityStateCompartmentExtractor#ActivityStateCompartmentExtractor(GraphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created ActivityStateCompartmentExtractor instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ActivityStateCompartmentExtractor instance.", extractor);
    }

    /**
     * <p>
     * Tests ctor ActivityStateCompartmentExtractor#ActivityStateCompartmentExtractor(GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when node is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNode() {
        try {
            new ActivityStateCompartmentExtractor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityStateCompartmentExtractor#extractName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractName is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractName() throws Exception {
        GraphElement element = (GraphElement) node.getContaineds().get(0);
        element = (GraphElement) element.getContaineds().get(0);
        element = (GraphElement) element.getContaineds().get(0);

        assertSame("The name compartment should be extracted correctly.", element, extractor.extractName());
    }

    /**
     * <p>
     * Tests ActivityStateCompartmentExtractor#extractName() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractName_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) node.getContaineds().get(0);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Other"));

        try {
            extractor.extractName();
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityStateCompartmentExtractor#extractName() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractName_CompartmentNotFoundException() throws Exception {
        node.clearContaineds();

        try {
            extractor.extractName();
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityStateCompartmentExtractor#updateName(GraphElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : UpdateName is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateName() throws Exception {
        GraphElement newElement = getNameNodeForUpdate();

        extractor.updateName(newElement);

        assertSame("The name compartment should be updated.", newElement, extractor.extractName());
    }

    /**
     * <p>
     * Tests ActivityStateCompartmentExtractor#updateName(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateName_NullNewElement() throws Exception {
        try {
            extractor.updateName(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityStateCompartmentExtractor#updateName(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is invalid and expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateName_InvalidNewElement() throws Exception {
        GraphElement newElement = new GraphNode();
        newElement.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.updateName(newElement);
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityStateCompartmentExtractor#updateName(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateName_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) node.getContaineds().get(0);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Other"));

        try {
            extractor.updateName(getNameNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityStateCompartmentExtractor#updateName(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateName_CompartmentNotFoundException() throws Exception {
        node.clearContaineds();

        try {
            extractor.updateName(getNameNodeForUpdate());
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Creates a new GraphElement instance for name compartment to update.
     * </p>
     *
     * @return a new GraphElement instance for name compartment to update.
     */
    private GraphNode getNameNodeForUpdate() {
        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(TestHelper.createSimpleSemanticModel("Name"));

        return nameNode;
    }
}