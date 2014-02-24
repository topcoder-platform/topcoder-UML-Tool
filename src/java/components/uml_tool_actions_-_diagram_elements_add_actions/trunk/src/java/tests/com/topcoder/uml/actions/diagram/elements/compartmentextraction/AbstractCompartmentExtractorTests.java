/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AbstractCompartmentExtractor.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AbstractCompartmentExtractorTests extends TestCase {
    /**
     * <p>
     * AbstractCompartmentExtractor instance for testing.
     * </p>
     */
    private AbstractCompartmentExtractor extractor;

    /**
     * <p>
     * DiagramElement instance for helping testing.
     * </p>
     */
    private DiagramElement element;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        element = new GraphNode();
        extractor = new MockCompartmentExtractor(element);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        extractor = null;
        element = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(AbstractCompartmentExtractorTests.class);
    }

    /**
     * <p>
     * Tests ctor AbstractCompartmentExtractor#AbstractCompartmentExtractor(DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created AbstractCompartmentExtractor instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AbstractCompartmentExtractor instance.", extractor);
    }

    /**
     * <p>
     * Tests ctor AbstractCompartmentExtractor#AbstractCompartmentExtractor(DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullElement() {
        try {
            new MockCompartmentExtractor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#extractName() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testExtractName_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.extractName();
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#updateName(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateName_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.updateName(null);
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#extractNamespace() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testExtractNamespace_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.extractNamespace();
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#updateNamespace(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateNamespace_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.updateNamespace(null);
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#extractStereotype() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testExtractStereotype_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.extractStereotype();
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#updateStereotype(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateStereotype_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.updateStereotype(null);
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#extractFirstAssociationEnd() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testExtractFirstAssociationEnd_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.extractFirstAssociationEnd();
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#updateFirstAssociationEnd(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateFirstAssociationEnd_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.updateFirstAssociationEnd(null);
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#extractSecondAssociationEnd() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testExtractSecondAssociationEnd_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.extractSecondAssociationEnd();
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#updateSecondAssociationEnd(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateSecondAssociationEnd_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.updateSecondAssociationEnd(null);
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#extractAttribute() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testExtractAttribute_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.extractAttribute();
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#updateAttribute(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateAttribute_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.updateAttribute(null);
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#extractOperation() for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testExtractOperation_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.extractOperation();
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#updateOperation(GraphElement) for failure.
     * </p>
     *
     * <p>
     * Expects CompartmentNotSupportedException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateOperation_CompartmentNotSupportedException() throws Exception {
        try {
            extractor.updateOperation(null);
            fail("CompartmentNotSupportedException expected.");
        } catch (CompartmentNotSupportedException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#setElement(DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The diagram element is set correctly.
     * </p>
     */
    public void testSetElement() {
        DiagramElement newElement = new GraphNode();
        extractor.setElement(newElement);

        assertSame("Failed to get correct diagram element.", newElement, extractor.getElement());
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#setElement(DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetElement_NullElement() {
        try {
            extractor.setElement(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractCompartmentExtractor#getElement() for accuracy.
     * </p>
     *
     * <p>
     * Verify : getElement() is correct.
     * </p>
     */
    public void testGetElement() {
        assertSame("Failed to get correct diagram element.", element, extractor.getElement());
    }

    /**
     * <p>
     * This class extends AbstractCompartmentExtractor class and is used for testing AbstractCompartmentExtractor class.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    public class MockCompartmentExtractor extends AbstractCompartmentExtractor {
        /**
         * <p>
         * Creates a MockCompartmentExtractor instance.
         * </p>
         *
         * @param element graph element
         */
        protected MockCompartmentExtractor(DiagramElement element) {
            super(element);
        }
    }
}