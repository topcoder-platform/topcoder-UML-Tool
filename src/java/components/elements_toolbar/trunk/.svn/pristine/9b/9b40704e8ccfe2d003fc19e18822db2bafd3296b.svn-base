/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements;

import java.util.Map;

/**
 * Class utility for checking the value an argument.
 *
 * @author enefem21
 * @version 1.0
 */
class ArgumentCheckUtil {

    /**
     * Private constructor to avoid an instantiation of this utility class.
     */
    private ArgumentCheckUtil() {
        // nothing to do
    }

    /**
     * Check if the object is null.
     *
     * @param object
     *            the object
     * @param objName
     *            the object name
     *
     * @throws IllegalArgumentException
     *             if the object is null
     */
    static void checkNotNull(String objName, Object object) {
        if (isNull(object)) {
            throw new IllegalArgumentException(objName + " can't be null");
        }
    }

    /**
     * Check not empty for <code>String</code>.
     *
     * @param object
     *            the object
     * @param objName
     *            the object name
     *
     * @throws IllegalArgumentException
     *             if the string is empty
     */
    static void checkNotEmpty(String objName, String object) {
        if (!isNull(object)) {
            if (isEmptyString(object)) {
                throw new IllegalArgumentException(objName + " can't be an empty string");
            }
        }
    }

    /**
     * Check not empty for <code>Map</code>.
     *
     * @param object
     *            the object
     * @param objName
     *            the object name
     *
     * @throws IllegalArgumentException
     *             if the map is empty
     */
    static void checkNotEmpty(String objName, Map object) {
        if (!isNull(object)) {
            if (object.size() == 0) {
                throw new IllegalArgumentException(objName + " can't be an empty map");
            }
        }
    }

    /**
     * Check not empty for array.
     *
     * @param objName
     *            the object name
     * @param array
     *            the array
     *
     * @throws IllegalArgumentException
     *             if the array is null
     */
    static void checkNotEmpty(String objName, int[] array) {
        if (!isNull(array)) {
            if (array.length == 0) {
                throw new IllegalArgumentException(objName + " can't be an empty array");
            }
        }
    }

    /**
     * Check not null and not empty for <code>String</code>.
     *
     * @param object
     *            the object
     * @param objName
     *            the object name
     *
     * @throws IllegalArgumentException
     *             if the string is null or empty
     */
    static void checkNotNullAndNotEmpty(String objName, String object) {
        checkNotNull(objName, object);
        checkNotEmpty(objName, object);
    }

    /**
     * Check not null and not empty for <code>Map</code>.
     *
     * @param object
     *            the object
     * @param objName
     *            the object name
     *
     * @throws IllegalArgumentException
     *             if the map is null or empty
     */
    static void checkNotNullAndNotEmpty(String objName, Map object) {
        checkNotNull(objName, object);
        checkNotEmpty(objName, object);
    }

    /**
     * Check not null and not empty for array.
     *
     * @param objName
     *            the object name
     * @param array
     *            the array
     *
     * @throws IllegalArgumentException
     *             if the array is null or empty
     */
    static void checkNotNullAndNotEmpty(String objName, int[] array) {
        checkNotNull(objName, array);
        checkNotEmpty(objName, array);
    }

    /**
     * Check if the number is in the range numberStart (inclusive) and numberEnd (exclusive).
     *
     * @param numberStart
     *            the number where the range is started, inclusive
     * @param objName
     *            the object name
     * @param numberEnd
     *            the number where the range is ended, exclusive
     * @param number
     *            the number to be checked
     *
     * @throws IllegalArgumentException
     *             if the number is negative
     */
    static void checkInRange(String objName, int number, int numberStart, int numberEnd) {
        if (number < numberStart) {
            throw new IllegalArgumentException(objName + " is smaller than " + numberStart);
        }
        if (number >= numberEnd) {
            throw new IllegalArgumentException(objName + " is greater than or same as " + numberEnd);
        }
    }

    /**
     * Check that the array is not contains null.
     *
     * @param arrayObjects
     *            the transformers
     * @param objName
     *            the object name
     */
    static void checkNotContainsNull(String objName, Object[] arrayObjects) {
        if (arrayObjects != null) {
            for (Object item : arrayObjects) {
                ArgumentCheckUtil.checkNotNull("array item", item);
            }
        }
    }

    /**
     * Check that the array is not null and not contains null.
     *
     * @param arrayObjects
     *            the transformers
     * @param objName
     *            the object name
     */
    static void checkNotNullAndNotContainsNull(String objName, Object[] arrayObjects) {
        checkNotNull(objName, arrayObjects);
        checkNotContainsNull(objName, arrayObjects);
    }

    /**
     * Check that the array is not contains empty string.
     *
     * @param arrayStrings
     *            the transformers
     * @param objName
     *            the object name
     */
    static void checkNotContainsEmptyString(String objName, String[] arrayStrings) {
        if (arrayStrings != null) {
            for (String value : arrayStrings) {
                ArgumentCheckUtil.checkNotEmpty("array value", value);
            }
        }
    }

    /**
     * Check that the array is not null and not contains null or empty string.
     *
     * @param arrayStrings
     *            the transformers
     * @param objName
     *            the object name
     */
    static void checkNotNullAndNotContainsNullOrEmptyString(String objName, String[] arrayStrings) {
        checkNotNull(objName, arrayStrings);
        checkNotContainsNull(objName, arrayStrings);
        checkNotContainsEmptyString(objName, arrayStrings);
    }

    /**
     * Check that the array is not contains null or empty string.
     *
     * @param arrayStrings
     *            the transformers
     * @param objName
     *            the object name
     */
    static void checkNotContainsNullOrEmptyString(String objName, String[] arrayStrings) {
        if (!isNull(arrayStrings)) {
            checkNotContainsNull(objName, arrayStrings);
            checkNotContainsEmptyString(objName, arrayStrings);
        }
    }

    /**
     * Check that the integer is greater than zero.
     *
     * @param integer
     *            the integer
     * @param intName
     *            the integer name
     */
    static void checkPositive(String intName, int integer) {
        if (integer <= 0) {
            throw new IllegalArgumentException(intName + " is not a positive number");
        }
    }

    /**
     * Checks if string is null or empty string.
     *
     * @param string
     *            the string
     *
     * @return true, if string is or and empty string
     */
    static boolean isNullOrEmptyString(String string) {
        return isNull(string) || isEmptyString(string);
    }

    /**
     * Checks if string is empty string.
     *
     * @param string
     *            the string
     *
     * @return true, if string is empty string
     */
    static boolean isEmptyString(String string) {
        return string.trim().length() == 0;
    }

    /**
     * Checks if object is null.
     *
     * @param object
     *            the object
     *
     * @return true, if object is null
     */
    static boolean isNull(Object object) {
        return object == null;
    }

}
