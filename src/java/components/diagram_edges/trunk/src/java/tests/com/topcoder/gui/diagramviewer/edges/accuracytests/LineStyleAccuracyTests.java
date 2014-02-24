/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Edges Version 1.0 Accuracytests.
 *
 * @ LineStyleAccuracyTests.java
 */
package com.topcoder.gui.diagramviewer.edges.accuracytests;

import com.topcoder.gui.diagramviewer.edges.LineStyle;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>LineStyle</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>LineStyle</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class LineStyleAccuracyTests extends TestCase {
    /**
     * <p>
     * Represents an instance of <code>LineStyle</code> uses for accuracy tests.
     * </p>
     */
    private LineStyle test = null;

    /**
     * <p>
     * Test suite of <code>LineStyleAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>LineStyleAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(LineStyleAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     */
    protected void setUp() {
        test = new LineStyle(7, 2);
    }

    /**
     * <p>
     * Accuracy Test of the <code>LineStyle</code>'s constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance to check the constructor.
        assertNotNull("Constructor should work well.", new LineStyle(5, 3));

        // get the attribute blankSpace to check the constructor.
        assertEquals("The blankSpace should be set to 2.", 2,
            test.getBlankLength());
        //  get the attribute dashLength to check the constructor.
        assertEquals("The dashLength should be set to 7.", 7,
            test.getDashLength());
    }

    /**
     * <p>
     * Accuracy Test of the <code>LineStyle</code>'s constructor.
     * It test will zero blankSpace.
     * </p>
     */
    public void testConstructor_ZeroBlankSpace() {
        // creat a new instance.
        test = new LineStyle(3, 0);
        // get the attribute blankSpace to check the constructor.
        assertEquals("The blankSpace should be set to 0.", 0,
            test.getBlankLength());
        //  get the attribute dashLength to check the constructor.
        assertEquals("The dashLength should be set to 3.", 3,
            test.getDashLength());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setDashLength(int)</code> and <code>getDashLength()</code>
     * methods.
     * </p>
     */
    public void testDashLength_Operation() {
        // get the attribute dashLength to check the get operation.
        assertEquals("The dashLength should be set to 7.", 7,
            test.getDashLength());
        // set the dashLength.
        test.setDashLength(5);
        //  get the attribute dashLength to check the set operation.
        assertEquals("The dashLength should be set to 5.", 5,
            test.getDashLength());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setBlankLength(int)</code> and <code>getBlankLength()</code>
     * methods.
     * </p>
     */
    public void testBlankLength_Operation() {
        // get the attribute blankLength to check the get operation.
        assertEquals("The blankLength should be set to 2.", 2,
            test.getBlankLength());
        // set the blankLength.
        test.setBlankLength(5);
        //  get the attribute blankLength to check the set operation.
        assertEquals("The blankLength should be set to 5.", 5,
            test.getBlankLength());

        //  set the blankLength.
        test.setBlankLength(0);
        //  get the attribute blankLength to check the set operation.
        assertEquals("The blankLength should be set to 0.", 0,
            test.getBlankLength());
    }
}
