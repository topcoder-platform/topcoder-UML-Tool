/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.State;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;

/**
 * <p>
 * AddStateNodeAbstractAction abstract class extends AbstractActivityUndoableAction
 * abstract class and this action will simply add the StateVertex node into the ActivityGraph.
 * </p>
 *
 * <p>
 * It will also pass the element to the ProjectConfigurationManager (retrieved from UMLModelManager),
 * to apply any initial formatting. It is also the base class of all add actions for activity elements.
 * </p>
 *
 * <p>
 * Thread-safety: this class is immutable, but the internal state of its state,
 * activityGraph, and manager variables may be changed externally, so it is
 * not guaranteed to be thread-safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public abstract class AddStateNodeAbstractAction extends AbstractActivityUndoableAction implements UndoableAction {
    /**
     * <p>
     * Represents the StateVertext object to add into the ActivityGraph
     * object in the execute method.
     * </p>
     *
     * <p>
     * Initialized in the constructor, and its reference is never
     * changed afterwards, non-null.
     * </p>
     */
    private final StateVertex state;

    /**
     * <p>
     * Represents the ActivityGraph object to add the state node in the execute method.
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
     * Initialized in the constructor, and its reference is never changed afterwards. Must be non-null.
     * </p>
     */
    private final UMLModelManager manager;

    /**
     * <p>
     * Construct an AddStateNodeAbstractAction with the name, state,
     * activity graph and manager specified.
     * </p>
     *
     * <p>
     * Note, the constructor will also pass the element to the
     * ProjectConfigurationManager, to apply any initial formatting.
     * </p>
     *
     * @param name the presentation name.
     * @param state the StateVertex object to add to ActivityGraph
     * @param activityGraph the ActivityGraph object to add the state node
     * @param manager the UMLModelManager object to apply initial formatting
     *
     * @throws IllegalArgumentException if any argument is null,
     * or name is empty string, or fails to apply initial formatting
     */
    protected AddStateNodeAbstractAction(String name, StateVertex state, ActivityGraph activityGraph,
        UMLModelManager manager) {
        super(name);

        Util.checkNull(state, "state");
        Util.checkNull(activityGraph, "activityGraph");
        Util.checkNull(manager, "manager");

        this.state = state;
        this.activityGraph = activityGraph;
        this.manager = manager;

        Util.applyInitialFormatting(manager, state);
    }

    /**
     * <p>
     * Add the state node into the ActivityGraph.
     * </p>
     *
     * @throws ActionExecutionException if any exception occurs, e.g. the top attribute
     * for the activity graph is missing
     */
    public void execute() throws ActionExecutionException {
        CompositeState container = Util.getTop(activityGraph);
        container.addSubVertex(state);
        state.setContainer(container);

        // update the state machine for the state when it is of State type
        if (state instanceof State) {
            ((State) state).setStateMachine(activityGraph);
        }
    }

    /**
     * <p>
     * Undo the add action, it will remove the state node from the activity graph.
     * </p>
     *
     * <p>
     * Note, all exceptions thrown except the CannotUndoException are logged.
     * </p>
     *
     * @throws CannotUndoException if canUndo returns false
     */
    public void undo() {
        super.undo();

        try {
            Util.getTop(activityGraph).removeSubVertex(state);
        } catch (ActionExecutionException e) {
            super.logException("ActionExecutionException thrown in the undo method.", e);
        }
    }
}
