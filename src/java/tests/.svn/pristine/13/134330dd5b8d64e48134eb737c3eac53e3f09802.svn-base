/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.actions.diagram.RemoveDiagramAction;
import com.topcoder.uml.actions.diagram.RemoveSequenceDiagramAction;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.eventmanager.ActionEvent;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Test the functionality of <code>RemoveDiagramHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveDiagramHandlerTest extends TestCase {
    /** Reference to main frame for testing */
    private MainFrame mainFrame;

    /** An instance of <code>RemoveDiagramHandler</code> for testing. */
    private RemoveDiagramHandler handler;

    /** Remove diagram action that triggers this handler */
    private RemoveDiagramAction removeDiagramAction;

    /** Action event to perform execute */
    private ActionEvent actionEvent;

    /** Action event to perform undo */
    private UndoChangesEvent undoEvent;

    /** Action event to perform redo */
    private RedoChangesEvent redoEvent;

    /** Reference to the removing diagram */
    private Diagram diagram;

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
        diagram = TestHelper.getDiagramView(DiagramType.SEQUENCE).getDiagram();
        removeDiagramAction = new RemoveSequenceDiagramAction(diagram);
        actionEvent = new ActionEvent(removeDiagramAction, diagram);
        undoEvent = new UndoChangesEvent(removeDiagramAction, diagram);
        redoEvent = new RedoChangesEvent(removeDiagramAction, diagram);
        handler = new RemoveDiagramHandler(mainFrame);
    }

    /**
     * Test method for 'RemoveDiagramHandler.RemoveDiagramHandler(MainFrame)'. The instance should be created
     * successfully.
     */
    public void testRemoveDiagramHandler_Accuracy() {
        assertNotNull("Test method for 'ChangePositionHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'RemoveDiagramHandler.RemoveDiagramHandler(MainFrame)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testRedoActionPerformed_Null() {
        try {
            new RemoveDiagramHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'RemoveDiagramHandler.actionPerformed(EventObject, EventValidation)'. diagram should be closed
     * and removed.
     */
    public void testActionPerformed_Accuracy() {
        handler.actionPerformed(actionEvent, EventValidation.SUCCESSFUL);

        assertTrue("Current diagram is not the removing one", TestHelper.getCurrentDiagram() != diagram);

        handler.undoActionPerformed(undoEvent, removeDiagramAction);
    }

    /**
     * Test method for 'RemoveDiagramHandler.actionPerformed(EventObject, EventValidation)'.The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testActionPerformed_Null_1() {
        try {
            handler.actionPerformed(null, EventValidation.SUCCESSFUL);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'RemoveDiagramHandler.actionPerformed(EventObject, EventValidation)'.The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testActionPerformed_Null_2() {
        try {
            handler.actionPerformed(actionEvent, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'RemoveDiagramHandler.undoActionPerformed(UndoChangesEvent, UndoableAction)'. diagram should be
     * added back and showed.
     */
    public void testUndoActionPerformed_Accuracy() {
        handler.actionPerformed(actionEvent, EventValidation.SUCCESSFUL);
        handler.undoActionPerformed(undoEvent, removeDiagramAction);

        assertTrue("Current diagram should be the removed one", TestHelper.getCurrentDiagram() == diagram);
    }

    /**
     * Test method for 'RemoveDiagramHandler.undoActionPerformed(UndoChangesEvent, UndoableAction)'. The argument is
     * null, IllegalArgumentException should be thrown.
     */
    public void testUndoActionPerformed_Null_1() {
        try {
            handler.undoActionPerformed(null, removeDiagramAction);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'RemoveDiagramHandler.undoActionPerformed(UndoChangesEvent, UndoableAction)'. The argument is
     * null, IllegalArgumentException should be thrown.
     */
    public void testUndoActionPerformed_Null_2() {
        try {
            handler.undoActionPerformed(undoEvent, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'RemoveDiagramHandler.redoActionPerformed(RedoChangesEvent, UndoableAction)'. diagram should be
     * closed and removed.
     */
    public void testRedoActionPerformed_Accuracy() {
        handler.actionPerformed(actionEvent, EventValidation.SUCCESSFUL);
        handler.undoActionPerformed(undoEvent, removeDiagramAction);
        handler.redoActionPerformed(redoEvent, removeDiagramAction);

        assertTrue("Current diagram should not be the removed one", TestHelper.getCurrentDiagram() != diagram);

        handler.undoActionPerformed(undoEvent, removeDiagramAction);
    }

    /**
     * Test method for 'RemoveDiagramHandler.redoActionPerformed(RedoChangesEvent, UndoableAction)'. The argument is
     * null, IllegalArgumentException should be thrown.
     */
    public void testRedoActionPerformed_Null_1() {
        try {
            handler.redoActionPerformed(null, removeDiagramAction);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'RemoveDiagramHandler.redoActionPerformed(RedoChangesEvent, UndoableAction)'. The argument is
     * null, IllegalArgumentException should be thrown.
     */
    public void testRedoActionPerformed_Null_2() {
        try {
            handler.redoActionPerformed(redoEvent, null);
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
        mainFrame = null;
        diagram = null;
        removeDiagramAction = null;
        actionEvent = null;
        undoEvent = null;
        redoEvent = null;
    }

}
