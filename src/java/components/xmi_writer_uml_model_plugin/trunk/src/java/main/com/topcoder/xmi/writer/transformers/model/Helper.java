/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * This Helper Class of this component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class Helper {
    /**
     * <p>
     * The private constructor of the helper class.
     * </p>
     *
     */
    private Helper() {
        //empty
    }

    /**
    * Checks whether the given Object is null.
    *
    * @param arg the argument to check
    * @param name the name of the argument
    * @throws IllegalArgumentException if the given Object is null
    */
    public static void checkNull(Object arg, String name) {
        if (arg == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * Checks whether the given String is empty.
     *
     * @param arg the String to check
     * @param name the name of the argument
     * @throws IllegalArgumentException if the given string is trimmed empty or null
     */
    public static void checkEmptyAndNullString(String arg, String name) {
        checkNull(arg, name);

        if (arg.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty.");
        }
    }
    /**
     * Gets the string property value of the property name. When the property is mandatory, it must exist in the
     * configuration manager.
     *
     * @param namespace the namespace where the configuration is read.
     * @param propertyName the property name of the property to be read.
     * @return the string value of the property in the configuration.
     * @throws ConfigurationException if <code>namespace</code> is missing in configuration;
     * or the property is missing in the configuration and the property is mandatory.
     */
    public static String getRequiredConfigProperty(String namespace, String propertyName)
        throws ConfigurationException {
        try {
            String value = ConfigManager.getInstance().getString(namespace, propertyName);

            // Check the missing and empty
            if ((value == null || value.trim().length() == 0)) {
                throw new ConfigurationException(propertyName + " is missing in configuration.");
            }
            return value;
        } catch (UnknownNamespaceException e) {
            //wrap the UnknownNamespaceException by ConfigurationException
            throw new ConfigurationException("The namespace " + namespace + " doesn't not exist.", e);
        }
    }
    /**
     * <p>
     * Update the String, replace its first char with its according low case.
     * </p>
     *
     * @param intiString the String to be set the first letter to low case
     * @return the updated String whose first letter it updated to low case
     */
    public static String firstLetterToLowCase(String intiString) {
        if (intiString.length() == 0) {
            return intiString;
        }
        //replace the first Cahracter by its according low case
        return Character.toLowerCase(intiString.charAt(0)) + intiString.substring(1);
    }
}
