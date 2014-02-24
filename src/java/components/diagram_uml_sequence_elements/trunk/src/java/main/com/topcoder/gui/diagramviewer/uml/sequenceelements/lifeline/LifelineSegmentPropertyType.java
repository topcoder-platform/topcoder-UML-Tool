/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline;

/**
 * <p>
 * The enum representing all possible kinds of the used properties for the LifelineSegment.
 * </p>
 *
 * <p>
 * The enum elements corresponds to the LifelineSegment class instance variables with the same
 * names: strokeColor, fillColor and so on.
 * </p>
 *
 * Thread safety: The enums are thread safe.
 *
 * @author gniuxiao, TCSDEVELOPER
 * @version 1.1
 * @since 1.1
 */
public enum LifelineSegmentPropertyType {
    /**
     * <p>
     * Represents the STROKE_COLOR enum item.
     * </p>
     *
     */
    STROKE_COLOR,
    /**
     * <p>
     * Represents the FILL_COLOR enum item.
     * </p>
     *
     */
    FILL_COLOR,
    /**
     * <p>
     * Represents the SHADOW_COLOR enum item.
     * </p>
     *
     */
    SHADOW_COLOR,
    /**
     * <p>
     * Represents the WIDTH enum item.
     * </p>
     *
     */
    WIDTH,
    /**
     * <p>
     * Represents the HEIGHT enum item.
     * </p>
     *
     */
    HEIGHT,
    /**
     * <p>
     * Represents the SHADOW_LENGTH enum item.
     * </p>
     *
     */
    SHADOW_LENGTH,
    /**
     * <p>
     * Represents the MINIMUM_WIDTH enum item.
     * </p>
     *
     */
    MINIMUM_WIDTH,
    /**
     * <p>
     * Represents the MINIMUM_HEIGHT enum item.
     * </p>
     *
     */
    MINIMUM_HEIGHT,
    /**
     * <p>
     * Represents the RENDER_SCHEME enum item.
     * </p>
     *
     */
    RENDER_SCHEME;
}
