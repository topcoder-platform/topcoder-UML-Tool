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
import com.topcoder.gui.panels.properties.propertypanel.links.ExtensionLinkPropertyPanel;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for ExtensionLinkPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class ExtensionLinkPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * ExtensionLinkPropertyPanel instance for testing.
     * </p>
     */
    private ExtensionLinkPropertyPanel instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        instance = new ExtensionLinkPropertyPanel(new PropertiesPanel(new UMLModelManager()));
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
        return new TestSuite(ExtensionLinkPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor ExtensionLinkPropertyPanel#ExtensionLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create ExtensionLinkPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests ExtensionLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        UseCase extension = new UseCaseImpl();
        extension.setName("ExtensionLinkProperty");
        Extend element = new ExtendImpl();
        element.setExtension(extension);
        instance.configurePanel(element);

        Component[] labels = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class);

        boolean extensionLinkLabelPresent = false;
        for (Component comp : labels) {
            JLabel label = (JLabel) comp;
            if (label.getText().contains("ExtensionLinkProperty")) {
                extensionLinkLabelPresent = true;
            }
        }

        assertTrue("Failed to refresh panel.", extensionLinkLabelPresent);
    }

}