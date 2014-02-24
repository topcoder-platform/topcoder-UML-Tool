/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.stresstests;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.Assert;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * Helper class to simplify the test process.
 * </p>
 * @author Achilles_2005
 * @version 1.0
 */
public final class TestHelper {
    /**
     * <p>
     * Represents the configuration file.
     * </p>
     */
    public static final String CONFIG_FILE = "test_files/stress/Configuration.xml";
    /**
     * <p>
     * Private constructor to avoid creation.
     * </p>
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Load the given configuration file into the Configuration Manager.
     * </p>
     * @param file
     *            configuration file
     */
    public static void loadConfig(String file) {
        try {
            ConfigManager.getInstance().add(new File(file).getAbsolutePath());
        } catch (ConfigManagerException e) {
            // ignore
        }
    }

    /**
     * <p>
     * Clear all namespaces in the Configuration Manager.
     * </p>
     */
    public static void clearConfig() {
        ConfigManager mgr = ConfigManager.getInstance();
        Iterator itr = mgr.getAllNamespaces();
        while (itr.hasNext()) {
            String ns = (String) itr.next();
            try {
                mgr.removeNamespace(ns);
            } catch (UnknownNamespaceException e) {
                // ignore
            }
        }
    }
}
