/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom;

import javax.swing.DebugGraphics;
import javax.swing.JComponent;
import javax.swing.JLabel;

import com.topcoder.gui.panels.zoom.transform.NatureZoomTransform;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>ZoomPane</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class ZoomPaneFailureTest extends TestCase {

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
     * The ZoomPane instance created for testing. It is a JLabel instance here.
     * </p>
     */
    private ZoomPane zoomPane;

    /**
     * <p>
     * The enclosed component to zoom.
     * </p>
     */
    private JComponent zoomComponent;

    /**
     * <p>
     * The given transform to perform the zoom.
     * </p>
     */
    private ZoomTransform transform;

    /**
     * <p>
     * Set up the environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        zoomComponent = new JLabel();
        transform = new NatureZoomTransform();
        zoomPane = new ZoomPane(zoomComponent, transform);
    }

    /**
     * <p>
     * Clear environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        zoomPane = null;
    }

    /**
     * <p>
     * Failure test for
     * <code>ZoomPane(JComponent zoomComponent, ZoomTransform transform)</code>.
     * </p>
     * <p>
     * zoomComponent is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testZoomPaneNullJComponent() {
        try {
            new ZoomPane(null, transform);
            fail("zoomComponent is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>ZoomPane(JComponent zoomComponent, ZoomTransform transform)</code>.
     * </p>
     * <p>
     * transform is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testZoomPaneNullZoomTransform() {
        try {
            new ZoomPane(zoomComponent, null);
            fail("transform is null, IllegalArgumentException is expected.");
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
            zoomPane.setZoomFactor(factor);
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
            zoomPane.setZoomFactor(zero);
            fail("zoomFactor is 0, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>setTransform(ZoomTransform transform)</code>.
     * </p>
     * <p>
     * transform is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetTransform() {
        try {
            zoomPane.setTransform(null);
            fail("transform is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>paintComponents(Graphics g)</code>.
     * </p>
     * <p>
     * g is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPaintComponentGraphicsNullGraphics() {
        try {
            zoomPane.paintComponent(null);
            fail("g is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>paintComponents(Graphics g)</code>.
     * </p>
     * <p>
     * g is of wrong type, IllegalArgumentException is expected.
     * </p>
     */
    public void testPaintComponentGraphicsWrongType() {
        try {
            zoomPane.paintComponent(new DebugGraphics());
            fail("g is of wrong type, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
