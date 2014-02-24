/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import java.awt.Rectangle;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedEvent;

/**
 * Test case for BoundaryChangeEventAccuracy.
 * 
 * @author radium
 * @version 1.0
 */
public class BoundaryChangedEventAccuracyTest extends TestCase {
    /**
     * Sample BoundaryChangeEvent for testing.
     */
    private BoundaryChangedEvent bce;

    /**
     * Sample Rectangle for testing.
     */
    private Rectangle old = new Rectangle();

    /**
     * Sample Rectangle for testing.
     */
    private Rectangle newD = new Rectangle();

    /**
     * Sample String for testing.
     */
    private String mess = "message";

    /**
     * Setup the environment for testing.
     */
    protected void setUp() throws Exception {
        bce = new BoundaryChangedEvent((Node) AccuracyTestHelper.createSubsystemNodeContainer(), old, newD, mess);
    }

    /**
     * Test method for getOldBoundary().
     */
    public void testGetOldBoundary() {
        assertEquals("Should be equal.", old, bce.getOldBoundary());
    }

    /**
     * Test method for getNewBoundary().
     */
    public void testGetNewBoundary() {
        assertEquals("Should be equal.", newD, bce.getNewBoundary());
    }

    /**
     * Test method for getMessage().
     */
    public void testGetMessage() {
        assertEquals("Should be equal.", mess, bce.getMessage());
    }

}
