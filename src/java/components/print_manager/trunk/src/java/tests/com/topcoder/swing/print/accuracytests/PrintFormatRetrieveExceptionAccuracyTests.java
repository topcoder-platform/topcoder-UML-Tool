/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.accuracytests;

import junit.framework.TestCase;

import com.topcoder.swing.print.PrintFormatRetrieveException;

/**
 * This class aggregates accuracy tests for PrintFormatRetrieveException class.
 * 
 * @author ch_music
 * @version 1.0
 */
public class PrintFormatRetrieveExceptionAccuracyTests extends TestCase {

    /**
     * A placeholder for PrintFormatRetrieveException instance.
     */
    private PrintFormatRetrieveException test;

    /**
     * Tests single-argument constructor. No exception is expected.
     */
    public void testPrintFormatRetrieveExceptionString() {
        test = new PrintFormatRetrieveException("test");
        assertNotNull("Fails to create exception.", test);
        assertEquals("Wrong message.", "test", test.getMessage());
    }

    /**
     * Tests two-argument constructor. No exception is expected.
     */
    public void testPrintFormatRetrieveExceptionStringThrowable() {
        test = new PrintFormatRetrieveException("test", new IllegalArgumentException());
        assertNotNull("Fails to create exception.", test);
        assertEquals("Wrong message.", "test", test.getMessage().substring(0, 4));
        assertEquals("Wrong cause.", IllegalArgumentException.class, test.getCause().getClass());
    }
}
