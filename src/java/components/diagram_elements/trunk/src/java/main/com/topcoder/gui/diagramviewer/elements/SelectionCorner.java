/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;

/**
 * <p>
 * This class represents a selection corner in diagram. A selection corner is a circle which can be embedded on
 * element's bound or edge's way-points. It is a concrete SWING <code>JComponent</code>.
 * </p>
 * <p>
 * The radius of circle, center of circle, stroke color and fill color are all configurable via API.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class SelectionCorner extends JComponent {

    /**
     * <p>
     * Represents the default radius value.
     * </p>
     * <p>
     * It will be used as a default value to initialize the <code>radius</code> field in constructor.
     * </p>
     */
    public static final int DEFAULT_RADIUS = 5;

    /**
     * <p>
     * Represents the default stroke color value.
     * </p>
     * <p>
     * It will be used as a default value to initialize the <code>strokeColor</code> field in constructor.
     * </p>
     */
    /*
     * Bugfix: UML-9710
     * Changed to black
     */
    public static final Color DEFAULT_STROKECOLOR = Color.BLACK;

    /**
     * <p>
     * Represents the default fill color value.
     * </p>
     * <p>
     * It will be used as a default value to initialize the <code>fillColor</code> field in constructor.
     * </p>
     */
    public static final Color DEFAULT_FILLCOLOR = Color.YELLOW;

    /**
     * <p>
     * Represents the type of the selection corner.
     * </p>
     * <p>
     * It is initialized in constructor, can be accessed by setter and getter. It can never be null.
     * </p>
     */
    private SelectionCornerType type;

    /**
     * <p>
     * Represents the circle center of the selection corner.
     * </p>
     * <p>
     * It is initialized in constructor, can be accessed by setter and getter. It can never be null.
     * </p>
     */
    private Point center;

    /**
     * <p>
     * Represents the circle radius of the selection corner.
     * </p>
     * <p>
     * It is initialized in constructor, can be accessed by setter and getter. It must be positive.
     * </p>
     */
    private int radius;

    /**
     * <p>
     * Represents the stroke color of the circle.
     * </p>
     * <p>
     * It is initialized in constructor, can be accessed by setter and getter. It can never be null.
     * </p>
     */
    private Color strokeColor;

    /**
     * <p>
     * Represents the fill color of the circle.
     * </p>
     * <p>
     * It is initialized in constructor, can be accessed by setter and getter. It can never be null.
     * </p>
     */
    private Color fillColor;

    /**
     * <p>
     * Constructs a <code>SelectionCorner</code> instance with given type and center.
     * </p>
     * <p>
     * Since <code>Point</code> class is mutable, <code>center</code> is cloned in this constructor.
     * </p>
     *
     * @param type
     *            the type of selection corner
     * @param center
     *            the circle center
     * @throws IllegalArgumentException
     *             if <code>type</code> or <code>center</code> is null
     */
    public SelectionCorner(SelectionCornerType type, Point center) {
        this(type, center, DEFAULT_RADIUS, DEFAULT_STROKECOLOR, DEFAULT_FILLCOLOR);
    }

    /**
     * <p>
     * Constructs a <code>SelectionCorner</code> instance with given arguments.
     * </p>
     * <p>
     * Since <code>Point</code> class is mutable, <code>center</code> is cloned in this constructor.
     * </p>
     *
     * @param type
     *            the type of selection corner
     * @param center
     *            the circle center
     * @param radius
     *            the circle radius
     * @param strokeColor
     *            the stroke color
     * @param fillColor
     *            the fill color
     * @throws IllegalArgumentException
     *             if <code>type</code>, <code>center</code>, <code>strokeColor</code> or <code>fillColor</code>
     *             is null, or <code>radius</code> is not positive.
     */
    public SelectionCorner(SelectionCornerType type, Point center, int radius, Color strokeColor, Color fillColor) {
        setType(type);
        setCenter(center);
        setRadius(radius);
        setStrokeColor(strokeColor);
        setFillColor(fillColor);
    }

    /**
     * <p>
     * Gets the type of the selection corner.
     * </p>
     *
     * @return the type of the selection corner
     */
    public SelectionCornerType getType() {
        return type;
    }

    /**
     * <p>
     * Sets the type of the selection corner.
     * </p>
     *
     * @param type
     *            the new type of the selection corner
     * @throws IllegalArgumentException
     *             if <code>type</code> is null
     */
    public void setType(SelectionCornerType type) {
        if (type == null) {
            throw new IllegalArgumentException("type should not be null.");
        }
        this.type = type;
    }

    /**
     * <p>
     * Gets the circle radius of the selection corner.
     * </p>
     *
     * @return the circle radius of the selection corner
     */
    public int getRadius() {
        return radius;
    }

    /**
     * <p>
     * Sets the circle radius of the selection corner.
     * </p>
     *
     * @param radius
     *            the new circle radius of the selection corner
     * @throws IllegalArgumentException
     *             if <code>radius</code> is not positive
     */
    public void setRadius(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius should not be non-positive.");
        }
        this.radius = radius;
        // update the location of this JComponent
        setLocation(center.x - radius, center.y - radius);
        // update the size of this JComponent
        setSize(new Dimension(2 * radius, 2 * radius));
    }

    /**
     * <p>
     * Gets the circle center of the selection corner.
     * </p>
     * <p>
     * Since <code>Point</code> class is mutable, center is cloned in this method.
     * </p>
     *
     * @return the circle center of the selection corner
     */
    public Point getCenter() {
        return new Point(center);
    }

    /**
     * <p>
     * Sets the circle center of the selection corner.
     * </p>
     * <p>
     * Since <code>Point</code> class is mutable, center is cloned in this method.
     * </p>
     *
     * @param center
     *            the new circle center of the selection corner
     * @throws IllegalArgumentException
     *             if <code>center</code> is null
     */
    public void setCenter(Point center) {
        if (center == null) {
            throw new IllegalArgumentException("center should not be null.");
        }
        this.center = new Point(center);
        // update the location of this JComponent
        setLocation(center.x - radius, center.y - radius);
        // the size of this JComponent remains
    }

    /**
     * <p>
     * Gets the stroke color of the circle.
     * </p>
     *
     * @return the stroke color of the circle
     */
    public Color getStrokeColor() {
        return strokeColor;
    }

    /**
     * <p>
     * Sets the stroke color of the circle.
     * </p>
     *
     * @param strokeColor
     *            the new stroke color of the circle
     * @throws IllegalArgumentException
     *             if <code>strokeColor</code> is null
     */
    public void setStrokeColor(Color strokeColor) {
        if (strokeColor == null) {
            throw new IllegalArgumentException("strokeColor should not be null.");
        }
        this.strokeColor = strokeColor;
    }

    /**
     * <p>
     * Gets the fill color of the circle.
     * </p>
     *
     * @return the fill color of the circle
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * <p>
     * Sets the fill color of the circle.
     * </p>
     *
     * @param fillColor
     *            the new fill color of the circle
     * @throws IllegalArgumentException
     *             if <code>fillColor</code> is null
     */
    public void setFillColor(Color fillColor) {
        if (fillColor == null) {
            throw new IllegalArgumentException("fillColor should not be null.");
        }
        this.fillColor = fillColor;
    }

    /**
     * <p>
     * Determines whether the given point (x, y) is in the circle.
     * </p>
     *
     * @param x
     *            the x coordinate of point
     * @param y
     *            the y coordinate of point
     * @return true if the given point is in the circle, otherwise false
     */
    public boolean contains(int x, int y) {
        /*
         * BugFix: UML-9867
         * The circle center should be (radius, radius).
         */
        // old code
//        return Math.pow(x - center.x, 2) + Math.pow(y - center.y, 2) <= Math.pow(radius, 2);
        return (x - radius) *(x - radius) + (y - radius) * (y - radius) <= radius * radius;
    }

    /**
     * <p>
     * Paints this component.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     *
     * @param g
     *            the graphics to paint on
     */
    protected void paintComponent(Graphics g) {
        if (g != null) {
            Color originColor = g.getColor();
            /*
             * BugFix: UML-9866
             * This method should paint the selection
             * corner in its own relative coordinate system.
             */
            // old code
//            int x = center.x - radius;
//            int y = center.y - radius;
//            int length = 2 * radius;
//            // fill the oval with fillColor
//            g.setColor(fillColor);
//            g.fillOval(x, y, length, length);
//            // draw the oval with strokeColor
//            g.setColor(strokeColor);
//            g.drawOval(x, y, length, length);
            int length = 2 * radius;
            // fill the oval with fillColor
            g.setColor(fillColor);
            g.fillOval(0, 0, length, length);
            // draw the oval with strokeColor
            g.setColor(strokeColor);
            g.drawOval(0, 0, length - 1, length - 1);

            // set the origin color back
            g.setColor(originColor);
        }
    }
}
