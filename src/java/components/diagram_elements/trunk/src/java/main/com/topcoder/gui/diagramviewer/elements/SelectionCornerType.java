/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

/**
 * <p>
 * This enumeration represents all the types of selection corners.
 * </p>
 * <p>
 * It defines eight values according to eight directions: East, South, West, North, NorthEast, SouthEast, NorthWest and
 * SouthWest.
 * </p>
 * <p>
 * <b>Thread Safety:</b> Enum is thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public enum SelectionCornerType {

    /**
     * <p>
     * Represents the East corner type.
     * </p>
     * <p>
     * It means the when mouse clicked on such corner, the cursor will be changed to <code>E_RESIZE_CURSOR</code>.
     * </p>
     */
    EAST,

    /**
     * <p>
     * Represents the South corner type.
     * </p>
     * <p>
     * It means the when mouse clicked on such corner, the cursor will be changed to <code>S_RESIZE_CURSOR</code>.
     * </p>
     */
    SOUTH,

    /**
     * <p>
     * Represents the West corner type.
     * </p>
     * <p>
     * It means the when mouse clicked on such corner, the cursor will be changed to <code>W_RESIZE_CURSOR</code>.
     * </p>
     */
    WEST,

    /**
     * <p>
     * Represents the North corner type.
     * </p>
     * <p>
     * It means the when mouse clicked on such corner, the cursor will be changed to <code>N_RESIZE_CURSOR</code>.
     * </p>
     */
    NORTH,

    /**
     * <p>
     * Represents the NorthEast corner type.
     * </p>
     * <p>
     * It means the when mouse clicked on such corner, the cursor will be changed to <code>NE_RESIZE_CURSOR</code>.
     * </p>
     */
    NORTHEAST,

    /**
     * <p>
     * Represents the SouthEast corner type.
     * </p>
     * <p>
     * It means the when mouse clicked on such corner, the cursor will be changed to <code>SE_RESIZE_CURSOR</code>.
     * </p>
     */
    SOUTHEAST,

    /**
     * <p>
     * Represents the NorthWest corner type.
     * </p>
     * <p>
     * It means the when mouse clicked on such corner, the cursor will be changed to <code>NW_RESIZE_CURSOR</code>.
     * </p>
     */
    NORTHWEST,

    /**
     * <p>
     * Represents the SouthWest corner type.
     * </p>
     * <p>
     * It means the when mouse clicked on such corner, the cursor will be changed to <code>SW_RESIZE_CURSOR</code>.
     * </p>
     */
    SOUTHWEST
}
