/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ActivityStateCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentNotFoundException;

/**
 * This is the failure test cases for ActivityStateCompartmentExtractor class.
 * 
 * @author Xuchen
 * @version 1.0
 */
public class ActivityStateCompartmentExtractorFailureTest extends TestCase {

    /** The ActivityStateCompartmentExtractor instance used for testing. */
    private ActivityStateCompartmentExtractor extractor;
    
    /** The GraphNode instance used for testing. */ 
    private GraphNode node;
    
    /**
     * Set up the testing environment.
     */
    protected void setUp() {
        node = new GraphNode();
        extractor = new ActivityStateCompartmentExtractor(node);
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull() {
        try {
            new ActivityStateCompartmentExtractor(null);
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
}

