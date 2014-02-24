/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>{@link ElementAlreadyExistsException}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class ElementAlreadyExistsExceptionUnitTest extends TestCase {
    /**
     * Represents a string with a detail message.
     */
    private static final String DETAIL_MESSAGE = "detail";

    /**
     * Represents the element object already exist.
     */
    private static final Object ELEMENT = new Object();

    /**
     * <p>
     * Unit test for <code>{@link ElementAlreadyExistsException#ElementAlreadyExistsException(String, Object)}</code>
     * constructor.
     * </p>
     * <p>
     * The detail error message and the element object already exist should be correct.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testElementAlreadyExistsExceptionStringObjectAccuracy() throws Exception {
        // Construct ElementAlreadyExistsException with a detail message and the element object.
        ElementAlreadyExistsException exception = new ElementAlreadyExistsException(DETAIL_MESSAGE, ELEMENT);

        // Verify that there is a detail message
        assertNotNull("Should have message.", exception.getMessage());
        assertEquals("Detailed error message should be identical.", DETAIL_MESSAGE, exception.getMessage());
        Object element = TestHelper.getFieldValue(exception, "element");
        assertNotNull("Should have message.", element);
        assertSame("Detailed error message should be identical.", ELEMENT, element);
    }

    /**
     * <p>
     * Unit test for <code>{@link ElementAlreadyExistsException#getElement()}</code> method.
     * </p>
     * <p>
     * Should return the element set while constructing the object.
     * </p>
     */
    public void testGetElementAccuracy() {
        // Construct ElementAlreadyExistsException with a detail message and the element object.
        ElementAlreadyExistsException exception = new ElementAlreadyExistsException(DETAIL_MESSAGE, ELEMENT);

        // Verify that there is a detail message
        Object element = exception.getElement();
        assertNotNull("Should have message.", element);
        assertSame("Detailed error message should be identical.", ELEMENT, element);
    }
}
