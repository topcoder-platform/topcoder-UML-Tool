/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EdgeAddEvent;

/**
 * Accuracy test for EdgeAddEvent.
 * 
 * @author radium
 * @version 1.0
 */
public class EdgeAddEventAccuracyTest extends TestCase {
    /**
     * Sample point for testing
     */
    private Point location = new Point(100, 100);

    /**
     * isStart for testing.
     */
    private boolean isStart = true;

    /**
     * Sample EdgeAddEvent for testing.
     */
    private EdgeAddEvent eae;

    /**
     * Set up the environment for testing.
     */
    protected void setUp() throws Exception {
        eae = new EdgeAddEvent(AccuracyTestHelper.createSubsystemNodeContainer(), location, isStart);
    }

    /**
     * Test method for getLocation().
     */
    public void testGetLocation() {
        assertEquals("Should be equal.", location, eae.getLocation());
    }

    /**
     * Test method for isStart().
     */
    public void testIsStart() {
        assertEquals("Should be equal.", isStart, eae.isStart());
    }

}
