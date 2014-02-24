/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import java.util.List;
import java.util.Map;

import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.ObjectFactory;


/**
 * <p>
 * This class is used by this component only. Provide some common utility methods.
 * </p>
 *
 * <p>
 * Thread safety: the class is thread-safe.
 * </p>
 *
 * @author TCSDEVELOPER
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
    static void checkNull(final Object param, final String paramName) {
        if (param == null) {
            throw new IllegalArgumentException("The argument '" + paramName
                    + "' should not be null.");
        }
    }

    /**
     * <p>
     * Checks whether the given string is null or empty.
     * </p>
     *
     * @param param
     *            the string to be checked
     * @param paramName
     *            the name of the String argument to be checked
     *
     * @throws IllegalArgumentException
     *             if the given string is null or empty
     */
    public static void checkString(final String param, final String paramName) {
        if ((param == null) || param.trim().equals("")) {
            throw new IllegalArgumentException("The argument '" + paramName
                    + "' should not be null or empty!");
        }
    }

    /**
     * <p>
     * Check whether the string array is null, or contains null or empty string.
     * </p>
     *
     * @param array the string array
     * @param paramName the name of the string array
     * @throws IllegalArgumentException if the given string array is null or contains null or empty string
     */
    public static void checkArray(final String[] array, final String paramName) {
        checkNull(array, paramName);

        for (int i = 0; i < array.length; i++) {
            checkString(array[i], paramName + "[" + i + "]");
        }
    }

    /**
     * <p>
     * Check whether the object list is null, or it is empty or contain null element.
     * </p>
     *
     * @param array the object list
     * @param paramName the name of the object list
     * @throws IllegalArgumentException if the given array is null or empty or contains null element
     */
    static void checkObjectList(final List array, final String paramName) {
        checkNull(array, paramName);

        if (array.size() == 0) {
            throw new IllegalArgumentException("The array '" + paramName
                    + "' should not be empty.");
        }

        //Check each element
        for (Object obj : array) {
            checkNull(obj, paramName + "'s element");
        }
    }

    /**
     * <p>
     * Check whether the string map is null or is empty, or it contain null or empty key.
     * </p>
     *
     * @param map the string map to check
     * @param paramName the name of the string map
     * @throws IllegalArgumentException if the map is null or is empty, or it contains null or empty key
     */
    static void checkStringMap(final Map<String, String> map,
        final String paramName) {
        checkNull(map, paramName);

        if (map.size() == 0) {
            throw new IllegalArgumentException("The map '" + paramName
                    + "' is empty.");
        }

        //Check each key
        for (String key : map.keySet()) {
            checkString(key, paramName + "'s key");
        }
    }

    /**
     * <p>
     * Check whether the double value is negative or Double.NaN.
     * </p>
     *
     * @param value the double value to check
     * @param paramName the name of the double value
     * @throws IllegalArgumentException if the double value is negative or Double.NaN
     */
    public static void checkNegativeAndNaN(final double value, final String paramName) {
        if (Double.isNaN(value) || value < 0) {
            throw new IllegalArgumentException("The argument '" + paramName
                    + "'(" + value + ") is negative.");
        }
    }

    /**
     * <p>
     * Create an object from ObjectFactory using key. The key should be valid format,
     * such as "key" or "key:id".
     * </p>
     *
     * @param of the ObjectFactory to create object from
     * @param key the key for the object
     * @return the object specified by the key
     * @throws XMIConverterConfigurationException if the key is invalid format
     * @throws InvalidClassSpecificationException if the object configuration specified by the key is invalid
     */
    public static Object createObject(ObjectFactory of, String key)
        throws XMIConverterConfigurationException, InvalidClassSpecificationException {
        Object obj;
        //Trim the key string first
        key = key.trim();

        int index = key.indexOf(":");

        try {
            //The value should be format like 'key' or 'key:identifier'
            if (index != -1) {
                String identifier = key.substring(index + 1);
                key = key.substring(0, index);

                //':id' and 'key:' and 'key:id:xx" are all invaid format
                if (key.length() == 0 || identifier.length() == 0 ||
                        (identifier.indexOf(":") != -1)) {
                    throw new XMIConverterConfigurationException(
                        "The key for Object Factory should be in correct format.");
                }

                obj = of.createObject(key, identifier);
            } else {
                if( key.length() == 0 ) {
                    throw new XMIConverterConfigurationException("The key for Object Factory should not be empty.");
                }

                obj = of.createObject(key);
            }
        } catch (NullPointerException e) {
            //If the key is in format key:id, and key doesn't exist in the config, it will throw NullPointerException
            //from ObjectFactory
            throw new XMIConverterConfigurationException("There is not config for " + key + " in object factory.");
        }

        return obj;
    }
}
