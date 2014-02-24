/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter.failuretests;

import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * A helper class to perform those common operations which are helpful for the test.
 * </p>
 *
 * @author iamajia
 * @version 1.0
 */
public class FailureTestHelper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private FailureTestHelper() {
    }

    /**
     * <p>
     * Use the given file to config the configuration manager.
     * </p>
     *
     * @param fileName config file to set up environment
     *
     * @throws Exception when any exception occurs
     */
    public static void loadSingleXMLConfig(String fileName) throws Exception {
        clearConfigFile();

        //set up environment
        ConfigManager config = ConfigManager.getInstance();

        config.add(fileName);
    }

    /**
     * <p>
     * Clear all the namespaces from the configuration manager.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public static void clearConfigFile() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator i = cm.getAllNamespaces(); i.hasNext();) {
            cm.removeNamespace((String) i.next());
        }
    }
}
