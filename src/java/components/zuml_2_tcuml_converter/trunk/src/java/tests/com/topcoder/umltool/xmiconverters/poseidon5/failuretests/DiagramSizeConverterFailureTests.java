/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import junit.framework.TestCase;

import com.topcoder.umltool.xmiconverters.poseidon5.converters.DiagramSizeConverter;

/**
 * <p>
 * Failure test fixture for <code>DiagramSizeConverter</code> class.
 * </p>
 * @author Thinfox
 * @version 1.0
 */
public class DiagramSizeConverterFailureTests extends TestCase {
    /**
     * <p>
     * Tests the ctor <code>DiagramSizeConverter(double, double, double)</code>.
     * </p>
     * <p>
     * When the emptyWidth is NaN, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_NaNEmptyWidth() {
        try {
            new DiagramSizeConverter(Double.NaN, 0, 0);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>DiagramSizeConverter(double, double, double)</code>.
     * </p>
     * <p>
     * When the emptyHeight is NaN, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_NaNEmptyHeight() {
        try {
            new DiagramSizeConverter(0, Double.NaN, 0);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>DiagramSizeConverter(double, double, double)</code>.
     * </p>
     * <p>
     * When the margin is NaN, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_NaNMargin() {
        try {
            new DiagramSizeConverter(0, 0, Double.NaN);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>DiagramSizeConverter(double, double, double)</code>.
     * </p>
     * <p>
     * When the emptyWidth is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_NegativeEmptyWidth() {
        try {
            new DiagramSizeConverter(-1, 0, 0);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>DiagramSizeConverter(double, double, double)</code>.
     * </p>
     * <p>
     * When the emptyHeight is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_NegativeEmptyHeight() {
        try {
            new DiagramSizeConverter(0, -1, 0);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>DiagramSizeConverter(double, double, double)</code>.
     * </p>
     * <p>
     * When the margin is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_NegativeMargin() {
        try {
            new DiagramSizeConverter(0, 0, -1);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
