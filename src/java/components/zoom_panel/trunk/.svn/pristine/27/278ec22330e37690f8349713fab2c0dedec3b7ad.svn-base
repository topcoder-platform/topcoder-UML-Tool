/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

/**
 * <p>
 * This is a framed area. As the user moves the cursor over the area, a label displays the cursor's location. When the
 * user clicks, the area displays a 7x7 dot at the click location. This frame is enclosed in ZoomPanel which is to be
 * zoomed.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CoordinateArea extends JComponent implements MouseInputListener {
    /**
     * Last clicked Point.
     */
    private Point point = null;

    /**
     * The DemoCotroller instance to show the cursor coordinates information.
     */
    private DemoController controller;

    /**
     * The size of the JComponent.
     */
    private Dimension preferredSize = new Dimension(400, 75);

    /**
     *
     * @param controller
     *            the controller to show cursor information
     */
    public CoordinateArea(DemoController controller) {
        this.controller = controller;

        // Add a border of 5 pixels at the left and bottom,
        // and 1 pixel at the top and right.
        setBorder(BorderFactory.createMatteBorder(1, 5, 5, 1, Color.RED));

        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.WHITE);
        setOpaque(true);
    }

    /**
     * Return the size of the component.
     *
     * @return the size
     */
    public Dimension getPreferredSize() {
        return preferredSize;
    }

    /**
     * Draws the component.
     *
     * @param g
     *            the Graphics object used to draw
     */
    protected void paintComponent(Graphics g) {
        // Paint background if we're opaque.
        if (isOpaque()) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        // Paint 20x20 grid.
        g.setColor(Color.GRAY);
        drawGrid(g, 20);
        // If user has chosen a point, paint a small dot on top.
        if (point != null) {
            g.setColor(getForeground());
            g.fillRect(point.x - 3, point.y - 3, 7, 7);
        }
    }

    /**
     * Draws a 20x20 grid using the current color.
     *
     * @param g
     *            the Graphics object used to draw
     * @param gridSpace
     *            the width and height of the grid
     */
    private void drawGrid(Graphics g, int gridSpace) {
        Insets insets = getInsets();
        int firstX = insets.left;
        int firstY = insets.top;
        int lastX = getWidth() - insets.right;
        int lastY = getHeight() - insets.bottom;

        // Draw vertical lines.
        int x = firstX;
        while (x < lastX) {
            g.drawLine(x, firstY, x, lastY);
            x += gridSpace;
        }

        // Draw horizontal lines.
        int y = firstY;
        while (y < lastY) {
            g.drawLine(firstX, y, lastX, y);
            y += gridSpace;
        }
    }

    /**
     * Methods required by the MouseInputListener interface.
     *
     * @param e
     *            the MouseEvent object
     */
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (point == null) {
            point = new Point(x, y);
        } else {
            point.x = x;
            point.y = y;
        }
        controller.updateClickPoint(point);
        repaint();
    }

    /**
     * Methods required by the MouseInputListener interface.
     *
     * @param e
     *            the MouseEvent object
     */
    public void mouseMoved(MouseEvent e) {
        controller.updateCursorLocation(e.getX(), e.getY());
    }

    /**
     * Methods required by the MouseInputListener interface.
     *
     * @param e
     *            the MouseEvent object
     */
    public void mouseExited(MouseEvent e) {
        controller.resetLabel();
    }

    /**
     * Methods required by the MouseInputListener interface.
     *
     * @param e
     *            the MouseEvent object
     */
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Methods required by the MouseInputListener interface.
     *
     * @param e
     *            the MouseEvent object
     */
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Methods required by the MouseInputListener interface.
     *
     * @param e
     *            the MouseEvent object
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Methods required by the MouseInputListener interface.
     *
     * @param e
     *            the MouseEvent object
     */
    public void mouseDragged(MouseEvent e) {
    }
}
