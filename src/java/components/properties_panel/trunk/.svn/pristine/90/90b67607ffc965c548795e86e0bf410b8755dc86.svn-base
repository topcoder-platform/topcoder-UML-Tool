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
import com.topcoder.gui.panels.properties.propertypanel.links.NamespaceLinkPropertyPanel;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for NamespaceLinkPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class NamespaceLinkPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * NamespaceLinkPropertyPanel instance for testing.
     * </p>
     */
    private NamespaceLinkPropertyPanel instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        instance = new NamespaceLinkPropertyPanel(new PropertiesPanel(new UMLModelManager()));
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
        return new TestSuite(NamespaceLinkPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor NamespaceLinkPropertyPanel#NamespaceLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create NamespaceLinkPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests NamespaceLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        Namespace namespace = new PackageImpl();
        namespace.setName("NamespaceLinkProperty");
        Dependency element = new DependencyImpl();
        element.setNamespace(namespace);
        instance.configurePanel(element);

        Component[] labels = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class);

        boolean namespaceLinkLabelPresent = false;
        for (Component comp : labels) {
            JLabel label = (JLabel) comp;
            if (label.getText().contains("NamespaceLinkProperty")) {
                namespaceLinkLabelPresent = true;
            }
        }

        assertTrue("Failed to refresh panel.", namespaceLinkLabelPresent);
    }

}