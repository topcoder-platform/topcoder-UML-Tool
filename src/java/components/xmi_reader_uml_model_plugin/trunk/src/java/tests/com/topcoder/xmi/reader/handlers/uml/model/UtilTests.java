/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.model;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for Util.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UtilTests extends TestCase {

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(UtilTests.class);
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) for accuracy.
     * </p>
     */
    public void testCheckNull() {
        Util.checkNull("", "test");
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckNull_NullArg() {
        try {
            Util.checkNull(null, "test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for accuracy.
     * </p>
     */
    public void testCheckString() {
        Util.checkString("test", "test");
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_NullArg() {
        try {
            Util.checkString(null, "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_EmptyArg() {
        try {
            Util.checkString(" ", "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}