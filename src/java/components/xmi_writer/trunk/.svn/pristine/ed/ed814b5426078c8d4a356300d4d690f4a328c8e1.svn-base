/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

/**
 * <p>
 * This class contains the common utility functions needed in this component. This class makes it easy to maintain.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public final class Helper {

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
     * @param value
     *            value of the variable.
     * @param name
     *            name of the variable.
     * @throws IllegalArgumentException
     *             if <code>value</code> is <code>null</code>.
     */
    public static final void validateObject(Object value, String name) {
        if (value == null) {
            throw new IllegalArgumentException("the [" + name + "] can not be null.");
        }
    }

    /**
     * <p>
     * Validates the value of a variable with type <code>String</code>. The value cannot be <code>null</code> and
     * <code>empty</code>.
     * </p>
     *
     * @param value
     *            value of the variable
     * @param name
     *            name of the variable
     * @throws IllegalArgumentException
     *             if <code> value</code> is <code>null</code> or <code>empty</code>.
     */
    public static final void validateString(String value, String name) {
        validateObject(value, name);

        if (value.trim().length() == 0) {
            throw new IllegalArgumentException("the [" + name + "] can not be empty.");
        }
    }
}
