/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AssociationEndsPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AssociationEndsPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The AssociationEndsPropertyPanel instance for testing.
     * </p>
     */
    private AssociationEndsPropertyPanel panel;

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

        panel = new AssociationEndsPropertyPanel(propertiesPanel);
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
        return new TestSuite(AssociationEndsPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor AssociationEndsPropertyPanel#AssociationEndsPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created AssociationEndsPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AssociationEndsPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor AssociationEndsPropertyPanel#AssociationEndsPropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new AssociationEndsPropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AssociationEndsPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when there are two Connections and verifies
     * AssociationEndsPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_TwoConnections() {
        AssociationEnd end1 = new AssociationEndImpl();
        end1.setName("end1");
        AssociationEnd end2 = new AssociationEndImpl();
        end2.setName("end2");

        Association element = new AssociationImpl();
        element.addConnection(end1);
        element.addConnection(end2);

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", "Start",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
        assertEquals("Failed to refresh panel correctly.", "End",
            ((JLabel) panel.retrievePanel().getComponent(1)).getText());
    }

    /**
     * <p>
     * Tests AssociationEndsPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when there are one Connection and verifies
     * AssociationEndsPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_OneConnection() {
        AssociationEnd end1 = new AssociationEndImpl();
        end1.setName("end1");

        Association element = new AssociationImpl();
        element.addConnection(end1);

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", "Start",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
        assertEquals("Failed to refresh panel correctly.", "End",
            ((JLabel) panel.retrievePanel().getComponent(1)).getText());
    }

    /**
     * <p>
     * Tests AssociationEndsPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when there are zero Connection and verifies
     * AssociationEndsPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_ZeroConnection() {
        Association element = new AssociationImpl();

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", "Start",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
        assertEquals("Failed to refresh panel correctly.", "End",
            ((JLabel) panel.retrievePanel().getComponent(1)).getText());
    }

    /**
     * <p>
     * Tests AssociationEndsPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the not visible and verifies
     * AssociationEndsPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NotVisible() {
        panel.refreshPanel();

        assertEquals("Failed to refresh panel correctly.", "",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
        assertEquals("Failed to refresh panel correctly.", "",
            ((JLabel) panel.retrievePanel().getComponent(1)).getText());
    }

    /**
     * <p>
     * Tests AssociationEndsPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when there are more than two Connections and verifies
     * AssociationEndsPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_MoreThanTwoConnections() {
        AssociationEnd end1 = new AssociationEndImpl();
        end1.setName("end1");
        AssociationEnd end2 = new AssociationEndImpl();
        end2.setName("end2");

        Association element1 = new AssociationImpl();
        element1.addConnection(end1);
        element1.addConnection(end2);

        Association element2 = new AssociationImpl();
        element2.addConnection(end2);
        element2.addConnection(end1);

        List<ModelElement> elements = new ArrayList<ModelElement>();
        elements.add(element1);
        elements.add(element2);
        panel.configurePanel(elements);

        assertEquals("Failed to refresh panel correctly.", "",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
        assertEquals("Failed to refresh panel correctly.", "",
            ((JLabel) panel.retrievePanel().getComponent(1)).getText());
    }

    /**
     * <p>
     * Tests AssociationEndsPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies AssociationEndsPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        panel.execute();
    }

}