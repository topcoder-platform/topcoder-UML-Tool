/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;

import com.topcoder.gui.panels.properties.MockModelElementChangeListener;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for KindPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class KindPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The KindPropertyPanel instance for testing.
     * </p>
     */
    private KindPropertyPanel panel;

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

        panel = new KindPropertyPanel(propertiesPanel);
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
        return new TestSuite(KindPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor KindPropertyPanel#KindPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created KindPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new KindPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor KindPropertyPanel#KindPropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new KindPropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests KindPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies KindPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        Parameter element = new ParameterImpl();
        element.setKind(ParameterDirectionKind.IN);

        panel.configurePanel(element);

        assertTrue("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(1)).isSelected());
    }

    /**
     * <p>
     * Tests KindPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when no button is selected and verifies
     * KindPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoVisible() {
        panel.refreshPanel();

        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(0)).isSelected());
        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(1)).isSelected());
        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(2)).isSelected());
        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(3)).isSelected());
    }

    /**
     * <p>
     * Tests KindPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when no button is selected and verifies
     * KindPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoButtonSelected() {
        List<ModelElement> elements = new ArrayList<ModelElement>();
        Parameter element1 = new ParameterImpl();
        element1.setKind(ParameterDirectionKind.IN);
        Parameter element2 = new ParameterImpl();

        elements.add(element1);
        elements.add(element2);
        panel.configurePanel(elements);

        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(0)).isSelected());
        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(1)).isSelected());
        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(2)).isSelected());
        assertFalse("Failed to refresh panel correctly.",
            ((JRadioButton) panel.retrievePanel().getComponent(3)).isSelected());
    }

    /**
     * <p>
     * Tests KindPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies KindPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        panel.configurePanel(new AssociationEndImpl());

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests KindPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies KindPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute_Inout() {
        Parameter element = new ParameterImpl();
        element.setKind(ParameterDirectionKind.INOUT);

        panel.configurePanel(element);

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests KindPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies KindPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute_In() {
        Parameter element = new ParameterImpl();
        element.setKind(ParameterDirectionKind.IN);

        panel.configurePanel(element);

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests KindPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies KindPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute_Out() {
        Parameter element = new ParameterImpl();
        element.setKind(ParameterDirectionKind.OUT);

        panel.configurePanel(element);

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }
}