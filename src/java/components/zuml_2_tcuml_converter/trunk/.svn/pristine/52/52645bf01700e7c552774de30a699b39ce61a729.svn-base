/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Accuracy test cases for class DefaultXMIConverter.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class DefaultXMIConverterAccuracyTest extends TestCase {

    /**
     * The instance of AccuracyMockDefaultXMIConverter for testing..
     */
    private AccuracyMockDefaultXMIConverter converter;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DefaultXMIConverterAccuracyTest.class);
    }

    /**
     * Sets up the environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        converter = new AccuracyMockDefaultXMIConverter();
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
        assertTrue("Should implement XMIConverter", converter instanceof XMIConverter);
    }
}
