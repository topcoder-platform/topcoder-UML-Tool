/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.AbstractCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentNotSupportedException;

/**
 * This is the failure test cases for AbstractCompartmentExtractor class.
 * Since AbstractCompartmentExtractor is abstract class, we create a subclass for it to test.
 * 
 * @author Xuchen
 * @version 1.0
 */
public class AbstractCompartmentExtractorFailureTest extends TestCase {

    /** The AbstractCompartmentExtractor instance used for testing. */
    private AbstractCompartmentExtractor extractor;
    
    /** The GraphElement instance used for testing. */ 
    private GraphElement element;
    
    /**
     * Set up the testing environment.
     */
    protected void setUp() {
        element = new GraphNode();
        extractor = new AbstractCompartmentExtractorImpl(element);
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull() {
        try {
            new AbstractCompartmentExtractorImpl(null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * Test extractName() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testExtractName() throws Exception {
        try {
            extractor.extractName();
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * Test updateName() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testUpdateName() throws Exception {
        try {
            extractor.updateName(element);
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * Test extractNamespace() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testExtractNamespace() throws Exception {
        try {
            extractor.extractNamespace();
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * Test updateNamespace() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testUpdateNamespace() throws Exception {
        try {
            extractor.updateNamespace(element);
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * Test extractStereotype() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testExtractStereotype() throws Exception {
        try {
            extractor.extractStereotype();
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * Test updateStereotype() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testUpdateStereotype() throws Exception {
        try {
            extractor.updateStereotype(element);
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * Test extractFirstAssociationEnd() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testExtractFirstAssociationEnd() throws Exception {
        try {
            extractor.extractFirstAssociationEnd();
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * Test updateFirstAssociationEnd() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testUpdateFirstAssociationEnd() throws Exception {
        try {
            extractor.updateFirstAssociationEnd(element);
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * Test extractSecondAssociationEnd() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testExtractSecondAssociationEnd() throws Exception {
        try {
            extractor.extractSecondAssociationEnd();
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * Test updateSecondAssociationEnd() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testUpdateSecondAssociationEnd() throws Exception {
        try {
            extractor.updateSecondAssociationEnd(element);
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * Test extractAttribute() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testExtractAttribute() throws Exception {
        try {
            extractor.extractAttribute();
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * Test updateAttribute() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testUpdateAttribute() throws Exception {
        try {
            extractor.updateAttribute(element);
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * Test extractOperation() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testExtractOperation() throws Exception {
        try {
            extractor.extractOperation();
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * Test updateOperation() method.
     * It should throw CompartmentNotSupportedException.
     * @throws Exception to JUnit
     */
    public void testUpdateOperation() throws Exception {
        try {
            extractor.updateOperation(element);
            fail("It should CompartmentNotSupportedException.");
        } catch (CompartmentNotSupportedException e) {
            // success
        }
    }
    
    /**
     * A simple AbstractCompartmentExtractor subclass which is used for testing purpose.
     * 
     * @author Xuchen
     * @version 1.0
     */
    class AbstractCompartmentExtractorImpl extends AbstractCompartmentExtractor {
        /**
         * <p>Create AbstractCompartmentExtractorImpl instance.</p>
         * @param element graph element in which the compartment graph element is to be extracted
         * @throws IllegalArgumentException thrown if element is null
         */
        public AbstractCompartmentExtractorImpl(DiagramElement element) {
            super(element);
        }
    }
}
