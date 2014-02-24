/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader.accuracytests;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;

/**
 * Defines helper methods used in accuracy tests of this component.
 * @author FireIce
 * @version 1.0
 */
public class AccuracyTestHelper {

    /**
     * This private constructor prevents the creation of a new instance.
     */
    private AccuracyTestHelper() {
    }

    /**
     * Gets the value of a private field in the given class. The field has the given name. The value is retrieved from
     * the given instance. If the instance is null, the field is a static field. If any error occurs, null is returned.
     * @param type
     *            the class which the private field belongs to
     * @param instance
     *            the instance which the private field belongs to
     * @param name
     *            the name of the private field to be retrieved
     * @return the value of the private field
     */
    public static Object getPrivateField(Class type, Object instance, String name) {
        Field field = null;
        Object obj = null;
        try {
            // get the reflection of the field
            field = type.getDeclaredField(name);
            // set the field accessible
            field.setAccessible(true);
            // get the value
            obj = field.get(instance);
        } catch (NoSuchFieldException e) {
            // ignore
        } catch (IllegalAccessException e) {
            // ignore
        } finally {
            if (field != null) {
                // reset the accessibility
                field.setAccessible(false);
            }
        }
        return obj;
    }

    /**
     * Sets the value of a private field in the given class.
     * @param type
     *            the class which the private field belongs to
     * @param instance
     *            the instance which the private field belongs to
     * @param name
     *            the name of the private field to be set
     * @param value
     *            the value to set
     */
    public static void setPrivateField(Class type, Object instance, String name, Object value) {
        Field field = null;
        try {
            // get the reflection of the field
            field = type.getDeclaredField(name);
            // set the field accessible
            field.setAccessible(true);
            // set the value
            field.set(instance, value);
        } catch (NoSuchFieldException e) {
            // ignore
        } catch (IllegalAccessException e) {
            // ignore
        } finally {
            if (field != null) {
                // reset the accessibility
                field.setAccessible(false);
            }
        }
    }

    /**
     * <p>
     * Clear testing configuration.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public static void clearNamespaces() throws Exception {
        ConfigManager configManager = ConfigManager.getInstance();
        for (Iterator iter = configManager.getAllNamespaces(); iter.hasNext();) {
            configManager.removeNamespace((String) iter.next());
        }
    }

    /**
     * <p>
     * Load the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public static void loadNamespaces() throws Exception {
        clearNamespaces();

        ConfigManager.getInstance().add("accuracytests" + File.separator + "accuracy.xml");
    }

}
