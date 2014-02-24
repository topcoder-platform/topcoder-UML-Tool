/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import javax.swing.JList;
import javax.swing.JScrollPane;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.IncomingTransitionPropertyPanel;
import com.topcoder.uml.model.statemachines.FinalStateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for IncomingTransitionPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class IncomingTransitionPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * IncomingTransitionPropertyPanel instance for testing.
     * </p>
     */
    private IncomingTransitionPropertyPanel instance;

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
        instance = new IncomingTransitionPropertyPanel(propertiesPanel);
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
        return new TestSuite(IncomingTransitionPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor IncomingTransitionPropertyPanel#IncomingTransitionPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create IncomingTransitionPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests IncomingTransitionPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        Transition transition = new TransitionImpl();
        StateVertex element = new FinalStateImpl();
        element.addIncomingTransition(transition);
        instance.configurePanel(element);

        JScrollPane scrollPane = (JScrollPane) instance.retrievePanel().getComponent(0);
        assertEquals("Failed to refresh panel.", 1, ((JList) scrollPane.getViewport().getView()).getModel().getSize());
    }

    /**
     * <p>
     * Tests IncomingTransitionPropertyPanel#execute() for accuracy.
     * </p>
     */
    public void testExecute() {
        Transition transition = new TransitionImpl();
        StateVertex element = new FinalStateImpl();
        element.addIncomingTransition(transition);
        instance.configurePanel(element);
        JScrollPane scrollPane = (JScrollPane) instance.retrievePanel().getComponent(0);
        ((JList) scrollPane.getViewport().getView()).setSelectedIndex(0);
        ModelElementSelectionListenerMock listener = new ModelElementSelectionListenerMock();
        propertiesPanel.addModelElementSelectionListener(listener);
        instance.execute();

        assertTrue("Failed to execute.", listener.IsCalled());
    }

}