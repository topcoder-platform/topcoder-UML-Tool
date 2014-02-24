/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
/**
 * <p>
 * Helper class, used to create the container of JComponent
 * which is need to be tested.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GUIForTest {

    /**
     * <p>
     * The JFrame instance.
     * </p>
     */
    private JFrame jf = null;

    /**
     * <p>
     * Create the UI.
     * </p>
     */
    public void createUI() {
        jf = new JFrame("test");
        jf.setSize(400, 480);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = jf.getRootPane();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
    }

    /**
     * <p>
     * Add the JComponent into the JFrame.
     * </p>
     * @param comp
     *              the JComponent to be added into the JFrame
     */
    public void add(JComponent comp) {
        jf.getRootPane().add(comp);
    }

    /**
     * <p>
     * Show the UI.
     * </p>
     */
    public void showUI() {
        jf.setResizable(false);
        jf.setVisible(true);
    }

    /**
     * <p>
     * Dispose the UI.
     * </p>
     */
    public void disposeUI() {
        jf.dispose();
    }
}
