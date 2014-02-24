/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.accuracytests;

import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * Dummy implementation of <code>ActionEventListener</code>.
 *
 * @author daiwb
 * @version 1.0
 */
public class DummyActionEventListener implements ActionEventListener {

    /**
     * N/A.
     */
    private String name;

    /**
     * N/A.
     */
    private Map<EventObject, EventValidation> actions = new HashMap<EventObject, EventValidation>();

    /**
     * N/A.
     */
    private Map<UndoChangesEvent, UndoableAction> undoActions = new HashMap<UndoChangesEvent, UndoableAction>();

    /**
     * N/A.
     */
    private Map<RedoChangesEvent, UndoableAction> redoActions = new HashMap<RedoChangesEvent, UndoableAction>();

    /**
     * N/A.
     *
     * @param name
     *            N/A.
     */
    DummyActionEventListener(String name) {
        this.name = name;
    }

    /**
     * N/A.
     *
     * @param event
     *            N/A.
     * @param eventValidation
     *            N/A.
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation) {
        actions.put(event, eventValidation);
    }

    /**
     * N/A.
     *
     * @param event
     *            N/A.
     * @param undoableAction
     *            N/A.
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction) {
        undoActions.put(event, undoableAction);
    }

    /**
     * N/A.
     *
     * @param event
     *            N/A.
     * @param undoableAction
     *            N/A.
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction) {
        redoActions.put(event, undoableAction);
    }

    /**
     * N/A.
     *
     * @return N/A.
     */
    public String getName() {
        return name;
    }

    /**
     * N/A.
     *
     * @return N/A.
     */
    public Map<EventObject, EventValidation> getActions() {
        return actions;
    }

    /**
     * N/A.
     *
     * @return N/A.
     */
    public Map<UndoChangesEvent, UndoableAction> getUndoActions() {
        return undoActions;
    }

    /**
     * N/A.
     *
     * @return N/A.
     */
    public Map<RedoChangesEvent, UndoableAction> getRedoActions() {
        return redoActions;
    }

}
