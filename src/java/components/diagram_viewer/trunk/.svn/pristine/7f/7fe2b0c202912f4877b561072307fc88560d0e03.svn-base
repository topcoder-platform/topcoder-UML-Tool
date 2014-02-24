/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests;

import java.io.File;
import java.util.Iterator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * This is the helper class for accuracy tests.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public final class AccuracyTestsHelper {
    /**
     * <p>
     * Represents the accuracy test files DIR.
     * </p>
     */
    public static String DIR ="accuracyTests" + File.separator;

    /**
     * <p>
     * Represents the default config file path.
     * </p>
     */
    public static String DefaultConfig = DIR + "AccuracyDefaultConfig.xml";

    /**
     * <p>
     * Private constructor to prevent this class being instantiated.
     * </p>
     */
    private AccuracyTestsHelper() {
        // Does nothing.
    }

    /**
     * <p>
     * Removes all namespaces.
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    public static void removeAllNamespaces() throws Exception {
        ConfigManager manager = ConfigManager.getInstance();
        for (Iterator it = manager.getAllNamespaces(); it.hasNext();) {
            manager.removeNamespace((String) it.next());
        }
    }

    /**
     * <p>
     * loads the configuration file.
     * </p>
     *
     * @param filename
     *            the filename to load the configuration from
     * @throws Exception
     *             when error occurs
     */
    public static void loadConfig(String filename) throws Exception {
        removeAllNamespaces();
        ConfigManager.getInstance().add(filename);
    }

    /**
     * <p>
     * Invokes a method using reflection, pass out exception from invoked method.
     * </p>
     *
     * @param obj the object to invoke on
     * @param type the type of obj
     * @param name the name of the method
     * @param parameterTypes the parameter types of the method
     * @param parameters the parameters
     * @return the return value, or null if the method is a void-return one
     * @throws Exception if any error happens.
     */
    public static Object invokeMethod(Object obj, Class type, String name,
            Class[] parameterTypes, Object[] parameters) throws Exception {

        Method  method = type.getDeclaredMethod(name, parameterTypes);

        try {
            // check isAccessible
            if (method.isAccessible()) {
                return method.invoke(obj, parameters);
            } else {
                try {
                    method.setAccessible(true);

                    return method.invoke(obj, parameters);
                } finally {
                    // set isAccessible back
                    method.setAccessible(false);
                }
            }
        } catch (InvocationTargetException ite) {
            // pass out exception from invoked method.
            throw (Exception) ite.getCause();
        }
    }

    /**
     * Creates an object using relection.
     *
     * @param type the type of the class
     * @param parameterTypes the types of parameter
     * @param parameters the parameters
     * @return the object created
     * @throws Exception to invoker
     */
    public static Object createInstance(Class type, Class[] parameterTypes, Object[] parameters)
        throws Exception {
        Constructor ctor = type.getDeclaredConstructor(parameterTypes);

        if (!ctor.isAccessible()) {
            // check isAccessible before new
            try {
                ctor.setAccessible(true);
                return ctor.newInstance(parameters);
            } finally {
                // check isAccessible back
                ctor.setAccessible(false);
            }
        } else {
            return ctor.newInstance(parameters);
        }
    }
}