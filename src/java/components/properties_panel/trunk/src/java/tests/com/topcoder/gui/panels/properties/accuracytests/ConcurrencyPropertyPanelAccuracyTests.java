/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import javax.swing.JCheckBox;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.ConcurrencyPropertyPanel;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for ConcurrencyPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class ConcurrencyPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * ConcurrencyPropertyPanel instance for testing.
     * </p>
     */
    private ConcurrencyPropertyPanel instance;

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
        instance = new ConcurrencyPropertyPanel(propertiesPanel);
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
        return new TestSuite(ConcurrencyPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor ConcurrencyPropertyPanel#ConcurrencyPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create ConcurrencyPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests ConcurrencyPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        Operation element = new OperationImpl();
        element.setConcurrency(CallConcurrencyKind.CONCURRENT);
        instance.configurePanel(element);

        JCheckBox box = (JCheckBox) AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JCheckBox.class)[0];
        assertTrue("Failed to refresh panel.", box.isSelected());
    }

    /**
     * <p>
     * Tests ConcurrencyPropertyPanel#execute() for accuracy.
     * </p>
     */
    public void testExecute() {
        instance.execute();
    }

}