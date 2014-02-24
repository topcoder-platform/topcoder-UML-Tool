/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentNotFoundException;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultNodeCompartmentExtractor;

/**
 * This is the failure test cases for DefaultNodeCompartmentExtractor class.
 * 
 * @author Xuchen
 * @version 1.0
 */
public class DefaultNodeCompartmentExtractorFailureTest extends TestCase {

    /** The DefaultNodeCompartmentExtractor instance used for testing. */
    private DefaultNodeCompartmentExtractor extractor;
    
    /** The GraphNode instance used for testing. */ 
    private GraphNode node;
    
    /**
     * Set up the testing environment.
     */
    protected void setUp() {
        node = new GraphNode();
        extractor = new DefaultNodeCompartmentExtractor(node);
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull() {
        try {
            new DefaultNodeCompartmentExtractor(null);
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
     * Test extractNamespace() method.
     * It should throw CompartmentNotFoundException.
     * @throws Exception to JUnit
     */
    public void testExtractNamespace() throws Exception {
        try {
            extractor.extractNamespace();
            fail("It should CompartmentNotFoundException.");
        } catch (CompartmentNotFoundException e) {
            // success
        }
    }
    
    /**
     * Test updateNamespace() method with null argument.
     * It should throw IllegalArgumentException.
     * @throws Exception to JUnit
     */
    public void testUpdateNamespaceNull() throws Exception {
        try {
            extractor.updateNamespace(null);
            fail("It should IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * Test updateNamespace() method with invalid argument.
     * It should throw CompartmentNotFoundException.
     * @throws Exception to JUnit
     */
    public void testUpdateNamespace() throws Exception {
        try {
            extractor.updateNamespace(node);
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
