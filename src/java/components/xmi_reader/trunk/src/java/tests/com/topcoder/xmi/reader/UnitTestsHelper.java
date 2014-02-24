/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import com.topcoder.util.config.ConfigManager;

import java.lang.reflect.Field;


/**
 * <p>
 * This class provides methods for testing use.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class UnitTestsHelper {
    /**
     * Private constructor to prevent this class being instantiated.
     */
    private UnitTestsHelper() {
        // Does nothing.
    }

    /**
     * Returns the value of the given field in the given Object using Reflection.
     *
     * @param obj the given Object instance to get the field value.
     * @param fieldName the name of the filed to get value from the obj.
     *
     * @return the field value in the obj.
     *
     * @throws Exception if any error occurs
     */
    public static Object getObjectFieldValue(Object obj, String fieldName)
        throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);

        field.setAccessible(true);

        return field.get(obj);
    }

    /**
     * Loads all configurations from files with given file name.
     *
     * @param file the file to loaded from.
     *
     * @throws Exception when error occurs
     */
    public static void loadConfig(String file) throws Exception {
        unloadConfig();

        ConfigManager cm = ConfigManager.getInstance();
        cm.add(file);
    }

    /**
     * Unloads the configurations.
     *
     * @throws Exception when error occurs
     */
    public static void unloadConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        if (cm.existsNamespace(XMIReader.DEFAULT_NAMESPACE)) {
            cm.removeNamespace(XMIReader.DEFAULT_NAMESPACE);
        }
    }
}
