/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.accuracytests;

import java.lang.reflect.Field;
import java.util.EventObject;
import java.util.Map;
import java.util.Set;

import com.topcoder.util.actionmanager.Action;
import com.topcoder.util.actionmanager.ActionManager;
import com.topcoder.util.eventmanager.ActionEvent;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.ActionEventValidator;
import com.topcoder.util.eventmanager.EventManager;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.GUIEventListener;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

import junit.framework.TestCase;

/**
 * This <code>TestCase</code> aggregates all accuracy test cases for <code>EventManager</code>.
 *
 * @author daiwb
 * @version 1.0
 */
public class EventManagerAccuracyTestCase extends TestCase {

    /**
     * <code>DummyActionEventListener</code> instance used for tests.
     */
    private DummyActionEventListener actionEventListener1 = new DummyActionEventListener("ONE");

    /**
     * <code>DummyActionEventValidator</code> instance used for tests, it always returns the result of
     * <code>SUCCESSFUL</code>.
     */
    private DummyActionEventValidator successfulValidator = new DummyActionEventValidator("SUCCESSFUL",
            EventValidation.SUCCESSFUL);

    /**
     * <code>DummyActionEventValidator</code> instance used for tests, it always returns the result of
     * <code>EVENT_MODIFIED</code>.
     */
    private DummyActionEventValidator modifiedValidator = new DummyActionEventValidator("EVENT_MODIFIED",
            EventValidation.EVENT_MODIFIED);

    /**
     * <code>DummyActionEventValidator</code> instance used for tests, it always returns the result of
     * <code>DENIED</code>.
     */
    private DummyActionEventValidator deniedValidator = new DummyActionEventValidator("DENIED", EventValidation.DENIED);

    /**
     * <code>DummyGUIEventListener</code> instance used for tests.
     */
    private DummyGUIEventListener guiEventListener1 = new DummyGUIEventListener("ONE");

    /**
     * <code>DummyUndoableAction</code> instance used for tests.
     */
    private DummyUndoableAction undoableAction1 = new DummyUndoableAction();

    /**
     * <code>ActionManager</code> instance used for tests.
     */
    private ActionManager actionMgr;

    /**
     * <code>EventManager</code> instance used for tests.
     */
    private EventManager eventMgr;

    /**
     * Sets up the testing environment, initializes the instances used for tests.
     */
    protected void setUp() {
        actionMgr = new ActionManager();
        eventMgr = new EventManager(actionMgr);
    }

    /**
     * Cleans up the testing environment, disposes the instances used for tests.
     */
    protected void tearDown() {
        actionMgr = null;
        eventMgr = null;
    }

    /**
     * Tests accuracy of <code>EventManager(ActionManager)</code>, the <code>EventManager</code> instance should be
     * created successfully.
     */
    public void testEventManager() {
        assertNotNull("The EventManager instance should be created successfully.", eventMgr);
    }

    /**
     * Tests accuracy of <code>handleActionEvent(ActionEvent)</code> when <code>event</code> is simple action event.
     * An <code>ActionEventValidator</code> always returns <code>SUCCESSFUL</code> result is added.
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testHandleActionEvent_SimpleActionEvent_SUCCESSFUL() throws Exception {
        Action action = new DummyAction();
        ActionEvent event = new ActionEvent(action, new Object());
        eventMgr.addEventValidator(successfulValidator, action.getClass());
        eventMgr.addActionEventListener(actionEventListener1, action.getClass());

        eventMgr.handleActionEvent(event);
        assertTrue("The given ActionEvent is not handled well.", actionEventListener1.getActions().containsKey(event));
        assertEquals("The given ActionEvent is not handled well.", EventValidation.SUCCESSFUL, actionEventListener1
                .getActions().get(event));
    }

    /**
     * Tests accuracy of <code>handleActionEvent(ActionEvent)</code> when <code>event</code> is simple action event.
     * An <code>ActionEventValidator</code> always returns <code>EVENT_MODIFIED</code> result is added.
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testHandleActionEvent_SimpleActionEvent_EVENT_MODIFIED() throws Exception {
        Action action = new DummyAction();
        ActionEvent event = new ActionEvent(action, new Object());
        eventMgr.addEventValidator(modifiedValidator, action.getClass());
        eventMgr.addActionEventListener(actionEventListener1, action.getClass());

        eventMgr.handleActionEvent(event);
        assertTrue("The given ActionEvent is not handled well.", actionEventListener1.getActions().containsKey(event));
        assertEquals("The given ActionEvent is not handled well.", EventValidation.EVENT_MODIFIED, actionEventListener1
                .getActions().get(event));
    }

    /**
     * Tests accuracy of <code>handleActionEvent(ActionEvent)</code> when <code>event</code> is simple action event.
     * An <code>ActionEventValidator</code> always returns <code>DENIED</code> result is added.
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testHandleActionEvent_SimpleActionEvent_DENIED() throws Exception {
        Action action = new DummyAction();
        ActionEvent event = new ActionEvent(action, new Object());
        eventMgr.addEventValidator(deniedValidator, action.getClass());
        eventMgr.addActionEventListener(actionEventListener1, action.getClass());

        eventMgr.handleActionEvent(event);
        assertTrue("The given ActionEvent is not handled well.", actionEventListener1.getActions().containsKey(event));
        assertEquals("The given ActionEvent is not handled well.", EventValidation.DENIED, actionEventListener1
                .getActions().get(event));
    }

    /**
     * Tests accuracy of <code>handleActionEvent(ActionEvent)</code> when <code>event</code> is
     * <code>UndoChangesEvent</code>. The <code>ActionEvent</code> to be added is not in the list of
     * <code>UndoableActionsToBeUndone</code>.
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testHandleActionEvent_UndoChangesEvent_1() throws Exception {
        UndoChangesEvent event = new UndoChangesEvent(undoableAction1, new Object());
        eventMgr.handleActionEvent(event);
        assertFalse("The given UndoChangesEvent should not be undone.", actionMgr.getUndoableActionsToBeUndone()
                .contains(undoableAction1));
    }

    /**
     * Tests accuracy of <code>handleActionEvent(ActionEvent)</code> when <code>event</code> is
     * <code>UndoChangesEvent</code>. The <code>ActionEvent</code> to be added is in the list of
     * <code>UndoableActionsToBeUndone</code>.
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testHandleActionEvent_UndoChangesEvent_2() throws Exception {
        UndoChangesEvent event = new UndoChangesEvent(undoableAction1, new Object());
        eventMgr.handleActionEvent(event);
    }

    /**
     * Tests accuracy of <code>handleActionEvent(ActionEvent)</code> when <code>event</code> is
     * <code>RedoChangesEvent</code>. The <code>ActionEvent</code> to be added is not in the list of
     * <code>UndoableActionsToBeRedone</code>.
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testHandleActionEvent_RedoChangesEvent_1() throws Exception {
        RedoChangesEvent event = new RedoChangesEvent(undoableAction1, new Object());
        eventMgr.handleActionEvent(event);
        assertFalse("The given UndoChangesEvent should not be redone.", actionMgr.getUndoableActionsToBeRedone()
                .contains(undoableAction1));
    }

    /**
     * Tests accuracy of <code>handleActionEvent(ActionEvent)</code> when <code>event</code> is
     * <code>RedoChangesEvent</code>. The <code>ActionEvent</code> to be added is in the list of
     * <code>UndoableActionsToBeRedone</code>.
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testHandleActionEvent_RedoChangesEvent_2() throws Exception {
        RedoChangesEvent event = new RedoChangesEvent(undoableAction1, new Object());
        eventMgr.handleActionEvent(event);
    }

    /**
     * Tests accuracy of <code>handleGUIEvent(EventObject)</code>.
     */
    public void testHandleGUIEvent() {
        EventObject event = new EventObject(new Object());
        eventMgr.addGUIEventListener(guiEventListener1, event.getClass());
        eventMgr.handleGUIEvent(event);
        assertTrue("The given EventObject is not handled well.", guiEventListener1.getActions().contains(event));
    }

    /**
     * Tests accuracy of <code>addEventValidator(ActionEventValidator, Class)</code> and
     * <code>removeEventValidator(ActionEventValidator, Class)</code>.
     */
    @SuppressWarnings("unchecked")
    public void testAddAndRemoveEventValidatorActionEventValidatorClass() {
        Action action = new DummyAction();

        eventMgr.addEventValidator(successfulValidator, action.getClass());
        Map<Class, Set<ActionEventValidator>> eventValidators = (Map<Class, Set<ActionEventValidator>>) getFieldValue(
                eventMgr, "eventValidators");
        Set set = eventValidators.get(action.getClass());
        assertNotNull("The EventManager should contain this ActionEventValidator-Class pair.", set);
        assertTrue("The EventManager should contain this ActionEventValidator-Class pair.", set
                .contains(successfulValidator));

        eventMgr.removeEventValidator(successfulValidator, action.getClass());
        eventValidators = (Map<Class, Set<ActionEventValidator>>) getFieldValue(eventMgr, "eventValidators");
        set = eventValidators.get(action.getClass());
        assertNotNull("The EventManager should not contain this ActionEventValidator-Class pair.", set);
        assertFalse("The EventManager should not contain this ActionEventValidator-Class pair.", set
                .contains(successfulValidator));

    }

    /**
     * Tests accuracy of <code>addActionEventListener(ActionEventListener, Class)</code> and
     * <code>removeActionEventListener(ActionEventListener, Class)</code>.
     */
    @SuppressWarnings("unchecked")
    public void testAddAndRemoveActionEventListenerActionEventListenerClass() {
        Action action = new DummyAction();

        eventMgr.addActionEventListener(actionEventListener1, action.getClass());
        Map<Class, Set<ActionEventListener>> actionEventListeners = (Map<Class, Set<ActionEventListener>>) getFieldValue(
                eventMgr, "actionEventListeners");
        Set set = actionEventListeners.get(action.getClass());
        assertNotNull("The EventManager should contain this ActionEventListener-Class pair.", set);
        assertTrue("The EventManager should contain this ActionEventListener-Class pair.", set
                .contains(actionEventListener1));

        eventMgr.removeActionEventListener(actionEventListener1, action.getClass());
        actionEventListeners = (Map<Class, Set<ActionEventListener>>) getFieldValue(eventMgr, "actionEventListeners");
        set = actionEventListeners.get(action.getClass());
        assertNotNull("The EventManager should not contain this ActionEventListener-Class pair.", set);
        assertFalse("The EventManager should not contain this ActionEventListener-Class pair.", set
                .contains(actionEventListener1));
    }

    /**
     * Tests accuracy of <code>addGUIEventListener(GUIEventListener, Class)</code> and
     * <code>removeGUIEventListener(GUIEventListener, Class)</code>.
     */
    @SuppressWarnings("unchecked")
    public void testAddAndRemoveGUIEventListenerGUIEventListenerClass() {
        EventObject obj = new EventObject(new Object());

        eventMgr.addGUIEventListener(guiEventListener1, obj.getClass());
        Map<Class, Set<GUIEventListener>> guiEventListeners = (Map<Class, Set<GUIEventListener>>) getFieldValue(
                eventMgr, "guiEventListeners");
        Set set = guiEventListeners.get(obj.getClass());
        assertNotNull("The EventManager should contain this GUIEventListener-Class pair.", set);
        assertTrue("The EventManager should contain this GUIEventListener-Class pair.", set.contains(guiEventListener1));

        eventMgr.removeGUIEventListener(guiEventListener1, obj.getClass());
        guiEventListeners = (Map<Class, Set<GUIEventListener>>) getFieldValue(eventMgr, "guiEventListeners");
        set = guiEventListeners.get(obj.getClass());
        assertNotNull("The EventManager should not contain this GUIEventListener-Class pair.", set);
        assertFalse("The EventManager should not contain this GUIEventListener-Class pair.", set
                .contains(guiEventListener1));
    }

    /**
     * Tests accuracy of <code>addEventValidator(ActionEventValidator)</code> and
     * <code>removeEventValidator(ActionEventValidator)</code>.
     */
    @SuppressWarnings("unchecked")
    public void testAddAndRemoveEventValidatorActionEventValidator() {
        eventMgr.addEventValidator(successfulValidator);
        Map<Class, Set<ActionEventValidator>> eventValidators = (Map<Class, Set<ActionEventValidator>>) getFieldValue(
                eventMgr, "eventValidators");
        Set set = eventValidators.get(null);
        assertNotNull("The EventManager should contain this ActionEventValidator-null pair.", set);
        assertTrue("The EventManager should contain this ActionEventValidator-null pair.", set
                .contains(successfulValidator));

        eventMgr.removeEventValidator(successfulValidator);
        eventValidators = (Map<Class, Set<ActionEventValidator>>) getFieldValue(eventMgr, "eventValidators");
        set = eventValidators.get(null);
        assertNotNull("The EventManager should not contain this ActionEventValidator-null pair.", set);
        assertFalse("The EventManager should not contain this ActionEventValidator-null pair.", set
                .contains(successfulValidator));
    }

    /**
     * Tests accuracy of <code>addGUIEventListener(GUIEventListener)</code> and
     * <code>removeGUIEventListener(GUIEventListener)</code>.
     */
    @SuppressWarnings("unchecked")
    public void testAddAndRemoveGUIEventListenerGUIEventListener() {
        eventMgr.addGUIEventListener(guiEventListener1);
        Map<Class, Set<GUIEventListener>> guiEventListeners = (Map<Class, Set<GUIEventListener>>) getFieldValue(
                eventMgr, "guiEventListeners");
        Set set = guiEventListeners.get(null);
        assertNotNull("The EventManager should contain this GUIEventListener-null pair.", set);
        assertTrue("The EventManager should contain this GUIEventListener-null pair.", set.contains(guiEventListener1));

        eventMgr.removeGUIEventListener(guiEventListener1);
        guiEventListeners = (Map<Class, Set<GUIEventListener>>) getFieldValue(eventMgr, "guiEventListeners");
        set = guiEventListeners.get(null);
        assertNotNull("The EventManager should not contain this GUIEventListener-null pair.", set);
        assertFalse("The EventManager should not contain this GUIEventListener-null pair.", set
                .contains(guiEventListener1));
    }

    /**
     * Test accuracy of <code>addActionEventListener(ActionEventListener)</code> and
     * <code>removeActionEventListener(ActionEventListener)</code>.
     */
    @SuppressWarnings("unchecked")
    public void testAddAndRemoveActionEventListenerActionEventListener() {
        eventMgr.addActionEventListener(actionEventListener1);
        Map<Class, Set<ActionEventListener>> actionEventListeners = (Map<Class, Set<ActionEventListener>>) getFieldValue(
                eventMgr, "actionEventListeners");
        Set set = actionEventListeners.get(null);
        assertNotNull("The EventManager should contain this ActionEventListener-null pair.", set);
        assertTrue("The EventManager should contain this ActionEventListener-null pair.", set
                .contains(actionEventListener1));

        eventMgr.removeActionEventListener(actionEventListener1);
        actionEventListeners = (Map<Class, Set<ActionEventListener>>) getFieldValue(eventMgr, "actionEventListeners");
        set = actionEventListeners.get(null);
        assertNotNull("The EventManager should not contain this ActionEventListener-null pair.", set);
        assertFalse("The EventManager should not contain this ActionEventListener-null pair.", set
                .contains(actionEventListener1));
    }

    /**
     * Returns the value of the given field in the given Object using Reflection.
     *
     * @param obj
     *            the given Object instance to get the field value.
     * @param fieldName
     *            the name of the filed to get value from the object.
     * @return the field value in the obj.
     */
    private static Object getFieldValue(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (SecurityException e) {
            // ignore the exception and return null.
        } catch (NoSuchFieldException e) {
            // ignore the exception and return null.
        } catch (IllegalArgumentException e) {
            // ignore the exception and return null.
        } catch (IllegalAccessException e) {
            // ignore the exception and return null.
        }
        return null;
    }

}
