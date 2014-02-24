/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.statemachines.SimpleState;

/**
 * <p>
 * RemoveSendSignalActionAction class extends RemoveStateNodeAbstractAction abstract
 * class, it is used to remove the SimpleState node with a tag definition attached
 * (TagDefinition("SendSignalAction").value="True").
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
public class RemoveSendSignalActionAction extends RemoveStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Send Signal Action";

    /**
     * <p>
     * Construct a RemoveSendSignalActionAction with the SimpleState specified.
     * </p>
     *
     * <p>
     * Note, it should check its tagged value with a tag definition attached
     * (TagDefinition("SendSignalAction").value="True").
     * </p>
     *
     * @param state the state node to remove from its activity graph it attached to.
     *
     * @throws IllegalArgumentException if the argument is null, or state argument doesn't have
     * the tag definition(TagDefinition("SendSignalAction").value="True").
     */
    public RemoveSendSignalActionAction(SimpleState state) {
        super(PRESENTATION_NAME, state);

        if (!Util.checkTagDefinition(state, "SendSignalAction", "True")) {
            throw new IllegalArgumentException(
                "The state doesn't have the tag definition [SendSignalAction](The data value should be True).");
        }
    }
}
