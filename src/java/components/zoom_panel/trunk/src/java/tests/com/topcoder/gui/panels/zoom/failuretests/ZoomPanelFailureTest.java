/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom.failuretests;

import javax.swing.JComponent;
import javax.swing.JLabel;

import junit.framework.TestCase;

import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.gui.panels.zoom.ZoomTransform;
import com.topcoder.gui.panels.zoom.transform.NatureZoomTransform;

/**
 * <p>
 * Failure test for <code>ZoomPanel</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class ZoomPanelFailureTest extends TestCase {

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
     * The ZoomPanel instance created for testing. It is a JLabel instance here.
     * </p>
     */
    private ZoomPanel zoomPanel;

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
        zoomPanel = new ZoomPanel(zoomComponent, transform);
    }

    /**
     * <p>
     * Clear environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        zoomPanel = null;
    }

    /**
     * <p>
     * Failure test for
     * <code>zoomPanel(JComponent zoomComponent, ZoomTransform transform)</code>.
     * </p>
     * <p>
     * zoomComponent is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testZoomPanelNullJComponent() {
        try {
            new ZoomPanel(null, transform);
            fail("zoomComponent is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>zoomPanel(JComponent zoomComponent, ZoomTransform transform)</code>.
     * </p>
     * <p>
     * transform is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testZoomPanelNullZoomTransform() {
        try {
            new ZoomPanel(zoomComponent, null);
            fail("transform is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>zoomPanel(JComponent zoomComponent)</code>.
     * </p>
     * <p>
     * zoomComponent is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testZoomPanel2NullJComponent() {
        try {
            new ZoomPanel(null);
            fail("zoomComponent is null, IllegalArgumentException is expected.");
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
            zoomPanel.setZoomFactor(factor);
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
            zoomPanel.setZoomFactor(zero);
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
            zoomPanel.setTransform(null);
            fail("transform is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
