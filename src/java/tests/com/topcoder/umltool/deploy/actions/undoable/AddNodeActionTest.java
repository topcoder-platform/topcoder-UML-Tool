/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.actions.model.usecase.AddUseCaseAction;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>AddNodeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddNodeActionTest extends TestCase {

    /** An instance of <code>AddUseCaseNodeAction</code> for testing. */
    private AddUseCaseNodeAction action;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        action = new AddUseCaseNodeAction(TestHelper.getMainFrame(), TestHelper.getDiagramView(DiagramType.USECASE),
                TestHelper.POSITION, TestHelper.SIZE, "AddActorNodeAction");
    }

    /**
     * Test method for 'AddNodeAction(MainFrame, DiagramView, Point, Dimension, String)'. The instance should be created
     * successfully.
     */
    public void testAddNodeAction_1() {
        assertNotNull(
                "Test method for 'AddUseCaseNodeAction(MainFrame, DiagramView, Point, Dimension, String)' failed.",
                action);
    }

    /**
     * Test method for 'AddNodeAction(MainFrame, DiagramView, Point, Dimension, String, NodeContainer)'. The instance
     * should be created successfully.
     */
    public void testAddNodeAction_2() {
        AddUseCaseNodeAction action = new AddUseCaseNodeAction(TestHelper.getMainFrame(), TestHelper
                .getDiagramView(DiagramType.USECASE), TestHelper.POSITION, TestHelper.SIZE, "AddUseCaseNodeAction",
                null);
        assertNotNull(
                "Test method for 'AddUseCaseNodeAction(MainFrame, DiagramView, Point, Dimension, String, NodeContainer)' failed.",
                action);
    }

    /**
     * Test method for 'getMainFrame()'. Main frame should be got correctly.
     */
    public void testGetMainFrame() {
        assertNotNull("Main frame should be got correctly.", action.getMainFrame());
    }

    /**
     * Test method for 'getDiagramView()'. Diagram view should be got correctly.
     */
    public void testGetDiagramView() {
        assertNotNull("Diagram view should be got correctly.", action.getDiagramView());
    }

    /**
     * Test method for 'getNodeContainer()'. Node container should be got correctly.
     */
    public void testGetNodeContainer() {
        assertNull("Node container should be got correctly.", action.getNodeContainer());
    }

    /**
     * Test method for 'getNode()'. Node should be got correctly.
     */
    public void testGetNode() {
        assertNotNull("Node should be got correctly.", action.getNode());
    }

    /**
     * Test method for 'setNode(Node)'. The argument is a node, should be set correctly.
     */
    public void testSetNode_Accuracy() {
        UseCaseNode newNode = TestHelper.addUseCaseNode();
        action.setNode(newNode);
        assertEquals("Node should be set correctly.", action.getNode(), newNode);
    }

    /**
     * Test method for 'setNode(Node)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testSetNode_null() {
        try {
            action.setNode(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'setAddModelElementAction(UndoableAction)'. The argument is a valid action, should be set
     * correctly.
     */
    public void testSetAddModelElementAction_Accuracy() {
        AddUseCaseAction addAction = new AddUseCaseAction(new UseCaseImpl(), UMLModelManager.getInstance());
        action.setAddModelElementAction(addAction);
    }

    /**
     * Test method for 'setAddModelElementAction(UndoableAction)'. The argument is null, IllegalArgumentException should
     * be thrown.
     */
    public void testSetAddModelElementAction_null() {
        try {
            action.setAddModelElementAction(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'setAddDiagramElementAction(AddDiagramElementAction)'. The argument is a valid action, should be
     * set correctly.
     */
    public void testSetAddDiagramElementAction_Accuracy() {
        GraphNode graphNode = DeployHelper.createGraphNodeForUseCase(new UseCaseImpl(), TestHelper.POSITION,
                TestHelper.SIZE);
        AddDiagramElementAction addAction = new AddDiagramElementAction(TestHelper.getDiagramView(DiagramType.USECASE)
                .getDiagram(), graphNode, UMLModelManager.getInstance().getProjectConfigurationManager());
        action.setAddDiagramElementAction(addAction);
    }

    /**
     * Test method for 'setAddDiagramElementAction(AddDiagramElementAction)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testSetAddDiagramElementAction_null() {
        try {
            action.setAddDiagramElementAction(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'executeAction()'. Action should be executed correctly.
     */
    public void testExecuteAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'undoAction()'. Action should be undone correctly.
     */
    public void testUndoAction() {
        try {
            action.executeAction();
            action.undoAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'redoAction()'. Action should be redone correctly.
     */
    public void testRedoAction() {
        try {
            action.executeAction();
            action.undoAction();
            action.redoAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        action = null;
    }
}
