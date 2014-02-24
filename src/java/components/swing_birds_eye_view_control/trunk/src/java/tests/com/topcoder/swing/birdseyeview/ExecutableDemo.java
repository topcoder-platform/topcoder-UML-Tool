/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

/**
 * <p>
 * This is an executable demo of the Birds Eye View component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ExecutableDemo {

    /**
     * <p>
     * Private constructor to void the creation of this class
     * from the other code.
     * </p>
     */
    private ExecutableDemo() {
    }

    /**
     * <p>
     * Static Main method to provide a executable demo of the Birds Eye View
     * component.
     * </p>
     * @param args
     *              the arguments from the java execute command
     */
    public static void main(String args[]) {
        // set the configuration in the UIManager
        UIManager.put("BirdsEyeView.overlayColor", Color.green);
        UIManager.put("BirdsEyeView.overlayBorderColor", Color.yellow);
        UIManager.put("BirdsEyeView.overlayBorderThickness", "1");
        UIManager.put("BirdsEyeView.overlayOpacity", "0.5");

        GUIForTest gui = new GUIForTest();
        gui.createUI();

        JLabel label = new JLabel(new ImageIcon("test_files/demo_test.gif"));
        JScrollPane sp = new JScrollPane(label);
        sp.setSize(380, 220);

        JLabel label1 = new JLabel(new ImageIcon("test_files/demo_test.gif"));
        BirdsEyeView birdEye = new BirdsEyeView(label1, sp.getSize(),
                new Point(0, 0));
        birdEye.setMaximumSize(new Dimension(300, 190));
        birdEye.setMinimumSize(new Dimension(300, 190));
        birdEye.setPreferredSize(new Dimension(300, 190));
        birdEye.getZoomPanel().setPreferredSize(new Dimension(300, 160));
        birdEye.getViewPort().addViewPortListener(new ChangeViewPortListener(sp));

        gui.add(sp);
        gui.add(birdEye);

        gui.showUI();
    }
}
