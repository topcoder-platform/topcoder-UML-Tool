/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import java.awt.Graphics;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classedges.Composition;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>Composition</code> class.
 *
 * @author still
 * @version 1.0
 */
public class CompositionFailureTest extends TestCase {

    /**
     * Test suite of Composition.
     *
     * @return Test suite of Composition.
     */
    public static Test suite() {
        return new TestSuite(CompositionFailureTest.class);
    }


    /**
     * <p>
     * Test of Composition(TextField, TextField) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null name textField.
     */
    public void testCompositionForException1() {
        try {
            new Composition(null, new TextField(new GraphNode()));
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }
    /**
     * <p>
     * Test of Composition(TextField, TextField) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null multiplicity textField.
     */
    public void testCompositionForException2() {
        try {
            new Composition(new TextField(new GraphNode()), null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
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
            new Composition(new TextField(new GraphNode()), new TextField(new GraphNode())) {
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
