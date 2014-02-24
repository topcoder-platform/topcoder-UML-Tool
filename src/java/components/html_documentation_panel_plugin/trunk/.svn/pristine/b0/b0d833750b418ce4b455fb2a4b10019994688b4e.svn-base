/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins.html.stresstests;

import com.topcoder.configuration.ConfigurationObject;
import com.topcoder.configuration.persistence.ConfigurationFileManager;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditor;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * <p>
 * Stress test cases for <code>HTMLDocumentationEditor</code> class.
 * </p>
 *
 * @author woodatxc
 * @version 1.0
 */
public class HTMLDocumentationEditorStressTest extends BaseStressTests {

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
        return new TestSuite(HTMLDocumentationEditorStressTest.class);
    }

    /**
     * <p>
     * Tests constructor <code>HTMLDocumentationEditor(String)</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1() throws Exception {
        this.beginTest();

        for (int i = 0; i < RUN_TIMES; i++) {
            new HTMLDocumentationEditor("testNamespace");
        }

        this.endTest("HTMLDocumentationEditor's HTMLDocumentationEditor(String)", 10000);
    }

    /**
     * <p>
     * Tests constructor <code>HTMLDocumentationEditor(ConfigurationObject)</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor2() throws Exception {
        this.beginTest();

        ConfigurationFileManager configManager =
            new ConfigurationFileManager("test_files/stresstests_files/demopreload.properties");
        ConfigurationObject config = configManager.getConfiguration("test");
        for (int i = 0; i < RUN_TIMES; i++) {
            new HTMLDocumentationEditor(config);
        }

        this.endTest("HTMLDocumentationEditor's HTMLDocumentationEditor(ConfigurationObject)", 10000);
    }
}
