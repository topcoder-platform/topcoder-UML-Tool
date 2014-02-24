/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import com.topcoder.util.actionmanager.Action;
import com.topcoder.util.actionmanager.ActionManager;
import com.topcoder.util.actionmanager.UndoableAction;

import junit.framework.TestCase;

import java.lang.reflect.Field;

import java.util.EventObject;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * <p>Test the functionality of <code>EventManager</code>class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EventManagerTest extends TestCase {
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

    /** An instance of <code>GUIEventListener</code> for testing. */
    private GUIEventListener gUIEventListener3 = new MockGUIEventListener("listener3");

    /** An instance of <code>UndoableAction</code> for testing. */
    private UndoableAction undoableAction1 = new MockAddClassDiagramAction();

    /** An instance of <code>UndoableAction</code> for testing. */
    private UndoableAction undoableAction2 = new MockAddClassMemberAction();

    /** An instance of <code>UndoableAction</code> for testing. */
    private UndoableAction undoableAction3 = new MockAddClassEdgeAction();

    /**
     * <p>Sets up the test environment. The test instance is created.</p>
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfig();
        actionManager = new ActionManager();

        // Setup the undoActions
        actionManager.executeAction(undoableAction1);
        actionManager.executeAction(undoableAction2);
        actionManager.executeAction(undoableAction3);

        eventManager = new EventManager(actionManager);
    }

    /**
     * <p>Tear down the test environment.</p>
     *
     * @throws Exception to junit
     */
    protected void tearDown() throws Exception {
        actionManager = null;
        TestHelper.clearConfig();
        super.tearDown();
    }

    /**
     * Test method for 'EventManager(ActionManager)'. The instance should be created successfully.
     */
    public void testEventManager_Accuracy() {
        assertNotNull("Test method for 'EventManager(ActionManager)' failed.", eventManager);
    }

    /**
     * Test method for 'EventManager(ActionManager)'. The argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testEventManager_null() {
        try {
            new EventManager(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.handleActionEvent(ActionEvent)'. The argument is null,
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to junit
     */
    public void testHandleActionEvent_null() throws Exception {
        try {
            eventManager.handleActionEvent(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.handleActionEvent(ActionEvent)'.<br>
     * The event is a simple ActionEvent, handleSimpleActionEvent() should be called.<br>
     * The event should be validated correctly and all the listeners should be notified.
     *
     * @throws Exception to junit
     */
    public void testHandleActionEvent_SimpleActionEvent_Accuracy()
        throws Exception {
        setUpEventManager();

        ActionEvent actionEvent = new ActionEvent(undoableAction1, new String());
        // Handle the event, actionEventListener1 and actionEventListener2 should be notified
        eventManager.handleActionEvent(actionEvent);

        // The validation result is EventValidation.EVENT_MODIFIED
        Pair<EventObject, EventValidation> performRecord = new Pair<EventObject, EventValidation>(actionEvent,
                EventValidation.EVENT_MODIFIED);
        // actionEventListener1 should be notified
        assertTrue("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener1).getPerformedRecords().contains(performRecord));
        // actionEventListener2 should be notified
        assertTrue("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener2).getPerformedRecords().contains(performRecord));
        // actionEventListener3 should not be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener3).getPerformedRecords().contains(performRecord));
    }

    /**
     * Test method for 'EventManager.handleActionEvent(ActionEvent)'.<br>
     * The event is an UndoChangesEvent, handleUndoChangesEvent() should be called.<br>
     * All the listeners should be notified correctly.
     *
     * @throws Exception to junit
     */
    public void testHandleActionEvent_UndoChangesEvent_Accuracy()
        throws Exception {
        setUpEventManager();

        UndoChangesEvent undoChangesEvent = new UndoChangesEvent(undoableAction2, new String());

        // Handle the event, actionEventListener1 and actionEventListener2 should be notified
        eventManager.handleActionEvent(undoChangesEvent);

        // 'undoableAction1' should be handled
        Pair<UndoChangesEvent, UndoableAction> performRecord
            = new Pair<UndoChangesEvent, UndoableAction>(undoChangesEvent, undoableAction1);
        // actionEventListener1 should not be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener1).getUndoPerformedRecords().contains(performRecord));
        // actionEventListener2 should not be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener2).getUndoPerformedRecords().contains(performRecord));
        // actionEventListener3 should not be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener3).getUndoPerformedRecords().contains(performRecord));

        // 'undoableAction2' should also be handled
        performRecord = new Pair<UndoChangesEvent, UndoableAction>(undoChangesEvent, undoableAction2);
        // actionEventListener1 should not be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener1).getUndoPerformedRecords().contains(performRecord));
        // actionEventListener2 should be notified
        assertTrue("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener2).getUndoPerformedRecords().contains(performRecord));
        // actionEventListener3 should not be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener3).getUndoPerformedRecords().contains(performRecord));

        // 'undoableAction3' should not be handled
        performRecord = new Pair<UndoChangesEvent, UndoableAction>(undoChangesEvent, undoableAction3);
        // actionEventListener1 should be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener1).getUndoPerformedRecords().contains(performRecord));
        // actionEventListener2 should be notified
        assertTrue("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener2).getUndoPerformedRecords().contains(performRecord));
        // actionEventListener3 should not be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener3).getUndoPerformedRecords().contains(performRecord));
    }

    /**
     * Test method for 'EventManager.handleActionEvent(ActionEvent)'.<br>
     * The event is an RedoChangesEvent, handleRedoChangesEvent() should be called.<br>
     * All the listeners should be notified correctly.
     *
     * @throws Exception to junit
     */
    public void testHandleActionEvent_RedoChangesEvent_Accuracy()
        throws Exception {
        setUpEventManager();
        actionManager.undoActions(undoableAction1);

        RedoChangesEvent redoChangesEvent = new RedoChangesEvent(undoableAction2, new String());
        //actionManager.undoActions(undoableAction3);
        // Handle the event, actionEventListener1 and actionEventListener2 should be notified
        eventManager.handleActionEvent(redoChangesEvent);

        // 'undoableAction1' should be handled
        Pair<RedoChangesEvent, UndoableAction> performRecord
            = new Pair<RedoChangesEvent, UndoableAction>(redoChangesEvent, undoableAction1);
        // actionEventListener1 should not be notified
        assertTrue("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener1).getRedoPerformedRecords().contains(performRecord));
        // actionEventListener2 should be notified
        assertTrue("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener2).getRedoPerformedRecords().contains(performRecord));
        // actionEventListener3 should not be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener3).getRedoPerformedRecords().contains(performRecord));

        // 'undoableAction2' should also be handled
        performRecord = new Pair<RedoChangesEvent, UndoableAction>(redoChangesEvent, undoableAction2);
        // actionEventListener1 should not be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener1).getRedoPerformedRecords().contains(performRecord));
        // actionEventListener2 should be notified
        assertTrue("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener2).getRedoPerformedRecords().contains(performRecord));
        // actionEventListener3 should not be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener3).getRedoPerformedRecords().contains(performRecord));

        // 'undoableAction3' should not be handled
        performRecord = new Pair<RedoChangesEvent, UndoableAction>(redoChangesEvent, undoableAction3);
        // actionEventListener1 should not be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener1).getRedoPerformedRecords().contains(performRecord));
        // actionEventListener2 should not be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener2).getRedoPerformedRecords().contains(performRecord));
        // actionEventListener3 should not be notified
        assertFalse("Test method for 'EventManager.handleActionEvent(ActionEvent)' failed.",
            ((MockActionEventListener) actionEventListener3).getRedoPerformedRecords().contains(performRecord));
    }

    /**
     * Test method for 'EventManager.handleGUIEvent(EventObject)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testHandleGUIEvent_null() {
        try {
            eventManager.handleGUIEvent(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.handleGUIEvent(EventObject)'. All the listeners should be notified.
     */
    public void testHandleGUIEvent_Accuracy() {
        setUpEventManager();

        RedoChangesEvent redoChangesEvent = new RedoChangesEvent(undoableAction1, new Object());

        // Handle the event, gUIEventListener1 and gUIEventListener2 should be notified
        eventManager.handleGUIEvent(redoChangesEvent);
        // Validate the notification
        // gUIEventListener1 should be notified
        assertTrue("Test method for 'EventManager.handleGUIEvent(EventObject)' failed.",
            ((MockGUIEventListener) gUIEventListener1).getPerformedRecords().contains(redoChangesEvent));
        // gUIEventListener2 should be notified
        assertTrue("Test method for 'EventManager.handleGUIEvent(EventObject)' failed.",
            ((MockGUIEventListener) gUIEventListener2).getPerformedRecords().contains(redoChangesEvent));
        // gUIEventListener3 should not be notified
        assertFalse("Test method for 'EventManager.handleGUIEvent(EventObject)' failed.",
            ((MockGUIEventListener) gUIEventListener3).getPerformedRecords().contains(redoChangesEvent));
    }

    /**
     * Test method for 'EventManager.addEventValidator(ActionEventValidator, Class)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddEventValidator1_null1() {
        try {
            eventManager.addEventValidator(null, UndoableAction.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.addEventValidator(ActionEventValidator, Class)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddEventValidator1_null2() {
        try {
            eventManager.addEventValidator(successEventValidator, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.addEventValidator(ActionEventValidator, Class)'. The argument
     * 'actionClass'is not an Action class, IllegalArgumentException should be thrown.
     */
    public void testAddEventValidator1_NotActionClass() {
        try {
            eventManager.addEventValidator(successEventValidator, String.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.addEventValidator(ActionEventValidator, Class)'. The validator should be
     * added correctly.
     */
    public void testAddEventValidator1_Accuracy() {
        eventManager.addEventValidator(successEventValidator, Action.class);
        eventManager.addEventValidator(modifiedEventValidator, Action.class);
        eventManager.addEventValidator(deniedEventValidator, UndoableAction.class);

        Map<Class, Set<ActionEventValidator>> map = (Map<Class, Set<ActionEventValidator>>)
            getPrivateField(EventManager.class, eventManager, "eventValidators");
        // Check all the validators have been added correctly
        assertTrue("Test method for 'EventManager.addEventValidator(ActionEventValidator, Class)' failed.",
            containsInMap(map, Action.class, successEventValidator));
        assertTrue("Test method for 'EventManager.addEventValidator(ActionEventValidator, Class)' failed.",
            containsInMap(map, Action.class, modifiedEventValidator));
        assertTrue("Test method for 'EventManager.addEventValidator(ActionEventValidator, Class)' failed.",
            containsInMap(map, UndoableAction.class, deniedEventValidator));
    }

    /**
     * Test method for 'EventManager.addActionEventListener(ActionEventListener, Class)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddActionEventListener1_null1() {
        try {
            eventManager.addActionEventListener(null, UndoableAction.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.addActionEventListener(ActionEventListener, Class)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddActionEventListener1_null2() {
        try {
            eventManager.addActionEventListener(actionEventListener1, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.addActionEventListener(ActionEventListener, Class)'. The argument
     * 'actionClass'is not an Action class, IllegalArgumentException should be thrown.
     */
    public void testAddActionEventListener1_NotActionClass() {
        try {
            eventManager.addActionEventListener(actionEventListener1, String.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.addActionEventListener(ActionEventListener, Class)'. The listener should
     * be added correctly.
     */
    public void testAddActionEventListener1_Accuracy() {
        eventManager.addActionEventListener(actionEventListener1, Action.class);
        eventManager.addActionEventListener(actionEventListener2, Action.class);
        eventManager.addActionEventListener(actionEventListener3, UndoableAction.class);

        Map<Class, Set<ActionEventListener>> map = (Map<Class, Set<ActionEventListener>>)
            getPrivateField(EventManager.class, eventManager, "actionEventListeners");
        // Check all the validators have been added correctly
        assertTrue("Test method for 'EventManager.addActionEventListener(ActionEventListener, Class)' failed.",
            containsInMap(map, Action.class, actionEventListener1));
        assertTrue("Test method for 'EventManager.addActionEventListener(ActionEventListener, Class)' failed.",
            containsInMap(map, Action.class, actionEventListener2));
        assertTrue("Test method for 'EventManager.addActionEventListener(ActionEventListener, Class)' failed.",
            containsInMap(map, UndoableAction.class, actionEventListener3));
    }

    /**
     * Test method for 'EventManager.addGUIEventListener(GUIEventListener, Class)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddGUIEventListener1_null1() {
        try {
            eventManager.addGUIEventListener(null, EventObject.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.addGUIEventListener(GUIEventListener, Class)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddGUIEventListener1_null2() {
        try {
            eventManager.addGUIEventListener(gUIEventListener1, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.addGUIEventListener(GUIEventListener, Class)'. The argument
     * 'actionClass'is not an EventObject class, IllegalArgumentException should be thrown.
     */
    public void testAddGUIEventListener1_NotEventObjectClass() {
        try {
            eventManager.addGUIEventListener(gUIEventListener1, String.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.addGUIEventListener(GUIEventListener, Class)'. The listener should be
     * added correctly.
     */
    public void testAddGUIEventListener1_Accuracy() {
        eventManager.addGUIEventListener(gUIEventListener1, RedoChangesEvent.class);
        eventManager.addGUIEventListener(gUIEventListener2, RedoChangesEvent.class);
        eventManager.addGUIEventListener(gUIEventListener3, UndoChangesEvent.class);

        Map<Class, Set<GUIEventListener>> map = (Map<Class, Set<GUIEventListener>>) getPrivateField(EventManager.class,
                eventManager, "guiEventListeners");
        // Check all the validators have been added correctly
        assertTrue("Test method for 'EventManager.addGUIEventListener(GUIEventListener, Class)' failed.",
            containsInMap(map, RedoChangesEvent.class, gUIEventListener1));
        assertTrue("Test method for 'EventManager.addGUIEventListener(GUIEventListener, Class)' failed.",
            containsInMap(map, RedoChangesEvent.class, gUIEventListener2));
        assertTrue("Test method for 'EventManager.addGUIEventListener(GUIEventListener, Class)' failed.",
            containsInMap(map, UndoChangesEvent.class, gUIEventListener3));
    }

    /**
     * Test method for 'EventManager.addEventValidator(ActionEventValidator)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddEventValidator2_null() {
        try {
            eventManager.addEventValidator(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.addEventValidator(ActionEventValidator)'. The validator should be added
     * correctly.
     */
    public void testAddEventValidator2_Accuracy() {
        eventManager.addEventValidator(successEventValidator);
        eventManager.addEventValidator(modifiedEventValidator);
        eventManager.addEventValidator(deniedEventValidator);

        Map<Class, Set<ActionEventValidator>> map = (Map<Class, Set<ActionEventValidator>>)
            getPrivateField(EventManager.class, eventManager, "eventValidators");
        // Check all the validators have been added correctly
        assertTrue("Test method for 'EventManager.addEventValidator(ActionEventValidator, Class)' failed.",
            containsInMap(map, null, successEventValidator));
        assertTrue("Test method for 'EventManager.addEventValidator(ActionEventValidator, Class)' failed.",
            containsInMap(map, null, modifiedEventValidator));
        assertTrue("Test method for 'EventManager.addEventValidator(ActionEventValidator, Class)' failed.",
            containsInMap(map, null, deniedEventValidator));
    }

    /**
     * Test method for 'EventManager.addGUIEventListener(GUIEventListener'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddGUIEventListener2_null1() {
        try {
            eventManager.addGUIEventListener(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.addGUIEventListener(GUIEventListener)'. The listener should be added
     * correctly.
     */
    public void testAddGUIEventListener2_Accuracy() {
        eventManager.addGUIEventListener(gUIEventListener1);
        eventManager.addGUIEventListener(gUIEventListener2);
        eventManager.addGUIEventListener(gUIEventListener3);

        Map<Class, Set<GUIEventListener>> map = (Map<Class, Set<GUIEventListener>>) getPrivateField(EventManager.class,
                eventManager, "guiEventListeners");
        // Check all the validators have been added correctly
        assertTrue("Test method for 'EventManager.addGUIEventListener(GUIEventListener, Class)' failed.",
            containsInMap(map, null, gUIEventListener1));
        assertTrue("Test method for 'EventManager.addGUIEventListener(GUIEventListener, Class)' failed.",
            containsInMap(map, null, gUIEventListener2));
        assertTrue("Test method for 'EventManager.addGUIEventListener(GUIEventListener, Class)' failed.",
            containsInMap(map, null, gUIEventListener3));
    }

    /**
     * Test method for 'EventManager.addActionEventListener(ActionEventListener)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddActionEventListener2_null1() {
        try {
            eventManager.addActionEventListener(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.addActionEventListener(ActionEventListener)'. The listener should be added
     * correctly.
     */
    public void testAddActionEventListener2_Accuracy() {
        eventManager.addActionEventListener(actionEventListener1);
        eventManager.addActionEventListener(actionEventListener2);
        eventManager.addActionEventListener(actionEventListener3);

        Map<Class, Set<ActionEventListener>> map = (Map<Class, Set<ActionEventListener>>)
            getPrivateField(EventManager.class, eventManager, "actionEventListeners");
        // Check all the validators have been added correctly
        assertTrue("Test method for 'EventManager.addActionEventListener(ActionEventListener, Class)' failed.",
            containsInMap(map, null, actionEventListener1));
        assertTrue("Test method for 'EventManager.addActionEventListener(ActionEventListener, Class)' failed.",
            containsInMap(map, null, actionEventListener2));
        assertTrue("Test method for 'EventManager.addActionEventListener(ActionEventListener, Class)' failed.",
            containsInMap(map, null, actionEventListener3));
    }

    /**
     * Test method for 'EventManager.removeEventValidator(ActionEventValidator, Class)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveEventValidator1_null1() {
        try {
            eventManager.removeEventValidator(null, UndoableAction.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.removeEventValidator(ActionEventValidator, Class)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveEventValidator1_null2() {
        try {
            eventManager.removeEventValidator(successEventValidator, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.removeEventValidator(ActionEventValidator, Class)'. The argument
     * 'actionClass'is not an Action class, IllegalArgumentException should be thrown.
     */
    public void testRemoveEventValidator1_NotActionClass() {
        try {
            eventManager.removeEventValidator(successEventValidator, String.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.removeEventValidator(ActionEventValidator, Class)'. The validator should
     * be removed correctly.
     */
    public void testRemoveEventValidator1_Accuracy() {
        Map<Class, Set<ActionEventValidator>> map = (Map<Class, Set<ActionEventValidator>>)
            getPrivateField(EventManager.class, eventManager, "eventValidators");
        Set<ActionEventValidator> validators1 = new HashSet<ActionEventValidator>();
        validators1.add(successEventValidator);
        validators1.add(modifiedEventValidator);
        map.put(Action.class, validators1);

        Set<ActionEventValidator> validators2 = new HashSet<ActionEventValidator>();
        validators2.add(deniedEventValidator);
        map.put(UndoableAction.class, validators2);

        // Check all the validators have been added correctly
        assertTrue("Test method for 'EventManager.removeEventValidator(ActionEventValidator, Class)' failed.",
            containsInMap(map, Action.class, successEventValidator));
        assertTrue("Test method for 'EventManager.removeEventValidator(ActionEventValidator, Class)' failed.",
            containsInMap(map, Action.class, modifiedEventValidator));
        assertTrue("Test method for 'EventManager.removeEventValidator(ActionEventValidator, Class)' failed.",
            containsInMap(map, UndoableAction.class, deniedEventValidator));
        // Remove the validators
        eventManager.removeEventValidator(successEventValidator, Action.class);
        eventManager.removeEventValidator(modifiedEventValidator, Action.class);
        eventManager.removeEventValidator(deniedEventValidator, UndoableAction.class);

        // Check all the validators have been removed correctly
        assertFalse("Test method for 'EventManager.removeEventValidator(ActionEventValidator, Class)' failed.",
            containsInMap(map, Action.class, successEventValidator));
        assertFalse("Test method for 'EventManager.removeEventValidator(ActionEventValidator, Class)' failed.",
            containsInMap(map, Action.class, modifiedEventValidator));
        assertFalse("Test method for 'EventManager.removeEventValidator(ActionEventValidator, Class)' failed.",
            containsInMap(map, UndoableAction.class, deniedEventValidator));
    }

    /**
     * Test method for 'EventManager.removeActionEventListener(ActionEventListener, Class)'. The argument is
     * null, IllegalArgumentException should be thrown.
     */
    public void testRemoveActionEventListener1_null1() {
        try {
            eventManager.removeActionEventListener(null, UndoableAction.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.removeActionEventListener(ActionEventListener, Class)'. The argument is
     * null, IllegalArgumentException should be thrown.
     */
    public void testRemoveActionEventListener1_null2() {
        try {
            eventManager.removeActionEventListener(actionEventListener1, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.removeActionEventListener(ActionEventListener, Class)'. The argument
     * 'actionClass'is not an Action class, IllegalArgumentException should be thrown.
     */
    public void testRemoveActionEventListener1_NotActionClass() {
        try {
            eventManager.removeActionEventListener(actionEventListener1, String.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.removeActionEventListener(ActionEventListener, Class)'. The listener
     * should be removed correctly.
     */
    public void testRemoveActionEventListener1_Accuracy() {
        Map<Class, Set<ActionEventListener>> map = (Map<Class, Set<ActionEventListener>>)
            getPrivateField(EventManager.class, eventManager, "actionEventListeners");
        Set<ActionEventListener> listeners1 = new HashSet<ActionEventListener>();
        listeners1.add(actionEventListener1);
        listeners1.add(actionEventListener2);
        map.put(Action.class, listeners1);

        Set<ActionEventListener> listeners2 = new HashSet<ActionEventListener>();
        listeners2.add(actionEventListener3);
        map.put(UndoableAction.class, listeners2);

        // Check all the listeners have been added correctly
        assertTrue("Test method for 'EventManager.removeActionEventListener(ActionEventListener, Class)' failed.",
            containsInMap(map, Action.class, actionEventListener1));
        assertTrue("Test method for 'EventManager.removeActionEventListener(ActionEventListener, Class)' failed.",
            containsInMap(map, Action.class, actionEventListener2));
        assertTrue("Test method for 'EventManager.removeActionEventListener(ActionEventListener, Class)' failed.",
            containsInMap(map, UndoableAction.class, actionEventListener3));
        // Remove the listeners
        eventManager.removeActionEventListener(actionEventListener1, Action.class);
        eventManager.removeActionEventListener(actionEventListener2, Action.class);
        eventManager.removeActionEventListener(actionEventListener3, UndoableAction.class);

        // Check all the listeners have been removed correctly
        assertFalse("Test method for 'EventManager.removeActionEventListener(ActionEventListener, Class)' failed.",
            containsInMap(map, Action.class, actionEventListener1));
        assertFalse("Test method for 'EventManager.removeActionEventListener(ActionEventListener, Class)' failed.",
            containsInMap(map, Action.class, actionEventListener2));
        assertFalse("Test method for 'EventManager.removeActionEventListener(ActionEventListener, Class)' failed.",
            containsInMap(map, UndoableAction.class, actionEventListener3));
    }

    /**
     * Test method for 'EventManager.removeGUIEventListener(GUIEventListener, Class)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveGUIEventListener1_null1() {
        try {
            eventManager.removeGUIEventListener(null, EventObject.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.removeGUIEventListener(GUIEventListener, Class)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveGUIEventListener1_null2() {
        try {
            eventManager.removeGUIEventListener(gUIEventListener1, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.removeGUIEventListener(GUIEventListener, Class)'. The argument
     * 'actionClass'is not an EventObject class, IllegalArgumentException should be thrown.
     */
    public void testRemoveGUIEventListener1_NotEventObjectClass() {
        try {
            eventManager.removeGUIEventListener(gUIEventListener1, String.class);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.removeGUIEventListener(GUIEventListener, Class)'. The listener should be
     * removed correctly.
     */
    public void testRemoveGUIEventListener1_Accuracy() {
        Map<Class, Set<GUIEventListener>> map = (Map<Class, Set<GUIEventListener>>) getPrivateField(EventManager.class,
                eventManager, "guiEventListeners");
        Set<GUIEventListener> listeners1 = new HashSet<GUIEventListener>();
        listeners1.add(gUIEventListener1);
        listeners1.add(gUIEventListener2);
        map.put(RedoChangesEvent.class, listeners1);

        Set<GUIEventListener> listeners2 = new HashSet<GUIEventListener>();
        listeners2.add(gUIEventListener3);
        map.put(UndoChangesEvent.class, listeners2);

        // Check all the listeners have been added correctly
        assertTrue("Test method for 'EventManager.removeGUIEventListener(GUIEventListener, Class)' failed.",
            containsInMap(map, RedoChangesEvent.class, gUIEventListener1));
        assertTrue("Test method for 'EventManager.removeGUIEventListener(GUIEventListener, Class)' failed.",
            containsInMap(map, RedoChangesEvent.class, gUIEventListener2));
        assertTrue("Test method for 'EventManager.removeGUIEventListener(GUIEventListener, Class)' failed.",
            containsInMap(map, UndoChangesEvent.class, gUIEventListener3));
        // Remove the listeners
        eventManager.removeGUIEventListener(gUIEventListener1, RedoChangesEvent.class);
        eventManager.removeGUIEventListener(gUIEventListener2, RedoChangesEvent.class);
        eventManager.removeGUIEventListener(gUIEventListener3, UndoChangesEvent.class);

        // Check all the listeners have been removed correctly
        assertFalse("Test method for 'EventManager.removeGUIEventListener(GUIEventListener, Class)' failed.",
            containsInMap(map, RedoChangesEvent.class, gUIEventListener1));
        assertFalse("Test method for 'EventManager.removeGUIEventListener(GUIEventListener, Class)' failed.",
            containsInMap(map, RedoChangesEvent.class, gUIEventListener2));
        assertFalse("Test method for 'EventManager.removeGUIEventListener(GUIEventListener, Class)' failed.",
            containsInMap(map, UndoChangesEvent.class, gUIEventListener3));
    }

    /**
     * Test method for 'EventManager.removeEventValidator(ActionEventValidator)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveEventValidator2_null() {
        try {
            eventManager.removeEventValidator(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.removeEventValidator(ActionEventValidator)'. The validator should be
     * removed correctly.
     */
    public void testRemoveEventValidator2_Accuracy() {
        Map<Class, Set<ActionEventValidator>> map = (Map<Class, Set<ActionEventValidator>>)
            getPrivateField(EventManager.class, eventManager, "eventValidators");
        Set<ActionEventValidator> validators1 = new HashSet<ActionEventValidator>();
        validators1.add(successEventValidator);
        validators1.add(modifiedEventValidator);
        validators1.add(deniedEventValidator);
        map.put(null, validators1);

        // Check all the validators have been added correctly
        assertTrue("Test method for 'EventManager.removeEventValidator(ActionEventValidator)' failed.",
            containsInMap(map, null, successEventValidator));
        assertTrue("Test method for 'EventManager.removeEventValidator(ActionEventValidator)' failed.",
            containsInMap(map, null, modifiedEventValidator));
        assertTrue("Test method for 'EventManager.removeEventValidator(ActionEventValidator)' failed.",
            containsInMap(map, null, deniedEventValidator));
        // Remove the validators
        eventManager.removeEventValidator(successEventValidator);
        eventManager.removeEventValidator(modifiedEventValidator);
        eventManager.removeEventValidator(deniedEventValidator);

        // Check all the validators have been removed correctly
        assertFalse("Test method for 'EventManager.removeEventValidator(ActionEventValidator)' failed.",
            containsInMap(map, null, successEventValidator));
        assertFalse("Test method for 'EventManager.removeEventValidator(ActionEventValidator)' failed.",
            containsInMap(map, null, modifiedEventValidator));
        assertFalse("Test method for 'EventManager.removeEventValidator(ActionEventValidator)' failed.",
            containsInMap(map, null, deniedEventValidator));
    }

    /**
     * Test method for 'EventManager.removeGUIEventListener(GUIEventListener'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveGUIEventListener2_null1() {
        try {
            eventManager.removeGUIEventListener(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.removeGUIEventListener(GUIEventListener)'. The listener should be removed
     * correctly.
     */
    public void testRemoveGUIEventListener2_Accuracy() {
        Map<Class, Set<GUIEventListener>> map = (Map<Class, Set<GUIEventListener>>) getPrivateField(EventManager.class,
                eventManager, "guiEventListeners");
        Set<GUIEventListener> listeners = new HashSet<GUIEventListener>();
        listeners.add(gUIEventListener1);
        listeners.add(gUIEventListener2);
        listeners.add(gUIEventListener3);
        map.put(null, listeners);

        // Check all the listeners have been added correctly
        assertTrue("Test method for 'EventManager.removeGUIEventListener(GUIEventListener)' failed.",
            containsInMap(map, null, gUIEventListener1));
        assertTrue("Test method for 'EventManager.removeGUIEventListener(GUIEventListener)' failed.",
            containsInMap(map, null, gUIEventListener2));
        assertTrue("Test method for 'EventManager.removeGUIEventListener(GUIEventListener)' failed.",
            containsInMap(map, null, gUIEventListener3));
        // Remove the listeners
        eventManager.removeGUIEventListener(gUIEventListener1);
        eventManager.removeGUIEventListener(gUIEventListener2);
        eventManager.removeGUIEventListener(gUIEventListener3);

        // Check all the listeners have been removed correctly
        assertFalse("Test method for 'EventManager.removeGUIEventListener(GUIEventListener)' failed.",
            containsInMap(map, null, gUIEventListener1));
        assertFalse("Test method for 'EventManager.removeGUIEventListener(GUIEventListener)' failed.",
            containsInMap(map, null, gUIEventListener2));
        assertFalse("Test method for 'EventManager.removeGUIEventListener(GUIEventListener)' failed.",
            containsInMap(map, null, gUIEventListener3));
    }

    /**
     * Test method for 'EventManager.removeActionEventListener(ActionEventListener)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveActionEventListener2_null1() {
        try {
            eventManager.removeActionEventListener(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'EventManager.removeActionEventListener(ActionEventListener)'. The listener should be
     * removed correctly.
     */
    public void testRemoveActionEventListener2_Accuracy() {
        Map<Class, Set<ActionEventListener>> map = (Map<Class, Set<ActionEventListener>>)
            getPrivateField(EventManager.class, eventManager, "actionEventListeners");
        Set<ActionEventListener> listeners = new HashSet<ActionEventListener>();
        listeners.add(actionEventListener1);
        listeners.add(actionEventListener2);
        listeners.add(actionEventListener3);
        map.put(null, listeners);

        // Check all the listeners have been added correctly
        assertTrue("Test method for 'EventManager.removeActionEventListener(ActionEventListener)' failed.",
            containsInMap(map, null, actionEventListener1));
        assertTrue("Test method for 'EventManager.removeActionEventListener(ActionEventListener)' failed.",
            containsInMap(map, null, actionEventListener2));
        assertTrue("Test method for 'EventManager.removeActionEventListener(ActionEventListener)' failed.",
            containsInMap(map, null, actionEventListener3));
        // Remove the listeners
        eventManager.removeActionEventListener(actionEventListener1);
        eventManager.removeActionEventListener(actionEventListener2);
        eventManager.removeActionEventListener(actionEventListener3);

        // Check all the listeners have been removed correctly
        assertFalse("Test method for 'EventManager.removeActionEventListener(ActionEventListener)' failed.",
            containsInMap(map, null, actionEventListener1));
        assertFalse("Test method for 'EventManager.removeActionEventListener(ActionEventListener)' failed.",
            containsInMap(map, null, actionEventListener2));
        assertFalse("Test method for 'EventManager.removeActionEventListener(ActionEventListener)' failed.",
            containsInMap(map, null, actionEventListener3));
    }

    /**
     * Register all the listeners and validators for testing.
     */
    private void setUpEventManager() {
        // Register the actionEventListener1 to MockUndoableAction class
        eventManager.addActionEventListener(actionEventListener1, MockAddClassDiagramAction.class);
        // Register the actionEventListener2 to all Action class
        eventManager.addActionEventListener(actionEventListener2);
        // Register the actionEventListener3 to simple Action Class
        eventManager.addActionEventListener(actionEventListener3, Action.class);

        // Register the validators to UndoableAction.class
        eventManager.addEventValidator(successEventValidator, UndoableAction.class);
        // Register the validators to all Action class
        eventManager.addEventValidator(modifiedEventValidator);
        // Register the validators to simple Action Class
        eventManager.addEventValidator(deniedEventValidator, Action.class);

        // Register the gUIEventListener1 to 'RedoChangesEvent'
        eventManager.addGUIEventListener(gUIEventListener1, RedoChangesEvent.class);
        // Register the gUIEventListener2 to all EventObject
        eventManager.addGUIEventListener(gUIEventListener2);
        // Register the gUIEventListener3 to 'UndoChangesEvent'
        eventManager.addGUIEventListener(gUIEventListener3, UndoChangesEvent.class);
    }

    /**
     * Check whether the map contains the specified element.
     *
     * @param <T> specify the type of the Set's element
     * @param map the map which the element will be put into
     * @param key the key of the specified Set
     * @param element the specified element to be checked
     *
     * @return true if the element is in the map, otherwise false
     */
    private static <T> boolean containsInMap(Map<Class, Set<T>> map, Class key, T element) {
        Set<T> set = map.get(key);

        if (set == null) {
            return false;
        }

        return set.contains(element);
    }

    /**
     * Gets the value of a private field in the given class. The field has the given name. The value is
     * retrieved from the given instance. If the instance is null, the field is a static field. If any error occurs,
     * null is returned.
     *
     * @param type the class which the private field belongs to
     * @param instance the instance which the private field belongs to
     * @param name the name of the private field to be retrieved
     *
     * @return the value of the private field
     */
    static Object getPrivateField(Class<?> type, Object instance, String name) {
        Field field = null;
        Object obj = null;

        try {
            // Get the reflection of the field
            field = type.getDeclaredField(name);

            // Set the field accessible.
            field.setAccessible(true);

            // Get the value
            obj = field.get(instance);
        } catch (NoSuchFieldException e) {
            // Ignore
        } catch (IllegalAccessException e) {
            // Ignore
        } finally {
            if (field != null) {
                // Reset the accessibility
                field.setAccessible(false);
            }
        }

        return obj;
    }
}
