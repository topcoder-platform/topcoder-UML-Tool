/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import com.topcoder.util.actionmanager.UndoableAction;

import java.util.EventObject;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>The mock implementation of <code>ActionEventListener</code> class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockActionEventListener implements ActionEventListener {
    /** A name used to identify the instance. */
    private String name = null;

    /** Records the performance of actionPerformed. */
    private Set<Pair<EventObject, EventValidation>> performedRecords
        = new HashSet<Pair<EventObject, EventValidation>>();

    /** Records the performance of redoActionPerformed. */
    private Set<Pair<RedoChangesEvent, UndoableAction>> redoPerformedRecords
        = new HashSet<Pair<RedoChangesEvent, UndoableAction>>();

    /** Records the performance of undoActionPerformed. */
    private Set<Pair<UndoChangesEvent, UndoableAction>> undoPerformedRecords
        = new HashSet<Pair<UndoChangesEvent, UndoableAction>>();

    /**
     * Creates a new MockActionEventListener object.
     *
     * @param name the name used to identify the instance
     */
    public MockActionEventListener(String name) {
        this.name = name;
    }

    /**
     * Mock implementation, just register this event.
     *
     * @param event the non null event has been performed
     * @param eventValidation the non null validation result
     *
     * @throws IllegalArgumentException if any argument is null
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation) {
        performedRecords.add(new Pair<EventObject, EventValidation>(event, eventValidation));
    }

    /**
     * Mock implementation, just register this event.
     *
     * @param event the non null event has been undone
     * @param undoableAction the non null action which is undone
     *
     * @throws IllegalArgumentException if any argument is null
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction) {
        undoPerformedRecords.add(new Pair<UndoChangesEvent, UndoableAction>(event, undoableAction));
    }

    /**
     * Mock implementation, just register this event.
     *
     * @param event the non null event which has been redo
     * @param undoableAction the non null action which is redone
     *
     * @throws IllegalArgumentException if any argument is null
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction) {
        redoPerformedRecords.add(new Pair<RedoChangesEvent, UndoableAction>(event, undoableAction));
    }

    /**
     * Get the instance name.
     *
     * @return the name of the instance
     */
    public String getName() {
        return name;
    }

    /**
     * Get the performance of actionPerformed.
     *
     * @return the performance of actionPerformed
     */
    public Set<Pair<EventObject, EventValidation>> getPerformedRecords() {
        return performedRecords;
    }

    /**
     * Get the performance of redoActionPerformed.
     *
     * @return the performance of redoActionPerformed
     */
    public Set<Pair<RedoChangesEvent, UndoableAction>> getRedoPerformedRecords() {
        return redoPerformedRecords;
    }

    /**
     * Get the performance of undoActionPerformed.
     *
     * @return the performance of undoActionPerformed
     */
    public Set<Pair<UndoChangesEvent, UndoableAction>> getUndoPerformedRecords() {
        return undoPerformedRecords;
    }
}
