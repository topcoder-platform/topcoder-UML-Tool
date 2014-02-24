/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

/**
 * <p>
 * The package class is used to support the gesture painting for <code>SectionDockContainer</code>.
 * It overrides the paint method to achieve this.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * It's not thread-safe as the super class is not thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
class DockContainerPanel extends JPanel {

    /**
     * <p>
     * The rectangle to draw gesture. Null able. Default is null.
     * Set by the setter.
     * </p>
     */
    private Rectangle gestureRect = null;

    /**
     * <p>
     * The color of the gesture. Null able. Default is null.
     * If Null, default color will be used.
     * Set by the setter.
     * </p>
     */
    private Color gestureColor = null;

    /**
     * <p>
     * Constructs a DockContainerPanel instance.
     * </p>
     */
    public DockContainerPanel() {
        // empty
    }

    /**
     * <p>
     * Setter of gestureRect property.
     * </p>
     *
     * @param gestureRect
     *        the gesture rectangle
     */
    public void setGestureRect(Rectangle gestureRect) {
        this.gestureRect = gestureRect;
    }

    /**
     * <p>
     * Setter of gestureColor property.
     * </p>
     *
     * @param gestureColor
     *        the gesture color
     */
    public void setGestureColor(Color gestureColor) {
        this.gestureColor = gestureColor;
    }

    /**
     * <p>
     * Override the paint method of JComponent to paint the gesture if exists.
     * </p>
     *
     * @param g
     *        the Graphics to paint
     */
    public void paint(Graphics g) {
        super.paint(g);

        // if gestureRect, paint
        if (gestureRect != null) {
            Color c = gestureColor;
            // if gestureColor is null, use default color
            if (c == null) {
                Color fg = getForeground();
                c = new Color(fg.getRed(), fg.getGreen(), fg.getBlue(), 128);
            }
            Color backup = g.getColor();
            g.setColor(c);
            g.drawRect(gestureRect.x, gestureRect.y, gestureRect.width, gestureRect.height);
            g.setColor(backup);
        }
    }
}
