/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for StylePanelConfigurationException.
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
public class StylePanelConfigurationExceptionTests extends TestCase {
    /**
     * <p>
     * The error message used for testing.
     * </p>
     */
    private static final String ERROR_MESSAGE = "test error message";

    /**
     * <p>
     * An exception instance used to create the StylePanelConfigurationException.
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
        return new TestSuite(StylePanelConfigurationExceptionTests.class);
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
    public void testStylePanelConfigurationException1() {
        StylePanelConfigurationException exception = new StylePanelConfigurationException(ERROR_MESSAGE);
        assertNotNull("Unable to instantiate StylePanelConfigurationException.", exception);
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
    public void testStylePanelConfigurationException2() {
        StylePanelConfigurationException exception = new StylePanelConfigurationException(
            ERROR_MESSAGE, CAUSE_EXCEPTION);

        assertNotNull("Unable to instantiate StylePanelConfigurationException.", exception);
        assertTrue("The error message should match", exception.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("Cause is not properly propagated to super class.", CAUSE_EXCEPTION, exception.getCause());
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies StylePanelConfigurationException subclasses Exception.
     * </p>
     */
    public void testStylePanelConfigurationExceptionInheritance1() {
        StylePanelConfigurationException exception = new StylePanelConfigurationException(ERROR_MESSAGE);
        assertTrue("StylePanelConfigurationException does not subclass Exception.", exception instanceof Exception);
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies StylePanelConfigurationException subclasses Exception.
     * </p>
     */
    public void testStylePanelConfigurationExceptionInheritance2() {
        StylePanelConfigurationException exception = new StylePanelConfigurationException(
            ERROR_MESSAGE, CAUSE_EXCEPTION);
        assertTrue("StylePanelConfigurationException does not subclass Exception.", exception instanceof Exception);
    }
}