/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for StyleNotSupportedException.
 * </p>
 *
 * <p>
 * This class is pretty simple. The test cases simply verifies the exception can be instantiated with the error message
 * and cause properly propagated, and that it comes with correct inheritance.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class StyleNotSupportedExceptionTests extends TestCase {
    /**
     * <p>
     * The error message used for testing.
     * </p>
     */
    private static final String ERROR_MESSAGE = "test error message";

    /**
     * <p>
     * An exception instance used to create the StyleNotSupportedException.
     * </p>
     */
    private static final Exception CAUSE_EXCEPTION = new NullPointerException();

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(StyleNotSupportedExceptionTests.class);
    }

    /**
     * <p>
     * Creation test.
     * </p>
     *
     * <p>
     * Verifies the error message is properly propagated.
     * </p>
     */
    public void testStyleNotSupportedException1() {
        StyleNotSupportedException exception = new StyleNotSupportedException(ERROR_MESSAGE);
        assertNotNull("Unable to instantiate StyleNotSupportedException.", exception);
        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE, exception.getMessage());
    }

    /**
     * <p>
     * Creation test.
     * </p>
     *
     * <p>
     * Verifies the error message and the cause are properly propagated.
     * </p>
     */
    public void testStyleNotSupportedException2() {
        StyleNotSupportedException exception = new StyleNotSupportedException(ERROR_MESSAGE, CAUSE_EXCEPTION);

        assertNotNull("Unable to instantiate StyleNotSupportedException.", exception);
        assertTrue("The error message should match", exception.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("Cause is not properly propagated to super class.", CAUSE_EXCEPTION, exception.getCause());
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies StyleNotSupportedException subclasses Exception.
     * </p>
     */
    public void testStyleNotSupportedExceptionInheritance1() {
        StyleNotSupportedException exception = new StyleNotSupportedException(ERROR_MESSAGE);
        assertTrue("StyleNotSupportedException does not subclass Exception.", exception instanceof Exception);
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies StyleNotSupportedException subclasses Exception.
     * </p>
     */
    public void testStyleNotSupportedExceptionInheritance2() {
        StyleNotSupportedException exception = new StyleNotSupportedException(ERROR_MESSAGE, CAUSE_EXCEPTION);
        assertTrue("StyleNotSupportedException does not subclass Exception.", exception instanceof Exception);
    }
}