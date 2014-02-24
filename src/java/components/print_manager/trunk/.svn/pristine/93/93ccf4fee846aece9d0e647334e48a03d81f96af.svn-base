/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import junit.framework.TestCase;


/**
 * Test case for PrintFormatRetrieveException.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PrintFormatRetrieveExceptionTest extends TestCase {
    /**
     * Test ctor PrintFormatRetrieveException(String) with string message and test whether it can be obtained
     * later.
     */
    public void testPrintFormatRetrieveExceptionString() {
        String msg = "msg";
        PrintFormatRetrieveException e = new PrintFormatRetrieveException(msg);
        assertTrue("msg should be set and obtained properly", e.getMessage().indexOf(msg) == 0);
    }

    /**
     * Test PrintFormatRetrieveException(String, Throwable) with msg and cause, and obtain them later.
     */
    public void testPrintFormatRetrieveExceptionStringThrowable() {
        String msg = "msg";
        Throwable t = new RuntimeException();
        PrintFormatRetrieveException e = new PrintFormatRetrieveException(msg, t);
        assertTrue("msg should be set and obtained properly", e.getMessage().indexOf(msg) == 0);
        assertEquals("throwable should be set and obtained properly", t, e.getCause());
    }
}
