/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterConfigurationException;
import com.topcoder.util.errorhandling.BaseException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Accuracy test cases for class XMIConverterConfigurationException.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class XMIConverterConfigurationExceptionAccuracyTest extends TestCase {

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(XMIConverterConfigurationExceptionAccuracyTest.class);
    }

    /**
     * <p>
     * Test for base class.
     * </p>
     *
     * <p>
     * Tests it for accuracy.
     * </p>
     */
    public void testBase_Accuracy() {
        assertTrue("Should extends BaseException",
                new XMIConverterConfigurationException("msg") instanceof BaseException);
    }

    /**
     * <p>
     * Test for constructor with message.
     * </p>
     *
     * <p>
     * Tests it for accuracy.
     * </p>
     */
    public void testCtor1_Accuracy() {
        String msg = "msg";
        Exception ex = new XMIConverterConfigurationException(msg);
        assertEquals("Exception message mismatched.", msg, ex.getMessage());
    }

    /**
     * <p>
     * Test for constructor with message and cause.
     * </p>
     * <p>
     * Tests it for accuracy.
     * </p>
     */
    public void testCtor2_Accuracy() {
        String msg = "message";
        Exception cause = new Exception("exception");
        Exception ex = new XMIConverterConfigurationException(msg, cause);
        assertSame("Expected cause: ", cause, ex.getCause());
        assertEquals("Exception message mismatched.", msg + ", caused by exception", ex
                .getMessage());
    }
}
