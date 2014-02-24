/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings;

import java.awt.Graphics;
import java.awt.Point;
import java.util.EnumMap;

/**
 * <p>
 * This is a mock ConfiguredEdgeEnding class.
 * </p>
 *
 * @author ch_music
 * @version 1.0
 */
public class AccuracyTestMockConfiguredEdgeEnding extends ConfiguredEdgeEnding {

    /**
     * <p>
     * Creates a new instance.
     * </p>
     *
     * @param propertyNameMapping a predefined Map with information about property names configuration
     * @throws IllegalArgumentException if propertyNameMapping is null/empty
     */
    public AccuracyTestMockConfiguredEdgeEnding(
            EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping) {
        super(propertyNameMapping);
    }

    /**
     * <p>
     * Creates a new instance.
     * </p>
     *
     * @param angle the angle
     * @param endingPoint coordinates of the end point
     * @param propertyNameMapping a predefined Map with information about property names configuration
     * @throws IllegalArgumentException if endingPoint argument is null, or if propertyNameMapping is null/empty
     */
    public AccuracyTestMockConfiguredEdgeEnding(double angle, Point endingPoint,
            EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping) {
        super(angle, endingPoint, propertyNameMapping);
    }

    /**
     * <p>
     * Paints component. Does nothing.
     * </p>
     *
     * @param g the graphics to paint on
     */
    protected void paintComponent(Graphics g) {
        // empty
    }
}
