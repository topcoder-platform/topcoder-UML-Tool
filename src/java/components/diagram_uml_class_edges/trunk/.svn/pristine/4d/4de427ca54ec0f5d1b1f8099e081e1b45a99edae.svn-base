/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import com.topcoder.gui.diagramviewer.edges.EdgeEnding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

/**
 * <p>
 * This class represents the simple closed arrow (triangle) used in edges: |&gt;.
 * </p>
 *
 * <p>
 * It can draw a simple closed arrow at specified location and angle, and it also can determine whether given point is
 * in the arrow triangle.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is immutable, but the super class may not be thread-safe.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public class ClosedArrow extends EdgeEnding {

    /** Represents the length of arrow. */
    private static final int ARROW_LENGTH = 10;

    /** Represents the number of arrow length to the virtual original. */
    private static final int K = 0;

    /**
     * <p>
     * Empty default constructor.
     * </p>
     */
    public ClosedArrow() {
    }

    /**
     * <p>
     * Paint the simple closed arrow (triangle): |&gt;.
     * </p>
     *
     * @param g
     *            the graphics to paint on (ignore null)
     */
    protected void paintComponent(Graphics g) {
        if (g == null) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;
        // back up the old color
        Color oldColor = g2.getColor();

        //Get endingPoint
        Point endingPoint = getEndingPoint();

        //Rotate the graphics
        g2.rotate(getAngle(), endingPoint.getX(), endingPoint.getY());

        //Paint the closed arrow
        Polygon triangle = new Polygon();
        triangle.addPoint(endingPoint.x - ARROW_LENGTH, endingPoint.y - ARROW_LENGTH);
        triangle.addPoint(endingPoint.x, endingPoint.y);
        triangle.addPoint(endingPoint.x - ARROW_LENGTH, endingPoint.y + ARROW_LENGTH);

        g2.setColor(Color.white);
        g2.fillPolygon(triangle);

        //Use parent edge color
        if (getParent() != null) {
            g2.setColor(getParent().getForeground());
        }
        g2.drawPolygon(triangle);

        //set back old color
        g2.setColor(oldColor);
    }

    /**
     * <p>
     * Determine whether the point is contained in closed arrow.
     * </p>
     *
     * @param x
     *            the x-coordinate value
     * @param y
     *            the y-coordinate value
     *
     * @return whether the point is contained.
     */
    public boolean contains(int x, int y) {
        return Utils.containsInArrow(x, y, getAngle(), getEndingPoint(), ARROW_LENGTH, K);
    }
}
