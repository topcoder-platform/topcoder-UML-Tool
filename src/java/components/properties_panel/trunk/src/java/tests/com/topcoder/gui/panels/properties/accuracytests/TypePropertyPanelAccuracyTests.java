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
import com.topcoder.gui.panels.properties.propertypanel.TypePropertyPanel;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * <p>
 * Accuracy Unit test cases for TypePropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class TypePropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * TypePropertyPanel instance for testing.
     * </p>
     */
    private TypePropertyPanel instance;

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
        UMLModelManager.getInstance().setProjectConfigurationManager(
            new ProjectConfigurationManager(UMLModelManager.getInstance()));
        propertiesPanel = new PropertiesPanel(UMLModelManager.getInstance());
        instance = new TypePropertyPanel(propertiesPanel, new ImageIcon());
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
        return new TestSuite(TypePropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor TypePropertyPanel#TypePropertyPanel(PropertiesPanel,Icon) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create TypePropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests TypePropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        Parameter parameter = new ParameterImpl();
        Namespace ns = new PackageImpl();
        Interface type = new InterfaceImpl();
        type.setName("MyType");
        ns.addOwnedElement(type);
        parameter.setType(type);

        propertiesPanel.getUMLModelManager().getModel().addOwnedElement(ns);

        instance.configurePanel(parameter);

        JComboBox comboBox = (JComboBox) AccuracyTestsHelper.getChildComponents(instance.retrievePanel(),
            JComboBox.class)[0];

        assertEquals("Failed to refresh panel correctly.", "MyType", comboBox.getSelectedItem().toString());
    }

    /**
     * <p>
     * Tests TypePropertyPanel#execute() for accuracy.
     * </p>
     */
    public void testExecute() {
        instance.configurePanel(new AttributeImpl());
        ModelElementChangeListenerMock listener = new ModelElementChangeListenerMock();
        propertiesPanel.addModelElementChangeListener(listener);
        instance.execute();

        assertTrue("Failed to execute.", listener.IsCalled());
    }

}