/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import com.topcoder.gui.panels.properties.MockModelElementChangeListener;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.classifiers.DataTypeImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for OwnerPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class OwnerPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The OwnerPropertyPanel instance for testing.
     * </p>
     */
    private OwnerPropertyPanel panel;

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
     * The Classifier instance for testing.
     * </p>
     */
    private Classifier classifier;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);

        classifier = new InterfaceImpl();
        Namespace namespace = new DataTypeImpl();
        namespace.addOwnedElement(classifier);
        Model model = new ModelImpl();
        model.addOwnedElement(namespace);
        UMLModelManager manager = new UMLModelManager();
        manager.setModel(model);

        propertiesPanel = new PropertiesPanel(manager);
        icon = new ImageIcon();

        panel = new OwnerPropertyPanel(propertiesPanel, icon);
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
        classifier = null;

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
        return new TestSuite(OwnerPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor OwnerPropertyPanel#OwnerPropertyPanel(PropertiesPanel,Icon) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created OwnerPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new OwnerPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor OwnerPropertyPanel#OwnerPropertyPanel(PropertiesPanel,Icon) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new OwnerPropertyPanel(null, icon);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor OwnerPropertyPanel#OwnerPropertyPanel(PropertiesPanel,Icon) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when icon is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullIcon() {
        try {
            new OwnerPropertyPanel(propertiesPanel, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests OwnerPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when classifier is config and verifies
     * OwnerPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_ClassifierConfig() {
        Operation element = new OperationImpl();
        element.setOwner(classifier);

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", 0,
            ((JComboBox) panel.retrievePanel().getComponent(2)).getSelectedIndex());
    }

    /**
     * <p>
     * Tests OwnerPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when classifier is not config and verifies
     * OwnerPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoClassifierConfig() {
        Operation element = new OperationImpl();

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", 0,
            ((JComboBox) panel.retrievePanel().getComponent(2)).getSelectedIndex());
    }

    /**
     * <p>
     * Tests OwnerPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies OwnerPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        Operation element = new OperationImpl();
        element.setOwner(classifier);
        panel.configurePanel(element);

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests OwnerPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when empty item is selected and verifies
     * OwnerPropertyPanel#execute() is correct.
     * </p>
     * @throws Exception to JUnit
     */
    public void testExecute_EmptyItemSelected() throws Exception {
        propertiesPanel = new PropertiesPanel(new UMLModelManager());
        panel = new OwnerPropertyPanel(propertiesPanel, icon);
        panel.configurePanel(new OperationImpl());

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertFalse("Failed to execute correctly.", listener.getIsExecuted());
    }

}