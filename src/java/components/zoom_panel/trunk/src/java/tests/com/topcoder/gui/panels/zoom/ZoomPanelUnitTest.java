/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.topcoder.gui.panels.zoom.transform.AffineZoomTransform;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class ZoomPanel's simple methods. It will test all its functions.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ZoomPanelUnitTest extends TestCase {

    /**
     * JComponent instance used for construct the ZoomPanel in the test. Created in setUp.
     */
    private JComponent component;

    /**
     * ZoomTransform instance used for the ZoomPanel instance for testing. Created in setUp.
     */
    private ZoomTransform transform;

    /**
     * ZoomPanel used for testing. Created in setUp.
     */
    private ZoomPanel panel;
    /**
     * <p>
     * Sets up testing environment.
     * <p>
     *
     * @throws Exception
     *             when error occurs
     */
    protected void setUp() throws Exception {
        component = new JPanel();
        transform = new AffineZoomTransform();
        panel = new ZoomPanel(component, transform);
    }

    /**
     * <p>
     * Clears the testing environment.
     * <p>
     *
     * @throws Exception
     *             when error occurs
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
        assertNotNull("constructor fails", new ZoomPanel(component, transform));
    }

    /**
     * <p>
     * Test of ZoomPanel(JComponent zoomComponent, ZoomTransform transform) for failure.
     * With first parameter valued null IllegalArgumentException is expected.
     * </p>
     */
    public void test2ParamCtorFailWithFirstParamNull() {
        try {
            new ZoomPanel(null, transform);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of ZoomPanel(JComponent zoomComponent, ZoomTransform transform) for failure.
     * With second parameter valued null IllegalArgumentException is expected.
     * </p>
     */
    public void test2ParamCtorFailWithSecondParamNul() {
        try {
            new ZoomPanel(component, null);
        } catch (IllegalArgumentException e) {
            // expected
        }
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
     * Test of ZoomPanel(JComponent zoomComponent) for failure.
     * With parameter valued null IllegalArgumentException is expected.
     * </p>
     */
    public void test1ParamCtorFailWithNull() {
        try {
            new ZoomPanel(null);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of getTransform for accuracy.
     * </p>
     */
    public void testGetTransformAccuracy() {
        assertEquals("two transformers should be equal", transform, panel.getTransform());
    }

    /**
     * <p>
     * Test of getZoomFactor for accuracy.
     * </p>
     */
    public void testGetZoomFactorAccuracy() {
        // the zoomfactor is 1.0 by default
        assertEquals("should be 1.0 by default", 1.0, panel.getZoomFactor(), Helper.EPSILON);
    }

    /**
     * <p>
     * Test of setTransform for accuracy.
     * </p>
     */
    public void testSetTransformAccuracy() {
        for (int i = 1; i < 10; i++) {
            ZoomTransform zt = new AffineZoomTransform();
            panel.setTransform(zt);
            assertEquals("the two transformers should be the same", zt, panel.getTransform());
        }
    }

    /**
     * <p>
     * Test of setTransform for failure.
     * With null passed in, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetTransformFailWithNull() {
        try {
            panel.setTransform(null);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of setZoomFactor for accuracy.
     * </p>
     */
    public void testSetZoomFactorAccuracy() {
        for (int i = 1; i < 10; i++) {
            panel.setZoomFactor(i);
            assertEquals("the two values should be equal", i, panel.getZoomFactor(), Helper.EPSILON);
        }
    }

    /**
     * <p>
     * Test of setZoomFactor for failure.
     * With 0 passed in, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetZoomFactorFailWithZero() {
        try {
            panel.setZoomFactor(0);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of setZoomFactor for failure.
     * With negative passed in, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetZoomFactorFailWithNegative() {
        try {
            panel.setZoomFactor(-3.0);
        } catch (IllegalArgumentException e) {
            // expected
        }
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
