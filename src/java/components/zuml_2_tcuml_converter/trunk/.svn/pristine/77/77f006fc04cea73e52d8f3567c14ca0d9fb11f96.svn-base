/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for <code>XMIConverterConfigurationException</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMIConverterConfigurationExceptionUnitTest extends TestCase {
    /**
     * <p>The error message for testing.</p>
     */
    private static final String MESSAGE = "The error message.";

    /**
     * <p>The throwable instance used as embeded exception.</p>
     */
    private static final Throwable CAUSE = new Exception("Exception");

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(XMIConverterConfigurationExceptionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for <code>XMIConverterConfigurationException(String)</code>.
     * </p>
     */
    public void testCtor() {
        XMIConverterConfigurationException exception = new XMIConverterConfigurationException(MESSAGE);
        assertNotNull("Unable to create XMIConverterConfigurationExceptoin instance.",
            exception);
        assertEquals("The message should match.", MESSAGE,
            exception.getMessage());

        exception = new XMIConverterConfigurationException(null);
        assertNotNull("Unable to create XMIConverterConfigurationExceptoin instance.",
            exception);
        assertNull("The message should match.", exception.getMessage());

        exception = new XMIConverterConfigurationException("");
        assertNotNull("Unable to create XMIConverterConfigurationExceptoin instance.",
            exception);
        assertEquals("The message should match.", "", exception.getMessage());
    }

    /**
     * <p>
     * Accuracy test for <code>XMIConverterConfigurationException(String. Throwable)</code>.
     * </p>
     */
    public void testCtor2() {
        XMIConverterConfigurationException exception = new XMIConverterConfigurationException(MESSAGE,
                CAUSE);
        assertNotNull("Unable to create XMIConverterConfigurationExceptoin instance.",
            exception);
        assertEquals("The cause should match.", CAUSE, exception.getCause());

        exception = new XMIConverterConfigurationException(MESSAGE, null);
        assertNotNull("Unable to create XMIConverterConfigurationExceptoin instance.",
            exception);
        assertNull("The message should match.", exception.getCause());
    }
}
