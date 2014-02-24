/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ PointAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.Point;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>Point</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>Point</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class PointAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>Point</code> used for tests.
     * </p>
     */
    private Point test = null;

    /**
     * <p>
     * Test suite of <code>PointAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>PointAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(PointAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new Point();
    }

    /**
     * <p>
     * Accuracy Test of the <code>Point()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new Point());

        // get the original value of x to check the constructor
        assertEquals("The x expected to be 0.0", 0.0, test.getX());
        // get the original value of y to check the constructor
        assertEquals("The y expected to be 0.0", 0.0, test.getY());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setX(double)</code> method and
     * <code>getX()</code>.
     * </p>
     */
    public void testX_Operation() {
        double [] values = new double [] {1.3, 5.8, 4.8, 9.3};
        for (double value : values) {
            // set the x.
            test.setX(value);
            // get the x.
            assertEquals("The value expected to be equal", value,
                test.getX());
        }
    }

    /**
     * <p>
     * Accuracy Test of the <code>setY(double)</code> method and
     * <code>getY()</code>.
     * </p>
     */
    public void testY_Operation() {
        double [] values = new double [] {1.3, 5.8, 4.8, 9.3};
        for (double value : values) {
            // set the y.
            test.setY(value);
            // get the y.
            assertEquals("The value expected to be equal", value,
                test.getY());
        }
    }
}
