/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import junit.framework.TestCase;


/**
 * Test case for ConfigurationException.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ConfigurationExceptionTest extends TestCase {
    /**
     * Test ctor ConfigurationException(String) with string message and test whether it can be obtained later.
     */
    public void testConfigurationExceptionString() {
        String msg = "msg";
        ConfigurationException e = new ConfigurationException(msg);
        assertTrue("msg should be set and obtained properly", e.getMessage().indexOf(msg) == 0);
    }

    /**
     * Test ConfigurationException(String, Throwable) with msg and cause, and obtain them later.
     */
    public void testConfigurationExceptionStringThrowable() {
        String msg = "msg";
        Throwable t = new RuntimeException();
        ConfigurationException e = new ConfigurationException(msg, t);
        assertTrue("msg should be set and obtained properly", e.getMessage().indexOf(msg) == 0);
        assertEquals("throwable should be set and obtained properly", t, e.getCause());
    }
}
