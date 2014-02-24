/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import junit.framework.TestCase;


/**
 * Test case for ImageExporterConfigurationException.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ImageExporterConfigurationExceptionTest extends TestCase {
    /**
     * Test ctor ImageExporterConfigurationException(String) with string message and test whether it can be
     * obtained later.
     */
    public void testImageExporterConfigurationExceptionString() {
        String msg = "msg";
        ImageExporterConfigurationException e = new ImageExporterConfigurationException(msg);
        assertTrue("msg should be set and obtained properly", e.getMessage().indexOf(msg) == 0);
    }

    /**
     * Test ImageExporterConfigurationException(String, Throwable) with msg and cause, and obtain them later.
     */
    public void testImageExporterConfigurationExceptionStringThrowable() {
        String msg = "msg";
        Throwable t = new RuntimeException();
        ImageExporterConfigurationException e = new ImageExporterConfigurationException(msg, t);
        assertTrue("msg should be set and obtained properly", e.getMessage().indexOf(msg) == 0);
        assertEquals("throwable should be set and obtained properly", t, e.getCause());
    }
}
