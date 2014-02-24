/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateAction;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultNodeCompartmentExtractor;

/**
 * This is the failure test cases for UpdateAction class.
 * Since UpdateAction is abstract class, we create a subclass for it to test.
 * 
 * @author Xuchen
 * @version 1.0
 */
public class UpdateActionFailureTest extends TestCase {

    /** The CompartmentExtractor instance used for testing. */
    private CompartmentExtractor extractor = null;
    
    /** The GraphElement instance used for testing. */ 
    private GraphElement element;
    
    /**
     * Set up the testing environment.
     */
    protected void setUp() {
        element = new GraphNode();
        extractor = new DefaultNodeCompartmentExtractor(new GraphNode());
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull1() {
        try {
            new UpdateActionImpl((CompartmentExtractor) null, element);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull2() {
        try {
            new UpdateActionImpl((GraphElement) null, element);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull3() {
        try {
            new UpdateActionImpl(null, extractor, element);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull4() {
        try {
            new UpdateActionImpl(element, null, element);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * A simple UpdateAction subclass which is used for testing purpose.
     * 
     * @author Xuchen
     * @version 1.0
     */
    class UpdateActionImpl extends UpdateAction {
        /**
         * Create UpdateActionImpl instance.
         * @param extractor compartment extractor to be used
         * @param value the new value to replace the old one
         * @throws IllegalArgumentException thrown if extractor argument is null.
         */
        public UpdateActionImpl(CompartmentExtractor extractor, Object value) {
            super(extractor, value);
        }
        
        /**
         * Create UpdateActionImpl instance.
         * @param element graph element to be updated
         * @param value the new value to replace the old one
         *
         * @throws IllegalArgumentException thrown if element argument is null.
         */
        public UpdateActionImpl(GraphElement element, Object value) {
            super(element, value);
        }
        
        /**
         * Create UpdateActionImpl instance.
         * @param element graph element to be updated
         * @param extractor compartment extractor to be used
         * @param value new value to replace the old one
         *
         * @throws IllegalArgumentException thrown if element or extractor is null
         */
        public UpdateActionImpl(GraphElement element, CompartmentExtractor extractor, Object value) {
            super(element, extractor, value);
        }
        
        /**
         * Empty.
         */
        public void execute() {
            // Empty
        }
    }
}

