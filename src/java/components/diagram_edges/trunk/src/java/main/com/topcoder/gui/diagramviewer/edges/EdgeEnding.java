/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;

/**
 * <p>
 * This class represents an ending of Edge.
 * </p>
 *
 * <p>
 * It is an extension of JComponent and is an abstract class.
 * This custom JComponent is responsible for drawing the ending of the edge.
 * </p>
 *
 * <p>
 * This class is abstract, concrete implementation should override the
 * contains() and paintComponent() method to provide custom drawing.
 * </p>
 *
 * <p>
 * Thread Safety : This class is mutable and not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public abstract class EdgeEnding extends JComponent {
    /**
     * <p>
     * Represent the angle of this edge ending in radian.
     * </p>
     *
     * <p>
     * The edge is coming in horizontally from the left side that the angle is 0 and as that
     * rotates counter-clockwise the angle increases.
     * </p>
     *
     * <p>
     * This value is mutable.
     * </p>
     */
    private double angle;

    /**
     * <p>
     * Represent the ending point of this edge ending.
     * </p>
     *
     * <p>
     * This value is mutable.
     * </p>
     */
    private Point endingPoint = new Point(0, 0);

    /**
     * <p>
     * Construct a EdgeEnding with default values.
     * </p>
     */
    public EdgeEnding() {
        // empty
    }

    /**
     * <p>
     * Construct a EdgeEnding with angle and ending point given.
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
    public EdgeEnding(double angle, Point endingPoint) {
        Util.checkNull(endingPoint, "endingPoint");

        this.angle = angle;
        this.endingPoint = new Point(endingPoint);
    }

    /**
     * <p>
     * Get the angle of this edge ending, which is in radian representation.
     * </p>
     *
     * @return the angle of this edge ending, which is in radian representation.
     */
    public double getAngle() {
        return this.angle;
    }

    /**
     * <p>
     * Set the angle of this edge ending, which is in radian representation.
     * </p>
     *
     * <p>
     * Note, there is no restriction on the given angle value.
     * </p>
     *
     * @param angle the new angle value to set
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * <p>
     * Get the ending point of this edge ending.
     * </p>
     *
     * <p>
     * Note, the ending point is cloned.
     * </p>
     *
     * @return the ending point of this edge ending.
     */
    public Point getEndingPoint() {
        return new Point(endingPoint);
    }

    /**
     * <p>
     * Set the ending point of this edge ending.
     * </p>
     *
     * <p>
     * Note, the given point is cloned.
     * </p>
     *
     * @param point the new ending point value to set
     *
     * @throws IllegalArgumentException if point is null.
     */
    public void setEndingPoint(Point point) {
        Util.checkNull(point, "point");

        this.endingPoint = new Point(point);
    }

    /**
     * <p>
     * This method is left as abstract to enforce subclass to provide concrete implementation.
     * </p>
     *
     * <p>
     * The concrete implementation should override this method for custom drawing.
     * </p>
     *
     * <p>
     * It will be called automatically by SWING framework.
     * </p>
     *
     * @param g the graphics to paint on
     */
    protected abstract void paintComponent(Graphics g);
}
