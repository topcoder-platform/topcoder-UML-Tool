/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Bloom Filter Version 1.1
 *
 * @ CollaborationsHelp.java
 */
package com.topcoder.uml.model.collaborations.collaborationinstances;

import java.util.Collection;

/**
 * <p> Helper class which contains methods for this component classes methods
 * to check the arguments. </p>
 *
 * @author yinzi
 * @version 1.0
 */
public final class CollaborationsHelper {
    /**
     * <p> Creates a new instance of <code>CollaborationsHelp</code> class. </p>
     *
     * <p> Private constructor to prevent this class being instantiated. </p>
     */
    private CollaborationsHelper() {
        // do nothing
    }

    /**
     * <p> Checks whether the given <code>Object</code> is not-null. </p>
     *
     * @param obj the <code>Object</code> to check.
     * @param name the name of the argument.
     *
     * @throws IllegalArgumentException if <code>obj</code> is <code>null</code>.
     */
    public static void checkNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException(name + " cannot be null.");
        }
    }

    /**
     * <p> Checks whether the given <code>collection</code> Collection is null or contains null elements. </p>
     *
     * @param collection the <code>collection</code> to check.
     * @param name the name of the argument.
     *
     * @throws IllegalArgumentException if there is <code>null</code> object in <code>collection</code>.
     */
    public static void checkCollection(Collection<?> collection, String name) {
        checkNotNull(collection, name);

        if (collection.contains(null)) {
            throw new IllegalArgumentException(name + "contains null elements.");
        }
    }
}
