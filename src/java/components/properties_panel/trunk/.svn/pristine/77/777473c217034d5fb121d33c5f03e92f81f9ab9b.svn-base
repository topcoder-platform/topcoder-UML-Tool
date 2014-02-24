/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.ParameterListPropertyPanel;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for ParameterListPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class ParameterListPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * ParameterListPropertyPanel instance for testing.
     * </p>
     */
    private ParameterListPropertyPanel instance;

    /**
     * <p>
     * PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        propertiesPanel = new PropertiesPanel(new UMLModelManager());
        instance = new ParameterListPropertyPanel(propertiesPanel, new ImageIcon(), new ImageIcon());
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        instance = null;
        propertiesPanel = null;
        AccuracyTestsHelper.clearConfig();
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ParameterListPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor ParameterListPropertyPanel#ParameterListPropertyPanel(PropertiesPanel,Icon,Icon) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create ParameterListPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests ParameterListPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        Parameter parameter = new ParameterImpl();
        Operation element = new OperationImpl();
        element.addParameter(parameter);
        instance.configurePanel(element);

        JScrollPane scrollPane = (JScrollPane) AccuracyTestsHelper.getChildComponents(instance.retrievePanel(),
            JScrollPane.class)[0];
        assertNotNull("Failed to refresh panel.",
                ((JTable) ((JPanel) scrollPane.getViewport().getView()).getComponent(1))
                .getModel().getValueAt(0, 1));
    }

    /**
     * <p>
     * Tests ParameterListPropertyPanel#execute() for accuracy.
     * </p>
     */
    public void testExecute() {
        instance.execute();
    }

}