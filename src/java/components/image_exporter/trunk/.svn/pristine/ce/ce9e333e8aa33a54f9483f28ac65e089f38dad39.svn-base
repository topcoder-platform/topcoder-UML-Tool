/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


/**
 * Component used in test. This component is the component to be printed.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PrintingPanel extends JPanel {
    /** message of the text. */
    private String message;

    /** font size of the text. */
    private int fontSize = 30;

    /** width of the message. */
    private int messageWidth;

/**
     * Creates a new PrintingPanel object.
     *
     * @param width width of the pannel
     * @param height height of the pannel
     * @param message message
     */
    public PrintingPanel(int width, int height, String message) {
        this.message = message;
        setBackground(Color.BLUE);

        Font font = new Font("Serif", Font.PLAIN, fontSize);
        setFont(font);

        FontMetrics metrics = getFontMetrics(font);
        messageWidth = metrics.stringWidth(message);
        setPreferredSize(new Dimension(width, height));
    }

    /**
     * paint the component.
     *
     * @param g graphics context
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        int x = messageWidth / 10;
        int y = (fontSize * 5) / 2;
        g2d.translate(x, y);
        g2d.setPaint(Color.black);
        g2d.drawString(message, 0, 0);
    }
}
