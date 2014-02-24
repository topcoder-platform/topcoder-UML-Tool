/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;

import com.topcoder.gui.panels.properties.MockModelElementChangeListener;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for NamePropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class NamePropertyPanelTests extends TestCase {
    /**
     * <p>
     * The NamePropertyPanel instance for testing.
     * </p>
     */
    private NamePropertyPanel panel;

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

        panel = new NamePropertyPanel(propertiesPanel);
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
        return new TestSuite(NamePropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor NamePropertyPanel#NamePropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created NamePropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new NamePropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor NamePropertyPanel#NamePropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new NamePropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests NamePropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when there is one registered element and verifies
     * NamePropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_OneRegistered() {
        Transition element = new TransitionImpl();
        element.setName("new");

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", "new",
            ((JFormattedTextField) panel.retrievePanel().getComponent(2)).getText());
        assertEquals("Failed to refresh panel correctly.", "new",
            ((JFormattedTextField) panel.retrievePanel().getComponent(2)).getValue());
    }

    /**
     * <p>
     * Tests NamePropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when there is different name and verifies
     * NamePropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_DifferentName() {
        Transition element1 = new TransitionImpl();
        element1.setName("new");
        Transition element2 = new TransitionImpl();
        element2.setName("old");

        List<ModelElement> elements = new ArrayList<ModelElement>();
        elements.add(element1);
        elements.add(element2);

        panel.configurePanel(elements);

        assertEquals("Failed to refresh panel correctly.", "",
            ((JFormattedTextField) panel.retrievePanel().getComponent(2)).getText());
        assertEquals("Failed to refresh panel correctly.", "",
            ((JFormattedTextField) panel.retrievePanel().getComponent(2)).getValue());
    }

    /**
     * <p>
     * Tests NamePropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies NamePropertyPanel#execute() is correct.
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