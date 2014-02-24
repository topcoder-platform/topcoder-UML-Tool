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
import com.topcoder.gui.panels.properties.propertypanel.StereotypeListPropertyPanel;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for StereotypeListPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class StereotypeListPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * StereotypeListPropertyPanel instance for testing.
     * </p>
     */
    private StereotypeListPropertyPanel instance;

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
        instance = new StereotypeListPropertyPanel(propertiesPanel, new ImageIcon(), new ImageIcon());
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
        return new TestSuite(StereotypeListPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor StereotypeListPropertyPanel#StereotypeListPropertyPanel(PropertiesPanel,Icon,Icon) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create StereotypeListPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests StereotypeListPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        Stereotype stereoType = new StereotypeImpl();
        Interface element = new InterfaceImpl();
        element.addStereotype(stereoType);
        instance.configurePanel(element);

        JScrollPane scrollPane = (JScrollPane) instance.retrievePanel().getComponent(2);
        assertNotNull("Failed to refresh panel correctly.",
                ((JTable) ((JPanel) scrollPane.getViewport().getView()).getComponent(0))
                .getModel().getValueAt(0, 1));
    }

    /**
     * <p>
     * Tests StereotypeListPropertyPanel#execute() for accuracy.
     * </p>
     */
    public void testExecute() {
        instance.execute();
    }

}