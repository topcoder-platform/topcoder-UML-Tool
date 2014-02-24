/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Edges Version 1.0 Accuracytests.
 *
 * @ EdgeEndingAccuracyTests.java
 */
package com.topcoder.gui.diagramviewer.edges.accuracytests;

import com.topcoder.gui.diagramviewer.edges.EdgeEnding;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Graphics;
import java.awt.Point;


/**
 * <p>
 * The <code>EdgeEnding</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>EdgeEnding</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class EdgeEndingAccuracyTests extends TestCase {
    /**
     * <p>
     * Represents an instance of <code>EdgeEnding</code> uses for accuracy tests.
     * </p>
     */
    private EdgeEnding test = null;

    /**
     * <p>
     * Test suite of <code>EdgeEndingAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>EdgeEndingAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(EdgeEndingAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     */
    protected void setUp() {
        test = new MockEdgeEnding();
    }

    /**
     * <p>
     * Accuracy Test of the <code>EdgeEnding</code>'s constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance to check the constructor.
        assertNotNull("Constructor should work well.", new MockEdgeEnding());

        //  get the attribute endPoint to check the constructor.
        assertEquals("The endPoint default to Point(0, 0).", new Point(0, 0),
            test.getEndingPoint());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setAngle(double)</code> and <code>getAngle()</code>
     * methods.
     * </p>
     */
    public void testAngle_Operation() {
        // set the angle.
        test.setAngle(1.24);
        //  get the attribute angle to check the set operation.
        assertEquals("The angle should be 1.24.", 1.24, test.getAngle());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setEndingPoint(Point)</code> and <code>getEndingPoint()</code>
     * methods.
     * </p>
     */
    public void testEndingPoint_Operation() {
        // get the attribute endPoint to check the get operation.
        assertEquals("The endPoint default to Point(0, 0).", new Point(0, 0),
            test.getEndingPoint());

        Point newPoint = new Point(2, 4);
        // set the endPoint.
        test.setEndingPoint(newPoint);
        //  get the attribute endPoint to check the set operation.
        assertEquals("The endPoint should be Point(2, 4).", newPoint,
            test.getEndingPoint());
    }
}


/**
 * The mock class extends from EdgeEnding used for accuracy tests only.
 *
 * @author zmg
 * @version 1.0
 */
@SuppressWarnings("serial")
class MockEdgeEnding extends EdgeEnding {
    /**
    * <p>
    * This method is left as abstract to enforce subclass to provide concrete
    * implementation.
    * </p>
    *
    * <p>
    * <strong>Note</strong>: It will be called automatically by SWING framework.
    * </p>
    *
    * @param g the graphics to paint on.
    */
    protected void paintComponent(Graphics g) {
    }
}
