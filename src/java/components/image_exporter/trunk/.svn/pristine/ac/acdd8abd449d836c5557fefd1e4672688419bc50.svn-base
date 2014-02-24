/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import junit.framework.TestCase;


/**
 * Test case for JComponentVisibleMakerException.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class JComponentVisibleMakerExceptionTest extends TestCase {
    /**
     * Test ctor JComponentVisibleMakerException(String) with string message and test whether it can be
     * obtained later.
     */
    public void testJComponentVisibleMakerExceptionString() {
        String msg = "msg";
        JComponentVisibleMakerException e = new JComponentVisibleMakerException(msg);
        assertTrue("msg should be set and obtained properly", e.getMessage().indexOf(msg) == 0);
    }

    /**
     * Test JComponentVisibleMakerException(String, Throwable) with msg and cause, and obtain them later.
     */
    public void testJComponentVisibleMakerExceptionStringThrowable() {
        String msg = "msg";
        Throwable t = new RuntimeException();
        JComponentVisibleMakerException e = new JComponentVisibleMakerException(msg, t);
        assertTrue("msg should be set and obtained properly", e.getMessage().indexOf(msg) == 0);
        assertEquals("throwable should be set and obtained properly", t, e.getCause());
    }
}
