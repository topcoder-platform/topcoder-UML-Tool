/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import javax.swing.JLabel;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.AssociationEndsPropertyPanel;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for AssociationEndsPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class AssociationEndsPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * AssociationEndsPropertyPanel instance for testing.
     * </p>
     */
    private AssociationEndsPropertyPanel instance;

    /**
     * <p>
     * PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        propertiesPanel = new PropertiesPanel(new UMLModelManager());
        instance = new AssociationEndsPropertyPanel(propertiesPanel);
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
        propertiesPanel = null;
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
        return new TestSuite(AssociationEndsPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor AssociationEndsPropertyPanel#AssociationEndsPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create AssociationEndsPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests AssociationEndsPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        AssociationEnd end1 = new AssociationEndImpl();
        end1.setName("AssociationEnds");
        Association element = new AssociationImpl();
        element.addConnection(end1);
        instance.configurePanel(element);

        JLabel label1 = (JLabel) AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class)[0];
        JLabel label2 = (JLabel) AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class)[1];
        assertEquals("Failed to refresh panel.", "Start", label1.getText());
        assertEquals("Failed to refresh panel.", "End", label2.getText());
    }

    /**
     * <p>
     * Tests AssociationEndsPropertyPanel#execute() for accuracy.
     * </p>
     */
    public void testExecute() {
        instance.execute();
    }

}