/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.failuretests;

import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;

/**
 * DOCUMENT ME!
 *
 * @author TCSDEVELOPER
 * @version 1.0
 * @since Dec 26, 2006
 */
public class Helper {
    /**
     * Constant represents the namespace prefix that will be used in failure tests.
     */
    public static final String TAG_OPTION_MANAGER_NAMESPACE_PREFIX = "tagOptions_invalid_";
    /**
     * Constant represents the namespace prefix that will be used in failure tests.
     */
    public static final String DOC_EDITOR_NAMESPACE_PREFIX = "defaultDocEditor_";
    /**
     * Constant represents the namespace prefix that will be used in failure tests.
     */
    public static final String TAG_EDITOR_NAMESPACE_PREFIX = "defaultTagEditor_Invalid_";
    /**
     * Constant represents the namespace prefix that will be used in failure tests.
     */
    public static final String DOC_PANEL_NAMESPACE_PREFIX = "docPanel_Invalid_";

    /**
     * Namespace for component.
     */
    public static final String NAMESPACE = "docPanelNamespace";
    /**
     * Tag option manager config file.
     */
    public static final String TAG_OPTION_MANAGER_CONFIG_FILE = "failuretests/tagOptions.xml";
    /**
     * Default editor config files.
     */
    public static final String DOC_EDITOR_CONFIG_FILE = "failuretests/docEditor.xml";
    /**
     * Tag editor config file.
     */
    public static final String TAG_EDITOR_CONFIG_FILE = "failuretests/tagEditor.xml";
    /**
     * Doc panel config file invalid.
     */
    public static final String DOC_PANEL_CONFIG_FILE = "failuretests/docPanel.xml";

    /**
     * Doc panel config file valid.
     */
    public static final String CONFIG_FILE = "failuretests/config.xml";
    /**
     * Empty constructor.
     */
    private Helper() {
        //empty
    }
    /**
     * <p>
     * Loads the configuration namespaces.
     * </p>
     *
     * @param file config file
     * @throws ConfigManagerException to JUnit
     */
    public static void addConfigFile(String file) throws ConfigManagerException {
        ConfigManager cm = ConfigManager.getInstance();
        cm.add(file);
    }

    /**
     * <p>
     * Remove all namespaces from config manager.
     * </p>
     *
     * @throws ConfigManagerException to JUnit
     */
    public static void clearConfiguration() throws ConfigManagerException {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator it = cm.getAllNamespaces();

        while (it.hasNext()) {
            cm.removeNamespace((String) it.next());
        }
    }
}
