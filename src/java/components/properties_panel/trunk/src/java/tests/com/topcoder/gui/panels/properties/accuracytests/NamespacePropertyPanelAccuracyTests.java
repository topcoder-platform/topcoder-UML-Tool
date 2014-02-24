/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.NamespacePropertyPanel;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for NamespacePropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class NamespacePropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * NamespacePropertyPanel instance for testing.
     * </p>
     */
    private NamespacePropertyPanel instance;

    /**
     * <p>
     * PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        propertiesPanel = new PropertiesPanel(new UMLModelManager());
        instance = new NamespacePropertyPanel(propertiesPanel, new ImageIcon());
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        instance = null;
        propertiesPanel = null;
        AccuracyTestsHelper.clearConfig();
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(NamespacePropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor NamespacePropertyPanel#NamespacePropertyPanel(PropertiesPanel,Icon) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create NamespacePropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests NamespacePropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        instance.configurePanel(new InterfaceImpl());

        JComboBox comboBox = (JComboBox) AccuracyTestsHelper.getChildComponents(instance.retrievePanel(),
            JComboBox.class)[0];

        assertEquals("Failed to refresh panel.", 0, comboBox.getSelectedIndex());
    }

    /**
     * <p>
     * Tests NamespacePropertyPanel#execute() for accuracy.
     * </p>
     */
    public void testExecute() {
        instance.configurePanel(new InterfaceImpl());
        ModelElementChangeListenerMock listener = new ModelElementChangeListenerMock();
        propertiesPanel.addModelElementChangeListener(listener);
        instance.execute();

        assertFalse("Failed to execute.", listener.IsCalled());
    }

}