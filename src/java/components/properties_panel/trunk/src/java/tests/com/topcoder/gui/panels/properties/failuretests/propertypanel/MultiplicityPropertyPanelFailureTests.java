/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests.propertypanel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.MultiplicityPropertyPanel;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Failure tests for MultiplicityPropertyPanel class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class MultiplicityPropertyPanelFailureTests extends TestCase {
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
     * Tests the constructor MultiplicityPropertyPanel(PropertiesPanel, List&lt;Multiplicity&gt;) with null
     * propertiesPanel, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullPropertiesPanel() throws Exception {
        List<Multiplicity> list = new ArrayList<Multiplicity>();
        list.add(new MultiplicityImpl());
        list.add(new MultiplicityImpl());
        list.add(new MultiplicityImpl());
        try {
            new MultiplicityPropertyPanel(null, list);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor MultiplicityPropertyPanel(PropertiesPanel, List&lt;Multiplicity&gt;) with null
     * multiplicities, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullMultiplicities() throws Exception {
        try {
            new MultiplicityPropertyPanel(propertiesPanel, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor MultiplicityPropertyPanel(PropertiesPanel, List&lt;Multiplicity&gt;) with empty
     * multiplicities, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_EmptyMultiplicities() throws Exception {
        List<Multiplicity> list = new ArrayList<Multiplicity>();

        try {
            new MultiplicityPropertyPanel(propertiesPanel, list);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor MultiplicityPropertyPanel(PropertiesPanel, List&lt;Multiplicity&gt;) with null item
     * multiplicities, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullItemMultiplicities() throws Exception {
        List<Multiplicity> list = new ArrayList<Multiplicity>();
        list.add(null);
        try {
            new MultiplicityPropertyPanel(propertiesPanel, list);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}