/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Point;

import com.topcoder.gui.diagramviewer.uml.activityelements.SimpleArrowEdgeEnding;

/**
 * Accuracy tests for the class: SimpleArrowEdgeEnding.
 * 
 * @author kinfkong
 * @version 1.0
 */
public class SimpleArrowEdgeEndingAccuracyTest extends AccuracyBase {

    /**
     * Represents the edgeEnding.
     */
    private SimpleArrowEdgeEnding edgeEnding;

    /**
     * Sets up the test environment.
     */
    protected void setUp() {
        edgeEnding = new SimpleArrowEdgeEnding(Math.PI * .5, new Point(20, 20));
    }

    /**
     * Tests the constructor SimpleArrowEdgeEnding.
     */
    public void testSimpleArrowEdgeEnding() {
        assertNotNull("The instance cannot be created.", edgeEnding);
    }

    /**
     * Tests the method: contains.
     */
    public void testContains() {
        assertTrue("The method does not work properly.", edgeEnding.contains(20, 15));
    }
    
}