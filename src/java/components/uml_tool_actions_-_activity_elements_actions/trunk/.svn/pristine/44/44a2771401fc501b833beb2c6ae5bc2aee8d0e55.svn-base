/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * RemoveTransitionAction class extends AbstractActivityUndoableAction abstract
 * class and it aims to remove the transition object from the activity graph it
 * attached to.
 * </p>
 *
 * <p>
 * Thread-safety: this class is immutable, but the internal state of its transition
 * variable may be changed externally, so it is not guaranteed to be thread-safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class RemoveTransitionAction extends AbstractActivityUndoableAction implements UndoableAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Transition";

    /**
     * <p>
     * Represents the transition to remove from its activity graph it attached
     * to in the execute method.
     * </p>
     *
     * <p>
     * Initialized in the constructor, and its reference is never changed
     * afterwards, non-null.
     * </p>
     */
    private final Transition transition;

    /**
     * <p>
     * Represents the StateMachine object owning the transition.
     * Used in execute and undo methods.
     * </p>
     *
     * <p>
     * Initialized in the constructor, and its reference is never
     * changed afterwards, non-null.
     * </p>
     */
    private final StateMachine stateMachine;

    /**
     * <p>
     * Constructs the RemoveTransitionAction with the given transition.
     * </p>
     *
     * @param transition the transition to remove from its activity graph it attached to.
     *
     * @throws IllegalArgumentException if the argument is null.
     */
    public RemoveTransitionAction(Transition transition) {
        super(PRESENTATION_NAME);

        Util.checkNull(transition, "transition");
        Util.checkNull(transition.getStateMachine(), "transition.stateMachine");

        this.transition = transition;
        this.stateMachine = transition.getStateMachine();
    }

    /**
     * <p>
     * Remove the transition from the activity graph it attaches to.
     * </p>
     *
     * @throws ActionExecutionException if any exception occurs.
     */
    public void execute() throws ActionExecutionException {
        stateMachine.removeTransition(transition);
    }

    /**
     * <p>
     * Undo the remove action, it will add the transition node back into the activity graph.
     * </p>
     *
     * <p>
     * Note, it will use super.logException method to log all exceptions
     * thrown except the CannotUndoException.
     * </p>
     *
     * @throws CannotUndoException if canUndo returns false
     */
    public void undo() {
        super.undo();

        stateMachine.addTransition(transition);
    }
}