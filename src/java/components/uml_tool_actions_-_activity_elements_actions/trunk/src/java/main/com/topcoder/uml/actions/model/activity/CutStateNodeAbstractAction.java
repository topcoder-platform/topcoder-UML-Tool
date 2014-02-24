/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.StateVertex;

import java.awt.datatransfer.Clipboard;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * CutStateNodeAbstractAction abstract class extends AbstractActivityUndoableAction
 * abstract class. This action will copy the StateVertex node to the clipboard, and
 * then remove this node from the its attached activity graph.
 * </p>
 *
 * <p>
 * The Clipboard object passed in the constructor could be null, if so the system
 * Clipboard is used instead.
 * </p>
 *
 * <p>
 * Thread-safety: this class is stateless, but as its base-class is not thread-safe,
 * this class is not thread-safe too.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public abstract class CutStateNodeAbstractAction extends AbstractActivityUndoableAction implements UndoableAction {
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
     * Represents the Clipboard object the StateVertex object is copied to
     * in the execute method.
     * </p>
     *
     * <p>
     * Initialized in constructor, and never changed afterwards.
     * It must be non-null.
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Represents the container of the state node.
     * Used in execute and undo method.
     * </p>
     *
     * <p>
     * Initialized in the constructor and never changed afterwards.
     * It must be non-null.
     * </p>
     */
    private final CompositeState container;

    /**
     * <p>
     * Constructs the CutStateNodeAbstractAction with the given
     * name, sate and clipboard.
     * </p>
     *
     * <p>
     * Note, if the given clipboard is null then the system Clipboard is used instead.
     * </p>
     *
     * @param name the presentation name.
     * @param state the StateVertex object to copy to clipboard, may be null
     * @param clipboard the Clipboard object the StateVertex object is copied to.
     *
     * @throws IllegalArgumentException if the state argument or its container is null,
     * or fail to get the system clipboard.
     */
    protected CutStateNodeAbstractAction(String name, StateVertex state, Clipboard clipboard) {
        super(name);

        Util.checkNull(state, "state");
        Util.checkNull(state.getContainer(), "Container for the state");

        this.state = state;
        this.clipboard = clipboard == null ? Util.getSystemClipboard() : clipboard;
        this.container = state.getContainer();
    }

    /**
     * <p>
     * Cut the state node to clipboard, and remove the node from its
     * attached activity graph.
     * </p>
     *
     * @throws ActivityObjectCloneException if the clone operation fails
     * @throws ActionExecutionException if any exception occurs
     */
    public void execute() throws ActivityObjectCloneException, ActionExecutionException {
        ActivityObjectClipboardUtility.copyStateNode(state, clipboard);

        container.removeSubVertex(state);
    }

    /**
     * <p>
     * Undo the cut action, it will add the state node back into the activity graph.
     * </p>
     *
     * <p>
     * Note, it will use super.logException method to log all exceptions
     * thrown except the CannotUndoException.
     * </p>
     *
     * @throws CannotUndoException if canUndo returns false.
     */
    public void undo() {
        super.undo();

        container.addSubVertex(state);
    }
}
