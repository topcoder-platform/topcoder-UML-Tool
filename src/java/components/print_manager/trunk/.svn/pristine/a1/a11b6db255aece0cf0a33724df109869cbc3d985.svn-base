/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import junit.framework.TestCase;


/**
 * Test case for PrintingException.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PrintingExceptionTest extends TestCase {
    /**
     * Test ctor PrintingExceptionTest(String) with string message and test whether it can be obtained later.
     */
    public void testPrintingExceptionString() {
        String msg = "msg";
        PrintingException e = new PrintingException(msg);
        assertTrue("msg should be set and obtained properly", e.getMessage().indexOf(msg) == 0);
    }

    /**
     * Test PrintFormatRetrieveException(String, Throwable) with msg and cause, and obtain them later.
     */
    public void testPrintingExceptionStringThrowable() {
        String msg = "msg";
        Throwable t = new RuntimeException();
        PrintingException e = new PrintingException(msg, t);
        assertTrue("msg should be set and obtained properly", e.getMessage().indexOf(msg) == 0);
        assertEquals("throwable should be set and obtained properly", t, e.getCause());
    }
}
