/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ BezierPointAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.BezierPoint;
import com.topcoder.diagraminterchange.Point;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;


/**
 * <p>
 * The <code>BezierPoint</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>BezierPoint</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class BezierPointAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>BezierPoint</code> used for tests.
     * </p>
     */
    private BezierPoint test = null;

    /**
     * <p>
     * Test suite of <code>BezierPointAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>BezierPointAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(BezierPointAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats a new instance of <code>BezierPoint</code>.
     * </p>
     */
    protected void setUp() {
        test = new BezierPoint();
    }

    /**
     * <p>
     * Accuracy Test of the <code>BezierPoint()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new BezierPoint());

        // get the original value of controls to check the constructor
        assertEquals("The controls expected to be empty", 0,
            test.countControls());
    }

    /**
     * <p>
     * Accuracy Test of the controls correlative method, such like :
     * <code>addControl(Point)</code> method, <code>getControls()</code> and also other method.
     * </p>
     */
    public void testControls_Operation() {
        // creat some points.
        Point point1 = new Point();
        Point point2 = new Point();
        Point point3 = new Point();

        // add the points to the list.
        test.addControl(point1);
        test.addControl(1, point2);

        // get the index of the point.
        assertEquals("The point1 expected to at index 0", 0,
            test.indexOfControl(point1));

        // check for contain.
        assertTrue("The point2 expected to be in the list",
            test.containsControl(point2));

        // set the point to the list.
        test.setControl(0, point3);

        // get the index of the point.
        assertEquals("The point3 expected to at index 0", 0,
            test.indexOfControl(point3));

        // get a copy of the points list.
        List<Point> newControls = test.getControls();

        // get the elements of points list to test.
        assertEquals("The points list expected to be 2 element", 2,
            newControls.size());
        assertTrue("The point3 expected to be in the list",
            newControls.contains(point3));

        // clear the new list.
        newControls.clear();

        // still two elements in points list.
        assertEquals("The points list expected to be 2 element", 2,
            test.countControls());

        // check the removed point.
        assertEquals("The two points expected to be equal", point2,
            test.removeControl(1));
        assertTrue("The point3 expected to be removed",
            test.removeControl(point3));

        // non exist element can not be removed.
        assertFalse("The point2 can not be removed again",
            test.removeControl(point2));

        // add the points to the list.
        test.addControl(point1);
        test.clearControls();
        assertEquals("The points list expected to be empty", 0,
            test.countControls());
    }
}
