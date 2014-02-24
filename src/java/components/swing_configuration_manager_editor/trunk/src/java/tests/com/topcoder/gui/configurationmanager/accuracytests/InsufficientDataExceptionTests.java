/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.accuracytests;

import junit.framework.TestCase;

import com.topcoder.gui.configurationmanager.InsufficientDataException;
import com.topcoder.util.errorhandling.ExceptionData;

/**
 * <p>
 * This class contains a set of tests for {@link InsufficientDataException} class.
 * </p>
 *
 * @author uhmateush
 * @version 1.0
 */
public class InsufficientDataExceptionTests extends TestCase {

    /**
     * <p>
     * Represents a message for tests.
     * </p>
     */
    private static final String TEST_MESSAGE = "test";

    /**
     * <p>
     * Represents a message for tests.
     * </p>
     */
    private static final String MESSAGE = "message";

    /**
     * <p>
     * Represents an data for tests.
     * </p>
     */
    private ExceptionData data;

    /**
     * <p>
     * Represents a cause for tests.
     * </p>
     */
    private IllegalStateException cause;

    /**
     * <p>
     * Initializes test environment.
     * </p>
     *
     * @throws Exception exception to jUnit.
     */
    protected void setUp() throws Exception {
        data = new ExceptionData();
        data.setApplicationCode(MESSAGE);

        cause = new IllegalStateException(MESSAGE + TEST_MESSAGE);
    }

    /**
     * <p>
     * Tests constructor with <code>String</code> parameter.
     * </p>
     */
    public void testConstructor0() {
        InsufficientDataException e = new InsufficientDataException(TEST_MESSAGE);
        assertEquals("The returned message should be equal to set.", TEST_MESSAGE, e.getMessage());
    }

    /**
     * <p>
     * Tests constructor with <code>String</code>, <code>Throwable</code> parameter.
     * </p>
     */
    public void testConstructor1() {
        InsufficientDataException e
            = new InsufficientDataException(TEST_MESSAGE, cause);
        assertEquals("The message is incorrect.", TEST_MESSAGE, e.getMessage());
        assertEquals("The inner exception is incorrect.", cause, e.getCause());
    }

    /**
     * <p>
     * Tests constructor with <code>String</code>, <code>ExceptionData</code> parameter.
     * </p>
     */
    public void testConstructor2() {
        InsufficientDataException e
            = new InsufficientDataException(TEST_MESSAGE, data);
        assertEquals("The message is incorrect.", TEST_MESSAGE, e.getMessage());
        assertEquals("The cause is incorrect.", MESSAGE, e.getApplicationCode());
    }

    /**
     * <p>
     * Tests constructor with <code>String</code>, <code>Throwable</code>, <code>ExceptionData</code> parameter.
     * </p>
     */
    public void testConstructor3() {
        InsufficientDataException e
            = new InsufficientDataException(TEST_MESSAGE, cause, data);
        assertEquals("The message is incorrect.", TEST_MESSAGE, e.getMessage());
        assertEquals("The application code is incorrect.", MESSAGE, e.getApplicationCode());
        assertEquals("The cause is incorrect.", cause, e.getCause());
    }
}