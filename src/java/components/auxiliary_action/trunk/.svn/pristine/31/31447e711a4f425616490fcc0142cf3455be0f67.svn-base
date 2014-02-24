/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;

/**
 * Set of tests for testing AuxiliaryElementCloneException class.
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AuxiliaryElementCloneExceptionAccuracyTest extends TestCase {

    /**
     * Exception message.
     */
    private String message = "message";

    /**
     * Exception.
     */
    private Exception e = new Exception();

    /**
     * Class under test for void ResponseBuilderException(String). Accuracy
     * testing of correctly assigned exception message.
     */
    public final void testAuxiliaryElementCloneExceptionString() {
        AuxiliaryElementCloneException exception = new AuxiliaryElementCloneException(message);
        // testing for equal messages
        assertEquals("messages must be equal", message, exception.getMessage());
    }

    /**
     * Class under test for void ResponseBuilderException(String, Throwable).
     * Accuracy testing of correctly assigned message and exception.
     */
    public final void testAuxiliaryElementCloneExceptionStringThrowable() {
        AuxiliaryElementCloneException exception = new AuxiliaryElementCloneException(message, e);
        // testing for cause and message
        assertEquals("causes must be equal", e, exception.getCause());
        assertTrue("message must be included", exception.getMessage().indexOf(message) != -1);
    }
}