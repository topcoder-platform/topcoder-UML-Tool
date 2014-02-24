/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import junit.framework.TestCase;


/**
 * Test case for ImageExporterException.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ImageExporterExceptionTest extends TestCase {
    /**
     * Test ctor ImageExporterException(String) with string message and test whether it can be obtained later.
     */
    public void testImageExporterExceptionString() {
        String msg = "msg";
        ImageExporterException e = new ImageExporterException(msg);
        assertTrue("msg should be set and obtained properly", e.getMessage().indexOf(msg) == 0);
    }

    /**
     * Test ImageExporterException(String, Throwable) with msg and cause, and obtain them later.
     */
    public void testImageExporterExceptionStringThrowable() {
        String msg = "msg";
        Throwable t = new RuntimeException();
        ImageExporterException e = new ImageExporterException(msg, t);
        assertTrue("msg should be set and obtained properly", e.getMessage().indexOf(msg) == 0);
        assertEquals("throwable should be set and obtained properly", t, e.getCause());
    }
}
