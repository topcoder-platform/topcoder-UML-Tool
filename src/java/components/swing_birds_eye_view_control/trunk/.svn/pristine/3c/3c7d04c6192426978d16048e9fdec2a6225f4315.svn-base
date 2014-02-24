/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

/**
 * <p>
 * Helper class for this component.
 * </p>
 *
 * <p>
 * <strong>Thread Safety:</strong> This class is immutable and so thread safe.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class Helper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private Helper() {
        // empty
    }

    /**
     * <p>
     * Checks whether the given Object is null.
     * </p>
     *
     * @param arg
     *            the argument to check
     * @param name
     *            the name of the argument to check
     * @throws IllegalArgumentException
     *             if the given Object is null
     */
    public static void checkNull(Object arg, String name) {
        if (arg == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Checks whether the given String is null or empty.
     * </p>
     *
     * @param arg
     *            the String to check
     * @param name
     *            the name of the String argument to check
     *
     * @throws IllegalArgumentException
     *             if the given string is null or empty
     */
    public static void checkNullOrEmpty(String arg, String name) {
        checkNull(arg, name);

        if (arg.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty.");
        }
    }

    /**
     * <p>
     * Return the Integer value of the input string.
     * </p>
     *
     * @param number
     *                  number in String type
     * @return
     *                  the number in Integer type, return null
     *                  if the number can not be converted to Integer
     *                  type.
     */
    public static Integer convertStringToInt(String number) {
        if (number == null) {
            return null;
        }
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * <p>
     * Return the Double value of the input string.
     * </p>
     *
     * @param number
     *                  the number in String type
     * @return
     *                  the number in Double type, return null
     *                  if the number can not be converted to Double
     *                  type.
     */
    public static Double convertStringToDouble(String number) {
        if (number == null) {
            return null;
        }
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * <p>
     * Compare the two input double numbers, if the distance of the two double numbers
     * is less than 1e-8, true is returned, else false is returned.
     * </p>
     * @param d1
     *          the first double number
     * @param d2
     *          the second double number
     * @return
     *          the result of the comparison.
     */
    public static boolean compareDoubles(double d1, double d2) {
        if (Math.abs(d1 - d2) < 1e-8) {
            return true;
        }
        return false;
    }
}
