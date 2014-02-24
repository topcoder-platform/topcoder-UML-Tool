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
import com.topcoder.gui.panels.properties.propertypanel.links.ParentLinkPropertyPanel;
import com.topcoder.uml.model.core.GeneralizableElement;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for ParentLinkPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class ParentLinkPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * ParentLinkPropertyPanel instance for testing.
     * </p>
     */
    private ParentLinkPropertyPanel instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        instance = new ParentLinkPropertyPanel(new PropertiesPanel(new UMLModelManager()));
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
        return new TestSuite(ParentLinkPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor ParentLinkPropertyPanel#ParentLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create ParentLinkPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests ParentLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        GeneralizableElement parent = new AssociationImpl();
        parent.setName("ParentLinkProperty");
        Generalization element = new GeneralizationImpl();
        element.setParent(parent);
        instance.configurePanel(element);

        Component[] labels = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class);

        boolean parentLinkLabelPresent = false;
        for (Component comp : labels) {
            JLabel label = (JLabel) comp;
            if (label.getText().contains("ParentLinkProperty")) {
                parentLinkLabelPresent = true;
            }
        }

        assertTrue("Failed to refresh panel.", parentLinkLabelPresent);
    }

}