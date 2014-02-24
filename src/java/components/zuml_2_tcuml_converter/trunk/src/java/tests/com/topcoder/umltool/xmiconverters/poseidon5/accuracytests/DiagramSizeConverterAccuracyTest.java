/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.DefaultXMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.DiagramSizeConverter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Accuracy test cases for class DiagramSizeConverter.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class DiagramSizeConverterAccuracyTest extends TestCase {

    /**
     * The instance of DiagramSizeConverter for testing..
     */
    private DiagramSizeConverter converter;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DiagramSizeConverterAccuracyTest.class);
    }

    /**
     * Sets up the environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        converter = new DiagramSizeConverter(10, 10, 5);
    }

    /**
     * <p>
     * Accuracy test for the base class.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testBase_Accuracy() throws Exception {
        assertTrue("Should implement DefaultXMIConverter",
                converter instanceof DefaultXMIConverter);
    }

    /**
     * <p>
     * Accuracy test for <code>DiagramSizeConverter(double, double, double)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>DiagramSizeConverter(double, double, double)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtor_Accuracy() throws Exception {
        assertNotNull("Should not be null", converter);
    }
}
