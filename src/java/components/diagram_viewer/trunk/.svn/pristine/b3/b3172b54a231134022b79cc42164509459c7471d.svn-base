/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * This helper class contains the methods for this component to check the
 * arguments.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class DVHelper {
    /**
     * <p>
     * Private constructor to prevent this class being instantiated.
     * </p>
     */
    private DVHelper() {
        // does nothing
    }

    /**
     * <p>
     * Checks whether the given Object is not null.
     * </p>
     *
     * @param obj the argument to check
     * @param name the name of first argument
     * @return the Object passed in
     * @throws IllegalArgumentException if the given Object(obj) is null
     */
    public static Object validateNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException("[" + name + "] should not be null.");
        }

        return obj;
    }

    /**
     * <p>
     * Checks whether the given String is not empty(trimmed). It will do nothing
     * if the passed in string is null.
     * </p>
     *
     * @param str the String to check
     * @param name the name of first argument
     * @throws IllegalArgumentException if the given string empty string
     *             (trimmed)
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
     * @return the string passed in
     * @throws IllegalArgumentException if the given string is null or empty
     *             string (trimmed)
     */
    public static String validateString(String str, String name) {
        validateNotNull(str, name);

        validateEmpty(str, name);

        return str;
    }

    /**
     * <p>
     * Validates the given value is positive.
     * </p>
     *
     * @param value the value to check
     * @param name the name of first argument
     * @return the value passed in.
     * @throws IllegalArgumentException if value is not positive
     */
    public static int validatePositive(int value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException("[" + name + "] should  be positive.");
        }
        return value;
    }

    /**
     * <p>
     * Validates the given value is positive.
     * </p>
     *
     * @param value the value to check
     * @param name the name of first argument
     * @return the value passed in.
     * @throws IllegalArgumentException if value is not positive
     */
    public static double validatePositive(double value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException("[" + name + "] should  be positive.");
        }
        return value;
    }

    /**
     * <p>
     * Validates the given value is validated or not.
     * </p>
     *
     * @param type the argument to check
     * @param name the name of first argument
     * @return the Class type passed in
     * @throws IllegalArgumentException if any argument is null, or if the type
     *             is not subclass of
     *             com.topcoder.gui.diagramviewer.elements.Node or
     *             com.topcoder.gui.diagramviewer.edges.Edge
     */
    public static Class validateClassType(Class<?> type, String name) {
        validateNotNull(type, "type");
        if (Node.class.isAssignableFrom(type) || Edge.class.isAssignableFrom(type)) {
            return type;
        } else {
            throw new IllegalArgumentException("[" + name + "] should be the subclass of Node or Edge.");
        }
    }

    /**
     * <p>
     * configGet of namespace, if the property loads fail , return the
     * defaultValue.
     * </p>
     *
     * @param namespace the namespace passed in.
     * @param property the property will be loaded.
     * @param defaultValue the defaultValue of the property.
     * @return the value loaded from namespace ,if fail , return defaultValue
     * @throws IllegalArgumentException if any of the args is null or empty.
     * @throws ConfigurationException if the config error occurs.
     */
    public static String configGet(String namespace, String property, String defaultValue)
            throws ConfigurationException {
        validateString(namespace, "namespace");
        try {
            String ret = ConfigManager.getInstance().getString(namespace, property);
            return (ret == null || ret.trim().length() == 0) ? defaultValue : ret;
        } catch (UnknownNamespaceException e) {
            throw new ConfigurationException("configuration error occurs when loading " + property
                    + ": The namespace is unknown");
        }

    }

}
