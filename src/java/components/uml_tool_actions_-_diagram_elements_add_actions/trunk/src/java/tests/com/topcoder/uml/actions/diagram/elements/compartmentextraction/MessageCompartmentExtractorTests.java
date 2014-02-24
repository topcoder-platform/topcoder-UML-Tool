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
 * Unit test cases for MessageCompartmentExtractor.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MessageCompartmentExtractorTests extends TestCase {
    /**
     * <p>
     * MessageCompartmentExtractor instance for testing.
     * </p>
     */
    private MessageCompartmentExtractor extractor;

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
        node = TestHelper.createGraphNodeForMessage();
        extractor = new MessageCompartmentExtractor(node);
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
        return new TestSuite(MessageCompartmentExtractorTests.class);
    }

    /**
     * <p>
     * Tests ctor MessageCompartmentExtractor#MessageCompartmentExtractor(GraphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created MessageCompartmentExtractor instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new MessageCompartmentExtractor instance.", extractor);
    }

    /**
     * <p>
     * Tests ctor MessageCompartmentExtractor#MessageCompartmentExtractor(GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when node is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNode() {
        try {
            new MessageCompartmentExtractor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests MessageCompartmentExtractor#extractStereotype() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractStereotype is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractStereotype() throws Exception {
        GraphElement element = (GraphElement) node.getContaineds().get(0);
        element = (GraphElement) element.getContaineds().get(0);

        assertEquals("Expects the stereotype compartment is extracted successfully.", element,
            extractor.extractStereotype());
    }

    /**
     * <p>
     * Tests MessageCompartmentExtractor#extractStereotype() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractStereotype_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) node.getContaineds().get(0);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Stimulus"));

        try {
            extractor.extractStereotype();
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests MessageCompartmentExtractor#extractStereotype() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractStereotype_CompartmentNotFoundException() throws Exception {
        node.clearContaineds();
        try {
            extractor.extractStereotype();
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests MessageCompartmentExtractor#updateStereotype(GraphElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : UpdateStereotype is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateStereotype() throws Exception {
        GraphElement newElement = getStereotypeNodeForUpdate();

        extractor.updateStereotype(newElement);

        assertEquals("The stereotype compartment should be updated.", newElement, extractor.extractStereotype());
    }

    /**
     * <p>
     * Tests MessageCompartmentExtractor#updateStereotype(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateStereotype_NullNewElement() throws Exception {
        try {
            extractor.updateStereotype(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests MessageCompartmentExtractor#updateStereotype(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is invalid and expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateStereotype_InvalidNewElement() throws Exception {
        GraphNode stereotypeNode = new GraphNode();
        stereotypeNode.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.updateStereotype(stereotypeNode);
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests MessageCompartmentExtractor#updateStereotype(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateStereotype_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) node.getContaineds().get(0);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Stimulus"));

        try {
            extractor.updateStereotype(getStereotypeNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests MessageCompartmentExtractor#updateStereotype(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateStereotype_CompartmentNotFoundException() throws Exception {
        node.clearContaineds();
        try {
            extractor.updateStereotype(getStereotypeNodeForUpdate());
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Creates a new GraphNode instance for stereotype compartment to update.
     * </p>
     *
     * @return a new GraphNode instance for stereotype compartment to update.
     */
    private GraphNode getStereotypeNodeForUpdate() {
        GraphNode stereotypeNode = new GraphNode();
        stereotypeNode.setSemanticModel(TestHelper.createSimpleSemanticModel("StereotypeCompartment"));

        return stereotypeNode;
    }

}