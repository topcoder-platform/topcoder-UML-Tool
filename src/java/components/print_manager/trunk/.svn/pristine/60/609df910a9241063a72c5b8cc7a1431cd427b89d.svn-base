/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.accuracytests;

import junit.framework.TestCase;

import com.topcoder.swing.print.PrintingException;

/**
 * This class aggregates accuracy tests for PrintingException class.
 * 
 * @author ch_music
 * @version 1.0
 */
public class PrintingExceptionAccuracyTests extends TestCase {

    /**
     * A placeholder for PrintingException instance.
     */
    private PrintingException test;

    /**
     * Tests single-argument constructor. No exception is expected.
     */
    public void testPrintingExceptionString() {
        test = new PrintingException("test");
        assertNotNull("Fails to create exception.", test);
        assertEquals("Wrong message.", "test", test.getMessage());
    }

    /**
     * Tests two-argument constructor. No exception is expected.
     */
    public void testPrintingExceptionStringThrowable() {
        test = new PrintingException("test", new IllegalArgumentException());
        assertNotNull("Fails to create exception.", test);
        assertEquals("Wrong message.", "test", test.getMessage().substring(0, 4));
        assertEquals("Wrong cause.", IllegalArgumentException.class, test.getCause().getClass());
    }
}
