/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.model.DescriptionRetrievalException;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for DescriptionRetrievalException.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DescriptionRetrievalExceptionTests extends TestCase {
    /** The test message. */
    private static final String ERROR_MESSAGE = "test exception message";

    /**
     * the cause Exception.
     */
    private final Exception cause = new NullPointerException();

    /**
     * test the excption constructor with ERROR_MESSAGE.
     */
    public void testDescriptionRetrievalException1() {
        DescriptionRetrievalException de = new DescriptionRetrievalException(ERROR_MESSAGE);
        assertNotNull("Unable to instantiate DescriptionRetrievalException.", de);

        assertEquals("Error message is not properly propagated to super class.",
            ERROR_MESSAGE, de.getMessage());
        assertTrue("The error message should match.",
            de.getMessage().indexOf(ERROR_MESSAGE) >= 0);
    }

    /**
     * test the excption constructor with ERROR_MESSAGE and throwable.
     */
    public void testDescriptionRetrievalException2() {
        DescriptionRetrievalException de = new DescriptionRetrievalException(ERROR_MESSAGE, cause);

        assertNotNull("Unable to instantiate DescriptionRetrievalException.", de);

        assertEquals("Cause is not properly propagated to super class.", cause,
            de.getCause());
    }

    /**
     * Inheritance test.
     */
    public void testDescriptionRetrievalException3() {
        assertTrue("DescriptionRetrievalException does not subclass XMITransformException.",
            new DescriptionRetrievalException(ERROR_MESSAGE) instanceof XMITransformException);

        assertTrue("DescriptionRetrievalException does not subclass XMITransformException.",
            new DescriptionRetrievalException(ERROR_MESSAGE, cause) instanceof XMITransformException);
    }
}
