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
import com.topcoder.gui.panels.properties.propertypanel.links.AssociationLinkPropertyPanel;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for AssociationLinkPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class AssociationLinkPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * AssociationLinkPropertyPanel instance for testing.
     * </p>
     */
    private AssociationLinkPropertyPanel instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        instance = new AssociationLinkPropertyPanel(new PropertiesPanel(new UMLModelManager()));
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
        return new TestSuite(AssociationLinkPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor AssociationLinkPropertyPanel#AssociationLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create AssociationLinkPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests AssociationLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        Association association = new AssociationImpl();
        association.setName("AssociationLinkProperty");
        AssociationEnd element = new AssociationEndImpl();
        element.setAssociation(association);
        instance.configurePanel(element);

        Component[] labels = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class);

        boolean associationLinkLabelPresent = false;
        for (Component comp : labels) {
            JLabel label = (JLabel) comp;
            if (label.getText().contains("AssociationLinkProperty")) {
                associationLinkLabelPresent = true;
            }
        }

        assertTrue("Failed to refresh panel.", associationLinkLabelPresent);
    }

}