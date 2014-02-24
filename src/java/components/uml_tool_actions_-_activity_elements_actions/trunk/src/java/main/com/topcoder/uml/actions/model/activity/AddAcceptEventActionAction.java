/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.statemachines.SimpleState;

/**
 * <p>
 * AddAcceptEventActionAction class extends AddStateNodeAbstractAction abstract
 * class, and this action is specifically used to add SimpleState with a tag
 * definition attached (TagDefinition("AcceptEventAction").value="True") in
 * activity graph.
 * </p>
 *
 * <p>
 * Thread Safety: this class is stateless, but as its base class is
 * not thread-safe, so it is not thread-safe too.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class AddAcceptEventActionAction extends AddStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Accept Event Action";

    /**
     * <p>
     * Construct a AddAcceptEventActionAction with the SimpleState,
     * activity graph and manager specified.
     * </p>
     *
     * <p>
     * Note, it checks its tagged value with a tag definition attached
     * (TagDefinition("AcceptEventAction").value="True").
     * </p>
     *
     * @param state the state node to add into activity graph
     * @param activityGraph the ActivityGraph object to add the state node
     * @param manager the UMLModelManager object to apply initial formatting
     *
     * @throws IllegalArgumentException if any argument is null, or state doesn't
     * have the tag definition (TagDefinition("AcceptEventAction").value="True")
     */
    public AddAcceptEventActionAction(SimpleState state, ActivityGraph activityGraph, UMLModelManager manager) {
        super(PRESENTATION_NAME, state, activityGraph, manager);

        if (!Util.checkTagDefinition(state, "AcceptEventAction", "True")) {
            throw new IllegalArgumentException(
                "The state doesn't have the tag definition [AcceptEventAction](The data value should be True).");
        }
    }
}
