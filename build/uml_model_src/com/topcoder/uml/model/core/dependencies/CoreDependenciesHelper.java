/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Core Dependencies Version 1.0
 *
 * @ CoreDependenciesHelp.java
 */
package com.topcoder.uml.model.core.dependencies;

import java.util.Collection;

/**
 * <p> Helper class which contains methods for this component classes methods to check the arguments. </p>
 *
 * @author yinzi
 * @version 1.0
 */
final class CoreDependenciesHelper {
    /**
     * <p> Creates a new instance of <code>CoreDependenciesHelp</code> class. </p>
     *
     * <p> Private constructor to prevent this class being instantiated. </p>
     */
    private CoreDependenciesHelper() {
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
     * @throws IllegalArgumentException if <code>str</code> is <code>null</code>
     * or empty after trim.
     */
    public static void checkCollection(Collection<?> collection, String name) {
        checkNotNull(collection, name);

        if (collection.contains(null)) {
            throw new IllegalArgumentException(name + "contains null elements."); 
        }
    }

    /**
     * <p> Checks whether the given index is in the range of [0, range). </p>
     *
     * @param index The index to check.
     * @param range The valid range of the index.
     * @param name The name of the index.
     * @throws IndexOutOfBoundsException If index is out of range.
     */
    public static void checkIndexRange(int index, int range, String name) {
        if (index < 0 || index >= range) {
            throw new IndexOutOfBoundsException(name + " should in the range of [0," + range + ")");
        }
    }


    /**
     * <p> Checks whether the given index is in the range of [0, range]. </p>
     *
     * @param index The index to check.
     * @param range The valid range of the index.
     * @param name The name of the index.
     * @throws IndexOutOfBoundsException If index is out of range.
     */
    public static void checkIndexAddRange(int index, int range, String name) {
        if (index < 0 || index > range) {
            throw new IndexOutOfBoundsException(name + " should in the range of [0," + range + "]");
        }
    }
}
