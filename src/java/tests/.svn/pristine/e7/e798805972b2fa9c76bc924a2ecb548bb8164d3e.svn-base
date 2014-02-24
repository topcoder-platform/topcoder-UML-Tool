/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.EventObject;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.uml.actions.general.ChangePositionAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Test the functionality of <code>ChangePositionHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangePositionHandlerTest extends TestCase {

    /** An instance of UseCaseNode for testing. */
    private UseCaseNode node;

    /** Old position of graph node. */
    private Point oldPosition;

    /** New position of the graph node for testing. */
    private Point newPosition = DeployHelper.createPoint(200, 200);

    /** Expected new location of node. */
    private java.awt.Point expectedLocation = new java.awt.Point();

    /** Old location of node. */
    private java.awt.Point oldLocation;

    /** An instance of <code>ChangePositionAction</code> for testing. */
    private ChangePositionAction action;

    /** An instance of <code>ChangePositionHandler</code> for testing. */
    private ChangePositionHandler handler;

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
        handler = new ChangePositionHandler(TestHelper.getMainFrame());
        node = TestHelper.addUseCaseNode();
        oldLocation = node.getLocation();
        GraphNode graphNode = node.getGraphNode();
        oldPosition = graphNode.getPosition();
        expectedLocation.x = (int) (newPosition.getX() - oldPosition.getX()) + oldLocation.x;
        expectedLocation.y = (int) (newPosition.getY() - oldPosition.getY()) + oldLocation.y;
        action = new ChangePositionAction(graphNode, newPosition);
        event = new EventObject(node);
        undoEvent = new UndoChangesEvent(action, node);
        redoEvent = new RedoChangesEvent(action, node);
    }

    /**
     * Test method for 'ChangePositionHandler(MainFrame)'. The instance should be created successfully.
     */
    public void testChangePositionHandler_Accuracy() {
        assertNotNull("Test method for 'ChangePositionHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'ChangePositionHandler(MainFrame)'. The argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testChangePositionHandler_null() {
        try {
            new ChangePositionHandler(null);
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
        assertEquals("Node should be move to a correct location", node.getLocation(), expectedLocation);
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
        assertEquals("Node should be moved to old location.", node.getLocation(), oldLocation);
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
        assertEquals("Node should be move to a correct location", node.getLocation(), expectedLocation);
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

        newPosition = null;

        action = null;

        handler = null;

        event = null;

        undoEvent = null;

        redoEvent = null;
    }
}
