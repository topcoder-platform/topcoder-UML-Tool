/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.DefaultXMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.IgnoreOperationInMethodConverter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Accuracy test cases for class IgnoreOperationInMethodConverter.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class IgnoreOperationInMethodConverterAccuracyTest extends TestCase {

    /**
     * The instance of IgnoreOperationInMethodConverter for testing..
     */
    private IgnoreOperationInMethodConverter converter;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(IgnoreOperationInMethodConverterAccuracyTest.class);
    }

    /**
     * Sets up the environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        converter = new IgnoreOperationInMethodConverter();
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
        assertTrue("Should implement DefaultXMIConverter", converter instanceof DefaultXMIConverter);
    }

    /**
     * <p>
     * Accuracy test for <code>IgnoreOperationInMethodConverter())</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>IgnoreOperationInMethodConverter()</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtor_Accuracy() throws Exception {
        assertNotNull("Should not be null", converter);
    }
}
