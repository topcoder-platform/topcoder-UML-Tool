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
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ChangeabilityPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ChangeabilityPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The ChangeabilityPropertyPanel instance for testing.
     * </p>
     */
    private ChangeabilityPropertyPanel panel;

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

        panel = new ChangeabilityPropertyPanel(propertiesPanel);
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
        return new TestSuite(ChangeabilityPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor ChangeabilityPropertyPanel#ChangeabilityPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created ChangeabilityPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ChangeabilityPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor ChangeabilityPropertyPanel#ChangeabilityPropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new ChangeabilityPropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ChangeabilityPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ChangeabilityPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        List<ModelElement> elements = new ArrayList<ModelElement>();
        AssociationEnd end = new AssociationEndImpl();
        end.setChangeability(ChangeableKind.CHANGEABLE);
        Attribute attribute = new AttributeImpl();
        attribute.setChangeability(ChangeableKind.CHANGEABLE);

        elements.add(end);
        elements.add(attribute);

        panel.configurePanel(elements);

        assertTrue("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(0)).isSelected());
    }

    /**
     * <p>
     * Tests ChangeabilityPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ChangeabilityPropertyPanel#refreshPanel() is correct.
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
     * Tests ChangeabilityPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when no button is selected and verifies
     * ChangeabilityPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoButtonSelected() {
        List<ModelElement> elements = new ArrayList<ModelElement>();
        AssociationEnd end = new AssociationEndImpl();
        end.setChangeability(ChangeableKind.CHANGEABLE);
        Attribute attribute = new AttributeImpl();
        attribute.setChangeability(ChangeableKind.CHANGEABLE);
        Attribute attribute2 = new AttributeImpl();

        elements.add(end);
        elements.add(attribute);
        elements.add(attribute2);

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
     * Tests ChangeabilityPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ChangeabilityPropertyPanel#execute() is correct.
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
     * Tests ChangeabilityPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ChangeabilityPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute_Changeable() {
        AssociationEnd end = new AssociationEndImpl();
        end.setChangeability(ChangeableKind.CHANGEABLE);

        panel.configurePanel(end);

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests ChangeabilityPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ChangeabilityPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute_Frozen() {
        AssociationEnd end = new AssociationEndImpl();
        end.setChangeability(ChangeableKind.FROZEN);

        panel.configurePanel(end);

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }
}