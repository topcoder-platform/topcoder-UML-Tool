/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.UpdateDiagramElementAction;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultEdgeCompartmentExtractor;

/**
 * This is the failure test cases for UpdateDiagramElementAction class.
 * Since UpdateDiagramElementAction is abstract class, we create a subclass for it to test.
 * 
 * @author Xuchen
 * @version 1.0
 */
public class UpdateDiagramElementActionFailureTest extends TestCase {
    
    /** The GraphElement instance used for testing. */ 
    private GraphElement element;
    
    /** The CompartmentExtractor instance used for testing. */
    private CompartmentExtractor extractor;
    
    /**
     * Set up the testing environment.
     */
    protected void setUp() {
        element = new GraphNode();
        extractor = new DefaultEdgeCompartmentExtractor(new GraphEdge());
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorExtractorNull() {
        try {
            new UpdateDiagramElementActionSubClass((CompartmentExtractor) null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorGraphElementNull() {
        try {
            new UpdateDiagramElementActionSubClass((GraphElement) null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * Test Constructor with both null arguments.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorGraphElementExtractorNull1() {
        try {
            new UpdateDiagramElementActionSubClass(null, null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test Constructor with only one null argument. It is ok.
     * It should not throw IllegalArgumentException.
     */
    public void testConstructorGraphElementExtractorNullAllowed1() {
        try {
            new UpdateDiagramElementActionSubClass(element, null);            
        } catch (IllegalArgumentException e) {
            fail("It should not throw IllegalArgumentException.");
        }
    }    
    
    /**
     * Test Constructor with only one null argument. It is ok.
     * It should not throw IllegalArgumentException.
     */
    public void testConstructorGraphElementExtractorNullAllowed2() {
        try {
            new UpdateDiagramElementActionSubClass(null, extractor);            
        } catch (IllegalArgumentException e) {
            fail("It should not throw IllegalArgumentException.");
        }
    }    
    
    /**
     * A simple UpdateDiagramElementAction subclass which is used for testing purpose.
     * 
     * @author Xuchen
     * @version 1.0
     */
    class UpdateDiagramElementActionSubClass extends UpdateDiagramElementAction {
        
        /**
         * <p>Create UpdateDiagramElementActionSubClass instance with given extractor.</p>
         * @param extractor compartment extractor to be used
         * @throws IllegalArgumentException thrown if the extractor is null
         */
        public UpdateDiagramElementActionSubClass(CompartmentExtractor extractor) {
            super(extractor);
        }
        
        /**
         * <p>Create UpdateDiagramElementActionSubClass with given element.</p>
         * @param element graph element to be updated
         * @throws IllegalArgumentException thrown if the element is null
         */
        public UpdateDiagramElementActionSubClass(GraphElement element) {
            super(element);
        }
        
        /**
         * <p>Create UpdateDiagramElementActionSubClass with given parent element and compartment extractor.</p>
         * @param element graph element to be updated
         * @param extractor extractor to be used
         * @throws IllegalArgumentException thrown if the element or the extractor is null
         */
        public UpdateDiagramElementActionSubClass(GraphElement element, CompartmentExtractor extractor) {
            super(element, extractor);
        }
        
        /**
         * Empty execute.
         */
        public void execute() {
            // empty
        }
    }
}
