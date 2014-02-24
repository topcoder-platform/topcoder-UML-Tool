/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import java.awt.Component;

import javax.swing.JLabel;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.SupplierLinkPropertyPanel;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for SupplierLinkPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class SupplierLinkPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * SupplierLinkPropertyPanel instance for testing.
     * </p>
     */
    private SupplierLinkPropertyPanel instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        instance = new SupplierLinkPropertyPanel(new PropertiesPanel(new UMLModelManager()));
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
        return new TestSuite(SupplierLinkPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor SupplierLinkPropertyPanel#SupplierLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create SupplierLinkPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests SupplierLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        UseCase supplier = new UseCaseImpl();
        supplier.setName("SupplierLinkProperty");
        Dependency element = new DependencyImpl();
        element.addSupplier(supplier);
        instance.configurePanel(element);

        Component[] labels = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class);

        boolean supplierLinkLabelPresent = false;
        for (Component comp : labels) {
            JLabel label = (JLabel) comp;
            if (label.getText().contains("SupplierLinkProperty")) {
                supplierLinkLabelPresent = true;
            }
        }

        assertTrue("Failed to refresh panel.", supplierLinkLabelPresent);
    }

}