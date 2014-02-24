/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Dimension;
import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.AsynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.CreateMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ReturnMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SendSignalMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SynchronousMessageEdge;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>AddSequeceNodeAction</code> class.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddSequenceEdgeActionTest extends TestCase {
    /** An instance of <code>AddSequenceEdgeAction</code> for testing. */
    private AddSequenceEdgeAction[] actions = new AddSequenceEdgeAction[5];

    /** Reference to main frame for testing */
    private MainFrame mainFrame;

    /** Reference to diagram view for testing */
    private DiagramView diagramView;

    /** Start position of the sequence edge */
    private Point startPoint;

    /** End position of the sequence edge */
    private Point endPoint;

    /** Start object node of the adding sequence edge */
    private ObjectNode startNode;

    /** End object node of the adding sequence edge */
    private ObjectNode endNode;

    /** The adding sequence edge */
    private SequenceEdge[] sequenceEdges = new SequenceEdge[5];

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        mainFrame = TestHelper.getMainFrame();
        diagramView = TestHelper.getDiagramView(DiagramType.SEQUENCE);
        diagramView.setSize(new Dimension(400, 400));
        startPoint = new Point(100, 100);
        endPoint = new Point(200, 100);
        startNode = TestHelper.createObjectNode();
        endNode = TestHelper.createObjectNode();

        actions[0] =
            new AddSequenceEdgeAction(mainFrame, diagramView, startPoint, endPoint, startNode, endNode,
                SynchronousMessageEdge.class);
        sequenceEdges[0] = (SequenceEdge) actions[0].getSequenceEdge();

        actions[1] =
            new AddSequenceEdgeAction(mainFrame, diagramView, startPoint, endPoint, startNode, endNode,
                AsynchronousMessageEdge.class);
        sequenceEdges[1] = (SequenceEdge) actions[1].getSequenceEdge();

        actions[2] =
            new AddSequenceEdgeAction(mainFrame, diagramView, startPoint, endPoint, startNode, endNode,
                CreateMessageEdge.class);
        sequenceEdges[2] = (SequenceEdge) actions[2].getSequenceEdge();

        actions[3] =
            new AddSequenceEdgeAction(mainFrame, diagramView, startPoint, endPoint, startNode, endNode,
                SendSignalMessageEdge.class);
        sequenceEdges[3] = (SequenceEdge) actions[3].getSequenceEdge();

        actions[4] =
            new AddSequenceEdgeAction(mainFrame, diagramView, startPoint, endPoint, startNode, endNode,
                ReturnMessageEdge.class);
        sequenceEdges[4] = (SequenceEdge) actions[4].getSequenceEdge();

        diagramView.add(startNode);
        diagramView.add(endNode);
    }

    /**
     * Test method for 'AddSequenceEdgeAction.AddSequenceEdgeAction(MainFrame, DiagramView, Point, Point,
     * ObjectNode, ObjectNode, Class)'. The instance of action should not be null.
     */
    public void testAddSequenceEdgeAction_Accuracy_AsynchronousMessage() {
        assertNotNull(
            "Test method for 'AddSequenceEdgeAction(MainFrame, DiagramView, Point, Point, ObjectNode, ObjectNode, Class)' with class type AsynchronousMessageEdge failed.",
            actions[0]);
    }

    /**
     * Test method for 'AddSequenceEdgeAction.AddSequenceEdgeAction(MainFrame, DiagramView, Point, Point,
     * ObjectNode, ObjectNode, Class)'. The instance of action should not be null.
     */
    public void testAddSequenceEdgeAction_Accuracy_SynchronousMessage() {
        assertNotNull(
            "Test method for 'AddSequenceEdgeAction(MainFrame, DiagramView, Point, Point, ObjectNode, ObjectNode, Class)' with class type SynchronousMessageEdge failed.",
            actions[1]);
    }

    /**
     * Test method for 'AddSequenceEdgeAction.AddSequenceEdgeAction(MainFrame, DiagramView, Point, Point,
     * ObjectNode, ObjectNode, Class)'. The instance of action should not be null.
     */
    public void testAddSequenceEdgeAction_Accuracy_CreateMessage() {
        assertNotNull(
            "Test method for 'AddSequenceEdgeAction(MainFrame, DiagramView, Point, Point, ObjectNode, ObjectNode, Class)' with class type CreateMessageEdge failed.",
            actions[2]);
    }

    /**
     * Test method for 'AddSequenceEdgeAction.AddSequenceEdgeAction(MainFrame, DiagramView, Point, Point,
     * ObjectNode, ObjectNode, Class)'. The instance of action should not be null.
     */
    public void testAddSequenceEdgeAction_Accuracy_SendSignalMessage() {
        assertNotNull(
            "Test method for 'AddSequenceEdgeAction(MainFrame, DiagramView, Point, Point, ObjectNode, ObjectNode, Class)' with class type SendSignalMessageEdge failed.",
            actions[3]);
    }

    /**
     * Test method for 'AddSequenceEdgeAction.AddSequenceEdgeAction(MainFrame, DiagramView, Point, Point,
     * ObjectNode, ObjectNode, Class)'. The instance of action should not be null.
     */
    public void testAddSequenceEdgeAction_Accuracy_ReturnMesage() {
        assertNotNull(
            "Test method for 'AddSequenceEdgeAction(MainFrame, DiagramView, Point, Point, ObjectNode, ObjectNode, Class)' with class type ReturnMessageEdge  failed.",
            actions[4]);
    }

    /**
     * Test method for 'AddSequenceEdgeAction.executeAction()'.The argument is null, IllegalArgumentException
     * should be thrown.
     */
    public void testExecuteAction_Null_1() {
        try {
            new AddSequenceEdgeAction(null, diagramView, startPoint, endPoint, startNode, endNode,
                SynchronousMessageEdge.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'AddSequenceEdgeAction.executeAction()'.The argument is null, IllegalArgumentException
     * should be thrown.
     */
    public void testExecuteAction_Null_2() {
        try {
            new AddSequenceEdgeAction(mainFrame, null, startPoint, endPoint, startNode, endNode,
                SynchronousMessageEdge.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'AddSequenceEdgeAction.executeAction()'.The argument is null, IllegalArgumentException
     * should be thrown.
     */
    public void testExecuteAction_Null_3() {
        try {
            new AddSequenceEdgeAction(mainFrame, diagramView, null, endPoint, startNode, endNode,
                SynchronousMessageEdge.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'AddSequenceEdgeAction.executeAction()'.The argument is null, IllegalArgumentException
     * should be thrown.
     */
    public void testExecuteAction_Null_4() {
        try {
            new AddSequenceEdgeAction(mainFrame, diagramView, startPoint, null, startNode, endNode,
                SynchronousMessageEdge.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'AddSequenceEdgeAction.executeAction()'.The argument is null, IllegalArgumentException
     * should be thrown.
     */
    public void testExecuteAction_Null_5() {
        try {
            new AddSequenceEdgeAction(mainFrame, diagramView, startPoint, endPoint, null, endNode,
                SynchronousMessageEdge.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'AddSequenceEdgeAction.executeAction()'. New instance should be created.
     */
    public void testExecuteAction_Null_6() {
        assertNotNull(new AddSequenceEdgeAction(mainFrame, diagramView, startPoint, endPoint, startNode, null,
            SynchronousMessageEdge.class));
    }

    /**
     * Test method for 'AddSequenceEdgeAction.executeAction()'.The argument is null, IllegalArgumentException
     * should be thrown.
     */
    public void testExecuteAction_Null_7() {
        try {
            new AddSequenceEdgeAction(mainFrame, diagramView, startPoint, endPoint, startNode, endNode, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'AddSequenceEdgeAction.executeAction()'. Sequence edge should be added to diagram view.
     */
    public void testExecuteAction_AsychronousMessage() {
        try {
            actions[0].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        assertTrue("Sequence Edge should added to diagram view", TestHelper.isContainedInDiagramView(diagramView,
            sequenceEdges[0]));
        actions[0].undoAction();
    }

    /**
     * Test method for 'AddSequenceEdgeAction.executeAction()'. Sequence edge should be added to diagram view.
     */
    public void testExecuteAction_SychronousMessage() {
        try {
            actions[1].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        assertTrue("Sequence Edge should added to diagram view", TestHelper.isContainedInDiagramView(diagramView,
            sequenceEdges[1]));
        actions[1].undoAction();
    }

    /**
     * Test method for 'AddSequenceEdgeAction.executeAction()'. Sequence edge should be added to diagram view.
     */
    public void testExecuteAction_CreateMessage() {
        try {
            actions[2].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        assertTrue("Sequence Edge should added to diagram view", TestHelper.isContainedInDiagramView(diagramView,
            sequenceEdges[2]));
        actions[2].undoAction();
    }

    /**
     * Test method for 'AddSequenceEdgeAction.executeAction()'. Sequence edge should be added to diagram view.
     */
    public void testExecuteAction_SendSignalMessage() {
        try {
            actions[3].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        assertTrue("Sequence Edge should added to diagram view", TestHelper.isContainedInDiagramView(diagramView,
            sequenceEdges[3]));
        actions[3].undoAction();
    }

    /**
     * Test method for 'AddSequenceEdgeAction.executeAction()'. Sequence edge should be added to diagram view.
     */
    public void testExecuteAction_ReturnMessage() {
        try {
            actions[4].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        assertTrue("Sequence Edge should added to diagram view", TestHelper.isContainedInDiagramView(diagramView,
            sequenceEdges[4]));
        actions[4].undoAction();
    }

    /**
     * Test method for 'AddSequenceEdgeAction.undoAction()'. Sequence edge should be removed from the diagram view.
     */
    public void testUndoAction_AsynchronousMessage() {
        try {
            actions[0].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        actions[0].undoAction();
        assertFalse("Sequence Edge should removed from diagram view", TestHelper.isContainedInDiagramView(
            diagramView, sequenceEdges[0]));
    }

    /**
     * Test method for 'AddSequenceEdgeAction.undoAction()'. Sequence edge should be removed from the diagram view.
     */
    public void testUndoAction_SynchronousMessage() {
        try {
            actions[1].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        actions[1].undoAction();
        assertFalse("Sequence Edge should removed from diagram view", TestHelper.isContainedInDiagramView(
            diagramView, sequenceEdges[1]));
    }

    /**
     * Test method for 'AddSequenceEdgeAction.undoAction()'. Sequence edge should be removed from the diagram view.
     */
    public void testUndoAction_CreateMessage() {
        try {
            actions[2].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        actions[2].undoAction();
        assertFalse("Sequence Edge should removed from diagram view", TestHelper.isContainedInDiagramView(
            diagramView, sequenceEdges[2]));
    }

    /**
     * Test method for 'AddSequenceEdgeAction.undoAction()'. Sequence edge should be removed from the diagram view.
     */
    public void testUndoAction_SendSignalMessage() {
        try {
            actions[3].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        actions[3].undoAction();
        assertFalse("Sequence Edge should removed from diagram view", TestHelper.isContainedInDiagramView(
            diagramView, sequenceEdges[3]));
    }

    /**
     * Test method for 'AddSequenceEdgeAction.undoAction()'. Sequence edge should be removed from the diagram view.
     */
    public void testUndoAction_ReturnMessage() {
        try {
            actions[4].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        actions[4].undoAction();
        assertFalse("Sequence Edge should removed from diagram view", TestHelper.isContainedInDiagramView(
            diagramView, sequenceEdges[4]));
    }

    /**
     * Test method for 'AddSequenceEdgeAction.redoAction()'. Sequence edge should be added to diagram view.
     */
    public void testRedoAction_AsynchronousMessage() {
        try {
            actions[0].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        actions[0].undoAction();
        actions[0].redoAction();
        assertTrue("Sequence Edge should added to diagram view", TestHelper.isContainedInDiagramView(diagramView,
            sequenceEdges[0]));
        actions[0].undoAction();
    }

    /**
     * Test method for 'AddSequenceEdgeAction.redoAction()'. Sequence edge should be added to diagram view.
     */
    public void testRedoAction_SynchronousMessage() {
        try {
            actions[1].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        actions[1].undoAction();
        actions[1].redoAction();
        assertTrue("Sequence Edge should added to diagram view", TestHelper.isContainedInDiagramView(diagramView,
            sequenceEdges[1]));
        actions[1].undoAction();
    }

    /**
     * Test method for 'AddSequenceEdgeAction.redoAction()'. Sequence edge should be added to diagram view.
     */
    public void testRedoAction_CreateMessage() {
        try {
            actions[2].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        actions[2].undoAction();
        actions[2].redoAction();
        assertTrue("Sequence Edge should added to diagram view", TestHelper.isContainedInDiagramView(diagramView,
            sequenceEdges[2]));
        actions[2].undoAction();
    }

    /**
     * Test method for 'AddSequenceEdgeAction.redoAction()'. Sequence edge should be added to diagram view.
     */
    public void testRedoAction_SendSignalMessage() {
        try {
            actions[3].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        actions[3].undoAction();
        actions[3].redoAction();
        assertTrue("Sequence Edge should added to diagram view", TestHelper.isContainedInDiagramView(diagramView,
            sequenceEdges[3]));
        actions[3].undoAction();
    }

    /**
     * Test method for 'AddSequenceEdgeAction.redoAction()'. Sequence edge should be added to diagram view.
     */
    public void testRedoAction_ReturnMessage() {
        try {
            actions[4].executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        actions[4].undoAction();
        actions[4].redoAction();
        assertTrue("Sequence Edge should added to diagram view", TestHelper.isContainedInDiagramView(diagramView,
            sequenceEdges[4]));
        actions[4].undoAction();
    }

    /**
     * Test method for 'AddSequenceEdgeAction.getSequenceEdge()'
     */
    public void testGetSequenceEdge() {
        actions[0].getSequenceEdge();
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        diagramView.remove(startNode);
        diagramView.remove(endNode);

        startNode = null;
        endNode = null;
        startPoint = null;
        endPoint = null;
        for (int i = 0; i < 5; i++) {
            sequenceEdges[i] = null;
            actions[i] = null;
        }

        diagramView = null;
        mainFrame = null;
    }

}
