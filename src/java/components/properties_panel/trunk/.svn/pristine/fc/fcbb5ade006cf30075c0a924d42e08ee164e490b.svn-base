/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import javax.swing.JFormattedTextField;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.GuardPropertyPanel;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpressionImpl;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for GuardPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class GuardPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * GuardPropertyPanel instance for testing.
     * </p>
     */
    private GuardPropertyPanel instance;

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
        instance = new GuardPropertyPanel(propertiesPanel);
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
        return new TestSuite(GuardPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor GuardPropertyPanel#GuardPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create GuardPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests GuardPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        BooleanExpression expression = new BooleanExpressionImpl();
        expression.setBody("Guard");
        Guard guard = new GuardImpl();
        guard.setExpression(expression);
        Transition element = new TransitionImpl();
        element.setGuard(guard);
        instance.configurePanel(element);

        JFormattedTextField textField = (JFormattedTextField) AccuracyTestsHelper.getChildComponents(
            instance.retrievePanel(), JFormattedTextField.class)[0];
        assertEquals("Failed to refresh panel.", "Guard", textField.getText());
        assertEquals("Failed to refresh panel.", "Guard", textField.getValue());
    }

    /**
     * <p>
     * Tests GuardPropertyPanel#execute() for accuracy.
     * </p>
     */
    public void testExecute() {
        instance.configurePanel(new TransitionImpl());
        ModelElementChangeListenerMock listener = new ModelElementChangeListenerMock();
        propertiesPanel.addModelElementChangeListener(listener);
        instance.execute();

        assertTrue("Failed to execute.", listener.IsCalled());
    }

}