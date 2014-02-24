/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel.links;

import javax.swing.JLabel;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for NamespaceLinkPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class NamespaceLinkPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The NamespaceLinkPropertyPanel instance for testing.
     * </p>
     */
    private NamespaceLinkPropertyPanel panel;

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

        panel = new NamespaceLinkPropertyPanel(propertiesPanel);
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
        return new TestSuite(NamespaceLinkPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor NamespaceLinkPropertyPanel#NamespaceLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created NamespaceLinkPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new NamespaceLinkPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor NamespaceLinkPropertyPanel#NamespaceLinkPropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new NamespaceLinkPropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests NamespaceLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies NamespaceLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        Namespace namespace = new PackageImpl();
        namespace.setName("NamespaceLink");
        Dependency element = new DependencyImpl();
        element.setNamespace(namespace);

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", "NamespaceLink",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

    /**
     * <p>
     * Tests NamespaceLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies NamespaceLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoVisible() {
        panel.refreshPanel();

        assertEquals("Failed to refresh panel correctly.", "Namespace",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

    /**
     * <p>
     * Tests NamespaceLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when setLinkedModelElement(null) is call and
     * verifies NamespaceLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoNamespaces() {
        panel.configurePanel(new DependencyImpl());

        assertEquals("Failed to refresh panel correctly.", "",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }
}