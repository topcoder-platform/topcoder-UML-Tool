/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.failuretests;

import com.topcoder.util.config.ConfigManager;

import java.io.File;

import java.util.Iterator;


/**
 * Test Helper for the component.
 *
 * @author crackme
 * @version 1.0
 */
public final class TestHelper {
    /**
     * Private test helper.
     */
    private TestHelper() {
    }

    /**
     * Load a config file to ConfigManager.
     *
     * @param file the file to load
     * @throws Exception exception to the caller.
     */
    public static void loadConfigFile(String file) throws Exception {
        clearConfig();
        ConfigManager.getInstance().add(new File(file).getAbsolutePath());
    }

    /**
     * Clear all the config files.
     *
     * @throws Exception exception to the caller.
     */
    public static void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        Iterator it = cm.getAllNamespaces();

        while (it.hasNext()) {
            String s = (String) it.next();

            if (cm.existsNamespace(s)) {
                cm.removeNamespace(s);
            }
        }
    }
}
