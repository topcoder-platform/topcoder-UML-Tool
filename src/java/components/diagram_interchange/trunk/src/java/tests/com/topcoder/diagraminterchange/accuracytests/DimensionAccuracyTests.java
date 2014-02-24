/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ DimensionAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.Dimension;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>Dimension</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>Dimension</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class DimensionAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>Dimension</code> used for tests.
     * </p>
     */
    private Dimension test = null;

    /**
     * <p>
     * Test suite of <code>DimensionAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>DimensionAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(DimensionAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new Dimension();
    }

    /**
     * <p>
     * Accuracy Test of the <code>Dimension()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new Dimension());

        // get the original value of height to check the constructor
        assertEquals("The height expected to be 0.0", 0.0, test.getHeight());

        // get the original value of width to check the constructor
        assertEquals("The width expected to be 0.0", 0.0, test.getWidth());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setHeight(double)</code> method and
     * <code>getHeight()</code>.
     * </p>
     */
    public void testHeight_Operation() {
        // set the height.
        test.setHeight(3.8);

        // get the height.
        assertEquals("The height expected to be equal", 3.8, test.getHeight());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setWidth(double)</code> method and
     * <code>getWidth()</code>.
     * </p>
     */
    public void testWidth_Operation() {
        // set the width.
        test.setWidth(9.24);

        // get the width.
        assertEquals("The width expected to be equal", 9.24, test.getWidth());
    }
}
