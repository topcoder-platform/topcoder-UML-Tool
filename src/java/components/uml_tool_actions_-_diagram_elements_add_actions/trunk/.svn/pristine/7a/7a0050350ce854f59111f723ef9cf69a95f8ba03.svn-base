/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateNameAction;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultNodeCompartmentExtractor;

/**
 * This is the failure test cases for UpdateNameAction class.
 *  
 * @author Xuchen
 * @version 1.0
 */
public class UpdateNameActionFailureTest extends TestCase {

    /** The CompartmentExtractor instance used for testing. */
    private CompartmentExtractor extractor = null;

    /**
     * Set up the testing environment.
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        extractor = new DefaultNodeCompartmentExtractor(new GraphNode());
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructor_Null1() {
        try {
            new UpdateNameAction(null, new GraphNode());
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    } 

    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructor_Null2() {
        try {
            new UpdateNameAction(extractor, null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}

