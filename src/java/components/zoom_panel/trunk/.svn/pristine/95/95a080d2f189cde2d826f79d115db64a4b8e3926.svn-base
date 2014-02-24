/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom.accuracytests;

import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.gui.panels.zoom.ZoomTransform;
import com.topcoder.gui.panels.zoom.transform.AffineZoomTransform;

import junit.framework.TestCase;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JPanel;


/**
 * Accuracy test for <code>ZoomPanel</code>.
 *
 * @author kzhu
 * @version 1.0
 */
public class ZoomPanelAccuracyTests extends TestCase {
    /** JComponent instance used for construct the ZoomPanel in the test. Created in setUp. */
    private JComponent component;

    /** ZoomTransform instance used for the ZoomPanel instance for testing. Created in setUp. */
    private ZoomTransform transform;

    /** ZoomPanel used for testing. Created in setUp. */
    private ZoomPanel panel;

    /**
     * <p>
     * Represents double epsilon for float number manipulation.
     * </p>
     */
    private final double EPSILON = 1e-6;

    /**
     * <p>
     * Sets up testing environment.
     * </p>
     * 
     * <p></p>
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        component = new JPanel();
        transform = new AffineZoomTransform();
        panel = new ZoomPanel(component, transform);
    }

    /**
     * <p>
     * Clears the testing environment.
     * </p>
     * 
     * <p></p>
     *
     * @throws Exception when error occurs
     */
    protected void tearDown() throws Exception {
        component = null;
        transform = null;
        panel = null;
    }

    /**
     * <p>
     * Test of ZoomPanel(JComponent zoomComponent, ZoomTransform transform) for accuracy.
     * </p>
     */
    public void test2ParamCtorAccuracy() {
        // instance should be created.
        assertNotNull("constructor fails", panel);

        // transform should be set.
        assertNotNull("transform should be set.", panel.getTransform());
    }

    /**
     * <p>
     * Test of ZoomPanel(JComponent zoomComponent) for accuracy.
     * </p>
     */
    public void test1ParamCtorAccuracy() {
        assertNotNull("constructor fails", new ZoomPanel(component));
    }

    /**
     * <p>
     * Test of setTransform for accuracy.
     * </p>
     */
    public void testSetTransformAccuracy() {
        ZoomTransform zt = new AffineZoomTransform();
        panel.setTransform(zt);

        // transform should be set.
        assertNotNull("transform should be set.", panel.getTransform());
    }

    /**
     * <p>
     * Tests that getTransform() returns correct value.
     * </p>
     */
    public void testGetTransform1() {
        ZoomTransform transform = new AffineZoomTransform();
        panel.setTransform(transform);

        // transform should be set.
        assertNotNull("transform should be set.", panel.getTransform());
    }

    /**
     * <p>
     * Test of getZoomFactor for accuracy.
     * </p>
     */
    public void testGetZoomFactorAccuracy() {
        // the zoomfactor is 1.0 by default
        assertEquals("should be 1.0 by default", 1.0, panel.getZoomFactor(), EPSILON);
    }

    /**
     * <p>
     * Test of setZoomFactor for accuracy.
     * </p>
     */
    public void testSetZoomFactorAccuracy() {
        panel.setZoomFactor(2.0);

        assertEquals("should be 2.0", 2.0, panel.getZoomFactor(), EPSILON);
    }

    /**
     * <p>
     * Test of setZoomBackground for accuracy with null.
     * </p>
     */
    public void testSetZoomBackgroundAccuracyWithNull() {
        // the default color
        Color old = panel.getZoomBackground();
        panel.setZoomBackground(null);
        assertEquals("should be the default color", old, panel.getZoomBackground());
    }

    /**
     * <p>
     * Test of setZoomBackground for accuracy with Color object.
     * </p>
     */
    public void testSetZoomBackgroundAccuracyWithColor() {
        Color color = Color.BLUE;

        // set color
        panel.setZoomBackground(color);

        // get color
        assertEquals("should be BLUE", color, panel.getZoomBackground());

        // set new color
        color = Color.RED;
        panel.setZoomBackground(color);
        assertEquals("should be RED", color, panel.getZoomBackground());
    }

    /**
     * <p>
     * Test of setZoomBackground for accuracy with Color object.
     * </p>
     */
    public void testGetZoomBackgroundAccuracy() {
        Color color = Color.GRAY;

        // set color
        panel.setZoomBackground(color);

        // get color
        assertEquals("should be BLUE", color, panel.getZoomBackground());
    }
}
