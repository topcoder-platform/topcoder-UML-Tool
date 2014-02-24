/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import java.awt.Graphics;
import java.awt.Point;
import java.util.EnumMap;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEnding;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;

/**
 * <p>
 * Mock implementation of <code>{@link ConfiguredEdgeEnding}</code> abstract class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class MockConfiguredEdgeEnding extends ConfiguredEdgeEnding {

    /**
     * <p>
     * Constructs an <code>{@link MockConfiguredEdgeEnding}</code> instance.
     * </p>
     * @param angle
     *            angle
     * @param endingPoint
     *            the ending point
     * @param propertyNameMapping
     *            the property name mapping.
     */
    public MockConfiguredEdgeEnding(double angle, Point endingPoint,
        EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping) {
        super(angle, endingPoint, propertyNameMapping);
    }

    /**
     * <p>
     * Constructs an <code>{@link MockConfiguredEdgeEnding}</code> instance.
     * </p>
     * @param propertyNameMapping
     *            the property name mapping
     */
    public MockConfiguredEdgeEnding(EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping) {
        super(propertyNameMapping);
    }

    /**
     * <p>
     * paint the component.
     * </p>
     */
    @Override
    protected void paintComponent(Graphics arg0) {
    }

}