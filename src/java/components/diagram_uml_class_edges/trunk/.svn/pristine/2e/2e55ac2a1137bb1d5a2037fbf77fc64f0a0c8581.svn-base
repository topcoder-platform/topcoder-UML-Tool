/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

/**
 * <p>
 * This class represents the filled diamond used in edges: &lt;*&gt;.
 * </p>
 *
 * <p>
 * It can draw a filled (with the color of parent edge) diamond at specified location and angle, and it also can
 * determine whether given point is in the edge ending diamond. It also allows selection, name/multiplicity and edge
 * ending popup menu, because it is a child of the ActiveEdgeEnding.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is immutable, but the super class may not be thread-safe.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public class Composition extends ActiveEdgeEnding {

    /** Represents the length of arrow. */
    private static final int ARROW_LENGTH = 10;

    /**
     * <p>
     * Construct the <code>Composition</code> active edge ending with specified name and multiplicity compartments.
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
    public Composition(TextField name, TextField multiplicity) {
        super(name, multiplicity);
    }

    /**
     * <p>
     * Paint the filled (with the color of the parent edge) diamond: &lt;*&gt;.
     * </p>
     *
     * @param g
     *            the graphics to paint on (ignore null)
     */
    protected void paintComponent(Graphics g) {
        if (g == null) {
            return;
        }

        //Paints the name/multiplicity compartments
        for (Component child : super.getComponents()) {
            if (child instanceof TextField) {
                ((TextField) child).paintComponent(g);
            }
        }

        Graphics2D g2 = (Graphics2D) g;
        // back up the old color
        Color oldColor = g2.getColor();

        //Get endingPoint
        Point endingPoint = getEndingPoint();

        //Rotate the graphics
        // BugFix: UML-9890
//        g2.rotate(-getAngle(), endingPoint.getX(), endingPoint.getY());
        g2.rotate(getAngle(), endingPoint.getX(), endingPoint.getY());

        //Paint the diamond
        Polygon diamond = new Polygon();
        diamond.addPoint(endingPoint.x - ARROW_LENGTH, endingPoint.y - ARROW_LENGTH);
        diamond.addPoint(endingPoint.x, endingPoint.y);
        diamond.addPoint(endingPoint.x - ARROW_LENGTH, endingPoint.y + ARROW_LENGTH);
        diamond.addPoint(endingPoint.x - ARROW_LENGTH - ARROW_LENGTH, endingPoint.y);

        //Use parent edge color
        if (getParent() != null) {
            g2.setColor(getParent().getForeground());
        }

        g2.fillPolygon(diamond);

        //set back old color
        g2.setColor(oldColor);
    }

    /**
     * <p>
     * Determine whether the point is contained in diamond.
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
        return Utils.containsInDiamond(x, y, getAngle(), getEndingPoint(), ARROW_LENGTH);
    }
}
