/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.stresstests;

import com.topcoder.util.actionmanager.ActionManager;
import com.topcoder.util.actionmanager.UndoableAction;

import java.util.List;

/**
 * <p>
 * The mock implementation of <code>ActionManager</code>.
 * </p>
 * 
 * @author PE
 * @version 1.0
 */
public class MockActionManager extends ActionManager {
    /** Represents the actions. */
    private List<UndoableAction> actions = null;

    /**
     * <p>
     * Creates the new MockActionManager instance.
     * </p>
     * 
     * @param actions the actions.
     */
    public MockActionManager(List<UndoableAction> actions) {
        this.actions = actions;
    }

    /**
     * <p>
     * Get the actions to be undone.
     * </p>
     * 
     * @return the actions to be undone
     */
    public List<UndoableAction> getUndoableActionsToBeUndone() {
        return actions;
    }

    /**
     * <p>
     * Get the actions to be redone.
     * </p>
     * 
     * @return the actions to be redone
     */
    public List<UndoableAction> getUndoableActionsToBeRedone() {
        return actions;
    }
}
