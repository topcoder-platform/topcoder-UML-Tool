/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import junit.framework.TestCase;


/**
 * Unit tests for {@link CodeGenerationException}.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestCodeGenerationException extends TestCase {
    /**
     * An exception message.
     */
    private static final String MESSAGE = "Something went horrible wrong";

    /**
     * Checks if the message is set correctly.
     */
    public void testCodeGenerationExceptionString() {
        CodeGenerationException ex = new CodeGenerationException(MESSAGE);
        assertEquals("message", MESSAGE, ex.getMessage());
        assertNull("cause", ex.getCause());
    }

    /**
     * Checks if the message and the cause are set correctly.
     */
    public void testCodeGenerationExceptionStringException() {
        Exception cause = new Exception();
        CodeGenerationException ex = new CodeGenerationException(MESSAGE, cause);
        assertTrue("message", ex.getMessage().startsWith(MESSAGE));
        assertEquals("cause", cause, ex.getCause());
    }
}
