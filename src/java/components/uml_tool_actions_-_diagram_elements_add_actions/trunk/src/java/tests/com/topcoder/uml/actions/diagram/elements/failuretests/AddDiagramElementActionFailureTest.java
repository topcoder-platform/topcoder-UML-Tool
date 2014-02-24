/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import java.io.File;
import java.util.Iterator;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;

/**
 * This is the failure test cases for AddDiagramElementAction class.
 * 
 * @author Xuchen
 * @version 1.0
 */
public class AddDiagramElementActionFailureTest extends TestCase {

    /** The GraphElement instance used for testing.*/
    private GraphElement parent;
    
    /** The GraphElement instance used for testing.*/
    private GraphElement element;
    
    /** The ProjectConfigurationManager instance used for testing. */
    private ProjectConfigurationManager manager;
    
    /**
     * Set up the testing environment.
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        parent = new GraphNode();
        element = new GraphNode();
        ConfigManager cm = ConfigManager.getInstance();
        cm.add(new File("test_files/failure/config.xml").getAbsolutePath());
        manager = new ProjectConfigurationManager(new UMLModelManager());
    }
    
    /**
     * Clear up testing environment.
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        for (Iterator it = cm.getAllNamespaces(); it.hasNext(); ) {
            cm.removeNamespace((String) it.next());
        }
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull1() {
        try {
            new AddDiagramElementAction(null, element, manager);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull2() {
        try {
            new AddDiagramElementAction(parent, null, manager);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * Test Constructor with null argument.
     * It should throw IllegalArgumentException.
     */
    public void testConstructorNull3() {
        try {
            new AddDiagramElementAction(parent, element, null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
