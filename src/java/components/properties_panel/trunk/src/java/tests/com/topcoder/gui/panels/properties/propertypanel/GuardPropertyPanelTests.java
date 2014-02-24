/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import javax.swing.JFormattedTextField;

import com.topcoder.gui.panels.properties.MockModelElementChangeListener;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpressionImpl;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for GuardPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GuardPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The GuardPropertyPanel instance for testing.
     * </p>
     */
    private GuardPropertyPanel panel;

    /**
     * <p>
     * The PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);
        propertiesPanel = new PropertiesPanel(new UMLModelManager());

        panel = new GuardPropertyPanel(propertiesPanel);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        panel = null;
        propertiesPanel = null;

        TestHelper.clearConfigFile(TestHelper.NAMESPACE);
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(GuardPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor GuardPropertyPanel#GuardPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created GuardPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new GuardPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor GuardPropertyPanel#GuardPropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new GuardPropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests GuardPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when there is one registered element and verifies
     * GuardPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_OneRegistered() {
        BooleanExpression expression = new BooleanExpressionImpl();
        expression.setBody("body");
        Guard guard = new GuardImpl();
        guard.setExpression(expression);
        Transition element = new TransitionImpl();
        element.setGuard(guard);

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", "body",
            ((JFormattedTextField) panel.retrievePanel().getComponent(2)).getText());
        assertEquals("Failed to refresh panel correctly.", "body",
            ((JFormattedTextField) panel.retrievePanel().getComponent(2)).getValue());
    }

    /**
     * <p>
     * Tests GuardPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when there is zero registered element and verifies
     * GuardPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_ZeroRegistered() {
        Transition element = new TransitionImpl();

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", "",
            ((JFormattedTextField) panel.retrievePanel().getComponent(2)).getText());
        assertEquals("Failed to refresh panel correctly.", "",
            ((JFormattedTextField) panel.retrievePanel().getComponent(2)).getValue());
    }

    /**
     * <p>
     * Tests GuardPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies GuardPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        panel.configurePanel(new TransitionImpl());

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

}