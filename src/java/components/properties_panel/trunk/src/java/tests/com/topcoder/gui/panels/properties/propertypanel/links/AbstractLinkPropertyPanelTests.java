/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel.links;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import com.topcoder.gui.panels.properties.MockModelElementSelectionListener;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AbstractLinkPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AbstractLinkPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The AbstractLinkPropertyPanel instance for testing.
     * </p>
     */
    private AbstractLinkPropertyPanel panel;

    /**
     * <p>
     * The PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * The PropertyKind list for testing.
     * </p>
     */
    private List<PropertyKind> properties;

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
        properties = new ArrayList<PropertyKind>();
        properties.add(PropertyKind.ABSTRACT);

        panel = new MockAbstractLinkPropertyPanel(properties, propertiesPanel, "labelText");
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
        properties = null;
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
        return new TestSuite(AbstractLinkPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor AbstractLinkPropertyPanel#AbstractLinkPropertyPanel(List,PropertiesPanel,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created AbstractLinkPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AbstractLinkPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor AbstractLinkPropertyPanel#AbstractLinkPropertyPanel(List,PropertiesPanel,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when properties is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullProperties() {
        try {
            new MockAbstractLinkPropertyPanel(null, propertiesPanel, "labelText");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractLinkPropertyPanel#AbstractLinkPropertyPanel(List,PropertiesPanel,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when properties is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyProperties() {
        properties = new ArrayList<PropertyKind>();
        try {
            new MockAbstractLinkPropertyPanel(properties, propertiesPanel, "labelText");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractLinkPropertyPanel#AbstractLinkPropertyPanel(List,PropertiesPanel,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when properties contains null element and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullInProperties() {
        properties.add(null);
        try {
            new MockAbstractLinkPropertyPanel(properties, propertiesPanel, "labelText");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AbstractLinkPropertyPanel#AbstractLinkPropertyPanel(List,PropertiesPanel,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new MockAbstractLinkPropertyPanel(properties, null, "labelText");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AbstractLinkPropertyPanel#AbstractLinkPropertyPanel(List,PropertiesPanel,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when labelText is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullLabelText() {
        try {
            new MockAbstractLinkPropertyPanel(properties, propertiesPanel, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AbstractLinkPropertyPanel#AbstractLinkPropertyPanel(List,PropertiesPanel,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when labelText is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyLabelText() {
        try {
            new MockAbstractLinkPropertyPanel(properties, propertiesPanel, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractLinkPropertyPanel#setLinkedModelElement(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * It verifies AbstractLinkPropertyPanel#setLinkedModelElement(ModelElement) is correct.
     * </p>
     */
    public void testSetLinkedModelElement() {
        ModelElement element = new GuardImpl();
        element.setName("link");
        panel.setLinkedModelElement(element);

        assertEquals("Failed to set linked element correctly.", "link",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

    /**
     * <p>
     * Tests AbstractLinkPropertyPanel#setLinkedModelElement(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when linkedModelElement is null and expects success.
     * </p>
     */
    public void testSetLinkedModelElement_NullLinkedModelElement() {
        panel.setLinkedModelElement(null);

        assertEquals("Failed to set linked element correctly.", "",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

    /**
     * <p>
     * Tests AbstractLinkPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies AbstractLinkPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        panel.configurePanel(new GuardImpl());
        panel.setLinkedModelElement(new GuardImpl());

        MockModelElementSelectionListener listener = new MockModelElementSelectionListener();
        propertiesPanel.addModelElementSelectionListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

}