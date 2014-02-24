/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import javax.swing.JRadioButton;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.ChangeabilityPropertyPanel;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for ChangeabilityPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class ChangeabilityPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * ChangeabilityPropertyPanel instance for testing.
     * </p>
     */
    private ChangeabilityPropertyPanel instance;

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
        instance = new ChangeabilityPropertyPanel(propertiesPanel);
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
        return new TestSuite(ChangeabilityPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor ChangeabilityPropertyPanel#ChangeabilityPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create ChangeabilityPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests ChangeabilityPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        AssociationEnd end = new AssociationEndImpl();
        end.setChangeability(ChangeableKind.CHANGEABLE);
        instance.configurePanel(end);

        JRadioButton button = (JRadioButton) AccuracyTestsHelper.getChildComponents(instance.retrievePanel(),
            JRadioButton.class)[0];
        assertTrue("Failed to refresh panel correctly.", button.isSelected());
    }

    /**
     * <p>
     * Tests ChangeabilityPropertyPanel#execute() for accuracy.
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