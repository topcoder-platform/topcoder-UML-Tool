/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.stresstests;

import java.io.File;
import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * This is the helper class for stress tests.
 * </p>
 *
 * @author Litteleken
 * @version 1.0
 */
public class StressTestHelper {

    /**
     * <p>
     * The times to run the methods for stress test.
     * </p>
     */
    public static final int TIMES = 100;

    /**
     * <p>
     * Initialize according to configuration file to construct the stress tests
     * environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public static void LoadConfig() throws ConfigManagerException {
        ClearConfig();
        ConfigManager configManager = ConfigManager.getInstance();
        configManager.add("stresstests" + File.separator + "config.xml");
    }

    /**
     * <p>
     * Clear the stress tests environment according to configuration file.
     * </p>
     *
     * @throws UnknownNamespaceException to JUnit
     */
    public static void ClearConfig() throws UnknownNamespaceException {
        ConfigManager configManager = ConfigManager.getInstance();

        for (Iterator iter = configManager.getAllNamespaces(); iter.hasNext();) {
            configManager.removeNamespace((String) iter.next());
        }

    }
}
