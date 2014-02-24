/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins.html.stresstests;

import com.topcoder.configuration.ConfigurationObject;
import com.topcoder.configuration.persistence.ConfigurationFileManager;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditor;
import com.topcoder.gui.panels.documentation.plugins.html.toolbars.DefaultHTMLDocumentationEditorToolBar;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * <p>
 * Stress test cases for <code>DefaultHTMLDocumentationEditorToolBar</code> class.
 * </p>
 *
 * @author woodatxc
 * @version 1.0
 */
public class DefaultHTMLDocumentationEditorToolBarStressTest extends BaseStressTests {

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DefaultHTMLDocumentationEditorToolBarStressTest.class);
    }

    /**
     * <p>
     * Tests constructor
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject, HTMLDocumentationEditor)</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1() throws Exception {
        this.beginTest();

        ConfigurationFileManager configManager =
            new ConfigurationFileManager("test_files/stresstests_files/demopreload.properties");
        ConfigurationObject config = configManager.getConfiguration("test");
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(config);
        for (int i = 0; i < RUN_TIMES; i++) {
            new DefaultHTMLDocumentationEditorToolBar(config.getChild("toolBarConfig"), editor);
        }

        this.endTest("DefaultHTMLDocumentationEditorToolBar's "
                + "DefaultHTMLDocumentationEditorToolBar(ConfigurationObject, HTMLDocumentationEditor)", 10000);
    }
}
