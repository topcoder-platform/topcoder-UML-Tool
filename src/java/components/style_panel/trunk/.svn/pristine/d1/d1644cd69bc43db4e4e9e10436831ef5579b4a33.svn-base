/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.styleobject;

import java.awt.Color;

import com.topcoder.gui.panels.style.StyleNotSupportedException;
import com.topcoder.gui.panels.style.Util;
import com.topcoder.diagraminterchange.Polyline;

/**
 * <p>
 * This class extends AbstractStyleObject and is the StyleObject adapter for Polyline.
 * </p>
 *
 * <p>
 * Polyline (of diagram interchange) is supported by StylePanel using this adapter.
 * </p>
 *
 * <p>
 * Polyline supports fill and outline color styles.
 * </p>
 *
 * <p>
 * The instance of this class' scope is handled by the programmer of the application that uses this component.
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
public class PolylineStyleObjectAdapter extends AbstractStyleObject {
    /**
     * <p>
     * Represents the adaptee in the adapter.
     * </p>
     *
     * <p>
     * This adapter only supports fill color and outline color.
     * </p>
     *
     * <p>
     * Is immutable and can not be null.
     * </p>
     */
    private final Polyline polyline;

    /**
     * <p>
     * Constructor of the adapter.
     * </p>
     *
     * @param polyline polyline acts as the adaptee
     *
     * @throws IllegalArgumentException if polyline is null
     */
    public PolylineStyleObjectAdapter(Polyline polyline) {
        Util.checkNull(polyline, "polyline");

        this.polyline = polyline;
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
            "getHeight() method for PolylineStyleObjectAdapter class is not supported.");
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
        throw new StyleNotSupportedException("getWidth() method for "
                + "PolylineStyleObjectAdapter class is not supported.");
    }

    /**
     * <p>
     * The x-position style is not supported.
     * </p>
     *
     * @return the x-position style value, no return value unless it is overridden
     *
     * @throws StyleNotSupportedException all the time unless it is overridden
     */
    public double getX() {
        throw new StyleNotSupportedException("getX() method for "
            + "PolylineStyleObjectAdapter class is not supported.");
    }

    /**
     * <p>
     * The y-position style is not supported.
     * </p>
     *
     * @return the y-position style value, no return value unless it is overridden
     *
     * @throws StyleNotSupportedException all the time unless it is overridden
     */
    public double getY() {
        throw new StyleNotSupportedException("getY() method for "
            + "PolylineStyleObjectAdapter class is not supported.");
    }

    /**
     * <p>
     * The font name style is not supported.
     * </p>
     *
     * @return the font name style value, no return value unless it is overridden
     *
     * @throws StyleNotSupportedException all the time unless it is overridden
     */
    public String getFontName() {
        throw new StyleNotSupportedException(
            "getFontName() method for PolylineStyleObjectAdapter class is not supported.");
    }

    /**
     * <p>
     * The font size style is not supported.
     * </p>
     *
     * @return the font size style value, no return value unless it is overridden
     *
     * @throws StyleNotSupportedException all the time unless it is overridden
     */
    public int getFontSize() {
        throw new StyleNotSupportedException(
            "getFontSize() method for PolylineStyleObjectAdapter class is not supported.");
    }

    /**
     * <p>
     * Returns fillColor of the polyline.
     * </p>
     *
     * <p>
     * The default fill color is WHITE, it will be returned when the fill color property
     * is missing or invalid.
     * </p>
     *
     * @return fillColor of the polyline
     *
     * @throws IllegalStateException if the style panel is not set yet
     */
    public String getFillColor() {
        return Util.getColorProperty(polyline, Util.getStylePanel(this).getFillColorKey(),
            Util.convertColor(Color.WHITE));
    }

    /**
     * <p>
     * Returns outlineColor of the polyline.
     * </p>
     *
     * <p>
     * The default outline color is BLACK, it will be returned when the outline color property
     * is missing or invalid.
     * </p>
     *
     * @return outlineColor of the polyline
     *
     * @throws IllegalStateException if the style panel is not set yet
     */
    public String getOutlineColor() {
        return Util.getColorProperty(polyline, Util.getStylePanel(this).getOutlineColorKey(),
            Util.convertColor(Color.BLACK));
    }

    /**
     * <p>
     * The text color style is not supported.
     * </p>
     *
     * @return the text color style value, no return value unless it is overridden
     *
     * @throws StyleNotSupportedException all the time unless it is overridden
     */
    public String getTextColor() {
        throw new StyleNotSupportedException(
            "getTextColor() method for PolylineStyleObjectAdapter class is not supported.");
    }

    // BugFix: UML-9758
    /**
     * <p>
     * Returns the polyline.
     * </p>
     * @return the polyline
     */
    public Polyline getPolyline() {
        return polyline;
    }
}
