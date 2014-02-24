/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentNotFoundException;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultEdgeCompartmentExtractor;

/**
 * This is the failure test cases for DefaultEdgeCompartmentExtractor class.
 * 
 * @author Xuchen
 * @version 1.0
 */
public class DefaultEdgeCompartmentExtractorFailureTest extends TestCase {

    /** The DefaultEdgeCompartmentExtractor instance used for testing. */
    private DefaultEdgeCompartmentExtractor extractor;
    
    /** The GraphEdge instance used for testing. */ 
    private GraphEdge edge;
    
    /**
     * Set up the testing environment.
     */
    protected void setUp() {
        edge = new GraphEdge();
        extractor = new DefaultEdgeCompartmentExtractor(edge);
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull() {
        try {
            new DefaultEdgeCompartmentExtractor(null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * Test extractName() method.
     * It should throw CompartmentNotFoundException.
     * @throws Exception to JUnit
     */
    public void testExtractName() throws Exception {
        try {
            extractor.extractName();
            fail("It should CompartmentNotFoundException.");
        } catch (CompartmentNotFoundException e) {
            // success
        }
    }
    
    /**
     * Test updateName() method with null argument.
     * It should throw IllegalArgumentException.
     * @throws Exception to JUnit
     */
    public void testUpdateNameNull() throws Exception {
        try {
            extractor.updateName(null);
            fail("It should IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * Test updateName() method with invalid argument.
     * It should throw CompartmentNotFoundException.
     * @throws Exception to JUnit
     */
    public void testUpdateName() throws Exception {
        try {
            extractor.updateName(edge);
            fail("It should CompartmentNotFoundException.");
        } catch (CompartmentNotFoundException e) {
            // success
        }
    }
    
    /**
     * Test extractStereotype() method.
     * It should throw CompartmentNotFoundException.
     * @throws Exception to JUnit
     */
    public void testExtractStereotype() throws Exception {
        try {
            extractor.extractStereotype();
            fail("It should CompartmentNotFoundException.");
        } catch (CompartmentNotFoundException e) {
            // success
        }
    }
    
    /**
     * Test updateStereotype() method with null argument.
     * It should throw IllegalArgumentException.
     * @throws Exception to JUnit
     */
    public void testUpdateStereotypeNull() throws Exception {
        try {
            extractor.updateStereotype(null);
            fail("It should IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * Test updateStereotype() method with invalid argument.
     * It should throw CompartmentNotFoundException.
     * @throws Exception to JUnit
     */
    public void testUpdateStereotype() throws Exception {
        try {
            extractor.updateStereotype(edge);
            fail("It should CompartmentNotFoundException.");
        } catch (CompartmentNotFoundException e) {
            // success
        }
    }
}
