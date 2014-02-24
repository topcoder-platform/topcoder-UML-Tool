/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import java.awt.Graphics;

import com.topcoder.gui.diagramviewer.uml.classedges.ClosedArrow;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>ClosedArrow</code> class.
 *
 * @author still
 * @version 1.0
 */
public class ClosedArrowFailureTest extends TestCase {

    /**
     * Test suite of ClosedArrow.
     *
     * @return Test suite of ClosedArrow.
     */
    public static Test suite() {
        return new TestSuite(ClosedArrowFailureTest.class);
    }

    /**
     * <p>
     * Test of paintComponent(Graphics) for ignoring null Graphics.
     * </p>
     *
     * No exception should be thrown when encountering null Graphics.
     */
    public void testPaintComponentForIgnoreNullGraphics() {
        try {
            // should not throw any exception
            new ClosedArrow() {
                /**
                 * Mock paintComponent simply call super paintComponent.
                 *
                 * @param g parameter passed to super paintComponent
                 */
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                }
            } .paintComponent(null);
        } catch (Exception e) {
            // should be here
            fail("No exception expected.");
        }
    }
}
