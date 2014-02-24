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
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for OrderingPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class OrderingPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The OrderingPropertyPanel instance for testing.
     * </p>
     */
    private OrderingPropertyPanel panel;

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

        panel = new OrderingPropertyPanel(propertiesPanel);
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
        return new TestSuite(OrderingPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor OrderingPropertyPanel#OrderingPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created OrderingPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new OrderingPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor OrderingPropertyPanel#OrderingPropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new OrderingPropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests OrderingPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies OrderingPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        AssociationEnd element = new AssociationEndImpl();
        element.setOrdering(OrderingKind.ORDERED);

        panel.configurePanel(element);

        assertTrue("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(0)).isSelected());
    }

    /**
     * <p>
     * Tests OrderingPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies OrderingPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoButtonSelected() {
        List<ModelElement> elements = new ArrayList<ModelElement>();
        AssociationEnd element1 = new AssociationEndImpl();
        element1.setOrdering(OrderingKind.ORDERED);
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
    }

    /**
     * <p>
     * Tests OrderingPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies OrderingPropertyPanel#refreshPanel() is correct.
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
    }

    /**
     * <p>
     * Tests OrderingPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies OrderingPropertyPanel#execute() is correct.
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
     * Tests OrderingPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies OrderingPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute_Ordered() {
        AssociationEnd element = new AssociationEndImpl();
        element.setOrdering(OrderingKind.ORDERED);

        panel.configurePanel(element);

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests OrderingPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies OrderingPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute_Unordered() {
        AssociationEnd element = new AssociationEndImpl();
        element.setOrdering(OrderingKind.UNORDERED);

        panel.configurePanel(element);

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }
}