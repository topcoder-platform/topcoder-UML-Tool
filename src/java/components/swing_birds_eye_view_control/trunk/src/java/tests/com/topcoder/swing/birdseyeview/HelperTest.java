/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

import java.lang.reflect.Constructor;

import junit.framework.TestCase;


/**
 * <p>
 * Unit tests for the <code>Helper</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HelperTest extends TestCase {
    /**
     * <p>
     * Accuracy test for the private constructor.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtorAccuracy() throws Exception {
        Constructor<Helper> constructor = Helper.class.getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);

        Object obj = constructor.newInstance(new Object[0]);
        assertTrue("The constructor can be accessed properly through reflect.",
            obj instanceof Helper);
    }

    /**
     * <p>
     * Accuracy test for the method <code>checkNull(Object arg, String name)</code> with the object is not null,
     * expects no error occurs.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCheckNullAccuracy() throws Exception {
        Helper.checkNull("arg", "name");
    }

    /**
     * <p>
     * Failure test for the method <code>checkNull(Object arg, String name)</code> with arg is null,
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCheckNullWithNull() throws Exception {
        try {
            Helper.checkNull(null, "name");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>checkNullOrEmpty(String arg, String name)</code> with arg is not null or
     * empty, expects no error occurs.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCheckNullOrEmptyAccuracy() throws Exception {
        Helper.checkNullOrEmpty("arg", "name");
    }

    /**
     * <p>
     * Failure test for the method <code>checkNullOrEmpty(String arg, String name)</code> with arg is null,
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCheckNullOrEmptyWithNull() throws Exception {
        try {
            Helper.checkNullOrEmpty(null, "name");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for the method <code>checkNullOrEmpty(String arg, String name)</code> with arg is empty,
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCheckNullOrEmptyWithEmpty() throws Exception {
        try {
            Helper.checkNullOrEmpty("", "name");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for the method <code>checkNullOrEmpty(String arg, String name)</code> with arg is trimmed empty,
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCheckNullOrEmptyWithTrimmedEmpty()
        throws Exception {
        try {
            Helper.checkNullOrEmpty(" \t\r\n ", "name");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test the method of convertStringToInt.
     * </p>
     */
    public void testConverStringToInt() {
        assertNull("null should be returned if the input value is invalid.",
                Helper.convertStringToInt("123 "));
        assertNull("null should be returned if the input value is invalid.",
                Helper.convertStringToInt(" "));
        assertNull("null should be returned if the input value is invalid.",
                Helper.convertStringToInt(null));
        assertEquals("Should return the expected value.",
                123, (int) Helper.convertStringToInt("123"));
    }

    /**
     * <p>
     * Test the method of convertStringToDouble.
     * </p>
     */
    public void testConverStringToDouble() {
        assertNull("null should be returned if the input value is invalid.",
                Helper.convertStringToInt("123. "));
        assertNull("null should be returned if the input value is invalid.",
                Helper.convertStringToInt(" "));
        assertNull("null should be returned if the input value is invalid.",
                Helper.convertStringToInt(null));
        assertEquals("Should return the expected value.",
                123.123, (double) Helper.convertStringToDouble("123.123"));
    }
    /**
     * <p>
     * Test the method of compareDouble.
     * </p>
     */
    public void testCompareDouble() {
        double d1 = 0.01;
        double d2 = 0.01000001;
        assertTrue("The two numbers should be equal.", Helper.compareDoubles(d1, d2));
        d1 = 0.01;
        d2 = 0.0100001;
        assertFalse("The two numbers should do not equal.", Helper.compareDoubles(d1, d2));
    }
}
