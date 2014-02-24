/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.Util;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import java.util.EnumMap;


/**
 * <p>The concrete edge ending with no arrow used on sequence diagrams. The painting of the edge ending is
 * implemented.</p>
 *  <p>Thread Safety : The class is mutable and so is not thread safe.</p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.1
 *
 * @since 1.0
 */
public class NothingEdgeEnding extends ConfiguredEdgeEnding {
/**
     * <p>
     * The default constructor with the given propertyNameMapping configed.
     * </p>
     *
     * @param propertyNameMapping The predefined <code>Map</code> with information about property
     * names configuration. The properties are from <code>DiagramElement</code> class.
     */
    public NothingEdgeEnding(EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping) {
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
    public NothingEdgeEnding(double angle, Point endingPoint,
        EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping) {
        super(angle, endingPoint, propertyNameMapping);
    }

    /**
     * <p>The drawing function for the edge ending. It paints the edge ending differently for different
     * RenderScheme.</p>
     *
     * @param g The reference to the Graphics instance, which is used for node ending drawing.
     */
    protected void paintComponent(Graphics g) {
        Util.checkNull(g, "g");

        // no painting here
    }

    /**
     * <p>This method returns false always because it is not interested at any swing events.</p>
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
     * <p>Returns the bounding rectangle of the edge ending.</p>
     *
     * @return The bounds of the edge ending and its selection.
     */
    public Rectangle getBounds() {
        return super.getBounds();
    }
}
