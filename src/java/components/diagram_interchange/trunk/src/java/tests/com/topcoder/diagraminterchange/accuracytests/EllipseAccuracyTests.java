/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ EllipseAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.Ellipse;
import com.topcoder.diagraminterchange.Point;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>Ellipse</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>Ellipse</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class EllipseAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>Ellipse</code> used for tests.
     * </p>
     */
    private Ellipse test = null;

    /**
     * <p>
     * Test suite of <code>EllipseAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>EllipseAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(EllipseAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new Ellipse();
    }

    /**
     * <p>
     * Accuracy Test of the <code>Ellipse()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new Ellipse());

        // get the original value of center point to check the constructor
        assertNull("The center point expected to be null", test.getCenter());

        // get the original value of x radius to check the constructor
        assertEquals("The x radius expected to be 0.0", 0.0, test.getRadiusX());

        // get the original value of y radius to check the constructor
        assertEquals("The y radius expected to be 0.0", 0.0, test.getRadiusY());

        // get the original value of rotation to check the constructor
        assertEquals("The rotation expected to be 0.0", 0.0, test.getRotation());

        // get the original value of start angle to check the constructor
        assertEquals("The start angle expected to be 0.0", 0.0,
            test.getStartAngle());

        // get the original value of end angle to check the constructor
        assertEquals("The end angle expected to be 0.0", 0.0, test.getEndAngle());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setCenter(Point)</code> method and
     * <code>getCenter()</code>.
     * </p>
     */
    public void testCenter_Operation() {
        // creat a new Point
        Point point = new Point();

        // set the center point.
        test.setCenter(point);

        // get the center point.
        assertEquals("The center point expected to be equal", point,
            test.getCenter());

        // set the center point to null.
        test.setCenter(null);

        // get the center point.
        assertNull("The center point expected to be null", test.getCenter());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setRadiusX(double)</code> method and
     * <code>getRadiusX()</code>.
     * </p>
     */
    public void testRadiusX_Operation() {
        // set the x radius.
        test.setRadiusX(3.85);

        // get the x radius.
        assertEquals("The x radius expected to be equal", 3.85,
            test.getRadiusX());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setRadiusY(double)</code> method and
     * <code>getRadiusY()</code>.
     * </p>
     */
    public void testRadiusY_Operation() {
        // set the y radius.
        test.setRadiusY(3.85);

        // get the y radius.
        assertEquals("The y radius expected to be equal", 3.85,
            test.getRadiusY());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setRotation(double)</code> method and
     * <code>getRotation()</code>.
     * </p>
     */
    public void testRotation_Operation() {
        // set the rotation.
        test.setRotation(2.77);

        // get the rotation.
        assertEquals("The rotation expected to be equal", 2.77,
            test.getRotation());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setStartAngle(double)</code> method and
     * <code>getStartAngle()</code>.
     * </p>
     */
    public void testStartAngle_Operation() {
        // set the start angle.
        test.setStartAngle(2.73);

        // get the start angle.
        assertEquals("The start angle expected to be equal", 2.73,
            test.getStartAngle());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setEndAngle(double)</code> method and
     * <code>getEndAngle()</code>.
     * </p>
     */
    public void testEndAngle_Operation() {
        // set the end angle.
        test.setEndAngle(3.77);

        // get the end angle.
        assertEquals("The end angle expected to be equal", 3.77,
            test.getEndAngle());
    }
}
