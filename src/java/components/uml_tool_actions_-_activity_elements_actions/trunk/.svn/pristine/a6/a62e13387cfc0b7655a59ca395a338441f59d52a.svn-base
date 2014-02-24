/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * PasteTransitionAction class implements UndoableAction interface.
 * This action add the Transition object retrieved from the clipboard
 * into the specified activity graph.
 * </p>
 *
 * <p>
 * It is appliation's responsibility to extract the content from the
 * Transferable interface depending on the specific DataFlavor objects.
 * </p>
 *
 * <p>
 * Thread-safe: This class is immutable, but the internal states of its
 * content and activityGraph variables could be changed externally,
 * so it is not guaranteed to be thread-safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class PasteTransitionAction extends AbstractActivityUndoableAction implements UndoableAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Paste Transition";

    /**
     * <p>
     * Represents the transferable content provided by the application,
     * this abstract action can only accept object of Transition type.
     * Used in execute method to add into the given activity graph.
     * </p>
     *
     * <p>
     * Initialized in constructor, and its reference is never changed afterwards.
     * It must be non-null.
     * </p>
     */
    private final Transition content;

    /**
     * <p>
     * Represents the ActivityGraph object to add the content node in the execute method.
     * </p>
     *
     * <p>
     * Initialized in constructor, and its reference is never changed afterwards.
     * It must be non-null.
     * </p>
     */
    private final ActivityGraph activityGraph;

    /**
     * <p>
     * Constructs the PasteTransitionAction with the given
     * content and activity graph.
     * </p>
     *
     * @param content the transferable content provided by the application
     * @param activityGraph the ActivityGraph object to add the content node
     *
     * @throws IllegalArgumentException if any argument is null, or the
     * content object is not of Transition type.
     */
    public PasteTransitionAction(Object content, ActivityGraph activityGraph) {
        super(PRESENTATION_NAME);

        Util.checkNull(content, "content");
        Util.checkNull(activityGraph, "activityGraph");

        Util.checkClassType(content, Transition.class);

        this.content = (Transition) content;
        this.activityGraph = activityGraph;
    }

    /**
     * <p>
     * Simply add the transition object into the ActivityGraph.
     * </p>
     *
     * @throws ActionExecutionException if any exception occurs.
     */
    public void execute() throws ActionExecutionException {
        activityGraph.addTransition(content);
        content.setStateMachine(activityGraph);
    }

    /**
     * <p>
     * Undo the cut action, it will add the transition node back into the activity graph.
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

        activityGraph.removeTransition(content);
    }
}
