/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.accuracytests;

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
public final class AccuracyTestHelper {

    /**
     * The namespace for the component.
     */
    public static final String NAMESPACE = "com.topcoder.swing.print.accuracytests";
    
    /**
     * The namespace for ObjectFactory.
     */
    public static final String NAMESPACE_OF = "com.topcoder.swing.print.accuracytests.of";

    /**
     * The config file for the component.
     */
    public static final String CONFIGPATH = "test_files/AccuracyTests_PM.xml";
    
    /**
     * The config file for the object factory.
     */
    public static final String CONFIGPATH_OF = "test_files/AccuracyTests_OF.xml";

    /**
     * Private constructor to prevent instantiation.
     */
    private AccuracyTestHelper() {
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
