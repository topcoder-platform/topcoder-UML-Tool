/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.custom;

import com.topcoder.uml.actions.general.Helper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will set / remove / change the
 * guard for a transition from an activity graph.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the
 * action, undo to undo the action and execute to execute the action.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, rainday
 * @version 1.0
 */
public class SetTransitionGuardAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the transition to be updated. This variable is set in the constructor, is
     * immutable (the reference) and never be null. This variable is referenced in the redoAction
     * and executeAction methods.
     * </p>
     */
    private final Transition transition;

    /**
     * <p>
     * Represents the old guard of the transition before this action performed. This variable is set
     * in the constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final Guard oldGuard;

    /**
     * <p>
     * Represents the new guard of the transition after this action performed. This variable is set
     * in the constructor, is immutable. This variable is referenced in the redoAction and execute
     * methods.
     * </p>
     */
    private final Guard newGuard;

    /**
     * <p>
     * Constructor of the set transition guard action.
     * </p>
     *
     * @param transition
     *        the non null transition to set the guard
     * @param guard
     *        the possible null new guard of the transition
     * @throws IllegalArgumentException
     *         if any non null argument is null
     */
    public SetTransitionGuardAction(Transition transition, Guard guard) {
        super("Set transition guard");
        Helper.checkNotNull(transition, "transition");
        this.transition = transition;
        oldGuard = transition.getGuard();
        newGuard = guard;
    }

    /**
     * <p>
     * Redo the set transition guard action.
     * </p>
     *
     */
    public void redoAction() {
        transition.setGuard(newGuard);
    }

    /**
     * <p>
     * Undo the set transition guard action.
     * </p>
     */
    public void undoAction() {
        transition.setGuard(oldGuard);
    }

    /**
     * <p>
     * Execute the set transition guard action.
     * </p>
     */
    public void executeAction() {
        transition.setGuard(newGuard);
    }
}
