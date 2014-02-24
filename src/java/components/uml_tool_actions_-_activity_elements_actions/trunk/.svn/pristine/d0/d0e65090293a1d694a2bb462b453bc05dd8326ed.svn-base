/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * AddTransitionAction class implements the UndoableAction interface and
 * this action will simply add the Transition object into the ActivityGraph.
 * </p>
 *
 * <p>
 * This class will also pass the element to the ProjectConfigurationManager,
 * to apply any initial formatting.
 * </p>
 *
 * <p>
 * Thread-safety: this class is immutable, but the internal state of its
 * transition, activityGraph, and manager variables may be changed externally,
 * so it is not guaranteed to be thread-safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class AddTransitionAction extends AbstractActivityUndoableAction implements UndoableAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Transition";

    /**
     * <p>
     * Represents the Transition object to add into the activity graph in the execute method.
     * </p>
     *
     * <p>
     * Initialized in the constructor, and its reference is never changed afterwards, non-null.
     * </p>
     */
    private final Transition transition;

    /**
     * <p>
     * Represents the ActivityGraph object to add the transition object in the execute method.
     * </p>
     *
     * <p>
     * Initialized in the constructor, and its reference is never changed afterwards, non-null.
     * </p>
     */
    private final ActivityGraph activityGraph;

    /**
     * <p>
     * Represents the UMLModelManager object to apply initial formatting in the execute method.
     * </p>
     *
     * <p>
     * Initialized in the constructor, and its reference is never changed afterwards.
     * Must be non-null.
     * </p>
     */
    private final UMLModelManager manager;

    /**
     * <p>
     * Construct an AddTransitionAction with the transition,
     * activity graph and manager specified.
     * </p>
     *
     * <p>
     * Note, the constructor will also pass the element to the
     * ProjectConfigurationManager, to apply any initial formatting.
     * </p>
     *
     * @param transition the Transition object to add.
     * @param activityGraph the ActivityGraph object to add the transition node
     * @param manager the UMLModelManager object to apply initial formatting
     *
     * @throws IllegalArgumentException if any argument is null,
     * or language is empty string.
     */
    public AddTransitionAction(Transition transition, ActivityGraph activityGraph, UMLModelManager manager) {
        super(PRESENTATION_NAME);

        Util.checkNull(transition, "transition");
        Util.checkNull(activityGraph, "activityGraph");
        Util.checkNull(manager, "manager");

        this.transition = transition;
        this.activityGraph = activityGraph;
        this.manager = manager;

        Util.applyInitialFormatting(manager, transition);
    }

    /**
     * <p>
     * Add the transition object into the ActivityGraph.
     * </p>
     *
     * @throws ActionExecutionException if any exception occurs, note, this exception
     * is not thrown in current implementation
     */
    public void execute() throws ActionExecutionException {
        activityGraph.addTransition(transition);
        transition.setStateMachine(activityGraph);
    }

    /**
     * <p>
     * Undo the add action, it will remove the transition from the activity graph.
     * </p>
     *
     * @throws CannotUndoException if canUndo returns false
     */
    public void undo() {
        super.undo();

        activityGraph.removeTransition(transition);
    }
}
