/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for AbstractLinkPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class AbstractLinkPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * AbstractLinkPropertyPanel instance for testing.
     * </p>
     */
    private AbstractLinkPropertyPanelMock instance;

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
        List<PropertyKind> properties = new ArrayList<PropertyKind>();
        properties.add(PropertyKind.ACTION_LINK);
        propertiesPanel = new PropertiesPanel(new UMLModelManager());

        instance = new AbstractLinkPropertyPanelMock(properties, propertiesPanel, "text");
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
        return new TestSuite(AbstractLinkPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor AbstractLinkPropertyPanel#AbstractLinkPropertyPanel(List,PropertiesPanel,String) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create AbstractLinkPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests AbstractLinkPropertyPanel#setLinkedModelElement(ModelElement) for accuracy.
     * </p>
     */
    public void testSetLinkedModelElement() {
        ModelElement element = new InterfaceImpl();
        element.setName("AbstractLink");
        instance.setLinkedModelElement(element);

        Component[] labels = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class);

        boolean labelPresent = false;
        for (Component comp : labels) {
            JLabel label = (JLabel) comp;
            if (label.getText().contains("AbstractLink")) {
                labelPresent = true;
            }
        }

        assertTrue("Failed to refresh panel.", labelPresent);
    }

    /**
     * <p>
     * Tests AbstractLinkPropertyPanel#execute() for accuracy.
     * </p>
     */
    public void testExecute() {
        instance.configurePanel(new InterfaceImpl());
        instance.setLinkedModelElement(new InterfaceImpl());
        ModelElementSelectionListenerMock listener = new ModelElementSelectionListenerMock();
        propertiesPanel.addModelElementSelectionListener(listener);
        instance.execute();

        assertTrue("Failed to execute.", listener.IsCalled());
    }

}
