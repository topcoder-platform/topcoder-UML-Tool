/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.TestHelper;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AssociationCompartmentExtractor.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AssociationCompartmentExtractorTests extends TestCase {
    /**
     * <p>
     * AssociationCompartmentExtractor instance for testing.
     * </p>
     */
    private AssociationCompartmentExtractor extractor;

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
        edge = TestHelper.createGraphEdgeForAssociation();

        extractor = new AssociationCompartmentExtractor(edge);
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
        return new TestSuite(AssociationCompartmentExtractorTests.class);
    }

    /**
     * <p>
     * Tests ctor AssociationCompartmentExtractor#AssociationCompartmentExtractor(GraphEdge) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created AssociationCompartmentExtractor instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AssociationCompartmentExtractor instance.", extractor);
    }

    /**
     * <p>
     * Tests ctor AssociationCompartmentExtractor#AssociationCompartmentExtractor(GraphEdge) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when edge is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullEdge() {
        try {
            new AssociationCompartmentExtractor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#extractName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractName is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractName() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(2);
        element = (GraphElement) element.getContaineds().get(0);

        assertSame("The name compartment should be extracted correctly.", element, extractor.extractName());
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#extractName() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractName_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(2);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.extractName();
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#extractName() for failure.
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
     * Tests AssociationCompartmentExtractor#updateName(GraphElement) for accuracy.
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
     * Tests AssociationCompartmentExtractor#updateName(GraphElement) for failure.
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
     * Tests AssociationCompartmentExtractor#updateName(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateName_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(2);
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
     * Tests AssociationCompartmentExtractor#updateName(GraphElement) for failure.
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
     * Tests AssociationCompartmentExtractor#extractStereotype() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractStereotype is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractStereotype() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(3);

        assertSame("The stereotype compartment should be extracted correctly.", element, extractor.extractStereotype());
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#extractStereotype() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractStereotype_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(3);
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
     * Tests AssociationCompartmentExtractor#extractStereotype() for failure.
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
     * Tests AssociationCompartmentExtractor#updateStereotype(GraphElement) for accuracy.
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
     * Tests AssociationCompartmentExtractor#updateStereotype(GraphElement) for failure.
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
     * Tests AssociationCompartmentExtractor#updateStereotype(GraphElement) for failure.
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
     * Tests AssociationCompartmentExtractor#updateStereotype(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateStereotype_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(3);
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
     * Tests AssociationCompartmentExtractor#updateStereotype(GraphElement) for failure.
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
     * Tests AssociationCompartmentExtractor#extractFirstAssociationEnd() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractFirstAssociationEnd is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractFirstAssociationEnd() throws Exception {
        GraphElement expectedElement = (GraphElement) edge.getContaineds().get(0);

        assertSame("The First Association End compartment should be extracted correctly.", expectedElement,
            extractor.extractFirstAssociationEnd());
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#extractFirstAssociationEnd() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractFirstAssociationEnd_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(0);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.extractFirstAssociationEnd();
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#extractFirstAssociationEnd() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractFirstAssociationEnd_CompartmentNotFoundException() throws Exception {
        edge.clearContaineds();

        try {
            extractor.extractFirstAssociationEnd();
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#updateFirstAssociationEnd(GraphElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : UpdateFirstAssociationEnd is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateFirstAssociationEnd() throws Exception {
        GraphElement newElement = getAssociationEndNodeForUpdate();

        extractor.updateFirstAssociationEnd(newElement);

        assertSame("The Second Association End compartment should be updated.", newElement,
            extractor.extractFirstAssociationEnd());
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#updateFirstAssociationEnd(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateFirstAssociationEnd_NullNewElement() throws Exception {
        try {
            extractor.updateFirstAssociationEnd(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#updateFirstAssociationEnd(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is invalid and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateFirstAssociationEnd_InvalidNewElement() throws Exception {
        try {
            extractor.updateFirstAssociationEnd(getStereotypeNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#updateFirstAssociationEnd(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateFirstAssociationEnd_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(0);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.updateFirstAssociationEnd(getAssociationEndNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#updateFirstAssociationEnd(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateFirstAssociationEnd_CompartmentNotFoundException() throws Exception {
        edge.clearContaineds();

        try {
            extractor.updateFirstAssociationEnd(getAssociationEndNodeForUpdate());
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#extractSecondAssociationEnd() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ExtractSecondAssociationEnd is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractSecondAssociationEnd() throws Exception {
        GraphElement expectedElement = (GraphElement) edge.getContaineds().get(1);

        assertSame("The Second Association End compartment should be extracted correctly.", expectedElement,
            extractor.extractSecondAssociationEnd());
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#extractSecondAssociationEnd() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractSecondAssociationEnd_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(1);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.extractSecondAssociationEnd();
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#extractSecondAssociationEnd() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtractSecondAssociationEnd_CompartmentNotFoundException() throws Exception {
        edge.clearContaineds();

        try {
            extractor.extractSecondAssociationEnd();
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#updateSecondAssociationEnd(GraphElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : UpdateSecondAssociationEnd is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateSecondAssociationEnd() throws Exception {
        GraphElement newElement = getAssociationEndNodeForUpdate();

        extractor.updateSecondAssociationEnd(newElement);

        assertSame("The Second Association End compartment should be updated.", newElement,
            extractor.extractSecondAssociationEnd());
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#updateSecondAssociationEnd(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateSecondAssociationEnd_NullNewElement() throws Exception {
        try {
            extractor.updateSecondAssociationEnd(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#updateSecondAssociationEnd(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is invalid and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateSecondAssociationEnd_InvalidNewElement() throws Exception {
        try {
            extractor.updateSecondAssociationEnd(getNameNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#updateSecondAssociationEnd(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateSecondAssociationEnd_CompartmentMalformedException() throws Exception {
        GraphElement element = (GraphElement) edge.getContaineds().get(1);
        element.setSemanticModel(TestHelper.createSimpleSemanticModel("Invalid"));

        try {
            extractor.updateSecondAssociationEnd(getAssociationEndNodeForUpdate());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationCompartmentExtractor#updateSecondAssociationEnd(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateSecondAssociationEnd_CompartmentNotFoundException() throws Exception {
        edge.clearContaineds();

        try {
            extractor.updateSecondAssociationEnd(getAssociationEndNodeForUpdate());
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Creates a new GraphNode instance for association end compartment to update.
     * </p>
     *
     * @return a new GraphNode instance for association end compartment to update.
     */
    private GraphNode getAssociationEndNodeForUpdate() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(TestHelper.createUmlSemanticModel(new AssociationEndImpl()));

        return node;
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