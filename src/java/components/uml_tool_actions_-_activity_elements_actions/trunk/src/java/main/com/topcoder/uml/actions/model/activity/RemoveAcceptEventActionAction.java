/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.statemachines.SimpleState;

/**
 * <p>
 * RemoveAcceptEventActionAction class extends RemoveStateNodeAbstractAction
 * abstract class, it is used to remove the SimpleState node with a tag
 * definition AcceptEventAction and the data value is True.
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
public class RemoveAcceptEventActionAction extends RemoveStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Accept Event Action";

    /**
     * <p>
     * Construct a RemoveAcceptEventActionAction with the SimpleState specified.
     * </p>
     *
     * @param state the state node to remove from its activity graph it attached to.
     *
     * @throws IllegalArgumentException if the argument is null, or state argument's
     * doesn't have the tag definition AcceptEventAction and the data value is True.
     */
    public RemoveAcceptEventActionAction(SimpleState state) {
        super(PRESENTATION_NAME, state);

        if (!Util.checkTagDefinition(state, "AcceptEventAction", "True")) {
            throw new IllegalArgumentException(
                "The state doesn't have the tag definition [AcceptEventAction](The data value should be True).");
        }
    }
}
