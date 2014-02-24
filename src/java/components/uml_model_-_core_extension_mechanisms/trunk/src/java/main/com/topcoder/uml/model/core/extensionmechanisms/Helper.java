/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms;

import java.util.Collection;

/**
 * <p>
 * Defines utilities used in this component. It contains methods for null
 * references checking and Collections with null entries checking.
 * </p>
 * <p>
 * Thread-safety: This class is thread-safe.
 * </p>
 *
 * @author BLE
 * @version 1.0
 */
final class Helper {
    /**
     * <p>
     * Creates an instance of <code>Helper</code> class. This private
     * constructor prevents the creation of a new instance.
     * </p>
     */
    private Helper() {
    }

    /**
     * <p>
     * Checks whether the given Object is not null.
     * </p>
     *
     * @param obj the argument to check
     * @param name the name of the argument
     * @throws IllegalArgumentException if the given Object(obj) is null
     */
    public static void assertNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException("[ " + name + " ] should not be null.");
        }
    }

    /**
     * <p>
     * Checks whether the given collection is not null and does not contain null
     * entries.
     * </p>
     *
     * @param collection the collection to check
     * @param name the name of the collection
     * @throws IllegalArgumentException if the given collection is null or
     *             contains null entries.
     */
    public static void assertNotNullOrContainsNull(Collection collection, String name) {
        assertNotNull(collection, name);

        if (collection.contains(null)) {
            throw new IllegalArgumentException("[ " + name + " ] should not contain null.");
        }
    }
}
