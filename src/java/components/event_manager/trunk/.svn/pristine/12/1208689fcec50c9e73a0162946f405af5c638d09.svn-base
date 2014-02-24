/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import com.topcoder.util.actionmanager.Action;
import com.topcoder.util.actionmanager.ActionManager;
import com.topcoder.util.actionmanager.UndoableAction;

import junit.framework.TestCase;


/**
 * <p>
 * This class demonstrates of the usage of this component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {
    /** An instance of <code>EventManage</code> for testing. */
    private EventManager eventManager = null;

    /** An instance of <code>ActionManager</code> for testing. */
    private ActionManager actionManager = null;

    /** An instance of <code>ActionEventValidator</code> for testing. */
    private ActionEventValidator successEventValidator = new MockActionEventValidator("Validator1",
            EventValidation.SUCCESSFUL);

    /** An instance of <code>ActionEventValidator</code> for testing. */
    private ActionEventValidator modifiedEventValidator = new MockActionEventValidator("Validator2",
            EventValidation.EVENT_MODIFIED);

    /** An instance of <code>ActionEventValidator</code> for testing. */
    private ActionEventValidator deniedEventValidator = new MockActionEventValidator("Validator3",
            EventValidation.DENIED);

    /** An instance of <code>ActionEventListener</code> for testing. */
    private ActionEventListener actionEventListener1 = new MockActionEventListener("listener1");

    /** An instance of <code>ActionEventListener</code> for testing. */
    private ActionEventListener actionEventListener2 = new MockActionEventListener("listener2");

    /** An instance of <code>ActionEventListener</code> for testing. */
    private ActionEventListener actionEventListener3 = new MockActionEventListener("listener3");

    /** An instance of <code>GUIEventListener</code> for testing. */
    private GUIEventListener gUIEventListener1 = new MockGUIEventListener("listener1");

    /** An instance of <code>GUIEventListener</code> for testing. */
    private GUIEventListener gUIEventListener2 = new MockGUIEventListener("listener2");

    /** An instance of <code>UndoableAction</code> for testing. */
    private UndoableAction undoableAction1 = new MockAddClassDiagramAction();

    /** An instance of <code>UndoableAction</code> for testing. */
    private UndoableAction undoableAction2 = new MockAddClassMemberAction();

    /** An instance of <code>UndoableAction</code> for testing. */
    private UndoableAction undoableAction3 = new MockAddClassEdgeAction();

    /**
     * Set up the demo test environment.
     *
     * @throws Exception if any error occurred when setting up the test environment
     */
    protected void setUp() throws Exception {
        super.setUp();

        // The ActionManager is created by the user
        actionManager = new ActionManager();

        actionManager.executeAction(undoableAction3);
        actionManager.executeAction(undoableAction2);
        actionManager.executeAction(undoableAction1);

        // The EventManager is created by the user
        eventManager = new EventManager(actionManager);
    }

    /**
     * Test demo for simple ActionEvent.
     *
     * @throws Exception to junit
     */
    public void testDemo_ActionEvent() throws Exception {
        // Register the validators to UndoableAction.class
        eventManager.addEventValidator(successEventValidator, UndoableAction.class);

        // Register the validators to all Action class
        eventManager.addEventValidator(modifiedEventValidator);

        // Register the validators to simple Action Class
        eventManager.addEventValidator(deniedEventValidator, Action.class);

        // The following listeners implement ActionEventListener
        // Register the actionEventListener1 to MockUndoableAction class
        eventManager.addActionEventListener(actionEventListener1, MockAddClassDiagramAction.class);

        // Register the actionEventListener2 to all the action events
        eventManager.addActionEventListener(actionEventListener2);

        // Register the actionEventListener3 to simple Action Class
        eventManager.addActionEventListener(actionEventListener3, Action.class);

        // Create the action event, and handle it
        ActionEvent actionEvent = new ActionEvent(undoableAction1, new String());

        // Handle the event, actionEventListener1 and actionEventListener2 should be notified
        // If the validation by the validator is not DENIED, the action will be executed.
        eventManager.handleActionEvent(actionEvent);

        // Create an undo changes event, and handle it
        UndoChangesEvent undoChangesEvent = new UndoChangesEvent(undoableAction2, new String());

        // Handle the event, actionEventListener1 and actionEventListener2 should be notified
        eventManager.handleActionEvent(undoChangesEvent);

        // Create a redo changes event, and handle it
        RedoChangesEvent redoChangesEvent = new RedoChangesEvent(undoableAction2, new String());

        // Handle the event, actionEventListener1 and actionEventListener2 should be notified
        eventManager.handleActionEvent(redoChangesEvent);
    }

    /**
     * Test demo for GUI event.
     */
    public void testDemo_GUIEvent() {
        // The event is triggered from the GUI, it will be passed to the event manager to be handled.
        RedoChangesEvent guiEvent = new RedoChangesEvent(undoableAction1, new Object());

        // Handle the event, no listeners will be notified
        eventManager.handleGUIEvent(guiEvent);

        // Register the following listeners which implements GUIEventListener
        // Register the gUIEventListener1 to GUI event
        eventManager.addGUIEventListener(gUIEventListener1, RedoChangesEvent.class);

        // Register the gUIEventListener2 to all events
        eventManager.addGUIEventListener(gUIEventListener2);

        // Handle the event, gUIEventListener1 and gUIEventListener2 will be notified
        eventManager.handleGUIEvent(guiEvent);
    }
}
