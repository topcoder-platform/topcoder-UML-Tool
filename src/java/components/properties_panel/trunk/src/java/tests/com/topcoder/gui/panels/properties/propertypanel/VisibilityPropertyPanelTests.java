/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;

import com.topcoder.gui.panels.properties.MockModelElementChangeListener;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for VisibilityPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class VisibilityPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The VisibilityPropertyPanel instance for testing.
     * </p>
     */
    private VisibilityPropertyPanel panel;

    /**
     * <p>
     * The PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);
        propertiesPanel = new PropertiesPanel(new UMLModelManager());

        panel = new VisibilityPropertyPanel(propertiesPanel);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        panel = null;
        propertiesPanel = null;

        TestHelper.clearConfigFile(TestHelper.NAMESPACE);
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(VisibilityPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor VisibilityPropertyPanel#VisibilityPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created VisibilityPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new VisibilityPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor VisibilityPropertyPanel#VisibilityPropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new VisibilityPropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests VisibilityPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies VisibilityPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        AssociationEnd element = new AssociationEndImpl();
        element.setVisibility(VisibilityKind.PROTECTED);

        panel.configurePanel(element);

        assertTrue("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(1)).isSelected());
    }

    /**
     * <p>
     * Tests VisibilityPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies VisibilityPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoButtonSelected() {
        List<ModelElement> elements = new ArrayList<ModelElement>();
        AssociationEnd element1 = new AssociationEndImpl();
        element1.setVisibility(VisibilityKind.PROTECTED);
        AssociationEnd element2 = new AssociationEndImpl();

        elements.add(element1);
        elements.add(element2);
        panel.configurePanel(elements);

        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(0)).isSelected());
        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(1)).isSelected());
        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(2)).isSelected());
        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(3)).isSelected());
    }

    /**
     * <p>
     * Tests VisibilityPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies VisibilityPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoVisible() {
        panel.refreshPanel();

        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(0)).isSelected());
        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(1)).isSelected());
        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(2)).isSelected());
        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(3)).isSelected());
    }

    /**
     * <p>
     * Tests VisibilityPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies VisibilityPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        panel.configurePanel(new AssociationEndImpl());

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests VisibilityPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies VisibilityPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute_Public() {
        AssociationEnd element = new AssociationEndImpl();
        element.setVisibility(VisibilityKind.PUBLIC);

        panel.configurePanel(element);

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests VisibilityPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies VisibilityPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute_Protected() {
        AssociationEnd element = new AssociationEndImpl();
        element.setVisibility(VisibilityKind.PROTECTED);

        panel.configurePanel(element);

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests VisibilityPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies VisibilityPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute_Package() {
        AssociationEnd element = new AssociationEndImpl();
        element.setVisibility(VisibilityKind.PACKAGE);

        panel.configurePanel(element);

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }
}
