/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;

/**
 * <p>
 * AddFlowFinalNodeAction class extends AddStateNodeAbstractAction abstract class,
 * and this action is specifically used to add FinalState node with a tag definition
 * attached (TagDefinition("FinalNodeType").value="FlowFinalNode") in activity graph.
 * </p>
 *
 * <p>
 * Thread-safety: this class is stateless, but as its base class is
 * not thread-safe, so it is not thread-safe too.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class AddFlowFinalNodeAction extends AddStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Flow Final Node";

    /**
     * <p>
     * Construct a AddFlowFinalNodeAction with the FinalState,
     * activity graph and manager specified.
     * </p>
     *
     * <p>
     * Note, it checks its tagged value with a tag definition attached
     * (TagDefinition("FinalNodeType").value="FlowFinalNode").
     * </p>
     *
     * @param state the state node to add into activity graph
     * @param activityGraph the ActivityGraph object to add the state node
     * @param manager the UMLModelManager object to apply initial formatting
     *
     * @throws IllegalArgumentException if any argument is null, or state doesn't
     * have the tag definition (TagDefinition("FinalNodeType").value="FlowFinalNode")
     */
    public AddFlowFinalNodeAction(FinalState state, ActivityGraph activityGraph, UMLModelManager manager) {
        super(PRESENTATION_NAME, state, activityGraph, manager);

        if (!Util.checkTagDefinition(state, "FinalNodeType", "FlowFinalNode")) {
            throw new IllegalArgumentException(
                "The state doesn't have the tag definition [FinalNodeType](The data value should be FlowFinalNode).");
        }
    }
}
