/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * This is a Helper class for Failure Test. It contains methods for loading and
 * unloading the namespaces.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
final class Helper {
    /**
     * <p>
     * Private constructor to prevent this class from being instantiated.
     * </p>
     */
    private Helper() {
    }

    /**
     * <p>
     * Loads the config file.
     * </p>
     *
     * @throws Exception if any exception occurs
     */
    public static void loadConfig() throws Exception {
        ConfigManager.getInstance().add("config.xml");
    }

    /**
     * <p>
     * Removes all namespaces.
     * </p>
     *
     * @throws Exception if any exception occurs
     */
    public static void unloadConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator it = cm.getAllNamespaces(); it.hasNext();) {
            cm.removeNamespace((String) it.next());
        }
    }
}
