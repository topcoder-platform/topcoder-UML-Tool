/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import java.util.Collection;


/**
 * <p>
 * Defines utilities used in this component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class Helper {
    /**
     * <p>
     * This private constructor prevents the creation of a new instance.
     * </p>
     */
    private Helper() {
    }

    /**
     * <p>
     * Validates the value of a variable with type <code>Object</code>. The value cannot be <code>null</code>.
     * </p>
     *
     * @param value value of the variable.
     * @param name name of the variable.
     *
     * @throws IllegalArgumentException if <code>value</code> is <code>null</code>.
     */
    public static void validateNotNull(Object value, String name) {
        if (value == null) {
            throw new IllegalArgumentException(name + " cannot be null.");
        }
    }

    /**
     * <p>
     * Validates the value of a variable with type <code>Collection</code>.
     * The value cannot be <code>null</code> or contain <code>null</code> value.
     * </p>
     *
     * @param value value of the variable.
     * @param name name of the variable.
     *
     * @throws IllegalArgumentException if <code>value</code> is <code>null</code>,
     * or if <code>value</code> contain <code>null</code> value.
     */
    public static void validateCollectionNotNullNotContainNull(Collection value, String name) {
        validateNotNull(value, name);

        if (value.contains(null)) {
            throw new IllegalArgumentException(name + " cannot contains null.");
        }
    }

    /**
     * Removes each element in given collection one by one from specified collection.
     *
     * @param collection collection to remove from.
     * @param toRemove collection containing elements to remove.
     * @return True if original collection is changed, false otherwise.
     */
    public static boolean removeAllFromCollection(Collection collection, Collection toRemove) {
        boolean changed = false;

        // loop to remove each of element
        for (Object obj : toRemove) {
            changed |= collection.remove(obj);
        }

        return changed;
    }
}
