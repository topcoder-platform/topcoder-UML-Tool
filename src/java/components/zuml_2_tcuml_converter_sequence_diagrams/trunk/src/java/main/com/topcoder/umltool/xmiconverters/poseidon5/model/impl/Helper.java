/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model.impl;

import java.util.Collection;


/**
 * <p>
 * This class is used by this component only. Provide some common utility methods.
 * </p>
 *
 * <p>
 * Thread safety: the class is thread-safe.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public final class Helper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private Helper() {
        // do nothing
    }

    /**
     * <p>
     * Checks whether the given object is null.If null,
     * <code>IllegalArgumentException</code> will be thrown.
     * </p>
     *
     * @param param
     *            the argument to be checked
     * @param paramName
     *            the name of the argument to be checked
     * @throws IllegalArgumentException
     *             if param is null
     */
    public static void checkNull(final Object param, final String paramName) {
        if (param == null) {
            throw new IllegalArgumentException("The argument '" + paramName
                    + "' should not be null.");
        }
    }

    /**
     * <p>
     * Check whether the collection is null or empty or contains null element.
     * </p>
     *
     * @param col the collection to check
     * @param paramName the name of the collection
     * @throws IllegalArgumentException if the collection is null or empty or contains null element
     */
    public static void checkCollection(final Collection<?> col,
        final String paramName) {
        checkNull(col, paramName);

        if (col.size() == 0) {
            throw new IllegalArgumentException("The collection '" + paramName
                    + "' should not be empty.");
        }

        for (Object obj : col) {
            checkNull(obj, paramName + "' element");
        }
    }
}
