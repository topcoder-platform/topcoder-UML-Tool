/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test cases for class DockContainerPanel.
 * </p>
 * @author extra
 * @version 1.0
 */
public class DockContainerPanelStressTests extends TestCase {

    /**
     * <p>
     * Stress test for paint(Graphics g) method.
     * </p>
     */
    public void testPaint() {
        DockContainerPanel panel = new DockContainerPanel();

        Rectangle rect = new Rectangle(0, 0, 1000, 1000);
        panel.setGestureRect(rect);
        panel.setGestureColor(Color.BLUE);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            JFrame frame = new JFrame();
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
            frame.dispose();
        }
        System.out.println("Paint the panel 20 times cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");
    }
}
