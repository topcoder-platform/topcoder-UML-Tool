/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom.accuracytests;

import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.gui.panels.zoom.ZoomTransform;
import com.topcoder.gui.panels.zoom.transform.AffineZoomTransform;

import junit.framework.TestCase;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JPanel;


/**
 * Accuracy test for <code>ZoomPane</code>.
 *
 * @author kzhu
 * @version 1.0
 */
public class ZoomPaneAccuracyTests extends TestCase {
    /**
     * <p>
     * ZoomPane instance to be tested. Created in setUp.
     * </p>
     */
    private ZoomPane zoomPane;

    /**
     * <p>
     * Represents double epsilon for float number manipulation.
     * </p>
     */
    private final double EPSILON = 1e-6;

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
     * </p>
     *
     * <p></p>
     *
     * @throws Exception any exception to JUnit
     */
    protected void setUp() throws Exception {
        jComponent = new JPanel();
        zoomTransform = new AffineZoomTransform();
        zoomPane = new ZoomPane(jComponent, zoomTransform);
    }

    /**
     * <p>
     * Clears the testing environment.
     * </p>
     *
     * <p></p>
     *
     * @throws Exception any exception to JUnit
     */
    protected void tearDown() throws Exception {
        jComponent = null;
        zoomTransform = null;
        zoomPane = null;
    }

    /**
     * <p>
     * Test of default constructor for accuracy. The instance should be created.
     * </p>
     *
     * @throws Exception any exception to JUnit
     */
    public void testCtorAccuracy1() throws Exception {
        assertNotNull("constructor fails", new ZoomPane(jComponent, zoomTransform));
    }

    /**
     * <p>
     * Tests constructor with no zoom, the component should be added to the default component list.
     * </p>
     *
     * @throws Exception any exception to JUnit
     */
    public void testCtorAccuracyNoZoom() throws Exception {
        assertTrue("The JComponent is not added", containComponent(zoomPane.getComponents(), jComponent));
    }

    /**
     * <p>
     * Tests constructor, the preferred size should be set.
     * </p>
     *
     * @throws Exception any exception to JUnit
     */
    public void testCtorAccuracySetSize() throws Exception {
        // the preferred size should be set.
        assertEquals("The size is set", zoomPane.getPreferredSize(), jComponent.getPreferredSize());
    }

    /**
     * <p>
     * Tests accuracy of <code>setPreferredSize</code>.
     * </p>
     *
     * @throws Exception any exception to JUnit
     */
    public void testSetPreferredSizeAccuracy() throws Exception {
        // create the dimension
        Dimension size = new Dimension(100, 200);

        // set the dimension
        zoomPane.setPreferredSize(size);

        // compare
        assertEquals("the size is set.", size, zoomPane.getPreferredSize());
    }

    /**
     * <p>
     * Tests accuracy of <code>getPreferredSize</code>. The value is set before we call get. So the set value should be
     * return.
     * </p>
     *
     * @throws Exception any exception to JUnit
     */
    public void testGetPreferredSizeAccuracy() throws Exception {
        // create the dimension
        Dimension size = new Dimension(100, 200);

        // set the dimension
        zoomPane.setPreferredSize(size);

        // compare
        assertEquals("the size is get correctly.", size, zoomPane.getPreferredSize());
    }

    /**
     * <p>
     * Tests accuracy of <code>getPreferredSize</code> with preferred size being null. So the right value should be
     * calculated.
     * </p>
     *
     * @throws Exception any exception to JUnit
     */
    public void testGetPreferredSizeAccuracyWithNull()
        throws Exception {
        // set the argument of jComponent and zoomTransform
        jComponent.setPreferredSize(new Dimension(100, 200));
        zoomTransform.setZoomFactor(2.0);

        // create zoomPane
        zoomPane = new ZoomPane(jComponent, zoomTransform);

        // the size should be new Dimension(200, 400) according to the zoom factor.
        assertEquals("The size should be calculate.", new Dimension(200, 400), zoomPane.getPreferredSize());
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
//        assertTrue("jComponent should be in the component list", containComponent(zoomPane.getComponents(), jComponent));
        assertTrue("jComponent should be visible", jComponent.isVisible());

        // set from no zoom to zoom
        zoomPane.setZoomFactor(3.0);

        /*
         * BugFix: UML-10107
         */
        // old code
//        // jComponent now must not be in the components array
//        assertFalse("jComponent should not be in the component list",
//            containComponent(zoomPane.getComponents(), jComponent));
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
//        assertFalse("jComponent should not be in the component list",
//            containComponent(zoomPane.getComponents(), jComponent));
        assertFalse("jComponent should be invisible", jComponent.isVisible());

        // set from no zoom to zoom
        zoomPane.setZoomFactor(1.0);

        /*
         * BugFix: UML-10107
         */
        // old code
//        // jComponent now must be in the components array
//        assertTrue("jComponent should be in the component list", containComponent(zoomPane.getComponents(), jComponent));
        assertTrue("jComponent should be visible", jComponent.isVisible());
    }

    /**
     * <p>
     * Test of getZoomFactor for accuracy.
     * </p>
     */
    public void testGetZoomFatorAccuracy() {
        zoomPane.setZoomFactor(3.0);
        assertEquals("the two zoomFactor should be equal", 3.0, zoomPane.getZoomFactor(), EPSILON);
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
//        assertTrue("jComponent should be in the component list", containComponent(zoomPane.getComponents(), jComponent));
        assertTrue("jComponent should be visible", jComponent.isVisible());

        // set from no zoom to zoom
        zoomPane.setTransform(new AffineZoomTransform(3.0));

        /*
         * BugFix: UML-10107
         */
        // old code
//        // jComponent now must not be in the components array
//        assertFalse("jComponent should not be in the component list",
//            containComponent(zoomPane.getComponents(), jComponent));
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
//        assertFalse("jComponent should be in the component list", containComponent(zoomPane.getComponents(), jComponent));
        assertFalse("jComponent should be invisible", jComponent.isVisible());

        // set from no zoom to zoom
        zoomPane.setTransform(new AffineZoomTransform(1.0));

        /*
         * BugFix: UML-10107
         */
        // old code
//        // jComponent now must not be in the components array
//        assertTrue("jComponent should not be in the component list",
//            containComponent(zoomPane.getComponents(), jComponent));
        assertTrue("jComponent should be visible", jComponent.isVisible());
    }

    /**
     * Tests that paintComponent(Graphics) works correctly.
     */
    public void testPaintComponentAccuracy() {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics2D = image.createGraphics();
        (new ZoomPanePublicPaint(jComponent, zoomTransform)).paintComponent(graphics2D);
    }

    /**
     * Return if the specified component contained in a list.
     *
     * @param components the list
     * @param component the component to check
     *
     * @return if the specified component contained in a list.
     */
    private boolean containComponent(Component[] components, Component component) {
        for (int i = 0; i < components.length; i++) {
            if (components[i] == component) {
                return true;
            }
        }

        return false;
    }

    /**
     * <p>
     * This class extends <code>ZoomPane</code> to make its <code>paintComponent</code> method public for testing
     * purposes.
     * </p>
     *
     * <p>
     * <b>Thread safety.</b> This class is not thread safe since its superclass is not thread safe.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    private static class ZoomPanePublicPaint extends ZoomPane {
        /**
         * Creates a <code>ZoomPanePublicPaint</code> object that uses the provided transform to zoom the provided
         * component.
         *
         * @param zoomComponent the enclosed component to zoom.
         * @param transform the transform to perform the zooming.
         *
         * @throws IllegalArgumentException if either argument is null.
         */
        public ZoomPanePublicPaint(JComponent zoomComponent, ZoomTransform transform) {
            super(zoomComponent, transform);
        }

        /**
         * <p>
         * Performs painting of the enclosed component using the corresponding transform.
         * </p>
         *
         * <p>
         * This method is used to call <code>ZoomPane</code>'s name-like method for testing purposes.
         * </p>
         *
         * @param graphics the graphics object used to paint. Should be a {@link java.awt.Graphics2D Graphics2D}
         *        instance if used in a Swing system.
         *
         * @throws IllegalArgumentException if the provided graphics object is not a <code>Graphics2D</code> instance.
         */
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
        }
    }
}
