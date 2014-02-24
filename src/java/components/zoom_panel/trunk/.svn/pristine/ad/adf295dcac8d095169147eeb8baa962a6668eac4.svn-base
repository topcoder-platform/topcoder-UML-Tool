/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom;

import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;

/**
 * <p>
 * This class contains the common utility functions needed in this component. This class makes it easy to maintain.
 * </p>
 * <p>
 * <strong>Thread-safety</strong>: it is thread-safe.
 * </p>
 *
 * @author 80x86
 * @version 1.0
 */
public final class Helper {

    /**
     * <p>
     * Constant used to determine if a variable is small enough.
     * </p>
     */
    public static final double EPSILON = 1e-6;

    /**
     * <p>
     * private empty constructor for preventing instantiation.
     * </p>
     */
    private Helper() {
    }

    /**
     * <p>
     * Validates the value of a variable with type <code>Object</code>. The value cannot be <code>null</code>.
     * </p>
     *
     * @param value value of the variable
     * @param name name of the variable
     * @throws IllegalArgumentException if <code>value</code> is <code>null</code>.
     */
    public static final void validateObject(Object value, String name) {
        if (value == null) {
            throw new IllegalArgumentException("the [" + name + "] can not be null.");
        }
    }

    /**
     * <p>
     * Validates an object with type <code>AffineTransform</code>. The object should be invertible.
     * </p>
     *
     * @param transform the object to be validated
     * @return the clone of the object
     * @throws IllegalArgumentException if the object is not invertible
     */
    public static final AffineTransform validateAffineTransform(AffineTransform transform) {
        try {
            transform.createInverse();
            return (AffineTransform) transform.clone();
        } catch (NoninvertibleTransformException e) {
            throw new IllegalArgumentException("transform is not invertible.");
        }
    }

    /**
     * <p>
     * Validates the value of a variable with type <code>double</code>. The value must be positive.
     * </p>
     *
     * @param d value of the variable
     * @param name name of the variable
     * @return the double value passed in
     * @throws IllegalArgumentException if <code>value</code> is not positive
     */
    public static final double validateDouble(double d, String name) {
        if (d > Helper.EPSILON && d < Double.POSITIVE_INFINITY) {
            return d;
        } else {
            throw new IllegalArgumentException("argument [" + name + "] can't be negative.");
        }
    }

    /**
     * Validate the variable of type <code>double</code> and cast it to int.
     *
     * @param d the value to be casted
     * @return the int value after being casted
     */
    public static int castDouble2Int(double d) {
        int ret = 0;

        if (d < Helper.EPSILON || d == Double.NaN) {
            ret = 0;
        } else {
            ret = (int) d;
        }

        return ret;
    }

    /**
     * Validate the variable of type <code>int</code>. The variable should not be negative.
     *
     * @param value the value to be validated
     * @param name the name of the variable
     * @return the original value
     * @throws IllegalArgumentException if value is negative
     */
    public static int validateIntNotNegative(int value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException("argument [" + name + "] should not be negative.");
        } else {
            return value;
        }
    }
}
