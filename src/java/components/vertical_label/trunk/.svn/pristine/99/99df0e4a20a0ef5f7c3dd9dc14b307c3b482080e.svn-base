/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.verticallabel;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import junit.framework.TestCase;

/**
 * Demo of the component.
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * Demo of the component.
     *
     * @throws Exception throw exception to junit.
     */
    public void testDemo() throws Exception {
        ImageIcon icon = new ImageIcon("test_files/uml.png");

        // Create the vertical labels with different horizontal alignment and flipped flag.
        JVerticalLabel label1 = new JVerticalLabel("JVerticalLabel 1", icon, SwingConstants.LEFT, false);
        JVerticalLabel label2 = new JVerticalLabel("JVerticalLabel 2", icon, SwingConstants.LEFT, true);
        JVerticalLabel label3 = new JVerticalLabel("JVerticalLabel 3", icon, SwingConstants.RIGHT, false);
        JVerticalLabel label4 = new JVerticalLabel("JVerticalLabel 4", icon, SwingConstants.RIGHT, true);

        label1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        label2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        label3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        label4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        label1.setVerticalAlignment(SwingConstants.TOP);
        label2.setVerticalAlignment(SwingConstants.TOP);
        label3.setVerticalAlignment(SwingConstants.TOP);
        label4.setVerticalAlignment(SwingConstants.TOP);

        // Set labels' background color.
        label1.setBackground(Color.RED);
        label2.setBackground(Color.GREEN);
        label3.setBackground(Color.BLUE);
        label4.setBackground(Color.WHITE);

        // Set labels' foreground color.
        label1.setForeground(Color.YELLOW);
        label2.setForeground(Color.BLUE);
        label3.setForeground(Color.WHITE);
        label4.setForeground(Color.BLACK);

        // Set labels' opaque.
        label1.setOpaque(true);
        label2.setOpaque(false);
        label3.setOpaque(true);
        label4.setOpaque(false);

        // Set labels' font.
        label1.setFont(Font.getFont("Arial"));
        label2.setFont(Font.getFont("Courier New"));
        label3.setFont(Font.getFont("Tahoma"));
        label4.setFont(Font.getFont("Times New Roman"));

        // Set label¡¯s border.
        label1.setBorder(new EtchedBorder());
        label2.setBorder(new EtchedBorder());
        label3.setBorder(new EtchedBorder());
        label4.setBorder(new EtchedBorder());

        // Show the vertical labels on UI.
        Container c = new Container();
        c.setLayout(new GridLayout(1, 4));
        c.add(label1);
        c.add(label2);
        c.add(label3);
        c.add(label4);

        JFrame jframe = new JFrame("Demo");
        jframe.setSize(new Dimension(400, 600));
        jframe.setLocationByPlatform(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setContentPane(c);
        jframe.setVisible(true);

        Thread.sleep(2000);
        jframe.dispose();
    }
}