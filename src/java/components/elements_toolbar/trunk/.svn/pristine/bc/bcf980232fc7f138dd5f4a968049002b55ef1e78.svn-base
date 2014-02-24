/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements.failuretests;

import java.io.File;
import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * This class provides helper method for the accuracy tests.
 * </p>
 * <p>
 * This class is made public as the accuracy tests classes are located in different packages.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public final class FailureTestHelper {

    /**
     * The namespace for this component's failure test.
     */
    public static final String NAMESPACE = "com.topcoder.gui.toolbars.elements.failuretests";

    /**
     * Failure tests configuration files location.
     */
    public static final String CONFIG_DIR = "test_files/failuretests/";

    /**
     * Private constructor to prevent instantiation.
     */
    private FailureTestHelper() {
    }

    /**
     * Loads a configuration in the given file into the given namespace with Configuration Manager.
     * 
     * @param namespace the namespace target
     * @param fileName the path of the configuration file
     * @throws Exception if any exception occurs
     */
    public static void loadConfig(String namespace, String fileName) throws Exception {
        ConfigManager configManager = ConfigManager.getInstance();
        File file = new File(fileName);

        if (configManager.existsNamespace(namespace)) {
            configManager.removeNamespace(namespace);
        }

        configManager.add(namespace, file.getCanonicalPath(), ConfigManager.CONFIG_XML_FORMAT);
    }

    /**
     * Removes all the loaded configuration from Configuration Manager.
     * 
     * @param namespace the namespace to be removed from Configuration Manager
     * @throws Exception if any exception occurs
     */
    public static void tearConfig() throws Exception {
        ConfigManager configManager = ConfigManager.getInstance();

        for (Iterator i = configManager.getAllNamespaces(); i.hasNext();) {
            String namespace = (String) i.next();

            if (configManager.existsNamespace(namespace)) {
                configManager.removeNamespace(namespace);
            }
        }
    }
}
