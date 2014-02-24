/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;

/**
 * <p>
 * AddObjectFlowStateAction class extends AddStateNodeAbstractAction abstract class,
 * and this action is specifically used to add ObjectFlowState node in activity graph.
 * </p>
 *
 * <p>
 * Thread-safety: this class is stateless, but as its base class
 * is not thread-safe, so it is not thread-safe too.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class AddObjectFlowStateAction extends AddStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Object Flow State";

    /**
     * <p>
     * Construct an AddObjectFlowStateAction with the ObjectFlowState,
     * activity graph and manager specified.
     * </p>
     *
     * @param state the state node to add into activity graph
     * @param activityGraph the ActivityGraph object to add the state node
     * @param manager the UMLModelManager object to apply initial formatting
     *
     * @throws IllegalArgumentException if any argument is null
     */
    public AddObjectFlowStateAction(ObjectFlowState state, ActivityGraph activityGraph, UMLModelManager manager) {
        super(PRESENTATION_NAME, state, activityGraph, manager);
    }
}
