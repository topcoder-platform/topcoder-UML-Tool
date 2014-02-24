/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.EnumMap;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.Util;

/**
 * <p>
 * The concrete edge ending with empty arrow used on sequence diagrams.
 * The painting of the edge ending is implemented.
 * </p>
 *
 * <p>
 * Thread Safety : The class is mutable and so is not thread safe.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class EmptyArrowEdgeEnding extends ConfiguredEdgeEnding {
    /**
     * <p>
     * The default constructor with the given propertyNameMapping configed.
     * </p>
     *
     * @param propertyNameMapping The predefined <code>Map</code> with information about property
     * names configuration. The properties are from <code>DiagramElement</code> class.
     */
    public EmptyArrowEdgeEnding(EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping) {
        super(propertyNameMapping);
    }

    /**
     * <p>
     * Constructs the class and set related class variables by using the arguments.
     * </p>
     *
     * @param angle The rotating angle.
     * @param endingPoint Coordinates of the end point.
     * @param propertyNameMapping The predefined <code>Map</code> with information about property
     * names configuration. The properties are from <code>DiagramElement</code> class.
     *
     * @throws IllegalArgumentException if endingPoint argument is null
     */
    public EmptyArrowEdgeEnding(double angle, Point endingPoint,
        EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping) {
        super(angle, endingPoint, propertyNameMapping);
    }

    /**
     * <p>
     * The drawing function for the edge ending. It paints the edge ending
     * differently for different RenderScheme. Refer to the component specification
     * for the details.
     * </p>
     *
     * @param g The reference to the Graphics instance, which is used for node ending drawing.
     *
     * @throws IllegalArgumentException if argument is null
     */
    protected void paintComponent(Graphics g) {
        Util.checkNull(g, "g");

        Graphics2D g2d = (Graphics2D) g;

        Point endingPoint = getEndingPoint();

        double x1 = endingPoint.getX();
        double y1 = endingPoint.getY();

        AffineTransform tx = AffineTransform.getRotateInstance(getAngle(), x1, y1);

        Polygon poly1 = new Polygon();
        poly1.addPoint((int) x1 - getArrowXLength(), (int) y1 - getArrowYLength());
        poly1.addPoint((int) x1, (int) y1);

        Polygon poly2 = new Polygon();
        poly2.addPoint((int) x1, (int) y1);
        poly2.addPoint((int) x1 - getArrowXLength(), (int) y1 + getArrowYLength());

        Shape shape1 = tx.createTransformedShape((Shape) poly1);
        Shape shape2 = tx.createTransformedShape((Shape) poly2);

        // back up the color
        Color oldColor = g2d.getColor();

        g2d.setColor(getStrokeColor());
        g2d.draw(shape1);
        g2d.draw(shape2);

        // restore the color
        g2d.setColor(oldColor);
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

    /**
     * <p>
     * Returns the bounding rectangle of the edge ending.
     * </p>
     *
     * @return The bounds of the edge ending and its selection.
     */
    public Rectangle getBounds() {
        return super.getBounds();
    }
}
