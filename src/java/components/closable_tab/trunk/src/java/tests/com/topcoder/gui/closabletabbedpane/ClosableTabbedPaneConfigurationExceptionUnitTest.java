/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.util.errorhandling.BaseNonCriticalException;
import com.topcoder.util.errorhandling.ExceptionData;

/**
 * <p>
 * UnitTest for ClosableTabbedPaneConfigurationException class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClosableTabbedPaneConfigurationExceptionUnitTest extends TestCase {
    /** Prepare a cause with message 'inner' for testing. */
    private Throwable cause;

    /** Prepare an ExceptionData with error code 'errorCode' for testing. */
    private ExceptionData data;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ClosableTabbedPaneConfigurationExceptionUnitTest.class);
    }

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        cause = new Throwable("inner");
        data = new ExceptionData().setErrorCode("errorCode");
    }

    /**
     * <p>
     * Check if ClosableTabbedPaneConfigurationException is a subclass of ClosableTabbedPaneConfigurationException.
     * </p>
     */
    public void testClosableTabbedPaneConfigurationException_Signature() {
        assertTrue("ClosableTabbedPaneConfigurationException signature incorrect",
            new ClosableTabbedPaneConfigurationException("msg") instanceof BaseNonCriticalException);
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPaneConfigurationException(String message)</code> constructor.
     * </p>
     * <p>
     * Simply call this constructor and then retrieve some data to compare with the desired ones.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPaneConfigurationException1_Accuracy() throws Exception {
        ClosableTabbedPaneConfigurationException e = new ClosableTabbedPaneConfigurationException("message");
        assertEquals("message mismatch", "message", e.getMessage());
        assertEquals("cause mismatch", null, e.getCause());
        assertEquals("error code mismatch", null, e.getErrorCode());
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPaneConfigurationException()</code> constructor.
     * </p>
     * <p>
     * Simply call this constructor and then retrieve some data to compare with the desired ones.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPaneConfigurationException0_Accuracy() throws Exception {
        ClosableTabbedPaneConfigurationException e = new ClosableTabbedPaneConfigurationException();
        assertEquals("message mismatch", null, e.getMessage());
        assertEquals("cause mismatch", null, e.getCause());
        assertEquals("error code mismatch", null, e.getErrorCode());
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPaneConfigurationException(String message, Throwable cause)</code>
     * constructor.
     * </p>
     * <p>
     * Simply call this constructor and then retrieve some data to compare with the desired ones.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPaneConfigurationException2_Accuracy() throws Exception {
        ClosableTabbedPaneConfigurationException e = new ClosableTabbedPaneConfigurationException("message", cause);
        assertEquals("message mismatch", "message", e.getMessage());
        assertEquals("cause mismatch", cause, e.getCause());
        assertEquals("error code mismatch", null, e.getErrorCode());
    }

    /**
     * <p>
     * Accuracy test of
     * <code>ClosableTabbedPaneConfigurationException(String message, Throwable cause, ExceptionData data)</code>
     * constructor.
     * </p>
     * <p>
     * Simply call this constructor and then retrieve some data to compare with the desired ones.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPaneConfigurationException3_Accuracy() throws Exception {
        ClosableTabbedPaneConfigurationException e = new ClosableTabbedPaneConfigurationException("message", cause,
            data);
        assertEquals("message mismatch", "message", e.getMessage());
        assertEquals("cause mismatch", cause, e.getCause());
        assertEquals("error code mismatch", data.getErrorCode(), e.getErrorCode());
    }
}
