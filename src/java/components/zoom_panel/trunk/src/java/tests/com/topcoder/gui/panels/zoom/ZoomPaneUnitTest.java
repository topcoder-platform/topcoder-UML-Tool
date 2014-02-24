/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom;

import java.awt.Dimension;
import java.awt.geom.AffineTransform;

import javax.swing.DebugGraphics;
import javax.swing.JComponent;
import javax.swing.JPanel;

import junit.framework.TestCase;

import com.topcoder.gui.panels.zoom.transform.AffineZoomTransform;

/**
 * <p>
 * Unit test cases for class ZoomPane's simple methods. It will test all its functions.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ZoomPaneUnitTest extends TestCase {

    /**
     * <p>
     * ZoomPane instance to be tested. Created in setUp.
     * </p>
     */
    private ZoomPane zoomPane;

    /**
     * <p>
     * JComponent instance used for testing. Created in setUp.
     * </p>
     */
    private JComponent jComponent;

    /**
     * <p>
     * ZoomTransform instance used for testing. Created in setUp.
     * </p>
     */
    private ZoomTransform zoomTransform;

    /**
     * <p>
     * Sets up testing environment.
     * <p>
     *
     * @throws Exception
     *             when error occurs
     */
    protected void setUp() throws Exception {
        jComponent = new JPanel();
        zoomTransform = new AffineZoomTransform();
        zoomPane = new ZoomPane(jComponent, zoomTransform);
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
        jComponent = null;
        zoomTransform = null;
        zoomPane = null;
    }

    /**
     * <p>
     * Test of default constructor for accuracy.
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public void testCtorAccuracy() throws Exception {
        assertNotNull("constructor fails", new ZoomPane(jComponent, zoomTransform));
    }

    /**
     * <p>
     * Test of default constructor for failure with first parameter valued null. IllegalArgumentException is excepted.
     * </p>
     */
    public void testCtorFailWithFirstParamNull() {
        try {
            new ZoomPane(null, zoomTransform);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of default constructor for failure with second parameter valued null. IllegalArgumentException is excepted.
     * </p>
     */
    public void testCtorFailWithSecondParamNull() {
        try {
            new ZoomPane(jComponent, null);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of setPreferredSize for accuracy with null value.
     * </p>
     */
    public void testSetPreferredSizeAccuracyWithNull() {
        // old size
        Dimension old = zoomPane.getPreferredSize();
        zoomPane.setPreferredSize(null);
        assertEquals("should be the old size, use doesn't define", old, zoomPane.getPreferredSize());
    }

    /**
     * <p>
     * Test of setPreferredSize for accuracy.
     * </p>
     */
    public void testSetPreferredSizeWithDimension() {
        for (int i = 1; i < 10; i++) {
            Dimension preferredSize = new Dimension(i, i);
            zoomPane.setPreferredSize(preferredSize);
            assertEquals("the two size should be equal", preferredSize, zoomPane.getPreferredSize());
        }
    }

    /**
     * <p>
     * Test of getPreferredSize for accuracy with null value.
     * </p>
     */
    public void testGetPreferredSizeAccuracyWithSizeNull() {
        Dimension d = new Dimension(3, 3);
        zoomPane.setPreferredSize(d);
        assertEquals("preferred size should be the same as d", d, zoomPane.getPreferredSize());
    }

    /**
     * <p>
     * Test of getPreferredSize for accuracy with not null value.
     * </p>
     */
    public void testGetPreferredSizeAccuracyWithSizeNotNull() {
        Dimension preferredSize = new Dimension(2, 3);
        zoomPane.setPreferredSize(preferredSize);
        assertEquals("the two size should be equal", preferredSize, zoomPane.getPreferredSize());
    }

    /**
     * <p>
     * Test of setZoomFactor for accuracy. Sets the zoomFactor from no zoom to zoom.
     * </p>
     */
    public void testSetZoomFactorAccuracyNoZoom2Zoom() {
        // set to no zoom first
        zoomPane.setZoomFactor(1.0);
        /*
         * BugFix: UML-10107
         */
        // old code
//        // jComponent now must be in the components array
//        assertTrue("jComponent should be in the component list", UnitTestHelper.containComponent(zoomPane
//                .getComponents(), jComponent));
        assertTrue("jComponent should be visible", jComponent.isVisible());
        // set from no zoom to zoom
        zoomPane.setZoomFactor(3.0);
        /*
         * BugFix: UML-10107
         */
        // old code
//        // jComponent now must not be in the components array
//        assertFalse("jComponent should not be in the component list", UnitTestHelper.containComponent(zoomPane
//                .getComponents(), jComponent));
        assertFalse("jComponent should be invisible", jComponent.isVisible());
    }

    /**
     * <p>
     * Test of setZoomFactor for accuracy. Sets the zoomFactor from zoom to no zoom.
     * </p>
     */
    public void testSetZoomFactorAccuracyZoom2NoZoom() {
        // set to zoom first
        zoomPane.setZoomFactor(3.0);
        /*
         * BugFix: UML-10107
         */
        // old code
//        // jComponent now must not be in the components array
//        assertFalse("jComponent should be in the component list", UnitTestHelper.containComponent(zoomPane
//                .getComponents(), jComponent));
        assertFalse("jComponent should be invisible", jComponent.isVisible());
        // set from no zoom to zoom
        zoomPane.setZoomFactor(1.0);
        /*
         * BugFix: UML-10107
         */
        // old code
//        // jComponent now must be in the components array
//        assertTrue("jComponent should not be in the component list", UnitTestHelper.containComponent(zoomPane
//                .getComponents(), jComponent));
        assertTrue("jComponent should be visible", jComponent.isVisible());
    }

    /**
     * <p>
     * Test of setZoomFactor for failure with 0.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testSetZoomFactorFailWithZeor() {
        try {
            zoomPane.setZoomFactor(0);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of setZoomFactor for failure with 0.
     * IllegalArgumentException is negative.
     * </p>
     */
    public void testSetZoomFactorFailWithNegative() {
        try {
            zoomPane.setZoomFactor(-3.0);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of getZoomFactor for accuracy.
     * </p>
     */
    public void testGetZoomFatorAccuracy() {
        zoomPane.setZoomFactor(3.0);
        assertEquals("the two zoomFactor should be equal", 3.0, zoomPane.getZoomFactor(), Helper.EPSILON);
    }

    /**
     * <p>
     * Test of getTransform for accuracy.
     * </p>
     */
    public void testGetTransformAccuracy() {
        assertEquals("the two transformers should be the same", zoomTransform, zoomPane.getTransform());
    }

    /**
     * <p>
     * Test of setTransform for accuracy. Sets the transformer from no zoom to zoom.
     * </p>
     */
    public void testSetTransformAccuracyNoZoom2Zoom() {
        // set to no zoom first
        zoomPane.setTransform(new AffineZoomTransform(1.0));
        /*
         * BugFix: UML-10107
         */
        // old code
//        // jComponent now must be in the components array
//        assertTrue("jComponent should be in the component list", UnitTestHelper.containComponent(zoomPane
//                .getComponents(), jComponent));
        assertTrue("jComponent should be visible", jComponent.isVisible());
        // set from no zoom to zoom
        zoomPane.setTransform(new AffineZoomTransform(3.0));
        /*
         * BugFix: UML-10107
         */
        // old code
//        // jComponent now must not be in the components array
//        assertFalse("jComponent should not be in the component list", UnitTestHelper.containComponent(zoomPane
//                .getComponents(), jComponent));
        assertFalse("jComponent should be invisible", jComponent.isVisible());
    }

    /**
     * <p>
     * Test of setTransform for accuracy. Sets the transformer from zoom to no zoom.
     * </p>
     */
    public void testSetTransformAccuracyZoom2NoZoom() {
        // set to no zoom first
        zoomPane.setTransform(new AffineZoomTransform(3.0));
        /*
         * BugFix: UML-10107
         */
        // old code
//        // jComponent now must be in the components array
//        assertFalse("jComponent should be in the component list", UnitTestHelper.containComponent(zoomPane
//                .getComponents(), jComponent));
        assertFalse("jComponent should be invisible", jComponent.isVisible());
        // set from no zoom to zoom
        zoomPane.setTransform(new AffineZoomTransform(1.0));
        /*
         * BugFix: UML-10107
         */
        // old code
//        // jComponent now must not be in the components array
//        assertTrue("jComponent should not be in the component list", UnitTestHelper.containComponent(zoomPane
//                .getComponents(), jComponent));
        assertTrue("jComponent should be visible", jComponent.isVisible());
    }

    /**
     * <p>
     * Test of setTransform for failure with null value.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testSetTransformFailWithNull() {
        try {
            zoomPane.setTransform(null);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of paintComponent for failure with null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testPaintComponentFailWithNull() {
        try {
            zoomPane.paintComponent(null);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test of paintComponent for failure with not Graphics2D instance.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testPaintComponentFailWithNotGraphics() {
        try {
            zoomPane.paintComponent(new DebugGraphics());
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test of paintComponent for accuracy with a transformer of noZoom.
     *
     * @throws Exception when error occurs
     */
    public void testPaintComponentAccuracyWithNoZoom() throws Exception {
        // the transformer is of no zoom by default
        DemoController demoController = new DemoController();
        zoomPane = new ZoomPane(new CoordinateArea(demoController), new AffineZoomTransform(1.0));
        ZoomPanel zoomPanel = new ZoomPanel(zoomPane);
        // create UI
        UnitTestHelper.createUI(demoController, zoomPanel);

        // dispose the UI
        UnitTestHelper.disposeUI();
    }

    /**
     * Test of paintComponent for accuracy with a transformer of Zoom.
     *
     * @throws Exception when error occurs
     */
    public void testPaintComponentAccuracyNoZoom() throws Exception {
        // the transformer is of no zoom by default, so need to set again
        DemoController demoController = new DemoController();
        zoomPane = new ZoomPane(new CoordinateArea(demoController),
                new AffineZoomTransform(new AffineTransform(0.5, 1, 0, 0.5, 1, 0)));
        zoomPane.setPreferredSize(new Dimension(300, 400));
        ZoomPanel zoomPanel = new ZoomPanel(zoomPane);
        // create UI
        UnitTestHelper.createUI(demoController, zoomPanel);

        // dispose the UI
        UnitTestHelper.disposeUI();
    }
}
