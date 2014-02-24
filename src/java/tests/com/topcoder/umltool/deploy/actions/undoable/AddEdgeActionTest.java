/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.uml.actions.model.usecase.AddIncludeAction;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>AddEdgeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddEdgeActionTest extends TestCase {

    /** An instance of <code>AddIncludeEdgeAction</code> for testing. */
    private AddIncludeEdgeAction action;

    /** Start node for testing. */
    private UseCaseNode startNode = TestHelper.addUseCaseNode();

    /** Target node for testing. */
    private UseCaseNode targetNode = TestHelper.addUseCaseNode();

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        action = new AddIncludeEdgeAction(TestHelper.getMainFrame(), TestHelper.getDiagramView(DiagramType.USECASE),
                TestHelper.START, TestHelper.END, "AddIncludeEdgeAction", startNode, targetNode);
    }

    /**
     * Test method for 'AddEdgeAction(String, MainFrame, DiagramView, Node, Node)'. The instance should be created
     * successfully.
     */
    public void testAddEdgeAction_1() {
        assertNotNull("Test method for 'AddEdgeAction(String, MainFrame, DiagramView, Node, AddNodeAction)' failed.",
                action);
    }

    /**
     * Test method for 'AddEdgeAction(String, MainFrame, DiagramView, Node, AddNodeAction)'. The instance should be
     * created successfully.
     */
    public void testAddEdgeAction_2() {
        UseCaseNode startNode = TestHelper.addUseCaseNode();
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.USECASE);
        AddIncludeEdgeAction action = new AddIncludeEdgeAction(mainFrame, view, TestHelper.START, TestHelper.END,
                "AddIncludeEdgeAction", startNode, new AddUseCaseNodeAction(mainFrame, view, TestHelper.POSITION,
                        TestHelper.SIZE, "Use Case"));
        assertNotNull("Test method for 'AddEdgeAction(String, MainFrame, DiagramView, Node, AddNodeAction)' failed.",
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
     * Test method for 'getStartNode()'. Start node should be got correctly.
     */
    public void testGetStartNode() {
        assertEquals("Start node should be got correctly.", action.getStartNode(), startNode);
    }

    /**
     * Test method for 'getTargetNode()'. Target node should be got correctly.
     */
    public void testGetTargetNode() {
        assertEquals("Target node should be got correctly.", action.getTargetNode(), targetNode);
    }

    /**
     * Test method for 'getEdge()'. Edge should be got correctly.
     */
    public void testGetEdge() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        assertNotNull("Edge should be got correctly.", action.getEdge());
    }

    /**
     * Test method for 'setEdge(Edge)'. The argument is an edge, should be set correctly.
     */
    public void testSetEdge() {
        List<Point> wayPoints = new ArrayList<Point>();
        wayPoints.add(new Point(100, 100));
        wayPoints.add(new Point(200, 200));
        wayPoints.add(new Point(300, 300));

        IncludeEdge newEdge = TestHelper.addIncludeEdge(wayPoints);
        action.setEdge(newEdge);
        assertEquals("Edge should be set correctly.", action.getEdge(), newEdge);
    }

    /**
     * Test method for 'setEdge(Edge)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testSetNode_null() {
        try {
            action.setEdge(null);
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
        AddIncludeAction addAction = new AddIncludeAction(new IncludeImpl(), UMLModelManager.getInstance());
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
        TestHelper.getDiagramView(DiagramType.USECASE).removeAll();
        action = null;
        startNode = null;
        targetNode = null;
    }
}
