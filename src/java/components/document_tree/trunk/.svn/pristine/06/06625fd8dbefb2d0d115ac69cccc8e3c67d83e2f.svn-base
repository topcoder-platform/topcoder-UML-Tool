/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.failuretests;

import java.util.Iterator;

import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.impl.DocumentTreePanelImpl;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * Failure test helper.
 * </p>
 *
 * @author stylecheck
 * @version 1.0
 */
public class FailureTestHelper {
    /** The namespace used for the class. */
    public static final String NAMESPACE = "com.topcoder.gui.trees.document.impl";

    /** Current User Directory. */
    public static final String TEMP = System.getProperty("user.dir");

    /** Test Files Directory. */
    public static final String TEST_FILES_DIR = TEMP + "/test_files/failureTest/";

    /**
     * <p>
     * Represents config file path.
     * </P>
     */
    public static final String CONFIGFILE = TEST_FILES_DIR + "Config.xml";

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

        UMLModelManager manager = UMLModelManager.getInstance();
        ProjectConfigurationManager projectConfigurationManager = new ProjectConfigurationManager(manager);
        projectConfigurationManager.addInitialDiagramFormatter(projectConfigurationManager
            .getDefaultProjectLanguage(), new MockInitialDiagramElementFormatter());
        manager.setProjectConfigurationManager(projectConfigurationManager);
        manager.setProjectLanguage("Test");
    }

    /**
     * <p>
     * This method reloads the config file from the given location.
     * </p>
     *
     * @param sFileName
     *            the location configuration file to be taken.
     */
    public static void reSetup(String sFileName) {
        tearDown();
        try {
            ConfigManager.getInstance().add(TEST_FILES_DIR + sFileName);
        } catch (ConfigManagerException e) {
            // ignore
        }
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

    /**
     * <p>
     * Creates a new document tree panel.
     * </p>
     *
     * @return the created document tree panel.
     */
    public static DocumentTreePanel getTreePanel() {
        return new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
            FailureTestHelper.NAMESPACE), FailureTestHelper.NAMESPACE);
    }
}
