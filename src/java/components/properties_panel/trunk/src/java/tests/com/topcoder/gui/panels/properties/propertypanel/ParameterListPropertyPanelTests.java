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
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ParameterListPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class ParameterListPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The ParameterListPropertyPanel instance for testing.
     * </p>
     */
    private ParameterListPropertyPanel panel;

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

        panel = new ParameterListPropertyPanel(propertiesPanel, deleteIcon, addIcon);
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
        return new TestSuite(ParameterListPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor ParameterListPropertyPanel#ParameterListPropertyPanel(PropertiesPanel,Icon,Icon) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created ParameterListPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ParameterListPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor ParameterListPropertyPanel#ParameterListPropertyPanel(PropertiesPanel,Icon,Icon) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new ParameterListPropertyPanel(null, deleteIcon, addIcon);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ParameterListPropertyPanel#ParameterListPropertyPanel(PropertiesPanel,Icon,Icon) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when deleteIcon is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullDeleteIcon() {
        try {
            new ParameterListPropertyPanel(propertiesPanel, null, addIcon);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ParameterListPropertyPanel#ParameterListPropertyPanel(PropertiesPanel,Icon,Icon) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when addIcon is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullAddIcon() {
        try {
            new ParameterListPropertyPanel(propertiesPanel, deleteIcon, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ParameterListPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ParameterListPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        Parameter parameter = new ParameterImpl();
        Operation element = new OperationImpl();
        element.addParameter(parameter);
        panel.configurePanel(element);

        JScrollPane scrollPane = (JScrollPane) panel.retrievePanel().getComponent(2);
        assertEquals("Failed to refresh panel correctly.", deleteIcon,
                ((JTable) ((JPanel) scrollPane.getViewport().getView()).getComponent(1))
                .getModel().getValueAt(0, 1));
    }

    /**
     * <p>
     * Tests ParameterListPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ParameterListPropertyPanel#refreshPanel() is correct.
     * </p>
     * @version 1.1
     */
    public void testRefreshPanelWithReturnValue() {
        Parameter parameter = new ParameterImpl();
        Operation element = new OperationImpl();
        parameter.setKind(ParameterDirectionKind.RETURN);
        element.addParameter(parameter);
        panel.configurePanel(element);

        JScrollPane scrollPane = (JScrollPane) panel.retrievePanel().getComponent(2);
        assertEquals("Failed to refresh panel correctly.", deleteIcon,
                ((JTable) ((JPanel) scrollPane.getViewport().getView()).getComponent(0))
                .getModel().getValueAt(0, 1));
    }

    /**
     * <p>
     * Tests ParameterListPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ParameterListPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        panel.execute();
    }

}