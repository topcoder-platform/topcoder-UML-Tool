/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader.accuracytests;

import com.topcoder.uml.standardclassloader.ClassDataLoaderConfigurationException;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test for <code>{@link ClassDataLoaderConfigurationException}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ClassDataLoaderConfigurationExceptionAccuracyTests extends TestCase {
    /**
     * Represents a string with a detail message.
     */
    private static final String DETAIL_MESSAGE = "detail";

    /**
     * Represents a throwable cause.
     */
    private static final Exception CAUSE = new Exception();

    /**
     * Tests accuracy of <code>ClassDataLoaderConfigurationException(String)</code> constructor. The detail error
     * message should be correct.
     */
    public void testClassDataLoaderConfigurationExceptionStringAccuracy() {
        // Construct ClassDataLoaderConfigurationException with a detail message
        ClassDataLoaderConfigurationException exception = new ClassDataLoaderConfigurationException(DETAIL_MESSAGE);

        // Verify that there is a detail message
        assertNotNull("Should have message.", exception.getMessage());
        assertEquals("Detailed error message should be identical.", DETAIL_MESSAGE, exception.getMessage());
    }

    /**
     * Tests accuracy of <code>ClassDataLoaderConfigurationException(String, Throwable)</code> constructor. The detail
     * error message and the original cause of error should be correct.
     */
    public void testClassDataLoaderConfigurationExceptionStringThrowableAccuracy() {
        // Construct ClassDataLoaderConfigurationException with a detail message and a cause
        ClassDataLoaderConfigurationException exception = new ClassDataLoaderConfigurationException(DETAIL_MESSAGE,
            CAUSE);

        // Verify that there is a detail message
        assertNotNull("Should have message.", exception.getMessage());
        assertEquals("Detailed error message with cause should be correct.", DETAIL_MESSAGE + ", caused by null",
            exception.getMessage());

        // Verify that there is a cause
        assertNotNull("Should have cause.", exception.getCause());
        assertTrue("Cause should be identical.", CAUSE == exception.getCause());
    }
}
