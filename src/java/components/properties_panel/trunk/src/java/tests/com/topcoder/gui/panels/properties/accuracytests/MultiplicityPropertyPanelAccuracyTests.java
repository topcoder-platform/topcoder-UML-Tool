/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.MultiplicityPropertyPanel;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for MultiplicityPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class MultiplicityPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * MultiplicityPropertyPanel instance for testing.
     * </p>
     */
    private MultiplicityPropertyPanel instance;

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
        List<Multiplicity> multiplicities = new ArrayList<Multiplicity>();
        multiplicities.add(new MultiplicityImpl());
        instance = new MultiplicityPropertyPanel(propertiesPanel, multiplicities);
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
        return new TestSuite(MultiplicityPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor MultiplicityPropertyPanel#MultiplicityPropertyPanel(PropertiesPanel,List) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create MultiplicityPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests MultiplicityPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        Multiplicity multiplicity = new MultiplicityImpl();
        Attribute element = new AttributeImpl();
        element.setMultiplicity(multiplicity);
        instance.configurePanel(element);

        JComboBox comboBox = (JComboBox) AccuracyTestsHelper.getChildComponents(instance.retrievePanel(),
            JComboBox.class)[0];
        assertEquals("Failed to refresh panel.", 2, comboBox.getItemCount());
    }

    /**
     * <p>
     * Tests MultiplicityPropertyPanel#execute() for accuracy.
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