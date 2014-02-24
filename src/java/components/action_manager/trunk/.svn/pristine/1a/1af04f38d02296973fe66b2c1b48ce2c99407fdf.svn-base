/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.stresstests;

import junit.framework.TestCase;

import com.topcoder.util.actionmanager.ActionManager;

/**
 * Stress test for <code>ActionManager</code>.
 * @author fuyun
 * @version 1.0
 */
public class ActionManagerStressTest extends TestCase {

    /**
     * The instance used for testing.
     */
    private ActionManager manager = null;

    /**
     * <p>
     * Sets up the test environment.
     * </p>
     * <p>
     * The <code>ActionManager</code> instance is created for testing.
     * </p>
     */
    protected void setUp() {
        manager = new ActionManager(999, null, null);

    }

    /**
     * Stress test for <code>executeAction(UndoableAction)</code>.
     * @throws Exception
     *             if there is any problem.
     */
    public void testExecuteActionStress() throws Exception {
        MyUndoableAction[] actions = new MyUndoableAction[1000];
        for (int i = 0; i < 1000; i++) {
            actions[i] = new MyUndoableAction();
        }

        for (int i = 0; i < 1000; i++) {
            manager.executeAction(actions[i]);
        }

        assertEquals("Fails to get the actions to be undone.", 999, manager
                    .getUndoableActionsToBeUndone().size());
        assertEquals("Fails to get the actions to be redone.", 0, manager
                    .getUndoableActionsToBeRedone().size());

    }

    /**
     * Stress test for <code>redoActions(UndoableAction)</code> and
     * <code>undoActions</code>.
     * @throws Exception
     *             if there is any problem.
     */
    public void testExecuteUndoRedoActionsStress() throws Exception {
        MyUndoableAction[] actions = new MyUndoableAction[1000];
        for (int i = 0; i < 1000; i++) {
            actions[i] = new MyUndoableAction();
        }

        for (int i = 0; i < 1000; i++) {
            manager.executeAction(actions[i]);
        }

        manager.undoActions(actions[900]);

        assertEquals("Fails to get the actions to be undone.", 899, manager
                    .getUndoableActionsToBeUndone().size());
        assertEquals("Fails to get the actions to be redone.", 100, manager
                    .getUndoableActionsToBeRedone().size());

        manager.redoActions(actions[950]);

        assertEquals("Fails to get the actions to be undone.", 950, manager
                    .getUndoableActionsToBeUndone().size());
        assertEquals("Fails to get the actions to be redone.", 49, manager
                    .getUndoableActionsToBeRedone().size());

        manager.undoActions(actions[1]);

        assertEquals("Fails to get the actions to be undone.", 0, manager
                    .getUndoableActionsToBeUndone().size());
        assertEquals("Fails to get the actions to be redone.", 999, manager
                    .getUndoableActionsToBeRedone().size());

    }

}
