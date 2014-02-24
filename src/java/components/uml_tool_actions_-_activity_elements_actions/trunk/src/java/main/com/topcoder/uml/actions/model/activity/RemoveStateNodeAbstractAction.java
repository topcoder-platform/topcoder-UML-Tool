/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * RemoveStateNodeAbstractAction abstract class extends AbstractActivityUndoableAction
 * abstract class and it is the parent class of all actions regarding to remove a
 * StateVertex object from the activity graph it attached to.
 * </p>
 *
 * <p>
 * Thread-safety: this class is immutable, but the internal state of its state
 * variable may be changed externally, so it is not guaranteed to be thread-safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public abstract class RemoveStateNodeAbstractAction extends AbstractActivityUndoableAction implements UndoableAction {

    /**
     * <p>
     * Represents the StateVertex object to remove from its activity graph it
     * attached to in the execute method.
     * </p>
     *
     * <p>
     * Initialized in the constructor, and its reference is never changed
     * afterwards, non-null.
     * </p>
     */
    private final StateVertex state;

    /**
     * <p>
     * Represents the container of the state node. Used in execute and undo method.
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
     * Constructs the RemoveStateNodeAbstractAction with the given
     * name and state.
     * </p>
     *
     * @param name the presentation name.
     * @param state the StateVertex object to remove
     *
     * @throws IllegalArgumentException if the argument is null
     */
    protected RemoveStateNodeAbstractAction(String name, StateVertex state) {
        super(name);

        Util.checkNull(state, "state");
        Util.checkNull(state.getContainer(), "state.container");

        this.state = state;
        this.container = state.getContainer();
    }

    /**
     * <p>
     * Remove the state node from the activity graph it attaches to.
     * </p>
     *
     * @throws ActionExecutionException if any exception occurs.
     */
    public void execute() throws ActionExecutionException {
        container.removeSubVertex(state);
    }

    /**
     * <p>
     * Undo the remove action, it will add the state node back into the activity graph.
     * </p>
     *
     * <p>
     * Note, it will use super.logException method to log all exceptions thrown
     * except the CannotUndoException.
     * </p>
     *
     * @throws CannotUndoException if canUndo returns false
     */
    public void undo() {
        super.undo();

        container.addSubVertex(state);
    }
}
