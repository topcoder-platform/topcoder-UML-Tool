/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class ConfigurationException. All the constructors are
 * tested.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ConfigurationExceptionUnitTests extends TestCase {
    /** The error message used for testing. */
    private static final String ERROR_MESSAGE = "test error message";

    /** An exception instance used to create the ConfigurationException. */
    private final Exception cause = new Exception();

    /**
     * Test constructor1: ConfigurationException(String), with correct message,
     * the message can be retrieved correctly later.
     */
    public void testCtor1() {
        ConfigurationException me = new ConfigurationException(ERROR_MESSAGE);
        assertNotNull("Unable to instantiate ConfigurationException.", me);
        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE, me.getMessage());
    }

    /**
     * Test constructor1:ConfigurationException(String), with null message, no
     * exception is expected.
     */
    public void testCtor1WithNullMessage() {
        // NO exception
        new ConfigurationException(null);
    }

    /**
     * Test constructor2: ConfigurationException(String, Throwable), with
     * correct error message, cause, the message and cause can be retrieved
     * correctly later.
     */
    public void testCtor2() {
        ConfigurationException me = new ConfigurationException(ERROR_MESSAGE, cause);

        assertNotNull("Unable to instantiate ConfigurationException.", me);
        assertTrue("Error message is not properly propagated to super class.",
                me.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("The inner exception should match", cause, me.getCause());
    }

    /**
     * Test constructor2: ConfigurationException(String, Throwable), with null
     * message, no exception is expected.
     */
    public void testCtor2WithNullMessage() {
        // No exception
        new ConfigurationException(null, cause);
    }

    /**
     * Test constructor2: ConfigurationException(String, Throwable), with null
     * inner exception, no exception is expected.
     */
    public void testCtor2WithNullCause() {
        // No exception
        new ConfigurationException(ERROR_MESSAGE, null);
    }
}
