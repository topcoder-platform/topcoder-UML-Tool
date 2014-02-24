/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import java.awt.Graphics;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classedges.Aggregation;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>Aggregation</code> class.
 * This class tests <code>Aggregation</code> for proper behavior. It covers
 * Aggregation(TextField, TextField), paintComponent(Graphics), contains(int, int).
 *
 * @author still
 * @version 1.0
 */
public class AggregationFailureTest extends TestCase {

    /**
     * Test suite of Aggregation.
     *
     * @return Test suite of Aggregation.
     */
    public static Test suite() {
        return new TestSuite(AggregationFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
    }
    /**
     * <p>
     * Test of Aggregation(TextField, TextField) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null name textField.
     */
    public void testAggregationForException1() {
        try {
            new Aggregation(null, new TextField(new GraphNode()));
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }
    /**
     * <p>
     * Test of Aggregation(TextField, TextField) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null multiplicity textField.
     */
    public void testAggregationForException2() {
        try {
            new Aggregation(new TextField(new GraphNode()), null);
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
            new Aggregation(new TextField(new GraphNode()), new TextField(new GraphNode())) {
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
