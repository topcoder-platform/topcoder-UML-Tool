/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import javax.swing.JFormattedTextField;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.NamePropertyPanel;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for NamePropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class NamePropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * NamePropertyPanel instance for testing.
     * </p>
     */
    private NamePropertyPanel instance;

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
        instance = new NamePropertyPanel(propertiesPanel);
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
        return new TestSuite(NamePropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor NamePropertyPanel#NamePropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create NamePropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests NamePropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        Transition element = new TransitionImpl();
        element.setName("NameProperty");
        instance.configurePanel(element);

        JFormattedTextField textField = (JFormattedTextField) AccuracyTestsHelper.getChildComponents(
            instance.retrievePanel(), JFormattedTextField.class)[0];
        assertEquals("Failed to refresh panel.", "NameProperty", textField.getText());
        assertEquals("Failed to refresh panel.", "NameProperty", textField.getValue());
    }

    /**
     * <p>
     * Tests NamePropertyPanel#execute() for accuracy.
     * </p>
     */
    public void testExecute() {
        instance.configurePanel(new AssociationEndImpl());
        ModelElementChangeListenerMock listener = new ModelElementChangeListenerMock();
        propertiesPanel.addModelElementChangeListener(listener);
        instance.execute();

        assertTrue("Failed to execute.", listener.IsCalled());
    }

}