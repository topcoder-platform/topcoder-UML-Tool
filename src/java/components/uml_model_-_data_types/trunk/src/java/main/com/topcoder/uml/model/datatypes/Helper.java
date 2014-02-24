/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

import java.util.Collection;

/**
 * <p>
 * This helper class contains methods for this package methods to check the arguments.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
final class Helper {

    /**
     * <p>
     * Private constructor to prevent this class being instantiated.
     * </p>
     *
     */
    private Helper() {
        // do nothing
    }

    /**
     * <p>
     * Checks whether the given Object is not null.
     * </p>
     *
     * @param obj
     *            the argument to check
     * @param name
     *            the name of the argument
     *
     * @throws IllegalArgumentException
     *             if the given Object is null
     */
    public static void checkNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException("[ " + name + " ] should not be null.");
        }
    }

    /**
     * <p>
     * Checks whether the given Collection is valid. <br>
     * Valid collection: <br>
     * 1. the collection is not null; <br>
     * 2. the collection does not contain null elements; <br>
     * </p>
     *
     * @param collection
     *            the collection to check
     * @param name
     *            the name of argument
     *
     * @throws IllegalArgumentException
     *             if the given collection is invalid.
     */
    public static void checkCollection(Collection collection, String name) {
        // check condition 1
        checkNotNull(collection, name);

        // check condition 2
        for (Object obj : collection) {
            if (obj == null) {
                throw new IllegalArgumentException("Each element in [ " + name
                    + " ] should not be null");
            }
        }
    }

    /**
     * <p>
     * Checks whether the given integer is not negative.
     * </p>
     *
     * @param value
     *            the integer value to check
     * @param name
     *            the name of the argument
     * @return the integer value.
     *
     * @throws IllegalArgumentException
     *             if the given integer is negative
     */
    public static int checkNotNegative(int value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException("[ " + name + " ] should not be negative.");
        }

        return value;
    }
}
