/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import java.util.Collection;
import java.util.Iterator;

/**
 * <p>
 * Helper class for the Element Properties Actions Component.
 * </p>
 *
 * @author kinzz, rainday
 * @version 1.0
 */
public final class Helper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private Helper() {
    }

    /**
     * <p>
     * Checks whether the given Object is null.
     * </p>
     *
     * @param obj
     *            the argument to check
     * @param name
     *            the name of the argument to check
     *
     * @throws IllegalArgumentException
     *             if the given Object is null
     */
    public static void checkNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Checks whether the given string is empty or null.
     * </p>
     *
     * @param str
     *            the argument to check
     * @param name
     *            the name of the string to check
     *
     * @throws IllegalArgumentException
     *             if the given string is null or empty
     */
    public static void checkNotNullAndNotEmpty(String str, String name) {
        checkNotNull(str, name);
        if (str.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty.");
        }
    }

    /**
     * <p>
     * Checks whether the given collection is null or contains null.
     * </p>
     *
     * @param collection
     *            the argument to check
     * @param name
     *            the name of the collection to check
     *
     * @throws IllegalArgumentException
     *             if the given collection is null or contains null.
     */
    public static void checkNotNullAndNotContainsNull(Collection<?> collection, String name) {
        checkNotNull(collection, name);
        Iterator<?> iter = collection.iterator();
        while (iter.hasNext()) {
            if (iter.next() == null) {
                throw new IllegalArgumentException(name + " should not contain null.");
            }
        }
    }
}
