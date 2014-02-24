/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins.html.accuracytests;

import javax.swing.JFrame;

import com.topcoder.configuration.persistence.ConfigurationFileManager;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditor;

import junit.framework.TestCase;

/**
 * Accuracy test for {@link HTMLDocumentationEditor}.
 *
 * @author iRabbit
 * @version 1.0
 */
public class HTMLDocumentationEditorAccuracyTests extends TestCase {

    /**
     * {@link HTMLDocumentationEditor} used in testing.
     */
    private HTMLDocumentationEditor instance;

    /**
     * Accuracy test for {@link HTMLDocumentationEditor#HTMLDocumentationEditor(String)}. use minimum configuration.
     *
     * @throws Exception to junit
     */
    public void testCtorString_Accuracy1() throws Exception {
        instance = new HTMLDocumentationEditor("accuracy_tests1");
        JFrame frame = new JFrame();
        frame.add(instance);
        instance.setVisible(true);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.validate();
        Thread.sleep(5000);
    }

    /**
     * Accuracy test for {@link HTMLDocumentationEditor#HTMLDocumentationEditor(String)}. use full configuration.
     *
     * @throws Exception to junit
     */
    public void testCtorString_Accuracy2() throws Exception {
        instance = new HTMLDocumentationEditor("accuracy_tests2");
        JFrame frame = new JFrame();
        frame.add(instance);
        instance.setVisible(true);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.validate();
        Thread.sleep(5000);
    }

    /**
     * Accuracy test for {@link HTMLDocumentationEditor#HTMLDocumentationEditor(ConfigurationObject)}. use minimum
     * configuration.
     *
     * @throws Exception to junit
     */
    public void testCtorConfigurationObject_Accuracy1() throws Exception {
        ConfigurationFileManager configManager = new ConfigurationFileManager();
        instance = new HTMLDocumentationEditor(configManager.getConfiguration("accuracy_tests1"));
        JFrame frame = new JFrame();
        frame.add(instance);
        instance.setVisible(true);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.validate();
        Thread.sleep(5000);
    }

    /**
     * Accuracy test for {@link HTMLDocumentationEditor#HTMLDocumentationEditor(ConfigurationObject)}. use full
     * configuration.
     *
     * @throws Exception to junit
     */
    public void testCtorConfigurationObject_Accuracy2() throws Exception {
        ConfigurationFileManager configManager = new ConfigurationFileManager();
        instance = new HTMLDocumentationEditor(configManager.getConfiguration("accuracy_tests2"));
        JFrame frame = new JFrame();
        frame.add(instance);
        instance.setVisible(true);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.validate();
        Thread.sleep(5000);
    }
}
