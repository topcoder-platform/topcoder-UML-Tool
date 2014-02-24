/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActionState;

/**
 * <p>
 * RemoveActionStateAction class extends RemoveStateNodeAbstractAction abstract class,
 * it is used to remove the ActionState node.
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
public class RemoveActionStateAction extends RemoveStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Action State";

    /**
     * <p>
     * Construct a RemoveActionStateAction with the ActionState specified.
     * </p>
     *
     * @param state the state node to remove from its activity graph it attached to.
     *
     * @throws IllegalArgumentException if the argument is null.
     */
    public RemoveActionStateAction(ActionState state) {
        super(PRESENTATION_NAME, state);
    }
}
