/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins.html.failuretests;

import com.topcoder.configuration.ConfigurationObject;
import com.topcoder.configuration.defaults.DefaultConfigurationObject;

/**
 * Failure test helper.
 * @author peony
 * @version 1.0
 */
public class FailureTestHelper {
    /**
     * Create a correct config object for editor
     * @return the correct config object for editor
     * @throws Exception
     *             to JUnit
     */
    public static ConfigurationObject getEditorConfig() throws Exception {
        ConfigurationObject config = new DefaultConfigurationObject("root");

        ConfigurationObject def = new DefaultConfigurationObject("default");
        def.setPropertyValue("vsbPolicy", "21");
        def.setPropertyValue("hsbPolicy", "31");
        def.setPropertyValue("XSDPath", "test_files/failuretests/xhtml1-strict.xsd");
        def.setPropertyValue("toolBarClass",
            "com.topcoder.gui.panels.documentation.plugins.html.toolbars.DefaultHTMLDocumentationEditorToolBar");

        config.addChild(def);

        config.addChild(getToolBarConfig());
        return config;
    }

    /**
     * Create a correct config object for too bar.
     * @return the correct config object for too bar
     * @throws Exception
     *             to JUnit
     */
    public static ConfigurationObject getToolBarConfig() throws Exception {
        ConfigurationObject config = new DefaultConfigurationObject("toolBarConfig");
        config.setPropertyValue("cutImage", "test_files/failuretests/cut.png");
        config.setPropertyValue("copyImage", "test_files/failuretests/copy.png");
        config.setPropertyValue("pasteImage", "test_files/failuretests/paste.png");
        config.setPropertyValue("undoImage", "test_files/failuretests/undo.png");
        config.setPropertyValue("redoImage", "test_files/failuretests/redo.png");
        config.setPropertyValue("boldImage", "test_files/failuretests/bold.png");
        config.setPropertyValue("italicImage", "test_files/failuretests/italic.png");
        config.setPropertyValue("underlineImage", "test_files/failuretests/underline.png");
        config.setPropertyValues("fontSizeConfig", new String[] {"6", "30", "2"});
        return config;
    }
}
