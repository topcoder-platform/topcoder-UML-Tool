/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.actions.AddRemoveAttributeAction;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultNodeCompartmentExtractor;

/**
 * This is the failure test cases for AddRemoveAttributeAction class.
 *  
 * @author Xuchen
 * @version 1.0
 */
public class AddRemoveAttributeActionFailureTest extends TestCase {

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
     * Test createRemoveAttributeAction method with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testCreateRemoveAttributeAction_Null1() {
        try {
            AddRemoveAttributeAction.createRemoveAttributeAction(null, new GraphNode());
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    } 

    /**
     * Test createRemoveAttributeAction method with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testCreateRemoveAttributeAction_Null2() {
        try {
            AddRemoveAttributeAction.createRemoveAttributeAction(extractor, null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    } 
    
    /**
     * Test createAddAttributeAction method with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testCreateAddAttributeAction_Null1() {
        try {
            AddRemoveAttributeAction.createAddAttributeAction(null, new GraphNode());
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    } 
    
    /**
     * Test createAddAttributeAction method with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testCreateAddAttributeAction_Null2() {
        try {
            AddRemoveAttributeAction.createAddAttributeAction(extractor, null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    } 
}
