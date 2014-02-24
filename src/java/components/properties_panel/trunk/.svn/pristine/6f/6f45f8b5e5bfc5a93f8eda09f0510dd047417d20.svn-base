/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for StereotypeListPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class StereotypeListPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The StereotypeListPropertyPanel instance for testing.
     * </p>
     */
    private StereotypeListPropertyPanel panel;

    /**
     * <p>
     * The PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * The deleteIcon instance for testing.
     * </p>
     */
    private Icon deleteIcon;

    /**
     * <p>
     * The addIcon instance for testing.
     * </p>
     */
    private Icon addIcon;

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
        deleteIcon = new ImageIcon();
        addIcon = new ImageIcon();

        panel = new StereotypeListPropertyPanel(propertiesPanel, addIcon, deleteIcon);
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
        addIcon = null;
        deleteIcon = null;
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
        return new TestSuite(StereotypeListPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor StereotypeListPropertyPanel#StereotypeListPropertyPanel(PropertiesPanel,Icon,Icon) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created StereotypeListPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new StereotypeListPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor StereotypeListPropertyPanel#StereotypeListPropertyPanel(PropertiesPanel,Icon,Icon) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new StereotypeListPropertyPanel(null, addIcon, deleteIcon);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StereotypeListPropertyPanel#StereotypeListPropertyPanel(PropertiesPanel,Icon,Icon) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when addIcon is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullAddIcon() {
        try {
            new StereotypeListPropertyPanel(propertiesPanel, null, deleteIcon);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StereotypeListPropertyPanel#StereotypeListPropertyPanel(PropertiesPanel,Icon,Icon) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when deleteIcon is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullDeleteIcon() {
        try {
            new StereotypeListPropertyPanel(propertiesPanel, addIcon, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StereotypeListPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies StereotypeListPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        Stereotype stereoType = new StereotypeImpl();
        Interface element = new InterfaceImpl();
        element.addStereotype(stereoType);
        panel.configurePanel(element);

        JScrollPane scrollPane = (JScrollPane) panel.retrievePanel().getComponent(2);
        assertEquals("Failed to refresh panel correctly.", deleteIcon,
            ((JTable) ((JPanel) scrollPane.getViewport().getView()).getComponent(0))
            .getModel().getValueAt(0, 1));
    }

    /**
     * <p>
     * Tests StereotypeListPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies StereotypeListPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        panel.execute();
    }

}