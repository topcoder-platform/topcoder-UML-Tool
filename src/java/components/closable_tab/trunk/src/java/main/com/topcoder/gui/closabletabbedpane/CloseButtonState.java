/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

/**
 * <p>
 * This enumeration lists the possible states in which a close button can be.
 * </p>
 * <p>
 * Thread Safety: This class is thread safe as it is stateless.
 * </p>
 * @author humblefool, TCSDEVELOPER
 * @version 1.0
 */
public enum CloseButtonState {
    /**
     * <p>
     * Represents the close button which is on the active tab and is being hovered upon by the mouse. It is static and
     * frozen since it is an enum constant.
     * </p>
     */
    ACTIVE_TAB_HOVERED,
    /**
     * <p>
     * Represents the close button which is on the active tab and is NOT being hovered upon by the mouse. It is static
     * and frozen since it is an enum constant.
     * </p>
     */
    ACTIVE_TAB_NOT_HOVERED,
    /**
     * <p>
     * Represents the close button which is on the inactive tab and is being hovered upon by the mouse. It is static
     * and frozen since it is an enum constant.
     * </p>
     */
    INACTIVE_TAB_HOVERED,
    /**
     * <p>
     * Represents the close button which is on the inactive tab and is NOT being hovered upon by the mouse. It is
     * static and frozen since it is an enum constant.
     * </p>
     */
    INACTIVE_TAB_NOT_HOVERED;

    /**
     * To prevent outside constructing.
     */
    private CloseButtonState() {
        // Does nothing.
    }
}
