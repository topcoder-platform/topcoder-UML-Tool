/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import java.awt.Point;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for <code>Helper</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HelperTests extends TestCase {

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
    }

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(HelperTests.class);
    }

    /**
     * <p>
     * Tests Helper#checkNull(Object, String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Helper#checkNull(Object, String) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckNull() throws Exception {
        try {
            Helper.checkNull("non-null", "non-null");
        } catch (IllegalArgumentException e) {
            fail("IAE should not be thrown.");
        }
    }

    /**
     * <p>
     * Tests Helper#checkNull(Object, String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckNull_Null() throws Exception {
        try {
            Helper.checkNull(null, "null");
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Helper#checkNotPositive(int, String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Helper#checkNotPositive(int, String) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckNotPositive() throws Exception {
        try {
            Helper.checkNotPositive(3, "positive");
        } catch (IllegalArgumentException e) {
            fail("IAE should not be thrown.");
        }
    }

    /**
     * <p>
     * Tests Helper#checkNotPositive(int, String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is zero and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckNotPositive_Zero() throws Exception {
        try {
            Helper.checkNotPositive(0, "zero");
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Helper#checkNotPositive(int, String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckNotPositive_Negative() throws Exception {
        try {
            Helper.checkNotPositive(-3, "negative");
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Helper#checkNegative(int, String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Helper#checkNegative(int, String) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckNegative() throws Exception {
        try {
            Helper.checkNegative(3, "positive");
            Helper.checkNegative(0, "zero");
        } catch (IllegalArgumentException e) {
            fail("IAE should not be thrown.");
        }
    }

    /**
     * <p>
     * Tests Helper#checkNegative(int, String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckNegative_Negative() throws Exception {
        try {
            Helper.checkNegative(-3, "negative");
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Helper#checkPoint(Point, String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Helper#checkPoint(Point, String) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckPoint() throws Exception {
        try {
            Helper.checkPoint(new Point(3, 7), "valid point");
        } catch (IllegalArgumentException e) {
            fail("IAE should not be thrown.");
        }
    }

    /**
     * <p>
     * Tests Helper#checkPoint(Point, String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckPoint_Null() throws Exception {
        try {
            Helper.checkPoint(null, "null point");
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Helper#checkPoint(Point, String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when x is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckPoint_X_Negative() throws Exception {
        try {
            Helper.checkPoint(new Point(-3, 7), "invalid point");
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Helper#checkPoint(Point, String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when y is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCheckPoint_Y_Negative() throws Exception {
        try {
            Helper.checkPoint(new Point(3, -7), "invalid point");
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}
