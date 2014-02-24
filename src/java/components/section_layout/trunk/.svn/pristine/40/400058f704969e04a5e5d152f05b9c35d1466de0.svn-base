/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import java.awt.Point;

/**
 * <p>
 * This class contains some helper functions provided for this component.
 * </p>
 *
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class Helper {

    /**
     * <p>
     * Creates a new instance of <code>Helper</code> class.
     * Private empty constructor to prevent instantiation.
     * </p>
     */
    private Helper() {
        // empty
    }

    /**
     * <p>
     * Checks an Object.
     * If the Object is null, throw an <code>IllegalArgumentException</code>.
     * </p>
     *
     * @param obj
     *        the Object to be checked.
     * @param name
     *        the name of the obj.
     * @throws IllegalArgumentException
     *         If the Object is null.
     */
    public static void checkNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException("The [" + name + "] should not be null.");
        }
    }

    /**
     * <p>
     * Checks an int value.
     * If the int value is not positive, throw an <code>IllegalArgumentException</code>.
     * </p>
     *
     * @param value
     *        the int value to be checked.
     * @param name
     *        the name of the value.
     * @throws IllegalArgumentException
     *         If the int value is not positive.
     */
    public static void checkNotPositive(int value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException("The [" + name + "] should be positive.");
        }
    }

    /**
     * <p>
     * Checks an int value.
     * If the int value is negative, throw an <code>IllegalArgumentException</code>.
     * </p>
     *
     * @param value
     *        the int value to be checked.
     * @param name
     *        the name of the value.
     * @throws IllegalArgumentException
     *         If the int value is negative.
     */
    public static void checkNegative(int value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException("The [" + name + "] should not be negative.");
        }
    }

    /**
     * <p>
     * Checks a Point.
     * If the Point is null or its x/y is negative, throw an <code>IllegalArgumentException</code>.
     * </p>
     *
     * @param point
     *        the Point to be checked.
     * @param name
     *        the name of the Point.
     * @throws IllegalArgumentException
     *         If the Point is null or its x/y is negative.
     */
    public static void checkPoint(Point point, String name) {
        checkNull(point, name);
        checkNegative(point.x, name + "'s x");
        checkNegative(point.y, name + "'s y");
    }
}
