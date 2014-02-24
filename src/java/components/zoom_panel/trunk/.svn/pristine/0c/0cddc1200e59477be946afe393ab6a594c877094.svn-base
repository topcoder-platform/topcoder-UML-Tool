/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom;

import java.awt.geom.AffineTransform;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>{@link Helper}</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HelperUnitTest extends TestCase {

    /**
     * <p>
     * Test of validateObject with null <code>Object</code> value. <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testValidateObjectWithNullObject() {
        try {
            Helper.validateObject(null, "test");
            fail("If the object parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of validateObject for accuracy.
     * </p>
     */
    public void testValidateObjectAccuracy() {
        try {
            Helper.validateObject(new Object(), "test");
        } catch (IllegalArgumentException e) {
            fail("If the object parameter is not null, should not throw IllegalArgumentException.");
        }
    }

    /**
     * <p>
     * Test of validateAffineTransform for accuracy. Using an AffineTransform which can be inversed. An AffineTransform
     * clone is expected.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testValidateAffineTransformAccuray() throws Exception {
        AffineTransform at = new AffineTransform();
        assertTrue("should be equal", at.equals(Helper.validateAffineTransform(at)));
    }

    /**
     * <p>
     * Test of validateAffineTransform for failure. Using an AffineTransform which can not be inversed.
     * IllegalArgumentException is expected
     * </p>
     */
    public void testValidateAffineTransformFailureWithUnInversable() {
        try {
            AffineTransform at = new AffineTransform(0, 0, 0, 0, 0, 0);
            Helper.validateAffineTransform(at);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of validateDouble for accuracy.
     * </p>
     */
    public void testValidateDoubleAccuracy() {
        double expected = 0.1;
        assertEquals("should be equal", expected, Helper.validateDouble(expected, "expected"), Helper.EPSILON);
    }

    /**
     * <p>
     * Test of validateDouble for failure. With 0 passed in IllegalArgumentException is expected.
     * </p>
     */
    public void testValidateDoubleFailureWithZero() {
        try {
            Helper.validateDouble(0, "test");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of validateDouble for failure. With negative passed in IllegalArgumentException is expected.
     * </p>
     */
    public void testValidateDoubleFailureWithNegative() {
        try {
            Helper.validateDouble(-3.0, "test");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of castDouble2Int for accuracy with 0.000000001, 0 is expected.
     * </p>
     */
    public void testCaseDouble2IntAccuracyWithSmall() {
        assertEquals("should be equal", 0, Helper.castDouble2Int(0.000000001));
    }

    /**
     * <p>
     * Test of castDouble2Int for accuracy with NaN, 0 is expected.
     * </p>
     */
    public void testCaseDouble2IntAccuracyWithNan() {
        assertEquals("should be equal", 0, Helper.castDouble2Int(Double.NaN));
    }

    /**
     * <p>
     * Test of castDouble2Int for accuracy with double bigger than Integer.MAX_VALUE, Integer.MAX_VALUE is expected.
     * </p>
     */
    public void testCaseDouble2IntAccuracyWithDoubleMax() {
        assertEquals("should be equal", Integer.MAX_VALUE, Helper.castDouble2Int(Integer.MAX_VALUE + 100.1));
    }

    /**
     * <p>
     * Test of validateIntNotNegative for accuracy.
     * </p>
     */
    public void testValidateIntNotNegativeAccuracy() {
        assertEquals("should be equal", 3, Helper.validateIntNotNegative(3, "test"));
    }

    /**
     * <p>
     * Test of validateIntNotNegative for failure with negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testValidateIntNotNegativeFailureWithNegative() {
        try {
            Helper.validateIntNotNegative(-3, "test");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
