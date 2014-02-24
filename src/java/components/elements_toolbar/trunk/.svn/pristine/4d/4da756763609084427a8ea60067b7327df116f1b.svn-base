/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements.stresstests;

import java.lang.reflect.Field;
import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * Helper class for JUnits.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class StressTestsHelper {
    /**
     * <p>
     * Represents the configManager instance.
     * </p>
     */
    private static final ConfigManager cm = ConfigManager.getInstance();

    /**
     * <p>
     * This private constructor creates a new instance of this Test helper.
     * </p>
     */
    private StressTestsHelper() {
        // Empty
    }

    /**
     * <p>
     * Loads the given configuration file.
     * </p>
     *
     * @param file
     *            The file to be loaded.
     * @throws Exception
     *            Exception to JUnit.
     */
    static void loadSingleFile(String file) throws Exception {
        configClear();
        cm.add(file);
    }

    /**
     * <p>
     * Releases all the configurations from the <code>ConfigManager</code>.
     * </p>
     */
    static void configClear() {
        for (Iterator it = cm.getAllNamespaces(); it.hasNext();) {
            try {
                cm.removeNamespace((String) it.next());
            } catch (UnknownNamespaceException e) {
                // Ignore
            }
        }
    }

    /**
     * <p>
     * Used to get the fields described in a class.
     * </p>
     *
     * @param object
     *            The object in which the attribute must be searched.
     * @param attributeName
     *            The name of the attribute.
     * @return returns <code>null</code> if no associated attribute found else returns the obtained attribute.
     *
     * @throws IllegalArgumentException
     *             If <code>object</code> or attribute name is <code>null</code> or if the exception is thrown if
     *             <code>Field.get(Object)</code> throws.
     * @throws IllegalAccessException
     *             If the passed field is inaccessible.
     */
    static Object getClassAttribute(Object object, String attributeName) throws IllegalAccessException {
        if (object == null || attributeName == null) {
            throw new IllegalArgumentException("Either object or attributeName can't be null.");
        }
        Field fields[] = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (attributeName.equalsIgnoreCase(field.getName())) {
                field.setAccessible(true);
                return field.get(object);
            }
        }
        return null;
    }
}
