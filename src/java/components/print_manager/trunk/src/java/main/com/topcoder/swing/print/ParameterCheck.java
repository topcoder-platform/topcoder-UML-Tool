/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import java.util.List;


/**
 * Helper class to do parameters checks.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class ParameterCheck {
    /**
     * Private ctor preventing this class from being instantiated.
     */
    private ParameterCheck() {
    }

    /**
     * Checks and throws IllegalArgumentException if the parameter is null.
     *
     * @param paramName name of the parameter
     * @param param value of the parameter to be checked
     *
     * @throws IllegalArgumentException if given parameter is null
     */
    public static void checkNull(String paramName, Object param) {
        if (param == null) {
            throw new IllegalArgumentException(paramName + " is null");
        }
    }

    /**
     * Checks and throws IllegalArgumentException if the parameter is null or empty string.
     *
     * @param paramName name of the parameter
     * @param string string to be checked
     *
     * @throws IllegalArgumentException if given parameter is empty string.
     */
    public static void checkNullEmpty(String paramName, String string) {
        checkNull(paramName, string);

        if (string.trim().length() == 0) {
            throw new IllegalArgumentException(paramName + " is empty string");
        }
    }

    /**
     * Checks and throws IllegalArgumentException if the parameter is null or empty list, or contains element
     * as null.
     *
     * @param paramName name of the parameter
     * @param list list to be checked
     *
     * @throws IllegalArgumentException if given parameter is null or empty list, or contains null as element
     */
    public static void checkEmptyList(String paramName, List list) {
        checkNull(paramName, list);

        if (list.isEmpty()) {
            throw new IllegalArgumentException(paramName + " is empty list");
        }

        if (list.contains(null)) {
            throw new IllegalArgumentException(paramName + " contains null");
        }
    }
}
