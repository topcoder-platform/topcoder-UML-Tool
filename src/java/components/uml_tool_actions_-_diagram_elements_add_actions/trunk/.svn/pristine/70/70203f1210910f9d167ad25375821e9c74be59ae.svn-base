/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ClassifierCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentNotFoundException;

/**
 * This is the failure test cases for ClassifierCompartmentExtractor class.
 * 
 * @author Xuchen
 * @version 1.0
 */
public class ClassifierCompartmentExtractorFailureTest extends TestCase {

    /** The ClassifierCompartmentExtractor instance used for testing. */
    private ClassifierCompartmentExtractor extractor;
    
    /** The GraphNode instance used for testing. */ 
    private GraphNode node;
    
    /**
     * Set up the testing environment.
     */
    protected void setUp() {
        node = new GraphNode();
        extractor = new ClassifierCompartmentExtractor(node);
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull() {
        try {
            new ClassifierCompartmentExtractor(null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * Test extractAttribute() method.
     * It should throw CompartmentNotFoundException.
     * @throws Exception to JUnit
     */
    public void testExtractAttribute() throws Exception {
        try {
            extractor.extractAttribute();
            fail("It should CompartmentNotFoundException.");
        } catch (CompartmentNotFoundException e) {
            // success
        }
    }
    
    /**
     * Test updateAttribute() method with null argument.
     * It should throw IllegalArgumentException.
     * @throws Exception to JUnit
     */
    public void testUpdateAttributeNull() throws Exception {
        try {
            extractor.updateAttribute(null);
            fail("It should IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * Test updateAttribute() method with invalid argument.
     * It should throw CompartmentNotFoundException.
     * @throws Exception to JUnit
     */
    public void testUpdateAttribute() throws Exception {
        try {
            extractor.updateAttribute(node);
            fail("It should CompartmentNotFoundException.");
        } catch (CompartmentNotFoundException e) {
            // success
        }
    }
    
    /**
     * Test extractOperation() method.
     * It should throw CompartmentNotFoundException.
     * @throws Exception to JUnit
     */
    public void testExtractOperation() throws Exception {
        try {
            extractor.extractOperation();
            fail("It should CompartmentNotFoundException.");
        } catch (CompartmentNotFoundException e) {
            // success
        }
    }
    
    /**
     * Test updateOperation() method with null argument.
     * It should throw IllegalArgumentException.
     * @throws Exception to JUnit
     */
    public void testUpdateOperationNull() throws Exception {
        try {
            extractor.updateOperation(null);
            fail("It should IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * Test updateOperation() method with invalid argument.
     * It should throw CompartmentNotFoundException.
     * @throws Exception to JUnit
     */
    public void testUpdateOperation() throws Exception {
        try {
            extractor.updateOperation(node);
            fail("It should CompartmentNotFoundException.");
        } catch (CompartmentNotFoundException e) {
            // success
        }
    }
}
