/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Container;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import static java.lang.Math.pow;

/**
 * <p>
 * This class represents a selection corner in diagram.
 * </p>
 *
 * <p>
 * It is a concrete SWING JComponent. A selection corner is a circle which can be embedded
 * on element's bound or edge's waypoints.
 * </p>
 *
 * <p>
 * The radius of circle, center of circle, stroke color and fill color are all configurable,
 * the corresponding setters are provided in this class.
 * </p>
 *
 * <p>
 * Thread Safety : This class is mutable and not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class SelectionCorner extends JComponent {
    /**
     * <p>
     * Represent the default radius value.
     * </p>
     *
     * <p>
     * It will be used as a default value to initialize the radius value of the selection corner.
     * </p>
     */
    public static final int DEFAULT_RADIUS = 5;

    /**
     * <p>
     * Represent the default stroke color value.
     * </p>
     *
     * <p>
     * It will be used as a default value to initialize the stroke color of the selection corner.
     * </p>
     */
    /*
     * Bugfix: UML-9711
     * Changed to black
     */
    public static final Color DEFAULT_STROKE_COLOR = Color.BLACK;

    /**
     * <p>
     * Represent the default fill color value.
     * </p>
     *
     * <p>
     * It will be used as a default value to initialize the fill color of the selection corner.
     * </p>
     *
     */
    public static final Color DEFAULT_FILL_COLOR = Color.YELLOW;

    /**
     * <p>
     * Represent the center of the selection corner.
     * </p>
     *
     * <p>
     * It will never be null and can be accessed by setter/getter.
     * </p>
     */
    private Point center;

    /**
     * <p>
     * Represent the circle radius of the selection corner.
     * </p>
     *
     * <p>
     * It will always be positive and can be accessed by setter/getter.
     * </p>
     */
    private int radius;

    /**
     * <p>
     * Represent the stroke color of the circle.
     * </p>
     *
     * <p>
     * It will never be null and can be accessed by setter/getter.
     * </p>
     */
    private Color strokeColor;

    /**
     * <p>
     * Represent the fill color of the circle.
     * </p>
     *
     * <p>
     * It will never be null and can be accessed by setter/getter.
     * </p>
     */
    private Color fillColor;

    /**
     * <p>
     * Construct a SelectionCorner instance with center given.
     * </p>
     *
     * <p>
     * The radius, stroke color and fill color will use the default values.
     * </p>
     *
     * <p>
     * Note, The given center is cloned.
     * </p>
     *
     * @param center the circle center
     *
     * @throws IllegalArgumentException if center is null
     */
    public SelectionCorner(Point center) {
        this(center, DEFAULT_RADIUS, DEFAULT_STROKE_COLOR, DEFAULT_FILL_COLOR);
    }

    /*
     * BugFix: BUGID UML-7176
     * Description:
     * In the constructor, location and size should have been set.
     * Solution:
     * Use the new setCenter and setRadius methods, so that location and size will be set automatically.
     */
    /**
     * <p>
     * Construct a SelectionCorner with center, radius, stroke color and fill color given.
     * </p>
     *
     * <p>
     * Note, The given center is cloned.
     * </p>
     *
     * @param center the circle center
     * @param radius the circle radius
     * @param strokeColor the stroke color
     * @param fillColor the fill color
     *
     * @throws IllegalArgumentException if center, strokeColor or fillColor is null or radius is not positive.
     */
    public SelectionCorner(Point center, int radius, Color strokeColor, Color fillColor) {
        Util.checkNull(center, "center");
        Util.checkNotPositive(radius, "radius");
        Util.checkNull(strokeColor, "strokeColor");
        Util.checkNull(fillColor, "fillColor");

        // old coder
//        this.center = new Point(center);
//        this.radius = radius;
        setCenter(center);
        setRadius(radius);
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
    }

    /**
     * <p>
     * Get the circle radius of the selection corner.
     * </p>
     *
     * @return the circle radius of the selection corner.
     */
    public int getRadius() {
        return radius;
    }

    /*
     * BugFix: BUGID UML-7176
     * Description:
     * When a radius is set, this component's size and location should also be reset.
     * Solution:
     * Code is added to set the size and location.
     */
    /**
     * <p>
     * Set the circle radius of the selection corner.
     * </p>
     *
     * @param radius the new radius value to set
     *
     * @throws IllegalArgumentException if radius is not positive
     */
    public void setRadius(int radius) {
        Util.checkNotPositive(radius, "radius");

        this.radius = radius;
        setSize(radius * 2, radius * 2);
        setLocation(center.x - radius, center.y - radius);
    }

    /**
     * <p>
     * Get the circle center of the selection corner.
     * </p>
     *
     * <p>
     * Note, the center point is cloned.
     * </p>
     *
     * @return the circle center of the selection corner.
     */
    public Point getCenter() {
        return new Point(center);
    }

    /*
     * BugFix: BUGID UML-7176
     * Description:
     * When a center is set, this component's location should be reset.
     * Solution:
     * Code is added to set the location.
     */
    /**
     * <p>
     * Set the circle center of the selection corner.
     * </p>
     *
     * <p>
     * Note, the given center will be cloned.
     * </p>
     *
     * @param center the new circle center value to set
     *
     * @throws IllegalArgumentException if center is null
     */
    public void setCenter(Point center) {
        Util.checkNull(center, "center");

        this.center = new Point(center);
        setLocation(center.x - radius, center.y - radius);
    }

    /**
     * <p>
     * Get the stroke color of the circle.
     * </p>
     *
     * @return the stroke color of the circle.
     */
    public Color getStrokeColor() {
        return strokeColor;
    }

    /**
     * <p>
     * Set the stroke color of the circle.
     * </p>
     *
     * @param strokeColor the new stroke color to set
     *
     * @throws IllegalArgumentException if strokeColor is null
     */
    public void setStrokeColor(Color strokeColor) {
        Util.checkNull(strokeColor, "strokeColor");

        this.strokeColor = strokeColor;
    }

    /**
     * <p>
     * Get the fill color of the circle.
     * </p>
     *
     * @return the fill color of the circle.
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * <p>
     * Set the fill color of the circle.
     * </p>
     *
     * @param fillColor the new fill color to set
     *
     * @throws IllegalArgumentException if fillColor is null
     */
    public void setFillColor(Color fillColor) {
        Util.checkNull(fillColor, "fillColor");

        this.fillColor = fillColor;
    }

    /**
     * <p>
     * Determine whether the given point is in the selection corner or not.
     * </p>
     *
     * <p>
     * Note, this method is invoked by the Swing framework, the given point is relative in this component.
     * But in this component, the center position is absolute position at the parent component, so the
     * conversion is done when the parent component is not null.
     * </p>
     *
     * @param x the x coordinate of point
     * @param y the y coordinate of point
     *
     * @return true when the given point is located inside or on the circle, otherwise false.
     */
    public boolean contains(int x, int y) {
        // convert the position to the corresponding position at the parent component
        Container parent = getParent();
        if (parent != null) {
            Point pt = SwingUtilities.convertPoint(this, x, y, parent);
            x = pt.x;
            y = pt.y;
        }

        // the center position is absolute position at the parent component
        return pow(x - center.x, 2) + pow(y - center.y, 2) <= pow(radius, 2);
    }

    /*
     * BugFix: BUGID UML-7176
     * Description:
     * Since corners are always added as child components, they should paint themselves in their own coordinate system.
     * Solution:
     * Code is modified to paint the component in its own coordinate system.
     */
    /**
     * <p>
     * This method paints the selection corner according to the current radius, center position,
     * stroke color and fill color.
     * </p>
     *
     * <p>
     * This method is the contract of JComponent for custom drawing.
     * </p>
     *
     * <p>
     * Note, this method will take effect only when the given graphics is not null.
     * </p>
     *
     * @param g the graphics to paint on
     */
    protected void paintComponent(Graphics g) {
		        if (g != null) {
					Graphics2D g2d=(Graphics2D)g;
		            Color originColor = g2d.getColor();
					Color lightBlue=new Color(254,254,254);
					Color darkBlue=new Color(126,170,218);
					Color border=new Color(86,111,185);
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
		/*            int length = 2 * radius;
		            // fill the oval with fillColor
		            g.setColor(fillColor);
		            g.fillOval(0, 0, length, length);
		            // draw the oval with strokeColor
		            g.setColor(strokeColor);
		*/

				    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
					int length=2*radius;
					GradientPaint gradient=new GradientPaint(0,radius, darkBlue, 0,0, lightBlue, true);
					g2d.setPaint(gradient);
					g2d.fillOval(0,0,length-1,length-1);
					g2d.setColor(border);
		            g2d.drawOval(0, 0, length-1, length-1);

		            // set the origin color back
		            g2d.setColor(originColor);
		        }
    }
}
