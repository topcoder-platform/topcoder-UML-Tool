/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import javax.swing.JCheckBox;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ConcurrencyPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ConcurrencyPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The ConcurrencyPropertyPanel instance for testing.
     * </p>
     */
    private ConcurrencyPropertyPanel panel;

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

        panel = new ConcurrencyPropertyPanel(propertiesPanel);
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
        return new TestSuite(ConcurrencyPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor ConcurrencyPropertyPanel#ConcurrencyPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created ConcurrencyPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ConcurrencyPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor ConcurrencyPropertyPanel#ConcurrencyPropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new ConcurrencyPropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConcurrencyPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConcurrencyPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        Operation element = new OperationImpl();
        element.setConcurrency(CallConcurrencyKind.CONCURRENT);

        panel.configurePanel(element);

        assertTrue("Failed to refresh panel correctly.",
            ((JCheckBox) panel.retrievePanel().getComponent(0)).isSelected());
    }

    /**
     * <p>
     * Tests ConcurrencyPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConcurrencyPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        panel.execute();
    }

}