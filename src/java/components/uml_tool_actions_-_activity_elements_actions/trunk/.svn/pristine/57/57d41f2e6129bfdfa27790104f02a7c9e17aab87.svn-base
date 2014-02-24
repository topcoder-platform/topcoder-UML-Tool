/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * CutTransitionAction class extends AbstractActivityUndoableAction
 * abstract class. This action will copy the Transition object to
 * the clipboard, and then remove this object from the its attached
 * activity graph.
 * </p>
 *
 * <p>
 * The Clipboard object passed in the constructor
 * could be null, if so the system Clipboard is used instead.
 * </p>
 *
 * <p>
 * Thread-safety: this class is immutable, but as the internal state
 * of state attribute could be changed externally, this class is not
 * guaranteed to be thread-safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class CutTransitionAction extends AbstractActivityUndoableAction implements UndoableAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Cut Transition";

    /**
     * <p>
     * Represents the Transition object cut to clipboard in the execute method.
     * </p>
     *
     * <p>
     * Initialized in constructor, and never changed afterwards.
     * It must be non-null.
     * </p>
     */
    private final Transition transition;

    /**
     * <p>
     * Represents the Clipboard object the Transition object is cut to in the execute method.
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
     * Represents the StateMachine object owning the transition.
     * Used in execute and undo methods.
     * </p>
     *
     * <p>
     * Initialized in the constructor, and its reference is
     * never changed afterwards, non-null.
     * </p>
     */
    private final StateMachine stateMachine;

    /**
     * <p>
     * Constructs the CutTransitionAction with the given
     * transition and clipboard.
     * </p>
     *
     * <p>
     * Note, if the given clipboard is null then the system Clipboard is used instead.
     * </p>
     *
     * @param transition the Transition object cut to clipboard
     * @param clipboard the Clipboard object the Transition object is cut to
     *
     * @throws IllegalArgumentException if the transition argument is null, or if the state
     * machine for the given transition is null, or fail to get the system clip board.
     */
    public CutTransitionAction(Transition transition, Clipboard clipboard) {
        super(PRESENTATION_NAME);

        Util.checkNull(transition, "transition");
        Util.checkNull(transition.getStateMachine(), "StateMachine for transition");

        this.transition = transition;
        this.clipboard = clipboard == null ? Util.getSystemClipboard() : clipboard;
        this.stateMachine = transition.getStateMachine();
    }

    /**
     * <p>
     * Cut the Transition object to the clipboard, and then remove
     * it from its attached activity graph.
     * </p>
     *
     * @throws ActionExecutionException if any exception occurs
     */
    public void execute() throws ActionExecutionException {
        ActivityObjectClipboardUtility.copyTransition(transition, clipboard);

        stateMachine.removeTransition(transition);
    }

    /**
     * <p>
     * Undo the cut action, it will add the transition node back into the activity graph.
     * </p>
     *
     * @throws CannotUndoException if canUndo returns false
     */
    public void undo() {
        super.undo();

        stateMachine.addTransition(transition);
    }
}
