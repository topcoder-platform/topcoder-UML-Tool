/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.EventObject;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.umltool.deploy.actions.undoable.RemoveDiagramElementAction;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Test the functionality of <code>RemoveDiagramElementHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveDiagramElementHandlerTest extends TestCase {
    /** An instance of <code>RemoveDiagramElementAction</code> for testing. */
    private RemoveDiagramElementAction action;

    /** An instance of <code>RemoveDiagramElementHandler</code> for testing. */
    private RemoveDiagramElementHandler handler;

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
        super.setUp();

        handler = new RemoveDiagramElementHandler(TestHelper.getMainFrame());
        UseCaseNode node = TestHelper.addUseCaseNode();
        action = new RemoveDiagramElementAction(TestHelper.getDiagramView(DiagramType.USECASE).getDiagram(), node
                .getGraphNode());

        event = new EventObject(node);
        undoEvent = new UndoChangesEvent(action, node);
        redoEvent = new RedoChangesEvent(action, node);
    }

    /**
     * Test method for 'RemoveDiagramElementHandler(MainFrame)'. The instance should be created successfully.
     */
    public void testRemoveDiagramElementHandler_Accuracy() {
        assertNotNull("Test method for 'RemoveDiagramElementHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'RemoveDiagramElementHandler(MainFrame)'. The argument is null, IllegalArgumentException should
     * be thrown.
     */
    public void testRemoveDiagramElementHandler_null() {
        try {
            new RemoveDiagramElementHandler(null);
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
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        handler.actionPerformed(event, EventValidation.SUCCESSFUL);
        action.undo();
        handler.undoActionPerformed(undoEvent, action);
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
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        handler.actionPerformed(event, EventValidation.SUCCESSFUL);
        action.undo();
        handler.undoActionPerformed(undoEvent, action);
        action.redo();
        handler.redoActionPerformed(redoEvent, action);
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

        TestHelper.getDiagramView(DiagramType.USECASE).removeAll();

        action = null;

        handler = null;

        event = null;

        undoEvent = null;

        redoEvent = null;
    }
}
