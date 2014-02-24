

/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests.propertypanel.links;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.propertypanel.links.AbstractLinkPropertyPanel;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;


/**
 * Failure tests for AbstractLinkPropertyPane class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class AbstractLinkPropertyPanelFailureTests extends TestCase {
    /**
     * This instance is used in the test.
     */
    private UMLModelManager umlModelManager = new UMLModelManager();

    /**
     * This instance is used in the test.
     */
    private PropertiesPanel propertiesPanel;

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
     * Tests the constructor AbstractLinkPropertyPanel(List&lt;PropertyKind&gt;, PropertiesPanel, String) with null
     * properties, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullProperties() throws Exception {
        try {
            new MockAbstractLinkPropertyPanel(null, propertiesPanel, "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor AbstractLinkPropertyPanel(List&lt;PropertyKind&gt;, PropertiesPanel, String) with null
     * propertiesPanel, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullPropertiesPanel() throws Exception {
        List<PropertyKind> list = new ArrayList<PropertyKind>();
        list.add(PropertyKind.AGGREGATION);
        try {
            new MockAbstractLinkPropertyPanel(list, null, "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor AbstractLinkPropertyPanel(List&lt;PropertyKind&gt;, PropertiesPanel, String) with empty
     * properties, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_EmptyProperties() throws Exception {
        try {
            new MockAbstractLinkPropertyPanel(new ArrayList<PropertyKind>(), propertiesPanel, "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor AbstractLinkPropertyPanel(List&lt;PropertyKind&gt;, PropertiesPanel, String) with null item
     * properties, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullItemProperties() throws Exception {
        List<PropertyKind> list = new ArrayList<PropertyKind>();
        list.add(null);
        try {
            new MockAbstractLinkPropertyPanel(list, propertiesPanel, "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
    
    /**
     * Tests the constructor AbstractLinkPropertyPanel(List&lt;PropertyKind&gt;, PropertiesPanel, String) with null
     * labelText, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullLabelText() throws Exception {
        List<PropertyKind> list = new ArrayList<PropertyKind>();
        list.add(PropertyKind.AGGREGATION);
        try {
            new MockAbstractLinkPropertyPanel(list, propertiesPanel, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
    
    /**
     * Tests the constructor AbstractLinkPropertyPanel(List&lt;PropertyKind&gt;, PropertiesPanel, String) with empty
     * labelText, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_EmptyLabelText1() throws Exception {
        List<PropertyKind> list = new ArrayList<PropertyKind>();
        list.add(PropertyKind.AGGREGATION);
        try {
            new MockAbstractLinkPropertyPanel(list, propertiesPanel, "");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor AbstractLinkPropertyPanel(List&lt;PropertyKind&gt;, PropertiesPanel, String) with empty
     * labelText, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_EmptyLabelText2() throws Exception {
        List<PropertyKind> list = new ArrayList<PropertyKind>();
        list.add(PropertyKind.AGGREGATION);
        try {
            new MockAbstractLinkPropertyPanel(list, propertiesPanel, " \t \n ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
    /**
     * This mock class is used in the test.
     * 
     * @author Yeung
     * @version 1.0
     */
    private class MockAbstractLinkPropertyPanel extends AbstractLinkPropertyPanel {

        /**
         * <p>
         * Creates a new instance of <code>MockAbstractLinkPropertyPanel</code>. Initialized the GUI elements.
         * </p>
         * 
         * @param properties
         *            the supported PropertyKind
         * @param propertiesPanel
         *            the PropertiesPanel that owns this panel
         * @param labelText
         *            the property name to be displayed
         * @throws IllegalArgumentException
         *             if any argument is null, or properties is empty or contains null element, or labelText is empty
         *             string
         */
        public MockAbstractLinkPropertyPanel(List<PropertyKind> properties, PropertiesPanel propertiesPanel,
            String labelText) {
            super(properties, propertiesPanel, labelText);
        }

        /**
         * <p>
         * Refreshes the panel.
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
    }
}
