/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for EdgeLayoutException.
 * </p>
 *
 * <p>
 * This class is pretty simple. The test cases simply verifies the exception can be instantiated
 * with the error message and cause properly propagated, and that it comes with correct inheritance.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.1
 */
public class EdgeLayoutExceptionTests extends TestCase {

    /**
     * <p>
     * The error message used for testing.
     * </p>
     */
    private static final String ERROR_MESSAGE = "test error message";

    /**
     * <p>
     * An exception instance used to create the EdgeLayoutException.
     * </p>
     */
    private static final Exception CAUSE_EXCEPTION = new NullPointerException();

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(EdgeLayoutExceptionTests.class);
    }

    /**
     * <p>
     * Creation test.
     * </p>
     *
     * <p>
     * It verifies the newly created exception instance should not be null.
     * </p>
     */
    public void testEdgeLayoutExceptionTests_Ctor() {
        EdgeLayoutException exception = new EdgeLayoutException(ERROR_MESSAGE);
        assertNotNull("Unable to instantiate EdgeLayoutException.", exception);
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
    public void testEdgeLayoutException_Msg() {
        EdgeLayoutException exception = new EdgeLayoutException(ERROR_MESSAGE);
        assertNotNull("Unable to instantiate EdgeLayoutException.", exception);
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
    public void testEdgeLayoutException_MsgCause() {
        EdgeLayoutException exception = new EdgeLayoutException(ERROR_MESSAGE, CAUSE_EXCEPTION);

        assertNotNull("Unable to instantiate EdgeLayoutException.", exception);
        assertTrue("The error message should match", exception.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("Cause is not properly propagated to super class.", CAUSE_EXCEPTION, exception.getCause());
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies EdgeLayoutException subclasses Exception.
     * </p>
     */
    public void testEdgeLayoutExceptionInheritance_Msg() {
        EdgeLayoutException exception = new EdgeLayoutException(ERROR_MESSAGE);
        assertTrue("EdgeLayoutException does not subclass Exception.", exception instanceof Exception);
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies EdgeLayoutException subclasses Exception.
     * </p>
     */
    public void testEdgeLayoutExceptionInheritance_MsgCause() {
        EdgeLayoutException exception = new EdgeLayoutException(ERROR_MESSAGE, CAUSE_EXCEPTION);
        assertTrue("EdgeLayoutException does not subclass Exception.", exception instanceof Exception);
    }
}
