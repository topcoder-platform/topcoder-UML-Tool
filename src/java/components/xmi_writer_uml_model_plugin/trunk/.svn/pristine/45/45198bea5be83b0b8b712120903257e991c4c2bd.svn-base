/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.model.DuplicateElementException;

import junit.framework.TestCase;
/**
 * <p>
 * Unit test cases for DuplicateElementException.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DuplicateElementExceptionTests extends TestCase {
    /** The test message. */
    private static final String ERROR_MESSAGE = "test exception message";
    /**
     * Test the constructor of the exception.
     *
     */
    public void test_DuplicateElementException1() {
        assertNotNull("Can not create the DuplicateElementException.",
                new DuplicateElementException(ERROR_MESSAGE, new Object()));
    }
    /**
     * Inheritance test.
     */
    public void testDescriptionRetrievalException2() {
        assertTrue("DescriptionRetrievalException does not subclass XMITransformException.",
                new DuplicateElementException(ERROR_MESSAGE, new Object()) instanceof XMITransformException);
    }
    /**
     * Test the method get element.
     *
     */
    public void test_getElement() {
        Object obj = new Object();
        DuplicateElementException e = new DuplicateElementException(ERROR_MESSAGE, obj);
        assertTrue("The obj should be same as set in constructor.", obj == e.getElement());
    }
}
