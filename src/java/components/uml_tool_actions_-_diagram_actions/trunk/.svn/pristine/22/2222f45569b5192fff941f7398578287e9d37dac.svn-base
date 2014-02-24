/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for {@link UndoableActionException} class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UndoableActionExceptionTest extends TestCase {
    /**
     * <p>
     * A error message used for testing.
     * </p>
     */
    private static final String ERROR_MESSAGE = "error message";

    /**
     * <p>
     * A Throwable instance used for testing.
     * </p>
     */
    private static final Throwable CAUSE = new Throwable();

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(UndoableActionExceptionTest.class);
    }

    /**
     * <p>
     * Tests constructor UndoableActionException(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UndoableActionException(message) is correct.
     * </p>
     */
    public void testCtor() {
        UndoableActionException e = new UndoableActionException(ERROR_MESSAGE);
        assertNotNull("The UndoableActionException instance should not be null.", e);
        assertEquals("The error message is incorrect.", ERROR_MESSAGE, e.getMessage());
        assertNull("The inner CAUSE should be null", e.getCause());
    }

    /**
     * <p>
     * Tests constructor UndoableActionException(String) for accuracy.
     * </p>
     * <p>
     * It tests the case that the message is null and expects no Exception.
     * </p>
     */
    public void testCtorWithNullString() {
        // no exception
        assertNotNull("The UndoableActionException instance should not be null.", new UndoableActionException(null));
    }

    /**
     * <p>
     * Tests constructor UndoableActionException(String) for accuracy.
     * </p>
     * <p>
     * It tests the case that the message is empty and expects no Exception.
     * </p>
     */
    public void testCtorWithEmptyString() {
        // no exception
        assertNotNull("The UndoableActionException instance should not be null.", new UndoableActionException(" "));
    }

    /**
     * <p>
     * Tests constructor UndoableActionException(String, Throwable) for accuracy.
     * </p>
     *
     * <p>
     * Verify: the UndoableActionException(String, Throwable) is correct.
     * </p>
     */
    public void testCtor2() {
        UndoableActionException e = new UndoableActionException(ERROR_MESSAGE, CAUSE);
        assertNotNull("The UndoableActionException instance should not be null.", e);
        assertTrue("The error message is incorrect.", e.getMessage().startsWith(ERROR_MESSAGE));
        assertSame("The inner CAUSE is incorrect", CAUSE, e.getCause());
    }

    /**
     * <p>
     * Tests constructor UndoableActionException(String, Throwable) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the message is null and expects no Exception.
     * </p>
     */
    public void testCtor2WithNullString() {
        // no exception
        assertNotNull("The UndoableActionException instance should not be null.",
                new UndoableActionException(null, CAUSE));
    }

    /**
     * <p>
     * Tests constructor UndoableActionException(String, Throwable) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the message is empty and expects no Exception.
     * </p>
     */
    public void testCtor2WithEmptyString() {
        // no exception
        assertNotNull("The UndoableActionException instance should not be null.",
                new UndoableActionException(" ", CAUSE));
    }

    /**
     * <p>
     * Tests constructor UndoableActionException(String, Throwable) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the cause is null and expects no Exception.
     * </p>
     */
    public void testCtor2WithNullCause() {
        // no exception
        UndoableActionException e = new UndoableActionException(ERROR_MESSAGE, null);
        assertNotNull("The UndoableActionException instance should not be null.", e);
        assertNull("The CAUSE should be null.", e.getCause());
    }

}
