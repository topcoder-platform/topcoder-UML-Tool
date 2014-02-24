/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import com.topcoder.uml.actions.model.usecase.InvalidDataContentException;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>InvalidDataContentException</code> exception.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestInvalidDataContentException extends TestCase {

    /**
     * Test the constructor <code>InvalidDataContentException(String)</code>.
     */
    public void testConstructor() {
        InvalidDataContentException idce = new InvalidDataContentException("Failed");
        assertNotNull("Instance of InvalidDataContentException should be created.", idce);
        assertTrue("The message field should be set.", idce.getMessage().endsWith("Failed"));
    }

    /**
     * Test the constructor <code>InvalidDataContentException(String, Throwable)</code>.
     */
    public void testConstructorWithCause() {
        Throwable cause = new Exception();
        InvalidDataContentException idce = new InvalidDataContentException("Failed", cause);
        assertNotNull("Instance of InvalidDataContentException should be created.", idce);
        assertTrue("The message field should be set.", idce.getMessage().startsWith("Failed"));
        assertTrue("The cause field should be set.", idce.getCause().equals(cause));
    }
}
