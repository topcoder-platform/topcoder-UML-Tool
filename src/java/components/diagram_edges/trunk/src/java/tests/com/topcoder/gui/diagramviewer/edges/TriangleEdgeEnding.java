/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

/**
 * <p>
 * This class extends the TriangleEdgeEnding class and is used for demonstration.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TriangleEdgeEnding extends EdgeEnding {
    /**
     * <p>
     * Construct a TriangleEdgeEnding instance.
     * </p>
     */
    public TriangleEdgeEnding() {
    }

    /**
     * <p>
     * Construct a TriangleEdgeEnding with angle and ending point given.
     * </p>
     *
     * <p>
     * Note, the angle should be in radian representation.
     * The endingPoint is cloned.
     * </p>
     *
     * @param angle the angle of edge ending
     * @param endingPoint the ending point of edge.
     *
     * @throws IllegalArgumentException if endingPoint is null.
     */
    public TriangleEdgeEnding(double angle, Point endingPoint) {
        super(angle, endingPoint);
    }

    /**
     * <p>
     * This method draws the arrow at the specified ending point.
     * </p>
     *
     * @param g the graphics to paint on
     */
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Point endingPoint = getEndingPoint();

        double x1 = endingPoint.getX();
        double y1 = endingPoint.getY();

        Polygon poly = new Polygon();
        poly.addPoint((int) x1 - 10, (int) y1 - 5);
        poly.addPoint((int) x1, (int) y1);
        poly.addPoint((int) x1 - 10, (int) y1 + 5);

        AffineTransform tx = AffineTransform.getRotateInstance(getAngle(), x1, y1);
        g2d.fill(tx.createTransformedShape((Shape) poly));
    }

    /**
     * <p>
     * This method returns false always because it is not interested at any swing events.
     * </p>
     *
     * @param x the x-coordinate value
     * @param y the y-coordinate value
     *
     * @return false always
     */
    public boolean contains(int x, int y) {
        return false;
    }
}
