/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

/**
 * <p>
 * This helper class contains the methods for this component to check the arguments.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
final class ReaderHelper {
    /**
     * <p>
     * Private constructor to prevent this class being instantiated.
     * </p>
     */
    private ReaderHelper() {
        // does nothing
    }

    /**
     * <p>
     * Checks whether the given Object is not null.
     * </p>
     *
     * @param obj the argument to check
     * @param name the name of first argument
     *
     * @return the Object passed in
     *
     * @throws IllegalArgumentException if the given Object(obj) is null
     */
    static Object validateNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException("[" + name + "] should not be null.");
        }

        return obj;
    }

    /**
     * <p>
     * Checks whether the given String is not empty(trimmed). It will do nothing if the passed in
     * string is null.
     * </p>
     *
     * @param str the String to check
     * @param name the name of first argument
     *
     * @throws IllegalArgumentException if the given string empty string (trimmed)
     */
    static void validateEmpty(String str, String name) {
        // validates only for non-null string
        if (str == null) {
            return;
        }

        if (str.trim().length() == 0) {
            throw new IllegalArgumentException("[" + name + "] should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Checks whether the given String is not null and not empty(trimmed).
     * </p>
     *
     * @param str the String to check
     * @param name the name of first argument
     *
     * @return the string passed in
     *
     * @throws IllegalArgumentException if the given string is null or empty string (trimmed)
     */
    static String validateString(String str, String name) {
        validateNotNull(str, name);

        validateEmpty(str, name);

        return str;
    }

    /**
     * <p>
     * Validates the both qname and the localName are not null nor empty after trimmed.
     * </p>
     *
     * @param localName the local name to check
     * @param qname the qualified name to check
     *
     * @return qname if it is not null or empty string, otherwise localName
     *
     * @throws IllegalArgumentException if both localName and qname are null or empty after
     *         trimmed.
     */
    static String validateLocalnameAndQname(String localName, String qname) {
        if ((qname != null) && (qname.trim().length() != 0)) {
            return qname;
        }

        if ((localName != null) && (localName.trim().length() != 0)) {
            return localName;
        }

        throw new IllegalArgumentException(
            "Both localName and qname are not valid(null or trimmed empty).");
    }

    /**
     * <p>
     * Validates the given value is not negative.
     * </p>
     *
     * @param value the value to check
     * @param name the name of first argument
     *
     * @throws IllegalArgumentException if value is negative
     */
    private static void validaNonNegative(int value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException("[" + name + "] should not be negative.");
        }
    }

    /**
     * <p>
     * Validates given arguments are valid: <br>
     * 1) ch is not null; <br>
     * 2) start or length is not negative; <br>
     * 3) start and length should not go off the end of the ch array. <br>
     * </p>
     *
     * @param ch the char array to check
     * @param start the start position to check
     * @param length the length from the start position of the ch
     *
     * @throws IllegalArgumentException if ch is null or if start or length is negative or would go
     *         off the end of the ch array
     */
    static void validaChaArrayAndBoundArgument(char[] ch, int start, int length) {
        ReaderHelper.validateNotNull(ch, "ch");
        ReaderHelper.validaNonNegative(start, "start");
        ReaderHelper.validaNonNegative(length, "length");

        if ((start + length) > ch.length) {
            throw new IllegalArgumentException(
                "The sum of start and length should not go off the end of ch array.");
        }
    }
}
