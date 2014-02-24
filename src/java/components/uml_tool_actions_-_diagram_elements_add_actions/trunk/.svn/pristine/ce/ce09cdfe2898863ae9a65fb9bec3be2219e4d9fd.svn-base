/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

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
     * Tests Util#checkNull(Object,String) method.
     * It test the case when a not null object is passed in and expects success.
     * </p>
     */
    public void testCheckNull_NotNullObject() {
        Util.checkNull("", "test");
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) method.
     * It test the case when a null object is passed in and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckNull_NullObject() {
        try {
            Util.checkNull(null, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}