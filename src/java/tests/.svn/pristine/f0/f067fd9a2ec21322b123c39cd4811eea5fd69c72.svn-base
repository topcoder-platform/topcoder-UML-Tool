/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.uml.actions.general.ChangePositionAction;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.ActionManager;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.EventManager;

/**
 * <p>
 * Test the functionality of <code>CompositeUndoableAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class CompositeUndoableActionTest extends TestCase {
    /** An instance of <code>CompositeUndoableAction</code> for testing. */
    private CompositeUndoableAction action;

    /** Undoable actions to be added to composite action */
    private UndoableAction[] undoableActions;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        action = new CompositeUndoableAction("Testing");
        action.setEventManager(TestHelper.getMainFrame().getEventManager());

        undoableActions = new UndoableAction[2];

        GraphNode graphNode = new GraphNode();
        undoableActions[0] = new ChangePositionAction(graphNode, new Point());
        undoableActions[1] = new ChangePositionAction(graphNode, new Point());

        ObjectNode objectNode = TestHelper.createObjectNode();

        action.put(undoableActions[0], objectNode);
        action.put(undoableActions[1], objectNode);
    }

    /**
     * Test method for 'CompositeUndoableAction.CompositeUndoableAction(String)'. The action instance should not be
     * null.
     */
    public void testCompositeUndoableAction_Accuracy() {
        assertNotNull("Test method for 'CompositeUndoableAction.CompositeUndoableAction(String' failed.", action);
    }

    /**
     * Test method for 'CompositeUndoableAction.CompositeUndoableAction(String)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddObjectNodeAction_Null() {
        try {
            new CompositeUndoableAction(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'CompositeUndoableAction.executeAction()'. Actions in composite action should be executed.
     */
    public void testExecuteAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        assertTrue("Undoable actions in composite action should be executed", undoableActions[0].canUndo());
        assertTrue("Undoable actions in composite action should be executed", undoableActions[1].canUndo());
        action.undoAction();
    }

    /**
     * Test method for 'CompositeUndoableAction.undoAction()'. Actions in composite action should be undone.
     */
    public void testUndoAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        action.undoAction();
        assertTrue("Undoable actions in composite action should be undone", undoableActions[0].canRedo());
        assertTrue("Undoable actions in composite action should be undone", undoableActions[1].canRedo());
    }

    /**
     * Test method for 'CompositeUndoableAction.redoAction()'. Actions in composite action should be redone.
     */
    public void testRedoAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        action.undoAction();
        action.redoAction();
        assertTrue("Undoable actions in composite action should be redone", undoableActions[0].canUndo());
        assertTrue("Undoable actions in composite action should be redone", undoableActions[1].canUndo());
        action.undoAction();
    }

    /**
     * Test method for 'CompositeUndoableAction.put(UndoableAction, Object)'. Undoable action could be put into
     * composite action.
     */
    public void testPut() {
        int count = action.countActions();
        action.put(undoableActions[0], new Object());
        assertTrue("One more undoable action is put into composite action. ", action.countActions() == count + 1);
    }

    /**
     * Test method for 'CompositeUndoableAction.setEventManager(EventManager)'. Event manager could be set.
     */
    public void testSetEventManager() {
        EventManager eventManager = new EventManager(new ActionManager());
        action.setEventManager(eventManager);
        assertEquals("Set event manager failed", eventManager, TestHelper.getPrivateField(
                CompositeUndoableAction.class, action, "eventManager"));
    }

    /**
     * Test method for 'CompositeUndoableAction.isEmpty()'. Return true if no action in composite action.
     */
    public void testIsEmpty_True() {
        CompositeUndoableAction compositeAction = new CompositeUndoableAction("Testing");
        assertTrue("Composite action is empty", compositeAction.isEmpty());
    }

    /**
     * Test method for 'CompositeUndoableAction.isEmpty()'. Return false if has actions in composite action.
     */
    public void testIsEmpty_False() {
        assertFalse("Composite action is not empty", action.isEmpty());
    }

    /**
     * Test method for 'CompositeUndoableAction.countActions()'. Returns the action number in composite action.
     */
    public void testCountActions() {
        assertEquals("Count of actions is wrong", action.countActions(), 2);
    }

    /**
     * Test method for 'CompositeUndoableAction.executeFrom(int)'. Actions from the given index could be executed.
     */
    public void testExecuteFrom() {
        try {
            action.executeFrom(1);
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        assertTrue("ExcuteFrom not work properly", !undoableActions[0].canUndo() && undoableActions[1].canUndo());
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        undoableActions[0] = null;
        undoableActions[1] = null;
        action = null;
    }

}
