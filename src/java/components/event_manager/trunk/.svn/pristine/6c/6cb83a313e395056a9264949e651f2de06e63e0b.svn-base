/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.stresstests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.util.actionmanager.ActionManager;
import com.topcoder.util.actionmanager.CompoundUndoableAction;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEvent;
import com.topcoder.util.eventmanager.MockAddClassDiagramAction;
import com.topcoder.util.eventmanager.EventManager;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Tests the stress aspect of <code>EventManager</code> class.
 * </p>
 * 
 * @author PE
 * @version 1.0
 */
public class EventManagerStressTest extends TestCase {
    /** Represents the amount to invoke the methods in this stress test. */
    private static final int COUNT = 10000;

    /** Represents the <code>EventManager</code> instance used for testing. */
    private EventManager manager;

    /** Represents the <code>UndoableAction</code> instance used for testing. */
    private UndoableAction undoableAction;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * 
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        undoableAction = new MockAddClassDiagramAction();
        List<UndoableAction> actions = new ArrayList<UndoableAction>();
        for (int i = 0; i < 10; i++) {
            actions.add(new CompoundUndoableAction("Action"));
        }
        actions.add(undoableAction);
        manager = new EventManager(new ActionManager());
        for (int i = 0; i < 10; i++) {
            manager.addActionEventListener(new MockActionEventListener());
            manager.addActionEventListener(new MockActionEventListener(), undoableAction.getClass());
        }
        for (int i = 0; i < 10; i++) {
            manager.addGUIEventListener(new MockGUIEventListener());
            manager.addGUIEventListener(new MockGUIEventListener(), ActionEvent.class);
        }
        for (int i = 0; i < 10; i++) {
            manager.addEventValidator(new MockActionEventValidator());
            manager.addEventValidator(new MockActionEventValidator(), undoableAction.getClass());
        }
    }

    /**
     * <p>
     * Tests the method <code>handleActionEvent(ActionEvent)</code> when the event is simple ActionEvent.
     * </p>
     * 
     * @throws Exception to JUnit
     */
    public void testHandleActionEvent_SimpleActionEvent() throws Exception {
        ActionEvent actionEvent = new ActionEvent(undoableAction, "source");
        long now = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            manager.handleActionEvent(actionEvent);
        }
        System.out.println("Invoking handleActionEvent(ActionEvent) with simple ActionEvent for " + COUNT
                + " times takes " + (System.currentTimeMillis() - now) / 1000.0 + " seconds.");
    }

    /**
     * <p>
     * Tests the method <code>handleActionEvent(ActionEvent)</code> when the event is UndoChangesEvent.
     * </p>
     * 
     * @throws Exception to JUnit
     */
    public void testHandleActionEvent_UndoChangesEvent() throws Exception {
        UndoChangesEvent actionEvent = new UndoChangesEvent(undoableAction, undoableAction);
        long now = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            manager.handleActionEvent(actionEvent);
        }
        System.out.println("Invoking handleActionEvent(ActionEvent) with UndoChangesEvent for " + COUNT
                + " times takes " + (System.currentTimeMillis() - now) / 1000.0 + " seconds.");
    }

    /**
     * <p>
     * Tests the method <code>handleActionEvent(ActionEvent)</code> when the event is RedoChangesEvent.
     * </p>
     * 
     * @throws Exception to JUnit
     */
    public void testHandleActionEvent_RedoChangesEvent() throws Exception {
        RedoChangesEvent actionEvent = new RedoChangesEvent(undoableAction, undoableAction);
        long now = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            manager.handleActionEvent(actionEvent);
        }
        System.out.println("Invoking handleActionEvent(ActionEvent) with RedoChangesEvent for " + COUNT
                + " times takes " + (System.currentTimeMillis() - now) / 1000.0 + " seconds.");
    }

    /**
     * <p>
     * Tests the method <code>handleGUIEvent(EventObject)</code>.
     * </p>
     * 
     * @throws Exception to JUnit
     */
    public void testHandleGUIEvent() throws Exception {
        ActionEvent actionEvent = new ActionEvent(undoableAction, undoableAction);
        long now = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            manager.handleGUIEvent(actionEvent);
        }
        System.out.println("Invoking handleGUIEvent(EventObject) for " + COUNT + " times takes "
                + (System.currentTimeMillis() - now) / 1000.0 + " seconds.");
    }
}
