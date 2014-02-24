/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.model.UnknownElementTypeException;

import junit.framework.TestCase;
/**
 * <p>
 * Unit test cases for UnknownElementTypeException.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnknownElementTypeExceptionTests extends TestCase {
    /** The test message. */
    private static final String ERROR_MESSAGE = "test exception message";
    /**
     * Test the constructor of the exception.
     *
     */
    public void test_UnknownElementTypeException1() {
        assertNotNull("Can not create the UnknownElementTypeException.",
                new UnknownElementTypeException(ERROR_MESSAGE, Object.class));
    }
    /**
     * Inheritance test.
     */
    public void testDescriptionRetrievalException2() {
        assertTrue("DescriptionRetrievalException does not subclass XMITransformException.",
                new UnknownElementTypeException(ERROR_MESSAGE, Object.class) instanceof XMITransformException);
    }
    /**
     * Test the method get element.
     *
     */
    public void test_getElement() {
        UnknownElementTypeException e = new UnknownElementTypeException(ERROR_MESSAGE, Object.class);
        assertTrue("The obj should be same as set in constructor.", Object.class == e.getElementType());
    }
}
