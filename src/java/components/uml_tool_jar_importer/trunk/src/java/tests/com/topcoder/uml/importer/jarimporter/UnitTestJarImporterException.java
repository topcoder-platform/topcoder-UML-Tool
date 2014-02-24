/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.importer.jarimporter;

import junit.framework.TestCase;

import com.topcoder.util.errorhandling.BaseCriticalException;
import com.topcoder.util.errorhandling.ExceptionData;

/**
 * This class contains unit tests for <code>JarImporterException</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTestJarImporterException extends TestCase {
    /**
     * Represents a detail message.
     */
    private static final String DETAIL_MESSAGE = "detail";

    /**
     * Represents an error cause.
     */
    private static final Throwable CAUSE = new Exception("UnitTest");

    /**
     * <p>
     * Represents the exception data.
     * </p>
     */
    private static final ExceptionData EXCEPTION_DATA = new ExceptionData();

    /**
     * <p>
     * Represents the application code set in exception data.
     * </p>
     */
    private static final String APPLICATION_CODE = "Accuracy";

    static {
        EXCEPTION_DATA.setApplicationCode(APPLICATION_CODE);
    }

    /**
     * <p>
     * <code>JarImporterException</code> should be subclass of <code>BaseCriticalException</code>.
     * </p>
     */
    public void testInheritance() {
        assertTrue("JarImporterException should be subclass of BaseCriticalException",
            JarImporterException.class.getSuperclass() == BaseCriticalException.class);
    }

    /**
     * <p>
     * Tests accuracy of <code>JarImporterException(String)</code> constructor. The detail error
     * message should be properly set.
     * </p>
     */
    public void testCtor1() {
        // Construct JarImporterException with a detail message
        JarImporterException exception = new JarImporterException(DETAIL_MESSAGE);

        // Verify that there is a detail message
        assertNotNull("Should have message.", exception.getMessage());
        assertEquals("Detailed error message should be identical.", DETAIL_MESSAGE, exception
            .getMessage());
    }

    /**
     * <p>
     * Tests accuracy of <code>JarImporterException(String, Throwable)</code> constructor. The
     * detail error message and the original cause of error should be properly set.
     * </p>
     */
    public void testCtor2() {
        // Construct JarImporterException with a detail message and a cause
        JarImporterException exception = new JarImporterException(DETAIL_MESSAGE, CAUSE);

        // Verify that there is a detail message
        assertNotNull("Should have message.", exception.getMessage());
        assertEquals("Detailed error message with cause should be properly set.", DETAIL_MESSAGE,
            exception.getMessage());

        // Verify that there is a cause
        assertNotNull("Should have cause.", exception.getCause());
        assertSame("Cause should be identical.", CAUSE, exception.getCause());
    }

    /**
     * <p>
     * Tests accuracy of <code>JarImporterException(String, ExceptionData)</code> constructor. The
     * detail error message and the exception data should be properly set.
     * </p>
     */
    public void testCtor3() {
        // Construct JarImporterException with a detail message and a cause
        JarImporterException exception = new JarImporterException(DETAIL_MESSAGE, EXCEPTION_DATA);

        // Verify that there is a detail message
        assertNotNull("Should have message.", exception.getMessage());
        assertEquals("Detailed error message with cause should be properly set.", DETAIL_MESSAGE,
            exception.getMessage());

        // Verify that the exception data is correctly set.
        assertNotNull("application code should not null", exception.getApplicationCode());
        assertEquals("exception data is not set.", APPLICATION_CODE, exception.getApplicationCode());
    }

    /**
     * <p>
     * Tests accuracy of <code>JarImporterException(String, Throwable, ExceptionData)
     * </code>
     * constructor. The detail error message, the cause exception and the exception data should be
     * properly set.
     * </p>
     */
    public void testCtor4() {
        // Construct JarImporterException with a detail message and a cause
        JarImporterException exception = new JarImporterException(DETAIL_MESSAGE, CAUSE,
            EXCEPTION_DATA);

        // Verify that there is a detail message
        assertNotNull("Should have message.", exception.getMessage());
        assertEquals("Detailed error message with cause should be properly set.", DETAIL_MESSAGE,
            exception.getMessage());

        // Verify that the exception data is correctly set.
        assertNotNull("application code should not null", exception.getApplicationCode());
        assertEquals("exception data is not set.", APPLICATION_CODE, exception.getApplicationCode());

        // Verify that there is a cause
        assertNotNull("Should have cause.", exception.getCause());
        assertSame("Cause should be identical.", CAUSE, exception.getCause());
    }
}
