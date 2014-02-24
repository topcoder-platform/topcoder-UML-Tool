/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;

import com.topcoder.gui.diagramviewer.edges.EdgeEnding;

/**
 * <p>
 * This class represents the simple arrow used in edges.
 * </p>
 * <p>
 * It can draw a simple arrow at specified location and angle, and it also can determine whether given point is in the
 * arrow triangle.
 * </p>
 * <p>
 * This class is immutable, but the super class may not be thread-safe.
 * </p>
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class SimpleArrowEdgeEnding extends EdgeEnding {

    /**
     * <p>
     * Displacement for draw arrow.
     * </p>
     */
    private static final int DISPLACEMENT = 10;

    /**
     * <p>
     * Creates a <code>SimpleArrowEdgeEnding</code> instance.
     * </p>
     * @param angle
     *            the angle
     * @param endingPoint
     *            the ending point
     * @throws IllegalArgumentException
     *             if endingPoint is null
     */
    public SimpleArrowEdgeEnding(double angle, Point endingPoint) {
        super(angle, endingPoint);
    }

    /**
     * <p>
     * Determines whether the point is contained in arrow.
     * </p>
     * @param x
     *            the x coordinate value
     * @param y
     *            the y coordinate value
     * @return whether the point is contained, if fail to compute, return false
     */
    public boolean contains(int x, int y) {
        Point endingPoint = getEndingPoint();
        AffineTransform transform = new AffineTransform();
        transform.rotate(getAngle(), endingPoint.x, endingPoint.y);
        Point2D point = new Point(x, y);
        try {
            point = transform.inverseTransform(new Point(x, y), null);
        } catch (NoninvertibleTransformException e) {
            return false;
        }
        int[] xpoints = new int[3];
        int[] ypoints = new int[3];
        xpoints[0] = endingPoint.x - DISPLACEMENT;
        ypoints[0] = endingPoint.y - DISPLACEMENT;
        xpoints[1] = endingPoint.x;
        ypoints[1] = endingPoint.y;
        xpoints[2] = endingPoint.x - DISPLACEMENT;
        ypoints[2] = endingPoint.y + DISPLACEMENT;
        Polygon triangle = new Polygon(xpoints, ypoints, 3);
        return triangle.contains(point.getX(), point.getY());
    }

    /**
     * <p>
     * Paints the simple arrow.
     * </p>
     * @param graphics
     *            the graphics context in which to paint
     */
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        Point endingPoint = getEndingPoint();
        /*
         * BugFix: BUGID UML-7179
         * Description:
         * This method uses -getAngle() to calculate the rotation angle, actually it should be getAngle().
         * Solution:
         * Code is modified to use getAngle().
         */
        // old code
//        g2d.rotate(-getAngle(), endingPoint.x, endingPoint.y);
        g2d.rotate(getAngle(), endingPoint.x, endingPoint.y);
        g2d.drawLine(endingPoint.x - DISPLACEMENT, endingPoint.y - DISPLACEMENT, endingPoint.x, endingPoint.y);
        g2d.drawLine(endingPoint.x - DISPLACEMENT, endingPoint.y + DISPLACEMENT, endingPoint.x, endingPoint.y);
    }
}
