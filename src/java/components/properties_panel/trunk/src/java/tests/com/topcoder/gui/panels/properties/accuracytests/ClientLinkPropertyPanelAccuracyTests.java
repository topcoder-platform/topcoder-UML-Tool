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
import com.topcoder.gui.panels.properties.propertypanel.links.ClientLinkPropertyPanel;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for ClientLinkPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class ClientLinkPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * ClientLinkPropertyPanel instance for testing.
     * </p>
     */
    private ClientLinkPropertyPanel instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        instance = new ClientLinkPropertyPanel(new PropertiesPanel(new UMLModelManager()));
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
        return new TestSuite(ClientLinkPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor ClientLinkPropertyPanel#ClientLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create ClientLinkPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests ClientLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        UseCase client = new UseCaseImpl();
        client.setName("ClientLinkProperty");
        Dependency element = new DependencyImpl();
        element.addClient(client);
        instance.configurePanel(element);

        Component[] labels = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class);

        boolean clientLinkLabelPresent = false;
        for (Component comp : labels) {
            JLabel label = (JLabel) comp;
            if (label.getText().contains("ClientLinkProperty")) {
                clientLinkLabelPresent = true;
            }
        }

        assertTrue("Failed to refresh panel.", clientLinkLabelPresent);
    }

}