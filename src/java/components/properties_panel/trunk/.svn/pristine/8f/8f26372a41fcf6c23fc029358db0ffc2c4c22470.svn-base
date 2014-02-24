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
 * Unit test cases for ParentLinkPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ParentLinkPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The ParentLinkPropertyPanel instance for testing.
     * </p>
     */
    private ParentLinkPropertyPanel panel;

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

        panel = new ParentLinkPropertyPanel(propertiesPanel);
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
        return new TestSuite(ParentLinkPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor ParentLinkPropertyPanel#ParentLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created ParentLinkPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ParentLinkPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor ParentLinkPropertyPanel#ParentLinkPropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new ParentLinkPropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ParentLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ParentLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        List<ModelElement> elements = new ArrayList<ModelElement>();
        GeneralizableElement parent = new AssociationImpl();
        parent.setName("ParentLink");
        Generalization element1 = new GeneralizationImpl();
        element1.setParent(parent);
        Abstraction element2 = new AbstractionImpl();
        element2.addSupplier(parent);

        elements.add(element1);
        elements.add(element2);
        panel.configurePanel(elements);

        assertEquals("Failed to refresh panel correctly.", "ParentLink",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

    /**
     * <p>
     * Tests ParentLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ParentLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoVisible() {
        panel.refreshPanel();

        assertEquals("Failed to refresh panel correctly.", "Parent",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

    /**
     * <p>
     * Tests ParentLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when setLinkedModelElement(null) is call and
     * verifies ParentLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoParents() {
        panel.configurePanel(new GeneralizationImpl());

        assertEquals("Failed to refresh panel correctly.", "",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

}