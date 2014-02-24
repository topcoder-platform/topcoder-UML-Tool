/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import com.topcoder.util.errorhandling.BaseException;
import com.topcoder.xmi.writer.transformers.model.ConfigurationException;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for ConfigurationException.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ConfigurationExceptionTests extends TestCase {
    /** The test message. */
    private static final String ERROR_MESSAGE = "test exception message";

    /**
     * the cause Exception.
     */
    private final Exception cause = new NullPointerException();

    /**
     * test the excption constructor with ERROR_MESSAGE.
     */
    public void testConfigurationException1() {
        ConfigurationException de = new ConfigurationException(ERROR_MESSAGE);
        assertNotNull("Unable to instantiate ConfigurationException.", de);

        assertEquals("Error message is not properly propagated to super class.",
            ERROR_MESSAGE, de.getMessage());
        assertTrue("The error message should match.",
            de.getMessage().indexOf(ERROR_MESSAGE) >= 0);
    }

    /**
     * test the excption constructor with ERROR_MESSAGE and throwable.
     */
    public void testConfigurationException2() {
        ConfigurationException de = new ConfigurationException(ERROR_MESSAGE, cause);

        assertNotNull("Unable to instantiate ConfigurationException.", de);

        assertEquals("Cause is not properly propagated to super class.", cause,
            de.getCause());
    }

    /**
     * Inheritance test.
     */
    public void testConfigurationException3() {
        assertTrue("ConfigurationException does not subclass BaseException.",
            new ConfigurationException(ERROR_MESSAGE) instanceof BaseException);

        assertTrue("ConfigurationException does not subclass BaseException.",
            new ConfigurationException(ERROR_MESSAGE, cause) instanceof BaseException);
    }
}
