/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.actions.AddRemoveAction;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;

/**
 * This is the failure test cases for AddRemoveAction class.
 * Since AddRemoveAction is abstract class, we create a subclass for it to test.
 * 
 * @author Xuchen
 * @version 1.0
 */
public class AddRemoveActionFailureTest extends TestCase {

    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull1() {
        try {
            new AddRemoveActionImpl(null, new GraphNode(), true);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * A simple AddRemoveAction subclass which is used for testing purpose.
     * 
     * @author Xuchen
     * @version 1.0
     */
    class AddRemoveActionImpl extends AddRemoveAction {
        /**
         * <p>Create AbstractCompartmentExtractorImpl instance.</p>
         * @param element graph element in which the compartment graph element is to be extracted
         * @throws IllegalArgumentException thrown if element is null
         */
        public AddRemoveActionImpl(CompartmentExtractor extractor, Object obj, boolean isRemove) {
            super(extractor, obj, isRemove);
        }
        
        /**
         * Empty.
         */
        public void executeRemove() {
            // Empty
        }
        
        /**
         * Empty.
         */
        public void executeAdd() {
            // Empty
        }
    }
}
