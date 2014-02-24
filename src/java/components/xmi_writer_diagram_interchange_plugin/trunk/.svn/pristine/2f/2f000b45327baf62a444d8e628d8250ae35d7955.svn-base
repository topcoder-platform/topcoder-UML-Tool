/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;


/**
 * <p>Helper class contains static methods for this package methods to check the arguments.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class Helper {
    /**
     * <p>
     * Private constructor to prevent this class being instantiated.
     * </p>
     */
    private Helper() {
        // do nothing.
    }

    /**
     * <p>Check whether the given object is not null.</p>
     *
     * @param obj the argument object to check
     * @param name the argument name. Used to give a meaningful error message.
     *
     * @throws IllegalArgumentException if the given object is null
     */
    public static void checkNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException("[ " + name + " ] should not be null.");
        }
    }

    /**
     * <p>Check whether the given object to transform is not null.</p>
     *
     * @param element the element object to check
     *
     * @throws IllegalArgumentException if the given object is null
     */
    public static void checkElementNotNull(Object element) {
        checkNotNull(element, "Element to transform");
    }

}
