/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.State;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;

/**
 * <p>
 * PasteStateNodeAbstractAction abstract class extends AbstractActivityUndoableAction
 * abstract class. This action add the StateVertex object retrieved from the clipboard
 * into the specified activity graph.
 * </p>
 *
 * <p>
 * It is appliation's responsibility to extract the connect from the Transferable
 * interface depending on the specific DataFlavor objects.
 * </P>
 *
 * <p>
 * Thread-safe: This class is immutable, but the internal states of its content
 * and activityGraph variables could be changed externally, so it is not
 * guaranteed to be thread-safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public abstract class PasteStateNodeAbstractAction extends AbstractActivityUndoableAction implements UndoableAction {
    /**
     * <p>
     * Represents the Transferable content provided by the application,
     * this abstract action can only accept object of StateVertex type.
     * Used in execute method to add into the given activity graph.
     * </p>
     *
     * <p>
     * Initialized in constructor, and its reference is never changed afterwards.
     * It must be non-null.
     * </p>
     */
    private final StateVertex content;

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
     * Construct the PasteStateNodeAbstractAction with the given
     * name, content and activity graph.
     * </p>
     *
     *
     * @param name the presentation name.
     * @param content the transferable content provided by the application
     * @param activityGraph the ActivityGraph object to add the content node
     *
     * @throws IllegalArgumentException if any argument is null, or the
     * content object is not of StateVertex type.
     */
    protected PasteStateNodeAbstractAction(String name, Object content, ActivityGraph activityGraph) {
        super(name);

        Util.checkNull(content, "content");
        Util.checkNull(activityGraph, "activityGraph");

        Util.checkClassType(content, StateVertex.class);

        this.content = (StateVertex) content;
        this.activityGraph = activityGraph;
    }

    /**
     * <p>
     * Add the state node into the ActivityGraph.
     * </p>
     *
     * @throws ActionExecutionException if any exception occurs.
     */
    public void execute() throws ActionExecutionException {
        CompositeState container = Util.getTop(activityGraph);
        container.addSubVertex(content);
        content.setContainer(container);

        // update the state machine for the content when it is of State type
        if (content instanceof State) {
            ((State) content).setStateMachine(activityGraph);
        }
    }

    /**
     * <p>
     * Undo the paste action, it will remove the state node from the activity graph.
     * </p>
     *
     * <p>
     * Note, all exceptions thrown except the CannotUndoException are logged.
     * </p>
     *
     * @throws CannotUndoException if canUndo returns false.
     */
    public void undo() {
        super.undo();

        try {
            Util.getTop(activityGraph).removeSubVertex(content);
        } catch (ActionExecutionException e) {
            super.logException("ActionExecutionException thrown in the undo method.", e);
        }
    }

}
