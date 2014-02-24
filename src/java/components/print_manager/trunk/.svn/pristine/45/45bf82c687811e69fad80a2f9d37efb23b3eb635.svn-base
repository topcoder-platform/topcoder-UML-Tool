/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.failuretests;

import java.awt.Button;
import java.awt.Component;
import java.awt.Rectangle;

import junit.framework.TestCase;

import com.topcoder.swing.print.ScalingPrint;

/**
 * <p>
 * Failure test for <code>ScalingPrint</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class ScalingPrintFailureTest extends TestCase {
    /**
     * <p>
     * A negative double value used for failure testing.
     * </p>
     */
    private double positive = 1;

    /**
     * <p>
     * A negative double value used for failure testing.
     * </p>
     */
    private double neg = -1;

    /**
     * <p>
     * Zero.
     * </p>
     */
    private double zero = 0;

    /**
     * <p>
     * The Component instance created for failure testing.
     * </p>
     */
    private Component component = new Button();

    /**
     * <p>
     * The Rectangle instance created for failure testing.
     * </p>
     */
    private Rectangle rectangle = new Rectangle();

    /**
     * <p>
     * Failure test for
     * <code>ScalingPrint(Component component, double scaleFactor)</code>.
     * </p>
     * <p>
     * component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testScalingPrintComponentDoubleNullComponent() {
        try {
            new ScalingPrint(null, positive);
            fail("component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>ScalingPrint(Component component, double scaleFactor)</code>.
     * </p>
     * <p>
     * scaleFactor is zero, IllegalArgumentException is expected.
     * </p>
     */
    public void testScalingPrintComponentDoubleZero() {
        try {
            new ScalingPrint(component, zero);
            fail("scaleFactor is zero, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>ScalingPrint(Component component, double scaleFactor)</code>.
     * </p>
     * <p>
     * scaleFactor is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testScalingPrintComponentDoubleNeg() {
        try {
            new ScalingPrint(component, neg);
            fail("scaleFactor is negative, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Failure test for
     * <code>ScalingPrint(Component component, Rectangle rectangle, double scaleFactor)</code>.
     * </p>
     * <p>
     * component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testScalingPrintComponentRectangleDoubleNullComponent() {
        try {
            new ScalingPrint(null, rectangle, positive);
            fail("component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Failure test for
     * <code>ScalingPrint(Component component, Rectangle rectangle, double scaleFactor)</code>.
     * </p>
     * <p>
     * scaleFactor is zero, IllegalArgumentException is expected.
     * </p>
     */
    public void testScalingPrintComponentRectangleDoubleZero() {
        try {
            new ScalingPrint(component, rectangle, zero);
            fail("scaleFactor is zero, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Failure test for
     * <code>ScalingPrint(Component component, Rectangle rectangle, double scaleFactor)</code>.
     * </p>
     * <p>
     * scaleFactor is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testScalingPrintComponentRectangleDoubleNeg() {
        try {
            new ScalingPrint(component, rectangle, neg);
            fail("scaleFactor is negative, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

}
