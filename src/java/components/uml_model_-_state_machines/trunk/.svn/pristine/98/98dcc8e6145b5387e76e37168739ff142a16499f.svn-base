/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.Collection;


/**
 * <p>This is a helper class for the component to check argument.</p>
 *
 * @author catcher
 * @version 1.0
 */
final class Helper {
    /**
     * <p>
     * The private constructor prevents creation.
     * </p>
     */
    private Helper() {
        // do nothing
    }

    /**
     * <p>Checks whether the given argument is null.</p>
     *
     * @param argument the argument to be checked
     * @param name the name of the argument
     *
     * @throws IllegalArgumentException if the argument is null
     */
    static void checkNotNull(Object argument, String name) {
        if (argument == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>Checks whether the given collection is null or contains null element.</p>
     *
     * @param collection the collection to be checked
     * @param name the name of the collection
     *
     * @throws IllegalArgumentException if the collection is null or contains null element.
     */
    static void chekCollection(Collection collection, String name) {
        checkNotNull(collection, name);

        if (collection.contains(null)) {
            throw new IllegalArgumentException(name + " should not contain null element.");
        }
    }
}
