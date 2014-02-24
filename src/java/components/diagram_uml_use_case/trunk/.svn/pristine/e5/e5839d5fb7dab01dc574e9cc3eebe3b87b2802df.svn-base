/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.SimpleArrow;

/**
 * Accuracy test for SimpleArrow.
 *
 * @author radium
 * @version 1.0
 */
public class SimpleArrowAccuracyTest extends TestCase {
    /**
     * Sample SimpleArrow for testing.
     */
    private SimpleArrow sa;

    /**
     * Setup the environment for testing.
     */
    protected void setUp() throws Exception {
        sa = new SimpleArrow();
        sa.setEndingPoint(new Point(100, 100));
        sa.setAngle(0);
    }

    /**
     * Test method for contains(int, int).
     */
    public void testContainsIntInt() {
        assertTrue("Should be true.", sa.contains(90, 90));
    }

}
