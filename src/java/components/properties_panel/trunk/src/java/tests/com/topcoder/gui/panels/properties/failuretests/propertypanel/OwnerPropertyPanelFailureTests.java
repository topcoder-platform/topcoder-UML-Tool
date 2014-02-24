
/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests.propertypanel;

import java.util.Iterator;

import javax.swing.ImageIcon;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.OwnerPropertyPanel;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Failure tests for OwnerPropertyPanel class.
 *
 * @author Yeung
 * @version 1.0
 */
public class OwnerPropertyPanelFailureTests extends TestCase {
    /**
     * This instance is used in the test.
     */
    private PropertiesPanel propertiesPanel;
    
    /**
     * This instance is used in the test.
     */
    private UMLModelManager umlModelManager = new UMLModelManager();
    
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
     * Tests the constructor OwnerPropertyPanel(PropertiesPanel, Icon) with null propertiesPanel, expected
     * IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullPropertiesPanel() throws Exception {
        try {
            new OwnerPropertyPanel(null, new ImageIcon());
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
    
    /**
     * Tests the constructor OwnerPropertyPanel(PropertiesPanel, Icon) with null icon, expected
     * IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullIcon() throws Exception {
        try {
            new OwnerPropertyPanel(propertiesPanel, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}
