/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.failuretests;

import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

import java.util.EventObject;

/**
 * <p>
 * The mock implementation of <code>ActionEventListener</code> class.
 * </p>
 *
 * @author King_Bette
 * @version 1.0
 */
public class MockActionEventListener implements ActionEventListener {

    /**
     * Creates a new MockActionEventListener object.
     */
    public MockActionEventListener() {
        // do nothing.
    }

    /**
     * Mock implementation, do nothing.
     *
     * @param event
     *            the non null event has been performed
     * @param eventValidation
     *            the non null validation result
     * @throws IllegalArgumentException
     *             if any argument is null
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation) {
        // do nothing.
    }

    /**
     * Mock implementation, do nothing.
     *
     * @param event
     *            the non null event has been undone
     * @param undoableAction
     *            the non null action which is undone
     * @throws IllegalArgumentException
     *             if any argument is null
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction) {
        // do nothing.
    }

    /**
     * Mock implementation, do nothing.
     *
     * @param event
     *            the non null event which has been redo
     * @param undoableAction
     *            the non null action which is redone
     * @throws IllegalArgumentException
     *             if any argument is null
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction) {
        // do nothing.
    }
}
