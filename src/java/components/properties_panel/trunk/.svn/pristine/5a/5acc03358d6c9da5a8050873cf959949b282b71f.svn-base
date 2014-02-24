/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import javax.swing.JList;
import javax.swing.JScrollPane;

import com.topcoder.gui.panels.properties.MockModelElementSelectionListener;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.statemachines.FinalStateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for OutgoingTransitionPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class OutgoingTransitionPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The OutgoingTransitionPropertyPanel instance for testing.
     * </p>
     */
    private OutgoingTransitionPropertyPanel panel;

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

        panel = new OutgoingTransitionPropertyPanel(propertiesPanel);
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
        return new TestSuite(OutgoingTransitionPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor OutgoingTransitionPropertyPanel#OutgoingTransitionPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created OutgoingTransitionPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new OutgoingTransitionPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor OutgoingTransitionPropertyPanel#OutgoingTransitionPropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new OutgoingTransitionPropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests OutgoingTransitionPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies OutgoingTransitionPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        Transition transition = new TransitionImpl();
        StateVertex element = new FinalStateImpl();
        element.addOutgoingTransition(transition);

        panel.configurePanel(element);

        JScrollPane scrollPane = (JScrollPane) panel.retrievePanel().getComponent(0);
        assertEquals("Failed to refresh panel correctly.", 1,
            ((JList) scrollPane.getViewport().getView()).getModel().getSize());
    }

    /**
     * <p>
     * Tests OutgoingTransitionPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies OutgoingTransitionPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        Transition transition = new TransitionImpl();
        StateVertex element = new FinalStateImpl();
        element.addOutgoingTransition(transition);

        panel.configurePanel(element);

        JScrollPane scrollPane = (JScrollPane) panel.retrievePanel().getComponent(0);
        ((JList) scrollPane.getViewport().getView()).setSelectedIndex(0);

        MockModelElementSelectionListener listener = new MockModelElementSelectionListener();
        propertiesPanel.addModelElementSelectionListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests OutgoingTransitionPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when no item is selected and verifies
     * OutgoingTransitionPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute_NoItemSelected() {
        panel.configurePanel(new FinalStateImpl());

        MockModelElementSelectionListener listener = new MockModelElementSelectionListener();
        propertiesPanel.addModelElementSelectionListener(listener);

        panel.execute();

        assertFalse("Failed to execute correctly.", listener.getIsExecuted());
    }

}