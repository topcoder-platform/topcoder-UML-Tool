/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.styleobject;

import java.awt.Color;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.panels.style.Util;

/**
 * <p>
 * This class extends AbstractStyleObject and is the StyleObject adapter for GraphNode.
 * </p>
 *
 * <p>
 * GraphNode (of diagram interchange) is supported by StylePanel using this adapter.
 * </p>
 *
 * <p>
 * GraphNode supports all styles available in StylePanel.
 * </p>
 *
 * <p>
 * The instance of this class' scope is handled by the programmer of the application that
 * uses this component.
 * </p>
 *
 * <p>
 * Thread safety: This class is NOT thread safe, since there is mutable field.
 * In this component, it's not a big deal since it will only work in event dispatcher thread.
 * </p>
 *
 * @author enefem21, TCSDEVELOPER
 * @version 1.0
 */
public class GraphNodeStyleObjectAdapter extends AbstractStyleObject {
    /**
     * <p>
     * Represents the adaptee in the adapter.
     * </p>
     *
     * <p>
     * This adapter supports all styles.
     * </p>
     *
     * <p>
     * Is immutable and can not be null.
     * </p>
     */
    private final GraphNode graphNode;

    /**
     * <p>
     * Constructor of the adapter.
     * </p>
     *
     * @param graphNode graphNode acts as the adaptee
     *
     * @throws IllegalArgumentException if graphNode is null
     */
    public GraphNodeStyleObjectAdapter(GraphNode graphNode) {
        Util.checkNull(graphNode, "graphNode");
        this.graphNode = graphNode;
    }

    /**
     * <p>
     * Returns height style value of the graphNode.
     * </p>
     *
     * <p>
     * The default value is zero, it will be returned when the height property is missing
     * or invalid.
     * </p>
     *
     * @return height style of the graphNode
     *
     * @throws IllegalStateException if the style panel for the style object is not set
     */
    public double getHeight() {
        return Util.getDoubleProperty(graphNode, Util.getStylePanel(this).getHeightKey());
    }

    /**
     * <p>
     * Returns width style value of the graphNode.
     * </p>
     *
     * <p>
     * The default value is zero, it will be returned when the width property is missing
     * or invalid.
     * </p>
     *
     * @return width style of the graphNode
     *
     * @throws IllegalStateException if the style panel for the style object is not set
     */
    public double getWidth() {
        return Util.getDoubleProperty(graphNode, Util.getStylePanel(this).getWidthKey());
    }

    /**
     * <p>
     * Returns x-position style value of the graphNode.
     * </p>
     *
     * <p>
     * The default value is zero, it will be returned when the x-position property is missing
     * or invalid.
     * </p>
     *
     * @return x-position of the graphNode
     *
     * @throws IllegalStateException if the style panel for the style object is not set
     */
    public double getX() {
        return Util.getDoubleProperty(graphNode, Util.getStylePanel(this).getXKey());
    }

    /**
     * <p>
     * Returns y-position of the graphNode.
     * </p>
     *
     * <p>
     * The default value is zero, it will be returned when the y-position property is missing
     * or invalid.
     * </p>
     *
     * @return y-position of the graphNode
     *
     * @throws IllegalStateException if the style panel is not set yet
     */
    public double getY() {
        return Util.getDoubleProperty(graphNode, Util.getStylePanel(this).getYKey());
    }

    /**
     * <p>
     * Returns font name of the graphNode.
     * </p>
     *
     * <p>
     * The default font name is &quot;Default&quot;, it will be returned when the font name property
     * is missing or invalid.
     * </p>
     *
     * @return font name of the graphNode
     *
     * @throws IllegalStateException if the style panel is not set yet
     */
    public String getFontName() {
        return Util.getFontNameProperty(graphNode, Util.getStylePanel(this).getFontNameKey());
    }

    /**
     * <p>
     * Returns fontSize of the graphNode.
     * </p>
     *
     * <p>
     * The default font size is ten, it will be returned when the font size property
     * is missing or invalid.
     * </p>
     *
     * @return fontSize of the graphNode
     *
     * @throws IllegalStateException if the style panel is not set yet
     */
    public int getFontSize() {
        return Util.getFontSizeProperty(graphNode, Util.getStylePanel(this).getFontSizeKey());
    }

    /**
     * <p>
     * Returns fillColor of the graphNode.
     * </p>
     *
     * <p>
     * The default fill color is WHITE, it will be returned when the fill color property
     * is missing or invalid.
     * </p>
     *
     * @return fillColor of the graphNode
     *
     * @throws IllegalStateException if the style panel is not set yet
     */
    public String getFillColor() {
        return Util.getColorProperty(graphNode, Util.getStylePanel(this).getFillColorKey(),
            Util.convertColor(Color.WHITE));
    }

    /**
     * <p>
     * Returns outlineColor of the graphNode.
     * </p>
     *
     * <p>
     * The default outline color is BLACK, it will be returned when the outline color property
     * is missing or invalid.
     * </p>
     *
     * @return outlineColor of the graphNode
     *
     * @throws IllegalStateException if the style panel is not set yet
     */
    public String getOutlineColor() {
        return Util.getColorProperty(graphNode, Util.getStylePanel(this).getOutlineColorKey(),
            Util.convertColor(Color.BLACK));
    }

    /**
     * <p>
     * Returns textColor of the graphNode.
     * </p>
     *
     * <p>
     * The default text color is BLACK, it will be returned when the text color property
     * is missing or invalid.
     * </p>
     *
     * @return textColor of the graphNode
     *
     * @throws IllegalStateException if the style panel is not set yet
     */
    public String getTextColor() {
        return Util.getColorProperty(graphNode, Util.getStylePanel(this).getTextColorKey(),
            Util.convertColor(Color.BLACK));
    }

    /**
     * <p>
     * Returns the graphNode.
     * </p>
     * @return the graphNode
     */
    public GraphNode getGraphNode() {
        return graphNode;
    }
}
