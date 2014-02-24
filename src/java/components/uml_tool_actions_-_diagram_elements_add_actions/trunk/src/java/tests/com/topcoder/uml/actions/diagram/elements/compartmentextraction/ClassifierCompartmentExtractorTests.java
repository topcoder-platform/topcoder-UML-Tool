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
 * Unit test cases for ClassifierCompartmentExtractor.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClassifierCompartmentExtractorTests extends TestCase {
    /**
     * <p>
     * ClassifierCompartmentExtractor instance for testing.
     * </p>
     */
    private ClassifierCompartmentExtractor extractor;

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
        node = TestHelper.createGraphNodeForClassifier();

        extractor = new ClassifierCompartmentExtractor(node);
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
        return new TestSuite(ClassifierCompartmentExtractorTests.class);
    }

    /**
     * <p>
     * Tests ctor ClassifierCompartmentExtractor#ClassifierCompartmentExtractor(GraphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created ClassifierCompartmentExtractor instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ClassifierCompartmentExtractor instance.", extractor);
    }

    /**
     * <p>
     * Tests ctor ClassifierCompartmentExtractor#ClassifierCompartmentExtractor(GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when classifier is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullClassifier() {
        try {
            new ClassifierCompartmentExtractor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#extractAttribute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractAttribute is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractAttribute() throws Exception {
        GraphElement element = (GraphElement) node.getContaineds().get(2);

        assertSame("The attribute compartment should be extracted correctly.", element, extractor.extractAttribute());
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#extractAttribute() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractAttribute_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) node.getContaineds().get(2);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.extractAttribute();
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#extractAttribute() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractAttribute_CompartmentNotFoundException() throws Exception {
        node.clearContaineds();

        try {
            extractor.extractAttribute();
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#updateAttribute(GraphElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : UpdateAttribute is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateAttribute() throws Exception {
        GraphElement newElement = getAttributeNodeForUpdate();

        extractor.updateAttribute(newElement);

        assertSame("The attribute compartment should be updated.", newElement, extractor.extractAttribute());
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#updateAttribute(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateAttribute_NullNewElement() throws Exception {
        try {
            extractor.updateAttribute(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#updateAttribute(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is invalid and expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateAttribute_InvalidNewElement() throws Exception {
        GraphElement element = new GraphNode();
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.updateAttribute(element);
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#updateAttribute(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateAttribute_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) node.getContaineds().get(2);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.updateAttribute(getAttributeNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#updateAttribute(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateAttribute_CompartmentNotFoundException() throws Exception {
        node.clearContaineds();

        try {
            extractor.updateAttribute(getAttributeNodeForUpdate());
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#extractOperation() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractOperation is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractOperation() throws Exception {
        GraphElement element = (GraphElement) node.getContaineds().get(4);

        assertSame("The operation compartment should be extracted correctly.", element, extractor.extractOperation());
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#extractOperation() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractOperation_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) node.getContaineds().get(4);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.extractOperation();
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#extractOperation() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractOperation_CompartmentNotFoundException() throws Exception {
        node.clearContaineds();

        try {
            extractor.extractOperation();
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#updateOperation(GraphElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : UpdateOperation is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateOperation() throws Exception {
        GraphElement newElement = getOperationNodeForUpdate();

        extractor.updateOperation(newElement);

        assertSame("The operation compartment should be udpated.", newElement, extractor.extractOperation());
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#updateOperation(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateOperation_NullNewElement() throws Exception {
        try {
            extractor.updateOperation(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#updateOperation(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is invalid and expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateOperation_InvalidNewElement() throws Exception {
        GraphElement element = new GraphNode();
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.updateOperation(element);
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#updateOperation(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateOperation_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) node.getContaineds().get(4);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.updateOperation(getOperationNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassifierCompartmentExtractor#updateOperation(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateOperation_CompartmentNotFoundException() throws Exception {
        node.clearContaineds();
        try {
            extractor.updateOperation(getOperationNodeForUpdate());
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Creates a new GraphNode instance for name compartment to update.
     * </p>
     *
     * @return a new GraphNode instance for name compartment to update.
     */
    private GraphNode getAttributeNodeForUpdate() {
        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(TestHelper.createSimpleSemanticModel("AttributeCompartment"));

        return nameNode;
    }

    /**
     * <p>
     * Creates a new GraphNode instance for stereotype compartment to update.
     * </p>
     *
     * @return a new GraphNode instance for stereotype compartment to update.
     */
    private GraphNode getOperationNodeForUpdate() {
        GraphNode stereotypeNode = new GraphNode();
        stereotypeNode.setSemanticModel(TestHelper.createSimpleSemanticModel("OperationCompartment"));

        return stereotypeNode;
    }
}