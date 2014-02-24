/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel.links;

import javax.swing.JLabel;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ExtensionLinkPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ExtensionLinkPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The ExtensionLinkPropertyPanel instance for testing.
     * </p>
     */
    private ExtensionLinkPropertyPanel panel;

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

        panel = new ExtensionLinkPropertyPanel(propertiesPanel);
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
        return new TestSuite(ExtensionLinkPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor ExtensionLinkPropertyPanel#ExtensionLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created ExtensionLinkPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ExtensionLinkPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor ExtensionLinkPropertyPanel#ExtensionLinkPropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new ExtensionLinkPropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ExtensionLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ExtensionLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        UseCase extension = new UseCaseImpl();
        extension.setName("ExtensionLink");
        Extend element = new ExtendImpl();
        element.setExtension(extension);

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", "ExtensionLink",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

    /**
     * <p>
     * Tests ExtensionLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ExtensionLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoVisible() {
        panel.refreshPanel();

        assertEquals("Failed to refresh panel correctly.", "Extension",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

    /**
     * <p>
     * Tests ExtensionLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when setLinkedModelElement(null) is call and
     * verifies ExtensionLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoExtens() {
        panel.configurePanel(new ExtendImpl());

        assertEquals("Failed to refresh panel correctly.", "",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

}