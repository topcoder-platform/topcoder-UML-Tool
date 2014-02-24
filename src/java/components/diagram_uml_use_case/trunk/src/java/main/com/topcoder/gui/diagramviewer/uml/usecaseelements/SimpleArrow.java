/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

/**
 * <p>
 * This class represents the simple arrow used in edges.
 * </p>
 * <p>
 * It can draw a simple arrow at specified location and angle, and it also can determine whether given point is in the
 * arrow triangle.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe, because the EdgeEnding class is not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class SimpleArrow extends EdgeEnding {

    /**
     * <p>
     * Represent the Arrow length.
     * </p>
     */
    private static final int ARROW_LENGTH = 10;

    /**
     * <p>
     * Empty default constructor.
     * </p>
     */
    public SimpleArrow() {
    }

    /**
     * <p>
     * Paint the simple arrow. <b>We assume that the arrow ending point and angle are defined in super class</b>
     * </p>
     *
     * @param g the graphics to paint on (ignore null)
     */
    protected void paintComponent(Graphics g) {
        if (g != null) {
            super.paintComponents(g);
            Graphics2D g2d = (Graphics2D) g;
            int endX = (int) getEndingPoint().getX();
            int endY = (int) getEndingPoint().getY();

            AffineTransform tx = AffineTransform.getRotateInstance(getAngle(), getEndingPoint().getX(),
                    getEndingPoint().getY());

            Point desPoint =  new Point();
            tx.transform(new Point(endX - ARROW_LENGTH, endY - ARROW_LENGTH), desPoint);
            g2d.drawLine(desPoint.x, desPoint.y, endX, endY);
            tx.transform(new Point(endX - ARROW_LENGTH, endY + ARROW_LENGTH), desPoint);
            g2d.drawLine(desPoint.x, desPoint.y, endX, endY);
        }
    }

    /**
     * <p>
     * Determine whether the point is contained in arrow. <b>We assume that the arrow ending point and angle are defined
     * in super class.</b>
     * </p>
     *
     * @return whether the point is contained.
     * @param x the x coordinate value
     * @param y the y coordinate value
     */
    public boolean contains(int x, int y) {
        // translate the point
        AffineTransform tx = AffineTransform.getRotateInstance(-getAngle(), getEndingPoint().getX(),
                getEndingPoint().getY());
        Point ptSrc = new Point(x, y);
        Point ptDst = new Point();
        tx.transform(ptSrc, ptDst);

        // determine whether the x, y is in the triangle.
        int endX = (int) getEndingPoint().getX();
        int endY = (int) getEndingPoint().getY();
        if (ptDst.x == endX) {
            if (ptDst.y == endY) {
                return true;
            }
        } else if ((endX - ptDst.x) <= ARROW_LENGTH && (endX - ptDst.x) >= 0
                && Math.abs((ptDst.y - endY) * 1.0 / (ptDst.x - endX)) <= 1) {
            return true;
        }
        return false;
    }
}