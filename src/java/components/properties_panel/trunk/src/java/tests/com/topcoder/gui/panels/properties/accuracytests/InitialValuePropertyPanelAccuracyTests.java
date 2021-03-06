/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import javax.swing.JFormattedTextField;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.InitialValuePropertyPanel;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpressionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for InitialValuePropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class InitialValuePropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * InitialValuePropertyPanel instance for testing.
     * </p>
     */
    private InitialValuePropertyPanel instance;

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
        instance = new InitialValuePropertyPanel(propertiesPanel);
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
        return new TestSuite(InitialValuePropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor InitialValuePropertyPanel#InitialValuePropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create InitialValuePropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests InitialValuePropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        BooleanExpression expression = new BooleanExpressionImpl();
        expression.setBody("InitialValue");
        Attribute element = new AttributeImpl();
        element.setInitialValue(expression);
        instance.configurePanel(element);

        JFormattedTextField textField = (JFormattedTextField) AccuracyTestsHelper.getChildComponents(
            instance.retrievePanel(), JFormattedTextField.class)[0];
        assertEquals("Failed to refresh panel.", "InitialValue", textField.getText());
    }

    /**
     * <p>
     * Tests InitialValuePropertyPanel#execute() for accuracy.
     * </p>
     */
    public void testExecute() {
        instance.configurePanel(new AttributeImpl());
        ModelElementChangeListenerMock listener = new ModelElementChangeListenerMock();
        propertiesPanel.addModelElementChangeListener(listener);
        instance.execute();

        assertTrue("Failed to execute.", listener.IsCalled());
    }

}