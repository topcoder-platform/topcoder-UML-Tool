/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.DebugGraphics;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import junit.framework.TestCase;

import com.topcoder.gui.panels.zoom.ZoomPanel;

/**
 * <p>
 * Unit test of BirdsEyeView.
 * </p>
 *
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class BirdsEyeViewTest extends TestCase {

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        UIManager.put("BirdsEyeView.overlayColor", Color.green);
        UIManager.put("BirdsEyeView.overlayBorderColor", Color.yellow);
        UIManager.put("BirdsEyeView.overlayBorderThickness", "1");
        UIManager.put("BirdsEyeView.overlayOpacity", "0.5");
    }

    /**
     * <p>
     * Test the constructor BirdsEyeView(JComponent inputObject,
     * Dimension inputObjectViewDimension, Point inputObjectViewPosition).
     * </p>
     */
    public void testConstructor() {
        JLabel label = new JLabel("just for the test!");
        JScrollPane sp = new JScrollPane(label);
        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        JComponent comp = view.getInputObject();
        assertEquals("The inputObjectViewDimension should be equals with expected.",
                sp.getViewport().getSize(), view.getInputObjectViewDimension());
        assertEquals("The inputObjectViewPosition should be equals with expected.",
                view.getViewPort().getLocation(), view.getInputObjectViewPosition());
        assertEquals("The inputObject should be equals with expected.", sp, comp);
        assertNotNull("The zoom panel should not be null.", view.getZoomPanel());
    }

    /**
     * <p>
     * Failure test of constructor BirdsEyeView(JComponent inputObject,
     * Dimension inputObjectViewDimension, Point inputObjectViewPosition)
     * with null parameters.
     * </p>
     */
    public void testConstructorWithNull() {
        try {
            new BirdsEyeView(null, new Dimension(), new Point());
            fail("the IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // pass
        }
        JLabel label = new JLabel("just for the test!");
        try {
            new BirdsEyeView(label, null, new Point());
            fail("the IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // pass
        }
        try {
            new BirdsEyeView(label, new Dimension(), null);
            fail("the IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test of constructor BirdsEyeView(JComponent inputObject,
     * Dimension inputObjectViewDimension, Point inputObjectViewPosition)
     * with invalid parameters.
     * </p>
     */
    public void testConstructorConfig() {
        JLabel label = new JLabel("just for the test!");
        JScrollPane sp = new JScrollPane(label);
        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        assertEquals("The background color of view port should be same with expected",
                Color.green, view.getViewPort().getBackground());
        assertEquals("The foreground color of view port should be same with expected",
                Color.yellow, view.getViewPort().getForeground());
        assertEquals("The opacity of view port should be same with expected",
                0.5, view.getViewPort().getOpacity());
    }

    /**
     * <p>
     * Failure test of constructor BirdsEyeView(JComponent inputObject,
     * Dimension inputObjectViewDimension, Point inputObjectViewPosition)
     * with invalid color configurations.
     * </p>
     */
    public void testConstructorWithInvalidColorConfig() {
        JLabel label = new JLabel("just for the test!");
        JScrollPane sp = new JScrollPane(label);

        UIManager.put("BirdsEyeView.overlayColor", null);
        UIManager.put("BirdsEyeView.overlayBorderColor", Color.yellow);
        UIManager.put("BirdsEyeView.overlayBorderThickness", "1");
        UIManager.put("BirdsEyeView.overlayOpacity", "0.5");

        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        assertEquals("The background color of view port should be same with expected",
                Color.gray, view.getViewPort().getBackground());

        UIManager.put("BirdsEyeView.overlayColor", Color.black);
        UIManager.put("BirdsEyeView.overlayBorderColor", null);
        view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        assertEquals("The foreground color of view port should be same with expected",
                Color.black, view.getViewPort().getForeground());
    }

    /**
     * <p>
     * Failure test of constructor BirdsEyeView(JComponent inputObject,
     * Dimension inputObjectViewDimension, Point inputObjectViewPosition)
     * with invalid thickness configurations.
     * </p>
     */
    public void testConstructorWithInvalidThicknessConfig() {
        JLabel label = new JLabel("just for the test!");
        JScrollPane sp = new JScrollPane(label);

        UIManager.put("BirdsEyeView.overlayColor", Color.gray);
        UIManager.put("BirdsEyeView.overlayBorderColor", Color.yellow);
        UIManager.put("BirdsEyeView.overlayOpacity", "0.5");

        UIManager.put("BirdsEyeView.overlayBorderThickness", null);
        new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        // pass

        UIManager.put("BirdsEyeView.overlayBorderThickness", "-1");
        new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        // pass

        UIManager.put("BirdsEyeView.overlayBorderThickness", "abc");
        new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        // pass

        UIManager.put("BirdsEyeView.overlayBorderThickness", "   ");
        new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        // pass
    }

    /**
     * <p>
     * Failure test of constructor BirdsEyeView(JComponent inputObject,
     * Dimension inputObjectViewDimension, Point inputObjectViewPosition)
     * with invalid opacity configurations.
     * </p>
     */
    public void testConstructorWithInvalidOpacityConfig() {
        JLabel label = new JLabel("just for the test!");
        JScrollPane sp = new JScrollPane(label);

        UIManager.put("BirdsEyeView.overlayColor", Color.gray);
        UIManager.put("BirdsEyeView.overlayBorderColor", Color.yellow);
        UIManager.put("BirdsEyeView.overlayBorderThickness", "3");

        UIManager.put("BirdsEyeView.overlayOpacity", null);
        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        assertEquals("The opacity of view port should be same with expected",
                0.5, view.getViewPort().getOpacity());

        UIManager.put("BirdsEyeView.overlayOpacity", "11");
        view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        assertEquals("The opacity of view port should be same with expected",
                0.5, view.getViewPort().getOpacity());

        UIManager.put("BirdsEyeView.overlayOpacity", "-1");
        view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        assertEquals("The opacity of view port should be same with expected",
                0.5, view.getViewPort().getOpacity());

        UIManager.put("BirdsEyeView.overlayOpacity", "abc.123");
        view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        assertEquals("The opacity of view port should be same with expected",
                0.5, view.getViewPort().getOpacity());

        UIManager.put("BirdsEyeView.overlayOpacity", "   ");
        view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        assertEquals("The opacity of view port should be same with expected",
                0.5, view.getViewPort().getOpacity());
    }

    /**
     * <p>
     * Test the getter and setter of inputObject attribute.
     * </p>
     */
    public void testInputObject() {
        JLabel label = new JLabel("1");
        JScrollPane sp = new JScrollPane(label);
        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());

        JLabel label1 = new JLabel("2");
        JScrollPane sp1 = new JScrollPane(label1);
        view.setInputObject(sp1);
        JComponent comp = view.getInputObject();
        assertEquals("The retrieved inputObject should be same with expected.", sp1, comp);
    }

    /**
     * <p>
     * Test the getter and setter of inputObject attribute.
     * </p>
     */
    public void testInputObjectWithNull() {
        JLabel label = new JLabel("1");
        JScrollPane sp = new JScrollPane(label);
        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());

        try {
            view.setInputObject(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }
    /**
     * <p>
     * Test the getter of view port.
     * </p>
     */
    public void testGetViewPort() {
        JLabel label = new JLabel("just for the test!");
        JScrollPane sp = new JScrollPane(label);
        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        assertEquals("The inputObjectViewDimension should be equals with expected.",
                sp.getViewport().getSize(), view.getInputObjectViewDimension());
        assertNotNull("The view port should not be null.", view.getViewPort());
    }

    /**
     * <p>
     * Test the getter and setter of zoom panel.
     * </p>
     */
    public void testZoomPanel() {
        JLabel label = new JLabel("just for the test!");
        JScrollPane sp = new JScrollPane(label);
        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());

        ZoomPanel zoomPanel = new ZoomPanel(label);
        view.setZoomPanel(zoomPanel);
        assertEquals("The retrieved zoomPanel should be same with expected.", zoomPanel, view.getZoomPanel());
    }

    /**
     * <p>
     * Test the setter of zoomPanel with null.
     * </p>
     */
    public void testZoomPanelWithNull() {
        JLabel label = new JLabel("just for the test!");
        JScrollPane sp = new JScrollPane(label);
        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());

        try {
            view.setZoomPanel(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Test the getter and setter of inputObjectViewDimension.
     * </p>
     */
    public void testInputObjectViewDimension() {
        JLabel label = new JLabel("just for the test!");
        JScrollPane sp = new JScrollPane(label);
        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());

        Dimension d = new Dimension();
        view.setInputObjectViewDimension(d);
        assertEquals("The retrieved inputObjectViewDimension should be same with expected.",
                d, view.getInputObjectViewDimension());
    }

    /**
     * <p>
     * Test the setter of inputObjectViewDimension with null.
     * </p>
     */
    public void testInputObjectViewDimensionWithNull() {
        JLabel label = new JLabel("just for the test!");
        JScrollPane sp = new JScrollPane(label);
        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());

        try {
            view.setInputObjectViewDimension(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Test the getter and setter of inputObjectViewPostion.
     * </p>
     */
    public void testInputObjectViewPostion() {
        JLabel label = new JLabel("just for the test!");
        JScrollPane sp = new JScrollPane(label);
        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());

        Point p = new Point();
        view.setInputObjectViewPosition(p);
        assertEquals("The retrieved inputObjectViewPosition should be same with expected.",
                p, view.getInputObjectViewPosition());

    }

    /**
     * <p>
     * Test the setter of inputObjectViewPostion with null.
     * </p>
     */
    public void testInputObjectViewPostionWithNull() {
        JLabel label = new JLabel("just for the test!");
        JScrollPane sp = new JScrollPane(label);
        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());

        try {
            view.setInputObjectViewPosition(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Test the mousePressed method.
     * </p>
     */
    public void testMousePressed() {
        BirdsEyeView view = initBirdsEyeView();
        view.mousePressed(new MouseEvent(view, 0, System.currentTimeMillis(), 0, 200, 200, 1, false));
        assertEquals("The location of view port should be same with expected.",
                new Point(100, 125), view.getViewPort().getLocation());
        view.getViewPort().setLocation(new Point(0, 0));
        view.mousePressed(new MouseEvent(view, 0, System.currentTimeMillis(), 0, 10, 200, 1, false));
        assertEquals("The location of view port should be same with expected.",
                new Point(0, 125), view.getViewPort().getLocation());
        view.getViewPort().setLocation(new Point(0, 0));
        view.mousePressed(new MouseEvent(view, 0, System.currentTimeMillis(), 0, 750, 200, 1, false));
        assertEquals("The location of view port should be same with expected.",
                new Point(599, 125), view.getViewPort().getLocation());
        view.getViewPort().setLocation(new Point(0, 0));
        view.mousePressed(new MouseEvent(view, 0, System.currentTimeMillis(), 0, 200, 50, 1, false));
        assertEquals("The location of view port should be same with expected.",
                new Point(100, 0), view.getViewPort().getLocation());
        view.getViewPort().setLocation(new Point(0, 0));
        view.mousePressed(new MouseEvent(view, 0, System.currentTimeMillis(), 0, 200, 550, 1, false));
        assertEquals("The location of view port should be same with expected.",
                new Point(100, 449), view.getViewPort().getLocation());
        view.getViewPort().setLocation(new Point(0, 0));
        view.mousePressed(new MouseEvent(view, 0, System.currentTimeMillis(), 0, -1, 200, 1, false));
        assertEquals("The location of view port should be same with expected.",
                new Point(0, 0), view.getViewPort().getLocation());
        view.getViewPort().setLocation(new Point(0, 0));
        view.mousePressed(new MouseEvent(view, 0, System.currentTimeMillis(), 0, 801, 200, 1, false));
        assertEquals("The location of view port should be same with expected.",
                new Point(0, 0), view.getViewPort().getLocation());
        view.getViewPort().setLocation(new Point(0, 0));
        view.mousePressed(new MouseEvent(view, 0, System.currentTimeMillis(), 0, 200, -1, 1, false));
        assertEquals("The location of view port should be same with expected.",
                new Point(0, 0), view.getViewPort().getLocation());
        view.getViewPort().setLocation(new Point(0, 0));
        view.mousePressed(new MouseEvent(view, 0, System.currentTimeMillis(), 0, 200, 601, 1, false));
        assertEquals("The location of view port should be same with expected.",
                new Point(0, 0), view.getViewPort().getLocation());
    }

    /**
     * <p>
     * Failure test of the mousePressed method.
     * </p>
     */
    public void testMousePressedFail() {
        BirdsEyeView view = initBirdsEyeView();
        view.mousePressed(null);
        assertEquals("The location of view port should be same with expected.",
                new Point(0, 0), view.getViewPort().getLocation());
    }

    /**
     * <p>
     * Initial the instance of BirdsEyeView.
     * </p>
     *
     * @return
     *          the instance of BirdsEyeView
     */
    private BirdsEyeView initBirdsEyeView() {
        JLabel label = new JLabel("just for the test!");
        JScrollPane sp = new JScrollPane(label);
        BirdsEyeView view = new BirdsEyeView(sp, sp.getViewport().getSize(), sp.getLocation());
        view.setSize(800, 600);
        view.getZoomPanel().setSize(800, 600);
        view.getViewPort().setSize(200, 150);
        view.getViewPort().setLocation(new Point(0, 0));
        return view;
    }

    /**
     * <p>
     * Test case of the paintComponent method.
     * </p>
     */
    public void testPaintComponent() {
        JLabel label = new JLabel();
        BirdsEyeView birdEye = new BirdsEyeView(label, new Dimension(100, 100),
                new Point(100, 100));
        label.setSize(400, 400);
        birdEye.setSize(100, 50);
        DebugGraphics g = new DebugGraphics();
        birdEye.paintComponent(g);
        double zoomFactor = 50 * 1.0 / 400;
        assertTrue("The zoom factor should be same with expected.", Helper.compareDoubles(zoomFactor,
                birdEye.getViewPort().getZoomFactor()));
        assertEquals("The size of the view port should be same with expected.",
                new Dimension((int) (zoomFactor * 100), (int) (zoomFactor * 100)),
                birdEye.getViewPort().getSize());
    }
    /**
     * <p>
     * Test case of the paintComponent method.
     * </p>
     */
    public void testPaintComponentWithZeroHeight() {
        JLabel label = new JLabel();
        BirdsEyeView birdEye = new BirdsEyeView(label, new Dimension(100, 100),
                new Point(100, 100));
        label.setSize(400, 400);
        birdEye.setSize(0, 0);
        DebugGraphics g = new DebugGraphics();
        birdEye.paintComponent(g);
        assertTrue("The zoom factor should be same with expected.", Helper.compareDoubles(1,
                birdEye.getViewPort().getZoomFactor()));
        assertEquals("The size of the view port should be same with expected.",
                new Dimension(100, 100), birdEye.getViewPort().getSize());
    }
    /**
     * <p>
     * Failure test case of the paintComponent method.
     * </p>
     */
    public void testPaintComponentFail() {
        JLabel label = new JLabel();
        BirdsEyeView birdEye = new BirdsEyeView(label, new Dimension(100, 100),
                new Point(100, 100));
        label.setSize(400, 400);
        birdEye.setSize(100, 50);
        birdEye.paintComponent(null);
        assertEquals("The size of the view port should be same with expected.",
                new Dimension(0, 0), birdEye.getViewPort().getSize());
    }
}
