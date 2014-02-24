/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AddDiagramElementAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddDiagramElementActionTests extends TestCase {
    /**
     * <p>
     * AddDiagramElementAction instance for testing.
     * </p>
     */
    private AddDiagramElementAction action;

    /**
     * <p>
     * GraphElement instance for helping testing.
     * </p>
     */
    private GraphElement parent;

    /**
     * <p>
     * GraphElement instance for helping testing.
     * </p>
     */
    private GraphElement child;

    /**
     * <p>
     * ProjectConfigurationManager instance for helping testing.
     * </p>
     */
    private ProjectConfigurationManager manager;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(ProjectConfigurationManager.class.getName(), "test_files/config.xml");
        TestHelper.loadSingleXMLConfig(ProjectConfigurationManager.class.getName() + ".objectfactory",
            "test_files/objectfactory.xml");

        parent = new GraphNode();
        child = new GraphNode();
        manager = new ProjectConfigurationManager(new UMLModelManager());
        manager.addInitialDiagramFormatter(manager.getDefaultProjectLanguage(),
            new MockInitialDiagramElementFormatter());

        action = new AddDiagramElementAction(parent, child, manager);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        parent = null;
        child = null;
        manager = null;

        action = null;

        TestHelper.clearConfigFile(ProjectConfigurationManager.class.getName());
        TestHelper.clearConfigFile(ProjectConfigurationManager.class.getName() + ".objectfactory");
        System.clearProperty("exception");
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(AddDiagramElementActionTests.class);
    }

    /**
     * <p>
     * Tests ctor AddDiagramElementAction#AddDiagramElementAction(GraphElement,
     * GraphElement,ProjectConfigurationManager) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created AddDiagramElementAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AddDiagramElementAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor AddDiagramElementAction#AddDiagramElementAction(GraphElement,
     * GraphElement,ProjectConfigurationManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when parent is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullParent() {
        try {
            new AddDiagramElementAction(null, child, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddDiagramElementAction#AddDiagramElementAction(GraphElement,
     * GraphElement,ProjectConfigurationManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when child is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullChild() {
        try {
            new AddDiagramElementAction(parent, null, manager);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AddDiagramElementAction#AddDiagramElementAction(GraphElement,
     * GraphElement,ProjectConfigurationManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when manager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullManager() {
        try {
            new AddDiagramElementAction(parent, child, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AddDiagramElementAction#getProjectConfigurationManager() for accuracy.
     * </p>
     *
     * <p>
     * Verify : getProjectConfigurationManager() is correct.
     * </p>
     */
    public void testGetProjectConfigurationManager() {
        assertSame("Failed to get correct project configuration manager.", manager,
            action.getProjectConfigurationManager());
    }

    /**
     * <p>
     * Tests AddDiagramElementAction#getChild() for accuracy.
     * </p>
     *
     * <p>
     * Verify : getChild() is correct.
     * </p>
     */
    public void testGetChild() {
        assertSame("Failed to get correct child element.", child, action.getChild());
    }

    /**
     * <p>
     * Tests AddDiagramElementAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Redo is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedo() throws Exception {
        action.execute();
        action.undo();

        action.redo();

        assertTrue("The relationship should be set up.", parent.containsContained(child));
        assertFalse("The child diagram element should be formatted.", child.isVisible());
    }

    /**
     * <p>
     * Tests AddDiagramElementAction#redo() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when ActionExecutionException is thrown during execution and expects
     * the exception is set to lastException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedo_ActionExecutionException() throws Exception {
        action.execute();
        action.undo();

        System.setProperty("exception", "ProjectConfigurationException");

        action.redo();

        assertNotNull("The lastException should be set", action.getLastException());
    }

    /**
     * <p>
     * Tests AddDiagramElementAction#redo() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the action is not executed before redo operation and expects CannotRedoException.
     * </p>
     *
     */
    public void testRedo_CannotRedoException() {
        try {
            action.redo();
            fail("CannotRedoException expected.");
        } catch (CannotRedoException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests AddDiagramElementAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : undo() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndo() throws Exception {
        action.execute();

        action.undo();

        assertFalse("The relationship should be cleared.", parent.containsContained(child));
    }

    /**
     * <p>
     * Tests AddDiagramElementAction#undo() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the action is not executed before undo operation and expects CannotUndoException.
     * </p>
     */
    public void testUndo_CannotUndoException() {
        try {
            action.undo();
            fail("CannotUndoException expected.");
        } catch (CannotUndoException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests AddDiagramElementAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : execute() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        action.execute();

        assertTrue("The relationship should be set up.", parent.containsContained(child));
        assertFalse("The child diagram element should be formatted.", child.isVisible());
    }

    /**
     * <p>
     * Tests AddDiagramElementAction#execute() for failure.
     * </p>
     *
     * <p>
     * Expects ActionExecutionException.
     * </p>
     */
    public void testExecute_ActionExecutionException() {
        System.setProperty("exception", "ProjectConfigurationException");

        try {
            action.execute();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }
}