/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.AffineTransform;

/**
 * <p>
 * This class represents the no-arrow ending used in edges: ---.
 * </p>
 *
 * <p>
 * It just draw nothing, but allows selection, name/multiplicity and edge ending popup menu, because it is a child of
 * the <code>ActiveEdgeEnding</code>.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is immutable, but the super class may not be thread-safe.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public class NoArrow extends ActiveEdgeEnding {

    /** Represents the width of rectangle. */
    private static final int RECTANGLE_WIDTH = 10;

    /** Represents the height of rectangle. */
    private static final int RECTANGLE_HEIGHT = 5;

    /**
     * <p>
     * Construct the <code>NoArrow</code> active edge ending with specified name and multiplicity compartments.
     * </p>
     *
     * @param name
     *            The name compartment to be registered to the edge ending.
     * @param multiplicity
     *            The multiplicity compartment to be registered to the edge ending.
     *
     * @throws IllegalArgumentException
     *             If any argument is null
     */
    public NoArrow(TextField name, TextField multiplicity) {
        super(name, multiplicity);
    }

    /**
     * <p>
     * Paint nothing.
     * </p>
     *
     * @param g
     *            the graphics to paint on (ignore null)
     */
    protected void paintComponent(Graphics g) {
    }

    /**
     * <p>
     * Determine whether the point is contained in the virtual rectangle (10x5 points).
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
        //Compute the new point through transform
        AffineTransform transform = AffineTransform.getRotateInstance(-getAngle(),
                getEndingPoint().getX(), getEndingPoint().getY());
        Point ptSrc = new Point(x, y);
        Point ptDst = new Point();
        transform.transform(ptSrc, ptDst);

        //Determine whether the new point is in rectangle, ending point is treated as right-top point
        int lengthX = (int) getEndingPoint().getX() - ptDst.x;
        int lengthY = (int) getEndingPoint().getY() - ptDst.y;
        if (lengthX > RECTANGLE_WIDTH || lengthX < 0 || lengthY > RECTANGLE_HEIGHT || lengthY < 0) {
            return false;
        }
        return true;
    }
}
