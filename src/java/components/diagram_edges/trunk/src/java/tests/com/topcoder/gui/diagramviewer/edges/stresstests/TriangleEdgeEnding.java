/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.stresstests;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import com.topcoder.gui.diagramviewer.edges.EdgeEnding;

/**
 * This class is an implementation of <code>EdgeEnding</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class TriangleEdgeEnding extends EdgeEnding {

    /**
     * The default constructor.
     */
    public TriangleEdgeEnding() {
    }

    /**
     * Paints this component.
     *
     * @param g
     *            the graphics to paint on
     */
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Point endingPoint = getEndingPoint();
        double x = endingPoint.getX();
        double y = endingPoint.getY();

        Polygon poly = new Polygon();
        poly.addPoint((int) x - 10, (int) y - 5);
        poly.addPoint((int) x, (int) y);
        poly.addPoint((int) x - 10, (int) y + 5);

        AffineTransform tx = AffineTransform.getRotateInstance(getAngle(), x, y);
        g2d.fill(tx.createTransformedShape((Shape) poly));
    }

    /**
     * Simply returns false.
     *
     * @param x
     *            the x coordinate value
     * @param y
     *            the y coordinate value
     *
     * @return false always
     */
    public boolean contains(int x, int y) {
        return false;
    }
}
