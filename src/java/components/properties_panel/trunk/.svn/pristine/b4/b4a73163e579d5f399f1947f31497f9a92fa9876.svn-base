/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests.propertypanel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.propertypanel.AbstractPropertyPanel;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.config.ConfigManager;

/**
 * Failure tests for AbstractPropertyPanel class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class AbstractPropertyPanelFailureTests extends TestCase {
    /**
     * This instance is used in the test.
     */
    private UMLModelManager umlModelManager = new UMLModelManager();

    /**
     * This instance is used in the test.
     */
    private PropertiesPanel propertiesPanel;

    /**
     * The MockAbstractPropertyPanel instance to test against.
     */
    private MockAbstractPropertyPanel panel;

    /**
     * Sets up the test environment.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    protected void setUp() throws Exception {
        // get the config manager
        ConfigManager cm = ConfigManager.getInstance();
        cm.add("failure/config.xml");

        propertiesPanel = new PropertiesPanel(umlModelManager);

        List<PropertyKind> list = new ArrayList<PropertyKind>();
        list.add(PropertyKind.AGGREGATION);

        panel = new MockAbstractPropertyPanel(list, propertiesPanel);
    }

    /**
     * Tears down the test environment.
     * 
     * @throws Exception
     *             if any error occurred when tear down
     */
    protected void tearDown() throws Exception {
        ConfigManager manager = ConfigManager.getInstance();
        for (Iterator iter = manager.getAllNamespaces(); iter.hasNext();) {
            manager.removeNamespace((String) iter.next());
        }
    }

    /**
     * Tests the constructor AbstractPropertyPanel(List&lt;PropertyKind&gt;, PropertiesPanel) with null properties,
     * expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullProperties() throws Exception {
        try {
            new MockAbstractPropertyPanel(null, propertiesPanel);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor AbstractPropertyPanel(List&lt;PropertyKind&gt;, PropertiesPanel) with null propertiesPanel,
     * expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullPropertiesPanel() throws Exception {
        List<PropertyKind> list = new ArrayList<PropertyKind>();
        list.add(PropertyKind.AGGREGATION);
        try {
            new MockAbstractPropertyPanel(list, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor AbstractPropertyPanel(List&lt;PropertyKind&gt;, PropertiesPanel) with empty properties,
     * expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_EmptyProperties() throws Exception {
        try {
            new MockAbstractPropertyPanel(new ArrayList<PropertyKind>(), propertiesPanel);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor AbstractPropertyPanel(List&lt;PropertyKind&gt;, PropertiesPanel) with null item properties,
     * expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullItemProperties() throws Exception {
        List<PropertyKind> list = new ArrayList<PropertyKind>();
        list.add(null);
        try {
            new MockAbstractPropertyPanel(list, propertiesPanel);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method configurePanel(ModelElement) with null modelElement, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testConfigurePanel_NullModelElement() throws Exception {
        try {
            panel.configurePanel((ModelElement) null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method configurePanel(List&lt;ModelElement&gt;) with null modelElements, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testConfigurePanel_NullModelElements() throws Exception {
        try {
            panel.configurePanel((List<ModelElement>) null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method configurePanel(List&lt;ModelElement&gt;) with null item modelElements, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testConfigurePanel_NullItemModelElements() throws Exception {
        List<ModelElement> list = new ArrayList<ModelElement>();
        list.add(null);
        try {
            panel.configurePanel(list);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method configurePanel(List&lt;ModelElement&gt;) with empty modelElements, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testConfigurePanel_EmptyModelElements() throws Exception {
        List<ModelElement> list = new ArrayList<ModelElement>();
        try {
            panel.configurePanel(list);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method isPropertySupported(PropertyKind) with null property, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testIsPropertySupported_NullProperty() throws Exception {
        try {
            panel.isPropertySupported(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setConfiguredModelElements(List&lt;ModelElement&gt;) with null modelElements, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testSetConfiguredModelElements_NullModelElements() throws Exception {
        try {
            panel.setConfiguredModelElements((List<ModelElement>) null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setConfiguredModelElements(List&lt;ModelElement&gt;) with empty modelElements, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testSetConfiguredModelElements_EmptyModelElements() throws Exception {
        List<ModelElement> list = new ArrayList<ModelElement>();
        try {
            panel.setConfiguredModelElements(list);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setConfiguredModelElements(List&lt;ModelElement&gt;) with null item modelElements, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testSetConfiguredModelElements_NullItemModelElements() throws Exception {
        List<ModelElement> list = new ArrayList<ModelElement>();
        list.add(null);
        try {
            panel.setConfiguredModelElements(list);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * This mock class is used in the test.
     * 
     * @author TCSDEVELOPER
     * @version 1.0
     */
    private class MockAbstractPropertyPanel extends AbstractPropertyPanel {

        /**
         * <p>
         * Creates a new instance of <code>AbstractPropertyPanel</code>.
         * </p>
         * 
         * @param properties
         *            the list of properties supported
         * @param propertiesPanel
         *            the PropertiesPanel instance that owns this panel
         * @throws IllegalArgumentException
         *             if either argument is null or properties is empty or contain null member
         */
        public MockAbstractPropertyPanel(List<PropertyKind> properties, PropertiesPanel propertiesPanel) {
            super(properties, propertiesPanel);
        }

        /**
         * <p>
         * Refreshes the panel.
         * </p>
         * <p>
         * This does not re-configure the panel display but only refreshed the property values displayed to reflect the
         * most up-to-date ModelElement's property values. The method is invoked if a ModelElement whose property is
         * being displayed had its property or properties changed from outside Properties Panel.
         * </p>
         * <p>
         * <strong>Implementation Notes:</strong> All the refreshPanel() implementation MUST check that isVisible()
         * returns true before performing anything else. If isVisible() is false, return immediately. Remember to
         * setConfigured(false) before performing refresh logic, and setConfigured(true) afterwards.
         * </p>
         */
        public void refreshPanel() {
        }

        /**
         * <p>
         * Executes the logic that occurs when a property value corresponding to this property panel is changed.
         * </p>
         */
        public void execute() {
        }

        /**
         * <p>
         * Sets the list of ModelElement that this instance is configured with. Called from <code>configurePanel</code>
         * methods.
         * </p>
         * 
         * @param modelElements
         *            the list of ModelElement that this instance is configured with
         * @throws IllegalArgumentException
         *             if the list is null or empty or contains null element
         */
        public void setConfiguredModelElements(List<ModelElement> modelElements) {
            super.setConfiguredModelElements(modelElements);
        }
    }
}