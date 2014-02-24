/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * Helper class for the project configuration component.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public final class Util {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private Util() {
        // empty
    }

    /**
     * <p>
     * Checks whether the given Object is null.
     * </p>
     *
     * @param arg the argument to check
     * @param name the name of the argument to check
     *
     * @throws IllegalArgumentException if the given Object is null
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
     * @param arg the String to check
     * @param name the name of the String argument to check
     *
     * @throws IllegalArgumentException if the given string is null or empty
     */
    public static void checkString(String arg, String name) {
        checkNull(arg, name);

        if (arg.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty.");
        }
    }

    /**
     * <p>
     * Return the value of the property.
     * </p>
     *
     * @param namespace the namespace to get the property value from.
     * @param propertyName the name of property
     *
     * @return the value of the property
     *
     * @throws ProjectConfigurationException if fail to load the config values.
     * @throws IllegalArgumentException if the given parameter is null or empty
     */
    public static String getString(String namespace, String propertyName)
        throws ProjectConfigurationException {
        checkString(namespace, "namespace");
        checkString(propertyName, "propertyName");

        String property;
        try {
            property = ConfigManager.getInstance().getString(namespace, propertyName);
        } catch (UnknownNamespaceException e) {
            throw new ProjectConfigurationException("UnknownNamespaceException occurs "
                + "when accessing ConfigManager.", e);
        }

        // Property is missed
        if (property == null) {
            throw new ProjectConfigurationException("Missed property: " + propertyName);
        }

        // Empty property value is not allowed
        if ((property.trim().length() == 0)) {
            throw new ProjectConfigurationException("Property " + propertyName + " is empty.");
        }

        return property;
    }
}