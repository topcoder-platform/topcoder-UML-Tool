/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.statemachines.FinalState;

/**
 * <p>
 * RemoveFlowFinalNodeAction class extends RemoveStateNodeAbstractAction abstract
 * class, it is used to remove the FinalState node with a tag definition attached
 * (TagDefinition("FinalNodeType").value="FlowFinalNode").
 * </p>
 *
 * <p>
 * Thread-safety: this class is stateless, but as its base class is not thread-safe,
 * so it is not thread-safe too.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class RemoveFlowFinalNodeAction extends RemoveStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Flow Final Node";

    /**
     * <p>
     * Construct a RemoveFlowFinalNodeAction with the FinalState specified.
     * </p>
     *
     * <p>
     * Note, it should check its tagged value with a tag definition attached
     * (TagDefinition("FinalNodeType").value="FlowFinalNode").
     * </p>
     *
     * @param state the state node to remove from its activity graph it attached to.
     *
     * @throws IllegalArgumentException if the argument is null, or state argument's doesn't
     *  have the tag definition (TagDefinition("FinalNodeType").value="FlowFinalNode").
     */
    public RemoveFlowFinalNodeAction(FinalState state) {
        super(PRESENTATION_NAME, state);

        if (!Util.checkTagDefinition(state, "FinalNodeType", "FlowFinalNode")) {
            throw new IllegalArgumentException(
                "The state doesn't have the tag definition [FinalNodeType](The data value should be FlowFinalNode).");
        }
    }
}
