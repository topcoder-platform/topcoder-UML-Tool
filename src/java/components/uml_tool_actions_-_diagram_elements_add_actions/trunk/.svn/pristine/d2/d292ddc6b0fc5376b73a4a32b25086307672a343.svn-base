/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.TestHelper;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for GeneralizationCompartmentExtractor.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GeneralizationCompartmentExtractorTests extends TestCase {
    /**
     * <p>
     * GeneralizationCompartmentExtractor instance for testing.
     * </p>
     */
    private GeneralizationCompartmentExtractor extractor;

    /**
     * <p>
     * GraphEdge instance for helping testing.
     * </p>
     */
    private GraphEdge edge;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        edge = TestHelper.createGraphEdgeForGeneralization();

        extractor = new GeneralizationCompartmentExtractor(edge);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        edge = null;
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
        return new TestSuite(GeneralizationCompartmentExtractorTests.class);
    }

    /**
     * <p>
     * Tests ctor GeneralizationCompartmentExtractor#GeneralizationCompartmentExtractor(GraphEdge) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created GeneralizationCompartmentExtractor instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new GeneralizationCompartmentExtractor instance.", extractor);
    }

    /**
     * <p>
     * Tests ctor GeneralizationCompartmentExtractor#GeneralizationCompartmentExtractor(GraphEdge) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when edge is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullEdge() {
        try {
            new GeneralizationCompartmentExtractor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests GeneralizationCompartmentExtractor#extractName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractName is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractName() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(0);
        element = (GraphElement) element.getContaineds().get(0);

        assertSame("The name compartment should be extracted correctly.", element, extractor.extractName());
    }

    /**
     * <p>
     * Tests GeneralizationCompartmentExtractor#extractName() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractName_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(0);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.extractName();
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GeneralizationCompartmentExtractor#extractName() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractName_CompartmentNotFoundException() throws Exception {
        edge.clearContaineds();

        try {
            extractor.extractName();
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GeneralizationCompartmentExtractor#updateName(GraphElement) for accuracy.
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
     * Tests GeneralizationCompartmentExtractor#updateName(GraphElement) for failure.
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
     * Tests GeneralizationCompartmentExtractor#updateName(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is invalid and expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateName_InvalidNewElement() throws Exception {
        try {
            extractor.updateName(getStereotypeNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GeneralizationCompartmentExtractor#updateName(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateName_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(0);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.updateName(getNameNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GeneralizationCompartmentExtractor#updateName(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateName_CompartmentNotFoundException() throws Exception {
        edge.clearContaineds();

        try {
            extractor.updateName(getNameNodeForUpdate());
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GeneralizationCompartmentExtractor#extractStereotype() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractStereotype is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractStereotype() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(1);

        assertSame("The stereotype compartment should be extracted correctly.", element, extractor.extractStereotype());
    }

    /**
     * <p>
     * Tests GeneralizationCompartmentExtractor#extractStereotype() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractStereotype_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(1);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.extractStereotype();
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GeneralizationCompartmentExtractor#extractStereotype() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractStereotype_CompartmentNotFoundException() throws Exception {
        edge.clearContaineds();

        try {
            extractor.extractStereotype();
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GeneralizationCompartmentExtractor#updateStereotype(GraphElement) for accuracy.
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

        assertSame("The stereotype compartment should be updated.", newElement, extractor.extractStereotype());
    }

    /**
     * <p>
     * Tests GeneralizationCompartmentExtractor#updateStereotype(GraphElement) for failure.
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
     * Tests GeneralizationCompartmentExtractor#updateStereotype(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is invalid and expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateStereotype_InvalidNewElement() throws Exception {
        try {
            extractor.updateStereotype(getNameNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests GeneralizationCompartmentExtractor#updateStereotype(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateStereotype_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(1);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.updateStereotype(getStereotypeNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests GeneralizationCompartmentExtractor#updateStereotype(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateStereotype_CompartmentNotFoundException() throws Exception {
        edge.clearContaineds();

        try {
            extractor.updateStereotype(getStereotypeNodeForUpdate());
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
    private GraphNode getNameNodeForUpdate() {
        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(TestHelper.createSimpleSemanticModel("Name"));

        return nameNode;
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