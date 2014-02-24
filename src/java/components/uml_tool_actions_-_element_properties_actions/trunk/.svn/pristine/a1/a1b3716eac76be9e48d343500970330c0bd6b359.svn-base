/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import java.lang.reflect.Field;
import com.topcoder.util.config.ConfigManager;

/**
 * Helper class of Accuracy Test.
 *
 * @author justforplay
 * @version 1.0
 */
public class AccuracyHelper {

    /**
     * Private constructor.
     */
    private AccuracyHelper() {
        // do nothing.
    }

    /**
     * Loads all configurations from CONFIG_FILE.
     */
    public static void loadDefaultConfig() {
        try {
            unloadConfig();

            ConfigManager.getInstance().add("accuracy_tests/Logging.xml");
        } catch (Exception exception) {
            System.err.println("Error while loading configuration" + exception.getMessage());
            // Ignore exception
        }
    }

    /**
     * Unloads all configurations from files.
     */
    public static void unloadConfig() {
        try {
            ConfigManager cm = ConfigManager.getInstance();
            if (cm.existsNamespace("com.topcoder.util.log")) {
                cm.removeNamespace("com.topcoder.util.log");
            }
        } catch (Exception exception) {
            System.err.println("Error while unloading configuration" + exception.getMessage());
            // Ignore exception

        }
    }

    /**
     * Returns the value of the given field in the given Object using Reflection.
     *
     * @param obj the given Object instance to get the field value.
     * @param fieldName the name of the filed to get value from the obj.
     * @return the field value in the obj.
     */
    public static Object getObjectFieldValue(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            return field.get(obj);
        } catch (SecurityException e) {
            // ignore
        } catch (NoSuchFieldException e) {
            // ignore
        } catch (IllegalArgumentException e) {
            // ignore
        } catch (IllegalAccessException e) {
            // ignore
        }

        return null;
    }

}
