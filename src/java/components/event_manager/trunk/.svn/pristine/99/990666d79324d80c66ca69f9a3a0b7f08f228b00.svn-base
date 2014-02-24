/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.stresstests;

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
 * @author PE
 * @version 1.0
 */
public class MockActionEventListener implements ActionEventListener {
    /**
     * Mock implementation, do nothing.
     *
     * @param event the non null event has been performed
     * @param eventValidation the non null validation result
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation) {
    }

    /**
     * Mock implementation, do nothing.
     *
     * @param event the non null event has been undone
     * @param undoableAction the non null action which is undone
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction) {
    }

    /**
     * Mock implementation, do nothing.
     *
     * @param event the non null event which has been redo
     * @param undoableAction the non null action which is redone
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction) {
    }
}
