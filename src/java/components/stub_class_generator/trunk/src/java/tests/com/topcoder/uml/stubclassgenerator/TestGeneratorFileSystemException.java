/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import junit.framework.TestCase;


/**
 * Unit tests for {@link GeneratorFileSystemException}.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestGeneratorFileSystemException extends TestCase {
    /**
     * An exception message.
     */
    private static final String MESSAGE = "Something went horrible wrong";

    /**
     * Checks if the message is set correctly.
     */
    public void testGeneratorFileSystemExceptionString() {
        GeneratorFileSystemException ex = new GeneratorFileSystemException(MESSAGE);
        assertEquals("message", MESSAGE, ex.getMessage());
        assertNull("cause", ex.getCause());
    }

    /**
     * Checks if the message and the cause are set correctly.
     */
    public void testGeneratorFileSystemExceptionStringException() {
        Exception cause = new Exception();
        GeneratorFileSystemException ex = new GeneratorFileSystemException(MESSAGE, cause);
        assertTrue("message", ex.getMessage().startsWith(MESSAGE));
        assertEquals("cause", cause, ex.getCause());
    }
}
