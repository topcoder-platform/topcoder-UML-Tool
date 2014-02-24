/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import com.topcoder.util.actionmanager.ActionManager;
import com.topcoder.util.actionmanager.UndoableAction;

import java.util.List;


/**
 * <p>The mock implementation of <code>ActionManager</code>.<br></p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockActionManager extends ActionManager {
    /** Represents the actions to be undone. */
    private List<UndoableAction> actionsTobeUndone = null;

    /** Represents the actions to be redone. */
    private List<UndoableAction> actionsTobeRedone = null;

    /**
     * <p>Set the actions to be undone.</p>
     *
     * @param actionsTobeUndone the actions to be undone.
     */
    public void setUndoableActionsToBeUndone(List<UndoableAction> actionsTobeUndone) {
        this.actionsTobeUndone = actionsTobeUndone;
    }

    /**
     * <p>Set the actions to be redone.</p>
     *
     * @param actionsTobeRedone the actions to be redone.
     */
    public void setUndoableActionsToBeRedone(List<UndoableAction> actionsTobeRedone) {
        this.actionsTobeRedone = actionsTobeRedone;
    }

    /**
     * <p>Get the actions to be undone.</p>
     *
     * @return the actions to be undone
     */
    public List<UndoableAction> getUndoableActionsToBeUndone() {
        return actionsTobeUndone;
    }

    /**
     * <p>Get the actions to be redone.</p>
     *
     * @return the actions to be redone
     */
    public List<UndoableAction> getUndoableActionsToBeRedone() {
        return actionsTobeRedone;
    }
}
