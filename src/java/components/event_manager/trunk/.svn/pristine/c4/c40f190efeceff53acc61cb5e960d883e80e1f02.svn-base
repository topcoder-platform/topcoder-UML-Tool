/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.failuretests;

import java.util.EventObject;

import com.topcoder.util.actionmanager.ActionManager;
import com.topcoder.util.eventmanager.EventManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for EventManager class.
 *
 * @author King_Bette
 * @version 1.0
 */
public class EventManagerFailureTest extends TestCase {
    /**
     * Represents an action manager that is used in the test.
     */
    private ActionManager actionManager = new ActionManager();
    /**
     * Represents event manager that is used in the test.
     */
    private EventManager eventManager = new EventManager(actionManager);
    /**
     * Represents a mock action event listener.
     */
    private MockActionEventListener actionEventListener = new MockActionEventListener();
    /**
     * Represents a mock gui event listener.
     */
    private MockGUIEventListener guiEventListener = new MockGUIEventListener();
    /**
     * Represents a mock action event validator.
     */
    private MockActionEventValidator eventValidator = new MockActionEventValidator();
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(EventManagerFailureTest.class);
    }

    /**
     * Failure test of <code>EventManager(ActionManager actionManager)</code> constructor.
     *
     * <p>
     * actionManager is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testEventManagerFailureNullActionManager() throws Exception {
        try {
            new EventManager(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>handleActionEvent(ActionEvent event)</code> method.
     *
     * <p>
     * event is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testHandleActionEventFailureNullEvent() throws Exception {
        try {
            eventManager.handleActionEvent(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>handleGUIEvent(EventObject event)</code> method.
     *
     * <p>
     * event is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testHandleGUIEventFailureNullEvent() throws Exception {
        try {
            eventManager.handleGUIEvent(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addEventValidator(ActionEventValidator eventValidator)</code> method.
     *
     * <p>
     * eventValidator is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddEventValidator1FailureNullEventValidator() throws Exception {
        try {
            eventManager.addEventValidator(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addActionEventListener(ActionEventListener listener)</code> method.
     *
     * <p>
     * listener is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddActionEventListener1FailureNullListener() throws Exception {
        try {
            eventManager.addActionEventListener(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addGUIEventListener(GUIEventListener listener)</code> method.
     *
     * <p>
     * listener is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddGUIEventListener1FailureNullListener() throws Exception {
        try {
            eventManager.addGUIEventListener(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeEventValidator(ActionEventValidator eventValidator)</code> method.
     *
     * <p>
     * eventValidator is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveEventValidator1FailureNullEventValidator() throws Exception {
        try {
            eventManager.removeEventValidator(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeActionEventListener(ActionEventListener listener)</code> method.
     *
     * <p>
     * listener is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveActionEventListener1FailureNullListener() throws Exception {
        try {
            eventManager.removeActionEventListener(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeGUIEventListener(GUIEventListener listener)</code> method.
     *
     * <p>
     * listener is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveGUIEventListener1FailureNullListener() throws Exception {
        try {
            eventManager.removeGUIEventListener(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addEventValidator(ActionEventValidator eventValidator, Class actionClass)</code> method.
     *
     * <p>
     * eventValidator is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddEventValidator2FailureNullEventValidator() throws Exception {
        try {
            eventManager.addEventValidator(null, MockUndoableAction.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addEventValidator(ActionEventValidator eventValidator, Class actionClass)</code> method.
     *
     * <p>
     * actionClass is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddEventValidator2FailureNullActionClass() throws Exception {
        try {
            eventManager.addEventValidator(eventValidator, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addEventValidator(ActionEventValidator eventValidator, Class actionClass)</code> method.
     *
     * <p>
     * actionClass is invalid.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddEventValidator2FailureInvalidActionClass() throws Exception {
        try {
            eventManager.addEventValidator(eventValidator, String.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addActionEventListener(ActionEventListener listener, Class actionClass)</code> method.
     *
     * <p>
     * listener is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddActionEventListener2FailureNullListener() throws Exception {
        try {
            eventManager.addActionEventListener(null, MockUndoableAction.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addActionEventListener(ActionEventListener listener, Class actionClass)</code> method.
     *
     * <p>
     * actionClass is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddActionEventListener2FailureNullActionClass() throws Exception {
        try {
            eventManager.addActionEventListener(actionEventListener, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addActionEventListener(ActionEventListener listener, Class actionClass)</code> method.
     *
     * <p>
     * actionClass is invalid.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddActionEventListener2FailureInvalidActionClass() throws Exception {
        try {
            eventManager.addActionEventListener(actionEventListener, String.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addGUIEventListener(GUIEventListener listener, Class eventClass)</code> method.
     *
     * <p>
     * listener is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddGUIEventListener2FailureNullListener() throws Exception {
        try {
            eventManager.addGUIEventListener(null, EventObject.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addGUIEventListener(GUIEventListener listener, Class eventClass)</code> method.
     *
     * <p>
     * eventClass is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddGUIEventListener2FailureNullEventClass() throws Exception {
        try {
            eventManager.addGUIEventListener(guiEventListener, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addGUIEventListener(GUIEventListener listener, Class eventClass)</code> method.
     *
     * <p>
     * eventClass is invalid.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddGUIEventListener2FailureInvalidEventClass() throws Exception {
        try {
            eventManager.addGUIEventListener(guiEventListener, MockUndoableAction.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeEventValidator(ActionEventValidator eventValidator, Class actionClass)</code> method.
     *
     * <p>
     * eventValidator is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveEventValidator2FailureNullEventValidator() throws Exception {
        try {
            eventManager.removeEventValidator(null, MockUndoableAction.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeEventValidator(ActionEventValidator eventValidator, Class actionClass)</code> method.
     *
     * <p>
     * actionClass is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveEventValidator2FailureNullActionClass() throws Exception {
        try {
            eventManager.removeEventValidator(eventValidator, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeEventValidator(ActionEventValidator eventValidator, Class actionClass)</code> method.
     *
     * <p>
     * actionClass is invalid.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveEventValidator2FailureInvalidActionClass() throws Exception {
        try {
            eventManager.removeEventValidator(eventValidator, String.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeActionEventListener(ActionEventListener listener, Class actionClass)</code> method.
     *
     * <p>
     * listener is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveActionEventListener2FailureNullListener() throws Exception {
        try {
            eventManager.removeActionEventListener(null, MockUndoableAction.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeActionEventListener(ActionEventListener listener, Class actionClass)</code> method.
     *
     * <p>
     * actionClass is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveActionEventListener2FailureNullActionClass() throws Exception {
        try {
            eventManager.removeActionEventListener(actionEventListener, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeActionEventListener(ActionEventListener listener, Class actionClass)</code> method.
     *
     * <p>
     * actionClass is invalid.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveActionEventListener2FailureInvalidActionClass() throws Exception {
        try {
            eventManager.removeActionEventListener(actionEventListener, String.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeGUIEventListener(GUIEventListener listener, Class eventClass)</code> method.
     *
     * <p>
     * listener is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveGUIEventListener2FailureNullListener() throws Exception {
        try {
            eventManager.removeGUIEventListener(null, EventObject.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeGUIEventListener(GUIEventListener listener, Class eventClass)</code> method.
     *
     * <p>
     * eventClass is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveGUIEventListener2FailureNullEventClass() throws Exception {
        try {
            eventManager.removeGUIEventListener(guiEventListener, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeGUIEventListener(GUIEventListener listener, Class eventClass)</code> method.
     *
     * <p>
     * eventClass is invalid.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveGUIEventListener2FailureInvalidEventClass() throws Exception {
        try {
            eventManager.removeGUIEventListener(guiEventListener, MockUndoableAction.class);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
