/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

/**
 * <p>
 * This class represents the line style of the segments of the edge.
 * </p>
 *
 * <p>
 * A line can be continuous or dashed. The dashes can be configurable.
 * The length of the dash and the length of the blank space between the dashes can both be configured.
 * </p>
 *
 * <p>
 * Thread Safety : This class is mutable and not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class LineStyle {
    /**
     * <p>
     * Represent the length of dash.
     * </p>
     *
     * <p>
     * It is initialized in the constructor, and can be accessed by setter/getter.
     * </p>
     *
     * <p>
     * It will be positive.
     * </p>
     */
    private int dashLength;

    /**
     * <p>
     * Represent the length of blank spaces between dashes.
     * </p>
     *
     * <p>
     * It is initialized in the constructor, and can be accessed by setter/getter.
     * </p>
     *
     * <p>
     * It will be non-negative.
     * If it is zero, the line is continuous.
     * </p>
     */
    private int blankLength;

    /**
     * <p>
     * Construct a LineStyle instance with dashLength and blankLength given.
     * </p>
     *
     * @param dashLength the length of dash
     * @param blankLength the length of blank spaces
     *
     * @throws IllegalArgumentException if dashLength is not positive, or blankLength is negative.
     */
    public LineStyle(int dashLength, int blankLength) {
        Util.checkNotPositive(dashLength, "dashLength");
        if (blankLength < 0) {
            throw new IllegalArgumentException("The blankLength is negative, its value is " + blankLength);
        }

        this.dashLength = dashLength;
        this.blankLength = blankLength;
    }

    /**
     * <p>
     * Get the length of dash.
     * </p>
     *
     * @return the length of dash
     */
    public int getDashLength() {
        return dashLength;
    }

    /**
     * <p>
     * Set the length of dash.
     * </p>
     *
     * @param dashLength the new length of dash to set
     *
     * @throws IllegalArgumentException if dashLength is not positive.
     */
    public void setDashLength(int dashLength) {
        Util.checkNotPositive(dashLength, "dashLength");

        this.dashLength = dashLength;
    }

    /**
     * <p>
     * Get the length of blank spaces between dashes.
     * </p>
     *
     * @return the length of blank spaces between dashes.
     */
    public int getBlankLength() {
        return blankLength;
    }

    /**
     * <p>
     * Set the length of blank spaces between dashes.
     * </p>
     *
     * @param blankLength the new length of blank to set
     *
     * @throws IllegalArgumentException if blankLength is negative.
     */
    public void setBlankLength(int blankLength) {
        if (blankLength < 0) {
            throw new IllegalArgumentException("The blankLength is negative, its value is " + blankLength);
        }

        this.blankLength = blankLength;
    }

    /**
     * <p>
     * Paint the line on the graphics with the styles defined in this class.
     * </p>
     *
     * @param g the graphics to paint on
     * @param p1 the first point of line
     * @param p2 the second point of line
     *
     * @throws IllegalArgumentException if any parameter is null
     */
    public void paint(Graphics g, Point p1, Point p2) {
        Util.checkNull(g, "g");
        Util.checkNull(p1, "p1");
        Util.checkNull(p2, "p2");

        if (blankLength == 0) {
            // a normal line
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        } else {
            // a dashed line
            Graphics2D g2d = (Graphics2D) g;
            float[] dashPattern = {dashLength, blankLength};

            // back up the original stroke
            Stroke stroke = g2d.getStroke();

            g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, dashPattern, 0));
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);

            // restore the original stroke, so it won't affect the drawing of other swing components
            g2d.setStroke(stroke);
        }

    }
}
