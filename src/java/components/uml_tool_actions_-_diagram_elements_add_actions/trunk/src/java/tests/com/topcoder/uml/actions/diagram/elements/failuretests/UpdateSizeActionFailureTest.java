/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateSizeAction;

/**
 * This is the failure test cases for UpdateSizeAction class.
 *  
 * @author Xuchen
 * @version 1.0
 */
public class UpdateSizeActionFailureTest extends TestCase {
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructor_Null1() {
        try {
            new UpdateSizeAction(null, new Dimension());
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
            new UpdateSizeAction(new GraphNode(), null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}

