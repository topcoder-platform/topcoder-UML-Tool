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
 * Unit test cases for DefaultEdgeCompartmentExtractor.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultEdgeCompartmentExtractorTests extends TestCase {
    /**
     * <p>
     * DefaultEdgeCompartmentExtractor instance for testing.
     * </p>
     */
    private DefaultEdgeCompartmentExtractor extractor;

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
        edge = TestHelper.createGraphEdgeForDefaultEdge();

        extractor = new DefaultEdgeCompartmentExtractor(edge);
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
        return new TestSuite(DefaultEdgeCompartmentExtractorTests.class);
    }

    /**
     * <p>
     * Tests ctor DefaultEdgeCompartmentExtractor#DefaultEdgeCompartmentExtractor(GraphEdge) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created DefaultEdgeCompartmentExtractor instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new DefaultEdgeCompartmentExtractor instance.", extractor);
    }

    /**
     * <p>
     * Tests ctor DefaultEdgeCompartmentExtractor#DefaultEdgeCompartmentExtractor(GraphEdge) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when edge is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullEdge() {
        try {
            new DefaultEdgeCompartmentExtractor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DefaultEdgeCompartmentExtractor#extractName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractName is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractName() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(1);

        assertSame("The name compartment should be extracted correctly.", element, extractor.extractName());
    }

    /**
     * <p>
     * Tests DefaultEdgeCompartmentExtractor#extractName() for failure.
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
     * Tests DefaultEdgeCompartmentExtractor#updateName(GraphElement) for accuracy.
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
     * Tests DefaultEdgeCompartmentExtractor#updateName(GraphElement) for failure.
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
     * Tests DefaultEdgeCompartmentExtractor#updateName(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is null and expects CompartmentMalformedException.
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
     * Tests DefaultEdgeCompartmentExtractor#updateName(GraphElement) for failure.
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
     * Tests DefaultEdgeCompartmentExtractor#extractStereotype() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractStereotype is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractStereotype() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(0);

        assertSame("The stereotype compartment should be extracted correctly.", element, extractor.extractStereotype());
    }

    /**
     * <p>
     * Tests DefaultEdgeCompartmentExtractor#extractStereotype() for failure.
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
     * Tests DefaultEdgeCompartmentExtractor#updateStereotype(GraphElement) for accuracy.
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
     * Tests DefaultEdgeCompartmentExtractor#updateStereotype(GraphElement) for failure.
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
     * Tests DefaultEdgeCompartmentExtractor#updateStereotype(GraphElement) for failure.
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
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests DefaultEdgeCompartmentExtractor#updateStereotype(GraphElement) for failure.
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