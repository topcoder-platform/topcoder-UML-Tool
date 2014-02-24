/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import com.topcoder.util.config.ConfigManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * The helper class provides utils for testing.
 *
 * @author lyt
 * @version 1.0
 */
public final class TestHelper {
/**
     * Private constructor prevent from instanciated.
     */
    private TestHelper() {
    }

    /**
     * Load the configuration files to ConfigManager.
     *
     * @throws Exception exception to the caller.
     */
    public static void loadConfig() throws Exception {
        ConfigManager.getInstance().add("config.xml");
    }

    /**
     * Clear all the configurations.
     *
     * @throws Exception exception to the caller.
     */
    public static void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator<String> it = cm.getAllNamespaces();
        List<String> nameSpaces = new ArrayList<String>();

        while (it.hasNext()) {
            nameSpaces.add(it.next());
        }

        for (int i = 0; i < nameSpaces.size(); i++) {
            cm.removeNamespace(nameSpaces.get(i));
        }
    }
}
