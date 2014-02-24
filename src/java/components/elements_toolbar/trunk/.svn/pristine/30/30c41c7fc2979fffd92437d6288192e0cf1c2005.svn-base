/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * Unit test cases for <code>GraphDataRetrieverException</code>.
 * </p>
 * <p>
 * This class is pretty simple. The test cases simply verifies the exception can be instantiated with the error
 * message and cause properly propagated, and that it comes with correct inheritance.
 * </p>
 *
 * @author enefem21
 * @version 1.0
 */
public class SectionPanelConfigurationExceptionTest extends TestCase {

    /**
     * <p>
     * The error message used for testing.
     * </p>
     */
    private static final String ERROR_MESSAGE = "test error message";

    /**
     * <p>
     * Creates a test suite of the tests contained in this class.
     * </p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(SectionPanelConfigurationExceptionTest.class);
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
    public void testSectionPanelConfigurationException1() {
        final SectionPanelConfigurationException ex = new SectionPanelConfigurationException(ERROR_MESSAGE);

        assertNotNull("Unable to instantiate SectionPanelConfigurationException.", ex);
        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE, ex.getMessage());
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
    public void testSectionPanelConfigurationException2() {
        Exception cause = new Exception();
        SectionPanelConfigurationException ex = new SectionPanelConfigurationException(ERROR_MESSAGE, cause);

        assertNotNull("Unable to instantiate SectionPanelConfigurationException.", ex);
        assertEquals("Cause is not properly propagated to super class.", cause, ex.getCause());
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies <code>SectionPanelConfigurationException</code> subclasses <code>BaseException</code>.
     * </p>
     */
    public void testSectionPanelConfigurationExceptionInheritance1() {
        assertTrue("SectionPanelConfigurationException does not subclass BaseException.",
            new SectionPanelConfigurationException(ERROR_MESSAGE) instanceof BaseException);
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies <code>SectionPanelConfigurationException</code> subclasses <code>BaseException</code>.
     * </p>
     */
    public void testSectionPanelConfigurationExceptionInheritance2() {
        assertTrue("SectionPanelConfigurationException does not subclass BaseException.",
            new SectionPanelConfigurationException(ERROR_MESSAGE, new Exception()) instanceof BaseException);
    }
}
