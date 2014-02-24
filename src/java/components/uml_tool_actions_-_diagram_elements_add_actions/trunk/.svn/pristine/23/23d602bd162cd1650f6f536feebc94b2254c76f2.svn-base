/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.actions.AddRemoveOperationAction;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultNodeCompartmentExtractor;

/**
 * This is the failure test cases for AddRemoveOperationAction class.
 *  
 * @author Xuchen
 * @version 1.0
 */
public class AddRemoveOperationActionFailureTest extends TestCase {

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
     * Test createRemoveOperationAction method with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testCreateRemoveOperationAction_Null1() {
        try {
            AddRemoveOperationAction.createRemoveOperationAction(null, new GraphNode());
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    } 

    /**
     * Test createRemoveOperationAction method with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testCreateRemoveOperationAction_Null2() {
        try {
            AddRemoveOperationAction.createRemoveOperationAction(extractor, null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    } 
    
    /**
     * Test createAddAttributeAction method with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testCreateAddOperationAction_Null1() {
        try {
            AddRemoveOperationAction.createAddOperationAction(null, new GraphNode());
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    } 
    
    /**
     * Test createAddAttributeAction method with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testCreateAddOperationAction_Null2() {
        try {
            AddRemoveOperationAction.createAddOperationAction(extractor, null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    } 
}

