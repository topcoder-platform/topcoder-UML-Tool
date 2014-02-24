/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings;

import java.awt.Color;
import java.awt.Point;
import java.util.EnumMap;

import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.RenderScheme;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.Util;

/**
 * <p>
 * This abstract class extends the parent EdgeEnding class by configuration options.
 * To configure the defaults - use ConfigManager configuration file. This file is
 * processed by the static initialization block of the class.
 * <p>
 *
 * <p>
 * This class needs configuration and here is a sample:
 * &lt;Property name=&quot;EdgeEndingStrokeColor&quot;&gt;
 *     &lt;Value&gt;Color.BLACK&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeEndingFillColor&quot;&gt;
 *     &lt;Value&gt;Color.BLACK&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeEndingRenderScheme&quot;&gt;
 *     &lt;Value&gt;1&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeEndingArrowXLength&quot;&gt;
 *     &lt;Value&gt;15&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeEndingArrowYLength&quot;&gt;
 *     &lt;Value&gt;15&lt;/Value&gt;
 * &lt;/Property&gt;
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
public abstract class ConfiguredEdgeEnding extends EdgeEnding {
    /**
     * <p>
     * Represents the namespace in the configuration file to use for loading default variables.
     * </p>
     */
    private static final String CONFIG_NAMESPACE = "com.topcoder.gui.diagramviewer.uml."
        + "sequenceelements.edgeendings.configurededgeending";

    /**
     * <p>
     * Represents the default main color for foreground elements.
     * </p>
     *
     * <p>
     * Note, this variable is not mutable and can be any value.
     * </p>
     *
     */
    private static final Color DEFAULT_STROKE_COLOR = Color.BLACK;

    /**
     * <p>
     * Represents the default main fill color.
     * </p>
     *
     * <p>
     * Note, this variable is not mutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_FILL_COLOR = Color.WHITE;

    /**
     * <p>
     * Represents the default length of the arrow on the X axis.
     * </p>
     *
     * <p>
     * Note, this variable is not mutable and can be any positive (not 0) value.
     * </p>
     */
    private static final int DEFAULT_ARROW_X_LENGTH = 15;

    /**
     * <p>
     * Represents the default length of the arrow on the Y axis.
     * </p>
     *
     * <p>
     * Note, this variable is not mutable and can be any positive (not 0) value.
     * </p>
     */
    private static final int DEFAULT_ARROW_Y_LENGTH = 10;

    /**
     * <p>
     * Represents the default rendering scheme.
     * </p>
     *
     * <p>
     * Note, this variable is not mutable and can be any value.
     * </p>
     */
    private static final RenderScheme DEFAULT_RENDER_SCHEME = RenderScheme.TopCoderScheme;

    /**
     * <p>
     * Represents the length of the arrow on the X axis.
     * </p>
     *
     * <p>
     * Note, this variable is mutable and can be any positive (not 0) value.
     * </p>
     */
    private int arrowXLength;

    /**
     * <p>
     * Represents the length of the arrow on the Y axis.
     * </p>
     *
     * <p>
     * Note, this variable is mutable and can be any positive (not 0) value.
     * </p>
     */
    private int arrowYLength;

    /**
     * <p>
     * Represents the rendering scheme.
     * </p>
     *
     * <p>
     * Note, this variable is mutable and can be any value.
     * </p>
     */
    private RenderScheme renderScheme;

    /**
     * <p>
     * Represents the main color for the foreground elements.
     * </p>
     *
     * <p>
     * This variable is mutable and can not be null.
     * </p>
     */
    private Color strokeColor;

    /**
     * <p>
     * Represents the main fill color.
     * </p>
     *
     * <p>
     * Note, this variable is mutable and can not be null.
     * </p>
     */
    private Color fillColor;

    /**
     * <p>
     * Represents the Map of property names, used for getting values from the
     * DiagramElement parent object.
     * </p>
     *
     * <p>
     * Use related setter function to mutate the elements of the Map.
     * The related getter function returns the value for the specified key from the Map.
     * </p>
     */
    private EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping;

    /**
     * <p>
     * The default constructor with the given propertyNameMapping configed.
     * </p>
     *
     * <p>
     * The instance variables will firstly load from the properties in the config manager,
     * if not found, then the default value will be used.
     * </p>
     *
     * @param propertyNameMapping The predefined Map with information about property names
     * configuration. The properties are from DiagramElement parent class.
     *
     * @throws IllegalArgumentException if propertyNameMapping is null/empty
     */
    protected ConfiguredEdgeEnding(EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping) {
        Util.checkNull(propertyNameMapping, "propertyNameMapping");
        if (propertyNameMapping.isEmpty()) {
            throw new IllegalArgumentException("The propertyNameMapping is empty.");
        }

        this.propertyNameMapping = propertyNameMapping;

        initialize();
    }

    /**
     * <p>
     * Construct the class and set related class variables by using the arguments.
     * </p>
     *
     * <p>
     * The instance variables will firstly load from the properties in the config manager,
     * if not found, then the default value will be used.
     * </p>
     *
     * @param angle The rotating angle.
     * @param endingPoint Coordinates of the end point.
     * @param propertyNameMapping The predefined <code>Map</code> with information about property
     * names configuration. The properties are from <code>DiagramElement</code> class.
     *
     * @throws IllegalArgumentException if endingPoint argument is null,
     * or if propertyNameMapping is null/empty
     */
    protected ConfiguredEdgeEnding(double angle, Point endingPoint,
        EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping) {
        super(angle, endingPoint);
        Util.checkNull(propertyNameMapping, "propertyNameMapping");
        if (propertyNameMapping.isEmpty()) {
            throw new IllegalArgumentException("The propertyNameMapping is empty.");
        }

        this.propertyNameMapping = propertyNameMapping;

        initialize();
    }

    /**
     * <p>
     * This method is responsible for initializing the instance variables.
     * </p>
     *
     * <p>
     * The instance variables will firstly load from the properties in the config manager, if not found,
     * then the default value will be used.
     * </p>
     */
    private void initialize() {
        this.strokeColor = Util.readColorProperty(null,
            propertyNameMapping.get(ConfiguredEdgeEndingPropertyType.STROKE_COLOR), CONFIG_NAMESPACE,
            "EdgeEndingStrokeColor", DEFAULT_STROKE_COLOR);

        this.fillColor = Util.readColorProperty(null,
            propertyNameMapping.get(ConfiguredEdgeEndingPropertyType.FILL_COLOR), CONFIG_NAMESPACE,
            "EdgeEndingFillColor", DEFAULT_FILL_COLOR);

        int defaultSchemeValue = (DEFAULT_RENDER_SCHEME == RenderScheme.SimpleScheme) ? 0 : 1;
        this.renderScheme = Util.parseReaderSchemeProperty(null,
            propertyNameMapping.get(ConfiguredEdgeEndingPropertyType.RENDER_SCHEME), CONFIG_NAMESPACE,
            "EdgeEndingRenderScheme", defaultSchemeValue);

        this.arrowXLength = Util.readIntegerProperty(null,
            propertyNameMapping.get(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH), CONFIG_NAMESPACE,
            "EdgeEndingArrowXLength", DEFAULT_ARROW_X_LENGTH);
        if (this.arrowXLength <= 0) {
            this.arrowXLength = DEFAULT_ARROW_X_LENGTH;
        }

        this.arrowYLength = Util.readIntegerProperty(null,
            propertyNameMapping.get(ConfiguredEdgeEndingPropertyType.ARROW_Y_LENGTH), CONFIG_NAMESPACE,
            "EdgeEndingArrowYLength", DEFAULT_ARROW_Y_LENGTH);
        if (this.arrowYLength <= 0) {
            this.arrowYLength = DEFAULT_ARROW_Y_LENGTH;
        }
    }

    /**
     * <p>
     * Sets the arrow length on the X axis.
     * </p>
     *
     * @param arrowXLength The length of the arrow on the X axis.
     *
     * @throws IllegalArgumentException if argument is negative or 0.
     */
    public void setArrowXLength(int arrowXLength) {
        if (arrowXLength <= 0) {
            throw new IllegalArgumentException("The given arrow length in X axis [" + arrowXLength
                + "] is not positive.");
        }

        this.arrowXLength = arrowXLength;
    }

    /**
     * <p>
     * Gets the arrow length on the X axis.
     * </p>
     *
     * @return The length of the arrow on the X axis.
     */
    public int getArrowXLength() {
        return this.arrowXLength;
    }

    /**
     * <p>
     * Sets the arrow length on the Y axis.
     * </p>
     *
     * @param arrowYLength The length of the arrow on the Y axis.
     *
     * @throws IllegalArgumentException if argument is negative or 0.
     */
    public void setArrowYLength(int arrowYLength) {
        if (arrowYLength <= 0) {
            throw new IllegalArgumentException("The given arrow length in Y axis [" + arrowYLength
                + "] is not positive.");
        }

        this.arrowYLength = arrowYLength;
    }

    /**
     * <p>
     * Gets the arrow length on the Y axis.
     * </p>
     *
     * @return The length of the arrow on the Y axis.
     */
    public int getArrowYLength() {
        return this.arrowYLength;
    }

    /**
     * <p>
     * Sets the render scheme of the edge ending.
     * </p>
     *
     * @param renderScheme The value from RenderScheme enum.
     *
     * @throws IllegalArgumentException if renderScheme is null
     */
    public void setRenderScheme(RenderScheme renderScheme) {
        Util.checkNull(renderScheme, "renderScheme");

        this.renderScheme = renderScheme;
    }

    /**
     * <p>
     * Gets the render scheme of the edge ending.
     * </p>
     *
     * @return The value from RenderScheme enum.
     */
    public RenderScheme getRenderScheme() {
        return this.renderScheme;
    }

    /**
     * <p>
     * Sets the stroke color of the edge ending.
     * </p>
     *
     * @param strokeColor The stroke color.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setStrokeColor(Color strokeColor) {
        Util.checkNull(strokeColor, "strokeColor");

        this.strokeColor = strokeColor;
    }

    /**
     * <p>
     * Gets the stroke color of the edge ending.
     * </p>
     *
     * @return The stroke color.
     */
    public Color getStrokeColor() {
        return this.strokeColor;
    }

    /**
     * <p>
     * Sets the fill color of the edge ending.
     * </p>
     *
     * @param fillColor The color to fill.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setFillColor(Color fillColor) {
        Util.checkNull(fillColor, "fillColor");

        this.fillColor = fillColor;
    }

    /**
     * <p>
     * Gets the fill color of the edge ending.
     * </p>
     *
     * @return The color to fill.
     */
    public Color getFillColor() {
        return this.fillColor;
    }

    /**
     * <p>
     * Sets the given key and value to the <code>propertyNameMapping</code> Map.
     * </p>
     *
     * @param key They key in the propertyNameMapping Map.
     * @param value They value in the propertyNameMapping Map for the specified key.
     *
     * @throws IllegalArgumentException if key is null or value argument is null/empty.
     */
    public void setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType key, String value) {
        Util.checkNull(key, "key");
        Util.checkString(value, "value");

        this.propertyNameMapping.put(key, value);
    }

    /**
     * <p>
     * Gets the property value in the <code>propertyNameMapping</code> Map according to the given
     * key.
     * </p>
     *
     * @param key They key in the propertyNameMapping Map.
     * @return They value in the propertyNameMapping Map for the specified key.
     *
     * @throws IllegalArgumentException if key is null
     */
    public String getPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType key) {
        Util.checkNull(key, "key");

        return this.propertyNameMapping.get(key);
    }
}
