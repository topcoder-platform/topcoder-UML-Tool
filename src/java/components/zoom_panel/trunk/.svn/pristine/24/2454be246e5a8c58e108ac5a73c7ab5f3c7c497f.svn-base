/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;

import junit.framework.TestCase;

import com.topcoder.gui.panels.zoom.transform.AffineZoomTransform;
import com.topcoder.gui.panels.zoom.transform.NatureZoomTransform;

/**
 * <p>
 * Demonstrates the usage of this component. The ZoomPane is used as a client of ZoomPanel. So the following parts will
 * show detail usage of ZoomPanel. ZoomPane doesn't make too much sense if users use only itself without enclosing it in
 * ZoomPanel. The demonstration will be split to 7 parts: <br>
 * 1) Creating UI using ZoomPanel; <br>
 * 2) Accessing zoomFactor of zoomPanel and changing zoomFactor to zoom the UI in the zoomPanel; <br>
 * 3) Accessing zoomTransform of zoomPanel and changing zoomTransform to zoom the UI in the zoomPanel, this will change
 * the zoomTransform to a AffineZoomTransformer; <br>
 * 4) Accessing zoomTransform of zoomPanel and changing zoomTransform to a NatureZoomTransform(2.5) instance. This will
 * make the component in the zoomPanel get larger; <br>
 * 5) Manipulating the scroll bars of the zoomPanel; <br>
 * 6) Manipulating Viewport of the zoomPanel; <br>
 * 7) Setting the background color of the zoomPanel; <br>
 * 8) Creating UI using ZoomPane only.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * ZoomPanel instance used for demo. Created in setUp method.
     */
    private ZoomPanel zoomPanel;

    /**
     * DemoController instance used for demo. Created in setUp method.
     */
    private DemoController demoController;

    /**
     * CoordinateArea instance used for demo. Created in setUp method.
     */
    private CoordinateArea coordinateArea;

    /**
     * Sets up demo environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        demoController = new DemoController();
        coordinateArea = new CoordinateArea(demoController);
        zoomPanel = new ZoomPanel(coordinateArea);
    }

    /**
     * Clears the demo environment.
     *
     * @throws Exception when error occurs
     */
    protected void tearDown() throws Exception {
        demoController = null;
        coordinateArea = null;
        zoomPanel = null;
    }

    /**
     * <p>
     * This is the first part of this component demo. It will demonstrate creating a user UI with grids in the panel and
     * a label showing the cursor coordinates information. This demo uses the default ZoomPanel with NatureZoomTransform
     * in it. So the grids in it are with no zoom.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCreateUI() throws Exception {
        // Create and set up the window.
        // The JFrame instance.
        JFrame frame = new JFrame("CoordinatesDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // We add the zoom component to the root pane
        Container container = frame.getRootPane();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

        // Create the Label to show mouse event information
        DemoController controller = new DemoController();

        // coordinateArea is the zoomed component
        CoordinateArea coordinateArea1 = new CoordinateArea(controller);

        // create a ZoomPanel to wrap around it.
        ZoomPanel zoomPanel1 = new ZoomPanel(coordinateArea1);
        container.add(zoomPanel1);

        // add label
        controller.buildUI(container);

        // Display the window.
        frame.pack();
        frame.setVisible(true);

        // Dispose the window. This may not be useful in your application.
        frame.dispose();
    }

    /**
     * <p>
     * This is the second part of this component demo. It will demonstrate how to access zoomFactor of zoomPanel and how
     * to change zoomFactor to make the UI in the panel zoom. The UI can be zoomed by both setting zoomFactor and
     * zoomTransform. This demo sets the zoomFactor.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testAccessAndChangeZoomFactor() throws Exception {
        // create UI
        UnitTestHelper.createUI(demoController, zoomPanel);
        // get the old factor
        @SuppressWarnings("unused")
        double factor = zoomPanel.getZoomFactor();
        // zoom to 3.0
        zoomPanel.setZoomFactor(5);
        zoomPanel.setZoomFactor(4);
        // dispose the UI
        UnitTestHelper.disposeUI();
    }

    /**
     * <p>
     * This is the third part of this component demo. It will demonstrate how to access zoomTransform of zoomPanel and
     * how to change zoomTransform to make the UI in the panel zoom. This demo uses custom AffineTransform to zoom in
     * affine transform. The UI can be zoomed by both setting zoomFactor and zoomTransform. This demo sets the
     * zoomTransform.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testAccessAndChangeZoomTransformAffineTransform() throws Exception {
        // create UI
        UnitTestHelper.createUI(demoController, zoomPanel);

        // get the old factor
        @SuppressWarnings("unused")
        ZoomTransform tranform = zoomPanel.getTransform();
        // set transform to affine transform
        zoomPanel.setTransform(new AffineZoomTransform(new AffineTransform(0.5, 1, 0, 0.5, 1, 0)));

        // dispose the UI
        UnitTestHelper.disposeUI();
    }

    /**
     * <p>
     * This is the fourth part of this component demo. It will demonstrate how to access zoomTransform of zoomPanel and
     * how to change zoomTransform to make the UI in the panel zoom. This demo uses NatureZoomTransform to zoom 2.5
     * times larger. The UI can be zoomed by both setting zoomFactor and zoomTransform. This demo sets the
     * zoomTransform.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testAccessAndChangeZoomTransformNatureTransform() throws Exception {
        // create UI
        UnitTestHelper.createUI(demoController, zoomPanel);

        // get the old factor
        @SuppressWarnings("unused")
        ZoomTransform tranform = zoomPanel.getTransform();
        // set zoom to 2.5
        zoomPanel.setTransform(new NatureZoomTransform(2.5));

        // dispose the UI
        UnitTestHelper.disposeUI();
    }

    /**
     * <p>
     * This is the fifth part of this component demo. It will demonstrate how to manipulate the scroll bars of the
     * zoomPanel. ZoomPanel extends JScrollPane, so users can use scroll bars of it as using a JScrollPane.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testManipulateScrollbars() throws Exception {
        // create UI
        UnitTestHelper.createUI(demoController, zoomPanel);

        // use the API of JScrollPane
        zoomPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        zoomPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // Access the JScrollBar indirectly
        zoomPanel.getVerticalScrollBar().setUnitIncrement(3);
        zoomPanel.getVerticalScrollBar().setBlockIncrement(25);

        // dispose the UI
        UnitTestHelper.disposeUI();
    }

    /**
     * <p>
     * This is the sixth part of this component demo. It will demonstrate how to manipulate Viewport of the zoomPanel.
     * Users don't change the size of ZoomPane. ZoomPane is the "scrollable client", and the size of JViewport just
     * specifies how much area users can see through the view port, and the position of the view port specifies which
     * part users can see.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testManipulateViewport() throws Exception {
        // create UI
        UnitTestHelper.createUI(demoController, zoomPanel);

        // get access to the JViewport
        JViewport viewport = zoomPanel.getViewport();
        // manipulate via JViewport's API
        Rectangle toShow = new Rectangle(200, 100);
        viewport.scrollRectToVisible(toShow);
        Dimension size = new Dimension(400, 300);
        viewport.setViewSize(size);
        viewport.setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE);

        // dispose the UI
        UnitTestHelper.disposeUI();
    }

    /**
     * <p>
     * This is the seventh part of this component demo. It will demonstrate how to set the background color of the
     * zoomPanel.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testConfigureBackground() throws Exception {
        // create UI
        UnitTestHelper.createUI(demoController, zoomPanel);

        zoomPanel.setZoomBackground(Color.BLUE);

        // dispose the UI
        UnitTestHelper.disposeUI();
    }

    /**
     * <p>
     * This is the eighth part of this component demo. It will demonstrate creating a user UI with grids in the ZoomPane
     * and a label showing the cursor coordinates information. This demo uses the ZoomPane with NatureZoomTransform(3.0)
     * in it. So the grids in it are zoomed larger.
     * </p>
     * <p>
     * But as a matter of fact, the uses should better not use this ZoomPane without enclosing it in ZoomPanel. Because
     * users can't see Viewport and the view size without ZoomPanel. So the ZoomPane doesn't make much sense itself.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCreateZoomPaneUI() throws Exception {
        // Create and set up the window.
        // The JFrame instance.
        JFrame frame = new JFrame("CoordinatesDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // We add the zoom component to the root pane
        Container container = frame.getRootPane();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

        // Create the Label to show mouse event information
        DemoController controller = new DemoController();

        // coordinateArea is the zoomed component
        CoordinateArea coordinateArea1 = new CoordinateArea(controller);

        // create a ZoomPanel to wrap around it.
        ZoomPane zoomPane = new ZoomPane(coordinateArea1, new NatureZoomTransform(3.0));
        container.add(zoomPane);

        // add label
        controller.buildUI(container);

        // Display the window.
        frame.pack();
        frame.setVisible(true);

        // Dispose the window. This may not be useful in your application.
        frame.dispose();
    }
}
