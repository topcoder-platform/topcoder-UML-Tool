/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.accuracytests;

import junit.framework.TestCase;

import com.topcoder.swing.print.ConfigurationException;

/**
 * This class aggregates accuracy tests for ConfigurationException class.
 * 
 * @author ch_music
 * @version 1.0
 */
public class ConfigurationExceptionAccuracyTests extends TestCase {

    /**
     * A placeholder for ConfigurationException instance.
     */
    private ConfigurationException test;

    /**
     * Tests single-argument constructor. No exception is expected.
     */
    public void testConfigurationExceptionString() {
        test = new ConfigurationException("test");
        assertNotNull("Fails to create exception.", test);
        assertEquals("Wrong message.", "test", test.getMessage());
    }

    /**
     * Tests two-argument constructor. No exception is expected.
     */
    public void testConfigurationExceptionStringThrowable() {
        test = new ConfigurationException("test", new IllegalArgumentException());
        assertNotNull("Fails to create exception.", test);
        assertEquals("Wrong message.", "test", test.getMessage().substring(0, 4));
        assertEquals("Wrong cause.", IllegalArgumentException.class, test.getCause().getClass());
    }
}
