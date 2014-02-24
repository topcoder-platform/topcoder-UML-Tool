/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import com.topcoder.util.actionmanager.UndoableAction;

import java.util.EventObject;


/**
 * This interface specifies the contract for implementation of an action event listener. It represents the listener
 * notified by the event manager about action events and about the undo/redone events. It provides a method to be
 * invoked about the execution of an action, using the action event and the validation result. It will also provide
 * two methods to be used when an undo/redone event occurred. These methods will be invoked for each undoable action
 * that is undone/redone.
 *
 * <p>
 * <b>Thread Safety:</b>
 * </p>
 *
 * <p>
 * The implementation of this interface is typically thread-safe.
 * </p>
 *
 * @author kinzz, TCSDEVELOPER
 * @version 1.0
 */
public interface ActionEventListener {
    /**
     * <p>
     * This method is called to inform the listener that the event is performed.
     * </p>
     *
     * @param event the non null event has been performed
     * @param eventValidation the non null validation result
     *
     * @throws IllegalArgumentException if event or eventValidation is null
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation);

    /**
     * <p>
     * This method is called to inform the listener that the event is undone.
     * </p>
     *
     * @param event the non null event has been undone
     * @param undoableAction the non null action which is undone
     *
     * @throws IllegalArgumentException if event or undoableAction is null
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction);

    /**
     * <p>
     * This method is called to inform the listener that the event is redone.
     * </p>
     *
     * @param event the non null event which has been redone
     * @param undoableAction the non null action which is redone
     *
     * @throws IllegalArgumentException if event or undoableAction is null
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction);
}
