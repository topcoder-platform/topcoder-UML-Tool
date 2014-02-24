/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.panels.properties.MockModelElementChangeListener;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Unit test cases for NamespacePropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class NamespacePropertyPanelTests extends TestCase {
    /**
     * <p>
     * The NamespacePropertyPanel instance for testing.
     * </p>
     */
    private NamespacePropertyPanel panel;

    /**
     * <p>
     * The PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * The Icon instance for testing.
     * </p>
     */
    private Icon icon;

    /**
     * <p>
     * The Namespace instance for testing.
     * </p>
     */
    private Namespace namespace;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);

        namespace = new PackageImpl();
        Model model = new ModelImpl();
        model.addOwnedElement(namespace);
        UMLModelManager manager = new UMLModelManager();
        manager.setModel(model);

        propertiesPanel = new PropertiesPanel(manager);
        icon = new ImageIcon();

        panel = new NamespacePropertyPanel(propertiesPanel, icon);
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
        icon = null;
        propertiesPanel = null;
        namespace = null;

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
        return new TestSuite(NamespacePropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor NamespacePropertyPanel#NamespacePropertyPanel(PropertiesPanel,Icon) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created NamespacePropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new NamespacePropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor NamespacePropertyPanel#NamespacePropertyPanel(PropertiesPanel,Icon) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new NamespacePropertyPanel(null, icon);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor NamespacePropertyPanel#NamespacePropertyPanel(PropertiesPanel,Icon) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when icon is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullIcon() {
        try {
            new NamespacePropertyPanel(propertiesPanel, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests NamespacePropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when namespace is config and verifies
     * NamespacePropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NamespaceConfig() {
        Interface element = new InterfaceImpl();
        element.setNamespace(namespace);

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", 1,
            ((JComboBox) panel.retrievePanel().getComponent(2)).getSelectedIndex());
    }

    /**
     * <p>
     * Tests NamespacePropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when namespace is not configed and verifies
     * NamespacePropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoNamespace() {
        Interface element = new InterfaceImpl();

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", 0,
            ((JComboBox) panel.retrievePanel().getComponent(2)).getSelectedIndex());
    }

    /**
     * <p>
     * Tests NamespacePropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies NamespacePropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        Interface element = new InterfaceImpl();
        element.setNamespace(namespace);
        panel.configurePanel(element);

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests NamespacePropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when empty item is selected and verifies
     * NamespacePropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute_EmptyItemSelected() {
        panel.configurePanel(new InterfaceImpl());

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertFalse("Failed to execute correctly.", listener.getIsExecuted());
    }

}