/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import java.awt.Component;

import javax.swing.JCheckBox;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.ModifiersPropertyPanel;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for ModifiersPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class ModifiersPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * ModifiersPropertyPanel instance for testing.
     * </p>
     */
    private ModifiersPropertyPanel instance;

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
        instance = new ModifiersPropertyPanel(propertiesPanel);
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
        return new TestSuite(ModifiersPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor ModifiersPropertyPanel#ModifiersPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create ModifiersPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests ModifiersPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        Package element1 = new PackageImpl();
        instance.configurePanel(element1);

        Component[] checkBoxes = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JCheckBox.class);
        assertEquals("Failed to refresh the panel for the PackageImpl model element.", 3, checkBoxes.length);
    }

    /**
     * <p>
     * Tests ModifiersPropertyPanel#execute() for accuracy.
     * </p>
     */
    public void testExecute() {
        instance.execute();
    }
}
