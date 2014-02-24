/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertiesPanelConfigurationException;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Failure test for PropertiesPanel calss.
 * 
 * @author Yeung
 * @version 1.0
 */
public class PropertiesPanelFailureTests extends TestCase {
    /**
     * This instance is used in the test.
     */
    private UMLModelManager umlModelManager = new UMLModelManager();

    /**
     * This instance is used in the test.
     */
    private PropertiesPanel panel;

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

        panel = new PropertiesPanel(umlModelManager);
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
     * Tests the constructor <code>PropertiesPanel(UMLModelManager)</code> with null umlModelManager, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCtor_NullUMLModelManager() throws Exception {
        try {
            new PropertiesPanel(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    
    /**
     * Tests the constructor <code>PropertiesPanel(UMLModelManager)</code> with null umlModelManager, expected
     * PropertiesPanelConfigurationException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCtor_InvalidConfiguration() throws Exception {
        tearDown();
        try {
            new PropertiesPanel(umlModelManager);
            fail("Expect PropertiesPanelConfigurationException.");
        } catch (PropertiesPanelConfigurationException e) {
            // expect
        }
    }
    
    /**
     * Tests the constructor <code>PropertiesPanel(String, UMLModelManager)</code> with null namespace, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCtor_NullNamespace() throws Exception {
        try {
            new PropertiesPanel(null, umlModelManager);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    
    /**
     * Tests the constructor <code>PropertiesPanel(String, UMLModelManager)</code> with empty namespace, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCtor_EmptyNamespace1() throws Exception {
        try {
            new PropertiesPanel("", umlModelManager);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    
    /**
     * Tests the constructor <code>PropertiesPanel(String, UMLModelManager)</code> with empty namespace, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCtor_EmptyNamespace2() throws Exception {
        try {
            new PropertiesPanel(" \t \n ", umlModelManager);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    
    /**
     * Tests the constructor <code>PropertiesPanel(String, UMLModelManager)</code> with null namespace, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCtor_NullUMLModelManager2() throws Exception {
        try {
            new PropertiesPanel("com.topcoder.gui.panels.properties", null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Tests the constructor <code>PropertiesPanel(String, UMLModelManager)</code> with null namespace, expected
     * PropertiesPanelConfigurationException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCtor_InvalidNamespace() throws Exception {
        try {
            new PropertiesPanel("invalid", umlModelManager);
            fail("Expect PropertiesPanelConfigurationException.");
        } catch (PropertiesPanelConfigurationException e) {
            // expect
        }
    }

    /**
     * Tests the method <code>configurePanel(ModelElement)</code> with null modelElement, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testConfigurePanel_NullModelElement() throws Exception {
        try {
            panel.configurePanel((ModelElement) null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Tests the method <code>configurePanel(List&lt;ModelElement&gt;)</code> with null modelElements, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testConfigurePanel_NullModelElements() throws Exception {
        try {
            panel.configurePanel((List<ModelElement>) null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Tests the method <code>configurePanel(List&lt;ModelElement&gt;)</code> with null item modelElements, expected
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
     * Tests the method <code>configurePanel(List&lt;ModelElement&gt;)</code> with empty modelElements, expected
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
     * Tests the method <code>configureProject(UMLModelManager)</code> with null umlModelManager, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testConfigureProject_NullUMLModelManager() throws Exception {
        try {
            panel.configureProject(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Tests the method <code>addModelElementChangeListener(ModelElementChangeListener)</code> with null listener,
     * expected IllegalArgumentException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddModelElementChangeListener_NullListener() throws Exception {
        try {
            panel.addModelElementChangeListener(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Tests the method <code>removeModelElementChangeListener(ModelElementChangeListener)</code> with null listener,
     * expected IllegalArgumentException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveModelElementChangeListener_NullListener() throws Exception {
        try {
            panel.removeModelElementChangeListener(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Tests the method <code>addModelElementSelectionListener(ModelElementSelectionListener)</code> with null
     * listener, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddModelElementSelectionListener_NullListener() throws Exception {
        try {
            panel.addModelElementSelectionListener(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Tests the method <code>removeModelElementSelectionListener(ModelElementSelectionListener)</code> with null
     * listener, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveModelElementSelectionListener_NullListener() throws Exception {
        try {
            panel.removeModelElementSelectionListener(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
