/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom.failuretests;

import com.topcoder.gui.panels.zoom.transform.NatureZoomTransform;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code> NatureZoomTransform</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class NatureZoomTransformFailureTest extends TestCase {

    /**
     * <p>
     * A negative number used to for failure testing.
     * </p>
     */
    private double factor = -1e-7;

    /**
     * <p>
     * A negative number used to for failure testing.
     * </p>
     */
    private double zero = 0;

    /**
     * <p>
     * The NatureZoomTransform instance created for testing.
     * </p>
     */
    private NatureZoomTransform transform;

    /**
     * <p>
     * Set up the environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        transform = new NatureZoomTransform();
    }

    /**
     * <p>
     * Clear environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        transform = null;
    }

    /**
     * <p>
     * Failure test for <code>NatureZoomTransform(double zoomFactor)</code>.
     * </p>
     * <p>
     * zoomFactor is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testNatureZoomTransformNegative() {
        try {
            new NatureZoomTransform(factor);
            fail("zoomFactor is negative, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>NatureZoomTransform(double zoomFactor)</code>.
     * </p>
     * <p>
     * zoomFactor is 0, IllegalArgumentException is expected.
     * </p>
     */
    public void testNatureZoomTransformZero() {
        try {
            new NatureZoomTransform(zero);
            fail("zoomFactor is 0, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>setZoomFactor(double zoomFactor)</code>.
     * </p>
     * <p>
     * zoomFactor is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetZoomFactorNegative() {
        try {
            transform.setZoomFactor(factor);
            fail("zoomFactor is negative, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>setZoomFactor(double zoomFactor)</code>.
     * </p>
     * <p>
     * zoomFactor is 0, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetZoomFactor() {
        try {
            transform.setZoomFactor(zero);
            fail("zoomFactor is 0, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>applyTransform(Graphics2D graphics)</code>.
     * </p>
     * <p>
     * graphics is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testApplyTransform() {
        try {
            transform.applyTransform(null);
            fail("graphics is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>applyInverseTransform(MouseEvent event)</code>.
     * </p>
     * <p>
     * event is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testApplyInverseTransform() {
        try {
            transform.applyInverseTransform(null);
            fail("event is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
