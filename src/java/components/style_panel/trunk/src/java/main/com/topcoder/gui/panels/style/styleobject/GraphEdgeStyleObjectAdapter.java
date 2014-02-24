/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.styleobject;

import java.awt.Color;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.panels.style.StyleNotSupportedException;
import com.topcoder.gui.panels.style.Util;

/**
 * <p>
 * This class extends AbstractStyleObject and is the StyleObject adapter for GraphEdge.
 * </p>
 *
 * <p>
 * GraphEdge (of diagram interchange) is supported by StylePanel using this adapter.
 * </p>
 *
 * <p>
 * GraphEdge supports position, font related, and outline color styles.
 * </p>
 *
 * <p>
 * The instance of this class' scope is handled by the programmer of the application that uses
 * this component.
 * </p>
 *
 * <p>
 * Thread safety: This class is NOT thread safe, since there is mutable field. In this component,
 * it's not a big deal since it will only work in event dispatcher thread.
 * </p>
 *
 * @author enefem21, TCSDEVELOPER
 * @version 1.0
 */
public class GraphEdgeStyleObjectAdapter extends AbstractStyleObject {
    /**
     * <p>
     * Represents the adaptee in the adapter.
     * </p>
     *
     * <p>
     * This adapter doesn't support fill color and size style.
     * </p>
     *
     * <p>
     * Is immutable and can not be null.
     * </p>
     */
    private final GraphEdge graphEdge;

    /**
     * <p>
     * Constructor of the adapter.
     * </p>
     *
     * @param graphEdge graphEdge acts as the adaptee
     *
     * @throws IllegalArgumentException if graphEdge is null
     */
    public GraphEdgeStyleObjectAdapter(GraphEdge graphEdge) {
        Util.checkNull(graphEdge, "graphEdge");

        this.graphEdge = graphEdge;
    }

    /**
     * <p>
     * The height style is not supported.
     * </p>
     *
     * @return the height style value, no return value unless it is overridden
     *
     * @throws StyleNotSupportedException all the time unless it is overridden
     */
    public double getHeight() {
        throw new StyleNotSupportedException(
            "getHeight() method for GraphEdgeStyleObjectAdapter class is not supported.");
    }

    /**
     * <p>
     * The width style is not supported.
     * </p>
     *
     * @return the width style value, no return value unless it is overridden
     *
     * @throws StyleNotSupportedException all the time unless it is overridden
     */
    public double getWidth() {
        throw new StyleNotSupportedException(
            "getWidth() method for GraphEdgeStyleObjectAdapter class is not supported.");
    }

    /**
     * <p>
     * Returns x-position style value of the graphEdge.
     * </p>
     *
     * <p>
     * The default value is zero, it will be returned when the x-position property is missing
     * or invalid.
     * </p>
     *
     * @return x-position of the graphEdge
     *
     * @throws IllegalStateException if the style panel for the style object is not set
     */
    public double getX() {
        return Util.getDoubleProperty(graphEdge, Util.getStylePanel(this).getXKey());
    }

    /**
     * <p>
     * Returns y-position of the graphEdge.
     * </p>
     *
     * <p>
     * The default value is zero, it will be returned when the y-position property is missing
     * or invalid.
     * </p>
     *
     * @return y-position of the graphEdge
     *
     * @throws IllegalStateException if the style panel is not set yet
     */
    public double getY() {
        return Util.getDoubleProperty(graphEdge, Util.getStylePanel(this).getYKey());
    }

    /**
     * <p>
     * Returns font name of the graphEdge.
     * </p>
     *
     * <p>
     * The default font name is &quot;Default&quot;, it will be returned when the font name property
     * is missing or invalid.
     * </p>
     *
     * @return font name of the graphEdge
     *
     * @throws IllegalStateException if the style panel is not set yet
     */
    public String getFontName() {
        return Util.getFontNameProperty(graphEdge, Util.getStylePanel(this).getFontNameKey());
    }

    /**
     * <p>
     * Returns fontSize of the graphEdge.
     * </p>
     *
     * <p>
     * The default font size is ten, it will be returned when the font size property
     * is missing or invalid.
     * </p>
     *
     * @return fontSize of the graphEdge
     *
     * @throws IllegalStateException if the style panel is not set yet
     */
    public int getFontSize() {
        return Util.getFontSizeProperty(graphEdge, Util.getStylePanel(this).getFontSizeKey());
    }

    /**
     * <p>
     * The fill color style is not supported.
     * </p>
     *
     * @return the fill color style value, no return value unless it is overridden
     *
     * @throws StyleNotSupportedException all the time unless it is overridden
     */
    public String getFillColor() {
        throw new StyleNotSupportedException(
            "getFillColor() method for GraphEdgeStyleObjectAdapter class is not supported.");
    }

    /**
     * <p>
     * Returns outlineColor of the graphEdge.
     * </p>
     *
     * <p>
     * The default outline color is BLACK, it will be returned when the outline color property
     * is missing or invalid.
     * </p>
     *
     * @return outlineColor of the graphEdge
     *
     * @throws IllegalStateException if the style panel is not set yet
     */
    public String getOutlineColor() {
        return Util.getColorProperty(graphEdge, Util.getStylePanel(this).getOutlineColorKey(),
            Util.convertColor(Color.BLACK));
    }

    /**
     * <p>
     * Returns textColor of the graphEdge.
     * </p>
     *
     * <p>
     * The default text color is BLACK, it will be returned when the text color property
     * is missing or invalid.
     * </p>
     *
     * @return textColor of the graphEdge
     *
     * @throws IllegalStateException if the style panel is not set yet
     */
    public String getTextColor() {
        return Util.getColorProperty(graphEdge, Util.getStylePanel(this).getTextColorKey(),
            Util.convertColor(Color.BLACK));
    }

    /**
     * <p>
     * Returns the graphEdge.
     * </p>
     * @return the graphEdge
     */
    public GraphEdge getGraphEdge() {
        return graphEdge;
    }
}
