/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * This is the helper class for unit tests.
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
     * Removes all namespaces.
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
     * loads the configuration file.
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
}