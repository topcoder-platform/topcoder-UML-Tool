/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;
import com.topcoder.util.config.UnknownNamespaceException;

import java.util.Iterator;


/**
 * Helper class for loading and clearing config.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class TestHelper {
    /** Default config files used in test. */
    private static final String[] CONFIG_FILES = { "ObjectFactory.xml", "PrintManager.xml" };

    /**
     * Private ctor preventing this class from being instantiated.
     */
    private TestHelper() {
    }

    /**
     * Clear all namespace.
     *
     * @throws UnknownNamespaceException if any error occurs
     */
    public static void clearConfig() throws UnknownNamespaceException {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator iter = cm.getAllNamespaces();

        while (iter.hasNext()) {
            cm.removeNamespace((String) iter.next());
        }
    }

    /**
     * Load all config files predefined in CONFIG_FILES.
     *
     * @throws ConfigManagerException if any error occurs
     */
    public static void loadConfig() throws ConfigManagerException {
        ConfigManager cm = ConfigManager.getInstance();

        for (int i = 0; i < CONFIG_FILES.length; i++) {
            cm.add(CONFIG_FILES[i]);
        }
    }
}
