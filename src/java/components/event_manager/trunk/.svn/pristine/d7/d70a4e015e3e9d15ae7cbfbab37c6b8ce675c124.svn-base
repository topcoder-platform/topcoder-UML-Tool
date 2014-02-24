/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import com.topcoder.util.actionmanager.UndoableAction;


/**
 * <p>
 * This class extends from the ActionEvent. The action inside must be an UndoableAction. The action will be redone by
 * the action manager.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b>
 * </p>
 *
 * <p>
 * This class is thread safe by being immutable.
 * </p>
 *
 * @author kinzz, TCSDEVELOPER
 * @version 1.0
 */
public class RedoChangesEvent extends ActionEvent {
    /**
     * <p>
     * Constructor of the undo changes event.
     * </p>
     *
     * @param action the non null undoable action carried by this event
     * @param source the event source
     *
     * @throws IllegalArgumentException if the action or source is null
     */
    public RedoChangesEvent(UndoableAction action, Object source) {
        super(action, source);
    }

    /**
     * <p>
     * Get the action carried by this event.
     * </p>
     *
     * @return the non null undoable action carried by this event
     */
    public UndoableAction getAction() {
        return (UndoableAction) super.getAction();
    }
}
