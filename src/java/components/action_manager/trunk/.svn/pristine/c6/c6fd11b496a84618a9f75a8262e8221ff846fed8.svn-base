/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.accuracytests;

import junit.framework.TestCase;

import com.topcoder.util.actionmanager.ActionManager;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.Level;
import com.topcoder.util.log.LogFactory;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Accuracy tests for <code>ActionManager</code>.
 *
 * @author hackerzhut
 * @version 1.0
 */
public class ActionManagerAccuracyTests extends TestCase {
    /** Represents the ActionManager instance for testing. */
    private ActionManager instance = null;

    /** Represents the Log instance for testing. */
    private Log logger = null;

    /** The integer counter used for testing. */
    private AtomicInteger integer;

    /**
     * Initialization for all tests here.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.unloadConfig();
        Helper.loadConfigFromFile("Logger_Wrapper.xml");
        Helper.loadConfigFromFile("config.xml");
        this.logger = LogFactory.getLog("com.topcoder.util.log");
        this.instance = new ActionManager();
        this.integer = new AtomicInteger();
    }

    /**
     * Clean up the entironment.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        Helper.unloadConfig();
    }

    /**
     * Test Method: ActionManager()
     * Condition: Create new ActionManager instance using no-arg constructor.
     * Expected: Should return non null object.
     *
     * @throws Exception to jUnit.
     */
    public void test_ActionManager_0arg() throws Exception {
        assertNotNull("Should not be null.", new ActionManager());
    }

    /**
     * Test Method: ActionManager(String namespace)
     * Condition: Create new ActionManager instance using 1-arg constructor.
     * Expected: Created object should not be null.
     *
     * @throws Exception to jUnit.
     */
    public void test_ActionManager_1arg() throws Exception {
        assertNotNull("Should not be null.", new ActionManager("missing.logger_name"));
        assertNotNull("Should not be null.", new ActionManager("missing.logging_level"));
        assertNotNull("Should not be null.", new ActionManager("com.topcoder.util.actionmanager.ActionManager"));
    }

    /**
     * Test Method: ActionManager(int maxUndoableActions, Log logger, Level loggingLevel)
     * Condition: Create new ActionManager instance using 3-arg constructor.
     * Expected: non null object.
     *
     * @throws Exception to jUnit.
     */
    public void test_ActionManager_3arg() throws Exception {
        assertNotNull("Should not be null.", new ActionManager(2, this.logger, Level.WARN));
        assertNotNull("Should not be null.", new ActionManager(2, null, Level.WARN));
        assertNotNull("Should not be null.", new ActionManager(2, null, null));
        assertNotNull("Should not be null.", new ActionManager(2, this.logger, null));
    }

    /**
     * Test Method: executeAction(Action)
     * Condition: execute the action.
     * Expected: verifies whether the action is executed.
     *
     * @throws Exception to jUnit.
     */
    public void test_executeAction() throws Exception {
        MockUndoableAction action = new MockUndoableAction(integer);
        instance.executeAction(action);

        // It should be 1.
        assertEquals(1, integer.get());
        List<UndoableAction> actions = instance.getUndoableActionsToBeUndone();
        assertEquals(1, actions.size());
        assertEquals(action, actions.get(0));
    }

    /**
     * Test Method: undoActions(UndoableAction)
     * Condition: n/a
     * Expected: verifies whether the action can be undone.
     *
     * @throws Exception to jUnit.
     */
    public void test_undoActions() throws Exception {
        MockUndoableAction action1 = new MockUndoableAction(integer);
        MockUndoableAction action2 = new MockUndoableAction(integer);
        MockUndoableAction action3 = new MockUndoableAction(integer);
        instance.executeAction(action1);
        instance.executeAction(action2);
        instance.executeAction(action3);

        // counter is 2 if undo to action3.
        instance.undoActions(action3);
        assertEquals(2, integer.get());
        // counter will be 0 if undo to action1.
        instance.undoActions(action1);
        assertEquals(0, integer.get());
    }

    /**
     * Test Method: redoActions(UndoableAction)
     * Condition: n/a
     * Expected: verifies whether the action can be redone.
     *
     * @throws Exception to jUnit.
     */
    public void test_redoActions() throws Exception {
        MockUndoableAction action1 = new MockUndoableAction(integer);
        instance.executeAction(action1);
        MockUndoableAction action2 = new MockUndoableAction(integer);
        instance.executeAction(action2);
        MockUndoableAction action3 = new MockUndoableAction(integer);
        instance.executeAction(action3);

        // make all actions undone.
        instance.undoActions(action1);

        // redo till action2
        instance.redoActions(action2);
        assertEquals(2, integer.get());

        // redo till action3
        instance.redoActions(action3);
        assertEquals(3, integer.get());
    }

    /**
     * Test Method: getUndoableActionToBeUndone()
     * Condition: n/a
     * Expected: verifies whether the action returned is last.
     *
     * @throws Exception to jUnit.
     */
    public void test_getUndoableActionToBeUndone() throws Exception {
        MockUndoableAction action = new MockUndoableAction(integer);
        instance.executeAction(new MockUndoableAction(integer));
        instance.executeAction(new MockUndoableAction(integer));
        instance.executeAction(new MockUndoableAction(integer));
        instance.executeAction(new MockUndoableAction(integer));
        instance.executeAction(new MockUndoableAction(integer));
        instance.executeAction(new MockUndoableAction(integer));
        instance.executeAction(action);

        // it should be last action.
        assertEquals("should be equal.", action, instance.getUndoableActionToBeUndone());
    }

    /**
     * Test Method: getUndoableActionsToBeUndone()
     * Condition: n/a
     * Expected: verifies whether the list of actions returned is last.
     *
     * @throws Exception to jUnit.
     */
    public void test_getUndoableActionsToBeUndone() throws Exception {
        MockUndoableAction action1 = new MockUndoableAction(integer);
        MockUndoableAction action2 = new MockUndoableAction(integer);
        instance.executeAction(action1);
        instance.executeAction(action2);

        List<UndoableAction> undoableActionsToBeUndone = instance.getUndoableActionsToBeUndone();
        assertEquals("Should be 2", 2, undoableActionsToBeUndone.size());

        assertTrue("Should contain action1", undoableActionsToBeUndone.contains(action1));
        assertTrue("Should contain action2", undoableActionsToBeUndone.contains(action2));
    }

    /**
     * Test Method: getUndoableActionToBeRedone()
     * Condition: n/a
     * Expected: verifies whether the last action undone.
     *
     * @throws Exception to jUnit.
     */
    public void test_getUndoableActionToBeRedone() throws Exception {
        MockUndoableAction action = new MockUndoableAction(integer);
        instance.executeAction(action);
        instance.executeAction(new MockUndoableAction(integer));
        instance.executeAction(new MockUndoableAction(integer));

        instance.undoActions(action);

        assertEquals("Should be equal", action, instance.getUndoableActionToBeRedone());
    }

    /**
     * Test Method: getUndoableActionsToBeRedone()
     * Condition: n/a
     * Expected: verifies whether the list of last action undone.
     *
     * @throws Exception to jUnit.
     */
    public void test_getUndoableActionsToBeRedone() throws Exception {
        MockUndoableAction action1 = new MockUndoableAction(integer);
        MockUndoableAction action2 = new MockUndoableAction(integer);
        instance.executeAction(action1);
        instance.executeAction(action2);

        instance.undoActions(action1);

        List<UndoableAction> undoableActionsToBeRedone = instance.getUndoableActionsToBeRedone();

        assertEquals("Should be 2.", 2, undoableActionsToBeRedone.size());

        assertTrue(undoableActionsToBeRedone.contains(action1));
        assertTrue(undoableActionsToBeRedone.contains(action2));
    }
}