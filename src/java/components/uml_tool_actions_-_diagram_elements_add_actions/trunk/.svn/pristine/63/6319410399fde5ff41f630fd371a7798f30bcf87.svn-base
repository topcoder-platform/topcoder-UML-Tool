/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.TestHelper;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.statemachines.Pseudostate;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for StructureCompartmentExtractor.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class StructureCompartmentExtractorTests extends TestCase {
    /**
     * <p>
     * StructureCompartmentExtractor instance for testing.
     * </p>
     */
    private StructureCompartmentExtractor extractor;

    /**
     * <p>
     * GraphElement instance for helping testing.
     * </p>
     */
    private GraphElement element;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        element = TestHelper.createGraphNodeForActivityNode();

        extractor = new StructureCompartmentExtractor(element, Pseudostate.class);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        element = null;
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
        return new TestSuite(StructureCompartmentExtractorTests.class);
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#extract() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Extract is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtract() throws Exception {
        extractor.addNextLevelSemanticModel("StereotypeCompartment", 0);

        GraphElement expectedElement = (GraphElement) element.getContaineds().get(0);

        assertSame("Expects the correct graph element is extracted.", expectedElement, extractor.extract());
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#extract() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtract_CompartmentMalformedException() throws Exception {
        extractor.addNextLevelSemanticModel(Interface.class, 0);

        try {
            extractor.extract();
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#extract() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExtract_CompartmentNotFoundException() throws Exception {
        extractor.addNextLevelSemanticModel("Help");

        try {
            extractor.extract();
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#addNextLevelSemanticModel(String,int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AddNextLevelSemanticModel is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddNextLevelSemanticModel1() throws Exception {
        extractor.addNextLevelSemanticModel("StereotypeCompartment", 0);

        GraphElement expectedElement = (GraphElement) element.getContaineds().get(0);

        assertSame("Expects the correct graph element is extracted.", expectedElement, extractor.extract());
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#addNextLevelSemanticModel(String,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when typeInfo is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddNextLevelSemanticModel1_Nullhanno() {
        try {
            extractor.addNextLevelSemanticModel((String) null, 1);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#addNextLevelSemanticModel(String,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when index is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testAddNextLevelSemanticModel1_NegativeIndex() {
        try {
            extractor.addNextLevelSemanticModel("type", -3);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#addNextLevelSemanticModel(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AddNextLevelSemanticModel is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddNextLevelSemanticModel2() throws Exception {
        extractor.addNextLevelSemanticModel("StereotypeCompartment");

        GraphElement expectedElement = (GraphElement) element.getContaineds().get(0);

        assertSame("Expects the correct graph element is extracted.", expectedElement, extractor.extract());
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#addNextLevelSemanticModel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when typeInfo is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddNextLevelSemanticModel2_Nullhanno() {
        try {
            extractor.addNextLevelSemanticModel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#addNextLevelSemanticModel(Class,int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AddNextLevelSemanticModel is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddNextLevelSemanticModel3() throws Exception {
        element = TestHelper.createGraphNodeForMessage();
        extractor = new StructureCompartmentExtractor(element, null);

        extractor.addNextLevelSemanticModel(Stimulus.class, 0);

        GraphElement expectedElement = (GraphElement) element.getContaineds().get(0);
        assertSame("Expects the correct graph element is extracted.", expectedElement, extractor.extract());
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#addNextLevelSemanticModel(Class,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when index is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testAddNextLevelSemanticModel3_NegativeIndex() {
        try {
            extractor.addNextLevelSemanticModel(Interface.class, -1);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#update(GraphElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Update is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdate() throws Exception {
        extractor.addNextLevelSemanticModel("StereotypeCompartment", 0);

        GraphNode node = new GraphNode();
        node.setSemanticModel(TestHelper.createSimpleSemanticModel("StereotypeCompartment"));

        extractor.update(node);

        assertSame("Expects the graph element is updated.", node, extractor.extract());
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#update(GraphElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newElement is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdate_NullNewElement() throws Exception {
        try {
            extractor.update(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#update(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentMalformedException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdate_CompartmentMalformedException() throws Exception {
        extractor.addNextLevelSemanticModel("Type", 0);

        try {
            extractor.update(new GraphNode());
            fail("CompartmentMalformedException expected.");
        } catch (CompartmentMalformedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests StructureCompartmentExtractor#update(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotFoundException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdate_CompartmentNotFoundException() throws Exception {
        extractor.addNextLevelSemanticModel("Type", 5);

        try {
            extractor.update(new GraphNode());
            fail("CompartmentNotFoundException expected.");
        } catch (CompartmentNotFoundException e) {
            //good
        }
    }
}