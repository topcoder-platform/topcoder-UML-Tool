/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom.failuretests;

import java.awt.geom.AffineTransform;

import com.topcoder.gui.panels.zoom.transform.AffineZoomTransform;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>AffineZoomTransform</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class AffineZoomTransformFailureTest extends TestCase {

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
     * The AffineZoomTransform instance created for testing.
     * </p>
     */
    private AffineZoomTransform transform;

    /**
     * <p>
     * The noninvertible AffineTransform instance created for testing.
     * </p>
     */
    private AffineTransform noninvertible;

    /**
     * <p>
     * Set up the environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        noninvertible = new AffineTransform(0.0, 1.0, 0.0, 1.0, 0.0, 1.0);
        transform = new AffineZoomTransform();
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
     * Failure test for <code>AffineZoomTransform(double zoomFactor)</code>.
     * </p>
     * <p>
     * zoomFactor is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testAffineZoomTransformNegative() {
        try {
            new AffineZoomTransform(factor);
            fail("zoomFactor is negative, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>AffineZoomTransform(double zoomFactor)</code>.
     * </p>
     * <p>
     * zoomFactor is 0, IllegalArgumentException is expected.
     * </p>
     */
    public void testAffineZoomTransformZero() {
        try {
            new AffineZoomTransform(zero);
            fail("zoomFactor is 0, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>AffineZoomTransform(AffineTransform transform)</code>.
     * </p>
     * <p>
     * transform is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAffineZoomTransformAffineTransformNull() {
        try {
            new AffineZoomTransform(null);
            fail("transform is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>AffineZoomTransform(AffineTransform transform)</code>.
     * </p>
     * <p>
     * transform is Noninvertible, IllegalArgumentException is expected.
     * </p>
     */
    public void testAffineZoomTransformAffineTransformNoninvertible() {
        try {
            new AffineZoomTransform(noninvertible);
            fail("transform is noninvertible, IllegalArgumentException is expected.");
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
    public void testSetZoomFactorZero() {
        try {
            transform.setZoomFactor(factor);
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

    /**
     * <p>
     * Failure test for <code>setTransform(AffineTransform transform)</code>.
     * </p>
     * <p>
     * transform is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetTransformNull() {
        try {
            transform.setTransform(null);
            fail("transform is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>setTransform(AffineTransform transform)</code>.
     * </p>
     * <p>
     * transform is noninvertible, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetTransformNoninvertible() {
        try {
            transform.setTransform(noninvertible);
            fail("transform is noninvertible, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
