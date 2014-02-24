/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.model.NodeValueRetrievalException;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test cases for NodeValueRetrievalException.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class NodeValueRetrievalExceptionTests extends TestCase {
    /** The test message. */
    private static final String ERROR_MESSAGE = "test exception message";

    /**
     * the cause Exception.
     */
    private final Exception cause = new NullPointerException();

    /**
     * test the excption constructor with ERROR_MESSAGE.
     */
    public void testNodeValueRetrievalException1() {
        NodeValueRetrievalException de = new NodeValueRetrievalException(ERROR_MESSAGE);
        assertNotNull("Unable to instantiate NodeValueRetrievalException.", de);

        assertEquals("Error message is not properly propagated to super class.",
            ERROR_MESSAGE, de.getMessage());
        assertTrue("The error message should match.",
            de.getMessage().indexOf(ERROR_MESSAGE) >= 0);
    }

    /**
     * test the excption constructor with ERROR_MESSAGE and throwable.
     */
    public void testNodeValueRetrievalException2() {
        NodeValueRetrievalException de = new NodeValueRetrievalException(ERROR_MESSAGE, cause);

        assertNotNull("Unable to instantiate NodeValueRetrievalException.", de);

        assertEquals("Cause is not properly propagated to super class.", cause,
            de.getCause());
    }

    /**
     * Inheritance test.
     */
    public void testNodeValueRetrievalException3() {
        assertTrue("NodeValueRetrievalException does not subclass XMITransformException.",
            new NodeValueRetrievalException(ERROR_MESSAGE) instanceof XMITransformException);

        assertTrue("NodeValueRetrievalException does not subclass XMITransformException.",
            new NodeValueRetrievalException(ERROR_MESSAGE, cause) instanceof XMITransformException);
    }
}
