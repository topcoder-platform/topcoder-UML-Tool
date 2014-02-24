/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This the unit tests of the {@link Helper} class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HelperTest extends TestCase {

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(HelperTest.class);
    }

    /**
     * <p>
     * Test method for 'checkNotNull(Object, String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the object is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckNotNullWithNull() {
        try {
            Helper.checkNotNull(null, "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Test method for 'checkNotNull(Object, String)' for accuracy.
     * </p>
     */
    public void testCheckNotNull() {
        // ok
        Helper.checkNotNull(new Object(), "test");
    }

    /**
     * <p>
     * Test method for 'checkElementNotNull(Object, String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the object is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckElementNotNulWithNull() {
        try {
            Helper.checkElementNotNull(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Test method for 'checkElementNotNull(Object, String)' for accuracy.
     * </p>
     */
    public void testCheckElementNotNul() {
        // ok
        Helper.checkElementNotNull(new Object());
    }

}
