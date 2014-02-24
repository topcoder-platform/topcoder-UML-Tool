/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 * <p>
 * This class provides methods for testing use.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class UnitTestHelper {

    /**
     * JFrame instance used for testing in demo to show the testing UI.
     */
    private static JFrame jframe;

    /**
     * Private constructor to prevent this class being instantiated.
     */
    private UnitTestHelper() {
        // Does nothing.
    }

    /**
     * <p>
     * Returns if the Component array contains the component object passed in.
     * </p>
     * @param components the Component array
     * @param component which is to be checked whether it is in the array
     * @return boolean whether the component is in the array
     */
    public static boolean containComponent(Component[] components, Component component) {
        boolean ret = false;
        for (Component c : components) {
            if (c.equals(component)) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    /**
     * <p>
     * Creates a UI for testing. Including the ZoomPanel instance and JComponent wrapped by the ZoomPanel.
     * </p>
     *
     * @param demoController
     *            DemoController instance to show the label and cursor information
     * @param zoomPanel
     *            the ZoomPanel instance to wrap the component
     */
    public static void createUI(DemoController demoController, ZoomPanel zoomPanel) {
        // Create and set up the window.
        jframe = new JFrame("Testing frame");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // We add the zoom component to the root pane
        Container container = jframe.getRootPane();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

        // create a ZoomPanel to wrap around it.
        container.add(zoomPanel);

        // add label
        demoController.buildUI(container);

        // Display the window.
        jframe.pack();
        jframe.setVisible(true);
    }

    /**
     * <p>
     * Dispose the UI created by this helper class.
     * </p>
     */
    public static void disposeUI() {
        jframe.dispose();
        jframe = null;
    }

    /**
     * Returns a Graphics2DDummy instance for testing.
     *
     * @return a Graphics2DDummy instance
     */
    public static Graphics2D getGraphics2D() {
        return new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB).createGraphics();
    }
}
