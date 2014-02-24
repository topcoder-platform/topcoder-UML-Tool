/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

/**
 * <p>
 * This is the general interface that can be used for any object that support style.
 * </p>
 *
 * <p>
 * If an object needs to be compatible with StylePanel, then developer can provide adapter for the class
 * implementing this interface.
 * It's suggested that AbstractStyleObject used rather than implementing this StyleObject interface.
 * </p>
 *
 * <p>
 * Thread Safety: The implementation of this interface is not required to be thread safe.
 * </p>
 *
 * @author enefem21, TCSDEVELOPER
 * @version 1.0
 */
public interface StyleObject {
    /**
     * <p>
     * Returns height of the style object.
     * </p>
     *
     * @return height of the style object
     *
     * @throws StyleNotSupportedException if the style is not supported
     */
    public double getHeight();

    /**
     * <p>
     * Returns width of the style object.
     * </p>
     *
     * @return width of the style object
     *
     * @throws StyleNotSupportedException if the style is not supported
     */
    public double getWidth();

    /**
     * <p>
     * Returns x coordinate of the style object.
     * </p>
     *
     * @return x coordinate of the style object
     *
     * @throws StyleNotSupportedException if the style is not supported
     */
    public double getX();

    /**
     * <p>
     * Returns y coordinate of the style object.
     * </p>
     *
     * @return y coordinate of the style object
     *
     * @throws StyleNotSupportedException if the style is not supported
     * @throws IllegalStateException if the style panel for the style object is not set
     */
    public double getY();

    /**
     * <p>
     * Returns font name of the style object.
     * </p>
     *
     * @return font name of the style object
     *
     * @throws StyleNotSupportedException if the style is not supported
     * @throws IllegalStateException if the style panel for the style object is not set
     */
    public String getFontName();

    /**
     * <p>
     * Returns font size of the style object.
     * </p>
     *
     * @return font size of the style object
     *
     * @throws StyleNotSupportedException if the style is not supported
     * @throws IllegalStateException if the style panel for the style object is not set
     */
    public int getFontSize();

    /**
     * <p>
     * Returns fill color of the style object.
     * </p>
     *
     * @return fill color of the style object
     *
     * @throws StyleNotSupportedException if the style is not supported
     * @throws IllegalStateException if the style panel for the style object is not set
     */
    public String getFillColor();

    /**
     * <p>
     * Returns outline color of the style object.
     * </p>
     *
     * @return outline color of the style object
     *
     * @throws StyleNotSupportedException if the style is not supported
     * @throws IllegalStateException if the style panel for the style object is not set
     */
    public String getOutlineColor();

    /**
     * <p>
     * Returns text color of the style object.
     * </p>
     *
     * @return text color of the style object
     *
     * @throws StyleNotSupportedException if the style is not supported
     * @throws IllegalStateException if the style panel for the style object is not set
     */
    public String getTextColor();

    /**
     * <p>
     * Sets the style panel.
     * </p>
     *
     * @param stylePanel stylePanel where this object attached, can be null
     */
    public void setStylePanel(StylePanel stylePanel);

    /**
     * <p>
     * Gets the style panel.
     * </p>
     *
     * @return stylePanel where this object is attached, null if this object is not attached
     */
    public StylePanel getStylePanel();
}
