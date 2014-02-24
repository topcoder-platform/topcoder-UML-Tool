/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ObjectFlowState;

/**
 * <p>
 * RemoveObjectFlowStateAction class extends RemoveStateNodeAbstractAction abstract
 * class, it is used to remove the ObjectFlowState node.
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
public class RemoveObjectFlowStateAction extends RemoveStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Object Flow State";

    /**
     * <p>
     * Construct a RemoveObjectFlowStateAction with the ObjectFlowState specified.
     * </p>
     *
     * @param state the state node to remove from its activity graph it attached to.
     *
     * @throws IllegalArgumentException if the argument is null.
     */
    public RemoveObjectFlowStateAction(ObjectFlowState state) {
        super(PRESENTATION_NAME, state);
    }
}
