/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import java.io.File;
import java.util.Iterator;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>AddDiagramElementAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestAddDiagramElementActionAccuracy extends TestCase {

    /**
     * Represents the parent GraphElement.
     */
    private GraphElement parent = null;

    /**
     * Represents the child GraphElement.
     */
    private GraphElement child = null;

    /**
     * Represents the ProjectConfigurationManager instance.
     */
    private ProjectConfigurationManager manager;

    /**
     * Represents the AddDiagramElementAction instance for testing.
     */
    private AddDiagramElementAction action = null;

    /**
     * Set up the environment.
     *
     * @throws Exception
     *             to junit.
     */
    public void setUp() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator iter = cm.getAllNamespaces(); iter.hasNext();) {
            cm.removeNamespace((String) iter.next());
        }

        String namespace = ProjectConfigurationManager.class.getName();
        cm.add(namespace, new File("test_files/accuracy/config.xml").getCanonicalPath(),
                ConfigManager.CONFIG_XML_FORMAT);

        cm.add(namespace + ".objectfactory", new File("test_files/accuracy/objectfactory.xml").getCanonicalPath(),
                ConfigManager.CONFIG_XML_FORMAT);

        manager = new ProjectConfigurationManager(new UMLModelManager());

        parent = new GraphNode();
        child = new GraphNode();

        action = new AddDiagramElementAction(parent, child, manager);
    }

    /**
     * Tear down the environment. clear all the namespace in the config manager.
     *
     * @throws Exception
     *             to junit.
     */
    public void tearDown() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator iter = cm.getAllNamespaces(); iter.hasNext();) {
            cm.removeNamespace((String) iter.next());
        }
    }

    /**
     * Test the constructor.
     *
     */
    public void testAddDiagramElementAction() {
        assertNotNull("The AddDiagramElementAction instance should be created.", action);
    }

    /**
     * Test method ProjectConfigurationManager getProjectConfigurationManager()
     *
     */
    public void testGetProjectConfigurationManager() {
        assertEquals("Equal is expected.", manager, action.getProjectConfigurationManager());
    }

    /**
     * Test method redo.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRedo() throws Exception {
        assertEquals("The parent element has 0 containeds.", 0, action.getElement().countContaineds());
        action.execute();

        assertEquals("The parent element has 1 containeds.", 1, action.getElement().countContaineds());

        action.undo();
        assertEquals("The parent element has 0 containeds.", 0, action.getElement().countContaineds());
        action.redo();

        assertEquals("The parent element has 1 containeds.", 1, action.getElement().countContaineds());
    }

    /**
     * Test method undo.
     *
     * @throws Exception
     *             to junit.
     */
    public void testUndo() throws Exception {
        assertEquals("The parent element has 0 containeds.", 0, action.getElement().countContaineds());
        action.execute();

        assertEquals("The parent element has 1 containeds.", 1, action.getElement().countContaineds());

        action.undo();
        assertEquals("The parent element has 0 containeds.", 0, action.getElement().countContaineds());

    }

    /**
     * Test method getChild.
     *
     */
    public void testGetChild() {
        assertEquals("Equal is expected.", child, action.getChild());
    }

    /**
     * Test method execute.
     *
     * @throws Exception
     *             to junit.
     */
    public void testExecute() throws Exception {
        assertEquals("The parent element has 0 containeds.", 0, action.getElement().countContaineds());
        action.execute();

        assertEquals("The parent element has 1 containeds.", 1, action.getElement().countContaineds());
    }
}