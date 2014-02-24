/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader.accuracytests;

import com.topcoder.uml.standardclassloader.UnknownLanguageException;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test for <code>{@link UnknownLanguageException}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class UnknownLanguageExceptionAccuracyTests extends TestCase {
    /**
     * Represents a string with a detail message.
     */
    private static final String DETAIL_MESSAGE = "detail";

    /**
     * Tests accuracy of <code>UnknownLanguageException(String)</code> constructor. The detail error message should be
     * correct.
     */
    public void testUnknownLanguageExceptionStringAccuracy() {
        // Construct UnknownLanguageException with a detail message
        UnknownLanguageException exception = new UnknownLanguageException(DETAIL_MESSAGE);

        // Verify that there is a detail message
        assertNotNull("Should have message.", exception.getMessage());
        assertEquals("Detailed error message should be identical.", DETAIL_MESSAGE, exception.getMessage());
    }
}
