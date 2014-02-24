/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * <p>
 * This is a Base TestCase which does the configuration job.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class BaseTestCase extends TestCase {
    /**
     * <p>
     * String representing the namespace for log.
     * </p>
     */
    protected static final String LOG_NAMESPACE = "com.topcoder.util.log";

    /**
     * <p>
     * String representing the default configuration file using BasicLog.
     * </p>
     */
    protected static final String DEFUALT_LOGGING_FILE = "Logging.xml";


    /**
     * <p>
     * String representing the project Language of the UMLModelManager.
     * </p>
     */
    protected static final String PROJECT_LANGUAGE = "project Language";


    /**
     * <p>
     * UMLModelManager instance used for testing.
     * </p>
     */
    protected static final UMLModelManager UML_MODEL_MANAGER = UMLModelManager.getInstance();

    /**
     * <p>
     * Sets up environment.
     * </p>
     * @throws Exception to Junit
     */
    protected void setUp() throws Exception {
        ConfigManager.getInstance().add(DEFUALT_LOGGING_FILE);
        ConfigManager.getInstance().add("Config.xml");
        UML_MODEL_MANAGER.setProjectConfigurationManager(new ProjectConfigurationManager(UML_MODEL_MANAGER));
        UML_MODEL_MANAGER.setProjectLanguage(PROJECT_LANGUAGE);
    }

    /**
     * <p>
     * Tears Down environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    protected void tearDown() throws Exception {
        ConfigManager configManager = ConfigManager.getInstance();
        if (configManager.existsNamespace(LOG_NAMESPACE)) {
            configManager.removeNamespace(LOG_NAMESPACE);
        }
        if (configManager.existsNamespace("com.topcoder.uml.projectconfiguration.ProjectConfigurationManager")) {
            configManager.removeNamespace("com.topcoder.uml.projectconfiguration.ProjectConfigurationManager");
        }
        if (configManager.existsNamespace("com.topcoder.uml.projectconfiguration.ProjectConfigurationManager.objectfactory")) {
            configManager.removeNamespace("com.topcoder.uml.projectconfiguration.ProjectConfigurationManager.objectfactory");
        }
        UML_MODEL_MANAGER.setProjectLanguage(null);
        UML_MODEL_MANAGER.clearActivityGraphs();
        UML_MODEL_MANAGER.clearDiagrams();
        UML_MODEL_MANAGER.getModel().clearOwnedElements();
    }
}
