/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import java.io.File;
import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * ConfigHelper provides Configuration load/clear.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
final class ConfigHelper {

    /**
     * <p>
     * Path of the configration base directory.
     * </p>
     */
    static final String ACC_CONFIG_PATH = "test_files" + File.separator + "accuracytests" + File.separator;

    /**
     * <p>
     * Path of the configration file.
     * </p>
     */
    static final String ACC_CONFIG_FILE = ACC_CONFIG_PATH + "AccuracyTestConfig.xml";

    /**
     * <p>
     * Namespace for configuration.
     * </p>
     */
    static final String ACC_NAMESPACE = "com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracy";

    /**
     * <p>
     * Private constructor prevents self instantiation.
     * </p>
     */
    private ConfigHelper() {
        // empty
    }

    /**
     * <p>
     * Uses the given file to config the configuration manager.
     * </p>
     *
     * @param fileName
     *            config file to set up environment
     * @throws Exception
     *             when any exception occurs
     */
    static void loadXMLConfigrationFile(String file) throws Exception {
        clearConfigration();
        File configFile = new File(file);
        ConfigManager configManager = ConfigManager.getInstance();
        configManager.add(configFile.getCanonicalPath());
    }

    /**
     * <p>
     * Clears all the namespaces from the configuration manager.
     * </p>
     */
    static void clearConfigration() throws UnknownNamespaceException {
        ConfigManager configManager = ConfigManager.getInstance();
        for (Iterator i = configManager.getAllNamespaces(); i.hasNext();) {
            configManager.removeNamespace((String) i.next());
        }
    }
}
