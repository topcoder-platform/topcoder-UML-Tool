/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import com.topcoder.util.config.ConfigManager;

import java.io.File;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Test Helper for the component.
 *
 * @author icyriver
 * @version 1.0
 */
final class TestHelper {
    /**
     * <p>
     * Private test helper.
     * </p>
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Config the <code>UMLModelManager</code> for accuracy tests.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public static void configUMLModelManager() throws Exception {
        // clean the ConfigManager.
        clearConfig();
        ConfigManager cm = ConfigManager.getInstance();
        cm.add("Config.xml");
        UMLModelManager manager = UMLModelManager.getInstance();
        ProjectConfigurationManager configManager = new ProjectConfigurationManager(manager);
        manager.setProjectConfigurationManager(configManager);
        manager.setProjectLanguage("Java");
        // clean the UMLModelManager for test.
        manager.clearActivityGraphs();
        manager.clearDiagrams();
        clearConfig();
    }

    /**
     * <p>
     * Load the xml file for <code>logging_wrapper</code>.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public static void loadLogFile() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        cm.add("accuracytests" + File.separator + "Logging.xml");
        cm.add("Config.xml");
    }

    /**
     * Clear all the configs.
     *
     * @throws Exception exception to the caller.
     */
    static void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator it = cm.getAllNamespaces();
        List nameSpaces = new ArrayList();

        while (it.hasNext()) {
            nameSpaces.add(it.next());
        }

        for (int i = 0; i < nameSpaces.size(); i++) {
            cm.removeNamespace((String) nameSpaces.get(i));
        }
    }
}
