/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.NodeAddEvent;

/**
 * Accuracy test for NodeAddEvent.
 * 
 * @author radium
 * @version 1.0
 */
public class NodeAddEventAccuracyTest extends TestCase {

    /**
     * Test method for getLocation().
     */
    public void testGetLocation() {
        Point location = new Point(100, 100);
        NodeAddEvent nae = new NodeAddEvent(AccuracyTestHelper.createSubsystemNodeContainer(), location);
        assertEquals("Should be equal.", location, nae.getLocation());
    }

}
