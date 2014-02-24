/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.EventObject;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.uml.actions.general.ChangeSizeAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Test the functionality of <code>ChangeSizeHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeSizeHandlerTest extends TestCase {
    /** Main frame window for testing. */
    private MainFrame MAINFRAME;

    /** An instance of UseCaseNode for testing. */
    private UseCaseNode node;

    /** An instance of GraphNode for testing. */
    private GraphNode graphNode;

    /** The size of the graph node. Used for testing only. */
    private Dimension oldSize;

    /** New size of the graph node for testing. */
    private Dimension newSize;

    /** An instance of <code>ChangeSizeAction</code> for testing. */
    private ChangeSizeAction action;

    /** An instance of <code>ChangeSizeHandler</code> for testing. */
    private ChangeSizeHandler handler;

    /** Event for executing. */
    private EventObject event;

    /** Event for undoing. */
    private UndoChangesEvent undoEvent;

    /** Event for redoing. */
    private RedoChangesEvent redoEvent;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        MAINFRAME = new MainFrame();
        handler = new ChangeSizeHandler(MAINFRAME);
        node = TestHelper.addUseCaseNode();
        java.awt.Dimension newDimension = new java.awt.Dimension(300, 200);
        newSize = DeployHelper.createDimension(newDimension);
        graphNode = node.getGraphNode();
        oldSize = graphNode.getSize();
        action = new ChangeSizeAction(graphNode, newSize);
        event = new EventObject(node);
        undoEvent = new UndoChangesEvent(action, node);
        redoEvent = new RedoChangesEvent(action, node);
    }

    /**
     * Test method for 'ChangeSizeHandler(MainFrame)'. The instance should be created successfully.
     */
    public void testChangeSizeHandler_Accuracy() {
        assertNotNull("Test method for 'ChangeSizeHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'ChangeSizeHandler(MainFrame)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testChangeSizeHandler_null() {
        try {
            new ChangeSizeHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'actionPerformed(EventObject, EventValidation)'. Valid event is given, should perform
     * successfully.
     */
    public void testActionPerformed_Accuracy() {
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        handler.actionPerformed(event, EventValidation.SUCCESSFUL);
        assertEquals("Node should be changed to the new size", graphNode.getSize(), newSize);
    }

    /**
     * Test method for 'actionPerformed(EventObject, EventValidation)'. Null event is given, IllegalArgumentException
     * should be thrown.
     */
    public void testActionPerformed_null() {
        try {
            handler.actionPerformed(null, EventValidation.SUCCESSFUL);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'undoActionPerformed(UndoChangesEvent, UndoableAction)'. Valid event is given, should perform
     * successfully.
     */
    public void testUndoActionPerformed_Accuracy() {
        try {
            action.execute();
            handler.actionPerformed(event, EventValidation.SUCCESSFUL);
            action.undo();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        handler.undoActionPerformed(undoEvent, action);
        assertEquals("Node should be changed to the old size.", graphNode.getSize(), oldSize);
    }

    /**
     * Test method for 'undoActionPerformed(UndoChangesEvent, UndoableAction)'. Null event is given,
     * IllegalArgumentException should be thrown.
     */
    public void testUndoActionPerformed_null() {
        try {
            handler.undoActionPerformed(null, action);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'redoActionPerformed(RedoChangesEvent, UndoableAction)'. Valid event is given, should perform
     * successfully.
     */
    public void testRedoActionPerformed_Accuracy() {
        try {
            action.execute();
            handler.actionPerformed(event, EventValidation.SUCCESSFUL);
            action.undo();
            handler.undoActionPerformed(undoEvent, action);
            action.redo();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        handler.redoActionPerformed(redoEvent, action);
        assertEquals("Node should be changed to a correct size", graphNode.getSize(), newSize);
    }

    /**
     * Test method for 'redoActionPerformed(RedoChangesEvent, UndoableAction)'. Null event is given,
     * IllegalArgumentException should be thrown.
     */
    public void testRedoActionPerformed_null() {
        try {
            handler.redoActionPerformed(null, action);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        newSize = null;

        action = null;

        handler = null;

        event = null;

        undoEvent = null;

        redoEvent = null;
    }
}
