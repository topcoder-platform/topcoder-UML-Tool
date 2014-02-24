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
 * Unit test cases for ActivityNodeCompartmentExtractor.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActivityNodeCompartmentExtractorTests extends TestCase {
    /**
     * <p>
     * ActivityNodeCompartmentExtractor instance for testing.
     * </p>
     */
    private ActivityNodeCompartmentExtractor extractor;

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
        node = TestHelper.createGraphNodeForActivityNode();
        extractor = new ActivityNodeCompartmentExtractor(node);
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
        return new TestSuite(ActivityNodeCompartmentExtractorTests.class);
    }

    /**
     * <p>
     * Tests ctor ActivityNodeCompartmentExtractor#ActivityNodeCompartmentExtractor(GraphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created ActivityNodeCompartmentExtractor instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ActivityNodeCompartmentExtractor instance.", extractor);
    }

    /**
     * <p>
     * Tests ctor ActivityNodeCompartmentExtractor#ActivityNodeCompartmentExtractor(GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when node is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNode() {
        try {
            new ActivityNodeCompartmentExtractor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityNodeCompartmentExtractor#extractName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractName is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractName() throws Exception {
        GraphElement element = extractor.extractName();
        GraphElement expectedElement = (GraphElement) node.getContaineds().get(1);

        assertSame("Expects the name compartment is extracted correctly.", expectedElement, element);
    }

    /**
     * <p>
     * Tests ActivityNodeCompartmentExtractor#extractName() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractName_CompartmentMalformedException() throws Exception {
        node.setContained(1, getStereotypeNodeForUpdate());

        try {
            extractor.extractName();
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityNodeCompartmentExtractor#extractName() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractName_CompartmentNotFoundException() throws Exception {
        node.removeContained(1);

        try {
            extractor.extractName();
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityNodeCompartmentExtractor#updateName(GraphElement) for accuracy.
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

        assertSame("Expects the name compartment is updated correctly.", newElement, extractor.extractName());
    }

    /**
     * <p>
     * Tests ActivityNodeCompartmentExtractor#updateName(GraphElement) for failure.
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
     * Tests ActivityNodeCompartmentExtractor#updateName(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is invalid and expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateName_InvalidNewElement() throws Exception {
        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(TestHelper.createSimpleSemanticModel("NameNode"));

        try {
            extractor.updateName(nameNode);
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityNodeCompartmentExtractor#updateName(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateName_CompartmentMalformedException() throws Exception {
        node.setContained(1, getStereotypeNodeForUpdate());

        try {
            extractor.updateName(getNameNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityNodeCompartmentExtractor#updateName(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateName_CompartmentNotFoundException() throws Exception {
        node.removeContained(1);

        try {
            extractor.updateName(getNameNodeForUpdate());
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityNodeCompartmentExtractor#extractStereotype() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractStereotype is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractStereotype() throws Exception {
        GraphElement expectedElement = (GraphElement) node.getContaineds().get(0);

        assertEquals("Expects the stereotype compartment is extracted successfully.", expectedElement,
            extractor.extractStereotype());
    }

    /**
     * <p>
     * Tests ActivityNodeCompartmentExtractor#extractStereotype() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractStereotype_CompartmentMalformedException() throws Exception {
        node.setContained(0, getNameNodeForUpdate());

        try {
            extractor.extractStereotype();
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityNodeCompartmentExtractor#extractStereotype() for failure.
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
     * Tests ActivityNodeCompartmentExtractor#updateStereotype(GraphElement) for accuracy.
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
     * Tests ActivityNodeCompartmentExtractor#updateStereotype(GraphElement) for failure.
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
     * Tests ActivityNodeCompartmentExtractor#updateStereotype(GraphElement) for failure.
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
        stereotypeNode.setSemanticModel(TestHelper.createSimpleSemanticModel("StereotypeNode"));

        try {
            extractor.updateStereotype(stereotypeNode);
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityNodeCompartmentExtractor#updateStereotype(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateStereotype_CompartmentMalformedException() throws Exception {
        node.setContained(0, getNameNodeForUpdate());

        try {
            extractor.updateStereotype(getStereotypeNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityNodeCompartmentExtractor#updateStereotype(GraphElement) for failure.
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