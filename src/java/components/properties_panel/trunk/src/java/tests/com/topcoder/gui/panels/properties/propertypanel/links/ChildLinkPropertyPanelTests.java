/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel.links;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.GeneralizableElement;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ChildLinkPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ChildLinkPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The ChildLinkPropertyPanel instance for testing.
     * </p>
     */
    private ChildLinkPropertyPanel panel;

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

        panel = new ChildLinkPropertyPanel(propertiesPanel);
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
        return new TestSuite(ChildLinkPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor ChildLinkPropertyPanel#ChildLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created ChildLinkPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ChildLinkPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor ChildLinkPropertyPanel#ChildLinkPropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new ChildLinkPropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ChildLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ChildLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        List<ModelElement> elements = new ArrayList<ModelElement>();
        GeneralizableElement child = new AssociationImpl();
        child.setName("ChildLink");
        Generalization element1 = new GeneralizationImpl();
        element1.setChild(child);
        Abstraction element2 = new AbstractionImpl();
        element2.addClient(child);

        elements.add(element1);
        elements.add(element2);
        panel.configurePanel(elements);

        assertEquals("Failed to refresh panel correctly.", "ChildLink",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

    /**
     * <p>
     * Tests ChildLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ChildLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoVisible() {
        panel.refreshPanel();

        assertEquals("Failed to refresh panel correctly.", "Child",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

    /**
     * <p>
     * Tests ChildLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when setLinkedModelElement(null) is call and
     * verifies ChildLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoChilds() {
        panel.configurePanel(new GeneralizationImpl());

        assertEquals("Failed to refresh panel correctly.", "",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

}