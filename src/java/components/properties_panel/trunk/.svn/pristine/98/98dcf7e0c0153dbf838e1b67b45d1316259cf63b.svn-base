/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import javax.swing.JRadioButton;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.VisibilityPropertyPanel;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for VisibilityPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class VisibilityPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * VisibilityPropertyPanel instance for testing.
     * </p>
     */
    private VisibilityPropertyPanel instance;

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
        instance = new VisibilityPropertyPanel(propertiesPanel);
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
        return new TestSuite(VisibilityPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor VisibilityPropertyPanel#VisibilityPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create VisibilityPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests VisibilityPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        AssociationEnd element = new AssociationEndImpl();
        element.setVisibility(VisibilityKind.PROTECTED);
        instance.configurePanel(element);

        JRadioButton button = (JRadioButton) AccuracyTestsHelper.getChildComponents(instance.retrievePanel(),
            JRadioButton.class)[1];
        assertTrue("Failed to refresh panel.", button.isSelected());
    }

    /**
     * <p>
     * Tests VisibilityPropertyPanel#execute() for accuracy.
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