/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.model.accuracytests;

import java.io.File;
import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * Helper class for accuracy tests of this component.
 * </p>
 *
 * @author mittu
 * @version 1.0
 */
final class AccuracyTestHelper {

    /**
     * <p>
     * Represents the user directory.
     * </p>
     */
    static final String USER_DIR = System.getProperty("user.dir") + File.separator;

    /**
     * <p>
     * Represents the accuracy directory.
     * </p>
     */
    static final String ACCURACY_DIR = USER_DIR + "test_files" + File.separator + "accuracy" + File.separator;

    /**
     * <p>
     * This private constructor creates a new instance of <code>AccuracyTestHelper</code>.
     * </p>
     */
    private AccuracyTestHelper() {
        // empty
    }

    /**
     * <p>
     * Loads the given configuration file.
     * </p>
     *
     * @param file
     *            The file to be loaded
     * @param releaseConfig
     *            Boolean which indicates whether to release the loaded namespaces
     */
    static void loadConfig(String file, boolean releaseConfig) {
        if (releaseConfig) {
            releaseConfigs();
        }
        ConfigManager manager = ConfigManager.getInstance();
        try {
            manager.add(file);
        } catch (ConfigManagerException e) {
            // ignore
        }
    }

    /**
     * <p>
     * Releases all the configurations from the manager.
     * </p>
     *
     */
    static void releaseConfigs() {
        ConfigManager manager = ConfigManager.getInstance();
        for (Iterator iterator = manager.getAllNamespaces(); iterator.hasNext();) {
            try {
                manager.removeNamespace((String) iterator.next());
            } catch (UnknownNamespaceException e) {
                // ignore
            }
        }
    }

}
