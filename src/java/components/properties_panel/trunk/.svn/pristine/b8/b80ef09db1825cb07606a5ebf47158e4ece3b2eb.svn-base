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
import com.topcoder.gui.panels.properties.propertypanel.links.ChildLinkPropertyPanel;
import com.topcoder.uml.model.core.GeneralizableElement;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for ChildLinkPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class ChildLinkPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * ChildLinkPropertyPanel instance for testing.
     * </p>
     */
    private ChildLinkPropertyPanel instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        instance = new ChildLinkPropertyPanel(new PropertiesPanel(new UMLModelManager()));
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
        return new TestSuite(ChildLinkPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor ChildLinkPropertyPanel#ChildLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create ChildLinkPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests ChildLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        GeneralizableElement child = new AssociationImpl();
        child.setName("ChildLinkProperty");
        Generalization element = new GeneralizationImpl();
        element.setChild(child);
        instance.configurePanel(element);

        Component[] labels = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class);

        boolean childLinkLabelPresent = false;
        for (Component comp : labels) {
            JLabel label = (JLabel) comp;
            if (label.getText().contains("ChildLinkProperty")) {
                childLinkLabelPresent = true;
            }
        }

        assertTrue("Failed to refresh panel.", childLinkLabelPresent);
    }

}