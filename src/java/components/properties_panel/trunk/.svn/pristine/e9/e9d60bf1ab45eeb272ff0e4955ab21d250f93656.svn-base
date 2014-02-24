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
import com.topcoder.gui.panels.properties.propertypanel.links.OwnerLinkPropertyPanel;
import com.topcoder.uml.model.core.BehavioralFeature;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for OwnerLinkPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class OwnerLinkPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * OwnerLinkPropertyPanel instance for testing.
     * </p>
     */
    private OwnerLinkPropertyPanel instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        instance = new OwnerLinkPropertyPanel(new PropertiesPanel(new UMLModelManager()));
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
        return new TestSuite(OwnerLinkPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor OwnerLinkPropertyPanel#OwnerLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create OwnerLinkPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests OwnerLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        BehavioralFeature behavioralFeature = new MethodImpl();
        behavioralFeature.setName("OwnerLinkProperty");
        Parameter element = new ParameterImpl();
        element.setBehavioralFeature(behavioralFeature);
        instance.configurePanel(element);

        Component[] labels = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class);

        boolean ownerLinkLabelPresent = false;
        for (Component comp : labels) {
            JLabel label = (JLabel) comp;
            if (label.getText().contains("OwnerLinkProperty")) {
                ownerLinkLabelPresent = true;
            }
        }

        assertTrue("Failed to refresh panel.", ownerLinkLabelPresent);
    }

}