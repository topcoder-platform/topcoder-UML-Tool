/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.io.Serializable;

/**
 * <p>
 * This class represents a dimension with width and height specified with double precision.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and is not thread-safe, since thread safety is not required.
 * Instead, the calling application is required to ensure thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public class Dimension implements Serializable {

    /**
     * <p>
     * Represents the width of this Dimension. Default to 0.0.
     * </p>
     */
    private double width;

    /**
     * <p>
     * Represents the height of this Dimension. Default to 0.0.
     * </p>
     */
    private double height;

    /**
     * <p>
     * Creates an instance of Dimension.
     * </p>
     */
    public Dimension() {
        // empty constructor
    }

    /**
     * <p>
     * Gets the width of this Dimension.
     * </p>
     *
     * @return the width of this Dimension
     */
    public double getWidth() {
        return width;
    }

    /**
     * <p>
     * Sets the width of this Dimension.
     * </p>
     *
     * @param width the new width of this Dimension
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * <p>
     * Gets the height of this Dimension.
     * </p>
     *
     * @return the height of this Dimension
     */
    public double getHeight() {
        return height;
    }

    /**
     * <p>
     * Sets the height of this Dimension.
     * </p>
     *
     * @param height the new height of this Dimension
     */
    public void setHeight(double height) {
        this.height = height;
    }
}