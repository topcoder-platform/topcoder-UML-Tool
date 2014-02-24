package com.topcoder.umltool.lnf;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.UIManager;

import javax.swing.border.LineBorder;

public class RoundCornerLineBorder extends LineBorder {
    private static final int ARC = 6;

    private Color backgroundColor;

    public RoundCornerLineBorder(Color color, Color backgroundColor, int thickness) {
        super(color, thickness, true);
        this.backgroundColor = backgroundColor;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Color oldColor = g.getColor();

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(UIManager.getColor("MainFrame.backgroundColor"));
        g2d.fillRect(0, 0, c.getWidth(), height);

        g2d.setColor(getLineColor());
        // Paint slant
        // g.drawLine(1, 5, 6, 0);
        g2d.drawArc(0, 0, ARC * 2, ARC * 2, 90, 90);
        // Paint top
        g2d.drawLine(ARC + 1, 0, c.getWidth() - ARC, 0);
        g2d.drawArc(c.getWidth() - ARC * 2 - 1, 0, ARC * 2, ARC * 2, 0, 90);
        g2d.drawLine(0, ARC, 0, height - 1);
        g2d.drawLine(c.getWidth() - 1, ARC, c.getWidth() - 1, height - 1);
        g2d.drawLine(0, height - 2, c.getWidth(), height - 2);
        g2d.setColor(backgroundColor);
        g2d.fillArc(1, 1, ARC * 2, ARC * 2, 90, 90);

        g2d.fillArc(c.getWidth() - ARC * 2 - 1, 1, ARC * 2, ARC * 2, 0, 90);
        g2d.fillRect(ARC + 1, 1, c.getWidth() - ARC * 2 - 2, height - 3);
        g2d.fillRect(1, ARC, ARC * 2, height - ARC - 2);
        g2d.fillRect(c.getWidth() - ARC * 2 - 1, ARC, ARC * 2, height - ARC - 2);
        g2d.setColor(oldColor);
    }

}
