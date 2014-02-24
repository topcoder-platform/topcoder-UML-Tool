/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings;

import java.awt.Graphics;
import java.awt.Point;
import java.util.EnumMap;

/**
 * <p>
 * This is a mock extends of ConfiguredEdgeEnding class.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class MockConfiguredEdgeEnding extends ConfiguredEdgeEnding {
    /**
     * <p>
     * The default constructor with the given propertyNameMapping configed.
     * </p>
     *
     * @param propertyNameMapping The predefined Map with information about property names
     * configuration. The properties are from DiagramElement parent class.
     *
     * @throws IllegalArgumentException if propertyNameMapping is null/empty
     */
    public MockConfiguredEdgeEnding(EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping) {
        super(propertyNameMapping);
    }

    /**
     * <p>
     * Construct the class and set related class variables by using the arguments.
     * The instance variables should be set from their "DEFAULT" counterparts.
     * The constructor is specially protected to prevent instantiation.
     * </p>
     *
     * @param angle The rotating angle.
     * @param endingPoint Coordinates of the end point.
     * @param propertyNameMapping The predefined Map with information about property
     * names configuration.
     * The properties are from DiagramElement parent class.
     *
     * @throws IllegalArgumentException if endingPoint argument is null,
     * or if propertyNameMapping is null/empty
     */
    public MockConfiguredEdgeEnding(double angle, Point endingPoint,
        EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping) {
        super(angle, endingPoint, propertyNameMapping);
    }

    /**
     * <p>
     * This method does nothing.
     * </p>
     *
     * @param g the graphics to paint on
     */
    protected void paintComponent(Graphics g) {
        // empty
    }

}
