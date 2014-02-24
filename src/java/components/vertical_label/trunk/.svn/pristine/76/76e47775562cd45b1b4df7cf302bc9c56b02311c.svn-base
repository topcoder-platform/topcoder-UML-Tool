/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.verticallabel.stresstests;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.topcoder.gui.verticallabel.JVerticalLabel;

/**
 * Stress test for <code>JVerticalLabel</code> class.
 *
 * @author CoInitialize
 * @version 1.0
 */
public class JVerticalLabelStressTest extends StressTestCase {

    /**
     * Represents the test loop count of the stress tests.
     */
    private static final int LOOP = 10000;

    /**
     * Test <code>JVerticalLabel</code>'s inner class' method
     * <code>VerticalLabelUI#paint(Graphics, JComponent)</code> for stress.
     *
     * @throws Exception exception thrown to JUnit.
     */
    public void testPaint() throws Exception {
        ImageIcon icon = new ImageIcon("test_files/stresstests/icon.png");

        JVerticalLabel[] labels = new JVerticalLabel[2];
        labels[0] = new JVerticalLabel("Hello world!", icon, SwingConstants.LEFT, true);
        labels[1] = new JVerticalLabel("Hello world!", icon, SwingConstants.LEFT, false);
        labels[1].setEnabled(false);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(labels[0]);
        panel.add(labels[1]);

        JFrame frame = new JFrame("StressTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(200, 200));
        frame.setContentPane(panel);
        frame.setVisible(true);

        start();
        for (int i = 0; i < LOOP; i++) {
            labels[0].getUI().paint(frame.getGraphics(), labels[0]);
            labels[1].getUI().paint(frame.getGraphics(), labels[1]);
        }
        stop();

        System.out.println("Run #paint(Graphics, JComponent) for " + LOOP + " times consumes " + getMilliseconds()
            + " milliseconds.");
    }
}
