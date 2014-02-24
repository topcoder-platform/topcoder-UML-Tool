/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.accuracytests;

import com.topcoder.gui.diagramviewer.uml.classedges.OpenArrow;

import junit.framework.TestCase;

import java.awt.Point;


/**
 * <p>Test the accuracy of OpenArrow class.</p>
 *
 * @author KLW
 * @version 1.0
 */
public class OpenArrowAccuracyTests extends TestCase {
    /** <code>OpenArrow</code> instance used for testing. */
    private OpenArrow arrow;

    /**
     * <p>Sets up test environment.</p>
     */
    protected void setUp() {
        arrow = new OpenArrow();
        arrow.setAngle(Math.toRadians(90));
        arrow.setEndingPoint(new Point(20, 20));
    }

    /**
     * <p>Tears down test environment.</p>
     */
    protected void tearDown() {
        arrow = null;
    }

    /**
     * <p>Accuracy test of constructor <code>OpenArrow()</code>. Should create the instance
     * successfully.</p>
     */
    public void testCtor() {
        assertNotNull("Should create the instance successfully.", arrow);
    }
}
