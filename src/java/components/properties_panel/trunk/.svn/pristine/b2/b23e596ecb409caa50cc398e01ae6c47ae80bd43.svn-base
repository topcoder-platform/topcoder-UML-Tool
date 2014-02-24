/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.propertypanel.AbstractPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.AggregationPropertyPanel;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for AbstractPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class AbstractPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * AbstractPropertyPanel instance for testing.
     * </p>
     */
    private AbstractPropertyPanel instance;

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
        instance = new AggregationPropertyPanel(propertiesPanel);
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
        return new TestSuite(AbstractPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor AbstractPropertyPanel#AbstractPropertyPanel(List,PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create AbstractPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#configurePanel(ModelElement) for accuracy.
     * </p>
     */
    public void testConfigurePanel1() {
        AssociationEnd element = new AssociationEndImpl();
        element.setAggregation(AggregationKind.AGGREGATE);
        instance.configurePanel(element);

        JRadioButton button = (JRadioButton) AccuracyTestsHelper.getChildComponents(instance.retrievePanel(),
            JRadioButton.class)[1];
        assertTrue("Failed to configure panel.", button.isSelected());

    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#configurePanel(List) for accuracy.
     * </p>
     */
    public void testConfigurePanel2() {
        List<ModelElement> elements = new ArrayList<ModelElement>();
        AssociationEnd element = new AssociationEndImpl();
        element.setAggregation(AggregationKind.AGGREGATE);
        elements.add(element);
        instance.configurePanel(elements);

        JRadioButton button = (JRadioButton) AccuracyTestsHelper.getChildComponents(instance.retrievePanel(),
            JRadioButton.class)[1];
        assertTrue("Failed to configure panel.", button.isSelected());
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#retrievePanel() for accuracy.
     * </p>
     */
    public void testRetrievePanel() {
        assertNotNull("Failed to retrieve panel.", instance.retrievePanel());
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#isPropertySupported(PropertyKind) for accuracy.
     * </p>
     */
    public void testIsPropertySupported() {
        assertFalse("Failed to return the value.", instance.isPropertySupported(PropertyKind.ABSTRACT));
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#getSupportedProperties() for accuracy.
     * </p>
     */
    public void testGetSupportedProperties() {
        assertEquals("Failed to get the supported properties.", PropertyKind.AGGREGATION,
            instance.getSupportedProperties().get(0));
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#isVisible() for accuracy.
     * </p>
     */
    public void testIsVisible() {
        assertFalse("Failed to return the value.", instance.isVisible());
    }

}