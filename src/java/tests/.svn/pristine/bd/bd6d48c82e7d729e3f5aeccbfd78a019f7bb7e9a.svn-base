/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveObjectNodeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveObjectNodeActionTest extends TestCase {
    /** Reference to main frame for testing */
    private MainFrame mainFrame;

    /** Reference to diagram view for testing */
    private DiagramView diagramView;

    /** An instance of <code>RemoveObjectNodeAction</code> for testing. */
    private RemoveObjectNodeAction action;

    /** ObjectNode to remove */
    private ObjectNode objectNode;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        mainFrame = TestHelper.getMainFrame();
        diagramView = TestHelper.getDiagramView(DiagramType.SEQUENCE);
        Diagram diagram = diagramView.getDiagram();

        Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) diagram.getOwner();
        Collaboration collaboration = (Collaboration) bridge.getElement();

        objectNode = TestHelper.createObjectNode();
        diagramView.add(objectNode);

        objectNode.getObject().setNamespace(collaboration);
        collaboration.addOwnedElement(objectNode.getObject());

        action = new RemoveObjectNodeAction(mainFrame, objectNode);
    }

    /**
     * Test method for 'RemoveObjectNodeAction.RemoveObjectNodeAction(MainFrame, ObjectNode)'. Instance of action should
     * not be null.
     */
    public void testRemoveObjectNodeAction_Accuracy() {
        assertNotNull("Test method for 'RemoveCollaborationAction(MainFrame, ObjectNode)' failed.", action);
    }

    /**
     * Test method for 'RemoveObjectNodeAction.RemoveObjectNodeAction(MainFrame, ObjectNode)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveObjectNodeAction_Null_1() {
        try {
            new RemoveObjectNodeAction(null, objectNode);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'RemoveObjectNodeAction.RemoveObjectNodeAction(MainFrame, ObjectNode)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveObjectNodeAction_Null_2() {
        try {
            new RemoveObjectNodeAction(mainFrame, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'RemoveObjectNodeAction.executeAction()'. Object node should be removed from diagram view.
     */
    public void testExecuteAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        assertFalse("Object node should be removed from diagram view", TestHelper.isContainedInDiagramView(diagramView,
                objectNode));
        action.undoAction();
    }

    /**
     * Test method for 'RemoveObjectNodeAction.undoAction()'
     */
    public void testUndoAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        action.undoAction();
        assertTrue("Object node should be added back to diagram view", TestHelper.isContainedInDiagramView(diagramView,
                objectNode));
    }

    /**
     * Test method for 'RemoveObjectNodeAction.redoAction()'
     */
    public void testRedoAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        action.undoAction();
        action.redoAction();
        assertFalse("Object node should be removed from diagram view", TestHelper.isContainedInDiagramView(diagramView,
                objectNode));
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        objectNode = null;
        mainFrame = null;
        diagramView = null;
        action = null;
    }

}
