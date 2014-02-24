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
import com.topcoder.gui.panels.properties.propertypanel.OwnerPropertyPanel;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for OwnerPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class OwnerPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * OwnerPropertyPanel instance for testing.
     * </p>
     */
    private OwnerPropertyPanel instance;

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
        instance = new OwnerPropertyPanel(propertiesPanel, new ImageIcon());
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
        return new TestSuite(OwnerPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor OwnerPropertyPanel#OwnerPropertyPanel(PropertiesPanel,Icon) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create OwnerPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests OwnerPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        instance.configurePanel(new OperationImpl());

        JComboBox comboBox = (JComboBox) AccuracyTestsHelper.getChildComponents(instance.retrievePanel(),
            JComboBox.class)[0];
        assertEquals("Failed to refresh panel.", -1, comboBox.getSelectedIndex());
    }

    /**
     * <p>
     * Tests OwnerPropertyPanel#execute() for accuracy.
     * </p>
     */
    public void testExecute() {
        instance.configurePanel(new OperationImpl());
        ModelElementChangeListenerMock listener = new ModelElementChangeListenerMock();
        propertiesPanel.addModelElementChangeListener(listener);
        instance.execute();

        assertFalse("Failed to execute.", listener.IsCalled());
    }

}