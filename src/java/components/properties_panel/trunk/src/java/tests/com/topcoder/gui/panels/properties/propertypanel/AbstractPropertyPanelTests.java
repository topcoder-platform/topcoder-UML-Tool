/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AbstractPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AbstractPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The MockAbstractPropertyPanel instance for testing.
     * </p>
     */
    private MockAbstractPropertyPanel panel;

    /**
     * <p>
     * The PropertyKind list for testing.
     * </p>
     */
    private List<PropertyKind> properties;

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

        properties = new ArrayList<PropertyKind>();
        properties.add(PropertyKind.ABSTRACT);
        propertiesPanel = new PropertiesPanel(new UMLModelManager());

        panel = new MockAbstractPropertyPanel(properties, propertiesPanel);
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
        properties = null;

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
        return new TestSuite(AbstractPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor AbstractPropertyPanel#AbstractPropertyPanel(List,PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created AbstractPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AbstractPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor AbstractPropertyPanel#AbstractPropertyPanel(List,PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when properties is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullProperties() {
        try {
            new MockAbstractPropertyPanel(null, propertiesPanel);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#AbstractPropertyPanel(List,PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when properties is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyProperties() {
        properties.remove(0);
        try {
            new MockAbstractPropertyPanel(properties, propertiesPanel);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#AbstractPropertyPanel(List,PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when properties contains null element and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullInProperties() {
        properties.add(null);
        try {
            new MockAbstractPropertyPanel(properties, propertiesPanel);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AbstractPropertyPanel#AbstractPropertyPanel(List,PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new MockAbstractPropertyPanel(properties, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#configurePanel(ModelElement) for accuracy.
     * </p>
     *
     * <p>
     * It verifies AbstractPropertyPanel#configurePanel(ModelElement) is correct.
     * </p>
     */
    public void testConfigurePanel1() {
        Interface element = new InterfaceImpl();
        panel.configurePanel(element);

        assertTrue("Failed to configure panel correctly.", panel.getIsExecuted());
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#configurePanel(ModelElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElement is null and expects IllegalArgumentException.
     * </p>
     */
    public void testConfigurePanel1_NullModelElement() {
        try {
            panel.configurePanel((ModelElement) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#configurePanel(List) for accuracy.
     * </p>
     *
     * <p>
     * It verifies AbstractPropertyPanel#configurePanel(List) is correct.
     * </p>
     */
    public void testConfigurePanel2() {
        List<ModelElement> elements = new ArrayList<ModelElement>();
        Interface element = new InterfaceImpl();
        elements.add(element);
        panel.configurePanel(elements);

        assertTrue("Failed to configure panel correctly.", panel.getIsExecuted());
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#configurePanel(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElements is null and expects IllegalArgumentException.
     * </p>
     */
    public void testConfigurePanel2_NullModelElements() {
        try {
            panel.configurePanel((List<ModelElement>) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#configurePanel(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElements is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testConfigurePanel2_EmptyModelElements() {
        List<ModelElement> elements = new ArrayList<ModelElement>();
        try {
            panel.configurePanel(elements);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#configurePanel(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElements contains null element and expects IllegalArgumentException.
     * </p>
     */
    public void testConfigurePanel2_NullInModelElements() {
        List<ModelElement> elements = new ArrayList<ModelElement>();
        elements.add(null);
        try {
            panel.configurePanel(elements);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#retrievePanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies AbstractPropertyPanel#retrievePanel() is correct.
     * </p>
     */
    public void testRetrievePanel() {
        assertNotNull("Failed to retrieve panel correctly.", panel.retrievePanel());
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#isPropertySupported(PropertyKind) for accuracy.
     * </p>
     *
     * <p>
     * It verifies AbstractPropertyPanel#isPropertySupported(PropertyKind) is correct.
     * </p>
     */
    public void testIsPropertySupported() {
        assertTrue("Failed to return the value correctly.", panel.isPropertySupported(PropertyKind.ABSTRACT));
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#isPropertySupported(PropertyKind) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when property is null and expects IllegalArgumentException.
     * </p>
     */
    public void testIsPropertySupported_NullProperty() {
        try {
            panel.isPropertySupported(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#getSupportedProperties() for accuracy.
     * </p>
     *
     * <p>
     * It verifies AbstractPropertyPanel#getSupportedProperties() is correct.
     * </p>
     */
    public void testGetSupportedProperties() {
        List<PropertyKind> kinds = panel.getSupportedProperties();
        assertEquals("Expected the size of kinds is one.", 1, kinds.size());
        assertEquals("Failed to get the supported properties correctly.", PropertyKind.ABSTRACT, kinds.get(0));
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#isConfigured() for accuracy.
     * </p>
     *
     * <p>
     * It verifies AbstractPropertyPanel#isConfigured() is correct.
     * </p>
     */
    public void testIsConfigured() {
        panel.setConfigured(true);
        assertTrue("Failed to return the value correctly.", panel.isConfigured());
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#getConfiguredModelElements() for accuracy.
     * </p>
     *
     * <p>
     * It verifies AbstractPropertyPanel#getConfiguredModelElements() is correct.
     * </p>
     */
    public void testGetConfiguredModelElements() {
        List<ModelElement> modelElements = new ArrayList<ModelElement>();
        ModelElement element = new GuardImpl();
        modelElements.add(element);

        panel.setConfiguredModelElements(modelElements);
        List<ModelElement> elements = panel.getConfiguredModelElements();

        assertEquals("Expected the size of elements is one.", 1, elements.size());
        assertSame("Failed to get the configured elements correctly.", element, elements.get(0));
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#getPropertiesPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies AbstractPropertyPanel#getPropertiesPanel() is correct.
     * </p>
     */
    public void testGetPropertiesPanel() {
        assertSame("Failed to get the properties panel correctly.", this.propertiesPanel, panel.getPropertiesPanel());
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#setConfigured(boolean) for accuracy.
     * </p>
     *
     * <p>
     * It verifies AbstractPropertyPanel#setConfigured(boolean) is correct.
     * </p>
     */
    public void testSetConfigured() {
        panel.setConfigured(true);
        assertTrue("Failed to set the configured correctly.", panel.isConfigured());
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#setConfiguredModelElements(List) for accuracy.
     * </p>
     *
     * <p>
     * It verifies AbstractPropertyPanel#setConfiguredModelElements(List) is correct.
     * </p>
     */
    public void testSetConfiguredModelElements() {
        List<ModelElement> modelElements = new ArrayList<ModelElement>();
        ModelElement element = new GuardImpl();
        modelElements.add(element);

        panel.setConfiguredModelElements(modelElements);
        List<ModelElement> elements = panel.getConfiguredModelElements();

        assertEquals("Expected the size of elements is one.", 1, elements.size());
        assertSame("Failed to set the configured elements correctly.", element, elements.get(0));
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#setConfiguredModelElements(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElements is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetConfiguredModelElements_NullModelElements() {
        try {
            panel.setConfiguredModelElements(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#setConfiguredModelElements(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElements is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testSetConfiguredModelElements_EmptyModelElements() {
        List<ModelElement> modelElements = new ArrayList<ModelElement>();
        try {
            panel.setConfiguredModelElements(modelElements);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#setConfiguredModelElements(List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElements contains null element and expects IllegalArgumentException.
     * </p>
     */
    public void testSetConfiguredModelElements_NullInModelElements() {
        List<ModelElement> modelElements = new ArrayList<ModelElement>();
        modelElements.add(new GuardImpl());
        modelElements.add(null);

        try {
            panel.setConfiguredModelElements(modelElements);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AbstractPropertyPanel#isVisible() for accuracy.
     * </p>
     *
     * <p>
     * It verifies AbstractPropertyPanel#isVisible() is correct.
     * </p>
     */
    public void testIsVisible() {
        assertFalse("Failed to return the value correctly.", panel.isVisible());
    }

}