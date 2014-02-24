/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ActivityNodeCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentNotFoundException;

/**
 * This is the failure test cases for ActivityNodeCompartmentExtractor class.
 * 
 * @author Xuchen
 * @version 1.0
 */
public class ActivityNodeCompartmentExtractorFailureTest extends TestCase {

    /** The ActivityNodeCompartmentExtractor instance used for testing. */
    private ActivityNodeCompartmentExtractor extractor;
    
    /** The GraphNode instance used for testing. */ 
    private GraphNode node;
    
    /**
     * Set up the testing environment.
     */
    protected void setUp() {
        node = new GraphNode();
        extractor = new ActivityNodeCompartmentExtractor(node);
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull() {
        try {
            new ActivityNodeCompartmentExtractor(null);
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
            extractor.updateName(node);
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
            extractor.updateStereotype(node);
            fail("It should CompartmentNotFoundException.");
        } catch (CompartmentNotFoundException e) {
            // success
        }
    }
}
