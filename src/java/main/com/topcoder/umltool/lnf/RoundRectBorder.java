package com.topcoder.umltool.lnf;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.border.LineBorder;

public class RoundRectBorder extends LineBorder {
	private final int arcLen;

	public RoundRectBorder(Color color, int arcLen) {
		super(color, 1, true);
		this.arcLen=arcLen;
	}
	
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Color oldColor = g.getColor();
        int i;
		Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(lineColor);
        for(i = 0; i < thickness; i++)  {
	        g2d.drawRoundRect(x+i, y+i, width-i-i-1, height-i-i-1, arcLen, arcLen);
        	
        }
        g2d.setColor(oldColor);
    }
}
