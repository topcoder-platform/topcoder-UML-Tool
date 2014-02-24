/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.statemachines.StateVertex;
import java.awt.datatransfer.Clipboard;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * CopyStateNodeAbstractAction abstract class implements the TransientAction
 * interface. It is the base class for all copy actions, it is used to copy
 * the StateVertex node to the clipboard.
 *
 * <p>
 * Note, the Clipboard object passed in the constructor could be null,
 * if so the system Clipboard is used instead.
 * </p>
 *
 * <p>
 * Thread-safety: this class is immutable, but the internal state of its
 * state variable may be changed externally, so it is not guaranteed to
 * be thread-safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public abstract class CopyStateNodeAbstractAction implements TransientAction {
    /**
     * <p>
     * Represents the StateVertex object to copy to clipboard in the execute method.
     * </p>
     *
     * <p>
     * Initialized in the constructor and never changed afterwards.
     * It must be non-null.
     * </p>
     *
     */
    private final StateVertex state;

    /**
     * <p>
     * Represents the Clipboard object the StateVertex object is copied to in the execute method.
     * </p>
     *
     * <p>
     * Initialized in constructor, and never changed afterwards.
     * It must be non-null.
     * </p>
     *
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Constructs the CopyStateNodeAbstractAction with the given state and clipboard.
     * </p>
     *
     * <p>
     * Note, if the given clipboard is null then the system Clipboard is used instead.
     * </p>
     *
     * @param state the StateVertex object to copy to clipboard
     * @param clipboard the Clipboard object the StateVertex object is copied to, may be null
     *
     * @throws IllegalArgumentException if the state argument is null,
     * or fail to get the system clipboard
     */
    protected CopyStateNodeAbstractAction(StateVertex state, Clipboard clipboard) {
        Util.checkNull(state, "state");

        this.state = state;
        this.clipboard = (clipboard == null) ? Util.getSystemClipboard() : clipboard;
    }

    /**
     * <p>
     * Copy the state node to the clipboard.
     * </p>
     *
     * @throws ActivityObjectCloneException if the clone operation fails.
     * @throws ActionExecutionException if any error occurs during the execution.
     */
    public void execute() throws ActivityObjectCloneException, ActionExecutionException {
        ActivityObjectClipboardUtility.copyStateNode(state, clipboard);
    }
}
