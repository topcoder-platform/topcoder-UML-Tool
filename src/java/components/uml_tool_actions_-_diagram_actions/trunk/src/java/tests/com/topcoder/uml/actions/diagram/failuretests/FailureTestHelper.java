/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.failuretests;

import java.util.Iterator;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * Failure test helper.
 * </p>
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FailureTestHelper {

    /**
     * <p>
     * Represents config file path.
     * </P>
     */
    public static final String CONFIGFILE = System.getProperty("user.dir") + "/test_files/Config.xml";

    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private FailureTestHelper() {
    }

    /**
     * <p>
     * Sets up the config manager and the UML model manager for testing.
     * </p>
     * 
     * @throws Exception
     *             unexpected exception.
     */
    public static void setUp() throws Exception {
        tearDown();
        ConfigManager configManager = ConfigManager.getInstance();
        configManager.add(CONFIGFILE);
        configManager.add("Logging.xml");

        UMLModelManager manager = UMLModelManager.getInstance();
        ProjectConfigurationManager projectConfigurationManager = new ProjectConfigurationManager(manager);
        projectConfigurationManager.addInitialDiagramFormatter(projectConfigurationManager
            .getDefaultProjectLanguage(), new MockInitialDiagramElementFormatter());
        manager.setProjectConfigurationManager(projectConfigurationManager);
        manager.setProjectLanguage("Test");
    }

    /**
     * <p>
     * Clears the config.
     * </p>
     */
    public static void tearDown() {
        ConfigManager configManager = ConfigManager.getInstance();
        // remove all the name space from the config manager.
        for (Iterator iter = configManager.getAllNamespaces(); iter.hasNext();) {
            try {
                configManager.removeNamespace((String) iter.next());
            } catch (UnknownNamespaceException e) {
                // ignore
            }
        }
    }
}
