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
import com.topcoder.gui.panels.properties.propertypanel.links.AdditionLinkPropertyPanel;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for AdditionLinkPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class AdditionLinkPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * AdditionLinkPropertyPanel instance for testing.
     * </p>
     */
    private AdditionLinkPropertyPanel instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        instance = new AdditionLinkPropertyPanel(new PropertiesPanel(new UMLModelManager()));
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
        return new TestSuite(AdditionLinkPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor AdditionLinkPropertyPanel#AdditionLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create AdditionLinkPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests AdditionLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        UseCase addition = new UseCaseImpl();
        addition.setName("AdditionLinkProperty");
        Include element = new IncludeImpl();
        element.setAddition(addition);
        instance.configurePanel(element);

        Component[] labels = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class);

        boolean additionLinkLabelPresent = false;
        for (Component comp : labels) {
            JLabel label = (JLabel) comp;
            if (label.getText().contains("AdditionLinkProperty")) {
                additionLinkLabelPresent = true;
            }
        }

        assertTrue("Failed to refresh panel.", additionLinkLabelPresent);
    }

}